package cn.foggyhillside.dumplings_delight.common.loot.modifier;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import vectorwing.farmersdelight.common.mixin.accessor.LootContextAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * (code based on Farmer's Delight source, so I'll leave this in)
 * Credits to Commoble for this implementation!
 */
public class DumplingsDelightAddTableLootModifier extends LootModifier
{
	public static final Supplier<Codec<DumplingsDelightAddTableLootModifier>> CODEC = Suppliers.memoize(() ->
			RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst)
					.and(ResourceLocation.CODEC.fieldOf("lootTable").forGetter((m) -> m.lootTable))
					.apply(inst, DumplingsDelightAddTableLootModifier::new)));

	private final ResourceLocation lootTable;

	protected DumplingsDelightAddTableLootModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
		super(conditionsIn);
		this.lootTable = lootTable;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (DumplingsDelightConfig.GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT.get()) {
			LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
			// Use new context to avoid a StackOverflowError.
			LootContext newContext = new LootContext.Builder(((LootContextAccessor)context).getParams()).create(this.lootTable);
			extraTable.getRandomItemsRaw(newContext, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}

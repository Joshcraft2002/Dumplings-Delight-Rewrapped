package cn.foggyhillside.dumplings_delight.loot.modifier;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import vectorwing.farmersdelight.common.mixin.accessor.LootContextAccessor;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Supplier;

import static net.minecraft.world.level.storage.loot.LootTable.createStackSplitter;

/**
 * (code based on Farmer's Delight source, so I'll leave this in)
 * Credits to Commoble for this implementation!
 */
public class DumplingsDelightAddTableLootModifier extends LootModifier
{
	public static final Supplier<MapCodec<DumplingsDelightAddTableLootModifier>> CODEC = Suppliers.memoize(() ->
			RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
					.and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable").forGetter((m) -> m.lootTable))
					.apply(inst, DumplingsDelightAddTableLootModifier::new)));

	private final ResourceKey<LootTable> lootTable;

	protected DumplingsDelightAddTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable) {
		super(conditionsIn);
		this.lootTable = lootTable;
	}

	@NotNull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (DumplingsDelightConfig.GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT.get()) {
			// Refabricated: The game will loop if we don't make a new context.
			LootContext extraContext = new LootContext.Builder(((LootContextAccessor)context).getParams()).create(Optional.empty());
			extraContext.setQueriedLootTableId(this.lootTable.location());
			context.getResolver().get(Registries.LOOT_TABLE, this.lootTable).ifPresent((extraTable) -> {
				extraTable.value().getRandomItemsRaw(extraContext, createStackSplitter(context.getLevel(), generatedLoot::add));
			});
		}
		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC.get();
	}
}

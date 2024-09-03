package cn.foggyhillside.dumplings_delight.loot.modifier;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.AddTableLootModifier;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

import static net.minecraft.world.level.storage.loot.LootTable.createStackSplitter;

/**
 * (code based on Farmer's Delight source, so I'll leave this in)
 * Credits to Commoble for this implementation!
 */
public class DumplingsDelightAddTableLootModifier extends AddTableLootModifier
{
	public static final Supplier<MapCodec<DumplingsDelightAddTableLootModifier>> CODEC = Suppliers.memoize(() ->
			RecordCodecBuilder.mapCodec(inst -> codecStart(inst)
					.and(ResourceKey.codec(Registries.LOOT_TABLE).fieldOf("lootTable").forGetter((m) -> m.lootTable))
					.apply(inst, DumplingsDelightAddTableLootModifier::new)));

	private final ResourceKey<LootTable> lootTable;

	protected DumplingsDelightAddTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable) {
		super(conditionsIn, lootTable);
		this.lootTable = lootTable;
	}

	@Nonnull
	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		if (DumplingsDelightConfig.GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT.get()) {
			context.getResolver().get(Registries.LOOT_TABLE, this.lootTable).ifPresent((extraTable) -> {
				extraTable.value().getRandomItemsRaw(context, createStackSplitter(context.getLevel(), generatedLoot::add));
			});
		}
		return generatedLoot;
	}
}

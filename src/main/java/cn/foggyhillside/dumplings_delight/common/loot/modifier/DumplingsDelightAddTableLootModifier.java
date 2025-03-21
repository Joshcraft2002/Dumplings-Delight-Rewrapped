//package cn.foggyhillside.dumplings_delight.common.loot.modifier;
//
//import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
//import it.unimi.dsi.fastutil.objects.ObjectArrayList;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.storage.loot.LootContext;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
//import org.jetbrains.annotations.NotNull;
//import vectorwing.farmersdelight.refabricated.LootModifier;
//
///**
// * (code based on Farmer's Delight source, so I'll leave this in)
// * Credits to Commoble for this implementation!
// */
//public class DumplingsDelightAddTableLootModifier extends LootModifier
//{
//	private final ResourceKey<LootTable> lootTable;
//
//	protected DumplingsDelightAddTableLootModifier(LootItemCondition[] conditionsIn, ResourceKey<LootTable> lootTable) {
//		super(conditionsIn);
//		this.lootTable = lootTable;
//	}
//
//	@NotNull
//	@Override
//	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
//		if (DumplingsDelightConfig.GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT.get()) {
//			// Refabricated: The game will loop if we don't make a new context.
////			LootContext extraContext = new LootContext.Builder(((LootContextAccessor)context).getParams()).create(Optional.empty());
////			extraContext.setQueriedLootTableId(this.lootTable.location());
////			context.getResolver().get(Registries.LOOT_TABLE, this.lootTable).ifPresent((extraTable) -> {
////				extraTable.value().getRandomItemsRaw(extraContext, createStackSplitter(context.getLevel(), generatedLoot::add));
////			});
//		}
//		return generatedLoot;
//	}
//}

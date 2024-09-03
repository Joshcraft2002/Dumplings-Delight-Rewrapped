package cn.foggyhillside.dumplings_delight.event;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import cn.foggyhillside.dumplings_delight.registry.DumplingsDelightItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.BasicItemListing;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;
import net.neoforged.neoforge.event.village.WandererTradesEvent;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@EventBusSubscriber(modid = DumplingsDelight.MOD_ID)
@ParametersAreNonnullByDefault
public class VillagerEvents
{
	@SubscribeEvent
	public static void onVillagerTrades(VillagerTradesEvent event) {
		if (!DumplingsDelightConfig.FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS.get()) return;

		Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
		VillagerProfession profession = event.getType();
		ResourceLocation professionKey = BuiltInRegistries.VILLAGER_PROFESSION.getKey(profession);
		if (professionKey == null) return;
		if (professionKey.getPath().equals("farmer")) {
			trades.get(1).add(emeraldForItemsTrade(DumplingsDelightItems.GARLIC.get(), 26, 16, 2));
			trades.get(1).add(emeraldForItemsTrade(DumplingsDelightItems.GREENONION.get(), 26, 16, 2));
			trades.get(1).add(emeraldForItemsTrade(DumplingsDelightItems.EGGPLANT.get(), 26, 16, 2));
			trades.get(1).add(emeraldForItemsTrade(DumplingsDelightItems.FENNEL.get(), 20, 16, 2));
			trades.get(1).add(emeraldForItemsTrade(DumplingsDelightItems.GARLIC_CHIVE.get(), 20, 16, 2));
			trades.get(2).add(emeraldForItemsTrade(DumplingsDelightItems.CHINESE_CABBAGE.get(), 16, 16, 5));
		}
	}

	@SubscribeEvent
	public static void onWandererTrades(WandererTradesEvent event) {
		if (DumplingsDelightConfig.WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS.get()) {
			List<VillagerTrades.ItemListing> trades = event.getGenericTrades();
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(), 1, 12));
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.EGGPLANT_SEEDS.get(), 1, 12));
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.FENNEL_SEEDS.get(), 1, 12));
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.GARLIC.get(), 1, 12));
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get(), 1, 12));
			trades.add(itemForEmeraldTrade(DumplingsDelightItems.GREENONION.get(), 1, 12));
		}
	}

	public static BasicItemListing emeraldForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
		return new BasicItemListing(new ItemStack(item, count), new ItemStack(Items.EMERALD), maxTrades, xp, 0.05F);
	}

	public static BasicItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
		return new BasicItemListing(1, new ItemStack(item), maxTrades, xp, 0.05F);
	}
}

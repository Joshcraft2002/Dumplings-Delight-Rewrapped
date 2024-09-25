package cn.foggyhillside.dumplings_delight.event;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import cn.foggyhillside.dumplings_delight.registry.DumplingsDelightItems;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

public class VillagerEvents
{
	public static void init() {
		// As the config cannot be loaded on init, we must do this.
		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
			onVillagerTrades();
			onWandererTrades();
		});
	}

	public static void onVillagerTrades() {
		if (!DumplingsDelightConfig.FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS.get()) return;

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1, (trades) -> {
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.GARLIC.get(), 26, 16, 2));
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.GREENONION.get(), 26, 16, 2));
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.EGGPLANT.get(), 26, 16, 2));
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.FENNEL.get(), 20, 16, 2));
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.GARLIC_CHIVE.get(), 20, 16, 2));
		});

		TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 2, (trades) -> {
			trades.add(emeraldForItemsTrade(DumplingsDelightItems.CHINESE_CABBAGE.get(), 16, 16, 5));
		});
	}

	public static void onWandererTrades() {
		if (DumplingsDelightConfig.WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS.get()) {
			TradeOfferHelper.registerWanderingTraderOffers(0, (trades) -> {
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(), 1, 12));
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.EGGPLANT_SEEDS.get(), 1, 12));
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.FENNEL_SEEDS.get(), 1, 12));
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.GARLIC.get(), 1, 12));
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get(), 1, 12));
				trades.add(itemForEmeraldTrade(DumplingsDelightItems.GREENONION.get(), 1, 12));
			});
		}
	}

	public static VillagerTrades.ItemListing emeraldForItemsTrade(ItemLike item, int count, int maxTrades, int xp) {
		return new VillagerTrades.EmeraldForItems(item, count, maxTrades, xp);
	}

	public static VillagerTrades.ItemListing itemForEmeraldTrade(ItemLike item, int maxTrades, int xp) {
		return new VillagerTrades.ItemsForEmeralds(new ItemStack(item), 1, 1, maxTrades, xp, 0.05F);
	}
}

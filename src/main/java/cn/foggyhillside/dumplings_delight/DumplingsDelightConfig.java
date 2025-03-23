package cn.foggyhillside.dumplings_delight;

import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigBuilder;
import vectorwing.farmersdelight.refabricated.mlconfigs.ConfigType;
import vectorwing.farmersdelight.refabricated.mlconfigs.ModConfigHolder;

import java.util.function.Supplier;

public class DumplingsDelightConfig {
    public static ModConfigHolder COMMON_CONFIG;

    // COMMON
    public static final String CATEGORY_SETTINGS = "settings";
    public static Supplier<Boolean> FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS;
    public static Supplier<Boolean> WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS;

    public static final String CATEGORY_WORLD = "world";
    public static Supplier<Boolean> GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT;
    public static Supplier<Boolean> GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS;

    static {
        ConfigBuilder builder = ConfigBuilder.create(DumplingsDelight.MOD_ID, ConfigType.COMMON);

        builder.comment("Game settings").push(CATEGORY_SETTINGS);
        FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS = builder.comment("Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)")
                .define("farmersBuyDumplingsDelightCrops", true);
        WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS = builder.comment("Should the Wandering Trader sell crop seeds, garlic, green onions?")
                .define("wanderingTraderSellsDumplingsDelightItems", true);
        builder.pop();

        builder.comment("World generation").push(CATEGORY_WORLD);
        GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT = builder.comment("Should this mod add some of its items (crop seeds, garlic, green onions) as extra chest loot across Minecraft?")
                .define("generateDumplingsDelightChestLoot", true);
        GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS = builder.comment("Should Dumplings Delight crops show up planted randomly in various village farms?")
                .define("genDumplingsDelightCropsOnVillageFarms", true);
        builder.pop();

        COMMON_CONFIG = builder.build();
        COMMON_CONFIG.forceLoad();
    }

    public static void touch() {

    }
}

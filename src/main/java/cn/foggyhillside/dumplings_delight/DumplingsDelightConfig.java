package cn.foggyhillside.dumplings_delight;

import net.neoforged.neoforge.common.ModConfigSpec;

public class DumplingsDelightConfig {
    public static ModConfigSpec COMMON_CONFIG;

    // COMMON
    public static final String CATEGORY_SETTINGS = "settings";
    public static ModConfigSpec.BooleanValue FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS;
    public static ModConfigSpec.BooleanValue WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS;

    public static final String CATEGORY_WORLD = "world";
    public static ModConfigSpec.BooleanValue GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT;
    public static ModConfigSpec.BooleanValue GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        COMMON_BUILDER.comment("Game settings").push(CATEGORY_SETTINGS);
        FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS = COMMON_BUILDER.comment("Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)")
                .define("farmersBuyDumplingsDelightCrops", true);
        WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS = COMMON_BUILDER.comment("Should the Wandering Trader sell crop seeds, garlic, green onions?")
                .define("wanderingTraderSellsDumplingsDelightItems", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
        GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (crop seeds, garlic, green onions) as extra chest loot across Minecraft?")
                .define("generateDumplingsDelightChestLoot", true);
        GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS = COMMON_BUILDER.comment("Should Dumplings Delight crops show up planted randomly in various village farms?")
                .define("genDumplingsDelightCropsOnVillageFarms", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}

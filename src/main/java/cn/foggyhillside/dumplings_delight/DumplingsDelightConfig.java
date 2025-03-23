package cn.foggyhillside.dumplings_delight;

import io.github.fabricators_of_create.porting_lib.config.ModConfigSpec;

import java.util.function.Supplier;

@SuppressWarnings("all")
public class DumplingsDelightConfig {
    public static ModConfigSpec COMMON_CONFIG;

    // COMMON
    public static final String CATEGORY_SETTINGS = "settings";
    public static Supplier<Boolean> FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS;
    public static Supplier<Boolean>  WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS;
    public static Supplier<Boolean>  CALAMARI_DROPS_FROM_SQUID;

    public static final String CATEGORY_WORLD = "world";
    public static Supplier<Boolean>  GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT;
    public static Supplier<Boolean> GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        COMMON_BUILDER.comment("Game settings").push(CATEGORY_SETTINGS);
        FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS = COMMON_BUILDER.comment("Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)")
                .define("farmersBuyDumplingsDelightCrops", true);
        WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS = COMMON_BUILDER.comment("Should the Wandering Trader sell crop seeds, garlic, green onions?")
                .define("wanderingTraderSellsDumplingsDelightItems", true);
        CALAMARI_DROPS_FROM_SQUID = COMMON_BUILDER.comment("Should calamari drop from squids and glow squids?")
                .define("calamariDropsFromSquid", true);
        COMMON_BUILDER.pop();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);
        GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (crop seeds, garlic, green onions) as extra chest loot across Minecraft?")
                .define("generateDumplingsDelightChestLoot", true);
        GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS = COMMON_BUILDER.comment("Should FD crops show up planted randomly in various village farms?")
                .define("genDumplingsDelightCropsOnVillageFarms", true);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}

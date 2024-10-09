package cn.foggyhillside.dumplings_delight;

import net.neoforged.neoforge.common.ModConfigSpec;

public class DumplingsDelightConfig {
    public static ModConfigSpec COMMON_CONFIG;

    // COMMON
    public static ModConfigSpec.BooleanValue FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS;
    public static ModConfigSpec.BooleanValue WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS;
    public static ModConfigSpec.BooleanValue GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT;
    public static ModConfigSpec.BooleanValue CALAMARI_DROPS_FROM_SQUID;

    static {
        ModConfigSpec.Builder COMMON_BUILDER = new ModConfigSpec.Builder();

        FARMERS_BUY_DUMPLINGS_DELIGHT_CROPS = COMMON_BUILDER.comment("Should Novice and Apprentice Farmers buy this mod's crops? (May reduce chances of other trades appearing)")
                .define("farmersBuyDumplingsDelightCrops", true);
        WANDERING_TRADER_SELLS_DUMPLINGS_DELIGHT_ITEMS = COMMON_BUILDER.comment("Should the Wandering Trader sell crop seeds, garlic, green onions?")
                .define("wanderingTraderSellsDumplingsDelightItems", true);
        GENERATE_DUMPLINGS_DELIGHT_CHEST_LOOT = COMMON_BUILDER.comment("Should this mod add some of its items (crop seeds, garlic, green onions) as extra chest loot across Minecraft?")
                .define("generateDumplingsDelightChestLoot", true);
        CALAMARI_DROPS_FROM_SQUID = COMMON_BUILDER.comment("Should calamari drop from squids and glow squids?")
                .define("calamariDropsFromSquid", true);

        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}

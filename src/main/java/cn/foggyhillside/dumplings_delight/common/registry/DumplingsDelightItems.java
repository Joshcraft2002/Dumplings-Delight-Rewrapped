package cn.foggyhillside.dumplings_delight.common.registry;

import cn.foggyhillside.dumplings_delight.common.item.DumplingsDelightFoodValues;
import cn.foggyhillside.dumplings_delight.common.item.GarlicItem;
import com.google.common.collect.Sets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static cn.foggyhillside.dumplings_delight.refabricated.DumplingsDelightRegUtils.regItem;

public class DumplingsDelightItems {

    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static Supplier<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
        Supplier<Item> block = regItem(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    //Crate
    public static final Supplier<Item> CHINESE_CABBAGE_CRATE = registerWithTab("chinese_cabbage_crate",
            () -> new BlockItem(DumplingsDelightBlocks.CHINESE_CABBAGE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GARLIC_CRATE = registerWithTab("garlic_crate",
            () -> new BlockItem(DumplingsDelightBlocks.GARLIC_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GREENONION_CRATE = registerWithTab("greenonion_crate",
            () -> new BlockItem(DumplingsDelightBlocks.GREENONION_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> EGGPLANT_CRATE = registerWithTab("eggplant_crate",
            () -> new BlockItem(DumplingsDelightBlocks.EGGPLANT_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GARLIC_CHIVE_CRATE = registerWithTab("garlic_chive_crate",
            () -> new BlockItem(DumplingsDelightBlocks.GARLIC_CHIVE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> FENNEL_CRATE = registerWithTab("fennel_crate",
            () -> new BlockItem(DumplingsDelightBlocks.FENNEL_CRATE.get(), new Item.Properties()));

    //Feast
    public static final Supplier<Item> DUMPLING_MEDLEY = registerWithTab("dumpling_medley",
            () -> new BlockItem(DumplingsDelightBlocks.DUMPLING_MEDLEY.get(), new Item.Properties().stacksTo(1)));
    public static final Supplier<Item> VINEGAR = registerWithTab("vinegar",
            () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(1), true));
    public static final Supplier<Item> CALAMARI = registerWithTab("calamari",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.CALAMARI)));

    //Crops
    public static final Supplier<Item> CHINESE_CABBAGE = registerWithTab("chinese_cabbage",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.CHINESE_CABBAGE)));
    public static final Supplier<Item> CHINESE_CABBAGE_SEEDS = registerWithTab("chinese_cabbage_seeds",
            () -> new BlockItem(DumplingsDelightBlocks.CHINESE_CABBAGES.get(), new Item.Properties()));
    public static final Supplier<Item> CHINESE_CABBAGE_LEAF = registerWithTab("chinese_cabbage_leaf",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.CHINESE_CABBAGE_LEAF)));
    public static final Supplier<Item> GARLIC = registerWithTab("garlic",
            () -> new GarlicItem(DumplingsDelightBlocks.GARLIC.get(), new Item.Properties().food(DumplingsDelightFoodValues.GARLIC), true));
    public static final Supplier<Item> GARLIC_CLOVE = registerWithTab("garlic_clove",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.GARLIC_CLOVE), true));
    public static final Supplier<Item> GREENONION = registerWithTab("greenonion",
            () -> new BlockItem(DumplingsDelightBlocks.GREENONION.get(), new Item.Properties().food(DumplingsDelightFoodValues.GREENONION)));
    public static final Supplier<Item> EGGPLANT = registerWithTab("eggplant",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.EGGPLANT)));
    public static final Supplier<Item> EGGPLANT_SEEDS = registerWithTab("eggplant_seeds",
            () -> new BlockItem(DumplingsDelightBlocks.EGGPLANT.get(), new Item.Properties()));
    public static final Supplier<Item> GARLIC_CHIVE = registerWithTab("garlic_chive",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.GARLIC_CHIVE)));
    public static final Supplier<Item> GARLIC_CHIVE_SEEDS = registerWithTab("garlic_chive_seeds",
            () -> new BlockItem(DumplingsDelightBlocks.GARLIC_CHIVE.get(), new Item.Properties()));
    public static final Supplier<Item> FENNEL = registerWithTab("fennel",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.FENNEL)));
    public static final Supplier<Item> FENNEL_SEEDS = registerWithTab("fennel_seeds",
            () -> new BlockItem(DumplingsDelightBlocks.FENNEL.get(), new Item.Properties()));

    //Dumplings
    public static final Supplier<Item> PORK_CABBAGE_BOILED_DUMPLING = registerWithTab("pork_cabbage_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.PORK_CABBAGE_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_CELERY_BOILED_DUMPLING = registerWithTab("pork_celery_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.PORK_CELERY_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_KELP_BOILED_DUMPLING = registerWithTab("pork_kelp_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.PORK_KELP_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_POTATO_BOILED_DUMPLING = registerWithTab("pork_potato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.PORK_POTATO_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_FENNEL_BOILED_DUMPLING = registerWithTab("pork_fennel_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.PORK_FENNEL_BOILED_DUMPLING)));
    public static final Supplier<Item> TOMATO_EGG_BOILED_DUMPLING = registerWithTab("tomato_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.TOMATO_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> BEEF_TOMATO_BOILED_DUMPLING = registerWithTab("beef_tomato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.BEEF_TOMATO_BOILED_DUMPLING)));
    public static final Supplier<Item> MUTTON_BOILED_DUMPLING = registerWithTab("mutton_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.MUTTON_BOILED_DUMPLING)));
    public static final Supplier<Item> CHICKEN_MUSHROOM_BOILED_DUMPLING = registerWithTab("chicken_mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.CHICKEN_MUSHROOM_BOILED_DUMPLING)));
    public static final Supplier<Item> COD_BOILED_DUMPLING = registerWithTab("cod_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.COD_BOILED_DUMPLING)));
    public static final Supplier<Item> SALMON_BOILED_DUMPLING = registerWithTab("salmon_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.SALMON_BOILED_DUMPLING)));
    public static final Supplier<Item> EGGPLANT_EGG_BOILED_DUMPLING = registerWithTab("eggplant_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.EGGPLANT_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> MUSHROOM_BOILED_DUMPLING = registerWithTab("mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.MUSHROOM_BOILED_DUMPLING)));
    public static final Supplier<Item> FUNGUS_BOILED_DUMPLING = registerWithTab("fungus_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.FUNGUS_BOILED_DUMPLING)));
    public static final Supplier<Item> CALAMARI_BOILED_DUMPLING = registerWithTab("calamari_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.CALAMARI_BOILED_DUMPLING)));
    public static final Supplier<Item> GARLIC_CHIVE_EGG_BOILED_DUMPLING = registerWithTab("garlic_chive_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(DumplingsDelightFoodValues.GARLIC_CHIVE_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> DANDELION_LEAF_BOILED_DUMPLING = registerWithTab("dandelion_leaf_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.DANDELION_LEAF_BOILED_DUMPLING), true));
    public static final Supplier<Item> PUFFERFISH_BOILED_DUMPLING = registerWithTab("pufferfish_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.PUFFERFISH_BOILED_DUMPLING), true));
    public static final Supplier<Item> RABBIT_MEAT_BOILED_DUMPLING = registerWithTab("rabbit_meat_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.RABBIT_MEAT_BOILED_DUMPLING), true));

    //Wonton
    public static final Supplier<Item> PORK_CARROT_WONTON = registerWithTab("pork_carrot_wonton",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.PORK_CARROT_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> PORK_MUSHROOM_WONTON = registerWithTab("pork_mushroom_wonton",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.PORK_MUSHROOM_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> PORK_CABBAGE_WONTON = registerWithTab("pork_cabbage_wonton",
            () -> new ConsumableItem(new Item.Properties().food(DumplingsDelightFoodValues.PORK_CABBAGE_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));

    public static void touch() {

    }
}

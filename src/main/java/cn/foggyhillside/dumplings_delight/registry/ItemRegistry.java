package cn.foggyhillside.dumplings_delight.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.item.FoodList;
import com.google.common.collect.Sets;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DumplingsDelight.MOD_ID);
    public static LinkedHashSet<Supplier<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static Supplier<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
        Supplier<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    //Crate
    public static final Supplier<Item> ChineseCabbageCrate = registerWithTab("chinese_cabbage_crate",
            () -> new BlockItem(BlockRegistry.CHINESE_CABBAGE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GarlicCrate = registerWithTab("garlic_crate",
            () -> new BlockItem(BlockRegistry.GARLIC_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GreenOnionCrate = registerWithTab("greenonion_crate",
            () -> new BlockItem(BlockRegistry.GREEN_ONION.get(), new Item.Properties()));
    public static final Supplier<Item> EggplantCrate = registerWithTab("eggplant_crate",
            () -> new BlockItem(BlockRegistry.EGGPLANT_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> GarlicChiveCrate = registerWithTab("garlic_chive_crate",
            () -> new BlockItem(BlockRegistry.GARLIC_CHIVE_CRATE.get(), new Item.Properties()));
    public static final Supplier<Item> FennelCrate = registerWithTab("fennel_crate",
            () -> new BlockItem(BlockRegistry.FENNEL_CRATE.get(), new Item.Properties()));

    //Feast
    public static final Supplier<Item> VINEGAR = registerWithTab("vinegar",
            () -> new ConsumableItem(new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(1), true));
    public static final Supplier<Item> CALAMARI = registerWithTab("calamari",
            () -> new Item(new Item.Properties().food(FoodList.CALAMARI)));

    //Crops
    public static final Supplier<Item> CHINESE_CABBAGE = registerWithTab("chinese_cabbage",
            () -> new Item(new Item.Properties().food(FoodList.CHINESE_CABBAGE)));
    public static final Supplier<Item> CHINESE_CABBAGE_SEEDS = registerWithTab("chinese_cabbage_seeds",
            () -> new BlockItem(BlockRegistry.CHINESE_CABBAGES.get(), new Item.Properties()));
    public static final Supplier<Item> CHINESE_CABBAGE_LEAF = registerWithTab("chinese_cabbage_leaf",
            () -> new Item(new Item.Properties().food(FoodList.CHINESE_CABBAGE_LEAF)));
    public static final Supplier<Item> GARLIC_CLOVE = registerWithTab("garlic_clove",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.GARLIC_CLOVE), true));
    public static final Supplier<Item> GREEN_ONION = registerWithTab("greenonion",
            () -> new BlockItem(BlockRegistry.GREEN_ONION.get(), new Item.Properties().food(FoodList.GREEN_ONION)));
    public static final Supplier<Item> EGGPLANT = registerWithTab("eggplant",
            () -> new Item(new Item.Properties().food(FoodList.EGGPLANT)));
    public static final Supplier<Item> EGGPLANT_SEEDS = registerWithTab("eggplant_seeds",
            () -> new BlockItem(BlockRegistry.EGGPLANT.get(), new Item.Properties()));
    public static final Supplier<Item> GARLIC_CHIVE = registerWithTab("garlic_chive",
            () -> new Item(new Item.Properties().food(FoodList.GARLIC_CHIVE)));
    public static final Supplier<Item> GARLIC_CHIVE_SEEDS = registerWithTab("garlic_chive_seeds",
            () -> new BlockItem(BlockRegistry.GARLIC_CHIVE.get(), new Item.Properties()));
    public static final Supplier<Item> FENNEL = registerWithTab("fennel",
            () -> new Item(new Item.Properties().food(FoodList.FENNEL)));
    public static final Supplier<Item> FENNEL_SEEDS = registerWithTab("fennel_seeds",
            () -> new BlockItem(BlockRegistry.FENNEL.get(), new Item.Properties()));

    //Dumplings
    public static final Supplier<Item> PORK_CABBAGE_BOILED_DUMPLING = registerWithTab("pork_cabbage_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PORK_CABBAGE_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_CELERY_BOILED_DUMPLING = registerWithTab("pork_celery_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PORK_CELERY_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_KELP_BOILED_DUMPLING = registerWithTab("pork_kelp_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PORK_KELP_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_POTATO_BOILED_DUMPLING = registerWithTab("pork_potato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PORK_POTATO_BOILED_DUMPLING)));
    public static final Supplier<Item> PORK_FENNEL_BOILED_DUMPLING = registerWithTab("pork_fennel_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.PORK_FENNEL_BOILED_DUMPLING)));
    public static final Supplier<Item> TOMATO_EGG_BOILED_DUMPLING = registerWithTab("tomato_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.TOMATO_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> BEEF_TOMATO_BOILED_DUMPLING = registerWithTab("beef_tomato_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.BEEF_TOMATO_BOILED_DUMPLING)));
    public static final Supplier<Item> MUTTON_BOILED_DUMPLING = registerWithTab("mutton_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.MUTTON_BOILED_DUMPLING)));
    public static final Supplier<Item> CHICKEN_MUSHROOM_BOILED_DUMPLING = registerWithTab("chicken_mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.CHICKEN_MUSHROOM_BOILED_DUMPLING)));
    public static final Supplier<Item> COD_BOILED_DUMPLING = registerWithTab("cod_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.COD_BOILED_DUMPLING)));
    public static final Supplier<Item> SALMON_BOILED_DUMPLING = registerWithTab("salmon_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.SALMON_BOILED_DUMPLING)));
    public static final Supplier<Item> EGGPLANT_EGG_BOILED_DUMPLING = registerWithTab("eggplant_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.EGGPLANT_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> MUSHROOM_BOILED_DUMPLING = registerWithTab("mushroom_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.MUSHROOM_BOILED_DUMPLING)));
    public static final Supplier<Item> FUNGUS_BOILED_DUMPLING = registerWithTab("fungus_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.FUNGUS_BOILED_DUMPLING)));
    public static final Supplier<Item> CALAMARI_BOILED_DUMPLING = registerWithTab("calamari_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.CALAMARI_BOILED_DUMPLING)));
    public static final Supplier<Item> GARLIC_CHIVE_EGG_BOILED_DUMPLING = registerWithTab("garlic_chive_egg_boiled_dumpling",
            () -> new Item(new Item.Properties().food(FoodList.GARLIC_CHIVE_EGG_BOILED_DUMPLING)));
    public static final Supplier<Item> DANDELION_LEAF_BOILED_DUMPLING = registerWithTab("dandelion_leaf_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.DANDELION_LEAF_BOILED_DUMPLING), true));
    public static final Supplier<Item> PUFFERFISH_BOILED_DUMPLING = registerWithTab("pufferfish_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.PUFFERFISH_BOILED_DUMPLING), true));
    public static final Supplier<Item> RABBIT_MEAT_BOILED_DUMPLING = registerWithTab("rabbit_meat_boiled_dumpling",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.RABBIT_MEAT_BOILED_DUMPLING), true));

    //Wonton
    public static final Supplier<Item> PORK_CARROT_WONTON = registerWithTab("pork_carrot_wonton",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.PORK_CARROT_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> PORK_MUSHROOM_WONTON = registerWithTab("pork_mushroom_wonton",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.PORK_MUSHROOM_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));
    public static final Supplier<Item> PORK_CABBAGE_WONTON = registerWithTab("pork_cabbage_wonton",
            () -> new ConsumableItem(new Item.Properties().food(FoodList.PORK_CABBAGE_WONTON).craftRemainder(Items.BOWL).stacksTo(16), true));
}

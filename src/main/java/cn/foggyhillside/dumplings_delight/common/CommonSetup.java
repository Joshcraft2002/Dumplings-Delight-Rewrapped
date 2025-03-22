package cn.foggyhillside.dumplings_delight.common;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightItems;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.ComposterBlock;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

public class CommonSetup {
    public static void init() {
        registerCompostables();
        registerItemSetAdditions();
    }

    public static void registerCompostables() {
        // 15% chance
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GARLIC_CLOVE.get(), 0.15F);

        // 30% chance
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.EGGPLANT_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.FENNEL_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get(), 0.3F);

        // 50% chance
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.CHINESE_CABBAGE_LEAF.get(), 0.5F);

        // 65% chance
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.CHINESE_CABBAGE.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.EGGPLANT.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.FENNEL.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GARLIC.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GARLIC_CHIVE.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GREENONION.get(), 0.65F);

        // 100% chance
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.BEEF_TOMATO_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.CALAMARI_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.CHICKEN_MUSHROOM_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.COD_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.DANDELION_LEAF_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.EGGPLANT_EGG_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.FUNGUS_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.GARLIC_CHIVE_EGG_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.MUSHROOM_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.MUTTON_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PORK_CABBAGE_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PORK_CELERY_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PORK_KELP_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PORK_POTATO_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PORK_FENNEL_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.PUFFERFISH_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.RABBIT_MEAT_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.SALMON_BOILED_DUMPLING.get(), 1.0F);
        ComposterBlock.COMPOSTABLES.put(DumplingsDelightItems.TOMATO_EGG_BOILED_DUMPLING.get(), 1.0F);
    }

    public static void registerItemSetAdditions() {
        Ingredient newChickenFood = Ingredient.of(DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(), DumplingsDelightItems.EGGPLANT_SEEDS.get(), DumplingsDelightItems.FENNEL_SEEDS.get(), DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get());
        Chicken.FOOD_ITEMS = Ingredient.of(Stream.concat(Arrays.stream(Chicken.FOOD_ITEMS.getItems()), Arrays.stream(newChickenFood.getItems())));

        Ingredient newPigFood = Ingredient.of(DumplingsDelightItems.CHINESE_CABBAGE.get(), DumplingsDelightItems.EGGPLANT.get());
        Pig.FOOD_ITEMS = Ingredient.of(Stream.concat(Arrays.stream(Pig.FOOD_ITEMS.getItems()), Arrays.stream(newPigFood.getItems())));

        Collections.addAll(Parrot.TAME_FOOD, DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(), DumplingsDelightItems.EGGPLANT_SEEDS.get(), DumplingsDelightItems.FENNEL_SEEDS.get(), DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get());

        Set<Item> newWantedItems = Sets.newHashSet(
                DumplingsDelightItems.CHINESE_CABBAGE.get(),
                DumplingsDelightItems.GARLIC.get(),
                DumplingsDelightItems.GREENONION.get(),
                DumplingsDelightItems.EGGPLANT.get(),
                DumplingsDelightItems.GARLIC_CHIVE.get(),
                DumplingsDelightItems.FENNEL.get(),
                DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(),
                DumplingsDelightItems.EGGPLANT_SEEDS.get(),
                DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get(),
                DumplingsDelightItems.FENNEL_SEEDS.get());
        newWantedItems.addAll(Villager.WANTED_ITEMS);
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(newWantedItems);
    }
}

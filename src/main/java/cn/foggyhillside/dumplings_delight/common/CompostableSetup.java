package cn.foggyhillside.dumplings_delight.common;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightItems;
import net.minecraft.world.level.block.ComposterBlock;

public class CompostableSetup {
    public static void init() {
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
}

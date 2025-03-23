package cn.foggyhillside.dumplings_delight.common.world;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightBlocks;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

import java.util.ArrayList;
import java.util.List;

public class VillageStructures
{
    public static void init(){
        ServerLifecycleEvents.SERVER_STARTED.register(VillageStructures::addNewVillageBuilding);
    }

    public static void addNewVillageBuilding(MinecraftServer server) {
        if (DumplingsDelightConfig.GENERATE_VILLAGE_FARM_DUMPLINGS_DELIGHT_CROPS.get()) {
            Registry<StructureProcessorList> processorLists = server.registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

            StructureProcessor temperateCropProcessor = new RuleProcessor(List.of(
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.GREENONION.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.GARLIC.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.GARLIC_CHIVE.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.EGGPLANT.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.FENNEL.get().defaultBlockState())
            ));

            StructureProcessor coldCropProcessor = new RuleProcessor(List.of(
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.CHINESE_CABBAGES.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.POTATOES, 0.1F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.CHINESE_CABBAGES.get().defaultBlockState())
            ));

            StructureProcessor aridCropProcessor = new RuleProcessor(List.of(
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.EGGPLANT.get().defaultBlockState()),
                    new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.15F), AlwaysTrueTest.INSTANCE, DumplingsDelightBlocks.CHINESE_CABBAGES.get().defaultBlockState())
            ));

            addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_plains"), temperateCropProcessor, processorLists);
            addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_savanna"), aridCropProcessor, processorLists);
            addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_snowy"), coldCropProcessor, processorLists);
            addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_taiga"), temperateCropProcessor, processorLists);
            addNewRuleToProcessorList(new ResourceLocation("minecraft:farm_desert"), aridCropProcessor, processorLists);
        }
    }

    private static void addNewRuleToProcessorList(ResourceLocation targetProcessorList, StructureProcessor processorToAdd, Registry<StructureProcessorList> processorListRegistry) {
        processorListRegistry.getOptional(targetProcessorList)
                .ifPresent(processorList -> {
                    // The list of processor is an immutable list.
                    // So we will create a new list, add to it, and set the field to that new list.
                    List<StructureProcessor> newSafeList = new ArrayList<>(processorList.list());
                    newSafeList.add(processorToAdd);
                    processorList.list = newSafeList; // Use an Access Transformer or Accessor Mixin to set the private list field.
                });
    }
}

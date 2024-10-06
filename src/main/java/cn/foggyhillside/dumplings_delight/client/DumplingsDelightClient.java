package cn.foggyhillside.dumplings_delight.client;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.renderer.RenderType;

public class DumplingsDelightClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(),
                DumplingsDelightBlocks.CHINESE_CABBAGES.get(),
                DumplingsDelightBlocks.EGGPLANT.get(),
                DumplingsDelightBlocks.FENNEL.get(),
                DumplingsDelightBlocks.GARLIC.get(),
                DumplingsDelightBlocks.GARLIC_CHIVE.get(),
                DumplingsDelightBlocks.GREENONION.get());
    }
}

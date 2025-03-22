package cn.foggyhillside.dumplings_delight;

import cn.foggyhillside.dumplings_delight.common.CommonSetup;
import cn.foggyhillside.dumplings_delight.common.event.*;
import cn.foggyhillside.dumplings_delight.common.registry.*;
import cn.foggyhillside.dumplings_delight.refabricated.DumplingsDelightLootModificationEvents;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class DumplingsDelight implements ModInitializer
{
    public static final String MOD_ID = "dumplings_delight";

    public static ResourceLocation res(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        DumplingsDelightConfig.touch();

        DumplingsDelightBlocks.touch();
        DumplingsDelightCreativeTabs.touch();
        DumplingsDelightEffects.touch();
        DumplingsDelightItems.touch();

        VillagerEvents.init();

        CommonSetup.registerItemSetAdditions();

        DumplingsDelightLootModificationEvents.init();

        CompostableHelper.init();
    }

}

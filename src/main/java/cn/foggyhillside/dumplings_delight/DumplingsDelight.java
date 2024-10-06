package cn.foggyhillside.dumplings_delight;

import cn.foggyhillside.dumplings_delight.event.*;
import cn.foggyhillside.dumplings_delight.registry.*;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry;
import io.github.fabricators_of_create.porting_lib.config.ConfigType;
import io.github.fabricators_of_create.porting_lib.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class DumplingsDelight implements ModInitializer
{
    public static final String MOD_ID = "dumplings_delight";

    public static ResourceLocation res(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    @Override
    public void onInitialize() {
        ConfigRegistry.registerConfig(MOD_ID, ConfigType.COMMON, DumplingsDelightConfig.COMMON_CONFIG);

        DumplingsDelightBlocks.BLOCKS.register();
        DumplingsDelightCreativeTabs.CREATIVE_MODE_TABS.register();
        DumplingsDelightEffects.init();
        DumplingsDelightItems.ITEMS.register();
        DumplingsDelightLootModifiers.LOOT_MODIFIERS.register();

        CommonEvents.init();
        VillagerEvents.init();

        CompostableHelper.init();
    }

}

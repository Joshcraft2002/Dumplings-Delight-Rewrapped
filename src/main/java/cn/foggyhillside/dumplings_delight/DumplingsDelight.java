package cn.foggyhillside.dumplings_delight;

import cn.foggyhillside.dumplings_delight.event.*;
import cn.foggyhillside.dumplings_delight.registry.*;
import io.github.fabricators_of_create.porting_lib.config.ConfigRegistry;
import io.github.fabricators_of_create.porting_lib.config.ModConfig;
import net.fabricmc.api.ModInitializer;

public class DumplingsDelight implements ModInitializer
{
    public static final String MOD_ID = "dumplings_delight";

    @Override
    public void onInitialize() {
        ConfigRegistry.registerConfig(MOD_ID, ModConfig.Type.COMMON, DumplingsDelightConfig.COMMON_CONFIG);

        DumplingsDelightBlocks.BLOCKS.register();
        DumplingsDelightCreativeTabs.CREATIVE_MODE_TABS.register();
        DumplingsDelightEffects.EFFECTS.register();
        DumplingsDelightItems.ITEMS.register();
        DumplingsDelightLootModifiers.LOOT_MODIFIERS.register();

        VillagerEvents.init();
    }

}

package cn.foggyhillside.dumplings_delight;

import cn.foggyhillside.dumplings_delight.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(DumplingsDelight.MOD_ID)
public class DumplingsDelight
{
    public static final String MOD_ID = "dumplings_delight";

    public DumplingsDelight(IEventBus modEventBus, ModContainer modContainer)
    {
        modContainer.registerConfig(ModConfig.Type.COMMON, DumplingsDelightConfig.COMMON_CONFIG);

        DumplingsDelightItems.ITEMS.register(modEventBus);
        DumplingsDelightBlocks.BLOCKS.register(modEventBus);
        DumplingsDelightEffects.EFFECTS.register(modEventBus);
        DumplingsDelightCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        DumplingsDelightLootModifiers.LOOT_MODIFIERS.register(modEventBus);
    }

}

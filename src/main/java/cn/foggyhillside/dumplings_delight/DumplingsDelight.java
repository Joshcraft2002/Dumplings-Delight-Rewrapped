package cn.foggyhillside.dumplings_delight;

import cn.foggyhillside.dumplings_delight.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(DumplingsDelight.MOD_ID)
public class DumplingsDelight
{
    public static final String MOD_ID = "dumplings_delight";

    public DumplingsDelight(IEventBus modEventBus)
    {
        ItemRegistry.ITEMS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        EffectRegistry.EFFECTS.register(modEventBus);
        CreativeTabRegistry.CREATIVE_MODE_TABS.register(modEventBus);
        LootModifierRegistry.LOOT_MODIFIERS.register(modEventBus);
    }

}

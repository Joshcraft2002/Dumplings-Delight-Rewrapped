package cn.foggyhillside.dumplings_delight.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.effect.GarlicPotionEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

public class DumplingsDelightEffects {
    public static final Holder<MobEffect> GARLIC = Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, DumplingsDelight.res("garlic"), new GarlicPotionEffect());

    public static void register() {
    }
}

package cn.foggyhillside.dumplings_delight.registry;


import cn.foggyhillside.dumplings_delight.effect.GarlicPotionEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.neoforged.neoforge.registries.DeferredRegister;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;

public class EffectRegistry {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, DumplingsDelight.MOD_ID);

    public static final Holder<MobEffect> GARLIC = EFFECTS.register("garlic", GarlicPotionEffect::new);
}

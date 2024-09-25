package cn.foggyhillside.dumplings_delight.registry;


import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.effect.GarlicPotionEffect;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;

public class DumplingsDelightEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, DumplingsDelight.MOD_ID);

    public static final Holder<MobEffect> GARLIC = EFFECTS.register("garlic", GarlicPotionEffect::new);
}

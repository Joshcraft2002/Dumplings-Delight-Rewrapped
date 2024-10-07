package cn.foggyhillside.dumplings_delight.common.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.common.effect.GarlicPotionEffect;
import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DumplingsDelightEffects {
    static final List<Supplier<?>> EFFECTS = new ArrayList<>();

    @NotNull
    private static <T extends MobEffect> Supplier<T> register(String id, Supplier<T> supplier) {
        var v = Suppliers.memoize(() ->
                Registry.register(BuiltInRegistries.MOB_EFFECT, DumplingsDelight.res(id), supplier.get()));
        EFFECTS.add(v);
        return v;
    }

    public static void init() {
        EFFECTS.forEach(Supplier::get);
        EFFECTS.clear();
    }

    public static final Supplier<MobEffect> GARLIC = register("garlic", GarlicPotionEffect::new);
}

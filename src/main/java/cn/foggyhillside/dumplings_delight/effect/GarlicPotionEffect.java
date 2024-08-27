package cn.foggyhillside.dumplings_delight.effect;

import cn.foggyhillside.dumplings_delight.registry.EffectRegistry;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;

import java.util.Collection;

import static cn.foggyhillside.dumplings_delight.tag.ModTags.DUMPLING;

public class GarlicPotionEffect extends MobEffect {
    public GarlicPotionEffect() {
        super(MobEffectCategory.BENEFICIAL, 14545909);
    }

    public static class OnFinishEat {
        @EventBusSubscriber(modid = DumplingsDelight.MOD_ID)
        private static class GlobalTrigger {
            @SubscribeEvent
            public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
                if (event == null) return;

                Entity entity = event.getEntity();
                ItemStack itemStack = event.getItem();

                if (!itemStack.is(DUMPLING) || entity == null)
                {
                    return;
                }

                if (entity instanceof Player) {
                    Collection<MobEffectInstance> effects = ((Player) entity).getActiveEffects();
                    for (MobEffectInstance effect : effects) {
                        if (effect.getEffect() == EffectRegistry.GARLIC)
                        {
                            ((Player) entity).getFoodData().setFoodLevel((int) (((Player) entity).getFoodData().getFoodLevel() + 1));
                        }

                    }

                }
            }
        }
    }
}

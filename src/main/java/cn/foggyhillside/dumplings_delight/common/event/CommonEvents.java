package cn.foggyhillside.dumplings_delight.common.event;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightEffects;
import cn.foggyhillside.dumplings_delight.common.tag.DumplingsDelightTags;
import io.github.fabricators_of_create.porting_lib.entity.events.LivingEntityUseItemEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class CommonEvents {
    public static void init() {
        LivingEntityUseItemEvents.LIVING_USE_ITEM_FINISH.register(CommonEvents::handleGarlicEffect);
    }

    private static ItemStack handleGarlicEffect(LivingEntity entity, ItemStack itemStack, int i, ItemStack result) {
        if (!(entity instanceof Player)) return result;

        if (itemStack.is(DumplingsDelightTags.DUMPLING) && entity.hasEffect(DumplingsDelightEffects.GARLIC.get())) {
            ((Player) entity).getFoodData().setFoodLevel((((Player) entity).getFoodData().getFoodLevel() + 1));
        }
        return result;
    }
}

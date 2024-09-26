package cn.foggyhillside.dumplings_delight.event;

import cn.foggyhillside.dumplings_delight.registry.DumplingsDelightEffects;
import io.github.fabricators_of_create.porting_lib.entity.events.living.LivingEntityUseItemEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import static cn.foggyhillside.dumplings_delight.tag.DumplingsDelightTags.DUMPLING;

public class CommonEvents {
    public static void init() {
        LivingEntityUseItemEvent.Finish.EVENT.register(CommonEvents::handleGarlicEffect);
    }

    public static void handleGarlicEffect(LivingEntityUseItemEvent.Finish event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof Player)) return;

        ItemStack itemStack = event.getItem();
        if (itemStack.is(DUMPLING) && ((Player) entity).hasEffect(DumplingsDelightEffects.GARLIC)) {
            ((Player) entity).getFoodData().setFoodLevel((((Player) entity).getFoodData().getFoodLevel() + 1));
        }
    }
}

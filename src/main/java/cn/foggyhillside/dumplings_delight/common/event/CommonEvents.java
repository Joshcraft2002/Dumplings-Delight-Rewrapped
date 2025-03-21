package cn.foggyhillside.dumplings_delight.common.event;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightEffects;
import cn.foggyhillside.dumplings_delight.common.tag.DumplingsDelightTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CommonEvents {

    public static void onItemUseFinished(Level level, LivingEntity livingEntity, ItemStack stack) {
        handleGarlicEffect(livingEntity, stack);
    }

    public static void handleGarlicEffect(LivingEntity livingEntity, ItemStack stack) {
        if (!(livingEntity instanceof Player)) return;

        if (stack.is(DumplingsDelightTags.DUMPLING) && livingEntity.hasEffect(DumplingsDelightEffects.GARLIC)) {
            ((Player) livingEntity).getFoodData().setFoodLevel((((Player) livingEntity).getFoodData().getFoodLevel() + 1));
        }
    }
}

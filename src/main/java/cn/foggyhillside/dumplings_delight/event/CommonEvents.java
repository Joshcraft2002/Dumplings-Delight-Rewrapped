package cn.foggyhillside.dumplings_delight.event;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.registry.DumplingsDelightEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

import static cn.foggyhillside.dumplings_delight.tag.DumplingsDelightTags.DUMPLING;

@EventBusSubscriber(modid = DumplingsDelight.MOD_ID)
public class CommonEvents
{
	@SubscribeEvent
	public static void handleGarlicEffect(LivingEntityUseItemEvent.Finish event) {
		Entity entity = event.getEntity();
		if (!(entity instanceof Player)) return;

		ItemStack itemStack = event.getItem();
		if (itemStack.is(DUMPLING) && ((Player) entity).hasEffect(DumplingsDelightEffects.GARLIC)) {
			((Player) entity).getFoodData().setFoodLevel((((Player) entity).getFoodData().getFoodLevel() + 1));
		}
	}
}

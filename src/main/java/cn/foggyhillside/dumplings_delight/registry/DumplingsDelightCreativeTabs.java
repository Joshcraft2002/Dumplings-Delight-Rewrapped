package cn.foggyhillside.dumplings_delight.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DumplingsDelightCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DumplingsDelight.MOD_ID);

    public static final Supplier<CreativeModeTab> TAB_DUMPLINGS_DELIGHT = CREATIVE_MODE_TABS.register(DumplingsDelight.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.dumplings_delight"))
                    .icon(() -> new ItemStack(DumplingsDelightItems.PORK_CABBAGE_BOILED_DUMPLING.get()))
                    .displayItems(((parameters, output) -> DumplingsDelightItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get()))))
                    .build());
}

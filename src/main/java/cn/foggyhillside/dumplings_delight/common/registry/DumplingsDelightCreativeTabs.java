package cn.foggyhillside.dumplings_delight.common.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

import static cn.foggyhillside.dumplings_delight.refabricated.DumplingsDelightRegUtils.regTab;

public class DumplingsDelightCreativeTabs {
    public static final Supplier<CreativeModeTab> TAB_DUMPLINGS_DELIGHT = regTab(DumplingsDelight.MOD_ID,
            () -> FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.dumplings_delight"))
                    .icon(() -> new ItemStack(DumplingsDelightItems.PORK_CABBAGE_BOILED_DUMPLING.get()))
                    .displayItems(((parameters, output) -> DumplingsDelightItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get()))))
                    .build());

    public static void touch() {

    }
}

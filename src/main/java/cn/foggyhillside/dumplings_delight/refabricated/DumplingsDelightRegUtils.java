package cn.foggyhillside.dumplings_delight.refabricated;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class DumplingsDelightRegUtils {
    public static <R, T extends R> Supplier<T> register(String name, Supplier<T> supplier, Registry<R> reg) {
        T object = supplier.get();
        Registry.register(reg, DumplingsDelight.res(name), object);
        return () -> object;
    }

    public static <B extends CreativeModeTab> Supplier<B> regTab(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.CREATIVE_MODE_TAB);
    }

    public static <B extends Item> Supplier<B> regItem(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.ITEM);
    }

    public static <B extends Block> Supplier<B> regBlock(String name, Supplier<B> supplier) {
        return register(name, supplier, BuiltInRegistries.BLOCK);
    }
}

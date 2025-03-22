package cn.foggyhillside.dumplings_delight.common;

import cn.foggyhillside.dumplings_delight.common.registry.DumplingsDelightItems;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;

import java.util.Set;

public class CommonSetup {
    public static void registerItemSetAdditions() {
        Set<Item> newWantedItems = Sets.newHashSet(
                DumplingsDelightItems.CHINESE_CABBAGE.get(),
                DumplingsDelightItems.GARLIC.get(),
                DumplingsDelightItems.GREENONION.get(),
                DumplingsDelightItems.EGGPLANT.get(),
                DumplingsDelightItems.GARLIC_CHIVE.get(),
                DumplingsDelightItems.FENNEL.get(),
                DumplingsDelightItems.CHINESE_CABBAGE_SEEDS.get(),
                DumplingsDelightItems.EGGPLANT_SEEDS.get(),
                DumplingsDelightItems.GARLIC_CHIVE_SEEDS.get(),
                DumplingsDelightItems.FENNEL_SEEDS.get());
        newWantedItems.addAll(Villager.WANTED_ITEMS);
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(newWantedItems);
    }
}

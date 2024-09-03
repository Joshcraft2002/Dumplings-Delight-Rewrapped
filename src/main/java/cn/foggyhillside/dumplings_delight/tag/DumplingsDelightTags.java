package cn.foggyhillside.dumplings_delight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;

public class DumplingsDelightTags {
    // Dumplings affected by Garlic Effect
    public static final TagKey<Item> DUMPLING = createItemTag( "dumpling");

    private static TagKey<Item> createItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DumplingsDelight.MOD_ID, path));
    }
}

package cn.foggyhillside.dumplings_delight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;

public class ModTags {
    public static final TagKey<Item> DUMPLING = ItemTags.create(ResourceLocation.fromNamespaceAndPath(DumplingsDelight.MOD_ID, "dumpling"));
}

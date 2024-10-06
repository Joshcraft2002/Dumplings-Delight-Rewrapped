package cn.foggyhillside.dumplings_delight.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;

public class DumplingsDelightTags {
    // Dumplings affected by Garlic Effect
    public static final TagKey<Item> DUMPLING = TagKey.create(Registries.ITEM, new ResourceLocation(DumplingsDelight.MOD_ID, "dumpling"));
}

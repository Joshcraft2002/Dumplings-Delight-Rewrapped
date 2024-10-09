package cn.foggyhillside.dumplings_delight.common.loot.modifier;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;

import org.jetbrains.annotations.NotNull;
import java.util.function.Supplier;

public class AddCalamariModifier extends LootModifier {
    public static final Supplier<Codec<AddCalamariModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> codecStart(inst)
                    .and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter((m) -> m.item))
                    .apply(inst, AddCalamariModifier::new)));

    private final Item item;

    protected AddCalamariModifier(LootItemCondition[] conditionsIn, Item item) {
        super(conditionsIn);
        this.item = item;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (DumplingsDelightConfig.CALAMARI_DROPS_FROM_SQUID.get()) {
            generatedLoot.add(new ItemStack(item, 1));
            if (context.getRandom().nextFloat() > 0.7) {
                generatedLoot.add(new ItemStack(item, 1));
            }
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}

package cn.foggyhillside.dumplings_delight.common.loot.modifier;

import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.LootModifier;

import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.mixin.accessor.LootContextAccessor;

import java.util.function.Supplier;

/**
 * Not sure what I'm doing, this is a copy of DumplingsDelightAddTableLootModifier but without the config condition
 */
public class AddTableLootModifier extends LootModifier {
    public static final Supplier<Codec<AddTableLootModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst)
                    .and(ResourceLocation.CODEC.fieldOf("table").forGetter((m) -> m.lootTable))
                    .apply(inst, AddTableLootModifier::new)));

    private final ResourceLocation lootTable;

    protected AddTableLootModifier(LootItemCondition[] conditionsIn, ResourceLocation lootTable) {
        super(conditionsIn);
        this.lootTable = lootTable;
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        LootTable extraTable = context.getResolver().getLootTable(this.lootTable);
        // Use new context to avoid a StackOverflowError.
        LootContext newContext = new LootContext.Builder(((LootContextAccessor)context).getParams()).create(this.lootTable);
        extraTable.getRandomItemsRaw(newContext, LootTable.createStackSplitter(context.getLevel(), generatedLoot::add));
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}

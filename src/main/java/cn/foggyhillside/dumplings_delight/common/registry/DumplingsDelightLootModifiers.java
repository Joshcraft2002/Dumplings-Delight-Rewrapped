package cn.foggyhillside.dumplings_delight.common.registry;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.common.loot.modifier.AddCalamariModifier;
import cn.foggyhillside.dumplings_delight.common.loot.modifier.DumplingsDelightAddTableLootModifier;
import com.mojang.serialization.MapCodec;
import io.github.fabricators_of_create.porting_lib.loot.IGlobalLootModifier;
import io.github.fabricators_of_create.porting_lib.loot.PortingLibLoot;
import io.github.fabricators_of_create.porting_lib.util.DeferredRegister;

import java.util.function.Supplier;

public class DumplingsDelightLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(PortingLibLoot.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DumplingsDelight.MOD_ID);

    public static final Supplier<MapCodec<AddCalamariModifier>> ADD_CALAMARI = LOOT_MODIFIERS.register("add_calamari", AddCalamariModifier.CODEC);
    public static final Supplier<MapCodec<DumplingsDelightAddTableLootModifier>> ADD_LOOT_TABLE = LOOT_MODIFIERS.register("add_loot_table", DumplingsDelightAddTableLootModifier.CODEC);
}

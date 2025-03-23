package cn.foggyhillside.dumplings_delight.refabricated;

import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.DumplingsDelightConfig;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;

/**
 * Yes this is based off of how FDRF did it
 */
public class DumplingsDelightLootModificationEvents {
    private static final ResourceKey<LootTable> ENTITIES_SQUID = vanillaKey("entities/squid");
    private static final ResourceKey<LootTable> ENTITIES_GLOW_SQUID = vanillaKey("entities/glow_squid");

    public static final ResourceKey<LootTable> ED_ABANDONED_MINESHAFT = key("chests/ed_abandoned_mineshaft");
    public static final ResourceKey<LootTable> ED_PILLAGER_OUTPOST = key("chests/ed_pillager_outpost");
    public static final ResourceKey<LootTable> ED_SHIPWRECK_SUPPLY = key("chests/ed_shipwreck_supply");
    public static final ResourceKey<LootTable> ED_SIMPLE_DUNGEON = key("chests/ed_simple_dungeon");
    public static final ResourceKey<LootTable> ED_VILLAGE_DESERT_HOUSE = key("chests/ed_village_desert_house");
    public static final ResourceKey<LootTable> ED_VILLAGE_PLAINS_HOUSE = key("chests/ed_village_plains_house");
    public static final ResourceKey<LootTable> ED_VILLAGE_SAVANNA_HOUSE = key("chests/ed_village_savanna_house");
    public static final ResourceKey<LootTable> ED_VILLAGE_SNOWY_HOUSE = key("chests/ed_village_snowy_house");
    public static final ResourceKey<LootTable> ED_VILLAGE_TAIGA_HOUSE = key("chests/ed_village_taiga_house");

    public static final ResourceKey<LootTable> ED_SQUID = key("entities/ed_squid");
    public static final ResourceKey<LootTable> ED_GLOW_SQUID = key("entities/ed_glow_squid");

    public static void init() {
        LootTableEvents.MODIFY.register(DumplingsDelightLootModificationEvents::modifyTable);
    }

    private static void modifyTable(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (!source.isBuiltin()) // Will return if the current loot table is modified via datapack.
            return;
        chestLoot(key, tableBuilder, source, registries);
        scavengingLoot(key, tableBuilder, source, registries);
    }

    private static void chestLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == BuiltInLootTables.ABANDONED_MINESHAFT)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_ABANDONED_MINESHAFT)));
        if (key == BuiltInLootTables.PILLAGER_OUTPOST)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_PILLAGER_OUTPOST)));
        if (key == BuiltInLootTables.SHIPWRECK_SUPPLY)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_SHIPWRECK_SUPPLY)));
        if (key == BuiltInLootTables.SIMPLE_DUNGEON)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_SIMPLE_DUNGEON)));
        if (key == BuiltInLootTables.VILLAGE_DESERT_HOUSE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_VILLAGE_DESERT_HOUSE)));
        if (key == BuiltInLootTables.VILLAGE_PLAINS_HOUSE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_VILLAGE_PLAINS_HOUSE)));
        if (key == BuiltInLootTables.VILLAGE_SAVANNA_HOUSE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_VILLAGE_SAVANNA_HOUSE)));
        if (key == BuiltInLootTables.VILLAGE_SNOWY_HOUSE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_VILLAGE_SNOWY_HOUSE)));
        if (key == BuiltInLootTables.VILLAGE_TAIGA_HOUSE)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_VILLAGE_TAIGA_HOUSE)));
    }

    private static void scavengingLoot(ResourceKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, HolderLookup.Provider registries) {
        if (key == ENTITIES_SQUID)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_SQUID)));
        if (key == ENTITIES_GLOW_SQUID)
            tableBuilder.withPool(LootPool.lootPool().add(NestedLootTable.lootTableReference(ED_GLOW_SQUID)));
    }

    private static ResourceKey<LootTable> vanillaKey(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.withDefaultNamespace(path));
    }

    private static ResourceKey<LootTable> key(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, DumplingsDelight.res(path));
    }
}

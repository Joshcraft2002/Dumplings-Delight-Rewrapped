package cn.foggyhillside.dumplings_delight.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.neoforged.neoforge.registries.DeferredRegister;
import cn.foggyhillside.dumplings_delight.DumplingsDelight;
import cn.foggyhillside.dumplings_delight.block.*;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, DumplingsDelight.MOD_ID);

    public static final Supplier<Block> CHINESE_CABBAGES = BLOCKS.register("chinese_cabbages",
            () -> new ChineseCabbageBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GARLIC = BLOCKS.register("garlic",
            () -> new GarlicBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GREENONION = BLOCKS.register("greenonion",
            () -> new GreenOnionBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> EGGPLANT = BLOCKS.register("eggplant",
            () -> new EggplantBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GARLIC_CHIVE = BLOCKS.register("garlic_chive",
            () -> new GarlicChiveBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> FENNEL = BLOCKS.register("fennel",
            () -> new FennelBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> CHINESE_CABBAGE_CRATE = BLOCKS.register("chinese_cabbage_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CRATE = BLOCKS.register("garlic_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GREENONION_CRATE = BLOCKS.register("greenonion_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> EGGPLANT_CRATE = BLOCKS.register("eggplant_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CHIVE_CRATE = BLOCKS.register("garlic_chive_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> FENNEL_CRATE = BLOCKS.register("fennel_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> DUMPLING_MEDLEY = BLOCKS.register("dumpling_medley",
            () -> new DumplingMedleyBlock(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL), true));
}

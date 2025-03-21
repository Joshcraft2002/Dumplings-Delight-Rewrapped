package cn.foggyhillside.dumplings_delight.common.registry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import cn.foggyhillside.dumplings_delight.common.block.*;

import java.util.function.Supplier;

import static cn.foggyhillside.dumplings_delight.refabricated.DumplingsDelightRegUtils.regBlock;

public class DumplingsDelightBlocks {

    public static final Supplier<Block> CHINESE_CABBAGES = regBlock("chinese_cabbages",
            () -> new ChineseCabbageBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GARLIC = regBlock("garlic",
            () -> new GarlicBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GREENONION = regBlock("greenonion",
            () -> new GreenOnionBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> EGGPLANT = regBlock("eggplant",
            () -> new EggplantBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> GARLIC_CHIVE = regBlock("garlic_chive",
            () -> new GarlicChiveBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> FENNEL = regBlock("fennel",
            () -> new FennelBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> CHINESE_CABBAGE_CRATE = regBlock("chinese_cabbage_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CRATE = regBlock("garlic_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GREENONION_CRATE = regBlock("greenonion_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> EGGPLANT_CRATE = regBlock("eggplant_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> GARLIC_CHIVE_CRATE = regBlock("garlic_chive_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> FENNEL_CRATE = regBlock("fennel_crate",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final Supplier<Block> DUMPLING_MEDLEY = regBlock("dumpling_medley",
            () -> new DumplingMedleyBlock(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL), true));

    public static void touch() {

    }
}

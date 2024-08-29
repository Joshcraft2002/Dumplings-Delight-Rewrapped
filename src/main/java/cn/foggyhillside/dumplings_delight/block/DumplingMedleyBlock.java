package cn.foggyhillside.dumplings_delight.block;

import cn.foggyhillside.dumplings_delight.registry.EffectRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.slf4j.Logger;

import java.util.Collection;

public class DumplingMedleyBlock extends Block {

    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SERVINGS = IntegerProperty.create("servings", 0, 7);
    public final boolean hasLeftovers;
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D),
            Block.box(1.0D, 0.0D, 1.0D, 15.0D, 3.0D, 15.0D)
    };

    public DumplingMedleyBlock(Properties properties, boolean hasLeftovers) {
        super(properties);
        this.hasLeftovers = hasLeftovers;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(getServingsProperty(), getMaxServings()));
    }

    public IntegerProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return 7;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[state.getValue(SERVINGS)];
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack heldStack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) {
            if (this.takeServing(level, pos, state, player, hand).consumesAction()) {
                return ItemInteractionResult.SUCCESS;
            }
        }

        return this.takeServing(level, pos, state, player, hand);
    }

    protected ItemInteractionResult takeServing(LevelAccessor level, BlockPos pos, BlockState state, Player player, InteractionHand hand) {
        int servings = state.getValue(getServingsProperty());

        if (servings == 0) {
            level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            level.destroyBlock(pos, true);
            return ItemInteractionResult.SUCCESS;
        }

        ItemStack heldStack = player.getItemInHand(hand);

        if (heldStack.isEmpty() && player.canEat(false)) {
            if (servings == 7 || servings == 6) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild)
                {
                    if (garlic(player)) { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 6); }
                    else { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 5); }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 5 * 2 * 0.7F);
                }
                level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                return ItemInteractionResult.SUCCESS;
            }
            if (servings == 5 || servings == 4 || servings == 3) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild)
                {
                    if (garlic(player)) { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 7); }
                    else { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 6); }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 5 * 2 * 0.7F);
                }
                level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                return ItemInteractionResult.SUCCESS;
            }
            if (servings == 2 || servings == 1) {
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0));
                if (!player.getAbilities().instabuild)
                {
                    if (garlic(player)) { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 9); }
                    else { player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() + 8); }
                    player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + 5 * 2 * 0.7F);
                }
                level.playSound(null, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS, 0.8F, 0.8F);
                level.setBlock(pos, state.setValue(getServingsProperty(), servings - 1), 3);
                return ItemInteractionResult.SUCCESS;
            }
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public boolean garlic(Player player) {
        Collection<MobEffectInstance> effects = player.getActiveEffects();
        for (MobEffectInstance effect : effects) {
            if (effect.getEffect() == EffectRegistry.GARLIC) { return true; }
        }
        return false;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState updateShape(BlockState stateIn, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        return facing == Direction.DOWN && !stateIn.canSurvive(level, currentPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(stateIn, facing, facingState, level, currentPos, facingPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.below()).isSolid();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public int getAnalogOutputSignal(BlockState blockState, Level level, BlockPos pos) {
        return blockState.getValue(getServingsProperty());
    }

    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    public boolean isPathfindable(BlockState state, PathComputationType type) {
        return false;
    }
}

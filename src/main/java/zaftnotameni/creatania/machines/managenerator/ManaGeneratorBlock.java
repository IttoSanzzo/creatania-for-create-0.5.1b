package zaftnotameni.creatania.machines.managenerator;

import com.simibubi.create.content.contraptions.base.DirectionalAxisKineticBlock;
import com.simibubi.create.foundation.block.ITE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import zaftnotameni.creatania.machines.manamachine.KineticManaMachine;
import zaftnotameni.creatania.registry.BlockEntities;

import static zaftnotameni.creatania.util.Voxel.ALMOST_FULL_BLOCK_VOXEL;
import static zaftnotameni.creatania.util.Voxel.FULL_BLOCK_VOXEL;

public class ManaGeneratorBlock extends DirectionalAxisKineticBlock implements ITE<ManaGeneratorBlockEntity> {
  public ManaGeneratorBlock(Properties properties) {
    super(properties);
    registerDefaultState(defaultBlockState());
  }
  @Override
  public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) { return KineticManaMachine.hasShaftTowards(state, face); }
  @Override
  protected Direction getFacingForPlacement(BlockPlaceContext context) { return KineticManaMachine.getFacingForPlacement(context); }
  @Override
  public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos, @NotNull CollisionContext context) { return ALMOST_FULL_BLOCK_VOXEL; }
  @Override
  public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) { return FULL_BLOCK_VOXEL; }
  @Override
  public Axis getRotationAxis(BlockState state) {
    return state.getValue(FACING).getAxis();
  }
  @Override
  public BlockState getRotatedBlockState(BlockState originalState, Direction targetedFace) { return KineticManaMachine.rotate(originalState); }
  @Override
  public BlockState rotate(BlockState pState, Rotation pRotation) { return KineticManaMachine.rotate(pState); }
  @Override
  public BlockEntityType<? extends ManaGeneratorBlockEntity> getTileEntityType() { return BlockEntities.MANA_GENERATOR_BLOCK_ENTITY.get(); }
  @Override
  public Class<ManaGeneratorBlockEntity> getTileEntityClass() {
    return ManaGeneratorBlockEntity.class;
  }
  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) { return new ManaGeneratorBlockEntity(getTileEntityType(), pos, state); }
  @Override
  public SpeedLevel getMinimumRequiredSpeedLevel() {
    return SpeedLevel.NONE;
  }
}
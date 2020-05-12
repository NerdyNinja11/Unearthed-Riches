package mod.nerdyninja11.unearthedriches.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class ChainBlock extends Block{
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE_N = Stream.of(
			Block.makeCuboidShape(7, 0, 9, 10, 1, 10),
			Block.makeCuboidShape(7, 1, 9, 8, 4, 10),
			Block.makeCuboidShape(9, 1, 9, 10, 4, 10),
			Block.makeCuboidShape(7, 4, 9, 10, 5, 10),
			Block.makeCuboidShape(8, 3, 8, 9, 4, 11),
			Block.makeCuboidShape(8, 4, 8, 9, 7, 9),
			Block.makeCuboidShape(8, 4, 10, 9, 7, 11),
			Block.makeCuboidShape(8, 7, 8, 9, 8, 11),
			Block.makeCuboidShape(9, 7, 9, 10, 10, 10),
			Block.makeCuboidShape(7, 7, 9, 8, 10, 10),
			Block.makeCuboidShape(7, 10, 9, 10, 11, 10),
			Block.makeCuboidShape(7, 6, 9, 10, 7, 10),
			Block.makeCuboidShape(8, 11, 7, 9, 12, 10),
			Block.makeCuboidShape(8, 9, 7, 9, 10, 10),
			Block.makeCuboidShape(8, 9, 10, 9, 12, 11),
			Block.makeCuboidShape(8, 9, 6, 9, 12, 7),
			Block.makeCuboidShape(7, 10, 4, 8, 11, 7),
			Block.makeCuboidShape(9, 10, 4, 10, 11, 7),
			Block.makeCuboidShape(7, 10, 7, 10, 11, 8),
			Block.makeCuboidShape(7, 10, 3, 10, 11, 4),
			Block.makeCuboidShape(8, 9, 1, 9, 10, 4),
			Block.makeCuboidShape(8, 11, 1, 9, 12, 4),
			Block.makeCuboidShape(8, 9, 4, 9, 12, 5),
			Block.makeCuboidShape(8, 9, 0, 9, 12, 1)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_S = Stream.of(
			Block.makeCuboidShape(6, 0, 6, 9, 1, 7),
			Block.makeCuboidShape(8, 1, 6, 9, 4, 7),
			Block.makeCuboidShape(6, 1, 6, 7, 4, 7),
			Block.makeCuboidShape(6, 4, 6, 9, 5, 7),
			Block.makeCuboidShape(7, 3, 5, 8, 4, 8),
			Block.makeCuboidShape(7, 4, 7, 8, 7, 8),
			Block.makeCuboidShape(7, 4, 5, 8, 7, 6),
			Block.makeCuboidShape(7, 7, 5, 8, 8, 8),
			Block.makeCuboidShape(6, 7, 6, 7, 10, 7),
			Block.makeCuboidShape(8, 7, 6, 9, 10, 7),
			Block.makeCuboidShape(6, 10, 6, 9, 11, 7),
			Block.makeCuboidShape(6, 6, 6, 9, 7, 7),
			Block.makeCuboidShape(7, 11, 6, 8, 12, 9),
			Block.makeCuboidShape(7, 9, 6, 8, 10, 9),
			Block.makeCuboidShape(7, 9, 5, 8, 12, 6),
			Block.makeCuboidShape(7, 9, 9, 8, 12, 10),
			Block.makeCuboidShape(8, 10, 9, 9, 11, 12),
			Block.makeCuboidShape(6, 10, 9, 7, 11, 12),
			Block.makeCuboidShape(6, 10, 8, 9, 11, 9),
			Block.makeCuboidShape(6, 10, 12, 9, 11, 13),
			Block.makeCuboidShape(7, 9, 12, 8, 10, 15),
			Block.makeCuboidShape(7, 11, 12, 8, 12, 15),
			Block.makeCuboidShape(7, 9, 11, 8, 12, 12),
			Block.makeCuboidShape(7, 9, 15, 8, 12, 16)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
			
	private static final VoxelShape SHAPE_E = Stream.of(
			Block.makeCuboidShape(6, 0, 7, 7, 1, 10),
			Block.makeCuboidShape(6, 1, 7, 7, 4, 8),
			Block.makeCuboidShape(6, 1, 9, 7, 4, 10),
			Block.makeCuboidShape(6, 4, 7, 7, 5, 10),
			Block.makeCuboidShape(5, 3, 8, 8, 4, 9),
			Block.makeCuboidShape(7, 4, 8, 8, 7, 9),
			Block.makeCuboidShape(5, 4, 8, 6, 7, 9),
			Block.makeCuboidShape(5, 7, 8, 8, 8, 9),
			Block.makeCuboidShape(6, 7, 9, 7, 10, 10),
			Block.makeCuboidShape(6, 7, 7, 7, 10, 8),
			Block.makeCuboidShape(6, 10, 7, 7, 11, 10),
			Block.makeCuboidShape(6, 6, 7, 7, 7, 10),
			Block.makeCuboidShape(6, 11, 8, 9, 12, 9),
			Block.makeCuboidShape(6, 9, 8, 9, 10, 9),
			Block.makeCuboidShape(5, 9, 8, 6, 12, 9),
			Block.makeCuboidShape(9, 9, 8, 10, 12, 9),
			Block.makeCuboidShape(9, 10, 7, 12, 11, 8),
			Block.makeCuboidShape(9, 10, 9, 12, 11, 10),
			Block.makeCuboidShape(8, 10, 7, 9, 11, 10),
			Block.makeCuboidShape(12, 10, 7, 13, 11, 10),
			Block.makeCuboidShape(12, 9, 8, 15, 10, 9),
			Block.makeCuboidShape(12, 11, 8, 15, 12, 9),
			Block.makeCuboidShape(11, 9, 8, 12, 12, 9),
			Block.makeCuboidShape(15, 9, 8, 16, 12, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	private static final VoxelShape SHAPE_W = Stream.of(
			Block.makeCuboidShape(9, 0, 6, 10, 1, 9),
			Block.makeCuboidShape(9, 1, 8, 10, 4, 9),
			Block.makeCuboidShape(9, 1, 6, 10, 4, 7),
			Block.makeCuboidShape(9, 4, 6, 10, 5, 9),
			Block.makeCuboidShape(8, 3, 7, 11, 4, 8),
			Block.makeCuboidShape(8, 4, 7, 9, 7, 8),
			Block.makeCuboidShape(10, 4, 7, 11, 7, 8),
			Block.makeCuboidShape(8, 7, 7, 11, 8, 8),
			Block.makeCuboidShape(9, 7, 6, 10, 10, 7),
			Block.makeCuboidShape(9, 7, 8, 10, 10, 9),
			Block.makeCuboidShape(9, 10, 6, 10, 11, 9),
			Block.makeCuboidShape(9, 6, 6, 10, 7, 9),
			Block.makeCuboidShape(7, 11, 7, 10, 12, 8),
			Block.makeCuboidShape(7, 9, 7, 10, 10, 8),
			Block.makeCuboidShape(10, 9, 7, 11, 12, 8),
			Block.makeCuboidShape(6, 9, 7, 7, 12, 8),
			Block.makeCuboidShape(4, 10, 8, 7, 11, 9),
			Block.makeCuboidShape(4, 10, 6, 7, 11, 7),
			Block.makeCuboidShape(7, 10, 6, 8, 11, 9),
			Block.makeCuboidShape(3, 10, 6, 4, 11, 9),
			Block.makeCuboidShape(1, 9, 7, 4, 10, 8),
			Block.makeCuboidShape(1, 11, 7, 4, 12, 8),
			Block.makeCuboidShape(4, 9, 7, 5, 12, 8),
			Block.makeCuboidShape(0, 9, 7, 1, 12, 8)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public ChainBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING, Direction.NORTH));
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch (state.get(FACING)) {
		case NORTH:
			return SHAPE_N;
		case SOUTH:
			return SHAPE_S;
		case EAST:
			return SHAPE_E;
		case WEST:
			return SHAPE_W; 
		default:
			return SHAPE_N;
		}
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING, context.getPlacementHorizontalFacing());
	}
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}

	
	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		SoundEvent chain = SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
		worldIn.playSound(player, pos, chain, SoundCategory.BLOCKS, 50, 50);
		
		return ActionResultType.SUCCESS;
	}
}

package mod.nerdyninja11.unearthedriches.objects.blocks;

import java.util.stream.Stream;

import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class QuarryBlock extends Block {
	public BooleanProperty POWERED = BlockStateProperties.POWERED;
	
	private static final VoxelShape SHAPE = Stream.of(
			Block.makeCuboidShape(0, 10, 0, 16, 16, 16),
			Block.makeCuboidShape(0, 0, 3, 3, 3, 16),
			Block.makeCuboidShape(3, 0, 13, 16, 3, 16),
			Block.makeCuboidShape(0, 0, 0, 13, 3, 3),
			Block.makeCuboidShape(13, 0, 0, 16, 3, 13),
			Block.makeCuboidShape(0, 3, 0, 3, 10, 3),
			Block.makeCuboidShape(0, 3, 13, 3, 10, 16),
			Block.makeCuboidShape(13, 3, 13, 16, 10, 16),
			Block.makeCuboidShape(13, 3, 0, 16, 10, 3),
			Block.makeCuboidShape(3, 8, 3, 13, 10, 13),
			Block.makeCuboidShape(4, 6, 4, 12, 8, 12),
			Block.makeCuboidShape(5, 4, 5, 11, 6, 11),
			Block.makeCuboidShape(6, 2, 6, 10, 4, 10),
			Block.makeCuboidShape(7, 0, 7, 9, 2, 9)
			).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}

	public QuarryBlock(Properties properties) {
		super(properties); 
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.QUARRY.get().create();
	}
	

	@Override
	public boolean isTransparent(BlockState state) {
		return true;
	}
	
	@Override
	public boolean isNormalCube(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return false;
	}
	
	
}

package mod.nerdyninja11.unearthedriches.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FlammableLeavesBlock extends LeavesBlock{
	private static int flammability, encouragement, opacity;
	
	
	public FlammableLeavesBlock(Properties properties, int flammabilityIn, int encouragementIn, int opacityIn) {
		super(properties);
		flammability = flammabilityIn;
		encouragement = encouragementIn;
		opacity = opacityIn;
	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return flammability;
	}
	
	@Override
	public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return encouragement;
	}
	
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		return true;
	}
	
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return opacity;
	}
	
}

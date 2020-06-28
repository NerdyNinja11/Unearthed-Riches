package mod.nerdyninja11.unearthedriches.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FlammableFenceGateBlock extends FenceGateBlock{
	private int flammability, encouragement;
	
	
	public FlammableFenceGateBlock(Properties properties, int flammabilityIn, int encouragementIn) {
		super(properties);
		flammability = flammabilityIn;
		encouragement = encouragementIn;
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
}

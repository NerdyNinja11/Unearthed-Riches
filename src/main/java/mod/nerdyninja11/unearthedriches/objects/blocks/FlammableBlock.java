package mod.nerdyninja11.unearthedriches.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FlammableBlock extends Block{
	private int flammability, encouragement;
	
	
	public FlammableBlock(Properties properties, int flammabilityIn, int encouragementIn) {
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

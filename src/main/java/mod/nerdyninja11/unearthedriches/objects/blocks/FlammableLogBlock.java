package mod.nerdyninja11.unearthedriches.objects.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

public class FlammableLogBlock extends LogBlock{
	private static int flammability, encouragement;
	
	
	public FlammableLogBlock(MaterialColor verticalColor, Properties properties, int flammabilityIn, int encouragementIn) {
		super(verticalColor, properties);
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

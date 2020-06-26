package mod.nerdyninja11.unearthedriches.objects.blocks;

import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class MilkFluidBlock extends FlowingFluidBlock{

	public MilkFluidBlock(Supplier<? extends FlowingFluid> supplier, Properties properties) {
		super(supplier, properties);
	}
	
	@Override
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		if (!worldIn.isRemote && worldIn.getDifficulty() != Difficulty.PEACEFUL) {
	         if (entityIn instanceof LivingEntity) {
	            LivingEntity livingentity = (LivingEntity)entityIn;
	            if (Math.random() > 0.995) {
	            	livingentity.clearActivePotions();
	            }
	         }

	    }
	}

}

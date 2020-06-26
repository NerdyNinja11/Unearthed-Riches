package mod.nerdyninja11.unearthedriches.objects.fluids;

import java.util.Random;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.init.FluidInit;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public class MilkFluid extends ForgeFlowingFluid {

	public static final ResourceLocation MILK_STILL_RL = new ResourceLocation(UnearthedRiches.MOD_ID,
			"blocks/milk_still");
	public static final ResourceLocation MILK_FLOWING_RL = new ResourceLocation(UnearthedRiches.MOD_ID,
			"blocks/milk_flowing");
	public static final ResourceLocation MILK_OVERLAY_RL = new ResourceLocation(UnearthedRiches.MOD_ID,
			"blocks/milk_overlay");

	public static final ForgeFlowingFluid.Properties MILK_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> FluidInit.MILK_FLUID.get(), () -> FluidInit.MILK_FLOWING.get(),
			FluidAttributes.builder(MILK_STILL_RL, MILK_FLOWING_RL).viscosity(1100).color(0xFFFFFF)
					.sound(SoundEvents.ITEM_BUCKET_FILL, SoundEvents.ITEM_BUCKET_EMPTY).overlay(MILK_OVERLAY_RL))
							.bucket(() -> Items.MILK_BUCKET).block(() -> FluidInit.MILK_BLOCK.get()).levelDecreasePerBlock(2);
 
	public MilkFluid(Properties properties) {
		super(properties);

	}

	@Override
	public boolean isSource(IFluidState state) {
		return false;
	}

	@Override
	public int getLevel(IFluidState p_207192_1_) {
		return 0;
	}
	
	@OnlyIn(Dist.CLIENT)
	public void animateTick(World worldIn, BlockPos pos, IFluidState state, Random random) {
	   if (!state.isSource() && !state.get(FALLING)) {
	      if (random.nextInt(64) == 0) {
	         worldIn.playSound((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.5F, random.nextFloat() + 0.75F, false);
	      }
	   } else if (random.nextInt(10) == 0) {
	      worldIn.addParticle(ParticleTypes.POOF, (double)pos.getX() + (double)random.nextFloat(), (double)pos.getY() + (double)random.nextFloat(), (double)pos.getZ() + (double)random.nextFloat(), 0.0D, 0.0D, 0.0D);
	   }

	 }
	
	

}

package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.objects.blocks.MilkFluidBlock;
import mod.nerdyninja11.unearthedriches.objects.fluids.MilkFluid;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {


	public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<>(ForgeRegistries.FLUIDS,
			UnearthedRiches.MOD_ID);

	public static final RegistryObject<FlowingFluid> MILK_FLUID = FLUIDS.register("milk_fluid",
			() -> new MilkFluid.Source(MilkFluid.MILK_PROPERTIES));
	public static final RegistryObject<FlowingFluid> MILK_FLOWING = FLUIDS.register("milk_flowing",
			() -> new MilkFluid.Flowing(MilkFluid.MILK_PROPERTIES));


	public static final RegistryObject<FlowingFluidBlock> MILK_BLOCK = BlockInit.BLOCKS.register("milk",
			() -> new MilkFluidBlock(() -> FluidInit.MILK_FLUID.get(), Block.Properties.from(Blocks.WATER)));

}

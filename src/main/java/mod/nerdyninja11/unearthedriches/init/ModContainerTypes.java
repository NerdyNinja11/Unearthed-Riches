package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.container.DisplayCaseContainer;
import mod.nerdyninja11.unearthedriches.container.NetherChestContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainerTypes {
	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, UnearthedRiches.MOD_ID);

	
	public static final RegistryObject<ContainerType<NetherChestContainer>> NETHER_CHEST = CONTAINER_TYPES
			.register("nether_chest", () -> IForgeContainerType.create(NetherChestContainer::new));
	
	public static final RegistryObject<ContainerType<DisplayCaseContainer>> DISPLAY_CASE = CONTAINER_TYPES
			.register("display_case", () -> IForgeContainerType.create(DisplayCaseContainer::new));
}

package mod.nerdyninja11.unearthedriches.init;

import mod.nerdyninja11.unearthedriches.UnearthedRiches;
import mod.nerdyninja11.unearthedriches.tileentity.NetherChestTileEntity;
import mod.nerdyninja11.unearthedriches.tileentity.QuarryTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, UnearthedRiches.MOD_ID);

	public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY = TILE_ENTITY_TYPES.register("quarry",
			() -> TileEntityType.Builder.create(QuarryTileEntity::new, BlockInit.QUARRY.get()).build(null));
	public static final RegistryObject<TileEntityType<NetherChestTileEntity>> NETHER_CHEST = TILE_ENTITY_TYPES.register(
			"nether_chest",
			() -> TileEntityType.Builder.create(NetherChestTileEntity::new, BlockInit.NETHER_CHEST.get()).build(null));

}

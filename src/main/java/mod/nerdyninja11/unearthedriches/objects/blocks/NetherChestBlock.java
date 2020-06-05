package mod.nerdyninja11.unearthedriches.objects.blocks;

import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import mod.nerdyninja11.unearthedriches.tileentity.NetherChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class NetherChestBlock extends Block {

	public NetherChestBlock(Properties properties) {
		super(properties); 
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	

	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return ModTileEntityTypes.NETHER_CHEST.get().create();
	}
	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult hit) {
		if (!worldIn.isRemote) {
			if (worldIn.dimension.isNether()) {
				worldIn.createExplosion((Entity)null, DamageSource.netherBedExplosion(), (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, 5.0F, true, Explosion.Mode.DESTROY);
	            return ActionResultType.SUCCESS;
			} else {
				TileEntity tile = worldIn.getTileEntity(pos);
				if (tile instanceof NetherChestTileEntity) {
					NetworkHooks.openGui((ServerPlayerEntity)player, (NetherChestTileEntity)tile, pos);
					return ActionResultType.SUCCESS;
			}
			}
		}
		return ActionResultType.FAIL;
	}
	
	@Override
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			TileEntity te = worldIn.getTileEntity(pos);
			if (te instanceof NetherChestTileEntity) {
				InventoryHelper.dropItems(worldIn, pos, ((NetherChestTileEntity)te).getItems());
			}
		}
	}

}

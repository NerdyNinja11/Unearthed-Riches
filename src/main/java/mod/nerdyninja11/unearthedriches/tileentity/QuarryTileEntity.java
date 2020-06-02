package mod.nerdyninja11.unearthedriches.tileentity;

import javax.annotation.Nullable;

import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import mod.nerdyninja11.unearthedriches.util.helpers.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

public class QuarryTileEntity extends TileEntity implements ITickableTileEntity {
	
	public int x, y, z, tick;
	public boolean initialized, powered;

	public QuarryTileEntity(final TileEntityType<?> tileEntityTypeIn) {
		super(tileEntityTypeIn);
	}
	
	public QuarryTileEntity() {
		this(ModTileEntityTypes.QUARRY.get());
	}
	
	@Override
	public void tick() {
		if (!initialized) init();
		if (powered = world.getBlockState(this.pos).get(BlockStateProperties.LIT)) {
			tick++;
			if (tick == 60) {
				tick = 0;
				if (y > 4) execute();
			}
		}	
	}
	
	
	private void init() {
		initialized = true;
		x = this.pos.getX();
		y = this.pos.getY() - 1;
		z = this.pos.getZ();
		tick = 0;
	}


	private void execute() {
		for (int i = 5; i > 0; i -= 2) {
			int index = 0;
			Block[] blocksRemoved = new Block[i*i];
			for (int x = -(i-1)/2; x < (i+1)/2; x++) {
				for (int z = -(i-1)/2; z < (i+1)/2; z++) {
					if (y > 4) {
						BlockPos posToBreak = new BlockPos(this.x + x, this.y, this.z + z);
						blocksRemoved[index] = this.world.getBlockState(posToBreak).getBlock();
						destroyBlock(posToBreak, true, null);
						index++;
					}
				}
			}
			this.y--;
		}
		this.y += 2;
	}

	private boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
		BlockState blockstate = world.getBlockState(pos);
		if (blockstate.isAir(world, pos)) return false;
		else if (blockstate.getBlockHardness(world, pos) > 10) return false;
		else if (blockstate.getBlockHardness(world, pos) < 0) return false;
		else {
			IFluidState ifluidstate = world.getFluidState(pos);
			world.playEvent(2001, pos, Block.getStateId(blockstate));
		
			if (dropBlock) {
				TileEntity tileentity = blockstate.hasTileEntity() ? world.getTileEntity(pos) : null;
				Block.spawnDrops(blockstate, world, this.pos.add(0, 1.5, 0), tileentity, entity, ItemStack.EMPTY);
			}
		
			return world.setBlockState(pos, ifluidstate.getBlockState(), 3);
		}
	}
	
	@Override
	public CompoundNBT write(CompoundNBT compound) {
		compound.put("initvalues", NBTHelper.toNBT(this));
		return super.write(compound);
	}
	
	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		CompoundNBT initvalues = compound.getCompound("initvalues");
		if (initvalues != null) {
			this.x = initvalues.getInt("x");
			this.y = initvalues.getInt("y");
			this.z = initvalues.getInt("z");
			this.tick = 0;
			initialized = true;
			return;
		} 
		init();
	}
}



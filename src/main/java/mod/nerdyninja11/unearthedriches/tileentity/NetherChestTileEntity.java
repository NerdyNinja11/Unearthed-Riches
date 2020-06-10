package mod.nerdyninja11.unearthedriches.tileentity;

import javax.annotation.Nonnull;

import mod.nerdyninja11.unearthedriches.container.NetherChestContainer;
import mod.nerdyninja11.unearthedriches.init.ModTileEntityTypes;
import mod.nerdyninja11.unearthedriches.objects.blocks.NetherChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

public class NetherChestTileEntity extends LockableLootTileEntity {

	private NonNullList<ItemStack> chestContents = NonNullList.withSize(216, ItemStack.EMPTY);
	protected int numPlayersUsing;
	private IItemHandlerModifiable items = createHandler();
	private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

	public NetherChestTileEntity(TileEntityType<?> typeIn) {
		super(typeIn);
	}

	public NetherChestTileEntity() {
		this(ModTileEntityTypes.NETHER_CHEST.get());
	}

	@Override
	public int getSizeInventory() {
		return 216;
	}

	@Override
	public NonNullList<ItemStack> getItems() {
		return this.chestContents;
	}

	@Override
	public void setItems(NonNullList<ItemStack> itemsIn) {
		this.chestContents = itemsIn;
	}

	@Override
	protected ITextComponent getDefaultName() {
		return new TranslationTextComponent("container.nether_chest");
	}

	@Override
	protected Container createMenu(int id, PlayerInventory player) {
		return new NetherChestContainer(id, player, this);
	}

	@Override
	public CompoundNBT write(CompoundNBT compound) {
		super.write(compound);
		if (!this.checkLootAndWrite(compound)) {
			ItemStackHelper.saveAllItems(compound, this.chestContents);
		}
		return compound;
	}

	@Override
	public void read(CompoundNBT compound) {
		super.read(compound);
		this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
		if (!this.checkLootAndRead(compound)) {
			ItemStackHelper.loadAllItems(compound, this.chestContents);
		}
	}

	private void playSound(SoundEvent sound) {
		double dx = (double) this.pos.getX() + 0.5D;
		double dy = (double) this.pos.getY() + 0.5D;
		double dz = (double) this.pos.getZ() + 0.5D;
		this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
				this.world.rand.nextFloat() * 0.1F + 0.9F);
	}

	@Override
	public boolean receiveClientEvent(int id, int type) {
		if (id == 1) {
			this.numPlayersUsing = type;
			return true;
		} else {
			return super.receiveClientEvent(id, type);
		}
	}

	@Override
	public void openInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			if (this.numPlayersUsing < 0) {
				this.numPlayersUsing = 0;
			}			
			++this.numPlayersUsing;
			this.playSound(SoundEvents.BLOCK_ANVIL_DESTROY);
			this.onOpenOrClose();
		}
	}

	protected void onOpenOrClose() {
		Block block = this.getBlockState().getBlock();
		if (block instanceof NetherChestBlock) {
			this.world.addBlockEvent(this.pos, block, 1, this.numPlayersUsing);
			this.world.notifyNeighborsOfStateChange(pos, block);
			
		}

	}

	public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
		BlockState blockState = reader.getBlockState(pos);
		if (blockState.hasTileEntity()) {
			TileEntity tileentity = reader.getTileEntity(pos);
			if (tileentity instanceof NetherChestTileEntity) {
				return ((NetherChestTileEntity) tileentity).numPlayersUsing;
			}
		}
		return 0;
	}

	public static void swapContents(NetherChestTileEntity te, NetherChestTileEntity ote) {
		NonNullList<ItemStack> list = te.getItems();
		te.setItems(ote.getItems());
		ote.setItems(list);
	}

	@Override
	public void closeInventory(PlayerEntity player) {
		if (!player.isSpectator()) {
			--this.numPlayersUsing;
			this.onOpenOrClose();
		}
	}

	@Override
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
		if (this.itemHandler != null) {
			this.itemHandler.invalidate();
			this.itemHandler = null;
		}
	}

	@Override
	public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
		if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return itemHandler.cast();
		}
		return super.getCapability(cap, side);
	}

	private IItemHandlerModifiable createHandler() {
		return new InvWrapper(this);
	}
	
	@Override
	public void remove() {
		super.remove();
		if (itemHandler != null) {
			this.itemHandler.invalidate();
		}
	}
}
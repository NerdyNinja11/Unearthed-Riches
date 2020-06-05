package mod.nerdyninja11.unearthedriches.container;

import java.util.Objects;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import mod.nerdyninja11.unearthedriches.init.ModContainerTypes;
import mod.nerdyninja11.unearthedriches.tileentity.NetherChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class NetherChestContainer extends Container {

	public final NetherChestTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public NetherChestContainer(final int windowID, final PlayerInventory playerInventory,
			final NetherChestTileEntity tileEntity) {
		super(ModContainerTypes.NETHER_CHEST.get(), windowID);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Main inventory
		int startX = 8;
		int startY = 18;
		int slotSizePlus2 = 18;
		for (int row = 0; row < 12; ++row) {
			for (int col = 0; col < 18; ++col) {
				this.addSlot(new Slot(tileEntity, (row * 18) + col, startX + (col * slotSizePlus2),
						startY + (row * slotSizePlus2)));
			}
		}
		
		// Player inventory
		int playerInvStartX = 89;
		int playerInvStartY = 248;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + col, playerInvStartX + (col * slotSizePlus2),
						playerInvStartY + (row * slotSizePlus2)));
			}
		}
		
		//Hotbar
		int hotbarStartY = 306;
		for (int col = 0; col < 9; ++col) {
			this.addSlot(new Slot(playerInventory, col, playerInvStartX + (col * slotSizePlus2),
					hotbarStartY));
		}
	}
	
	private static NetherChestTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof NetherChestTileEntity) {
			return (NetherChestTileEntity)tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct - " + tileAtPos);
	}
	
	
	public NetherChestContainer(final int windowID, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowID, playerInventory, getTileEntity(playerInventory, data));	
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.NETHER_CHEST.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index < 216) {
	            if (!this.mergeItemStack(itemstack1, 216, this.inventorySlots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.mergeItemStack(itemstack1, 0, 216, false)) {
	            return ItemStack.EMPTY;
	         }

	         if (itemstack1.isEmpty()) {
	            slot.putStack(ItemStack.EMPTY);
	         } else {
	            slot.onSlotChanged();
	         }
	      }

	      return itemstack;
	}
}

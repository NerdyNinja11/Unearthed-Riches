package mod.nerdyninja11.unearthedriches.container;

import java.util.Objects;

import mod.nerdyninja11.unearthedriches.init.BlockInit;
import mod.nerdyninja11.unearthedriches.init.ModContainerTypes;
import mod.nerdyninja11.unearthedriches.tileentity.DisplayCaseTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

public class DisplayCaseContainer extends Container {

	public final DisplayCaseTileEntity tileEntity;
	private final IWorldPosCallable canInteractWithCallable;

	public DisplayCaseContainer(final int windowID, final PlayerInventory playerInventory,
			final DisplayCaseTileEntity tileEntity) {
		super(ModContainerTypes.DISPLAY_CASE.get(), windowID);
		this.tileEntity = tileEntity;
		this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

		// Main inventory
		this.addSlot(new Slot(tileEntity, 0, 81, 36));

		
		// Player inventory
		int playerInvStartX = 8;
		int playerInvStartY = 84;
		int slotSizePlus2 = 18;
		for (int row = 0; row < 3; ++row) {
			for (int col = 0; col < 9; ++col) {
				this.addSlot(new Slot(playerInventory, 9 + (row * 9) + col, playerInvStartX + (col * slotSizePlus2),
						playerInvStartY + (row * slotSizePlus2)));
			}
		}
		
		//Hotbar
		int hotbarStartY = 142;
		for (int col = 0; col < 9; ++col) {
			this.addSlot(new Slot(playerInventory, col, playerInvStartX + (col * slotSizePlus2),
					hotbarStartY));
		}
	}
	
	
	private static DisplayCaseTileEntity getTileEntity(final PlayerInventory playerInventory, final PacketBuffer data) {
		Objects.requireNonNull(playerInventory, "playerInventory cannot be null");
		Objects.requireNonNull(data, "data cannot be null");
		
		final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
		if (tileAtPos instanceof DisplayCaseTileEntity) {
			return (DisplayCaseTileEntity) tileAtPos;
		}
		throw new IllegalStateException("Tile entity is not correct - " + tileAtPos);
	}
	
	
	public DisplayCaseContainer(final int windowID, final PlayerInventory playerInventory, final PacketBuffer data) {
		this(windowID, playerInventory, getTileEntity(playerInventory, data));	
	}
	
	@Override
	public boolean canInteractWith(PlayerEntity playerIn) {
		return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.DISPLAY_CASE.get());
	}
	
	@Override
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
	      ItemStack itemstack = ItemStack.EMPTY;
	      Slot slot = this.inventorySlots.get(index);
	      if (slot != null && slot.getHasStack()) {
	         ItemStack itemstack1 = slot.getStack();
	         itemstack = itemstack1.copy();
	         if (index < 1) {
	            if (!this.mergeItemStack(itemstack1, 1, this.inventorySlots.size(), true)) {
	               return ItemStack.EMPTY;
	            }
	         } else if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
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

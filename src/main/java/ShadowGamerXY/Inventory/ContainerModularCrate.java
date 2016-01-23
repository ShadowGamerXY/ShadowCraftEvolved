package ShadowGamerXY.Inventory;

import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;

public class ContainerModularCrate extends ContainerSCE 
{
	private final TileEntityModularCrate te;
	
	
	public ContainerModularCrate(InventoryPlayer playerInventory, TileEntityModularCrate te)
	{
		this.addSlotToContainer(new SlotSCE(te, 0, 8, 17));
		this.addSlotToContainer(new SlotSCE(te, 1, 26, 17));
		this.addSlotToContainer(new SlotSCE(te, 2, 44, 17));
		this.addSlotToContainer(new SlotSCE(te, 3, 62, 17));
		this.addSlotToContainer(new SlotSCE(te, 4, 80, 17));
		this.addSlotToContainer(new SlotSCE(te, 5, 98, 17));
		this.addSlotToContainer(new SlotSCE(te, 6, 116, 17));
		this.addSlotToContainer(new SlotSCE(te, 7, 134, 17));
		this.addSlotToContainer(new SlotSCE(te, 8, 152, 17));
		this.addSlotToContainer(new SlotSCE(te, 9, 8, 35));
		this.addSlotToContainer(new SlotSCE(te, 10, 26, 35));
		this.addSlotToContainer(new SlotSCE(te, 11, 44, 35));
		this.addSlotToContainer(new SlotSCE(te, 12, 62, 35));
		this.addSlotToContainer(new SlotSCE(te, 13, 80, 35));
		this.addSlotToContainer(new SlotSCE(te, 14, 98, 35));
		this.addSlotToContainer(new SlotSCE(te, 15, 116, 35));
		this.addSlotToContainer(new SlotSCE(te, 16, 134, 35));
		this.addSlotToContainer(new SlotSCE(te, 17, 152, 35));
		this.addSlotToContainer(new SlotSCE(te, 18, 8, 53));
		this.addSlotToContainer(new SlotSCE(te, 19, 26, 53));
		this.addSlotToContainer(new SlotSCE(te, 20, 44, 53));
		this.addSlotToContainer(new SlotSCE(te, 21, 62, 53));
		this.addSlotToContainer(new SlotSCE(te, 22, 80, 53));
		this.addSlotToContainer(new SlotSCE(te, 23, 98, 53));
		this.addSlotToContainer(new SlotSCE(te, 24, 116, 53));
		this.addSlotToContainer(new SlotSCE(te, 25, 134, 53));
		this.addSlotToContainer(new SlotSCE(te, 26, 152, 53));


		
		
		
		this.addPlayerSlots(playerInventory, 8, 84);
		this.te =te;
	}
	
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.isUseableByPlayer(player);
	}
	 /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex){
		return null;
    	  
    }
}

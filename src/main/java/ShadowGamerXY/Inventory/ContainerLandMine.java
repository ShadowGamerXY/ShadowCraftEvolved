package ShadowGamerXY.Inventory;

import java.util.List;

import ShadowGamerXY.Network.MessageHandleTextUpdate;
import ShadowGamerXY.Network.NetworkHandler;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerLandMine extends ContainerSCE 
{
	private final TileEntityLandMineMk3 te;
	private int lastTimer = -1;
	private String lastTarget = "";
	
	
	public ContainerLandMine(InventoryPlayer playerInventory, TileEntityLandMineMk3 te)
	{
		this.addSlotToContainer(new SlotSCE(te, 0, 80, 58));
		this.addSlotToContainer(new SlotSCE(te, 1, 80, 22));
		this.addSlotToContainer(new SlotSCE(te, 2, 80, 40));
		this.addSlotToContainer(new SlotSCE(te, 3, 62, 40));
		this.addSlotToContainer(new SlotSCE(te, 4, 98, 40));
		this.addSlotToContainer(new SlotSCE(te, 5, 102, 18));
		
		
		this.addPlayerSlots(playerInventory, 8, 84);
		this.te =te;
	}
	

    @Override
    public void detectAndSendChanges(){
        super.detectAndSendChanges();
        if(lastTimer != te.getTimer()) {
            for(ICrafting crafter : (List<ICrafting>)crafters) {
                crafter.sendProgressBarUpdate(this, 0, te.getTimer());
            }
            lastTimer = te.getTimer();
        }
        if(!lastTarget.equals(te.getTarget())) {
            for(Object crafter : crafters) {
                if(crafter instanceof EntityPlayerMP) {
                    NetworkHandler.sendTo(new MessageHandleTextUpdate(te, 0, te.getTarget()), (EntityPlayerMP)crafter);
                }
            }
            lastTarget = te.getTarget();
        }
        }
        
	 @SideOnly(Side.CLIENT)
	    public void updateProgressBar(int id, int vaule)
	    {
		 super.updateProgressBar(id, vaule);
		 if(id  == 0)
		 {
			 te.setTimer(vaule);
		 }
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
        ItemStack itemstack = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if(slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            //From here change accordingly...
            if(slotIndex < 6) {
                if(!mergeItemStack(itemstack1, 6, 42, true)) {
                    return null;
                }
            } else {
                //Shift click single items only.
                if(itemstack1.stackSize == 1) {
                    for(int i = 0; i < 6; i++) {
                        Slot shiftedInSlot = (Slot)inventorySlots.get(i);
                        if(!shiftedInSlot.getHasStack() && shiftedInSlot.isItemValid(itemstack1)) mergeItemStack(itemstack1, i, i + 1, false);
                    }
                }
            }
            //...till here.

            if(itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if(itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}

package ShadowGamerXY.Inventory;

import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ICrafting;
import net.minecraft.item.ItemStack;

public class ContainerInfuser extends ContainerSCE 
{
	private final  TileEntityInfuser te;
	private int dualCookTime;
	private int dualPower;
	private int lastItemBurnTime;
	
	public ContainerInfuser(InventoryPlayer playerInventory, TileEntityInfuser te)
	{
		dualCookTime = 0;
		dualPower = 0;
		lastItemBurnTime = 0;
		
		
		this.addSlotToContainer(new SlotSCE(te, 0, 45, 17));
		this.addSlotToContainer(new SlotSCE(te, 1, 45, 49));
		this.addSlotToContainer(new SlotSCE(te, 2, 8, 54));
		this.addSlotToContainer(new SlotSCE(te, 3, 113, 33));
		
		
		this.addPlayerSlots(playerInventory, 8, 84);
		this.te =te;
	}
	
	public void addCraftingToCrafters (ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		crafting.sendProgressBarUpdate(this, 0, this.te.dualCookTime);
		crafting.sendProgressBarUpdate(this, 1, this.te.dualPower);
	}
	
	
	public void detectAndSendChanges()
    {
      super.detectAndSendChanges();
      
    	  for(int i =0; i < this.crafters.size(); i++)
    	  {
    		  ICrafting k = (ICrafting)this.crafters.get(i);
    		  
    		  if(this.dualCookTime !=this.te.dualPower)
    		  {	
    			  k.sendProgressBarUpdate(this, 0, this.te.dualCookTime);
    		  }
    		  if(this.dualPower !=this.te.dualPower)
    		  {	
    			  k.sendProgressBarUpdate(this, 1, this.te.dualPower);
    		  }
    	  }
      this.dualCookTime = this.te.dualCookTime;
      this.dualPower=this.te.dualPower;
    }
    
    public void updateProgressBar(int i,int j)
    {
    	if(i == 0)
    	{
    	 te.dualCookTime = j;
    	}
    	
    	if(i == 1)
    	{
    	te.dualPower = j;
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
		return null;
    	  
    }
}

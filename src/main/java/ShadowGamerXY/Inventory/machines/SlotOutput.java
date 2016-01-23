package ShadowGamerXY.Inventory.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotOutput extends Slot 
{
	
	public EntityPlayer thePlayer;
	
	public SlotOutput(IInventory inventory, EntityPlayer player, int id, int x, int y) {
		super(inventory, id, x, y);
	}
	
	public boolean isItemValid(ItemStack stack)
	{
		return false;
	}
	public void onPickupFromSlot(EntityPlayer player, ItemStack stack)
	{
		this.onCrafting(stack);
		super.onPickupFromSlot(player, stack);
	}
	protected void onCrafting(ItemStack stack, int count)
	{
		this.onCrafting(stack);
	}

	
}

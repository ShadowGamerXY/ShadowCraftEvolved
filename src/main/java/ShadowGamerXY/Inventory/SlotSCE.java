package ShadowGamerXY.Inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SlotSCE extends net.minecraft.inventory.Slot
{

	public SlotSCE(IInventory inventory, int invenotryIndex, int x, int y) {
		super(inventory, invenotryIndex, x, y);

	}
	@Override
	public boolean isItemValid(ItemStack stack)
    {
        return inventory.isItemValidForSlot(getSlotIndex(), stack);
    }
	
}

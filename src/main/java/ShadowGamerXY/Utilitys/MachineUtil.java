package ShadowGamerXY.Utilitys;

import ShadowGamerXY.Utilitys.Power.EnergyBar;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class MachineUtil 
{
	public static void operate(ItemStack[] inventory, EnergyBar energyBar, ItemStack result, IInventory inventoryClass, int status, boolean isOperating, int energyUsePerOperation, int stackSizeToDecerase)
	{
		if(result != null)
		{
			if(inventory[1] == null)
			{
				inventory[1] = result.copy();
			}
			else if(inventory[1].isItemEqual(result))
			{
				inventory[1].stackSize += result.stackSize;
			}
			
			inventory[0].stackSize -= stackSizeToDecerase;
			
			if(inventory[0].stackSize <= 0)
			{
				inventory[0] = null;
			}
			energyBar.removeEnergy(energyUsePerOperation);
		}
		status = 0;
		isOperating = false;
	}
	
	public static boolean canOperate(ItemStack[] inventory, EnergyBar energyBar, ItemStack result, IInventory inventoryClass, int energyUsePerOperation, int stackSizeToDecrease)
	{
		if(inventory[0] == null)
		{
			return false;
		}
		if(result == null)return false;
		if(!energyBar.canRemoveEnergy(energyUsePerOperation)) return false;
		if(inventory[1] == null) return true;
		if(!inventory[1].isItemEqual(result)) return false;
		if(inventory[1].stackSize + stackSizeToDecrease > inventory[1].getMaxStackSize()) return false;
		int resultStack = inventory[1].stackSize + result.stackSize;
		return(resultStack <= inventoryClass.getInventoryStackLimit() && (resultStack <= result.getMaxStackSize()));
	}
}

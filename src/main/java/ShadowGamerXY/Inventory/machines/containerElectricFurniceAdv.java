package ShadowGamerXY.Inventory.machines;

import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurniceAdvanced;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.world.World;

public class containerElectricFurniceAdv extends Container
{
	public final EntityPlayer player;
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	private TileEntiyElectricFurniceAdvanced tile; 
	
	public static final int INPUT = 0, OUTPUT = 1;
	
	public containerElectricFurniceAdv(EntityPlayer player, World world, int x, int y, int z) 
	{
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.tile = (TileEntiyElectricFurniceAdvanced) world.getTileEntity(x, y, z);
		
		updateSlots();
	}
	
	public boolean canInteractWith(EntityPlayer player)
	{
		return tile.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
    {
    	ItemStack itemstack = null;
    	Slot slot = (Slot)this.inventorySlots.get(slotId);

    	if (slot != null && slot.getHasStack())
    	{
    	ItemStack itemstack1 = slot.getStack();
    	itemstack = itemstack1.copy();

    	// If itemstack is in Output stack
    	if (slotId == OUTPUT)
    	{
    	// try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
    	// so the last slot in the inventory won't get checked if you don't add 1
    	if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+36+1, true))
    	{
    	return null;
    	}

    	slot.onSlotChange(itemstack1, itemstack);
    	}
    	// itemstack is in player inventory, try to place in appropriate furnace slot
    	else if (slotId != INPUT)
    	{
    	// if it can be smelted, place in the input slots
    	if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
    	{
    	// try to place in either Input slot; add 1 to final input slot because mergeItemStack uses < index
    	if (!this.mergeItemStack(itemstack1, INPUT, INPUT+1, false))
    	{
    	return null;
    	}
    	}
    	// item in player's inventory, but not in action bar
    	else if (slotId >= OUTPUT+1 && slotId < OUTPUT+28)
    	{
    	// place in action bar
    	if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false))
    	{
    	return null;
    	}
    	}
    	// item in action bar - place in player inventory
    	else if (slotId >= OUTPUT+28 && slotId < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false))
    	{
    	return null;
    	}
    	}
    	// In one of the infuser slots; try to place in player inventory / action bar
    	else if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+37, false))
    	{
    	return null;
    	}

    	if (itemstack1.stackSize == 0)
    	{
    	slot.putStack((ItemStack)null);
    	}
    	else
    	{
    	slot.onSlotChanged();
    	}

    	if (itemstack1.stackSize == itemstack.stackSize)
    	{
    	return null;
    	}

    	slot.onPickupFromSlot(player, itemstack1);
    	}
    	return itemstack;
    }
	
	public void updateSlots()
	{
		this.inventorySlots.clear();
		
		this.addSlotToContainer(new Slot(tile, INPUT, 56, 35));
		
		this.addSlotToContainer(new SlotOutput(tile, player, OUTPUT, 116, 35));
		
		
		for(int i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 9; ++j)
			{
				this.addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 83 + i * 18 ));
			}
		}
		
		for(int i = 0; i < 9; ++i)
		{
			this.addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 141));
		}
	}
}

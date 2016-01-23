package ShadowGamerXY.Inventory.machines;

import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;


public class ContainerBasicGenerator extends Container
{
	public final EntityPlayer player;
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	private TileEntiyBasicGenerator tile;

	public ContainerBasicGenerator(EntityPlayer player, World world, int x, int y, int z)
	{

		
		
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		this.tile = (TileEntiyBasicGenerator) world.getTileEntity(x, y, z);
		
		updateSlots();

	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return true;
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slotID)
	{
		ItemStack stack = null;
		Slot currentSlot =(Slot)inventorySlots.get(slotID);
		
		if(currentSlot != null && currentSlot.getHasStack())
		{
			ItemStack slotStack = currentSlot.getStack();
			stack = slotStack.copy();
			
			if(TileEntityFurnace.isItemFuel(slotStack))
			{
				if(slotID != 0)
				{
					if(!mergeItemStack(slotStack, 0, 1, false))
					{
						return null;
					}
					else if(slotID == 0)
					{
						if(!mergeItemStack(slotStack, 1, inventorySlots.size(), true))
						{
							return null;
						}
					}
				}
				else
				{
					if(slotID  >= 1 && slotID <= 27)
					{
						if(!mergeItemStack(slotStack, 28, inventorySlots.size(), false))
						{
							return null;
						}
					}
					else if(slotID > 27)
					{
						if(!mergeItemStack(slotStack, 1, 27, false))
							{
								return null;
							}
						}
					
				else
				{
					 if(!mergeItemStack(slotStack, 1, inventorySlots.size(), true))
							 {
						 	return null;
							 }
						}
					}
				}
			
			if(slotStack.stackSize == 0)
			{
				currentSlot.putStack((ItemStack)null);
			}
			else
			{
				currentSlot.onSlotChanged();
			}
			if(slotStack.stackSize == stack.stackSize)
			{
				return null;
			}
			currentSlot.onPickupFromSlot(player, slotStack);
			}
			return stack;
		}
	
	
	/**
	 *  Slots of the container
	 */
		public void updateSlots()
	{
		this.inventorySlots.clear();
		
		this.addSlotToContainer(new Slot(tile, 0, 80, 61));

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

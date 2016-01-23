package ShadowGamerXY.TileEntitys;

import ShadowGamerXY.Utilitys.InventoryUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TilentityMachine extends TileEntity implements IInventory
{
	private ItemStack[] inventory = new ItemStack[18];
	public int rotation = 3;
	@Override
	public int getSizeInventory() {
		return InventoryUtil.getSizeInventory(inventory);
	}
	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return InventoryUtil.getStackInSlot(inventory, slot);
	}
	@Override
	public ItemStack decrStackSize(int slot, int count) 
	{
		return InventoryUtil.decrStackSize(inventory, slot, count);
	}
	@Override
	public ItemStack getStackInSlotOnClosing(int slot) 
	{
		return InventoryUtil.getStackInSlotOnClosing(inventory, slot);
	}
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) 
	{
		InventoryUtil.setInventorySlotContents(this, inventory, slot, stack);
	}
	@Override
	public String getInventoryName() 
	{
		return "container";
	}
	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return false;
	}
	@Override
	public void openInventory() {}
	@Override
	public void closeInventory() {}
	
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return false;
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		tag.setInteger("rotation", rotation);
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		rotation = tag.getInteger("rotation");
	}
}

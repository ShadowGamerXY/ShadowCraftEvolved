package ShadowGamerXY.TileEntitys.Storage;

import java.util.ArrayList;
import java.util.List;

import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.TileEntitys.TileEntitySCE;
import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityModularCrate extends TileEntitySCE implements ISidedInventory
{
	private ItemStack[] modularStacks = new ItemStack[27];
	public int direction;

	@Override
	public void writeToPacket(ByteBuf buf){
	    for(ItemStack stack : modularStacks)
	        ByteBufUtils.writeItemStack(buf, stack);
	}

	@Override
	public void readFromPacket(ByteBuf buf){
	    for(int i = 0; i < modularStacks.length; i++)
	        modularStacks[i] = ByteBufUtils.readItemStack(buf);
	    worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){
	    super.readFromNBT(tag);

	    modularStacks = new ItemStack[27];
	    NBTTagList camoStackTag = tag.getTagList("camoStacks", 10);

	    for(int i = 0; i < camoStackTag.tagCount(); i++) {
	        NBTTagCompound t = camoStackTag.getCompoundTagAt(i);
	        int index = t.getByte("index");
	        if(index >= 0 && index < modularStacks.length) {
	            modularStacks[index] = ItemStack.loadItemStackFromNBT(t);
	        }
	    }
	}

	@Override
	public void writeToNBT(NBTTagCompound tag){
	    super.writeToNBT(tag);

	    NBTTagList camoStackTag = new NBTTagList();
	    for(int i = 0; i < modularStacks.length; i++) {
	        ItemStack stack = modularStacks[i];
	        if(stack != null) {
	            NBTTagCompound t = new NBTTagCompound();
	            stack.writeToNBT(t);
	            t.setByte("index", (byte)i);
	            camoStackTag.appendTag(t);
	        }
	    }
	    tag.setTag("camoStacks", camoStackTag);
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory(){
	    return modularStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int slot){
	    return modularStacks[slot];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	@Override
	public ItemStack decrStackSize(int slot, int decreaseAmount){
	    if(modularStacks[slot] != null) {
	        ItemStack itemstack;

	        if(modularStacks[slot].stackSize <= decreaseAmount) {
	            itemstack = modularStacks[slot];
	            setInventorySlotContents(slot, null);
	            markDirty();
	            return itemstack;
	        } else {
	            itemstack = modularStacks[slot].splitStack(decreaseAmount);

	            if(modularStacks[slot].stackSize == 0) {
	                setInventorySlotContents(slot, null);
	            }

	            markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	@Override
	public ItemStack getStackInSlotOnClosing(int slot){
	    if(modularStacks[slot] != null) {
	        ItemStack itemstack = modularStacks[slot];
	        modularStacks[slot] = null;
	        return itemstack;
	    } else {
	        return null;
	    }
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	@Override
	public void setInventorySlotContents(int slot, ItemStack stack){
	    modularStacks[slot] = stack;

	    if(stack != null && stack.stackSize > getInventoryStackLimit()) {
	        stack.stackSize = getInventoryStackLimit();
	    }

	    markDirty();
	    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	/**
	 * Returns the name of the inventory
	 */
	@Override
	public String getInventoryName(){
	    return ModBlocks.ModularCrate.getUnlocalizedName() + ".name";
	}

	/**
	 * Returns if the inventory is named
	 */
	@Override
	public boolean hasCustomInventoryName(){
	    return false;
	}

	/**
	 * Returns the maximum stack size for a inventory slot.
	 */
	@Override
	public int getInventoryStackLimit(){
	    return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	@Override
	public boolean isUseableByPlayer(EntityPlayer player){
	    return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(){}

	@Override
	public void closeInventory(){}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
	 */
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack){
	   return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side){
	    return new int[]{side};
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack stack, int side){
	    return isItemValidForSlot(slot, stack);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_){
	    return true;
	}

}

package ShadowGamerXY.TileEntitys.Machines;
import ShadowGamerXY.Blocks.Machines.Infuser;
import ShadowGamerXY.CustomRecipes.InfuserRecipes;
import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.Init.ModItems;
import ShadowGamerXY.TileEntitys.TileEntitySCE;
import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.IEntityMultiPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class TileEntityInfuser extends TileEntitySCE implements ISidedInventory{

	private ItemStack[] infuserStacks = new ItemStack[4];
	public int dualPower;
	public int dualCookTime;
	public static final int maxPower = 10000;
	public static final int mashingSpeed = 50;
	private static int facing = 0;
	
	private static final int[] slots_top = new int[] {0, 1};
	private static final int[] slots_bottom = new int[] {3};
	private static final int[] slots_side = new int[] {2};

	public int direction;
	
	@Override
	public void writeToPacket(ByteBuf buf){
	    for(ItemStack stack : infuserStacks)
	        ByteBufUtils.writeItemStack(buf, stack);
	}

	
	public static int getFacingDireciton()
	{
		return facing;
	}   
	public static void setFacingDireciton(int side)
	{
		facing = side;
	}
	
	@Override
	public void readFromPacket(ByteBuf buf){
	    for(int i = 0; i < infuserStacks.length; i++)
	        infuserStacks[i] = ByteBufUtils.readItemStack(buf);
	    worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag){
	    super.readFromNBT(tag);
	    this.facing = tag.getInteger("facing");
	    infuserStacks = new ItemStack[10];
	    NBTTagList camoStackTag = tag.getTagList("camoStacks", 10);

	    for(int i = 0; i < camoStackTag.tagCount(); i++) {
	        NBTTagCompound t = camoStackTag.getCompoundTagAt(i);
	        int index = t.getByte("index");
	        if(index >= 0 && index < infuserStacks.length) {
	            infuserStacks[index] = ItemStack.loadItemStackFromNBT(t);
	        }
	    }
	    dualPower = tag.getShort("PowerTime");
		dualCookTime = tag.getShort("CookTime");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag){
	    super.writeToNBT(tag);
	    tag.setShort("PowerTime", (short)dualPower);
		tag.setShort("CookTime", (short)dualCookTime);
	    NBTTagList camoStackTag = new NBTTagList();
	    tag.setInteger("facing", (int)this.facing);
	    
	    for(int i = 0; i < infuserStacks.length; i++) {
	        ItemStack stack = infuserStacks[i];
	        if(stack != null) {
	            NBTTagCompound t = new NBTTagCompound();
	            stack.writeToNBT(t);
	            t.setByte("index", (byte)i);
	            camoStackTag.appendTag(t);
	        }
	    }
	    tag.setTag("camoStacks", camoStackTag);
	}
	
	public boolean hasItemPower(ItemStack itemstack) {
		return getItemPower(itemstack) > 0;
	}
	
	private static int getItemPower (ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if (item == Items.coal) return 800;
			if (item == Item.getItemFromBlock(Blocks.coal_block)) return 7200;
			if (item == Items.stick) return 10;
			if(item == ModItems.SamllEnergyCell) return 5000;

			
			return 0;
		}
	}
	
	public int getMasherProgressScaled(int i) {
		return (dualCookTime * i) / this.mashingSpeed;
	}
	
	public int getPowerRemainingScaled(int i) {
		return (dualPower * i) / maxPower;
	}
	
private boolean canMash() {
		
		if (infuserStacks[0] == null || infuserStacks[1] == null) {
			return false;
		}
		
		ItemStack itemstack = InfuserRecipes.getMashingResult(infuserStacks[0].getItem(), infuserStacks[1].getItem());
		
		if (itemstack == null) {
			return false;
		}
		
		if (infuserStacks[3] == null) {
			return true;
		}
		
		if (!infuserStacks[3].isItemEqual(itemstack)) {
			return false;
		}
		
		if (infuserStacks[3].stackSize < getInventoryStackLimit() && infuserStacks[3].stackSize < infuserStacks[3].getMaxStackSize()) {
			return true;
		}else{
			return infuserStacks[3].stackSize < itemstack.getMaxStackSize();
		}
	}
	
	private void mashItem() {
		if (canMash()) {
			ItemStack itemstack = InfuserRecipes.getMashingResult(infuserStacks[0].getItem(), infuserStacks[1].getItem());
			
			if (infuserStacks[3] == null) {
				infuserStacks[3] = itemstack.copy();
			}else if (infuserStacks[3].isItemEqual(itemstack)) {
				infuserStacks[3].stackSize += itemstack.stackSize;
			}
			
			for (int i = 0; i < 2; i++) {
				if (infuserStacks[i].stackSize <= 0) {
					infuserStacks[i] = new ItemStack(infuserStacks[i].getItem().setFull3D());
				}else{
					infuserStacks[i].stackSize--;
				}
				
				if (infuserStacks[i].stackSize <= 0){
					infuserStacks[i] = null;
				}
			}
		}
	}
	
	
	public boolean hasPower() {
		return dualPower > 0;
	}
	
	public boolean isMashing() {
		return this.dualCookTime > 0;
	}
	public void updateEntity() {
		boolean flag = this.hasPower();
		boolean flag1= false;
		
		if(hasPower() && this.isMashing()) {
			this.dualPower--;
		}
		
		if(!worldObj.isRemote) {
			if (this.hasItemPower(this.infuserStacks[2]) && this.dualPower < (this.maxPower - this.getItemPower(this.infuserStacks[2]))) {
				this.dualPower += getItemPower(this.infuserStacks[2]);
				
				if(this.infuserStacks[2] != null) {
					flag1 = true;
					
					this.infuserStacks[2].stackSize--;
					
					if(this.infuserStacks[2].stackSize == 0) {
						this.infuserStacks[2] = this.infuserStacks[2].getItem().getContainerItem(this.infuserStacks[2]);
					}
				}
			}
			
			if (hasPower() && canMash()) {
				dualCookTime++;
				
				if (this.dualCookTime == this.mashingSpeed) {
					this.dualCookTime = 0;
					this.mashItem();
					flag1 = true;
				}
			}else{
				dualCookTime = 0;
			}
			
			if (flag != this.isMashing()) {
				flag1 = true;
				Infuser.updateBlockState(this.isMashing(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		
		if (flag1) {
			this.markDirty();
		}
    }


	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory(){
	    return infuserStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	@Override
	public ItemStack getStackInSlot(int slot){
	    return infuserStacks[slot];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	@Override
	public ItemStack decrStackSize(int slot, int decreaseAmount){
	    if(infuserStacks[slot] != null) {
	        ItemStack itemstack;

	        if(infuserStacks[slot].stackSize <= decreaseAmount) {
	            itemstack = infuserStacks[slot];
	            setInventorySlotContents(slot, null);
	            markDirty();
	            return itemstack;
	        } else {
	            itemstack = infuserStacks[slot].splitStack(decreaseAmount);

	            if(infuserStacks[slot].stackSize == 0) {
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
	    if(infuserStacks[slot] != null) {
	        ItemStack itemstack = infuserStacks[slot];
	        infuserStacks[slot] = null;
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
	    infuserStacks[slot] = stack;

	    if(stack != null && stack.stackSize > getInventoryStackLimit()) {
	        stack.stackSize = getInventoryStackLimit();
	    }

	    markDirty();
	    worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	/**
	 * Returns the name of the inventory
	 **/
	@Override
	public String getInventoryName(){
	    return ModBlocks.Infuser.getUnlocalizedName() + ".name";
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

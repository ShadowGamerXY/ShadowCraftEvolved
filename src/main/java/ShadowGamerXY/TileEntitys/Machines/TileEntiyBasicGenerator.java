package ShadowGamerXY.TileEntitys.Machines;

import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.InventoryUtil;
import ShadowGamerXY.Utilitys.NBTUtil;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.EnergyNet;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntiyBasicGenerator extends TileEntity implements IEnergy,IInventory,ISidedInventory     
{
	private EnergyBar energyBar = new EnergyBar(4000);
	private ItemStack[] inventory = new ItemStack[7];
	public int burnTime;
	public int currentItemBurnTime;
	public int rotation = 3;
	private float modifier = 0.5F;
	private float defaultModifier = 10F;
	public int burnTimeRemuvedPerTick = 10;
	public int direction;
	
	public void updateEntity()
	{
		updateGenerating();
	}
	
	private void updateGenerating()
	{
		boolean modified = burnTime > 0;
		
		if(burnTime > 0)
		{
			if(burnTime > burnTimeRemuvedPerTick)
			{
				burnTime -= burnTimeRemuvedPerTick;
				energyBar.addEnergyWithRemaining(burnTimeRemuvedPerTick);
			}
			else
			{
				energyBar.addEnergyWithRemaining(burnTime);
				burnTime = 0;
			}
		}
		else if(burnTime > 0)
		{
			energyBar.addEnergyWithRemaining(burnTime);
			burnTime = 0;
		}
		
		if(burnTime == 0 && (TileEntityFurnace.isItemFuel(inventory[0]) || TileEntityFurnace.isItemFuel(inventory[5]) || TileEntityFurnace.isItemFuel(inventory[6])))
		{
			currentItemBurnTime = burnTime += (int) (TileEntityFurnace.getItemBurnTime(inventory[0]) * modifier) + (int) (TileEntityFurnace.getItemBurnTime(inventory[6]) * modifier);
			if(inventory[0] != null)
			{
				inventory[0].stackSize--;
				if(inventory[0].stackSize <= 0)
				{
					inventory[0] = null;
				}
			}
			if(inventory[5] != null)
			{
				inventory[5].stackSize--;
				if(inventory[5].stackSize <= 0)
				{
					inventory[5] = null;
				}
			}
			if(inventory[6] != null)
			{
				inventory[6].stackSize--;
				if(inventory[6].stackSize <= 0)
				{
					inventory[6] = null;
				}
			}
		}
		EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, energyBar);
		if(modified != burnTime > 0)
		{
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}
	
	/**
	 It says if we can add energy to this 'machine'. We return false because we want it to output energy not input it!
	 **/
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction)
	{
		return false;
	}
	
	/**
	 It says if we can connect to this 'machine'. It returns true beacuse we can/must connect.
	 **/
	@Override
	public boolean canConnect(ForgeDirection direction)
	{
		return true;
	}
	
	@Override
	public EnergyBar getEnergyBar()
	{
		return energyBar;
	}
	@Override
	public void setLastRecivedDirection(ForgeDirection direction)
	{
		
	}
	
	/**
	 * Here we tell how much energy is allowed to output at once!
	 */
	@Override
	public int getEnergyTransferRate()
	{
		return 2500;
	}
	
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	public void onDataPacket(NetworkManager maneger, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}
	
	@Override
	public int getSizeInventory()
	{
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
		return "container.powerGenerator";
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
		return true;
	}
	 
	@Override
	public void openInventory()
	{
		
	}
	
	@Override
	public void closeInventory()
	{
		
	}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		switch(slot)
		{
			case 0:
				return TileEntityFurnace.isItemFuel(itemstack);
		}
		return false;
	}
	
	public int getBurnTime()
	{
		return burnTime;
	}
	
	public boolean isBurning()
	{
		return burnTime > 0;
	}
	
	public int getBurnTimeScaled(int scale)
	{
		return burnTime * scale / currentItemBurnTime;
	}
	
	@Override
	public int[] getAccessibleSlotsFromSide(int slot)
	{
		return new int[] {0};
	}
	
	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side)
	{
		return isItemValidForSlot(slot, itemstack);
	}
	
	@Override 
	public boolean canExtractItem(int slot, ItemStack stack, int side)
	{
		return false;
	}
	
	@Override
	public BlockType getTypeOfBlock()
	{
		return BlockType.MACHINE;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
		tag.setInteger("rotation", rotation);
		tag.setInteger("burnTime", burnTime);
		tag.setInteger("currentItemBurnTime", currentItemBurnTime);
		NBTUtil.writeItemStackArrayToNBT(inventory, tag);	
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
		rotation = tag.getInteger("rotation");
		burnTime = tag.getInteger("burnTime");
		currentItemBurnTime = tag.getInteger("currentItemBurnTime");
		NBTUtil.readItemStackArrayFormNBT(inventory, tag);		
	}
	
}

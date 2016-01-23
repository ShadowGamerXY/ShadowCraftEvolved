package ShadowGamerXY.TileEntitys.Machines;

import ShadowGamerXY.CustomRecipes.InfuserRecipes;
import ShadowGamerXY.TileEntitys.TilentityMachine;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.InventoryUtil;
import ShadowGamerXY.Utilitys.MachineUtil;
import ShadowGamerXY.Utilitys.NBTUtil;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntiyElectricFurnice extends TileEntity implements IEnergy,IInventory
{
	private EnergyBar energyBar = new EnergyBar(4000);
	private ItemStack[] inventory = new ItemStack[18];
	private int energyUsePerSmelt = 150;
	private int defaultEnergyUsePerSmelt = 150;
	public boolean isSmelting;
	private int smeltStatus;
	private int smeltTime = 60;
	private int defaultSmeltTime = 60;
	public int rotation = 3;

	
	public void updateEntity()
	{
		updateSmelting();
	}
	
	private void updateSmelting()
	{
		boolean modified = isSmelting;
		
		this.isSmelting = canSmelt();
		
		if(this.isSmelting)
		{
			this.smeltStatus += 1;
		}
		else
		{
			this.smeltStatus = 0;
		}
		if(this.smeltStatus >= this.smeltTime)
		{
			smelt();
			this.smeltStatus = 0;
		}
		if(modified != isSmelting)
		{
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);	
		}
	}
	
	public boolean canSmelt()
	{
		if(inventory[0] == null) return false;
		return MachineUtil.canOperate(inventory, energyBar, FurnaceRecipes.smelting().getSmeltingResult(inventory[0]), this, energyUsePerSmelt, 1);
	}
	
	private void smelt()
	{
		MachineUtil.operate(inventory, energyBar,FurnaceRecipes.smelting().getSmeltingResult(inventory[0]), this, smeltStatus, isSmelting, energyUsePerSmelt, 1);
	}
	
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction)
	{
		return true;
	}
	
	@Override
	public boolean canConnect(ForgeDirection direction )
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
	
	@Override
	public int getEnergyTransferRate()
	{
		return 100;
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
		return "container.electricFurnice";
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
	{}
	@Override
	public void closeInventory()
	{}
	
	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack)
	{
		return true;
	}
	
	public int getCookProgresScaled(int scale)
	{
		return this.smeltStatus * scale / smeltTime;
	}
	
	@Override
	public BlockType getTypeOfBlock()
	{
		return BlockType.MACHINE;
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
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
		tag.setInteger("rotation", rotation);
		tag.setInteger("smeltStatus", smeltStatus);
		NBTUtil.writeItemStackArrayToNBT(inventory, tag);	
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
		rotation = tag.getInteger("rotation");
		smeltStatus = tag.getInteger("smeltStatus");
		NBTUtil.readItemStackArrayFormNBT(inventory, tag);		
	}
	
}

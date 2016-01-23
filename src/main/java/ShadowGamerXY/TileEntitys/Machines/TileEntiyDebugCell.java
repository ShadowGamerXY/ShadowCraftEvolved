package ShadowGamerXY.TileEntitys.Machines;

import ShadowGamerXY.TileEntitys.TilentityMachine;
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

public class TileEntiyDebugCell extends TileEntity implements IEnergy,IInventory
{
	private EnergyBar energyBar = new EnergyBar(1000000);
	private ItemStack[] inventory = new ItemStack[18];
	public int rotation = 3;

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
		return 1000;
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
		NBTUtil.writeItemStackArrayToNBT(inventory, tag);	
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
		rotation = tag.getInteger("rotation");
		NBTUtil.readItemStackArrayFormNBT(inventory, tag);		
	}
	
}

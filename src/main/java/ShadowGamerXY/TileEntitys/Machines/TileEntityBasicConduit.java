package ShadowGamerXY.TileEntitys.Machines;

import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.EnergyNet;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBasicConduit extends TileEntity implements IEnergy{
	public int direction;

	private ForgeDirection lastRecivedDirection = ForgeDirection.UNKNOWN;
	
	/**How much power it holds(with more cables the number gets bigger)**/
	private EnergyBar energyBar = new EnergyBar(500);
	
	public void updateEntity()
	{
		EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, lastRecivedDirection, energyBar);
	}
	
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction)
	{
		return true;
	}
	
	@Override
	public boolean canConnect(ForgeDirection direction)
	{
		return true;
	}
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSqared()
	{
		return Double.MAX_VALUE;
	}
	
	public AxisAlignedBB getRenderBoundingBox()
	{
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
	}
	
	public EnergyBar getEnergyBar()
	{
		return energyBar;
	}

	@Override
	public void setLastRecivedDirection(ForgeDirection direction) 
	{
		this.lastRecivedDirection = direction;	
	}
	
	public Packet getDescriptionPacket()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, zCoord,yCoord, 1,tag);
	}
	
	public void onDataPacket(NetworkManager maneger,S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}
	
	public void writeToNBT(NBTTagCompound tag)
	{
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
	}
	
	/**Put here how much energy can transfer**/
	@Override
	public int getEnergyTransferRate()
	{
		return 500;
	}

	@Override
	public BlockType getTypeOfBlock() {
		return BlockType.CABLE;
	}


	 
}

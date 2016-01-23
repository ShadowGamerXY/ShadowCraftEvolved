package ShadowGamerXY.TileEntitys.Machines;

import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.EnergyNet;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntiyCreativeEnergyCube extends TileEntity implements IEnergy
{
	
	private EnergyBar energyBar = new EnergyBar(5000000, true);
	
	public void updateEntity()
	{
		EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord,energyBar);
		energyBar.setEnergyLevel(energyBar.getMaxEnergyLevel());
	}

	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction)
	{
		return false;
	}

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
	public void setLastRecivedDirection(ForgeDirection directoion) 
	{
	}

	@Override
	public int getEnergyTransferRate() 
	{
		return energyBar.getMaxEnergyLevel();
	}

	@Override
	public BlockType getTypeOfBlock() 
	{
		return BlockType.MACHINE;
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
	
	public Packet getDiscriptionPacek()
	{
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord,yCoord,zCoord, 1, tag);
	}
	
	public void onDataPacket(NetworkManager maneger, S35PacketUpdateTileEntity packet)
	{
		readFromNBT(packet.func_148857_g());
	}

}

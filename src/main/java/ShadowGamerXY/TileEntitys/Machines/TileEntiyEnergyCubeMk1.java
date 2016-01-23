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

public class TileEntiyEnergyCubeMk1 extends TileEntity implements IEnergy
{
	private EnergyBar energyBar =  new EnergyBar(40000);
	public ForgeDirection outputSide = ForgeDirection.SOUTH;
	
	public void updateEntity()
	{
		EnergyNet.distributeEnergyToSide(worldObj, xCoord, yCoord, zCoord, outputSide, energyBar);
	}
	
	
	
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction) 
	{
		return direction != outputSide;
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
		return 100;
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
		tag.setInteger("outputSide", outputSide.ordinal());
	}
	
	public void readFromNBT(NBTTagCompound tag)
	{
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
		outputSide = ForgeDirection.getOrientation(tag.getInteger("outputSide"));
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

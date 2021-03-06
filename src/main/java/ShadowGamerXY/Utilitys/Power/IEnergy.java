package ShadowGamerXY.Utilitys.Power;

import ShadowGamerXY.Utilitys.BlockType;
import net.minecraftforge.common.util.ForgeDirection;

public interface IEnergy 
{
	public boolean canAddEnergyOnSide(ForgeDirection direction);
	public boolean canConnect(ForgeDirection direction);
	public EnergyBar getEnergyBar();
	public void setLastRecivedDirection(ForgeDirection directoion);
	public int getEnergyTransferRate();
	public BlockType getTypeOfBlock();
}

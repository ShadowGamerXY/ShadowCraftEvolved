package ShadowGamerXY.Utilitys.Power;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyNet 
{
	
	public static void distributeEnergyToSurrounding(World world, int x, int y, int z, ForgeDirection lastDirection, EnergyBar energyBar)
	{
		distributeEnergyToSurroundingWithLoss(world, x, y, z, lastDirection, energyBar, 0);
	}
	
	public static void distributeEnergyToSurrounding(World world, int x, int y, int z, EnergyBar energyBar)
	{
		distributeEnergyToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, energyBar);
	}
	
	public static void distributeEnergyToSide(World world, int x, int y,int z, ForgeDirection direction, EnergyBar energyBar)
	{
		if(world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy)
		{
			IEnergy energyTileOnSide = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
			IEnergy thisEnergyTile = (IEnergy) world.getTileEntity(x, y, z);
			ForgeDirection invertSides = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
			if(energyTileOnSide.canConnect(invertSides) && energyTileOnSide.canAddEnergyOnSide(invertSides))
			{
				if(energyBar.getEnergyLevel() - thisEnergyTile.getEnergyTransferRate() >= 0)
				{
					if(energyTileOnSide.getEnergyBar().canAddEnergy(thisEnergyTile.getEnergyTransferRate()))
					{
						energyTileOnSide.getEnergyBar().addEnergy(thisEnergyTile.getEnergyTransferRate());
						energyBar.removeEnergy(thisEnergyTile.getEnergyTransferRate());
					}
					else
					{
						int remainig = energyTileOnSide.getEnergyBar().addEnergyWithRemaining(thisEnergyTile.getEnergyTransferRate());
						energyBar.removeEnergy(thisEnergyTile.getEnergyTransferRate() - remainig);
					}
					energyTileOnSide.setLastRecivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
				}
			}
		}
	}
	
	
	public static void distributeEnergyToSurroundingWithLoss(World world, int x, int y,int z, ForgeDirection lastDirection, EnergyBar energyBar, int loss)
	{
		int sides = 0;
		boolean sidesCanOutput[] = new boolean[6];
		for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			if(world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy)
			{
				IEnergy energyTileNextToIt = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
				IEnergy thisEnergyTile = (IEnergy) world.getTileEntity(x, y, z);
				ForgeDirection invertSides = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
				if(thisEnergyTile.canConnect(invertSides) && energyTileNextToIt.canAddEnergyOnSide(invertSides) && direction != lastDirection)
				{
					sidesCanOutput[direction.ordinal()] = true;
					sides++;
				}
			}
		}
		
		for(ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
		{
			if(sidesCanOutput[direction.ordinal()] && direction != lastDirection)
			{
				IEnergy energyTile = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
				if(energyBar.getEnergyLevel() - energyTile.getEnergyTransferRate() / sides >= 0)
				{
					if(energyTile.getEnergyBar().canAddEnergy(energyTile.getEnergyTransferRate() / sides - loss))
					{
						energyTile.getEnergyBar().addEnergy(energyTile.getEnergyTransferRate() / sides - loss);
						energyBar.removeEnergy(energyTile.getEnergyTransferRate() / sides);
					}
					else
					{
						int remaining = energyTile.getEnergyBar().addEnergyWithRemaining(energyTile.getEnergyTransferRate() / sides - loss);
						energyBar.removeEnergy(energyTile.getEnergyTransferRate() / sides  - remaining);
					}
					energyTile.setLastRecivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
				}
			}
		}
	}
}

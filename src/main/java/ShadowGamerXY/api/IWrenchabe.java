package ShadowGamerXY.api;

import net.minecraft.world.World;

public interface IWrenchabe 
{
	public void wrenchRightClick(World world, int x, int y, int z);

	public void wrenchShiftRightClick(World world, int x, int y, int z);
}

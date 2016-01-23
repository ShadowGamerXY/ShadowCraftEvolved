package ShadowGamerXY.Blocks.MatalBlocks;

import ShadowGamerXY.Blocks.BlocksSCE;
import net.minecraft.world.IBlockAccess;

public class ZixiriumBlock extends BlocksSCE
{
	public ZixiriumBlock()
	{
		super();
		this.setBlockName("ZixiriumBlock");
		this.setHardness(5.0f);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	    {
	        return true;
	    }
}

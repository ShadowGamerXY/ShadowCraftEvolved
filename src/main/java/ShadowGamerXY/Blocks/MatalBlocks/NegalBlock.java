package ShadowGamerXY.Blocks.MatalBlocks;

import ShadowGamerXY.Blocks.BlocksSCE;
import ShadowGamerXY.Init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class NegalBlock extends BlocksSCE
{
	public NegalBlock()
	{
		super();
		this.setBlockName("NegalBlock");
		this.setHardness(5.0f);
	}
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
	    {
	        return true;
	    }
}

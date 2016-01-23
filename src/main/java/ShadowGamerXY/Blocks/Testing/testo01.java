package ShadowGamerXY.Blocks.Testing;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import ShadowGamerXY.Blocks.BlocksSCE;
import ShadowGamerXY.Init.ModBlocks;

public class testo01 extends BlocksSCE 
{
	public testo01()
	{
		super();
		this.setBlockName("test");
	}
	
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
	    {
		 if(world.isAirBlock(x, y+1, z)){
		 	world.setBlock(x, y+1, z, ModBlocks.testo01);
		 }
	        return true;
	    }
}

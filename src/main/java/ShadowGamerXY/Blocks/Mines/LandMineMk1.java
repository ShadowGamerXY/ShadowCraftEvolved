package ShadowGamerXY.Blocks.Mines;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk1;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class LandMineMk1 extends BlockSCETileEntity
{
	public LandMineMk1()
	{
		super();
		this.setBlockName("LandMine");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityLandMineMk1();
	}
}

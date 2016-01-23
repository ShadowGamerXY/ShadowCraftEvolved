package ShadowGamerXY.Blocks.Storage;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk3;
import ShadowGamerXY.Utilitys.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BasicCrateMk3	extends BlockSCETileEntity 
{
	
	public BasicCrateMk3()
	{
		super();
		this.setBlockName("BasicCrateMk3");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityBasicCrateMk3();
	}
	
	
	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	        if(!world.isRemote) {
	        	
	        	TileEntityBasicCrateMk3 storage = (TileEntityBasicCrateMk3)world.getTileEntity(x, y, z);
	        	TileEntityBasicCrateMk3 master = storage.getMaster();
	            LogHelper.info("master storage:");
	            for(int i = 0; i < master.getSizeInventory(); i++) {
	            }
	           
	        }
	        return true;
	    }
	 

}

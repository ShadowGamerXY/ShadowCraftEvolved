package ShadowGamerXY.Blocks.Storage;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk4;
import ShadowGamerXY.Utilitys.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BasicCrateMk4	extends BlockSCETileEntity 
{
	
	public BasicCrateMk4()
	{
		super();
		this.setBlockName("BasicCrateMk4");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityBasicCrateMk4();
	}
	
	
	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	        if(!world.isRemote) {
	        	
	        	TileEntityBasicCrateMk4 storage = (TileEntityBasicCrateMk4)world.getTileEntity(x, y, z);
	        	TileEntityBasicCrateMk4 master = storage.getMaster();
	            LogHelper.info("master storage:");
	            for(int i = 0; i < master.getSizeInventory(); i++) {
	            }
	           
	        }
	        return true;
	    }

}

package ShadowGamerXY.Blocks.Storage;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrate;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk2;
import ShadowGamerXY.Utilitys.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BasicCrateMk2	extends BlockSCETileEntity 
{
	
	public BasicCrateMk2()
	{
		super();
		this.setBlockName("BasicCrateMk2");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityBasicCrateMk2();
	}
	
	
	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	        if(!world.isRemote) {
	        	
	        	TileEntityBasicCrateMk2 storage = (TileEntityBasicCrateMk2)world.getTileEntity(x, y, z);
	        	TileEntityBasicCrateMk2 master = storage.getMaster();
	            LogHelper.info("master storage:");
	            for(int i = 0; i < master.getSizeInventory(); i++) {
	            }
	           
	        }
	        return true;
	    }
     
}

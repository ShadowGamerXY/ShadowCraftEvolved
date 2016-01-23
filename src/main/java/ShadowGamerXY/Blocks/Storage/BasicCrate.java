package ShadowGamerXY.Blocks.Storage;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrate;
import ShadowGamerXY.Utilitys.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BasicCrate	extends BlockSCETileEntity 
{
	public IIcon Side0;
	public IIcon Side1;
	
	public BasicCrate()
	{
		super();
		this.setBlockName("BasicCrate");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityBasicCrate();
	}
	
	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(int side, int meta)
	    {
	    
	    	if(side == 0)
	    	{
	    		return Side0;
	    	}
	    	else if(side == 1)
	    	{
	       return Side0;
	    	}
	    	else if(side == 2)
	    	{
	       return Side1;
	    	}
	    	else if(side == 3)
	    	{
	       return Side1;
	    	}
	    	else if(side == 4)
	    	{
	       return Side1;
	    	}
	    	else if(side == 5)
	    	{
	       return Side1;
	    	}
	    	return null;
	    }
	 
	 public void registerBlockIcons(IIconRegister iconregiser)
		{
		 Side0 = iconregiser.registerIcon(references.MOD_ID + ":BasicCrate_Top");
		 Side1 = iconregiser.registerIcon(references.MOD_ID + ":BasicCrate");
		}
	 
	
	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	        if(!world.isRemote) {
	        	
	        	TileEntityBasicCrate storage = (TileEntityBasicCrate)world.getTileEntity(x, y, z);
	        	TileEntityBasicCrate master = storage.getMaster();
	            LogHelper.info("master storage:");
	            for(int i = 0; i < master.getSizeInventory(); i++) {
	                LogHelper.info(i + ", " + master.getStackInSlot(i));
	            }
	           
	        }
	        return true;
	    }
	
}

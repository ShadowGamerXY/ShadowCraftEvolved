package ShadowGamerXY.Blocks.TreeFarm;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.TileEntityTreeFarm;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class FarmCore extends BlockSCETileEntity{

	public IIcon Side0;
	public IIcon Side1;
	
	
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
	 Side1 = iconregiser.registerIcon(references.MOD_ID + ":FarmCore");
	}
 
	
	
	
	
	public FarmCore(){
        this.setBlockName("TreeFarmCore");
        this.setHardness(5.0f);
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_){
        return new TileEntityTreeFarm();
    }
}

package ShadowGamerXY.Blocks.Storage;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrate;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import ShadowGamerXY.Utilitys.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModularCrate extends BlockSCETileEntity{

	public IIcon Side0;
	public IIcon Side1;
	
	
	public ModularCrate()
	{
		super();
		this.setBlockName("ModularCrate");
		this.setResistance(17.0f);
	}
	 public int getRenderType() {
			return -1;
		}
		
		public boolean isOpaqueCube() {
			return false;
		}
		
		public boolean renderAsNormalBlock() {
			return false;
		}

		@Override
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
		{
		if (entity == null)
		{
		return;
		}

		TileEntityModularCrate tile = (TileEntityModularCrate) world.getTileEntity(x, y, z);
		tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}



			
			
			
		
		
		private void setDefaultDirection(World world, int x, int y, int z) {
			if(!world.isRemote) {
				Block b1 = world.getBlock(x, y, z - 1);
				Block b2 = world.getBlock(x,  y,  z + 1);
				Block b3 = world.getBlock(x - 1, y, z);
				Block b4  = world.getBlock(x + 1, y, z);
				
				byte b0 = 3;
				
				if(b1.func_149730_j() && !b2.func_149730_j()) {
					b0 = 3;	
				}
				
				if(b2.func_149730_j() && !b1.func_149730_j()) {
					b0 = 2;	
				}
				
				if(b3.func_149730_j() && !b4.func_149730_j()) {
					b0 = 5;	
				}
				
				if(b4.func_149730_j() && !b3.func_149730_j()) {
					b0 = 4;	
				}
				
				world.setBlockMetadataWithNotify(x, y, x, b0, 2);
			}
			
		}
	
	/*@SideOnly(Side.CLIENT)
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
	 Side1 = iconregiser.registerIcon(references.MOD_ID + ":ModularCrate");
	}
 */
	

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityModularCrate();
	}
	
	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
	        if(!world.isRemote) {
	        		player.openGui(ShadowCraftEvolved.instance, IDs.GuiIDs.ModularCrate.ordinal(), world, x, y, z);
	        }else{
	        	TileEntityModularCrate te = (TileEntityModularCrate)world.getTileEntity(x, y, z);
	        }
	        return true;
	    }
	

}

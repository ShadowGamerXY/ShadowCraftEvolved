package ShadowGamerXY.Blocks.Machines;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
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

public class Infuser extends BlockSCETileEntity{
	
	private static boolean keepInventory = true;
	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;
	public IIcon Side3;
	public IIcon Side4;
	public IIcon Side5;
	
	

	
	 public Infuser() {
		super();
		this.setBlockName("Infuser");
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
	       return Side3;
	    	}
	    	else if(side == 4)
	    	{
	       return Side2;
	    	}
	    	else if(side == 5)
	    	{
	       return Side2;
	    	}
	    	return null;
	    }
	 
	 public void registerBlockIcons(IIconRegister iconregiser)
		{
		 Side0 = iconregiser.registerIcon(references.MOD_ID + ":BasicCrate_Top");
		 Side1 = iconregiser.registerIcon(references.MOD_ID + ":Infuser");
		 Side2 = iconregiser.registerIcon(references.MOD_ID + ":MachineSide");
		 Side3 = iconregiser.registerIcon(references.MOD_ID + ":MachineBack");
		}*/
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

		TileEntityInfuser tile = (TileEntityInfuser) world.getTileEntity(x, y, z);
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
	

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityInfuser();
	}

	 @Override
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		 if(!world.isRemote) {	
	        		player.openGui(ShadowCraftEvolved.instance, IDs.GuiIDs.Infuser.ordinal(), world, x, y, z);
	        }else{
	        	TileEntityInfuser te = (TileEntityInfuser)world.getTileEntity(x, y, z);
	        }
	        return true;
	    }
	 public TileEntity getBlockEntity(int meta)
	    {
	        switch(meta)
	        {    
	        case 0: return new TileEntityInfuser();
	        }
			return null;
	    }
	 
	 
	public static void updateBlockState(boolean isMashing, World world, int xCoord, int yCoord, int zCoord) {
			
			int i = world.getBlockMetadata(xCoord, yCoord, zCoord);
			TileEntity entity = world.getTileEntity(xCoord, yCoord, zCoord);
			keepInventory = true;
			
			if (isMashing) {
				world.setBlock(xCoord, yCoord, zCoord, ModBlocks.Infuser);
			}else{
				world.setBlock(xCoord, yCoord, zCoord, ModBlocks.Infuser);
			}
			
			keepInventory = true;
			world.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);
			
			if (entity != null) {
				entity.validate();
				world.setTileEntity(xCoord, yCoord, zCoord, entity);
			}
		}
	
    
}

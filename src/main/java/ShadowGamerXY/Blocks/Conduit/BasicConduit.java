package ShadowGamerXY.Blocks.Conduit;


import java.util.List;

import ShadowGamerXY.TileEntitys.Machines.TileEntityBasicConduit;
import ShadowGamerXY.TileEntitys.Machines.TileEntityBasicConduitMk2;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import ShadowGamerXY.Utilitys.DropInventroy;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import ShadowGamerXY.api.IWrenchabe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BasicConduit extends BlockContainer implements IWrenchabe
{
	
	public BasicConduit() 
	{
		super(Material.iron);
		this.setBlockName("BasicConduit");
		this.setCreativeTab(CreativeTabsSCE.Machine_TAB);
		this.setHardness(5000.0f);
	}
	
	  public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
	    {
	        int meta = world.getBlockMetadata(x, y, z);
	        boolean[] blockBounds = new boolean[6];
	        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
	        {
	            blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy && ((IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ)).canConnect(direction);
	        }
	        if (meta <= 2) this.setBlockBounds(blockBounds[4] ? 0 : 0.375F, blockBounds[0] ? 0 : 0.375F, blockBounds[2] ? 0 : 0.375F, blockBounds[5] ? 1 : 0.625F, blockBounds[1] ? 1 : 0.625F, blockBounds[3] ? 1 : 0.625F);
	    }
	   
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	    {
	        int meta = world.getBlockMetadata(x, y, z);
	        boolean[] blockBounds = new boolean[6];
	        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
	        {
	            blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy && ((IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ)).canConnect(direction);
	        }
	        if (meta == 0) return AxisAlignedBB.getBoundingBox(x + (blockBounds[4] ? 0 : 0.375F), y + (blockBounds[0] ? 0 : 0.375F), z + (blockBounds[2] ? 0 : 0.375F), x + (blockBounds[5] ? 1 : 0.625F), y + (blockBounds[1] ? 1 : 0.625F), z + (blockBounds[3] ? 1 : 0.625F));
	        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
	    }
	   
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	   
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	   
	    public TileEntity createNewTileEntity(World world, int meta)
	    {
	        switch (meta)
	        {
	            case 0:
	                return new TileEntityBasicConduit();
	            case 1:
	            	return new TileEntityBasicConduitMk2();
	        }
	        return null;
	    }
	   
	    public boolean hasTileEntity(int meta)
	    {
	        return meta <= 1;
	    }
	   
	    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side)
	    {
	        return false;
	    }
	   
	    public void getSubBlocks(Item item, CreativeTabs tab, List list)
	    {
	        list.add(new ItemStack(this, 1, 0));
	        list.add(new ItemStack(this, 1, 1));
	    }
	
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
	{
	if (entity == null)
	{
	return;
	}

	TileEntityBasicConduit tile = (TileEntityBasicConduit) world.getTileEntity(x, y, z);
	
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
	public void wrenchRightClick(World world, int x, int y, int z) {
	}

	@Override
	public void wrenchShiftRightClick(World world, int x, int y, int z) 
	{
		if(!world.isRemote && world.getTileEntity(x, y, z) != null)
		{
			ItemStack stack =  new ItemStack(Item.getItemFromBlock(this));
			
			DropInventroy.dropInventory(world, x, y, z);
			world.setBlockToAir(x, y, z);
			world.removeTileEntity(x,y,z);
			world.notifyBlockChange(x, y, z, this);
			dropBlockAsItem(world, x, y, z, stack);
		}
	}




}

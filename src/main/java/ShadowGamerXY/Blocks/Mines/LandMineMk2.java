package ShadowGamerXY.Blocks.Mines;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk2;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LandMineMk2 extends BlockSCETileEntity 
{
	public LandMineMk2()
	{
		super();
		this.setBlockName("LandMineMk2");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityLandMineMk2();
	}
	
	
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
	 {
		 if(!world.isRemote){
		 TileEntityLandMineMk2 te = (TileEntityLandMineMk2)world.getTileEntity(x, y, z);
		 if(te.getCamouflage() != null)
		 {
			 ItemStack camoStack = te.getCamouflage();
			 te.setCamouflage(null);
			 EntityItem itemEntity = new EntityItem(world, x,y,z, camoStack);
			 world.spawnEntityInWorld(itemEntity);
		 }
		 else {
			 ItemStack playerItem = entityPlayer.getCurrentEquippedItem();
		 
		 if(playerItem !=null)
			 {
			ItemStack camoStack = playerItem.splitStack(1);
			te.setCamouflage(camoStack);
		 	}
		 	}
		 }
		 return true;
	 }
	 
	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	    {
		 TileEntityLandMineMk2 te = (TileEntityLandMineMk2)world.getTileEntity(x, y, z);
		 ItemStack stack = te.getCamouflage();
		 if(stack != null && stack.getItem() instanceof ItemBlock)
		 {
			 Block block = ((ItemBlock)stack.getItem()).field_150939_a;
			 return block.getIcon(side, stack.getItemDamage());
		 }
		 else
		 {
			 return super.getIcon(world, x, y, z, side);
		 }
	    }
}

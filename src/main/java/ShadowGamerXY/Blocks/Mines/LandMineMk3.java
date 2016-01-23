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
import ShadowGamerXY.Init.ModItems;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LandMineMk3 extends BlockSCETileEntity
{
	public LandMineMk3()
	{
		super();
		this.setBlockName("LandMineMk3");
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntityLandMineMk3();
	}
	
	
	 public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
	 {
		if(!world.isRemote){
		if(entityPlayer.isSneaking())	
			entityPlayer.openGui(ShadowCraftEvolved.instance, IDs.GuiIDs.Land_Mine.ordinal(), world, x, y, z);
		
			 TileEntityLandMineMk3 te = (TileEntityLandMineMk3)world.getTileEntity(x, y, z);
		 if(te.getCamouflage(side) != null)
		 {
			 ItemStack camoStack = te.getCamouflage(side);
			 te.setCamouflage(null, side);
			 EntityItem itemEntity = new EntityItem(world, x,y,z, camoStack);
			 world.spawnEntityInWorld(itemEntity);
		 }
		 else {
			 ItemStack playerItem = entityPlayer.getCurrentEquippedItem();
		 
		 if(playerItem !=null)
			 {
			ItemStack camoStack = playerItem.splitStack(1);
			te.setCamouflage(camoStack, side);
		 	}
		 	}
		 }
		
		 return true;
	 }
	 
	 @SideOnly(Side.CLIENT)
	    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	    {
		 TileEntityLandMineMk3 te = (TileEntityLandMineMk3)world.getTileEntity(x, y, z);
		 ItemStack stack = te.getCamouflage(side);
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

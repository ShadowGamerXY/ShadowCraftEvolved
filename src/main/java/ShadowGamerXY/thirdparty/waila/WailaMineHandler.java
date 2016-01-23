package ShadowGamerXY.thirdparty.waila;

import java.util.List;

import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class WailaMineHandler implements IWailaDataProvider {

	@Override
	public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config) {
		TileEntityLandMineMk3 te = (TileEntityLandMineMk3)accessor.getTileEntity();		
		int side = accessor.getSide().ordinal();
		ItemStack stack = te.getCamouflage(side);
		 if(stack != null && stack.getItem() instanceof ItemBlock)
		 {
			return stack;
		 }
		 else
		 {
			 return new ItemStack(ModBlocks.LandMineMk3);
		 }
	}

	@Override
	public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
			return currenttip;
	}

	@Override
	public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) 
	{
		NBTTagCompound tag = accessor.getNBTData();
			String target = tag.getString("target");
			
			if(!target.equals("")) {
	            currenttip.add(I18n.format("sce.waila.LandMine.target") + " " + EnumChatFormatting.RED + target);
	        }
	        int timer = tag.getInteger("timer");
	        if(timer == 0) {
	            currenttip.add(I18n.format("sce.waila.LandMine.primed"));
	        } else if(timer == -1) {
	            currenttip.add(I18n.format("sce.waila.LandMine.notPrimed"));
	        } else {
	            currenttip.add(I18n.format("sce.waila.LandMine.primingIn") + " " + timer);
	        }
	        return currenttip;
	}

	@Override
	public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
			return currenttip;
	}

	@Override
	public NBTTagCompound getNBTData(EntityPlayerMP player, TileEntity te, NBTTagCompound tag, World world, int x,  int y, int z) {
		TileEntityLandMineMk3 tile = (TileEntityLandMineMk3)te;
		tag.setString("target", tile.getTarget());
		tag.setInteger("timer", tile.getTimer());
		return tag;
	}

}

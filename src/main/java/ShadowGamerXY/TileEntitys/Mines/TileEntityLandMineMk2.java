package ShadowGamerXY.TileEntitys.Mines;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;

import java.util.List;

import ShadowGamerXY.TileEntitys.TileEntitySCE;
import ShadowGamerXY.Utilitys.LogHelper;

import com.jcraft.jogg.Packet;

import cpw.mods.fml.common.network.ByteBufUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLandMineMk2 extends TileEntitySCE 
{
	private int timer = 60;
	private ItemStack camoStack;
	
	
	@Override
	public void updateEntity()
	{
		if(timer > 0)timer--;
		if(timer == 0 && !worldObj.isRemote)
		{
			List<Entity> entitys = worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.getBoundingBox(xCoord -1, yCoord -1, zCoord -1, xCoord +2, yCoord +2, zCoord +2));
			if(entitys.size() > 0){
			worldObj.createExplosion(null, xCoord +0.5, yCoord +0.5, zCoord +0.5, 5.0F, true);
			}
		}
	}
	
	public void setCamouflage(ItemStack stack)
	{
		camoStack = stack;
		worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}
	
	public ItemStack getCamouflage()
	{
		return camoStack;
	}
	
	
	public void writeToPacket(ByteBuf buf)
	{
		ByteBufUtils.writeItemStack(buf, camoStack);
		LogHelper.info("writting to packet!");
	}
	
	public void readFromPacket(ByteBuf buf)
	{
		camoStack = ByteBufUtils.readItemStack(buf);
		LogHelper.info("reading from packet!");
		worldObj.markBlockRangeForRenderUpdate(xCoord, yCoord, zCoord, xCoord, yCoord, zCoord);
	}

	
	 public void readFromNBT(NBTTagCompound tag)
	    {
		 super.readFromNBT(tag);
		 timer = tag.getInteger("timer");	
		 
		 if(tag.hasKey("camoStack"))
		 {
			 camoStack = ItemStack.loadItemStackFromNBT(tag.getCompoundTag("camoStack"));
		 }
		 else
		 {
			 camoStack = null;
		 }
	    }	

	 public void writeToNBT(NBTTagCompound tag)
	    {
	        super.writeToNBT(tag);
	        tag.setInteger("timer", timer);
	        if( camoStack != null)
	        {
	        NBTTagCompound t = new NBTTagCompound();
	        camoStack.writeToNBT(t);
	        tag.setTag("camoStack", t);
	        }
	    }

}

package ShadowGamerXY.TileEntitys.Mines;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityLandMineMk1 extends TileEntity {

	private int timer = 60;

		@Override
		public void updateEntity()
		{
			if(timer > 0)timer--;
			if(timer == 0 && !worldObj.isRemote)
			{
				List<Entity> entitys = worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox(xCoord -1, yCoord -1, zCoord -1, xCoord +2, yCoord +2, zCoord +2));
				if(entitys.size() > 0){
				worldObj.createExplosion(null, xCoord +0.5, yCoord +0.5, zCoord +0.5, 4.0F, true);
				}
			}
		}
		
		 public void readFromNBT(NBTTagCompound tag)
		    {
			 super.readFromNBT(tag);
			 timer = tag.getInteger("timer");	
		    }	

		 public void writeToNBT(NBTTagCompound tag)
		    {
		        super.writeToNBT(tag);
		        tag.setInteger("timer", timer);
		    }

}

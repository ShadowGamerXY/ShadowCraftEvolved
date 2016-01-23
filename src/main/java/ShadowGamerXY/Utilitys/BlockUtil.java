package ShadowGamerXY.Utilitys;

import codechicken.lib.math.MathHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class BlockUtil 
{
	public static int determineMetadataBasedOnPlayerOrientation(EntityLivingBase player)
	{
		int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0f) + 0.5f) &3;
		if(rotation == 0)
		{
			return 2;
		}
		if(rotation == 1)
		{
			return 5;
		}
		if(rotation == 2)
		{
			return 3;
		}
		if(rotation == 3)
		{
			return 4;
		}
		return 3;
	}
	
}

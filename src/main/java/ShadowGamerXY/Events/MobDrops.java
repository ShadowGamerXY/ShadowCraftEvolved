package ShadowGamerXY.Events;

import java.util.Random;

import ShadowGamerXY.Init.ModItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDrops 
{
	
	public Random r = new Random();
	
	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		if (event.entity instanceof EntityMob)
		{
			if(r.nextInt(100)<55)
			{
				event.drops.clear();
	 
				ItemStack stack = new ItemStack(ModItems.BloodShard);
				EntityItem drop = new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, event.entity.posZ, stack);
	 
				event.drops.add(drop);
			}
		}
	}
}

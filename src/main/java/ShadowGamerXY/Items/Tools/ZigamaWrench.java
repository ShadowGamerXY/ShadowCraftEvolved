package ShadowGamerXY.Items.Tools;

import ShadowGamerXY.Items.ItemsSCE;
import ShadowGamerXY.api.IWrenchabe;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.common.util.RotationHelper;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import scala.xml.dtd.impl.NondetWordAutom;

public class ZigamaWrench extends ItemsSCE
{
	public ZigamaWrench() 
	{
		this.setUnlocalizedName("ZigmaWrench");
		this.setMaxStackSize(1);
		setHarvestLevel("wrentch", 0);
		setFull3D();
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int hitSide, float hitX, float hitY, float hitZ)
	{
		Block block = world.getBlock(x, y, z);
		if(block ==  null)
		{
			return false;
		}
		
		PlayerInteractEvent event = new PlayerInteractEvent(player, Action.RIGHT_CLICK_BLOCK, x, y, z, hitSide, world);
		if(MinecraftForge.EVENT_BUS.post(event) || event.getResult() == Result.DENY || event.useBlock == Result.DENY || event.useItem ==  Result.DENY)
		{
			return false;
		}
		
		if(block instanceof IWrenchabe)
		{
			if(player.isSneaking())
			{
				((IWrenchabe) block).wrenchShiftRightClick(world, x, y, z);
			}
			else
			{
				((IWrenchabe)block).wrenchRightClick(world, x, y, z);
			}
			
			player.swingItem();
			return !world.isRemote;		
		}
		else
		{
			player.swingItem();
			return RotationHelper.rotateVanillaBlock(block, world, x, y, z, ForgeDirection.getOrientation(hitSide));
		}
	}
}

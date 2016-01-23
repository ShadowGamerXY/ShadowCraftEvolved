package ShadowGamerXY.Items.Tools.Wands;

import java.util.List;

import ShadowGamerXY.Items.ItemsSCE;
import ShadowGamerXY.Utilitys.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BasicSepter extends ItemsSCE
{
	public BasicSepter()
	{
		this.setUnlocalizedName("BasicSepter");
		this.isFull3D();
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) 
	{

		if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) 
		{
			list.add(StringHelper.shiftForDetails());
		}
		if (!StringHelper.isShiftKeyDown()) {
			return;
		}
		list.add("Basic.");
		list.add(StringHelper.getInfoText("shadowInfo.Septer")); 
	}
}

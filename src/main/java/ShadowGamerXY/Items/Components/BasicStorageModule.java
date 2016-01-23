package ShadowGamerXY.Items.Components;

import java.awt.List;

import ShadowGamerXY.Items.ItemsSCE;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class BasicStorageModule extends ItemsSCE {

	public BasicStorageModule()
	{
		super();
		this.setUnlocalizedName("BasicStorageModule");
	}
	
	public void addInformation(ItemStack itemstack, EntityPlayer player, List descriptiveList, boolean B)
	{
		 descriptiveList.add("Decorative Block");
	}
}

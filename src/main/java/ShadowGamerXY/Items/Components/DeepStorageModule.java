package ShadowGamerXY.Items.Components;

import java.util.List;

import ShadowGamerXY.Items.ItemsSCE;
import ShadowGamerXY.Utilitys.StringHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class DeepStorageModule extends ItemsSCE
{
	public DeepStorageModule(){
		super();
		this.setUnlocalizedName("DeepStorageModule");
		}
	@Override
	public EnumRarity getRarity(ItemStack stack)
	{
		return EnumRarity.rare;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean check) {

		if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
			list.add(StringHelper.shiftForDetails());
		}
		if (!StringHelper.isShiftKeyDown()) {
			return;
		}
		list.add(StringHelper.getInfoText("shadowInfo.DeepStorage")); 
	}
	
	
}


package ShadowGamerXY.Items.Components.Core;

import ShadowGamerXY.Items.ItemsSCE;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class MatrixCore	extends ItemsSCE{

		public MatrixCore()
		{
			super();
			this.setUnlocalizedName("MatrixCore");
		}
		
		@Override
		public EnumRarity getRarity(ItemStack stack)
		{
			return EnumRarity.uncommon;
		}
}

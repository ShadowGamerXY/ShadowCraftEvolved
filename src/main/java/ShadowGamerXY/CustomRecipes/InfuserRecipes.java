package ShadowGamerXY.CustomRecipes;

import ShadowGamerXY.Init.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class InfuserRecipes {
	public static ItemStack getMashingResult(Item item, Item item2) {
		return getOutput(item, item2);
	}
	
	public static ItemStack getOutput(Item item, Item item2) {
		//Recipe One
		if (item == Items.coal && item2 == Items.iron_ingot || item == Items.iron_ingot && item2 == Items.coal) {
			return new ItemStack(ModItems.ingotCopper, 1);
		}
		if (item == item.getItemFromBlock(Blocks.coal_block) && item2 == item.getItemFromBlock(Blocks.iron_block)|| item == item.getItemFromBlock(Blocks.iron_block) && item2 == item.getItemFromBlock(Blocks.coal_block)) {
			return new ItemStack(ModItems.ingotCopper, 9);
		}
		
		return null;
	}
}

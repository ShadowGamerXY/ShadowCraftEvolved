package ShadowGamerXY.Utilitys;

import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.Init.ModItems;
import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelHandler implements IFuelHandler
{

	@Override
	public int getBurnTime(ItemStack fuel) 
	{
		Block blockFuel = Block.getBlockFromItem(fuel.getItem());
        Item itemFuel = fuel.getItem();
        
        if (blockFuel == ModBlocks.testo01)
        {
            return 40;
        }else if (itemFuel == ModItems.BloodShard)
        {
            return 40;
        }else{
		return 0;        
		}
	}

}

package ShadowGamerXY.References;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class materials {
	public static final class Tools
    {
        public static final Item.ToolMaterial NegalIron = EnumHelper.addToolMaterial(references.Materials.NegalIron,  3, 2000, 11.0f, 4.5f, 10);
        public static final Item.ToolMaterial Reinforced = EnumHelper.addToolMaterial(references.Materials.Reinforced,  3, 5000, 16.0f, 6.6f, 10);
        

    }
	
	 public static final class Armor
	    {
	        public static final ItemArmor.ArmorMaterial Negal = EnumHelper.addArmorMaterial(references.Materials.NegalIron, 1000, new int[]{3, 10, 6, 3}, 0);

	    }

}

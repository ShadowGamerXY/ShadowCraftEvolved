package ShadowGamerXY.Utilitys;

import ShadowGamerXY.Init.ModItems;
import ShadowGamerXY.References.references;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsSCE {
	
	int tabIndex;
	
	public static final CreativeTabs SCE_TAB = new CreativeTabs(references.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.DireSword;
		}
	};
	
	public static final CreativeTabs Machine_TAB = new CreativeTabs("Machines")
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.IronGear;
		}
	};

}

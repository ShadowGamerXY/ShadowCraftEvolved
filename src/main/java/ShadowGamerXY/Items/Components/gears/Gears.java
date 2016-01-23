package ShadowGamerXY.Items.Components.gears;

import java.util.List;

import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class Gears extends Item
{
	public IIcon[] icons = new IIcon[4];
	
	public Gears(String unlocalizedName) 
	{
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(CreativeTabsSCE.Machine_TAB);
		this.setHasSubtypes(true);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
	    for (int i = 0; i < 4; i ++) {
	        this.icons[i] = reg.registerIcon(references.MOD_ID + ":Gear_" + i);
	    }
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
	    if (meta > 4)
	        meta = 0;

	    return this.icons[meta];
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
	    for (int i = 0; i < 4; i ++) {
	        list.add(new ItemStack(item, 1, i));
	    }
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
	    return this.getUnlocalizedName() + "_" + stack.getItemDamage();
	}

}

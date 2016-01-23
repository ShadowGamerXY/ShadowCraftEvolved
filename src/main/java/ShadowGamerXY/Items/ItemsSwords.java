package ShadowGamerXY.Items;

import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public abstract class ItemsSwords extends ItemSword
{
	
	public ItemsSwords(ToolMaterial material) {
		super(material);
		this.setCreativeTab(CreativeTabsSCE.SCE_TAB);
	}
	
	@Override
	public String getUnlocalizedName()
	{
	 return String.format("item.%s%s", references.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
@Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", references.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }
@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister)
{
    itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
}

protected String getUnwrappedUnlocalizedName(String unlocalizedName)
{
    return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
}

}

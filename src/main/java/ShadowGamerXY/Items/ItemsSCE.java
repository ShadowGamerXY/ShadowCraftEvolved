package ShadowGamerXY.Items;

import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemsSCE extends Item
{
	public ItemsSCE()
	{
		
		super();
		this.setCreativeTab(CreativeTabsSCE.SCE_TAB);
	}
	
	public ItemsSCE(ToolMaterial shadowSteel) {
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

	public void takenFromCrafting(EntityPlayer player, ItemStack item, IInventory matrix) {

		
	}
}

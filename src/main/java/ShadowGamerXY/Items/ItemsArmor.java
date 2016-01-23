package ShadowGamerXY.Items;

import ShadowGamerXY.Init.ModItems;
import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemsArmor extends ItemArmor {

	public String textureName;

	public ItemsArmor(String unlocalizedName, ArmorMaterial material, String textureName, int type) {
		super(material, 0, type);
		this.textureName = textureName;
		this.setCreativeTab(CreativeTabsSCE.SCE_TAB);
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(references.MOD_ID + ":" + unlocalizedName);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		return references.MOD_ID + ":textures/items/armor/" + this.textureName + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
}

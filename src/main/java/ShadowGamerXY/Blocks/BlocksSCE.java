package ShadowGamerXY.Blocks;

import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlocksSCE extends Block{

	public BlocksSCE(Material material)
	{
		super(material);
		this.setCreativeTab(CreativeTabsSCE.SCE_TAB);
	}
	
	public BlocksSCE()
	{
		this(Material.rock);
		this.setHardness(5.0f);
	}
	 @Override
	    public String getUnlocalizedName()
	    {
	        return String.format("tile.%s%s", references.MOD_ID.toLowerCase()+ ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public void registerBlockIcons(IIconRegister iconRegister)
	    {
	        blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
	    }

	    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	    {
	        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	    }

	    
	   
	   

	    
}

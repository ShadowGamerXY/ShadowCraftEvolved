package ShadowGamerXY.Blocks.Ores;



import org.lwjgl.util.Color;

import ShadowGamerXY.Blocks.BlocksSCE;
import net.minecraft.block.Block;

public class NegalOre extends BlocksSCE{

	public NegalOre()
	{
		super();
		this.setBlockName("NegalOre");
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
	}
	

}
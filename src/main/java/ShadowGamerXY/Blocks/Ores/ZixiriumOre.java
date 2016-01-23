package ShadowGamerXY.Blocks.Ores;

import ShadowGamerXY.Blocks.BlocksSCE;
import ShadowGamerXY.References.materials.Tools;
import cpw.mods.fml.common.toposort.TopologicalSort;

public class ZixiriumOre extends BlocksSCE
{
	public ZixiriumOre()
	{
		super();
		this.setBlockName("ZixiriumOre");
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
	}
}

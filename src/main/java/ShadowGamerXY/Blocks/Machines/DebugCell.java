package ShadowGamerXY.Blocks.Machines;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyDebugCell;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk1;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class DebugCell extends BlockSCETileEntity
{
	
	public DebugCell()
	{
		super();
		this.setBlockName("DebugCell");
	}		

	@Override
	public TileEntity createNewTileEntity(World world, int metaData) {
		return new TileEntiyEnergyCubeMk1();
	}
}

package ShadowGamerXY.Blocks.Storage.Energy;

import java.util.List;
import java.util.Random;

import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyCreativeEnergyCube;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk1;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import ShadowGamerXY.Utilitys.DropInventroy;
import ShadowGamerXY.api.IWrenchabe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyCube extends Block implements IWrenchabe
{
		public IIcon output;
		public IIcon base;
		public IIcon outputCreative;
		
		public EnergyCube()
		{
			super(Material.iron);
			this.setCreativeTab(CreativeTabsSCE.Machine_TAB);
			this.setBlockName("EnergyCube");
			this.setHardness(500.0F);
			this.setResistance(17.5F);
			this.setHarvestLevel("pickaxe", 1);
			this.setStepSound(soundTypeMetal);
		}

		public TileEntity createTileEntity(World world, int meta) 
		{
			switch(meta)
			{
			case 0:
				return new TileEntiyCreativeEnergyCube();
			case 1:
				return new TileEntiyEnergyCubeMk1();
			}
				return null;
		}
		
		public boolean hasTileEntity(int meta)
		{
			return meta <= 3;
		}
		
		public void getSubBlocks(Item item, CreativeTabs creaticeTab, List list)
		{
			list.add(new ItemStack(item, 1, 0));
			list.add(new ItemStack(item, 1, 1));
		}
		

		public int damageDropped(int meta)
		{
			return meta;
		} 
		
		public ItemStack getPickBlock(MovingObjectPosition target, World world,int x,int y, int z)
		{
			int meta = world.getBlockMetadata(x, y, z);
			return new ItemStack(this, 1, meta);
		}
		
		public IIcon getIcon(IBlockAccess world,int x,int y,int z, int side)
		{
			int meta = world.getBlockMetadata(x, y, z);
			
			switch(meta)
			{
			case 0:
				return outputCreative;
			case 1:
				TileEntiyEnergyCubeMk1 te = (TileEntiyEnergyCubeMk1) world.getTileEntity(x, y, z);
				if(side == te.outputSide.ordinal())
				{
					return output;
				}
			}
			return base;
		}
		
		public void registerBlockIcons(IIconRegister IR)
		{
			output = IR.registerIcon(references.MOD_ID + ":" + "machine_output");
			base = IR.registerIcon(references.MOD_ID + ":" + "machine_input");
			
			outputCreative = IR.registerIcon(references.MOD_ID + ":" + "machine_output_creative");
		}
		
		public IIcon getIcon(int side, int meta)
		{
			switch(meta)
			{
			case 0:
				return outputCreative;
			case 1:
				if(side == 3)return output;
			}
			return base;
		}
		
		
		public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
		{
			int meta = world.getBlockMetadata(x, y, z);
			if(meta == 1)
			{
					TileEntiyEnergyCubeMk1 te = (TileEntiyEnergyCubeMk1) world.getTileEntity(x, y, z);
					int rotation = BlockPistonBase.determineOrientation(world, x, y, z, player);
					te.outputSide = ForgeDirection.VALID_DIRECTIONS[rotation];
			}
		}
		
		@Override
		public void wrenchRightClick(World world, int x, int y, int z) 
		{
			
		}

		@Override
		public void wrenchShiftRightClick(World world, int x, int y, int z) 
		{
			if(!world.isRemote && world.getTileEntity(x, y, z) != null)
			{
				ItemStack stack =  new ItemStack(Item.getItemFromBlock(ModBlocks.EnergyCube));
				
				DropInventroy.dropInventory(world, x, y, z);
				world.setBlockToAir(x, y, z);
				world.removeTileEntity(x,y,z);
				world.notifyBlockChange(x, y, z, this);
				dropBlockAsItem(world, x, y, z, stack);
			}
		}
}

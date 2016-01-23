package ShadowGamerXY.Blocks.Machines;

import java.util.List;

import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurniceAdvanced;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurniceAdvanced;
import ShadowGamerXY.Utilitys.BlockUtil;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import ShadowGamerXY.Utilitys.DropInventroy;
import ShadowGamerXY.Utilitys.LogHelper;
import ShadowGamerXY.api.IWrenchabe;
import cpw.mods.fml.common.eventhandler.Event.Result;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import scala.util.Random;

public class BlockMachinesSCE extends BlockContainer implements IWrenchabe
{
	
	private IIcon[] icons = new IIcon[4];
	private static boolean keepInventory;
	private Random rand =  new Random();
	
	public BlockMachinesSCE()
	{
		super(Material.iron);
		this.setCreativeTab(CreativeTabsSCE.SCE_TAB);
		this.setBlockName("machines");
		this.setHardness(5.0f);
		this.setResistance(17.5f);
		this.setStepSound(soundTypeMetal);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	public TileEntity createNewTileEntity(World world, int meta) 
	{
		switch(meta)
		{
		case 0:
			return new TileEntiyElectricFurniceAdvanced();
		}
			LogHelper.info("No tile entity");
			return null;
	}
	
	public boolean hasTileEntity(int meta)
	{
		return meta < 3;
	}
	
	public EnumRarity getRarity(ItemStack stack)
	{
			return EnumRarity.rare;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{	
		if(!world.isRemote)
		{
			int meta =  world.getBlockMetadata(x, y, z);
			if(meta ==0)
			{
			player.openGui(ShadowCraftEvolved.instance, IDs.GuiIDs.ELFurniceAdv.ordinal(), world, x, y, z);
			
			return true;
			}		
		}
		return true;
	}
	
	public void getSubBlocks(Item item, CreativeTabs creaticeTab, List list)
	{
		list.add(new ItemStack(item, 1, 0));
	}
	
	public int damageDropped(int meta)
	{
		return meta;
	}
	
	public ItemStack  getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x, y, z);
		return new ItemStack(this, 1, meta);
	}
	
	public void registerBlockIcons(IIconRegister iconRegister)
	{
		icons[0] = iconRegister.registerIcon(references.MOD_ID + ":machine_base");
		icons[1] = iconRegister.registerIcon(references.MOD_ID + ":ElectricFurnice_off");
		icons[2] = iconRegister.registerIcon(references.MOD_ID + ":ElectricFurnice_on");
		icons[3] = iconRegister.registerIcon(references.MOD_ID + ":machine_top");
	}
	
	
	public IIcon getIcon(int side, int meta)
	{
		if(meta == 0 && side == 3)
		{
			return icons[1];
		}
		else if(meta == 0 && side == 1)
		{
			return icons[3];
		}
		else if(meta == 0 && side == 0)
		{
			return icons[3];
		}
		return icons[0];
	}
	
	public IIcon getIcon(IBlockAccess world, int x,int y, int z, int side)
	{
		int meta = world.getBlockMetadata(x, y, z);
		
		if(meta == 0)
		{
			TileEntiyElectricFurniceAdvanced tileentity = (TileEntiyElectricFurniceAdvanced) world.getTileEntity(x, y, z);
			if(side == tileentity.rotation)
			{
				if(tileentity.isSmelting)
				{
					return icons[2];
				}
				else
				{
				return icons[1];
				}
			}
			if(side == 1)
			{
				return icons[3];
			}
			if(side == 0)
			{
				return icons[3];
			}
		}
		return icons[0];
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		int meta = world.getBlockMetadata(x, y, z);
		
		if(meta == 0)
		{
			TileEntiyElectricFurniceAdvanced tileentity = (TileEntiyElectricFurniceAdvanced) world.getTileEntity(x, y, z);
			tileentity.rotation = BlockUtil.determineMetadataBasedOnPlayerOrientation(player);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) 
    {
		if(!keepInventory) 
		{
			TileEntiyElectricFurniceAdvanced tileEntity = (TileEntiyElectricFurniceAdvanced)world.getTileEntity(x, y, z);
			
			if(tileEntity != null) 
			{
				for(int i = 0; i < tileEntity.getSizeInventory(); i++) 
				{
					ItemStack itemStack = tileEntity.getStackInSlot(i);
					
					if(itemStack != null) 
					{
						float f = this.rand.nextFloat() * 0.8F + 0.1F;
						float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
						float f2 = this.rand.nextFloat() * 0.8F + 0.1F;
						
						while(itemStack.stackSize > 0) 
						{
							int j = this.rand.nextInt(21) + 10;
							
							if(j > itemStack.stackSize)
								j = itemStack.stackSize;
							
							itemStack.stackSize -= j;
							
							EntityItem item = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemStack.getItem(), j, itemStack.getItemDamage()));
							
							if(itemStack.hasTagCompound())
								item.getEntityItem().setTagCompound((NBTTagCompound)itemStack.getTagCompound().copy());
							
							world.spawnEntityInWorld(item);
						}
					}
				}
				world.func_147453_f(x, y, z, oldBlock);
			}
		}
		super.breakBlock(world, x, y, z, oldBlock, oldMetadata);
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
			ItemStack stack =  new ItemStack(Item.getItemFromBlock(this));
			
			DropInventroy.dropInventory(world, x, y, z);
			world.setBlockToAir(x, y, z);
			world.removeTileEntity(x,y,z);
			world.notifyBlockChange(x, y, z, this);
			dropBlockAsItem(world, x, y, z, stack);
		}
	}
	
	
}

package ShadowGamerXY.Blocks.Machines;

import java.util.Random;

import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import ShadowGamerXY.Utilitys.BlockUtil;
import ShadowGamerXY.Utilitys.CreativeTabsSCE;
import ShadowGamerXY.Utilitys.DropInventroy;
import ShadowGamerXY.api.IWrenchabe;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BasicGenerator extends BlockContainer implements IWrenchabe
{
	//private IIcon[] icons = new IIcon[3];
	private static boolean keepInventory;
	private Random rand = new Random();

	public BasicGenerator() {
		super(Material.iron);
		this.setCreativeTab(CreativeTabsSCE.Machine_TAB);
		this.setBlockName("BasicGenerator");
		this.setHardness(500.0F);
		this.setResistance(17.5F);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeMetal);
	}
	
	 public int getRenderType() {
			return -1;
		}
		
		public boolean isOpaqueCube() {
			return false;
		}
		
		public boolean renderAsNormalBlock() {
			return false;
		}

	
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntiyBasicGenerator();
	}
	
	public boolean hasTileEntiy(int meta)
	{
		return true;
	}
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote) 	
		{
    		player.openGui(ShadowCraftEvolved.instance, IDs.GuiIDs.BasicGen.ordinal(), world, x, y, z);
		}
        return true;
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		
		int meta = world.getBlockMetadata(x, y, z);
		
		if(meta == 0)
		{
			TileEntiyBasicGenerator tileentity = (TileEntiyBasicGenerator) world.getTileEntity(x, y, z);
			tileentity.rotation = BlockUtil.determineMetadataBasedOnPlayerOrientation(player);
		}
	}
	
	public void breakBlock(World world, int x, int y, int z, Block oldBlock, int oldMetadata) 
    {
		if(!keepInventory) 
		{
			TileEntiyBasicGenerator tileEntity = (TileEntiyBasicGenerator)world.getTileEntity(x, y, z);
			
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

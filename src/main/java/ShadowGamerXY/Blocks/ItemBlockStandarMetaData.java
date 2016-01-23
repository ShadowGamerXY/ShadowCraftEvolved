	package ShadowGamerXY.Blocks;

import java.util.List;

import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.TileEntitys.Machines.TileEntityBasicConduit;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk3;
import ShadowGamerXY.Utilitys.StringHelper;
import ShadowGamerXY.Utilitys.Power.Energy;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class ItemBlockStandarMetaData extends ItemBlock
{
	public ItemBlockStandarMetaData(Block block) {
		super(block);
		setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack itemstack)
    {
        return getUnlocalizedName() + "." + itemstack.getItemDamage();
    }
	
	 public int getMetadata(int meta)
	 {
		 return meta;
	 }
	 
	 
	 public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced)
	 {
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicConduit))
		 {
			 int meta = stack.getItemDamage();
			 
			 if(meta == 0)
			 {
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Transfer rate: 500 SF/s");
				 list.add("Basic");
				 list.add("Energy loss: 0" + Energy.ShadowCraftEvolved.getSymbol() + "/block");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicGen))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Basic");
				 list.add("To generate SF energy!");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.ElFurnice))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Basic");
				 list.add("To smelt items!");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.EnergyCube))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 1)
			 {
				 list.add("Basic");
			 }
			if(meta == 0)
			{
				list.add("Creative only!");
			}
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.EnergyCube2))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Advanced");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrateMk5DeepStorage))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {list.add("Mk4");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				list.add("DeepStorage");
				list.add("Has 600 slots.");
				list.add("64 items per slot.");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrate))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Basic");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Can store 64 same items.");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrateMk2))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Mk1");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Has 10 slots.");
				 list.add("64 items per slot.");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrateMk3))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Mk2");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Has 32 slots.");
				 list.add("64 items per slot,");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrateMk4))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Mk3");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Has 64 slots.");
				 list.add("64 items per slot.");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.BasicCrateMk5))
		 {
			 int meta = stack.getItemDamage();
			 if(meta == 0)
			 {
				 list.add("Mk4");
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Has 128 slots.");
				 list.add("64 items per slot.");
			 }
		 }
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.EnergyCube3))
		 {
			 int meta = stack.getItemDamage();
			 
			 if(meta == 0)
			 {
				 list.add(StringHelper.getNoticeText("Ultimate"));
				 if (StringHelper.displayShiftForDetail && !StringHelper.isShiftKeyDown()) {
						list.add(StringHelper.shiftForDetails());
					}
					if (!StringHelper.isShiftKeyDown()) {
						return;
					}
				 list.add("Can hold:");
				 list.add(StringHelper.getActivationText("800000000SF"));
			 }
		 }
		 
		 if(stack.getItem() == Item.getItemFromBlock(ModBlocks.Machines))
		 {
			 int meta = stack.getItemDamage();
			 
			 if(meta == 0)
			 {
				 list.add(StringHelper.getActivationText("Advanced"));
			 }
		 }
	}
}



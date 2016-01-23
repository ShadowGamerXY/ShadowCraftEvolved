package ShadowGamerXY.Utilitys;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class NBTUtil 
{
	public static void readItemStackArrayFormNBT(ItemStack[] inventory, NBTTagCompound tag)
	{
		NBTTagList NBTlist = tag.getTagList("Items", 10);
		
		for(int i = 0; i < NBTlist.tagCount(); ++i)
		{
			NBTTagCompound NBTcompound1 = NBTlist.getCompoundTagAt(i);
			byte b0 = NBTcompound1.getByte("Slot");
			
			if(b0 >= 0 && b0 < inventory.length)
			{
				inventory[b0] = ItemStack.loadItemStackFromNBT(NBTcompound1);
			}
		}
	}
	
	public static void writeItemStackArrayToNBT(ItemStack[] inventory, NBTTagCompound tag)
	{
		NBTTagList list = new NBTTagList();
		
		for(int i = 0; i < inventory.length; ++i)
		{
			if(inventory[i] != null)
			{
				NBTTagCompound compound1 = new NBTTagCompound();
				compound1.setByte("Slot", (byte) i);
				inventory[i].writeToNBT(compound1);
				list.appendTag(compound1);
			}
		}
		tag.setTag("Items", list);
	}
}

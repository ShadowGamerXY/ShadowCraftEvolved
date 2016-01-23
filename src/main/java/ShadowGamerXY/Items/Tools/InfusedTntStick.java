package ShadowGamerXY.Items.Tools;

import ShadowGamerXY.Items.ItemsSCE;
import ShadowGamerXY.Main.ShadowCraftEvolved;
import ShadowGamerXY.References.IDs;
import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class InfusedTntStick extends ItemsSCE
{
	public InfusedTntStick()
	{
		this.setUnlocalizedName("Debugger");
	}
	
	  public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
      {
              if(!world.isRemote)
              {
                      TileEntity tileentity = world.getTileEntity(x, y, z);
                      if(tileentity instanceof IEnergy)
                      {
                              player.addChatMessage(new ChatComponentText("[" + references.MOD_NAME + "] ShadowFlux level = " + ((IEnergy) tileentity).getEnergyBar().getEnergyLevel()));
                      }
                      return true;
              }
              return false;
      }
	  
      public boolean isFull3D()
      {
              return true;
      }
      
      @Override
      public EnumRarity getRarity(ItemStack stack)
      {
    	  return EnumRarity.uncommon;
      }
}

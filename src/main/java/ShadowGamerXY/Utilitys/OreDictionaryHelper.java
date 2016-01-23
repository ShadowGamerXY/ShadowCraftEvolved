package ShadowGamerXY.Utilitys;


import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHelper {
	public static final String INGOT_COPPER = "ingotCopper";
	  public static final String INGOT_TIN = "ZixiriumIngot";


	  public static boolean isRegistered(String name) {
	    if (!getOres(name).isEmpty()) {
	      return true;
	    }
	    return false;
	  }

	  public static List<ItemStack> getOres(String name) {
	    return OreDictionary.getOres(name);
	  }

	  public static boolean hasCopper() {
	    return isRegistered(INGOT_COPPER);
	  }

	  public static boolean hasTin() {
	    return isRegistered(INGOT_TIN);
	  }


	  private OreDictionaryHelper() {
	  }

	  public static String[] getOreNames(ItemStack stack) {
	    int[] ids = OreDictionary.getOreIDs(stack);
	    String[] ret = new String[ids.length];
	    for (int i = 0; i < ids.length; i++) {
	      ret[i] = OreDictionary.getOreName(ids[i]);
	    }
	    return ret;
	  }

	  public static boolean hasName(ItemStack stack, String oreName) {
	    return ArrayUtils.contains(getOreNames(stack), oreName);
	  }

}

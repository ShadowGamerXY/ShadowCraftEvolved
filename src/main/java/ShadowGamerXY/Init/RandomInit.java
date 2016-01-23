package ShadowGamerXY.Init;

import ShadowGamerXY.Utilitys.FuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class RandomInit 
{
	public static FuelHandler Fuel = new FuelHandler();
	
	
	public static void init()
	{
		GameRegistry.registerFuelHandler(Fuel);
	}
}

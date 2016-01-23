package ShadowGamerXY.thirdparty.waila;

import ShadowGamerXY.Blocks.Machines.BasicGenerator;
import ShadowGamerXY.Blocks.Mines.LandMineMk3;
import mcp.mobius.waila.api.IWailaRegistrar;

public class Waila {

	
		public static void onWailaCall(IWailaRegistrar registrar)
		{
			registrar.registerStackProvider(new WailaMineHandler(), LandMineMk3.class);
			registrar.registerBodyProvider(new WailaMineHandler() , LandMineMk3.class);
			registrar.registerNBTProvider(new WailaMineHandler(), LandMineMk3.class);
		}
}

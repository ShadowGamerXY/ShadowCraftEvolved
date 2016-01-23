package ShadowGamerXY.WorldGen;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

public class ShadowWorld 
{
	public static void mainRegistry(){
		initialiseWorldGen();
	}
	
	public static void initialiseWorldGen(){
		registerWorldGen(new WorldGen(), 1);
	}
	
	public static void registerWorldGen(IWorldGenerator worldGenClass, int weightedProberblity){
		GameRegistry.registerWorldGenerator(worldGenClass, weightedProberblity);
	}
}

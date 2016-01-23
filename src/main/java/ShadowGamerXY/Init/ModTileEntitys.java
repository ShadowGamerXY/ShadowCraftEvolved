package ShadowGamerXY.Init;

import ShadowGamerXY.References.IDs;
import ShadowGamerXY.TileEntitys.TileEntityTreeFarm;
import ShadowGamerXY.TileEntitys.Machines.TileEntityBasicConduit;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyCreativeEnergyCube;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyDebugCell;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurnice;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurniceAdvanced;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk1;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk2;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk3;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk1;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk2;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrate;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk2;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk3;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk4;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk5;
import ShadowGamerXY.TileEntitys.Storage.TileEntityBasicCrateMk5Deep;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModTileEntitys {


	public static void init()
	{
		GameRegistry.registerTileEntity(TileEntityLandMineMk1.class, IDs.Land_Mine_Mk1);
		GameRegistry.registerTileEntity(TileEntityLandMineMk2.class, IDs.Land_Mine_Mk2);
		GameRegistry.registerTileEntity(TileEntityLandMineMk3.class, IDs.Land_Mine_Mk3);
		
		GameRegistry.registerTileEntity(TileEntityInfuser.class, IDs.Infuser);
		GameRegistry.registerTileEntity(TileEntiyElectricFurnice.class, IDs.ELfurnice);
		GameRegistry.registerTileEntity(TileEntiyElectricFurniceAdvanced.class, IDs.Machines);
		
		GameRegistry.registerTileEntity(TileEntiyBasicGenerator.class, IDs.BasicGenerator);
		
		GameRegistry.registerTileEntity(TileEntiyDebugCell.class, IDs.DebugCell);

		
		GameRegistry.registerTileEntity(TileEntityBasicCrate.class, IDs.BasicCrate);
		GameRegistry.registerTileEntity(TileEntityBasicCrateMk2.class, IDs.BasicCrateMk2);
		GameRegistry.registerTileEntity(TileEntityBasicCrateMk3.class, IDs.BasicCrateMk3);
		GameRegistry.registerTileEntity(TileEntityBasicCrateMk4.class, IDs.BasicCrateMk4);
		GameRegistry.registerTileEntity(TileEntityBasicCrateMk5.class, IDs.BasicCrateMk5);
		GameRegistry.registerTileEntity(TileEntityBasicCrateMk5Deep.class, IDs.BasicCrateMk5Deep);
		
		GameRegistry.registerTileEntity(TileEntityBasicConduit.class, IDs.Conduit);
		
		GameRegistry.registerTileEntity(TileEntityTreeFarm.class, IDs.Farm);
		
		GameRegistry.registerTileEntity(TileEntityModularCrate.class, IDs.Mcrate);
		
		
		//EnergyCubes//
		
		GameRegistry.registerTileEntity(TileEntiyEnergyCubeMk1.class, IDs.ECube1);
		GameRegistry.registerTileEntity(TileEntiyEnergyCubeMk2.class, IDs.ECube2);
		GameRegistry.registerTileEntity(TileEntiyEnergyCubeMk3.class, IDs.ECube3);
		GameRegistry.registerTileEntity(TileEntiyCreativeEnergyCube.class, IDs.ECubeCreative);
	}

}

package ShadowGamerXY.Init;

import ShadowGamerXY.Blocks.BlockSCETileEntity;
import ShadowGamerXY.Blocks.BlocksSCE;
import ShadowGamerXY.Blocks.ItemBlockStandarMetaData;
import ShadowGamerXY.Blocks.BuildingBlocks.EnderStone;
import ShadowGamerXY.Blocks.Conduit.BasicConduit;
import ShadowGamerXY.Blocks.Machines.BasicGenerator;
import ShadowGamerXY.Blocks.Machines.BlockMachinesSCE;
import ShadowGamerXY.Blocks.Machines.DebugCell;
import ShadowGamerXY.Blocks.Machines.ElectricFurnice;
import ShadowGamerXY.Blocks.Machines.Infuser;
import ShadowGamerXY.Blocks.MatalBlocks.HardendIronBlock;
import ShadowGamerXY.Blocks.MatalBlocks.LithiumBlock;
import ShadowGamerXY.Blocks.MatalBlocks.NegalBlock;
import ShadowGamerXY.Blocks.MatalBlocks.ZixiriumBlock;
import ShadowGamerXY.Blocks.Mines.LandMineMk1;
import ShadowGamerXY.Blocks.Mines.LandMineMk2;
import ShadowGamerXY.Blocks.Mines.LandMineMk3;
import ShadowGamerXY.Blocks.Ores.DarkCopperore;
import ShadowGamerXY.Blocks.Ores.LithiumOre;
import ShadowGamerXY.Blocks.Ores.NegalOre;
import ShadowGamerXY.Blocks.Ores.NickelOre;
import ShadowGamerXY.Blocks.Ores.ZixiriumOre;
import ShadowGamerXY.Blocks.Storage.BasicCrate;
import ShadowGamerXY.Blocks.Storage.BasicCrateMk2;
import ShadowGamerXY.Blocks.Storage.BasicCrateMk3;
import ShadowGamerXY.Blocks.Storage.BasicCrateMk4;
import ShadowGamerXY.Blocks.Storage.BasicCrateMk5;
import ShadowGamerXY.Blocks.Storage.BasicCrateMk5DeepStorage;
import ShadowGamerXY.Blocks.Storage.ModularCrate;
import ShadowGamerXY.Blocks.Storage.Energy.EnergyCube;
import ShadowGamerXY.Blocks.Storage.Energy.EnergyCubeAdvanced;
import ShadowGamerXY.Blocks.Storage.Energy.EnergyCubeUltimate;
import ShadowGamerXY.Blocks.TreeFarm.FarmBaseBlock;
import ShadowGamerXY.Blocks.TreeFarm.FarmCore;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;

public class ModBlocks 
{
	
	//Ores//
	public static final BlocksSCE NegalOre = new NegalOre();
	public static final BlocksSCE ZixiriumOre = new ZixiriumOre();
	public static final BlocksSCE DarkCopperOre = new DarkCopperore();
	public static final BlocksSCE LithiumOre = new LithiumOre();
	public static final BlocksSCE NickelOre = new NickelOre();

	
	//test//
	public static final BlocksSCE testo01 = new ShadowGamerXY.Blocks.Testing.testo01();
	
	public static final BlockContainer ElFurnice = new ElectricFurnice();
	public static final Block EnergyCube2 = new EnergyCubeAdvanced();
	public static final Block EnergyCube3 = new EnergyCubeUltimate();
	public static final Block EnergyCube = new EnergyCube();
	
	//Ender//
	public static final BlocksSCE EnderStone = new EnderStone();
	
	public static final BlockContainer Machines =  new BlockMachinesSCE();
	
	
	//Blocks//
	public static final BlocksSCE NegalBlock = new NegalBlock();
	public static final BlocksSCE ZixiriumBlock = new ZixiriumBlock();
	public static final BlocksSCE HardendIronBlock = new HardendIronBlock();
	public static final BlocksSCE LithiumBlock = new LithiumBlock();
	
	public static final BlockSCETileEntity DebuggCell = new DebugCell();
	
	public static final BlockContainer BasicConduit = new BasicConduit();
	
	//Generators//
	public static final Block BasicGen = new BasicGenerator();
	
	
	//Storage//
	public static final BlockSCETileEntity BasicCrate = new BasicCrate();
	public static final BlockSCETileEntity BasicCrateMk2 = new BasicCrateMk2();
	public static final BlockSCETileEntity BasicCrateMk3 = new BasicCrateMk3();
	public static final BlockSCETileEntity BasicCrateMk4 = new BasicCrateMk4();
	public static final BlockSCETileEntity BasicCrateMk5 = new BasicCrateMk5();
	public static final BlockSCETileEntity BasicCrateMk5DeepStorage = new BasicCrateMk5DeepStorage();
	
	
	public static final BlockSCETileEntity ModularCrate = new ModularCrate();
	
	
	
	public static final BlockSCETileEntity TreeFarmCore = new FarmCore();
	public static final BlocksSCE FarmBaseBlock = new FarmBaseBlock();

	
	//Machines//
	public static final BlockSCETileEntity Infuser = new Infuser();
	
	//Mines//
	public static final BlockSCETileEntity LandMineMk1 = new LandMineMk1();
	public static final BlockSCETileEntity LandMineMk2 = new LandMineMk2();
	public static final BlockSCETileEntity LandMineMk3 = new LandMineMk3();
	
	public static void init()
	{
		GameRegistry.registerBlock(NegalOre, "Negalore");
		GameRegistry.registerBlock(DarkCopperOre, "DarkCopperOre");
		GameRegistry.registerBlock(LithiumOre, "LithiumOre");
		GameRegistry.registerBlock(NickelOre, "NickelOre");
		
		
		GameRegistry.registerBlock(testo01, "testo01");
		
		GameRegistry.registerBlock(DebuggCell, "DebuggCell");
		
		//Blocks//
		GameRegistry.registerBlock(NegalBlock, "NegalBlock");
		GameRegistry.registerBlock(ZixiriumOre, "ZixiriumOre");
		GameRegistry.registerBlock(ZixiriumBlock, "ZixiriumBlock");
		GameRegistry.registerBlock(HardendIronBlock, "HardendIronBlock");
		GameRegistry.registerBlock(LithiumBlock, "LithiumBlock");
		
		//BuildingBlocks//
		GameRegistry.registerBlock(EnderStone, "EnderStone");
		
		//Machines//
		GameRegistry.registerBlock(Infuser,ItemBlockStandarMetaData.class, "Infuser");
		GameRegistry.registerBlock(ElFurnice, ItemBlockStandarMetaData.class,"ElectricFurnice");
		GameRegistry.registerBlock(Machines, ItemBlockStandarMetaData.class,"Machines");
		GameRegistry.registerBlock(EnergyCube, ItemBlockStandarMetaData.class,"EnergyCube");
		GameRegistry.registerBlock(EnergyCube2, ItemBlockStandarMetaData.class,"EnergyCube2");
		GameRegistry.registerBlock(EnergyCube3, ItemBlockStandarMetaData.class,"EnergyCube3");

		
		//generators//
		GameRegistry.registerBlock(BasicGen, ItemBlockStandarMetaData.class,"BasicGenerator");
		
		
		GameRegistry.registerBlock(BasicConduit,ItemBlockStandarMetaData.class, "BasicConduit");

		//Storage//
		GameRegistry.registerBlock(BasicCrate, ItemBlockStandarMetaData.class,"BasicCrate");
		GameRegistry.registerBlock(BasicCrateMk2, ItemBlockStandarMetaData.class,"BasicCrateMk2");
		GameRegistry.registerBlock(BasicCrateMk3, ItemBlockStandarMetaData.class,"BasicCrateMk3");
		GameRegistry.registerBlock(BasicCrateMk4,ItemBlockStandarMetaData.class, "BasicCrateMk4");
		GameRegistry.registerBlock(BasicCrateMk5,ItemBlockStandarMetaData.class, "BasicCrateMk5");
		GameRegistry.registerBlock(BasicCrateMk5DeepStorage, ItemBlockStandarMetaData.class, "BasicCrateMk5DeepStorage");

		
		GameRegistry.registerBlock(TreeFarmCore, "TreeFarmCore");
		GameRegistry.registerBlock(FarmBaseBlock, "FarmBaseBlock");
		
		GameRegistry.registerBlock(ModularCrate, "ModularCrate");

		
		//Mines//
		GameRegistry.registerBlock(LandMineMk1, "LandMineMk1");
		GameRegistry.registerBlock(LandMineMk2, "LandMineMk2");
		GameRegistry.registerBlock(LandMineMk3, "LandMineMk3");
	}
	
}

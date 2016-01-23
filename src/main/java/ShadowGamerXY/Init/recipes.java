package ShadowGamerXY.Init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class recipes 
{
	public static void init()
	{
		
		
		//Armor//	
		GameRegistry.addRecipe(new ItemStack(ModItems.NegalChest), "X X","XXX","XXX", 'X', new ItemStack(ModItems.NegalIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.NegalBoots), "X X","X X","   ", 'X', new ItemStack(ModItems.NegalIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.NegalHelm), "XXX","X X","   ", 'X', new ItemStack(ModItems.NegalIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.NegalLeggings), "XXX","X X","X X", 'X', new ItemStack(ModItems.NegalIngot));
		GameRegistry.addRecipe(new ItemStack(ModItems.NegalDust, 8), "XXX", "XYX", "XXX", 'X', new ItemStack(ModBlocks.NegalOre), 'Y', new ItemStack(ModItems.BloodShard));
		
		//Mines//
		GameRegistry.addRecipe(new ItemStack(ModBlocks.LandMineMk1), "ZXZ","BYB","XXX",'Z', new ItemStack(Blocks.stone_pressure_plate),'B', new ItemStack(Items.gunpowder), 'X', new ItemStack(Blocks.stone), 'Y', new ItemStack(ModItems.MineCore));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.LandMineMk2), "ZBZ","XYX","ZBZ",'Z', new ItemStack(ModItems.NegalIngot),'B', new ItemStack(ModItems.CamouflageCore), 'X', new ItemStack(Items.iron_ingot), 'Y', new ItemStack(ModBlocks.LandMineMk1));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.LandMineMk3), "ZBZ","XYX","ZBZ",'Z', new ItemStack(ModItems.NegalIngot),'B', new ItemStack(ModItems.CamouflageCore), 'X', new ItemStack(Items.iron_ingot), 'Y', new ItemStack(ModBlocks.LandMineMk2));
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.EnderStone, 4), "ZXZ","XZX","ZXZ",'Z', new ItemStack(Blocks.end_stone), 'X', new ItemStack(Blocks.stonebrick));
		GameRegistry.addRecipe(new ItemStack(ModItems.Wrench), "XYX", " K ", " X ", 'X', new ItemStack(ModItems.HardendIronIngot), 'Y', new ItemStack(ModItems.ZixiriumIngot), 'K', new ItemStack(ModItems.Gears, 1, 3));

		
		//MetalBlocks//
		GameRegistry.addRecipe(new ItemStack(ModBlocks.NegalBlock), "XXX","XXX","XXX",'X', new ItemStack(ModItems.NegalIngot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ZixiriumBlock), "XXX","XXX","XXX",'X', new ItemStack(ModItems.ZixiriumIngot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.HardendIronBlock), "XXX","XXX","XXX",'X', new ItemStack(ModItems.HardendIronIngot));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.LithiumBlock), "XXX","XXX","XXX",'X', new ItemStack(ModItems.LithiumIngot));

		
		//StorageCrates//
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrateMk5DeepStorage), "XY ","   ","  ",'X', new ItemStack(ModBlocks.BasicCrateMk5), 'Y', new ItemStack(ModItems.DeepStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrate), "X X","YZY","XKX",'X', new ItemStack(Blocks.planks), 'K', new ItemStack(ModItems.BasicConector),'Y', new ItemStack(Blocks.chest), 'Z', new ItemStack(ModItems.BasicStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrateMk2),"  ","XZX","  ",'X', new ItemStack(ModBlocks.BasicCrate), 'Z', new ItemStack(ModItems.AdvancedStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrateMk3),"  ","XZX","  ",'X', new ItemStack(ModBlocks.BasicCrateMk2), 'Z', new ItemStack(ModItems.AdvancedStorageModule));	
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrateMk4),"X X","YZY","X X",'X', new ItemStack(ModBlocks.BasicCrateMk3), 'Z', new ItemStack(ModItems.BasicConector),'Y', new ItemStack(ModItems.AdvancedStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicCrateMk5),"X X","YZY","X X",'X', new ItemStack(ModBlocks.BasicCrateMk4), 'Z', new ItemStack(Blocks.diamond_block),'Y', new ItemStack(ModItems.AdvancedStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ModularCrate),"XXX","YZY","XXX",'X', new ItemStack(ModItems.NegalIngot), 'Z', new ItemStack(ModItems.BasicStorageModule),'Y', new ItemStack(Blocks.chest));

		//Components//
		GameRegistry.addRecipe(new ItemStack(ModItems.BasicStorageModule), "XYX","YZY","XYX",'X', new ItemStack(Blocks.planks), 'Y', new ItemStack(ModItems.NegalIngot), 'Z', new ItemStack(Blocks.chest));
		GameRegistry.addRecipe(new ItemStack(ModItems.AdvancedStorageModule), "XYX","YZY","XYX",'X', new ItemStack(ModItems.ZixiriumIngot), 'Y', new ItemStack(ModItems.NegalIngot), 'Z', new ItemStack(ModItems.BasicStorageModule));
		GameRegistry.addRecipe(new ItemStack(ModItems.BasicConector), "X X"," Z ","X X",'X', new ItemStack(Items.iron_ingot), 'Z', new ItemStack(Items.redstone));
		GameRegistry.addRecipe(new ItemStack(ModItems.DeepStorageModule), "XKX","KZK","XKX",'X', new ItemStack(ModBlocks.BasicCrateMk4), 'Z', new ItemStack(ModItems.AdvancedStorageModule), 'K', new ItemStack(Blocks.iron_block));
		GameRegistry.addRecipe(new ItemStack(ModItems.Casing), "X X"," X ","X X",'X', new ItemStack(ModItems.HardendIronIngot));

		//Gears//
		GameRegistry.addRecipe(new ItemStack(ModItems.Gears,1,0), " X ", "XYX", " X ", 'X', new ItemStack(Items.stick), 'Y', new ItemStack(Blocks.planks));
		GameRegistry.addRecipe(new ItemStack(ModItems.Gears, 1, 1), " X ", "XYX", " X ", 'X', new ItemStack(Items.iron_ingot), 'Y', new ItemStack(ModItems.Gears,0));
		GameRegistry.addRecipe(new ItemStack(ModItems.Gears, 1, 2), " X ", "XYX", " X ", 'X', new ItemStack(ModItems.ingotCopper), 'Y', new ItemStack(ModItems.Gears,1, 1));
		GameRegistry.addRecipe(new ItemStack(ModItems.Gears, 1, 3), " X ", "XYX", " X ", 'X', new ItemStack(ModItems.LithiumIngot), 'Y', new ItemStack(ModItems.Gears,1,1));

		
		GameRegistry.addRecipe(new ItemStack(ModItems.SamllEnergyCell), "XYX", "YZY","XYX", 'X', new ItemStack(ModItems.LithiumIngot), 'Y', new ItemStack(Items.redstone),'Z', new ItemStack(ModItems.ZixiriumIngot));
		
		
		//EnergyCube//
		GameRegistry.addRecipe(new ItemStack(ModBlocks.EnergyCube, 1, 1), "XYX", "YZY","XYX", 'X', new ItemStack(ModItems.LithiumIngot), 'Y', new ItemStack(ModItems.SamllEnergyCell),'Z', new ItemStack(ModItems.Casing));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.EnergyCube2),"YXY", "XKX","YXY", 'X', new ItemStack(ModItems.NickelIngot), 'Y', new ItemStack(Blocks.glass), 'K', new ItemStack(ModBlocks.EnergyCube,1,1) );
		GameRegistry.addRecipe(new ItemStack(ModBlocks.EnergyCube3),"YXY", "XKX","YXY", 'X', new ItemStack(ModItems.NickelIngot), 'Y', new ItemStack(ModItems.LithiumIngot), 'K', new ItemStack(ModBlocks.EnergyCube2) );

		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.Infuser), "X X","YZY","KYK",'K', new ItemStack(ModItems.ingotCopper), 'X',new ItemStack(ModItems.NegalIngot), 'Z', new ItemStack(ModItems.MatrixCore), 'Y', new ItemStack(Items.redstone));

		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.FarmBaseBlock, 6), "XYX","YKY","XYX",'X', new ItemStack(ModItems.HardendIronIngot), 'Y', new ItemStack(ModItems.Casing), 'K',new ItemStack(Blocks.iron_block));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.TreeFarmCore), "XYX","YKY","XYX",'X', new ItemStack(ModItems.HardendIronIngot), 'Y', new ItemStack(ModItems.Casing), 'K', new ItemStack(ModItems.MatrixCore));

		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicGen), " X ","YKY", "YZY", 'X', new ItemStack(Blocks.furnace), 'Y', new ItemStack(ModItems.HardendIronIngot), 'K', new ItemStack(ModItems.Gears, 1, 1), 'Z', new ItemStack(ModItems.MatrixCore));
		GameRegistry.addRecipe(new ItemStack(ModBlocks.BasicConduit, 6), "XXX","YZY","XXX", 'X', new ItemStack(Blocks.glass), 'Y', new ItemStack(ModItems.HardendIronIngot), 'Z', new ItemStack(Blocks.redstone_block));
		
		GameRegistry.addRecipe(new ItemStack(ModBlocks.ElFurnice), " Y ","YZY", "KRK", 'Y', new ItemStack(Blocks.furnace), 'K', new ItemStack(ModItems.Gears, 1, 1), 'Z', new ItemStack(ModItems.MatrixCore), 'R', new ItemStack(Items.redstone));

		
		GameRegistry.addRecipe(new ItemStack(ModItems.EnergyMeter), " X ", "XYX", " V ", 'X', new ItemStack(ModItems.HardendIronIngot), 'Y', new ItemStack(Blocks.glass_pane), 'V', new ItemStack(ModItems.SamllEnergyCell));
		
		
		
		GameRegistry.addRecipe(new ItemStack(ModItems.CoreCasing), "XZX","ZYZ","XZX", 'X', new ItemStack(Items.iron_ingot), 'Z', new ItemStack(ModItems.NegalIngot),'Y', new ItemStack(Blocks.glass));
		GameRegistry.addRecipe(new ItemStack(ModItems.MineCore), "XXX","XYX","XXX", 'X', new ItemStack(Blocks.tnt), 'Y', new ItemStack(ModItems.CoreCasing));
		GameRegistry.addRecipe(new ItemStack(ModItems.ShieldComponent), "XYX","YZY","XYX", 'X', new ItemStack(ModItems.NegalIngot), 'Y', new ItemStack(ModItems.ZixiriumIngot), 'Z', new ItemStack(Items.diamond));
		GameRegistry.addRecipe(new ItemStack(ModItems.CamouflageCore), "XYX","YZY","XYX", 'X', new ItemStack(ModItems.NegalIngot), 'Y', new ItemStack(ModItems.ShieldComponent), 'Z', new ItemStack(ModItems.CoreCasing));
		GameRegistry.addRecipe(new ItemStack(ModItems.MatrixCore), "XYX","YZY","XYX",'X', new ItemStack(Blocks.iron_bars), 'Z', new ItemStack(ModItems.Casing), 'Y', new ItemStack(Items.redstone));

		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.NegalIngot,9), new ItemStack(ModBlocks.NegalBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ZixiriumIngot,9), new ItemStack(ModBlocks.ZixiriumBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.HardendIronIngot,9), new ItemStack(ModBlocks.HardendIronBlock));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.LithiumIngot,9), new ItemStack(ModBlocks.LithiumBlock));
		
		//Smelting//
		GameRegistry.addSmelting(new ItemStack(ModItems.NegalDust), new ItemStack(ModItems.NegalIngot), 3.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.ZixiriumOre), new ItemStack(ModItems.ZixiriumIngot), 3.0F);
		GameRegistry.addSmelting(new ItemStack(Items.iron_ingot), new ItemStack(ModItems.HardendIronIngot), 3.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.LithiumOre), new ItemStack(ModItems.LithiumIngot), 4.0F);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.DarkCopperOre), new ItemStack(ModItems.ingotCopper), 4.0F);
		GameRegistry.addSmelting(new ItemStack(Blocks.iron_block), new ItemStack(ModBlocks.HardendIronBlock), 3.0f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.NickelOre), new ItemStack(ModItems.NickelIngot), 3.0f);

	}
}

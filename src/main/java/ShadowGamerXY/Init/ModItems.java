package ShadowGamerXY.Init;

import ShadowGamerXY.Items.ItemsArmor;
import ShadowGamerXY.Items.ItemsSCE;
import ShadowGamerXY.Items.SamllEnergyCell;
import ShadowGamerXY.Items.Components.AdvancedStorageModule;
import ShadowGamerXY.Items.Components.BasicConector;
import ShadowGamerXY.Items.Components.BasicStorageModule;
import ShadowGamerXY.Items.Components.Casing;
import ShadowGamerXY.Items.Components.CoreCasing;
import ShadowGamerXY.Items.Components.DeepStorageModule;
import ShadowGamerXY.Items.Components.ShieldComponent;
import ShadowGamerXY.Items.Components.Core.CamouflageCore;
import ShadowGamerXY.Items.Components.Core.MatrixCore;
import ShadowGamerXY.Items.Components.Core.MineCore;
import ShadowGamerXY.Items.Components.gears.GearIron;
import ShadowGamerXY.Items.Components.gears.GearWood;
import ShadowGamerXY.Items.Components.gears.Gears;
import ShadowGamerXY.Items.Ingots.DarkCopperIngot;
import ShadowGamerXY.Items.Ingots.HardendIronIngot;
import ShadowGamerXY.Items.Ingots.LithiumIngot;
import ShadowGamerXY.Items.Ingots.NegalDust;
import ShadowGamerXY.Items.Ingots.NegalIngot;
import ShadowGamerXY.Items.Ingots.NickelIngot;
import ShadowGamerXY.Items.Ingots.ZixiriumIngot;
import ShadowGamerXY.Items.Negal.BloodShard;
import ShadowGamerXY.Items.Negal.NegalBoots;
import ShadowGamerXY.Items.Negal.NegalChestplate;
import ShadowGamerXY.Items.Tools.EnergyMeter;
import ShadowGamerXY.Items.Tools.InfusedTntStick;
import ShadowGamerXY.Items.Tools.ZigamaWrench;
import ShadowGamerXY.Items.Tools.Wands.BasicSepter;
import ShadowGamerXY.References.materials;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class ModItems 
{
	//Ingots//
	public static final ItemsSCE NegalIngot = new NegalIngot();
	public static final ItemsSCE ZixiriumIngot = new ZixiriumIngot();	
	public static final ItemsSCE HardendIronIngot = new HardendIronIngot();	
	public static final ItemsSCE ingotCopper = new DarkCopperIngot();
	public static final ItemsSCE LithiumIngot = new LithiumIngot();
	public static final ItemsSCE NickelIngot = new NickelIngot();
	public static final ItemsSCE NegalDust = new NegalDust();	
	
	public static final ItemsSCE SamllEnergyCell = new SamllEnergyCell();
	
	//Components//
	public static final ItemsSCE BasicStorageModule = new BasicStorageModule();
	public static final ItemsSCE AdvancedStorageModule = new AdvancedStorageModule();
	public static final ItemsSCE BasicConector = new BasicConector();
	public static final ItemsSCE DeepStorageModule = new DeepStorageModule();
	public static final ItemsSCE MatrixCore = new MatrixCore();
	public static final ItemsSCE Casing = new Casing();

	
	public static final ItemsSCE BloodShard = new BloodShard();

	
	//Gears//
	public static final ItemsSCE WoodGear =  new GearWood();
	public static final ItemsSCE IronGear =  new GearIron();
	
	public static final Item Gears = new Gears("Gear");
	
	//Tools//
	public static final ItemsSCE InfusedTntStick = new InfusedTntStick();
	public static final ItemsSCE EnergyMeter = new EnergyMeter();
	public static final ItemsSCE Wrench =  new ZigamaWrench();
	
	//Wands//
	public static final ItemsSCE BasicSepter = new BasicSepter();
	
	//Swords//
	public static final ItemSword DireSword = new ShadowGamerXY.Items.Swords.Oblivion.DireSword();
	
	public static final ItemsArmor NegalChest = new NegalChestplate("NegalChestplate", materials.Armor.Negal, "negal", 1);
	public static final ItemsArmor NegalHelm = new ShadowGamerXY.Items.Negal.NegalHelm("NegalHelmet", materials.Armor.Negal, "negal", 0);
	public static final ItemsArmor NegalBoots = new NegalBoots("NegalBoots", materials.Armor.Negal, "negal", 3);
	public static final ItemsArmor NegalLeggings = new ShadowGamerXY.Items.Negal.NegalLeggings("NegalLeggings", materials.Armor.Negal, "negal", 2);
	
	
	//Cores//
	public static final ItemsSCE CoreCasing = new CoreCasing();
	public static final ItemsSCE MineCore = new MineCore();
	public static final ItemsSCE CamouflageCore = new CamouflageCore();
	public static final ItemsSCE ShieldComponent = new ShieldComponent();
	
	public static void init()
	{
		//Ingots//
		GameRegistry.registerItem(NegalIngot, "NegalIngot");
		GameRegistry.registerItem(ZixiriumIngot, "ZixiriumIngot");
		GameRegistry.registerItem(HardendIronIngot, "HardendIronIngot");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(LithiumIngot, "LithiumIngot");
		GameRegistry.registerItem(NickelIngot, "NickelIngot");
		GameRegistry.registerItem(NegalDust, "NegalDust");

		
		GameRegistry.registerItem(BloodShard, "BloodShard");

		
		//Components//
		GameRegistry.registerItem(BasicConector, "BasicConector");
		GameRegistry.registerItem(BasicStorageModule, "BasicStorageModule");
		GameRegistry.registerItem(AdvancedStorageModule, "AdvancedStorageModule");
		GameRegistry.registerItem(DeepStorageModule, "DeepStorageModule");
		GameRegistry.registerItem(MatrixCore, "MatrixCore");
		GameRegistry.registerItem(Casing, "Casing");
		GameRegistry.registerItem(NegalChest, "NegalChest");
		GameRegistry.registerItem(NegalHelm, "NegalHelm");
		GameRegistry.registerItem(NegalBoots, "NegalBoots");
		GameRegistry.registerItem(NegalLeggings, "NegalLeggings");
		
		GameRegistry.registerItem(SamllEnergyCell, "SmallEnergyCells");

		
		//Gears//
		//GameRegistry.registerItem(WoodGear, "GearWood");
		//GameRegistry.registerItem(IronGear, "GearIron");
		
		GameRegistry.registerItem(Gears, "Gears");
		
		//Tools//
		GameRegistry.registerItem(InfusedTntStick, "InfusedTntStick");
		GameRegistry.registerItem(EnergyMeter, "EnergyMeter");
		GameRegistry.registerItem(Wrench, "ZigmaWrench");
		
		//wands
		GameRegistry.registerItem(BasicSepter, "BasicSepter");
		
		//Swords//
		GameRegistry.registerItem(DireSword, "DireSword");
		
		//Cores//
		GameRegistry.registerItem(MineCore, "MineCore");
		GameRegistry.registerItem(CoreCasing, "CoreCasing");
		GameRegistry.registerItem(CamouflageCore, "CamouflageCore");
		GameRegistry.registerItem(ShieldComponent, "ShieldComponent");
	}
}

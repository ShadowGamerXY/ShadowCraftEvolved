package ShadowGamerXY.Main;

import ShadowGamerXY.Events.MobDrops;
import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.Init.ModItems;
import ShadowGamerXY.Init.ModTileEntitys;
import ShadowGamerXY.Init.RandomInit;
import ShadowGamerXY.Init.recipes;
import ShadowGamerXY.Network.DescriptionHandler;
import ShadowGamerXY.Network.NetworkHandler;
import ShadowGamerXY.Proxys.CommonProxy;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import ShadowGamerXY.Utilitys.GuiHandler;
import ShadowGamerXY.Utilitys.LogHelper;
import ShadowGamerXY.Utilitys.OreDict;
import ShadowGamerXY.WorldGen.ShadowWorld;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLInterModComms.IMCEvent;
import cpw.mods.fml.common.event.FMLInterModComms.IMCMessage;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid=references.MOD_ID, name= references.MOD_NAME, version= references.VERSION)

public class ShadowCraftEvolved {

	@Instance(references.MOD_ID)
	public static ShadowCraftEvolved instance;
	
	@SidedProxy(clientSide=references.CLIENT_PROXY_CLASS, serverSide= references.SERVER_PROXY_CLASS)
	
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	
	public void preInit(FMLPreInitializationEvent event)
	{
		ModBlocks.init();
        ModItems.init();
        ModTileEntitys.init();
        proxy.preInit();
        NetworkHandler.init();
        DescriptionHandler.init();
        RandomInit.init();
        FMLInterModComms.sendMessage(references.MOD_ID, "camoMineBlacklist", new ItemStack(Blocks.glass));
        FMLInterModComms.sendMessage("Waila", "register", "ShadowGamerXY.thirdparty.waila.Waila.onWailaCall");
        ShadowWorld.mainRegistry();
        OreDict.registerVanilla();
        LogHelper.info("Pre Initialization Complete!");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.init();
		recipes.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		MinecraftForge.EVENT_BUS.register(new MobDrops());
		LogHelper.info("Initialization Complete");
		
		
	}
	
	@Mod.EventHandler
	
	public void postInit (FMLPostInitializationEvent event)
	{
		proxy.postInit();
		LogHelper.info("PostInitialization Complete");

		
	}
	
	@Mod.EventHandler
	public void onIMCMessages(IMCEvent event)
	{
		LogHelper.info("Reciving IMC");
		for(IMCMessage message : event.getMessages())
		{
			if(message.key.equalsIgnoreCase("camoMineBlcklist"))
			{
				if(message.isItemStackMessage()){
				ItemStack blacklistedStack = message.getItemStackValue();
				if(blacklistedStack.getItem() != null)
				{
					TileEntityLandMineMk3.camouflageBlacklist.add(blacklistedStack);
				}
				else{
					
				}
				}
				else
				{
					LogHelper.warn(String.format("Mod %s sent a non-ItemStack message, where an ItemStack was expected.", message.getSender()));
				}
				}
			else{
					LogHelper.warn(String.format("Mod %s used an invalid IMC key: %s", message.getSender(), message.key));
			}
		}
	
	}
}

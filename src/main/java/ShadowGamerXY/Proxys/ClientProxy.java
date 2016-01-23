package ShadowGamerXY.Proxys;

import ShadowGamerXY.Client.KeyBindings;
import ShadowGamerXY.Client.KeyInputHandler;
import ShadowGamerXY.Init.ModBlocks;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntityBasicConduit;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import ShadowGamerXY.render.ItemRenderInfuser;
import ShadowGamerXY.render.ItemRenderModularCrate;
import ShadowGamerXY.render.RenderBasicGenerator;
import ShadowGamerXY.render.RenderInfuser;
import ShadowGamerXY.render.RenderModularCrate;
import ShadowGamerXY.render.cable.CableRender;
import ShadowGamerXY.render.cable.ItemCableRender;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy{
	
	  @Override
	    public void preInit(){
	        registerKeybinds();
	        registerRenderThings();
	       
	    }

	    private void registerKeybinds(){
	        FMLCommonHandler.instance().bus().register(new KeyInputHandler());
	        for(KeyBindings key : KeyBindings.values()) {
	            ClientRegistry.registerKeyBinding(key.getKeyBid());
	        }
	        
	    }

	    	
	      
	        

		public void registerRenderThings() {
			TileEntitySpecialRenderer render = new RenderInfuser();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInfuser.class, render);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.Infuser), new ItemRenderInfuser(render, new TileEntityInfuser()));
			
			//ModularCrate
			TileEntitySpecialRenderer render1 = new RenderModularCrate();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityModularCrate.class, render1);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.ModularCrate), new ItemRenderModularCrate(render1, new TileEntityModularCrate()));
		
			
			//Generator
			TileEntitySpecialRenderer render2 = new RenderBasicGenerator();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntiyBasicGenerator.class, render2);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.BasicGen), new ItemRenderModularCrate(render2, new TileEntiyBasicGenerator()));
		
			/*TileEntitySpecialRenderer render3 = new RenderEnergyCube();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntiyEnergyCubeMk1.class, render3);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.EnergyCube), new ItemRenderModularCrate(render3, new TileEntiyEnergyCubeMk1()));
		*/
			/*Conduit
			TileEntitySpecialRenderer render2 = new RenderConduit();
			ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBasicConduit.class, render2);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.BasicConduit), new ItemRenderConduit(render2, new TileEntityBasicConduit()));
		*/
			
			ClientRegistry.registerTileEntity(TileEntityBasicConduit.class, references.MOD_ID + ":BasicConduit", CableRender.instance);
			MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ModBlocks.BasicConduit), ItemCableRender.instace);
				
					
		}
	    

	    @Override
	    public void init(){

	    }

	    @Override
	    public void postInit(){

	    }

	 
	@Override
	    public EntityPlayer getClientPlayer(){
	        return Minecraft.getMinecraft().thePlayer;
	    }


}

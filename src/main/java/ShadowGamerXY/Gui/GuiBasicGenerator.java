package ShadowGamerXY.Gui;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Inventory.machines.ContainerBasicGenerator;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import ShadowGamerXY.Utilitys.GuiUtil;
import ShadowGamerXY.Utilitys.Power.Energy;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiBasicGenerator extends GuiContainer
{
	public final ResourceLocation texture = new ResourceLocation(references.MOD_ID.toLowerCase() + ":textures/gui/guiBasicGenerator.png");
	
	public final EntityPlayer player;
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	public static TileEntiyBasicGenerator te;

	public GuiBasicGenerator(EntityPlayer player, World world, int x,int y,int z) 
	{
		super(new ContainerBasicGenerator(player, world, x, y, z));
	
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.te =(TileEntiyBasicGenerator) world.getTileEntity(x, y, z);
	}



	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{
		this.mc.getTextureManager().bindTexture(texture);;
		GuiUtil.drawRactangle(guiLeft, guiTop, xSize, ySize, 256, 256,0, 0);
		int energyBarSize = 48;
		this.drawTexturedModalRect(guiLeft + 80, guiTop + 7 + energyBarSize - ((IEnergy) te).getEnergyBar().getEnergyLevelScaled(energyBarSize), 176, 0, 16,((IEnergy) te).getEnergyBar().getEnergyLevelScaled(energyBarSize));
		if(te.isBurning())
		{
			this.drawTexturedModalRect(guiLeft + 117, guiTop + 63, 176, 50, 14, 14);
		}
	}
	
	
	@Override
	public void drawGuiContainerForegroundLayer(int x,int y)
	{
		float scale = 0.8f;
		GL11.glScalef(scale, scale, scale);
		int seconds = te.getBurnTime() / (20 * te.burnTimeRemuvedPerTick);
		int minutes = seconds / 60;
		fontRendererObj.drawString(minutes + " minutes and", 8, 8, 4210752);
		fontRendererObj.drawString(seconds + (this.te.isBurning() ? 1 : 0) + " seconds left", 8, 16, 4210752);
		GL11.glScalef(1 / scale, 1 / scale, 1 / scale);
		drawEnergyLevel(x, y);
	}
	

	
	private void drawEnergyLevel(int x, int y)
	{
		int minX = guiLeft + 80;
		int maxX = guiLeft + 95;
		int minY = guiTop + 7;
		int maxY = guiTop + 54;
		
		EnergyBar energyBar = ((IEnergy) te).getEnergyBar();
		if(x >= minX && x <= maxX && y >= minY && y <= maxY)
		{
			this.drawHoveringText(Arrays.asList(energyBar.getEnergyLevel() + " /" + energyBar.getMaxEnergyLevel() + " " + Energy.ShadowCraftEvolved.getName()), x - guiLeft - 6, y - guiTop, fontRendererObj);
		}
	}
	
	private void darwBurnTime(int x, int y)
	{
		int minX = guiLeft + 100;
		int maxX = guiLeft + 114;
		int minY = guiTop + 61;
		int maxY = guiTop + 74;
		
		if(x >= minX && x <= maxX && y >= minY && y <= maxY)
		{
			this.drawHoveringText(Arrays.asList((te.getBurnTime()) / 20 + " Burn seconds left"), x - guiLeft + 10, y - guiTop, fontRendererObj);	
		}
	}
	


}

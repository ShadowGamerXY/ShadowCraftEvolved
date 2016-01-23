package ShadowGamerXY.Gui;

import java.util.Arrays;

import org.lwjgl.opengl.GL11;

import com.oracle.jrockit.jfr.UseConstantPool;

import ShadowGamerXY.Inventory.machines.ContainerBasicGenerator;
import ShadowGamerXY.Inventory.machines.containerElectricFurnice;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyElectricFurnice;
import ShadowGamerXY.Utilitys.GuiUtil;
import ShadowGamerXY.Utilitys.Power.Energy;
import ShadowGamerXY.Utilitys.Power.EnergyBar;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiElectricFurnice extends GuiContainer
{
private static final ResourceLocation texture = new ResourceLocation(references.MOD_ID.toLowerCase() + ":textures/gui/guiElFurnice.png");
	
	public final EntityPlayer player;
	public final World world;
	public final int x;
	public final int y;
	public final int z;
	public static TileEntiyElectricFurnice te;

	public GuiElectricFurnice(EntityPlayer player, World world, int x,int y,int z) 
	{
		super(new containerElectricFurnice(player, world, x, y, z));
	
		this.player = player;
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
		
		this.te =(TileEntiyElectricFurnice) world.getTileEntity(x, y, z);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{		
		xSize = 176;
		this.mc.getTextureManager().bindTexture(texture);		
		GuiUtil.drawRactangle(guiLeft, guiTop, xSize, ySize, 256, 256, 0, 0);
		int energyBarSize= 48;
		this.drawTexturedModalRect(guiLeft + 8, guiTop + 8 + energyBarSize - ((IEnergy) te).getEnergyBar().getEnergyLevelScaled(energyBarSize), 176, 31, 16, ((IEnergy)te).getEnergyBar().getEnergyLevelScaled(energyBarSize));
		int middleX = (this.width - this.xSize) / 2;
		int middleY = (this.height - this.ySize) / 2;
		
		if(this.te.isSmelting)
		{
			this.drawTexturedModalRect(middleX + 56, middleY + 36 + 18, 176, 0, 14, 14);
		}
		int scale = this.te.getCookProgresScaled(24);
		this.drawTexturedModalRect(middleX + 79, middleY + 34, 176, 14, scale + 1, 16);
	}
	
	@Override
	public void drawGuiContainerForegroundLayer(int x,int y)
	{
	drawEnergyLevel(x, y);
	}
	
	private void drawEnergyLevel(int x, int y)
	{
		int minX = guiLeft + 8;
		int maxX = guiLeft + 8 + 15;
		int minY = guiTop + 8;
		int maxY = guiTop + 8 + 47;
		
		EnergyBar energyBar = ((IEnergy) te).getEnergyBar();
		if(x >= minX && x <= maxX && y >= minY && y <= maxY)
		{
			this.drawHoveringText(Arrays.asList(energyBar.getEnergyLevel() + " /" + energyBar.getMaxEnergyLevel() + " " + Energy.ShadowCraftEvolved.getName()), x - guiLeft - 6, y - guiTop, fontRendererObj);
		}
	}
	
	@Override
	 public void updateScreen()
	    {
	        super.updateScreen();
	    }
	
}

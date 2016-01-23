package ShadowGamerXY.Gui;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Inventory.ContainerInfuser;
import ShadowGamerXY.Network.MessageHandleGuiButtonPress;
import ShadowGamerXY.Network.MessageHandleTextUpdate;
import ShadowGamerXY.Network.NetworkHandler;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntityInfuser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiInfuser extends GuiSCE{

	private final TileEntityInfuser te;

	public GuiInfuser(InventoryPlayer playerInventory, TileEntityInfuser te){
	    super(new ContainerInfuser(playerInventory, te), "GuiInfuser", te);
	    this.te = te;
	}

	@Override
	public void initGui(){
	    super.initGui();
	}
	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTick){
	    super.drawScreen(mouseX, mouseY, partialTick);
	    GL11.glDisable(GL11.GL_LIGHTING);
	    GL11.glDisable(GL11.GL_BLEND);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
	    super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}
	
	@Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);     
        this.mc.getTextureManager().bindTexture(guiTexture);
        
        Minecraft.getMinecraft().getTextureManager().bindTexture(guiTexture);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
        

        if (te.hasPower())
        {
            int i1 = te.getPowerRemainingScaled(45);
            drawTexturedModalRect(guiLeft + 11, guiTop + 53 - i1, 176, 94 - i1, 44, i1);
        }
        int j1 = te.getMasherProgressScaled(45);
    drawTexturedModalRect(guiLeft + 63, guiTop + 19, 176, 0, j1 + 1, 43);
    }

	@Override
	public void updateScreen(){
	    super.updateScreen();
	}
	
}

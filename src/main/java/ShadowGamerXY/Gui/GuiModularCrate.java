package ShadowGamerXY.Gui;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Inventory.ContainerModularCrate;
import ShadowGamerXY.Network.MessageHandleTextUpdate;
import ShadowGamerXY.Network.NetworkHandler;
import ShadowGamerXY.TileEntitys.Storage.TileEntityModularCrate;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiModularCrate extends GuiSCE
{ 
private final TileEntityModularCrate te;
private GuiButton resetButton;
private GuiTextField textField;

public GuiModularCrate(InventoryPlayer playerInventory, TileEntityModularCrate te){
    super(new ContainerModularCrate(playerInventory, te), "GuiModularCrate", te);
    this.te = te;
}

@Override
public void initGui(){
    super.initGui();
}


/**
 * Called when the mouse is clicked.
 */
@Override
protected void mouseClicked(int mouseX, int mouseY, int button){
    super.mouseClicked(mouseX, mouseY, button);
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
public void updateScreen(){
    super.updateScreen();
}
}
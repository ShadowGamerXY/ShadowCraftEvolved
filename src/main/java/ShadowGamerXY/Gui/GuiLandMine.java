package ShadowGamerXY.Gui;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Inventory.ContainerLandMine;
import ShadowGamerXY.Network.MessageHandleGuiButtonPress;
import ShadowGamerXY.Network.MessageHandleTextUpdate;
import ShadowGamerXY.Network.NetworkHandler;
import ShadowGamerXY.TileEntitys.Mines.TileEntityLandMineMk3;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiLandMine extends GuiSCE
{ 
private final TileEntityLandMineMk3 te;
private GuiButton resetButton;
private GuiTextField textField;

public GuiLandMine(InventoryPlayer playerInventory, TileEntityLandMineMk3 te){
    super(new ContainerLandMine(playerInventory, te), "GuiLandMine", te);
    this.te = te;
}

@Override
public void initGui(){
    super.initGui();
    resetButton = new GuiButton(0, guiLeft + 10, guiTop + 37, 40, 20, "");
    buttonList.add(resetButton);

    textField = new GuiTextField(fontRendererObj, guiLeft + 100, guiTop + 65, 70, 12);
    textField.setMaxStringLength(40);
    textField.setText(te.getTarget());
}

@Override
public void onTextfieldUpdate(int id){
    if(id == 0) textField.setText(te.getTarget());
}

/**
 * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
 */
@Override
protected void keyTyped(char chr, int keyCode){
    if(textField.textboxKeyTyped(chr, keyCode)) {
        NetworkHandler.sendToServer(new MessageHandleTextUpdate(te, 0, textField.getText()));
    } else {
        super.keyTyped(chr, keyCode);
    }
}

/**
 * Called when the mouse is clicked.
 */
@Override
protected void mouseClicked(int mouseX, int mouseY, int button){
    super.mouseClicked(mouseX, mouseY, button);
    textField.mouseClicked(mouseX, mouseY, button);
}

/**
 * Draws the screen and all the components in it.
 */
@Override
public void drawScreen(int mouseX, int mouseY, float partialTick){
    super.drawScreen(mouseX, mouseY, partialTick);
    GL11.glDisable(GL11.GL_LIGHTING);
    GL11.glDisable(GL11.GL_BLEND);
    textField.drawTextBox();
}

@Override
protected void actionPerformed(GuiButton button){
    if(button.id == 0) NetworkHandler.sendToServer(new MessageHandleGuiButtonPress(te, 0));
}

@Override
protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
    super.drawGuiContainerForegroundLayer(mouseX, mouseY);
    fontRendererObj.drawString(I18n.format("gui.shadowcraftevolved.LandMine.target", te.getTimer()), 120, 55, 0xFF444444);//0xAARRGGBB
    if(te.getTimer() >= 0) fontRendererObj.drawString(I18n.format("gui.shadowcraftevolved.LandMine.timer", te.getTimer()), 10, 25, 0xFF444444);//0xAARRGGBB
}

@Override
public void updateScreen(){
    super.updateScreen();
    resetButton.displayString = I18n.format("gui.shadowcraftevolved.guiButton.button." + (te.getTimer() == -1 ? "restart" : "reset"));
}
}
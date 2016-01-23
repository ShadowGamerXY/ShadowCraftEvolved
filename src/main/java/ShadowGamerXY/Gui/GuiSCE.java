package ShadowGamerXY.Gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import ShadowGamerXY.References.references;

public abstract class GuiSCE extends GuiContainer{

	public ResourceLocation guiTexture;
	private IInventory inventory;
	
	public GuiSCE(Container container, String guiTextureName, IInventory inventory) {
		super(container);
		this.guiTexture  = new ResourceLocation(references.MOD_ID.toLowerCase() + ":textures/gui/" + guiTextureName +".png");
		this.inventory = inventory ;
	}

	
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float portialTick, int mouseX, int mouseY) {
		mc.getTextureManager().bindTexture(guiTexture);
		drawTexturedModalRect(guiLeft, guiTop, 0,0, xSize, ySize);
		
	}
	
	  /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY){
        String s = inventory.hasCustomInventoryName() ? inventory.getInventoryName() : I18n.format(inventory.getInventoryName());
        fontRendererObj.drawString(s, xSize / 2 - fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        //fontRendererObj.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 4210752);
    }

    public void onTextfieldUpdate(int id){}

}

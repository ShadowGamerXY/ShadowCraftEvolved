package ShadowGamerXY.render.cable;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Model.Cables.ModelCable;
import ShadowGamerXY.References.references;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class ItemCableRender implements IItemRenderer
{
	public static final ItemCableRender instace = new ItemCableRender();
	private static final ResourceLocation texture = new ResourceLocation(references.MOD_ID + ":" + "textures/models/Cable.png");

	
	@Override
	public boolean handleRenderType(ItemStack stack, ItemRenderType type)
	{
		return true;
	}
	@Override
	public void renderItem(ItemRenderType type, ItemStack stack, Object...objects)
	{
		int meta = stack.getItemDamage();
		GL11.glPushMatrix();
		GL11.glTranslatef(0.5f, 1.5f, 0.5f);
		GL11.glRotatef(180, 0, 0, 1);
		if(meta == 0)
		{
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			ModelCable.instace.renderMiddle();
			ModelCable.instace.renderDown(false);
			ModelCable.instace.renderUp(false);
			ModelCable.instace.renderNorth(false);
			ModelCable.instace.renderSouth(false);
			ModelCable.instace.renderWeast(false);
			ModelCable.instace.renderEast(false);
		}
		GL11.glPopMatrix();
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) 
	{
		return true;
	}
}

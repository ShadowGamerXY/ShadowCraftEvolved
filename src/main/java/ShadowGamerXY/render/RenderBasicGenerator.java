package ShadowGamerXY.render;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Model.ModelBasicGenerator;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyBasicGenerator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderBasicGenerator extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(references.MOD_ID + ":" + "textures/models/Generator.png");
	
	private ModelBasicGenerator model;
	
	public RenderBasicGenerator() {
		this.model = new ModelBasicGenerator();
	}
	private void adjustRotatePivotViaMeta(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		 GL11.glPushMatrix();
		 GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

	GL11.glPushMatrix();

	GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	this.bindTexture(texture);;
	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

	GL11.glPushMatrix();
	TileEntiyBasicGenerator tile = (TileEntiyBasicGenerator) tileentity;
	int direction = tile.direction;
	GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);

	this.model.modelRender(0.0625F);

	GL11.glPopMatrix();
	GL11.glPopMatrix();
	}

}

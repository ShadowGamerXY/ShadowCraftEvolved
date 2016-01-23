package ShadowGamerXY.render;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Model.ModelEnergyCube;
import ShadowGamerXY.References.references;
import ShadowGamerXY.TileEntitys.Machines.TileEntiyEnergyCubeMk1;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderEnergyCube extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(references.MOD_ID + ":" + "textures/models/EnergyCube.png");
	
	private ModelEnergyCube model;
	
	public RenderEnergyCube() {
		this.model = new ModelEnergyCube();
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
	TileEntiyEnergyCubeMk1 tile = (TileEntiyEnergyCubeMk1) tileentity;
	int direction = tile.direction;
	GL11.glRotatef(direction * 90, 0.0F, 1.0F, 0.0F);

	this.model.render(0.0625F);

	GL11.glPopMatrix();
	GL11.glPopMatrix();
	}

}

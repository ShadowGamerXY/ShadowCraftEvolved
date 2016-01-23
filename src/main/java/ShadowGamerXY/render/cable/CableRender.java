package ShadowGamerXY.render.cable;

import org.lwjgl.opengl.GL11;

import ShadowGamerXY.Model.Cables.ModelCable;
import ShadowGamerXY.References.references;
import ShadowGamerXY.Utilitys.BlockType;
import ShadowGamerXY.Utilitys.Power.IEnergy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

public class CableRender extends TileEntitySpecialRenderer
{
	public static final CableRender instance = new CableRender();
	private static final ResourceLocation texture = new ResourceLocation(references.MOD_ID + ":" + "textures/models/Cable.png");
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double xOffset, double yOffset, double zOffset, float partialTickTime)
    {
        int meta = tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord);
        boolean[][] sides = new boolean[2][6];
        boolean[] cables = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS)
        {
            sides[meta][direction.ordinal()] = tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ) instanceof IEnergy && ((IEnergy) tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ)).canConnect(direction);
            cables[direction.ordinal()] = tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ) instanceof IEnergy && !(((IEnergy) tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ)).getTypeOfBlock()	 == BlockType.CABLE);
        }
        GL11.glPushMatrix();
        GL11.glTranslatef((float) (xOffset + 0.5F), (float) (yOffset + 1.5F), (float) (zOffset + 0.5F));
        GL11.glRotatef(180, 0, 0, 1);
        if (meta == 0)
        {
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
            ModelCable.instace.renderMiddle();
            if (sides[0][0]) ModelCable.instace.renderDown(cables[0]);
            if (sides[0][1]) ModelCable.instace.renderUp(cables[1]);
            if (sides[0][2]) ModelCable.instace.renderNorth(cables[2]);
            if (sides[0][3]) ModelCable.instace.renderSouth(cables[3]);
            if (sides[0][4]) ModelCable.instace.renderWeast(cables[4]);
            if (sides[0][5]) ModelCable.instace.renderEast(cables[5]);
        }
        GL11.glPopMatrix();
    }
	

}

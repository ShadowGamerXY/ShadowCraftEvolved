package ShadowGamerXY.Utilitys;

import net.minecraft.client.renderer.Tessellator;

public class GuiUtil 
{
	public static void drawRactangle(double x, double y, double width, double height, int imageWidth, int imageHeight, double u, double v)
	{
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(x + 0, y + height, 0, u / imageWidth, height / imageHeight);
		tessellator.addVertexWithUV(x + width, y + height, 0, width / imageWidth, height / imageHeight);
		tessellator.addVertexWithUV(x + width, y + 0, 0, width / imageWidth, v / imageHeight);
		tessellator.addVertexWithUV(x + 0, y + 0, 0, u / imageWidth, v / imageHeight);
		tessellator.draw();
	}
}

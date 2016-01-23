package ShadowGamerXY.Model.Cables;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCable extends ModelBase
{
	public static ModelCable instace = new ModelCable();
	
	ModelRenderer Middle;
	ModelRenderer WestClosing;
	ModelRenderer EastClosing;
	ModelRenderer East;
	ModelRenderer Weast;
	ModelRenderer North;
	ModelRenderer NorthClosed;
	ModelRenderer Sauth;
	ModelRenderer SauthClosed;
	ModelRenderer Up;
	ModelRenderer UpClosed;
	ModelRenderer Down;
	ModelRenderer DownClosed;
	
	public ModelCable()
	{
		textureWidth = 64;
		textureHeight = 32;
		
		Middle = new ModelRenderer(this, 30, 0);
		Middle.addBox(0f, 0f, 0f, 4, 4, 4);
		Middle.setRotationPoint(-2f, 14f, -2f);
		Middle.setTextureSize(64, 32);
		Middle.mirror = true;
		setRotation(Middle, 0f, 0f, 0f);
		
		WestClosing = new ModelRenderer(this, 0, 0);
		WestClosing.addBox(0f, 0f, 0f, 1, 6, 6);
		WestClosing.setRotationPoint(7f, 13f, -3f);	
		WestClosing.setTextureSize(64, 32);
		WestClosing.mirror = true;
		setRotation(WestClosing, 0f, 0f, 0f);
		
		EastClosing = new ModelRenderer(this, 0, 0);
		EastClosing.addBox(0f, 0f, 0f, 1, 6, 6);
		EastClosing.setRotationPoint(-8f, 13f, -3f);
		EastClosing.setTextureSize(64, 32);
		EastClosing.mirror = true;
		setRotation(EastClosing, 0f, 0f, 0f);
		
		East = new ModelRenderer(this, 10, 20);
		East.addBox(0f, 0f, 0f, 6, 4, 4);
		East.setRotationPoint(-8f, 14f, -2f);
		East.setTextureSize(64, 32);
		East.mirror = true;
		setRotation(East, 0f, 0f, 0f);
		
		Weast = new ModelRenderer(this, 10, 20);
		Weast.addBox(0f, 0f, 0f, 6, 4, 4);
		Weast.setRotationPoint(2f, 14f, -2f);
		Weast.setTextureSize(64, 32);
		Weast.mirror = true;
		setRotation(Weast, 0f, 0f, 0f);
		
		North = new ModelRenderer(this, 10, 20);
		North.addBox(0f, 0f, 0f, 4, 4, 6);
		North.setRotationPoint(-2f, 14f, -8f);
		North.setTextureSize(32, 32);
		North.mirror = true;
		setRotation(North, 0f, 0f, 0f);
		
		NorthClosed = new ModelRenderer(this, 35, 13);
		NorthClosed.addBox(0f, 0f, 0f, 6, 6, 1);
		NorthClosed.setRotationPoint(-3f, 13f, -8f);
		NorthClosed.setTextureSize(64, 32);
		NorthClosed.mirror = true;
		setRotation(NorthClosed, 0f, 0f, 0f);
		
		Sauth = new ModelRenderer(this, 10, 20);
		Sauth.addBox(0f, 0f, 0f, 4, 4, 6);
		Sauth.setRotationPoint(-2f, 14f, 2);
		Sauth.setTextureSize(64, 32);
		Sauth.mirror = true;
		setRotation(Sauth, 0f, 0f, 0f);
		
		SauthClosed = new ModelRenderer(this, 35, 13);
		SauthClosed.addBox(0f, 0f, 0f, 6, 6, 1);
		SauthClosed.setRotationPoint(-3f, 13f, 7f);
		SauthClosed.setTextureSize(64, 32);
		SauthClosed.mirror = true;
		setRotation(SauthClosed, 0f, 0f, 0f);
		
		Up = new ModelRenderer(this, 10, 20);
		Up.addBox(0f, 0f, 0f, 4, 6, 4);
		Up.setRotationPoint(-2f, 8f, -2f);
		Up.setTextureSize(32, 32);
		Up.mirror = true;
		setRotation(Up, 0f, 0f, 0f);
		
		UpClosed = new ModelRenderer(this, 34, 22);
		UpClosed.addBox(0f, 0f, 0f, 6, 1, 6);
		UpClosed.setRotationPoint(-3f, 8f, -3f);
		UpClosed.setTextureSize(64, 32);
		UpClosed.mirror = true;
		setRotation(UpClosed, 0f, 0f, 0f);
		
		Down = new ModelRenderer(this, 10, 20);
		Down.addBox(0f, 0f, 0f, 4, 6, 4);
		Down.setRotationPoint(-2f, 18f, -2f);
		Down.setTextureSize(64, 32);
		Down.mirror = true;
		setRotation(Down, 0f, 0f, 0f);
		
		DownClosed = new ModelRenderer(this, 34, 22);
		DownClosed.addBox(0f, 0f, 0f, 6, 1, 6);
		DownClosed.setRotationPoint(-3f, 23f, -3f);
		DownClosed.setTextureSize(64, 32);
		DownClosed.mirror = true;
		
	}
	
	  private void setRotation(ModelRenderer model, float x, float y, float z)
	  {
	    model.rotateAngleX = x;
	    model.rotateAngleY = y;
	    model.rotateAngleZ = z;
	  }
	  
	  public void renderMiddle()
	  {
		  Middle.render(0.0625f);
		  
	  }
	  public void renderNorth(boolean closing)
	  {
		  North.render(0.0625f);
		  if(closing) NorthClosed.render(0.0625f);
	  }
	  public void renderSouth(boolean closing)
	  {
		  Sauth.render(0.0625f);
		  if(closing) SauthClosed.render(0.0625f);
	  }
	  public void renderEast(boolean closing)
	  {
		  East.render(0.0625f);
		  if(closing) EastClosing.render(0.0625f);
	  }
	  public void renderWeast(boolean closing)
	  {
		  Weast.render(0.0625f);
		  if(closing) WestClosing.render(0.0625f);
	  }
	  public void renderUp(boolean closing)
	  {
		  Up.render(0.0625f);
		  if(closing) UpClosed.render(0.0625f);
	  }
	  public void renderDown(boolean closing)
	  {
		  Down.render(0.0625f);
		  if(closing) DownClosed.render(0.0625f);
	  }
}

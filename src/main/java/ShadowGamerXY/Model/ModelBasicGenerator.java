// Date: 2.1.2016 15:56:27
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX
package ShadowGamerXY.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBasicGenerator extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Connector4;
    ModelRenderer Connector1;
    ModelRenderer Connector3;
    ModelRenderer Connector2;
    ModelRenderer Base;
    ModelRenderer GenBase;
    ModelRenderer Pylon;
    ModelRenderer Pylon2;
    ModelRenderer Pylon3;
    ModelRenderer Pylon4;
    ModelRenderer pylon5;
    ModelRenderer Shape5;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
  
  public ModelBasicGenerator()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Leg1 = new ModelRenderer(this, 0, 49);
      Leg1.addBox(5F, 12F, 5F, 3, 12, 3);
      Leg1.setRotationPoint(0F, 0F, 0F);
      Leg1.setTextureSize(64, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 49);
      Leg2.addBox(5F, 12F, -8F, 3, 12, 3);
      Leg2.setRotationPoint(0F, 0F, 0F);
      Leg2.setTextureSize(64, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Leg3 = new ModelRenderer(this, 0, 49);
      Leg3.addBox(-8F, 12F, -8F, 3, 12, 3);
      Leg3.setRotationPoint(0F, 0F, 0F);
      Leg3.setTextureSize(64, 64);
      Leg3.mirror = true;
      setRotation(Leg3, 0F, 0F, 0F);
      Leg4 = new ModelRenderer(this, 0, 49);
      Leg4.addBox(-8F, 12F, 5F, 3, 12, 3);
      Leg4.setRotationPoint(0F, 0F, 0F);
      Leg4.setTextureSize(64, 64);
      Leg4.mirror = true;
      setRotation(Leg4, 0F, 0F, 0F);
      Connector4 = new ModelRenderer(this, 45, 38);
      Connector4.addBox(-3F, 13F, -8F, 6, 6, 1);
      Connector4.setRotationPoint(0F, 0F, 0F);
      Connector4.setTextureSize(64, 64);
      Connector4.mirror = true;
      setRotation(Connector4, 0F, 0F, 0F);
      Connector1 = new ModelRenderer(this, 0, 30);
      Connector1.addBox(7F, 13F, -3F, 1, 6, 6);
      Connector1.setRotationPoint(0F, 0F, 0F);
      Connector1.setTextureSize(64, 64);
      Connector1.mirror = true;
      setRotation(Connector1, 0F, 0F, 0F);
      Connector3 = new ModelRenderer(this, 45, 38);
      Connector3.addBox(-3F, 13F, 7F, 6, 6, 1);
      Connector3.setRotationPoint(0F, 0F, 0F);
      Connector3.setTextureSize(64, 64);
      Connector3.mirror = true;
      setRotation(Connector3, 0F, 0F, 0F);
      Connector2 = new ModelRenderer(this, 0, 30);
      Connector2.addBox(-8F, 13F, -3F, 1, 6, 6);
      Connector2.setRotationPoint(0F, 0F, 0F);
      Connector2.setTextureSize(64, 64);
      Connector2.mirror = true;
      setRotation(Connector2, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(-8F, 22F, -8F, 16, 2, 16);
      Base.setRotationPoint(0F, 0F, 0F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      GenBase = new ModelRenderer(this, 18, 21);
      GenBase.addBox(-5F, 15F, -5F, 10, 1, 10);
      GenBase.setRotationPoint(0F, 0F, 0F);
      GenBase.setTextureSize(64, 64);
      GenBase.mirror = true;
      setRotation(GenBase, 0F, 0F, 0F);
      Pylon = new ModelRenderer(this, 30, 39);
      Pylon.addBox(-0.5F, 7F, -7F, 1, 8, 1);
      Pylon.setRotationPoint(0F, 0F, 0F);
      Pylon.setTextureSize(64, 64);
      Pylon.mirror = true;
      setRotation(Pylon, 0.7853982F, 0.7853982F, 0F);
      Pylon2 = new ModelRenderer(this, 35, 39);
      Pylon2.addBox(-0.5F, 5.8F, -6.5F, 1, 9, 1);
      Pylon2.setRotationPoint(0F, 1F, 0F);
      Pylon2.setTextureSize(64, 64);
      Pylon2.mirror = true;
      setRotation(Pylon2, 0.7853982F, -0.7853982F, 0F);
      Pylon3 = new ModelRenderer(this, 35, 39);
      Pylon3.addBox(-0.5F, 5.8F, -6.5F, 1, 9, 1);
      Pylon3.setRotationPoint(0F, 1F, 0F);
      Pylon3.setTextureSize(64, 64);
      Pylon3.mirror = true;
      setRotation(Pylon3, 0.7853982F, 2.356194F, 0F);
      Pylon4 = new ModelRenderer(this, 30, 39);
      Pylon4.addBox(-0.5F, 7F, -7F, 1, 8, 1);
      Pylon4.setRotationPoint(0F, 0F, 0F);
      Pylon4.setTextureSize(64, 64);
      Pylon4.mirror = true;
      setRotation(Pylon4, 0.7853982F, -2.356194F, 0F);
      pylon5 = new ModelRenderer(this, 35, 39);
      pylon5.addBox(-0.5F, 10F, -0.5F, 1, 9, 1);
      pylon5.setRotationPoint(0F, 0F, 0F);
      pylon5.setTextureSize(64, 64);
      pylon5.mirror = true;
      setRotation(pylon5, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 21);
      Shape5.addBox(-1.5F, 8F, -1.5F, 3, 3, 3);
      Shape5.setRotationPoint(0F, 0F, 0F);
      Shape5.setTextureSize(64, 64);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 15, 49);
      Shape1.addBox(-2F, 16F, 2F, 4, 4, 5);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 15, 49);
      Shape2.addBox(-2F, 16F, -7F, 4, 4, 5);
      Shape2.setRotationPoint(0F, 0F, 0F);
      Shape2.setTextureSize(64, 64);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 35, 50);
      Shape3.addBox(2F, 16F, -2F, 5, 4, 4);
      Shape3.setRotationPoint(0F, 0F, 0F);
      Shape3.setTextureSize(64, 64);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 35, 50);
      Shape4.addBox(-7F, 16F, -2F, 5, 4, 4);
      Shape4.setRotationPoint(0F, 0F, 0F);
      Shape4.setTextureSize(64, 64);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Leg3.render(f5);
    Leg4.render(f5);
    Connector4.render(f5);
    Connector1.render(f5);
    Connector3.render(f5);
    Connector2.render(f5);
    Base.render(f5);
    GenBase.render(f5);
    Pylon.render(f5);
    Pylon2.render(f5);
    Pylon3.render(f5);
    Pylon4.render(f5);
    pylon5.render(f5);
    Shape5.render(f5);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
  }
  
  public void modelRender(float f5)
  {
	  Leg1.render(f5);
	    Leg2.render(f5);
	    Leg3.render(f5);
	    Leg4.render(f5);
	    Connector4.render(f5);
	    Connector1.render(f5);
	    Connector3.render(f5);
	    Connector2.render(f5);
	    Base.render(f5);
	    GenBase.render(f5);
	    Pylon.render(f5);
	    Pylon2.render(f5);
	    Pylon3.render(f5);
	    Pylon4.render(f5);
	    pylon5.render(f5);
	    Shape5.render(f5);
	    Shape1.render(f5);
	    Shape2.render(f5);
	    Shape3.render(f5);
	    Shape4.render(f5);
  }
  
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
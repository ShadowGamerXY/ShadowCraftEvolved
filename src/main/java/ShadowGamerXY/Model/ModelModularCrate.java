// Date: 26.12.2015 19:32:24
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package ShadowGamerXY.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelModularCrate extends ModelBase
{
  //fields
    ModelRenderer Base2;
    ModelRenderer Base;
    ModelRenderer Base6;
    ModelRenderer Base4;
    ModelRenderer Base5;
    ModelRenderer Base3;
    ModelRenderer Base7;
    ModelRenderer Base8;
    ModelRenderer Base9;
    ModelRenderer Base10;
    ModelRenderer Base11;
    ModelRenderer Base12;
    ModelRenderer Shape1;
  
  public ModelModularCrate()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      Base2 = new ModelRenderer(this, 0, 0);
      Base2.addBox(-8F, 8F, 6F, 2, 16, 2);
      Base2.setRotationPoint(0F, 0F, 0F);
      Base2.setTextureSize(64, 64);
      Base2.mirror = true;
      setRotation(Base2, 0F, 0F, 0F);
      Base = new ModelRenderer(this, 0, 0);
      Base.addBox(6F, 8F, 6F, 2, 16, 2);
      Base.setRotationPoint(0F, 0F, 0F);
      Base.setTextureSize(64, 64);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Base6 = new ModelRenderer(this, 0, 0);
      Base6.addBox(-8F, 22F, 6F, 16, 2, 2);
      Base6.setRotationPoint(0F, 0F, 0F);
      Base6.setTextureSize(64, 64);
      Base6.mirror = true;
      setRotation(Base6, 0F, 0F, 0F);
      Base4 = new ModelRenderer(this, 0, 0);
      Base4.addBox(6F, 8F, -8F, 2, 16, 2);
      Base4.setRotationPoint(0F, 0F, 0F);
      Base4.setTextureSize(64, 64);
      Base4.mirror = true;
      setRotation(Base4, 0F, 0F, 0F);
      Base5 = new ModelRenderer(this, 0, 0);
      Base5.addBox(-8F, 8F, -8F, 2, 16, 2);
      Base5.setRotationPoint(0F, 0F, 0F);
      Base5.setTextureSize(64, 64);
      Base5.mirror = true;
      setRotation(Base5, 0F, 0F, 0F);
      Base3 = new ModelRenderer(this, 0, 0);
      Base3.addBox(-8F, 22F, -8F, 16, 2, 2);
      Base3.setRotationPoint(0F, 0F, 0F);
      Base3.setTextureSize(64, 64);
      Base3.mirror = true;
      setRotation(Base3, 0F, 0F, 0F);
      Base7 = new ModelRenderer(this, 0, 0);
      Base7.addBox(-8F, 8F, -8F, 16, 2, 2);
      Base7.setRotationPoint(0F, 0F, 0F);
      Base7.setTextureSize(64, 64);
      Base7.mirror = true;
      setRotation(Base7, 0F, 0F, 0F);
      Base8 = new ModelRenderer(this, 0, 0);
      Base8.addBox(-8F, 8F, 6F, 16, 2, 2);
      Base8.setRotationPoint(0F, 0F, 0F);
      Base8.setTextureSize(64, 64);
      Base8.mirror = true;
      setRotation(Base8, 0F, 0F, 0F);
      Base9 = new ModelRenderer(this, 0, 0);
      Base9.addBox(-8F, 8F, -8F, 2, 2, 16);
      Base9.setRotationPoint(0F, 0F, 0F);
      Base9.setTextureSize(64, 64);
      Base9.mirror = true;
      setRotation(Base9, 0F, 0F, 0F);
      Base10 = new ModelRenderer(this, 0, 0);
      Base10.addBox(6F, 8F, -8F, 2, 2, 16);
      Base10.setRotationPoint(0F, 0F, 0F);
      Base10.setTextureSize(64, 64);
      Base10.mirror = true;
      setRotation(Base10, 0F, 0F, 0F);
      Base11 = new ModelRenderer(this, 0, 0);
      Base11.addBox(6F, 22F, -8F, 2, 2, 16);
      Base11.setRotationPoint(0F, 0F, 0F);
      Base11.setTextureSize(64, 64);
      Base11.mirror = true;
      setRotation(Base11, 0F, 0F, 0F);
      Base12 = new ModelRenderer(this, 0, 0);
      Base12.addBox(-8F, 22F, -8F, 2, 2, 16);
      Base12.setRotationPoint(0F, 0F, 0F);
      Base12.setTextureSize(64, 64);
      Base12.mirror = true;
      setRotation(Base12, 0F, 0F, 0F);
      Shape1 = new ModelRenderer(this, 2, 43);
      Shape1.addBox(6F, 6F, -5F, 10, 10, 10);
      Shape1.setRotationPoint(0F, 0F, 0F);
      Shape1.setTextureSize(64, 64);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0.7853982F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Base2.render(f5);
    Base.render(f5);
    Base6.render(f5);
    Base4.render(f5);
    Base5.render(f5);
    Base3.render(f5);
    Base7.render(f5);
    Base8.render(f5);
    Base9.render(f5);
    Base10.render(f5);
    Base11.render(f5);
    Base12.render(f5);
    Shape1.render(f5);
  }
  public void renderModel(float f5){
	  Base2.render(f5);
	    Base.render(f5);
	    Base6.render(f5);
	    Base4.render(f5);
	    Base5.render(f5);
	    Base3.render(f5);
	    Base7.render(f5);
	    Base8.render(f5);
	    Base9.render(f5);
	    Base10.render(f5);
	    Base11.render(f5);
	    Base12.render(f5);
	    Shape1.render(f5);
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

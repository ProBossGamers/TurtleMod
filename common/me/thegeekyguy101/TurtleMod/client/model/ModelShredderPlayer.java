package me.thegeekyguy101.TurtleMod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelShredderPlayer extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Sholderplate1;
    ModelRenderer Sholderplate2;
    ModelRenderer HelmTop;
    ModelRenderer Helmright;
    ModelRenderer Helmleft;
    ModelRenderer Helmforhead;
    ModelRenderer Headspike1;
    ModelRenderer Headspike2;
    ModelRenderer Headspike3;
    ModelRenderer Headspike4;
    ModelRenderer sholderspikeright1;
    ModelRenderer sholderspikeright2;
    ModelRenderer sholderspikeright3;
    ModelRenderer sholderspikeright4;
    ModelRenderer sholderspikeleft1;
    ModelRenderer sholderspikeleft2;
    ModelRenderer sholderspikeleft3;
    ModelRenderer sholderspikeleft4;
    ModelRenderer Skirtright;
    ModelRenderer Skirtleft;
    ModelRenderer Skirtback;
    ModelRenderer Skirtfront;
    ModelRenderer clawpart1;
    ModelRenderer clawpart2;
    ModelRenderer clawpart3;
    ModelRenderer clawpart4;
  
  public ModelShredderPlayer()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(128, 128);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(128, 128);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(128, 128);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(128, 128);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 128);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 128);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      Sholderplate1 = new ModelRenderer(this, 42, 0);
      Sholderplate1.addBox(0F, 0F, 0F, 5, 1, 6);
      Sholderplate1.setRotationPoint(4F, -1F, -3F);
      Sholderplate1.setTextureSize(128, 128);
      Sholderplate1.mirror = true;
      setRotation(Sholderplate1, 0F, 0F, 0F);
      Sholderplate2 = new ModelRenderer(this, 43, 0);
      Sholderplate2.addBox(0F, 0F, 0F, 5, 1, 6);
      Sholderplate2.setRotationPoint(-9F, -1F, -3F);
      Sholderplate2.setTextureSize(128, 128);
      Sholderplate2.mirror = true;
      setRotation(Sholderplate2, 0F, 0F, 0F);
      HelmTop = new ModelRenderer(this, 73, 0);
      HelmTop.addBox(0F, 0F, 0F, 8, 1, 9);
      HelmTop.setRotationPoint(-4F, -9F, -5F);
      HelmTop.setTextureSize(128, 128);
      HelmTop.mirror = true;
      setRotation(HelmTop, 0F, 0F, 0F);
      Helmright = new ModelRenderer(this, 86, 12);
      Helmright.addBox(0F, 0F, 0F, 1, 9, 9);
      Helmright.setRotationPoint(-5F, -9F, -5F);
      Helmright.setTextureSize(128, 128);
      Helmright.mirror = true;
      setRotation(Helmright, 0F, 0F, 0F);
      Helmleft = new ModelRenderer(this, 86, 12);
      Helmleft.addBox(0F, 0F, 0F, 1, 9, 9);
      Helmleft.setRotationPoint(4F, -9F, -5F);
      Helmleft.setTextureSize(128, 128);
      Helmleft.mirror = true;
      setRotation(Helmleft, 0F, 0F, 0F);
      Helmforhead = new ModelRenderer(this, 87, 23);
      Helmforhead.addBox(0F, 0F, 0F, 8, 2, 1);
      Helmforhead.setRotationPoint(-4F, -8F, -5F);
      Helmforhead.setTextureSize(128, 128);
      Helmforhead.mirror = true;
      setRotation(Helmforhead, 0F, 0F, 0F);
      Headspike1 = new ModelRenderer(this, 82, 1);
      Headspike1.addBox(0F, 0F, 0F, 6, 1, 1);
      Headspike1.setRotationPoint(-3F, -8F, -6F);
      Headspike1.setTextureSize(128, 128);
      Headspike1.mirror = true;
      setRotation(Headspike1, 0F, 0F, 0F);
      Headspike2 = new ModelRenderer(this, 49, 0);
      Headspike2.addBox(0F, 0F, 0F, 2, 6, 1);
      Headspike2.setRotationPoint(-1F, -14F, -6F);
      Headspike2.setTextureSize(128, 128);
      Headspike2.mirror = true;
      setRotation(Headspike2, 0F, 0F, 0F);
      Headspike3 = new ModelRenderer(this, 52, 0);
      Headspike3.addBox(-1F, -5F, 0F, 1, 5, 1);
      Headspike3.setRotationPoint(-2F, -8F, -6F);
      Headspike3.setTextureSize(128, 128);
      Headspike3.mirror = true;
      setRotation(Headspike3, 0F, 0F, -0.4886922F);
      Headspike4 = new ModelRenderer(this, 53, 0);
      Headspike4.addBox(0F, -5F, 0F, 1, 5, 1);
      Headspike4.setRotationPoint(2F, -8F, -6F);
      Headspike4.setTextureSize(128, 128);
      Headspike4.mirror = true;
      setRotation(Headspike4, 0F, 0F, 0.4886922F);
      sholderspikeright1 = new ModelRenderer(this, 52, 0);
      sholderspikeright1.addBox(-1F, -3F, 0F, 1, 3, 1);
      sholderspikeright1.setRotationPoint(-5F, -1F, 1F);
      sholderspikeright1.setTextureSize(128, 128);
      sholderspikeright1.mirror = true;
      setRotation(sholderspikeright1, 0F, 0F, -0.3490659F);
      sholderspikeright2 = new ModelRenderer(this, 52, 0);
      sholderspikeright2.addBox(-1F, -3F, 0F, 1, 3, 1);
      sholderspikeright2.setRotationPoint(-8F, -1F, -2F);
      sholderspikeright2.setTextureSize(128, 128);
      sholderspikeright2.mirror = true;
      setRotation(sholderspikeright2, 0F, 0F, -0.3490659F);
      sholderspikeright3 = new ModelRenderer(this, 52, 0);
      sholderspikeright3.addBox(-1F, -3F, 0F, 1, 3, 1);
      sholderspikeright3.setRotationPoint(-5F, -1F, -2F);
      sholderspikeright3.setTextureSize(128, 128);
      sholderspikeright3.mirror = true;
      setRotation(sholderspikeright3, 0F, 0F, -0.3490659F);
      sholderspikeright4 = new ModelRenderer(this, 52, 0);
      sholderspikeright4.addBox(-1F, -3F, 0F, 1, 3, 1);
      sholderspikeright4.setRotationPoint(-8F, -1F, 1F);
      sholderspikeright4.setTextureSize(128, 128);
      sholderspikeright4.mirror = true;
      setRotation(sholderspikeright4, 0F, 0F, -0.3490659F);
      sholderspikeleft1 = new ModelRenderer(this, 52, 0);
      sholderspikeleft1.addBox(0F, -3F, 0F, 1, 3, 1);
      sholderspikeleft1.setRotationPoint(5F, -1F, -2F);
      sholderspikeleft1.setTextureSize(128, 128);
      sholderspikeleft1.mirror = true;
      setRotation(sholderspikeleft1, 0F, 0F, 0.3490659F);
      sholderspikeleft2 = new ModelRenderer(this, 52, 0);
      sholderspikeleft2.addBox(0F, -3F, 0F, 1, 3, 1);
      sholderspikeleft2.setRotationPoint(5F, -1F, 1F);
      sholderspikeleft2.setTextureSize(128, 128);
      sholderspikeleft2.mirror = true;
      setRotation(sholderspikeleft2, 0F, 0F, 0.3490659F);
      sholderspikeleft3 = new ModelRenderer(this, 52, 0);
      sholderspikeleft3.addBox(0F, -3F, 0F, 1, 3, 1);
      sholderspikeleft3.setRotationPoint(8F, -1F, 1F);
      sholderspikeleft3.setTextureSize(128, 128);
      sholderspikeleft3.mirror = true;
      setRotation(sholderspikeleft3, 0F, 0F, 0.3490659F);
      sholderspikeleft4 = new ModelRenderer(this, 52, 0);
      sholderspikeleft4.addBox(0F, -3F, 0F, 1, 3, 1);
      sholderspikeleft4.setRotationPoint(8F, -1F, -2F);
      sholderspikeleft4.setTextureSize(128, 128);
      sholderspikeleft4.mirror = true;
      setRotation(sholderspikeleft4, 0F, 0F, 0.3490659F);
      Skirtright = new ModelRenderer(this, 58, 14);
      Skirtright.addBox(0F, 0F, 0F, 1, 4, 5);
      Skirtright.setRotationPoint(-5F, 12F, -3F);
      Skirtright.setTextureSize(128, 128);
      Skirtright.mirror = true;
      setRotation(Skirtright, 0F, 0F, 0F);
      Skirtleft = new ModelRenderer(this, 58, 14);
      Skirtleft.addBox(0F, 0F, 0F, 1, 4, 5);
      Skirtleft.setRotationPoint(4F, 12F, -3F);
      Skirtleft.setTextureSize(128, 128);
      Skirtleft.mirror = true;
      setRotation(Skirtleft, 0F, 0F, 0F);
      Skirtback = new ModelRenderer(this, 60, 25);
      Skirtback.addBox(0F, 0F, 0F, 10, 4, 1);
      Skirtback.setRotationPoint(-5F, 12F, 2F);
      Skirtback.setTextureSize(128, 128);
      Skirtback.mirror = true;
      setRotation(Skirtback, 0F, 0F, 0F);
      Skirtfront = new ModelRenderer(this, 65, 35);
      Skirtfront.addBox(0F, 0F, 0F, 8, 4, 1);
      Skirtfront.setRotationPoint(-4F, 12F, -3F);
      Skirtfront.setTextureSize(128, 128);
      Skirtfront.mirror = true;
      setRotation(Skirtfront, 0F, 0F, 0F);
      clawpart1 = new ModelRenderer(this, 50, 0);
      clawpart1.addBox(0F, 0F, 0F, 2, 1, 1);
      clawpart1.setRotationPoint(8F, 9F, -2F);
      clawpart1.setTextureSize(128, 128);
      clawpart1.mirror = true;
      setRotation(clawpart1, 0F, 0F, 0F);
      clawpart2 = new ModelRenderer(this, 50, 0);
      clawpart2.addBox(0F, 0F, 0F, 2, 1, 1);
      clawpart2.setRotationPoint(8F, 9F, 1F);
      clawpart2.setTextureSize(128, 128);
      clawpart2.mirror = true;
      setRotation(clawpart2, 0F, 0F, 0F);
      clawpart3 = new ModelRenderer(this, 51, 0);
      clawpart3.addBox(0F, 0F, 0F, 1, 4, 1);
      clawpart3.setRotationPoint(9F, 10F, 1F);
      clawpart3.setTextureSize(128, 128);
      clawpart3.mirror = true;
      setRotation(clawpart3, 0F, 0F, 0F);
      clawpart4 = new ModelRenderer(this, 51, 0);
      clawpart4.addBox(9F, 0F, 0F, 1, 4, 1);
      clawpart4.setRotationPoint(0F, 10F, -2F);
      clawpart4.setTextureSize(128, 128);
      clawpart4.mirror = true;
      setRotation(clawpart4, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    Sholderplate1.render(f5);
    Sholderplate2.render(f5);
    HelmTop.render(f5);
    Helmright.render(f5);
    Helmleft.render(f5);
    Helmforhead.render(f5);
    Headspike1.render(f5);
    Headspike2.render(f5);
    Headspike3.render(f5);
    Headspike4.render(f5);
    sholderspikeright1.render(f5);
    sholderspikeright2.render(f5);
    sholderspikeright3.render(f5);
    sholderspikeright4.render(f5);
    sholderspikeleft1.render(f5);
    sholderspikeleft2.render(f5);
    sholderspikeleft3.render(f5);
    sholderspikeleft4.render(f5);
    Skirtright.render(f5);
    Skirtleft.render(f5);
    Skirtback.render(f5);
    Skirtfront.render(f5);
    clawpart1.render(f5);
    clawpart2.render(f5);
    clawpart3.render(f5);
    clawpart4.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
  {
	  this.head.rotateAngleY = par4 / (180F / (float)Math.PI);
      this.head.rotateAngleX = par5 / (180F / (float)Math.PI);
      this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 2.0F * par2 * 0.5F;
      this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 2.0F * par2 * 0.5F;
      this.rightarm.rotateAngleZ = 0.0F;
      this.leftarm.rotateAngleZ = 0.0F;
      this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
      this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.4F * par2;
      this.rightleg.rotateAngleY = 0.0F;
      this.leftleg.rotateAngleY = 0.0F;

      if (this.isRiding)
      {
          this.rightarm.rotateAngleX += -((float)Math.PI / 5F);
          this.leftarm.rotateAngleX += -((float)Math.PI / 5F);
          this.rightleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.leftleg.rotateAngleX = -((float)Math.PI * 2F / 5F);
          this.rightleg.rotateAngleY = ((float)Math.PI / 10F);
          this.leftleg.rotateAngleY = -((float)Math.PI / 10F);
      }

      this.rightarm.rotateAngleY = 0.0F;
      this.leftarm.rotateAngleY = 0.0F;
      float f6;
      float f7;

      if (this.onGround > -9990.0F)
      {
          f6 = this.onGround;
          this.body.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(f6) * (float)Math.PI * 2.0F) * 0.2F;
          this.rightarm.rotationPointZ = MathHelper.sin(this.body.rotateAngleY) * 5.0F;
          this.rightarm.rotationPointX = -MathHelper.cos(this.body.rotateAngleY) * 5.0F;
          this.leftarm.rotationPointZ = -MathHelper.sin(this.body.rotateAngleY) * 5.0F;
          this.leftarm.rotationPointX = MathHelper.cos(this.body.rotateAngleY) * 5.0F;
          this.rightarm.rotateAngleY += this.body.rotateAngleY;
          this.leftarm.rotateAngleY += this.body.rotateAngleY;
          this.leftarm.rotateAngleX += this.body.rotateAngleY;
          f6 = 1.0F - this.onGround;
          f6 *= f6;
          f6 *= f6;
          f6 = 1.0F - f6;
          f7 = MathHelper.sin(f6 * (float)Math.PI);
          float f8 = MathHelper.sin(this.onGround * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;
          this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
          this.rightarm.rotateAngleY += this.body.rotateAngleY * 2.0F;
          this.rightarm.rotateAngleZ = MathHelper.sin(this.onGround * (float)Math.PI) * -0.4F;
      }

      this.rightarm.rotateAngleZ += MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      this.leftarm.rotateAngleZ -= MathHelper.cos(par3 * 0.09F) * 0.05F + 0.05F;
      this.rightarm.rotateAngleX += MathHelper.sin(par3 * 0.067F) * 0.05F;
      this.leftarm.rotateAngleX -= MathHelper.sin(par3 * 0.067F) * 0.05F;

     
  }

}

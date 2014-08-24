package net.probossgamers.turtlemod.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Ryan, you can clean up the model classes...
 */
public class ModelTurtle extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer FrontRight;
    ModelRenderer FrontLeft;
    ModelRenderer BackLeft;
    ModelRenderer BackRight;
    ModelRenderer Shape1;

    public ModelTurtle()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 6, 4, 6);
        this.head.setRotationPoint(1.0F, 21.0F, -2.0F);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 8, 8, 4);
        this.body.setRotationPoint(1.0F, 15.0F, 6.0F);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, ((float) Math.PI / 2F), 0.0F, 0.0F);
        this.FrontRight = new ModelRenderer(this, 0, 16);
        this.FrontRight.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.FrontRight.setRotationPoint(-7.0F, 21.0F, -4.0F);
        this.FrontRight.setTextureSize(64, 64);
        this.FrontRight.mirror = true;
        this.setRotation(this.FrontRight, 0.0F, 0.0F, 0.0F);
        this.FrontLeft = new ModelRenderer(this, 0, 16);
        this.FrontLeft.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.FrontLeft.setRotationPoint(4.0F, 21.0F, -4.0F);
        this.FrontLeft.setTextureSize(64, 64);
        this.FrontLeft.mirror = true;
        this.setRotation(this.FrontLeft, 0.0F, 0.0F, 0.0F);
        this.BackLeft = new ModelRenderer(this, 0, 16);
        this.BackLeft.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.BackLeft.setRotationPoint(4.0F, 21.0F, 1.0F);
        this.BackLeft.setTextureSize(64, 64);
        this.BackLeft.mirror = true;
        this.setRotation(this.BackLeft, 0.0F, 0.0F, 0.0F);
        this.BackRight = new ModelRenderer(this, 0, 16);
        this.BackRight.addBox(0.0F, 0.0F, 0.0F, 3, 3, 3);
        this.BackRight.setRotationPoint(-7.0F, 21.0F, 1.0F);
        this.BackRight.setTextureSize(64, 64);
        this.BackRight.mirror = true;
        this.setRotation(this.BackRight, 0.0F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 28, 21);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Shape1.setRotationPoint(-3.0F, 17.0F, -3.0F);
        this.Shape1.setTextureSize(64, 64);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
    }

    public void render(Entity entity, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(entity, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7, entity);
        this.head.render(var7);
        this.body.render(var7);
        this.FrontRight.render(var7);
        this.FrontLeft.render(var7);
        this.BackLeft.render(var7);
        this.BackRight.render(var7);
        this.Shape1.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

        FrontRight.rotateAngleY = 0.0F;
        FrontLeft.rotateAngleY = 0.0F;
        BackLeft.rotateAngleY = 0.0F;
        BackRight.rotateAngleY = 0.0F;
    }
}

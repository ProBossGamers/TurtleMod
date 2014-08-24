package net.probossgamers.turtlemod.client.model.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

/**
 * Ryan, you can clean up the model classes...
 */
public class ModelMineTurtle extends ModelBase
{
    ModelRenderer Shape2;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer FrontRight;
    ModelRenderer FrontLeft;
    ModelRenderer BackLeft;
    ModelRenderer BackRight;
    ModelRenderer Shape1;

    public ModelMineTurtle()
    {
        textureWidth = 64;
        textureHeight = 64;

        Shape2 = new ModelRenderer(this, 28, 0);
        Shape2.addBox(0F, 0F, 0F, 2, 1, 2);
        Shape2.setRotationPoint(-1F, 16F, -1F);
        Shape2.setTextureSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -8F, 6, 4, 6);
        head.setRotationPoint(1F, 21F, -2F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 28, 8);
        body.addBox(-5F, -10F, -7F, 8, 8, 4);
        body.setRotationPoint(1F, 15F, 6F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 1.570796F, 0F, 0F);
        FrontRight = new ModelRenderer(this, 0, 16);
        FrontRight.addBox(0F, 0F, 0F, 3, 3, 3);
        FrontRight.setRotationPoint(-7.0F, 21.0F, -4.0F);
        FrontRight.setTextureSize(64, 64);
        FrontRight.mirror = true;
        setRotation(FrontRight, 0F, 0F, 0F);
        FrontLeft = new ModelRenderer(this, 0, 16);
        FrontLeft.addBox(0F, 0F, 0F, 3, 3, 3);
        FrontLeft.setRotationPoint(4.0F, 21.0F, -4.0F);
        FrontLeft.setTextureSize(64, 64);
        FrontLeft.mirror = true;
        setRotation(FrontLeft, 0F, 0F, 0F);
        BackLeft = new ModelRenderer(this, 0, 16);
        BackLeft.addBox(0F, 0F, 0F, 3, 3, 3);
        BackLeft.setRotationPoint(4F, 21F, 1F);
        BackLeft.setTextureSize(64, 64);
        BackLeft.mirror = true;
        setRotation(BackLeft, 0F, 0F, 0F);
        BackRight = new ModelRenderer(this, 0, 16);
        BackRight.addBox(0F, 0F, 0F, 3, 3, 3);
        BackRight.setRotationPoint(-7F, 21F, 1F);
        BackRight.setTextureSize(64, 64);
        BackRight.mirror = true;
        setRotation(BackRight, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 28, 21);
        Shape1.addBox(0F, 0F, 0F, 6, 1, 6);
        Shape1.setRotationPoint(-3F, 17F, -3F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Shape2.render(f5);
        head.render(f5);
        body.render(f5);
        FrontRight.render(f5);
        FrontLeft.render(f5);
        BackLeft.render(f5);
        BackRight.render(f5);
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
        FrontLeft.rotateAngleX = MathHelper.cos(f * 0.666F) * 1.4F * f1;
        FrontRight.rotateAngleX = MathHelper.cos(f * 0.666F + (float) Math.PI) * 1.4F * f1;
        BackLeft.rotateAngleX = MathHelper.cos(f * 0.666F + (float) Math.PI) * 1.4F * f1;
        BackRight.rotateAngleX = MathHelper.cos(f * 0.666F) * 1.4F * f1;

        FrontRight.rotateAngleY = 0.0F;
        FrontLeft.rotateAngleY = 0.0F;
        BackLeft.rotateAngleY = 0.0F;
        BackRight.rotateAngleY = 0.0F;
    }
}

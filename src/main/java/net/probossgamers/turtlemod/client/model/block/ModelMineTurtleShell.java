// Date: 25/08/2014 9:28:23 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package net.probossgamers.turtlemod.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMineTurtleShell extends ModelBase
{
    //fields
    ModelRenderer body;
    ModelRenderer Shape1;
    ModelRenderer Shape2;

    public ModelMineTurtleShell()
    {
        textureWidth = 64;
        textureHeight = 64;

        body = new ModelRenderer(this, 28, 8);
        body.addBox(-5F, -10F, -7F, 8, 8, 4);
        body.setRotationPoint(1F, 17F, 6F);
        body.setTextureSize(64, 64);
        body.mirror = true;
        setRotation(body, 1.570796F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 28, 21);
        Shape1.addBox(0F, 0F, 0F, 6, 1, 6);
        Shape1.setRotationPoint(-3F, 19F, -3F);
        Shape1.setTextureSize(64, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 28, 0);
        Shape2.addBox(0F, 0F, 0F, 2, 1, 2);
        Shape2.setRotationPoint(-1F, 18F, -1F);
        Shape2.setTextureSize(64, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
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
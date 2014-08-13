package net.probossgamers.turtlemod.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTurtleShell extends ModelBase
{
    //fields
    ModelRenderer bottom_shell;
    ModelRenderer topshell;

    public ModelTurtleShell()
    {
        textureWidth = 64;
        textureHeight = 64;

        bottom_shell = new ModelRenderer(this, 28, 8);
        bottom_shell.addBox(-4F, -4F, -4F, 8, 8, 4);
        bottom_shell.setRotationPoint(0F, 20F, 0F);
        bottom_shell.setTextureSize(64, 64);
        bottom_shell.mirror = true;
        setRotation(bottom_shell, 1.570796F, 0F, 0F);
        topshell = new ModelRenderer(this, 28, 21);
        topshell.addBox(-3F, 0F, -3F, 6, 1, 6);
        topshell.setRotationPoint(0F, 19F, 0F);
        topshell.setTextureSize(64, 64);
        topshell.mirror = true;
        setRotation(topshell, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        bottom_shell.render(f5);
        topshell.render(f5);
    }

    public void renderModel(float f) {
        bottom_shell.render(f);
        topshell.render(f);
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
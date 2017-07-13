package com.probossgamers.turtlemod.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Turtle by DeathJusty
 */
@SideOnly(Side.CLIENT)
public class ModelTurtleOriginal extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer bodytop;
    public ModelRenderer head;
    public ModelRenderer leftbackfoot;
    public ModelRenderer rightbackfoot;
    public ModelRenderer rightfrontfoot;
    public ModelRenderer leftfrontfoot;

    public ModelTurtleOriginal() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.body = new ModelRenderer(this, 28, 8);
        this.body.setRotationPoint(0.0F, 18.0F, -4.0F);
        this.body.addBox(-4.0F, 0.0F, 0.0F, 8, 4, 8);
        this.bodytop = new ModelRenderer(this, 28, 21);
        this.bodytop.setRotationPoint(0.0F, 18.0F, -4.0F);
        this.bodytop.addBox(-3.0F, -1.0F, 1.0F, 6, 1, 6);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 20.0F, -4.0F);
        this.head.addBox(-3.0F, -3.0F, -6.0F, 6, 4, 6);
        this.leftbackfoot = new ModelRenderer(this, 0, 16);
        this.leftbackfoot.setRotationPoint(4.0F, 21.0F, 2.5F);
        this.leftbackfoot.addBox(0.0F, 0.0F, -1.5F, 3, 3, 3);
        this.rightbackfoot = new ModelRenderer(this, 0, 16);
        this.rightbackfoot.setRotationPoint(-4.0F, 21.0F, 2.5F);
        this.rightbackfoot.addBox(-3.0F, 0.0F, -1.5F, 3, 3, 3);
        this.rightfrontfoot = new ModelRenderer(this, 0, 16);
        this.rightfrontfoot.setRotationPoint(-4.0F, 21.0F, -3.5F);
        this.rightfrontfoot.addBox(-3.0F, 0.0F, -1.5F, 3, 3, 3);
        this.leftfrontfoot = new ModelRenderer(this, 0, 16);
        this.leftfrontfoot.setRotationPoint(4.0F, 21.0F, -3.5F);
        this.leftfrontfoot.addBox(0.0F, 0.0F, -1.5F, 3, 3, 3);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale) {
        this.body.render(scale);
        this.bodytop.render(scale);
        this.head.render(scale);
        this.leftbackfoot.render(scale);
        this.rightbackfoot.render(scale);
        this.rightfrontfoot.render(scale);
        this.leftfrontfoot.render(scale);
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }


    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        leftfrontfoot.rotateAngleX = MathHelper.cos(f * 0.666F) * 1.4F * f1;
        rightfrontfoot.rotateAngleX = MathHelper.cos(f * 0.666F + (float) Math.PI) * 1.4F * f1;
        leftbackfoot.rotateAngleX = MathHelper.cos(f * 0.666F + (float) Math.PI) * 1.4F * f1;
        rightbackfoot.rotateAngleX = MathHelper.cos(f * 0.666F) * 1.4F * f1;

        rightfrontfoot.rotateAngleY = 0.0F;
        leftfrontfoot.rotateAngleY = 0.0F;
        leftbackfoot.rotateAngleY = 0.0F;
        rightbackfoot.rotateAngleY = 0.0F;
    }
}
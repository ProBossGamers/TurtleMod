package com.probossgamers.turtlemod.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Saddle_Turtle.tcn by Unknown
 */
@SideOnly(Side.CLIENT)
public class Saddle_Turtle extends ModelBase {
    public ModelRenderer head;
    public ModelRenderer bottomshell;
    public ModelRenderer frontright;
    public ModelRenderer frontleft;
    public ModelRenderer backleft;
    public ModelRenderer backright;
    public ModelRenderer topshell;
    public ModelRenderer Shape1;
    public ModelRenderer Shape2;
    public ModelRenderer Shape3;
    public ModelRenderer Shape4;
    public ModelRenderer Shape5;
    public ModelRenderer Shape6;
    public ModelRenderer Shape7;
    public ModelRenderer Shape8;
    public ModelRenderer Shape9;
    public ModelRenderer Shape10;
    public ModelRenderer Shape11;
    public ModelRenderer Shape12;
    public ModelRenderer Shape13;
    public ModelRenderer tail;

    public Saddle_Turtle()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, 20.6F, -2.0F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 6, 4, 6);
        this.bottomshell = new ModelRenderer(this, 28, 8);
        this.bottomshell.setRotationPoint(1.0F, 14.6F, 6.0F);
        this.bottomshell.addBox(-5.0F, -10.0F, -7.0F, 8, 8, 4);
        this.setRotationAngles(this.bottomshell, 1.5707963267948966F, 0.0F, 0.0F);
        this.frontright = new ModelRenderer(this, 0, 16);
        this.frontright.setRotationPoint(-4.0F, 20.6F, -3.0F);
        this.frontright.addBox(-3.0F, 0.0F, -2.0F, 3, 3, 3);
        this.frontleft = new ModelRenderer(this, 0, 16);
        this.frontleft.setRotationPoint(4.0F, 20.6F, -3.0F);
        this.frontleft.addBox(0.0F, 0.0F, -2.0F, 3, 3, 3);
        this.backleft = new ModelRenderer(this, 0, 16);
        this.backleft.setRotationPoint(4.0F, 20.6F, 2.0F);
        this.backleft.addBox(0.0F, 0.0F, -1.0F, 3, 3, 3);
        this.backright = new ModelRenderer(this, 0, 16);
        this.backright.setRotationPoint(-4.0F, 20.6F, 1.0F);
        this.backright.addBox(-3.0F, 0.0F, 0.0F, 3, 3, 3);
        this.topshell = new ModelRenderer(this, 28, 21);
        this.topshell.setRotationPoint(-3.0F, 16.6F, -3.0F);
        this.topshell.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.Shape1 = new ModelRenderer(this, 38, 23);
        this.Shape1.setRotationPoint(-4.0F, 16.6F, -1.0F);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape2 = new ModelRenderer(this, 36, 2);
        this.Shape2.setRotationPoint(4.0F, 17.6F, -1.0F);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape3 = new ModelRenderer(this, 36, 2);
        this.Shape3.setRotationPoint(-4.0F, 17.6F, -1.0F);
        this.Shape3.addBox(-1.0F, 0.0F, 0.0F, 1, 3, 1);
        this.Shape4 = new ModelRenderer(this, 35, 23);
        this.Shape4.setRotationPoint(-2.0F, 15.6F, 2.0F);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1);
        this.Shape5 = new ModelRenderer(this, 26, 3);
        this.Shape5.setRotationPoint(-1.0F, 15.6F, -3.0F);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
        this.Shape6 = new ModelRenderer(this, 37, 24);
        this.Shape6.setRotationPoint(-1.0F, 14.6F, 2.0F);
        this.Shape6.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
        this.Shape7 = new ModelRenderer(this, 43, 3);
        this.Shape7.setRotationPoint(4.0F, 20.6F, 0.0F);
        this.Shape7.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape8 = new ModelRenderer(this, 43, 3);
        this.Shape8.setRotationPoint(4.0F, 20.6F, -2.0F);
        this.Shape8.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape9 = new ModelRenderer(this, 43, 3);
        this.Shape9.setRotationPoint(4.0F, 21.6F, -1.0F);
        this.Shape9.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape10 = new ModelRenderer(this, 43, 3);
        this.Shape10.setRotationPoint(0.0F, 20.6F, 0.0F);
        this.Shape10.addBox(-5.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape11 = new ModelRenderer(this, 43, 3);
        this.Shape11.setRotationPoint(-5.0F, 20.6F, -2.0F);
        this.Shape11.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape12 = new ModelRenderer(this, 43, 3);
        this.Shape12.setRotationPoint(-5.0F, 21.6F, -1.0F);
        this.Shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1);
        this.Shape13 = new ModelRenderer(this, 36, 24);
        this.Shape13.setRotationPoint(0.0F, 16.6F, -1.0F);
        this.Shape13.addBox(3.0F, 0.0F, 0.0F, 1, 1, 1);
        this.tail = new ModelRenderer(this, 3, 17);
        this.tail.setRotationPoint(-1.0F, 20.0F, 4.0F);
        this.tail.addBox(0.0F, 0.0F, 0.0F, 2, 1, 1);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float rotationYaw, float rotationPitch, float scale)
    {
        this.head.render(scale);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.bottomshell.offsetX, this.bottomshell.offsetY, this.bottomshell.offsetZ);
        GlStateManager.translate(this.bottomshell.rotationPointX * scale, this.bottomshell.rotationPointY * scale, this.bottomshell.rotationPointZ * scale);
        GlStateManager.scale(1.0F, 1.0F, 1.0F);
        GlStateManager.translate(-this.bottomshell.offsetX, -this.bottomshell.offsetY, -this.bottomshell.offsetZ);
        GlStateManager.translate(-this.bottomshell.rotationPointX * scale, -this.bottomshell.rotationPointY * scale, -this.bottomshell.rotationPointZ * scale);
        this.bottomshell.render(scale);
        GlStateManager.popMatrix();
        this.frontright.render(scale);
        this.frontleft.render(scale);
        this.backleft.render(scale);
        this.backright.render(scale);
        this.topshell.render(scale);
        this.Shape1.render(scale);
        this.Shape2.render(scale);
        this.Shape3.render(scale);
        this.Shape4.render(scale);
        this.Shape5.render(scale);
        this.Shape6.render(scale);
        this.Shape7.render(scale);
        this.Shape8.render(scale);
        this.Shape9.render(scale);
        this.Shape10.render(scale);
        this.Shape11.render(scale);
        this.Shape12.render(scale);
        this.Shape13.render(scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.0F);
        this.tail.render(scale);
        GlStateManager.disableBlend();
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z)
    {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

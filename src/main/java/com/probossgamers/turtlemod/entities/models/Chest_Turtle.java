package com.probossgamers.turtlemod.entities.models;


import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Chest_Turtle.tcn by Unknown
 */
@SideOnly(Side.CLIENT)
public class Chest_Turtle extends ModelBase
{
    public ModelRenderer head;
    public ModelRenderer bottomshell;
    public ModelRenderer frontright;
    public ModelRenderer frontleft;
    public ModelRenderer backleft;
    public ModelRenderer backright;
    public ModelRenderer topshell;
    public ModelRenderer chestpart1;
    public ModelRenderer chestpart2;
    public ModelRenderer chestpart3;
    public ModelRenderer chestpart4;
    public ModelRenderer chestpart5;
    public ModelRenderer chestpart6;
    public ModelRenderer tail;

    public Chest_Turtle()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(1.0F, 20.0F, -2.0F);
        this.head.addBox(-4.0F, -4.0F, -8.0F, 6, 4, 6);
        this.bottomshell = new ModelRenderer(this, 28, 8);
        this.bottomshell.setRotationPoint(1.0F, 14.0F, 6.0F);
        this.bottomshell.addBox(-5.0F, -10.0F, -7.0F, 8, 8, 4);
        this.setRotationAngles(this.bottomshell, 1.5707963267948966F, 0.0F, 0.0F);
        this.frontright = new ModelRenderer(this, 0, 16);
        this.frontright.setRotationPoint(-4.0F, 21.0F, -3.0F);
        this.frontright.addBox(-3.0F, 0.0F, -2.0F, 3, 3, 3);
        this.frontleft = new ModelRenderer(this, 0, 16);
        this.frontleft.setRotationPoint(4.0F, 21.0F, -3.0F);
        this.frontleft.addBox(0.0F, 0.0F, -2.0F, 3, 3, 3);
        this.backleft = new ModelRenderer(this, 0, 16);
        this.backleft.setRotationPoint(4.0F, 21.0F, 2.0F);
        this.backleft.addBox(0.0F, 0.0F, -1.0F, 3, 3, 3);
        this.backright = new ModelRenderer(this, 0, 16);
        this.backright.setRotationPoint(-4.0F, 21.0F, 2.0F);
        this.backright.addBox(-3.0F, 0.0F, -1.0F, 3, 3, 3);
        this.topshell = new ModelRenderer(this, 28, 21);
        this.topshell.setRotationPoint(-3.0F, 16.0F, -3.0F);
        this.topshell.addBox(0.0F, 0.0F, 0.0F, 6, 1, 6);
        this.chestpart1 = new ModelRenderer(this, 33, 0);
        this.chestpart1.setRotationPoint(-8.0F, 16.0F, -1.0F);
        this.chestpart1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.chestpart2 = new ModelRenderer(this, 33, 0);
        this.chestpart2.setRotationPoint(7.0F, 16.0F, -1.0F);
        this.chestpart2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1);
        this.chestpart3 = new ModelRenderer(this, 0, 27);
        this.chestpart3.setRotationPoint(-7.0F, 16.0F, -4.0F);
        this.chestpart3.addBox(0.0F, 0.0F, 0.0F, 3, 5, 7);
        this.chestpart4 = new ModelRenderer(this, 20, 28);
        this.chestpart4.setRotationPoint(4.0F, 16.0F, -4.0F);
        this.chestpart4.addBox(0.0F, 0.0F, 0.0F, 3, 5, 7);
        this.chestpart5 = new ModelRenderer(this, 0, 41);
        this.chestpart5.setRotationPoint(-4.0F, 16.0F, -4.0F);
        this.chestpart5.addBox(0.0F, 0.0F, 0.0F, 1, 1, 7);
        this.chestpart6 = new ModelRenderer(this, 0, 41);
        this.chestpart6.setRotationPoint(3.0F, 16.0F, -4.0F);
        this.chestpart6.addBox(0.0F, 0.0F, 0.0F, 1, 1, 7);
        this.tail = new ModelRenderer(this, 3, 17);
        this.tail.setRotationPoint(-1.0F, 19.0F, 4.0F);
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
        this.chestpart1.render(scale);
        this.chestpart2.render(scale);
        this.chestpart3.render(scale);
        this.chestpart4.render(scale);
        this.chestpart5.render(scale);
        this.chestpart6.render(scale);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.0F);
        this.tail.render(scale);
        GlStateManager.disableBlend();
    }

    public void setRotationAngles(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

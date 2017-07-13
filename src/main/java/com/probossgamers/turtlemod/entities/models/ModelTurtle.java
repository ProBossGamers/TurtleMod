package com.probossgamers.turtlemod.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelQuadruped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Turtle by DeathJusty
 */
@SideOnly(Side.CLIENT)
public class ModelTurtle extends ModelQuadruped
{
    public ModelRenderer body;
    public ModelRenderer bodytop;
    public ModelRenderer head;
    public ModelRenderer leftbackfoot;
    public ModelRenderer rightbackfoot;
    public ModelRenderer rightfrontfoot;
    public ModelRenderer leftfrontfoot;

    public ModelTurtle()
    {
        this(0.0F);
    }

    public ModelTurtle(float scale)
    {
        super(6, scale);
        this.head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4, 3, 1, scale);
        this.childYOffset = 4.0F;
    }
 }
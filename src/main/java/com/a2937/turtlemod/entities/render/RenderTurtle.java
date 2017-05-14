package com.a2937.turtlemod.entities.render;
 
 import com.a2937.turtlemod.entities.EntityTurtle;
import com.a2937.turtlemod.entities.models.ModelTurtle;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 
 @SideOnly(Side.CLIENT)
 public class RenderTurtle extends RenderLiving<EntityTurtle>
 {
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");
 
     public RenderTurtle(RenderManager manager)
     {
         super(manager, new ModelTurtle(), 0.5f);
     }
 
     public ResourceLocation getEntityTexture(EntityTurtle par1Entity)
     {
        return textureLocation;
     }
 }
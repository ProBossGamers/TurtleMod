package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityArcticTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 7/1/2017.
 */
public class RenderArcticTurtle extends RenderLiving<EntityArcticTurtle>
{
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/arctic_turtle.png");

    public RenderArcticTurtle(RenderManager manager)
    {
        super(manager, new ModelTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityArcticTurtle par1Entity)
    {
        return textureLocation;
    }
}
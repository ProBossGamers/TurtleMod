package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityDubStepTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/24/2017.
 */
public class RenderDubStepTurtle extends RenderLiving<EntityDubStepTurtle>
 {
public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/dubstep_turtle.png");

public RenderDubStepTurtle(RenderManager manager)
        {
        super(manager, new ModelTurtle(), 0.5f);
        }

public ResourceLocation getEntityTexture(EntityDubStepTurtle par1Entity)
    {
    return textureLocation;
    }
 }
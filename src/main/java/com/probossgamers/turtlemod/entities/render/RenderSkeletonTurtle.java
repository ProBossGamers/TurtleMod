package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntitySkeletonTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/17/2017.
 */
public class RenderSkeletonTurtle extends RenderLiving<EntitySkeletonTurtle>
{

public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/skeletonturtle.png");

public RenderSkeletonTurtle(RenderManager manager)
        {
        super(manager,new ModelTurtle(), 0.5f);
        }

public ResourceLocation getEntityTexture(EntitySkeletonTurtle par1Entity)
        {
        return textureLocation;
        }
}
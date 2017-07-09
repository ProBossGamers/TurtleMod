package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntitySkeletonTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityZombieTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

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

        public void doRender(EntitySkeletonTurtle entity, double x, double y, double z, float entityYaw, float partialTicks)
        {
                super.doRender(entity, x, y, z, entityYaw, partialTicks);
                if(entity.isUpsideDown())
                {
                        GL11.glRotatef(180,0,0,0);
                }
        }

public ResourceLocation getEntityTexture(EntitySkeletonTurtle par1Entity)
        {
        return textureLocation;
        }
}
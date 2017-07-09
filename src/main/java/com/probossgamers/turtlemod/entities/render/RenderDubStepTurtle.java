package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityArcticTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityDubStepTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityZombieTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

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

     public void doRender(EntityDubStepTurtle entity, double x, double y, double z, float entityYaw, float partialTicks)
     {
         super.doRender(entity, x, y, z, entityYaw, partialTicks);
         if(entity.isUpsideDown())
         {
             GL11.glRotatef(180,0,0,0);
         }
     }
        /*
        *Only before render
      protected void preRenderCallback(EntityDubStepTurtle par1EntityLivingBase, float par2)
         {
             if(par1EntityLivingBase.isUpsideDown())
             {
                 GL11.glRotatef(180,0,0,0);
             }

         }
*/
public ResourceLocation getEntityTexture(EntityDubStepTurtle par1Entity)
    {
    return textureLocation;
    }
 }
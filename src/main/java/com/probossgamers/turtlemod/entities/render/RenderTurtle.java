package com.probossgamers.turtlemod.entities.render;
 
 import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.models.ModelTurtle;

 import com.probossgamers.turtlemod.entities.monster.EntityZombieTurtle;
 import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
 import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
 public class RenderTurtle extends RenderLiving<EntityTurtle>
 {
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/turtle.png");
 
     public RenderTurtle(RenderManager manager)
     {
         super(manager, new ModelTurtle(), 0.5f);
     }

     public void doRender(EntityTurtle entity, double x, double y, double z, float entityYaw, float partialTicks)
     {
         super.doRender(entity, x, y, z, entityYaw, partialTicks);
         if(entity.isUpsideDown())
         {
             GL11.glRotatef(180,0,0,0);
         }
     }
     public ResourceLocation getEntityTexture(EntityTurtle par1Entity)
     {
        return textureLocation;
     }
 }
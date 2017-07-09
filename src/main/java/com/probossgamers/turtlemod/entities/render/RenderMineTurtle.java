package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelMineTurtle;
import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityMineTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityZombieTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

/**
 * Created by aaron on 5/14/2017.
 */


// I`ve set the name to lowercase.
@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving<EntityMineTurtle>
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/mineturtle.png");

    public RenderMineTurtle(RenderManager manager)
    {
        super(manager,new ModelTurtle(), 0.5f); // Temporarily replacing it with the normal model

    }

    public void doRender(EntityMineTurtle entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        if(entity.isUpsideDown())
        {
            GL11.glRotatef(180,0,0,0);
        }
    }

    public ResourceLocation getEntityTexture(EntityMineTurtle entity)
    {
        return textures;
    }
}
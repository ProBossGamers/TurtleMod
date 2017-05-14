package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelMineTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by aaron on 5/14/2017.
 */



@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/MineTurtle.png");

    public RenderMineTurtle(RenderManager manager)
    {
        super(manager,new ModelMineTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return textures;
    }
}
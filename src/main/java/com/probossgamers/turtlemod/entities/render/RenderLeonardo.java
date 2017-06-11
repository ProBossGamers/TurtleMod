package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.monster.EntityLeonardo;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/11/2017.
 */
public class RenderLeonardo extends RenderLiving<EntityLeonardo>
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/leonardo.png");

    public RenderLeonardo(RenderManager manager)
    {
        super(manager, new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityLeonardo entity)
    {
        return textures;
    }
}
package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.monster.EntityRaphael;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/11/2017.
 */
public class RenderRaphael extends RenderLiving<EntityRaphael>
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/raphael.png");

    public RenderRaphael(RenderManager manager)
    {
        super(manager, new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityRaphael entity)
    {
        return textures;
    }
}
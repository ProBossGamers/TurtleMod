package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.monster.EntityMichelangelo;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/11/2017.
 */
public class RenderMichelangelo extends RenderLiving<EntityMichelangelo>
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/michelangelo.png");

    public RenderMichelangelo(RenderManager manager)
    {
        super(manager,new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityMichelangelo entity)
    {
        return textures;
    }
}
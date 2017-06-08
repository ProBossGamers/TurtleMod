package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.EntityHelloGuy;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 6/8/2017.
 */
public class RenderHelloGuy  extends RenderLiving<EntityHelloGuy>
{

    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/helloguy.png");

    public RenderHelloGuy(RenderManager manager)
    {
        super(manager,new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityHelloGuy par1Entity)
    {
        return textureLocation;
    }
}
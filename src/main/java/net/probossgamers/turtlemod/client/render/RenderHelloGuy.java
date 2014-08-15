package net.probossgamers.turtlemod.client.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderHelloGuy extends RenderLiving {
    public static final ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/HelloGuy.png");

    public RenderHelloGuy(ModelBiped model, float shadowSize)
    {
        super(model, shadowSize);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return textures;
    }
}

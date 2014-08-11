package net.probossgamers.turtlemod.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.turtlemod.client.model.ModelMineTurtle;

@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving
{
    public static final ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/MineTurtle.png");

    public RenderMineTurtle(ModelMineTurtle model, float shadowSize)
    {
        super(model, shadowSize);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return textures;
    }
}

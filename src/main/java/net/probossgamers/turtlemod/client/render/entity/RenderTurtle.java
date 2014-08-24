package net.probossgamers.turtlemod.client.render.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.turtlemod.client.model.entity.ModelTurtle;

@SideOnly(Side.CLIENT)
public class RenderTurtle extends RenderLiving
{
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");

    public RenderTurtle()
    {
        super(new ModelTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return textureLocation;
    }
}

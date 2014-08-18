package net.probossgamers.turtlemod.client.render.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.turtlemod.client.model.ModelTurtle;

@SideOnly(Side.CLIENT)
public class RenderZombieTurtle extends RenderLiving
{
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/ZombieTurtle.png");

    public RenderZombieTurtle()
    {
        super(new ModelTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(net.minecraft.entity.Entity par1Entity) {
        return textureLocation;
    }
}

package net.probossgamers.turtlemod.client.render.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.turtlemod.client.model.entity.ModelMineTurtle;

@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/MineTurtle.png");

    public RenderMineTurtle()
    {
        super(new ModelMineTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return textures;
    }
}

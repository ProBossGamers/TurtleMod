package net.probossgamers.TurtleMod.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.TurtleMod.TurtleMod;
import net.probossgamers.TurtleMod.entity.EntityTurtle;
import net.probossgamers.TurtleMod.model.ModelTurtle;
import net.minecraft.entity.Entity;

@SideOnly(Side.CLIENT)
public class RenderTurtle extends RenderLiving {

    public static final ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");

    public RenderTurtle(ModelTurtle model, float shadowSize) {
        super(model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(net.minecraft.entity.Entity par1Entity) {
        return textureLocation;
    }
}

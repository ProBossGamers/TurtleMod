package net.probossgamers.TurtleMod.client.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.TurtleMod.client.model.ModelMineTurtle;

@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving {

    public static final ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/MineTurtle.png");

    public RenderMineTurtle(ModelMineTurtle model, float shadowSize) {

        super(model, shadowSize);
    }

    @Override
    protected ResourceLocation getEntityTexture(net.minecraft.entity.Entity par1Entity) {
        return textureLocation;
    }
}

package net.probossgamers.turtlemod.client.render.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RenderLeonardo extends RenderLiving
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/Leonardo.png");

    public RenderLeonardo()
    {
        super(new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(Entity entity)
    {
        return textures;
    }
}

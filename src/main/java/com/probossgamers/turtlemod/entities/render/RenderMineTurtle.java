package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelMineTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityMineTurtle;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by aaron on 5/14/2017.
 */


// I`ve set the name to lowercase.
@SideOnly(Side.CLIENT)
public class RenderMineTurtle extends RenderLiving<EntityMineTurtle>
{
    public ResourceLocation textures = new ResourceLocation("turtlemod:textures/mobs/mineturtle.png");

    public RenderMineTurtle(RenderManager manager)
    {
        super(manager,new ModelMineTurtle(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityMineTurtle entity)
    {
        return textures;
    }
}
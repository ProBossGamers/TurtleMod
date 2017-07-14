package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.monster.EntityEightiesShredder;
import com.probossgamers.turtlemod.entities.monster.EntityNetherTurtle;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by aaron on 7/14/2017.
 */
public class RenderEightiesShredder  extends RenderLiving<EntityEightiesShredder>
{
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/shredder_80s.png");

    public RenderEightiesShredder(RenderManager manager)
    {
        super(manager, new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityEightiesShredder par1Entity)
    {
        return textureLocation;
    }
}
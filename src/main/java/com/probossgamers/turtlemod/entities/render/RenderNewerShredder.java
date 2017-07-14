package com.probossgamers.turtlemod.entities.render;

import com.probossgamers.turtlemod.entities.monster.EntityNewerShredder;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by aaron on 7/14/2017.
 */

public class RenderNewerShredder extends RenderLiving<EntityNewerShredder> {
    public ResourceLocation textureLocation = new ResourceLocation("turtlemod:textures/mobs/shredder_2003.png");

    public RenderNewerShredder(RenderManager manager) {
        super(manager, new ModelBiped(), 0.5f);
    }

    public ResourceLocation getEntityTexture(EntityNewerShredder par1Entity) {
        return textureLocation;
    }
}
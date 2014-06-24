package net.probossgamers.TurtleMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.probossgamers.TurtleMod.Server.ServerProxy;
import net.probossgamers.TurtleMod.entity.EntityTurtle;
import net.probossgamers.TurtleMod.model.ModelTurtle;
import net.probossgamers.TurtleMod.render.RenderTurtle;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
    }
}

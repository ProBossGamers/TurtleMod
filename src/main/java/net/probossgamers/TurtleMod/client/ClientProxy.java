package net.probossgamers.TurtleMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.probossgamers.TurtleMod.Server.ServerProxy;
import net.probossgamers.TurtleMod.entity.EntityMineTurtle;
import net.probossgamers.TurtleMod.entity.EntityTurtle;
import net.probossgamers.TurtleMod.entity.EntityZombieTurtle;
import net.probossgamers.TurtleMod.model.ModelMineTurtle;
import net.probossgamers.TurtleMod.model.ModelTurtle;
import net.probossgamers.TurtleMod.render.RenderMineTurtle;
import net.probossgamers.TurtleMod.render.RenderTurtle;
import net.probossgamers.TurtleMod.render.RenderZombieTurtle;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.5F));
    }
}

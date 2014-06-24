package net.probossgamers.TurtleMod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.probossgamers.TurtleMod.server.ServerProxy;
import net.probossgamers.TurtleMod.entity.monster.EntityMineTurtle;
import net.probossgamers.TurtleMod.entity.passive.EntityTurtle;
import net.probossgamers.TurtleMod.entity.monster.EntityZombieTurtle;
import net.probossgamers.TurtleMod.client.model.ModelMineTurtle;
import net.probossgamers.TurtleMod.client.model.ModelTurtle;
import net.probossgamers.TurtleMod.client.render.RenderMineTurtle;
import net.probossgamers.TurtleMod.client.render.RenderTurtle;
import net.probossgamers.TurtleMod.client.render.RenderZombieTurtle;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.5F));
    }
}

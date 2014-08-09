package net.probossgamers.turtlemod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.probossgamers.turtlemod.client.model.ModelMineTurtle;
import net.probossgamers.turtlemod.client.model.ModelTurtle;
import net.probossgamers.turtlemod.client.render.RenderMineTurtle;
import net.probossgamers.turtlemod.client.render.RenderTurtle;
import net.probossgamers.turtlemod.client.render.RenderZombieTurtle;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;
import net.probossgamers.turtlemod.entity.monster.EntityZombieTurtle;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;
import net.probossgamers.turtlemod.server.ServerProxy;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.5F));
    }
}

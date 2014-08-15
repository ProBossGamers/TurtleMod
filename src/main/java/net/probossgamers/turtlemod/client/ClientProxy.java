package net.probossgamers.turtlemod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.probossgamers.turtlemod.client.model.ModelMineTurtle;
import net.probossgamers.turtlemod.client.model.ModelTurtle;
import net.probossgamers.turtlemod.client.render.*;
import net.probossgamers.turtlemod.entity.monster.EntityDonatello;
import net.probossgamers.turtlemod.entity.monster.EntityLeonardo;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;
import net.probossgamers.turtlemod.entity.monster.EntityZombieTurtle;
import net.probossgamers.turtlemod.entity.passive.EntityHelloGuy;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;
import net.probossgamers.turtlemod.server.ServerProxy;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new RenderHelloGuy(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDonatello.class, new RenderDonatello(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLeonardo.class, new RenderLeonardo(new ModelBiped(), 0.5F));
    }
}

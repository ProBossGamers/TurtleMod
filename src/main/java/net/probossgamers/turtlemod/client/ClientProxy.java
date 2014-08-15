package net.probossgamers.turtlemod.client;

import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;
import net.probossgamers.turtlemod.client.model.ModelMineTurtle;
import net.probossgamers.turtlemod.client.model.ModelTurtle;
import net.probossgamers.turtlemod.client.render.*;
import net.probossgamers.turtlemod.entity.monster.*;
import net.probossgamers.turtlemod.entity.passive.EntityHelloGuy;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;
import net.probossgamers.turtlemod.event.PlayerRender;
import net.probossgamers.turtlemod.server.ServerProxy;

public class ClientProxy extends ServerProxy {
    @Override
    public void registerRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new RenderHelloGuy(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDonatello.class, new RenderDonatello(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityRaphael.class, new RenderRaphael(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityLeonardo.class, new RenderLeonardo(new ModelBiped(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(EntityMichelangelo.class, new RenderMichelangelo(new ModelBiped(), 0.5F));

        MinecraftForge.EVENT_BUS.register(new PlayerRender());
    }
}

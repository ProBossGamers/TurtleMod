package net.probossgamers.turtlemod.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.probossgamers.turtlemod.client.render.block.BlockTurtleShellRenderer;
import net.probossgamers.turtlemod.client.render.entity.*;
import net.probossgamers.turtlemod.client.render.item.ItemTurtleShellRenderer;
import net.probossgamers.turtlemod.client.render.tileentity.RenderTurtleShell;
import net.probossgamers.turtlemod.entity.monster.*;
import net.probossgamers.turtlemod.entity.passive.EntityHelloGuy;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;
import net.probossgamers.turtlemod.event.BlockRender;
import net.probossgamers.turtlemod.item.ModItems;
import net.probossgamers.turtlemod.server.ServerProxy;
import net.probossgamers.turtlemod.tileentity.TileEntityTurtleShell;

public class ClientProxy extends ServerProxy
{
    public void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle());
        RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle());
        RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new RenderHelloGuy());
        RenderingRegistry.registerEntityRenderingHandler(EntityDonatello.class, new RenderDonatello());
        RenderingRegistry.registerEntityRenderingHandler(EntityRaphael.class, new RenderRaphael());
        RenderingRegistry.registerEntityRenderingHandler(EntityLeonardo.class, new RenderLeonardo());
        RenderingRegistry.registerEntityRenderingHandler(EntityMichelangelo.class, new RenderMichelangelo());
        RenderingRegistry.registerEntityRenderingHandler(EntityFootNinja.class, new RenderFootNinja());

        RenderingRegistry.registerBlockHandler(new BlockTurtleShellRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurtleShell.class, new RenderTurtleShell());

        MinecraftForgeClient.registerItemRenderer(ModItems.turtleShell, new ItemTurtleShellRenderer());

        MinecraftForge.EVENT_BUS.register(new BlockRender());
    }
}

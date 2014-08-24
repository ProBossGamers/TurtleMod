package net.probossgamers.turtlemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.probossgamers.turtlemod.client.model.entity.player.ModelTurtlePlayer;

public class PlayerRender
{
    // public final RenderTurtlePlayer turtleRenderer = new RenderTurtlePlayer(new ModelTurtlePlayer(), 0.3F);
    public ModelTurtlePlayer turtleModel;

    @SubscribeEvent
    public void pre(RenderPlayerEvent.Pre event)
    {
        String username = event.entityPlayer.getDisplayName();
        EntityPlayer player = event.entityPlayer;

        if (username.equals("Ry_dog101") || username.equals("iLexiconn")) // :3
        {
            event.setCanceled(true);
        }
    }
}

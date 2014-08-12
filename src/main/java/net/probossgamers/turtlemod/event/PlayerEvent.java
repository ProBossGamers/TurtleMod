package net.probossgamers.turtlemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;

public class PlayerEvent {

    @SubscribeEvent
    public void pre(RenderPlayerEvent.Pre event) {
        String username = event.entityPlayer.getDisplayName();
        EntityPlayer player  = event.entityPlayer;

        if(username.equals("Ry_dog101")) {
            event.setCanceled(true);
            // EntityPlayer.setSize();
        }
    }
}

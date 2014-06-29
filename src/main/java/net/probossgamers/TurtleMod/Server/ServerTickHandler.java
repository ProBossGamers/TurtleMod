package net.probossgamers.TurtleMod.Server;

import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.texture.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ServerTickHandler extends TickEvent {

    public ServerTickHandler(Type type, Side side, Phase phase) {
        super(type, side, phase);
    }

    @Override
    public void tick(EntityPlayer player) {
        if (player.getCurrentArmor(4) != null) {
            ItemStack helmet = player.getCurrentArmor(4);
        }
    }
}

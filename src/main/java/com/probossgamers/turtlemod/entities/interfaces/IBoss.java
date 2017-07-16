package com.probossgamers.turtlemod.entities.interfaces;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;

/**
 * Created by aaron on 7/16/2017.
 */
public interface IBoss
{
    /*
    Requires the mob to have a BossInfoServer
    Looks like
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);
    */

    //Required to set the name for the boss info
    public void readEntityFromNBT(NBTTagCompound compound);

    //BossInfo adds the player
    public void addTrackingPlayer(EntityPlayerMP player);

    //BossInfo removes the player
    public void removeTrackingPlayer(EntityPlayerMP player);

    //Sets the bossinfo name
    public void setCustomNameTag(String name);

    //To tell if the mob should recieve damage from the source.
    public boolean attackEntityFrom(DamageSource source, float amount);
}

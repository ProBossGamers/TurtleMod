package com.probossgamers.turtlemod.entities;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.entities.monster.EntityMineTurtle;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
/**
 * Created by aaron on 5/29/2017.
 */


public class EntityHelloGuy extends EntityCreature
{
    public EntityHelloGuy(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIAvoidEntity(this, EntityMineTurtle.class, 8.0F, 0.6D, 0.6D));
        tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 3.0F, 1.0F));
        tasks.addTask(3, new EntityAIWander(this, 1.0D));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        //todo
    }

    public SoundEvent getAmbientSound()
    {
        return SoundHandler.helloguy_hg;
    }

    public SoundEvent getHurtSound()
    {
        return SoundHandler.helloguy_hgh;
    }

    public SoundEvent getDeathSound()
    {
        return SoundHandler.helloguy_hgd;
    }

}
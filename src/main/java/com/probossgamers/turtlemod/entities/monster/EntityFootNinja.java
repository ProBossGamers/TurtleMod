package com.probossgamers.turtlemod.entities.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
/**
 * Created by aaron on 5/31/2017.
 */



public class EntityFootNinja extends EntityMob
{
    public EntityFootNinja(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        /*tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityDonatello.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLeonardo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMichelangelo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityRaphael.class, 1.0D, false));
        */
        tasks.addTask(4, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDonatello.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLeonardo.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMichelangelo.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityRaphael.class,  true));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D + ((0.23000000417232513D / 3) * 2));
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5D);
    }


}
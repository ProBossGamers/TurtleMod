package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityFootNinja extends EntityMob
{
    public EntityFootNinja(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityDonatello.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLeonardo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMichelangelo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityRaphael.class, 1.0D, false));
        tasks.addTask(4, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDonatello.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLeonardo.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMichelangelo.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityRaphael.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D + ((0.23000000417232513D / 3) * 2));
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.5D);
    }


}

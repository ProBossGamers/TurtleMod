package com.probossgamers.turtlemod.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

/**
 * Created by aaron on 5/14/2017.
 */
public class EntityAIExplodeOnCollide extends EntityAIBase
{
    public Class classTarget;
    public Entity entityClass;

    public EntityAIExplodeOnCollide(EntityLiving entity, Class target)
    {
        classTarget = target;
        entityClass = entity;
    }

    public boolean shouldExecute()
    {
        return !entityClass.world.getEntitiesWithinAABB(classTarget, entityClass.getEntityBoundingBox()).isEmpty() || !this.entityClass.world.getGameRules().getBoolean("mobGriefing") ;
    }

    public void startExecuting()
    {

            explode();
    }

    public void explode()
    {

        entityClass.world.createExplosion(entityClass, entityClass.posX, entityClass.posY, entityClass.posZ, 10f, entityClass.world.getGameRules().getBoolean("mobGriefing"));
        entityClass.setDead();
    }
}
package net.probossgamers.turtlemod.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;

public class EntityAIExplodeOnCollide extends EntityAIBase
{
    public Class classTarget;
    public Entity entityClass;

    public EntityAIExplodeOnCollide(EntityMineTurtle entity, Class target) {
        classTarget = target;
        entityClass = entity;
    }

    public boolean shouldExecute() {
        return !entityClass.worldObj.selectEntitiesWithinAABB(classTarget, entityClass.boundingBox, IEntitySelector.selectAnything).isEmpty();
    }

    public void startExecuting() {
        explode();
    }

    public void explode() {
        entityClass.worldObj.createExplosion(entityClass, entityClass.posX, entityClass.posY, entityClass.posZ, 10f, entityClass.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        entityClass.setDead();
    }
}

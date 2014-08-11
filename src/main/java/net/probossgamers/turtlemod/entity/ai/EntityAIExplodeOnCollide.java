package net.probossgamers.turtlemod.entity.ai;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.ai.EntityAIBase;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;

public class EntityAIExplodeOnCollide extends EntityAIBase
{
    public Class classTarget;
    public EntityMineTurtle mineTurtle;

    public EntityAIExplodeOnCollide(EntityMineTurtle turtle, Class target) {
        classTarget = target;
        mineTurtle = turtle;
    }

    public boolean shouldExecute() {
        return !mineTurtle.worldObj.selectEntitiesWithinAABB(classTarget, mineTurtle.boundingBox, IEntitySelector.selectAnything).isEmpty();
    }

    public void startExecuting() {
        mineTurtle.explode();
    }
}

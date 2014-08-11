package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.entity.ai.EntityAIExplodeOnCollide;

public class EntityMineTurtle extends EntityCreature {
    public EntityMineTurtle(World world) {
        super(world);
        setSize(1f, 0.3f);
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAvoidEntity(this, EntityCreeper.class, 6.0f, 1.0f, 1.2f));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        tasks.addTask(3, new EntityAILookIdle(this));
        tasks.addTask(4, new EntityAIExplodeOnCollide(this, EntityPlayer.class));
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
    }

    public String getLivingSound() {
        return "turtlemod:turtle:living";
    }

    public String getHurtSound() {
        return "turtlemod:turtle:hurt";
    }

    public String getDeathSound() {
        return "turtlemod:turtle:death";
    }

    public void explode() {
        worldObj.createExplosion(this, posX, posY, posZ, 10f, worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"));
        setDead();
    }
}
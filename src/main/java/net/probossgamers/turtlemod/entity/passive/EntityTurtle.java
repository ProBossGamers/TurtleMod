package net.probossgamers.turtlemod.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityTurtle extends EntityCreature {

    public EntityTurtle(World world) {
        super(world);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(2, new EntityAIPanic(this, 0.5D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1150000021D);
    }

    public String getLivingSound() {
        return "turtlemod:mob.turtle.living";
    }

    public String getHurtSound() {
        return "turtlemod:mob.turtle.hurt";
    }

    public String getDeathSound() {
        return "turtlemod:mob.turtle.death";
    }
}

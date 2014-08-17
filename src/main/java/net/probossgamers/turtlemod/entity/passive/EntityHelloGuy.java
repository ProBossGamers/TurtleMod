package net.probossgamers.turtlemod.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;

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
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        //todo
    }

    public String getLivingSound() {
        return "turtlemod:helloGuy:hg";
    }

    public String getHurtSound() {
        return "turtlemod:helloGuy:hgh";
    }

    public String getDeathSound() {
        return "turtlemod:helloGuy;hgd";
    }
}

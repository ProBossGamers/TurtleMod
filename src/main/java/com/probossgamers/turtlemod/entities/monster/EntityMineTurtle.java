package com.probossgamers.turtlemod.entities.monster;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.entities.EntityHelloGuy;
import com.probossgamers.turtlemod.entities.ai.EntityAIExplodeOnCollide;
import com.probossgamers.turtlemod.items.ModItems;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Created by aaron on 5/14/2017.
 */
public class EntityMineTurtle extends EntityCreature
{
    public EntityMineTurtle(World world)
    {
        super(world);
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIExplodeOnCollide(this, EntityPlayer.class));
        tasks.addTask(3, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHelloGuy.class, true));
        //this.tasks.addTask(6, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, true));
        tasks.addTask(5, new EntityAILookIdle(this));
        setSize(0.6f, 0.5f);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        entityDropItem(new ItemStack(Items.GUNPOWDER), 0);
        this.entityDropItem(new ItemStack(ModBlocks.turtleShell), 0);
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D / 2);
    }

    public SoundEvent getAmbientSound()
    {
        return SoundHandler.turtle_living;
    }

    public SoundEvent getHurtSound()
    {
        return SoundHandler.turtle_hurt;
    }

    public SoundEvent getDeathSound()
    {
        return SoundHandler.turtle_death;
    }
}
package com.probossgamers.turtlemod.entities;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.items.ModItems;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTurtle extends EntityAnimal
{
    public EntityTurtle(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIWander(this, 1.0D));
        tasks.addTask(2, new EntityAIPanic(this, 1.0D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(4, new EntityAILookIdle(this));
        tasks.addTask(5, new EntityAITempt(this, 1.25D, ModItems.pizzaSlice, false));
        setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled()
    {
       return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D / 2);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        this.entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        this.entityDropItem(new ItemStack(ModBlocks.turtleShell), 0);
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

   @Override
	public boolean isBreedingItem(ItemStack stack) {
		return stack.getItem() == ModItems.pizzaSlice;
	}
   
	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		return new EntityTurtle(this.world);
	}
}
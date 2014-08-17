package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.ModBlocks;
import net.probossgamers.turtlemod.ModItems;
import net.probossgamers.turtlemod.entity.ai.EntityAIExplodeOnCollide;

public class EntityMineTurtle extends EntityCreature
{
    public EntityMineTurtle(World world)
    {
        super(world);
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAvoidEntity(this, EntityCreeper.class, 6.0f, 1.0f, 1.2f));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        tasks.addTask(3, new EntityAILookIdle(this));
        tasks.addTask(4, new EntityAIExplodeOnCollide(this, EntityPlayer.class));
        setSize(0.6f, 0.5f);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        entityDropItem(new ItemStack(ModItems.turtleLeather), 1);
        entityDropItem(new ItemStack(ModBlocks.turtleShell), 1);
        entityDropItem(new ItemStack(Items.gunpowder), 1);
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
    }

    public String getLivingSound()
    {
        return "turtlemod:turtle:living";
    }

    public String getHurtSound()
    {
        return "turtlemod:turtle:hurt";
    }

    public String getDeathSound()
    {
        return "turtlemod:turtle:death";
    }
}
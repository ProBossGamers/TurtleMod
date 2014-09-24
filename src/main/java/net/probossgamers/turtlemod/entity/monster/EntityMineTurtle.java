package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.entity.ai.EntityAIExplodeOnCollide;
import net.probossgamers.turtlemod.item.ModItems;

public class EntityMineTurtle extends EntityCreature
{
    public EntityMineTurtle(World world)
    {
        super(world);
        tasks.addTask(1, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIExplodeOnCollide(this, EntityPlayer.class));
        tasks.addTask(3, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        tasks.addTask(5, new EntityAILookIdle(this));
        setSize(0.6f, 0.5f);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        entityDropItem(new ItemStack(Items.gunpowder), 0);
        this.entityDropItem(new ItemStack(ModItems.turtleShell), 0);
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D / 2);
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
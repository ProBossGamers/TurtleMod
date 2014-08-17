package net.probossgamers.turtlemod.entity.passive;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.ModBlocks;
import net.probossgamers.turtlemod.ModItems;

public class EntityTurtle extends EntityCreature
{
    public EntityTurtle(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIWander(this, 0.5D));
        tasks.addTask(2, new EntityAIPanic(this, 0.5D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(4, new EntityAILookIdle(this));
        setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1150000021D);
    }

    //public Item getDropItem()
    //{
    //    return ModItems.turtleShell;
    //}

    public void dropFewItems(boolean hit, int looting)
    {
        this.entityDropItem(new ItemStack(ModItems.turtleLeather), 1);
        this.entityDropItem(new ItemStack(ModBlocks.turtleShell), 1);
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

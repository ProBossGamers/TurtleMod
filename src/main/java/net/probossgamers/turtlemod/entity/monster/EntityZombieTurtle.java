package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.block.RegisterBlocks;
import net.probossgamers.turtlemod.item.RegisterItems;

public class EntityZombieTurtle extends EntityMob {
    public EntityZombieTurtle(World world) {
        super(world);
        this.getNavigator().setBreakDoors(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this,EntityPlayer.class, 0.5D, false));
        this.tasks.addTask(3, new EntityAIAttackOnCollide(this,EntityVillager.class, 0.5D, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(6,new EntityAIMoveThroughVillage(this, 0.5D, false));
        this.tasks.addTask(7, new EntityAIWander(this, 0.5D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this,EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, 0, false));
        this.setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1150000021D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
    }

    public void dropFewItems(boolean hit, int looting) {
        this.entityDropItem(new ItemStack(RegisterItems.turtleLeather), 1);
        this.entityDropItem(new ItemStack(RegisterBlocks.turtleShell), 1);
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

    public void onLivingUpdate() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRemote && !this.isChild()) {
            float f = this.getBrightness(1.0F);
            if (f > 0.5F && this.rand.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.worldObj.canBlockSeeTheSky(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ))) {
                setFire(8);
            }
            super.onLivingUpdate();
        }
    }
}

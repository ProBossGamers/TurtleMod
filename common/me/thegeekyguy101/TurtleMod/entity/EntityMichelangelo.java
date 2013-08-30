package me.thegeekyguy101.TurtleMod.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIBreakDoor;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class EntityMichelangelo extends EntityMob {

	public EntityMichelangelo(World par1World) {
		super(par1World);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlaze.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCaveSpider.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCreeper.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityEnderman.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGhast.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGiantZombie.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMagmaCube.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPigZombie.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySilverfish.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySlime.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySpider.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWitch.class, 0.25F, false));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 0.25F, false));
		this.tasks.addTask(3, new EntityAIMoveThroughVillage(this, 0.25F, false));
		this.tasks.addTask(4, new EntityAIWander(this, 0.25F));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlaze.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySlime.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
	}
	
	protected boolean isAIEnabled()
    {
        return true;
    }
	
	protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(20.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
        this.func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(3.0D);
    }
	
	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound() {
		return "turtlemod:mob.turtle.living";
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "turtlemod:mob.turtle.hurt";
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "turtlemod:mob.turtle.death";
	}
	
}

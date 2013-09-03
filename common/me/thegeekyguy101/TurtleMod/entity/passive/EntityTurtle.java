package me.thegeekyguy101.TurtleMod.entity.passive;

import me.thegeekyguy101.TurtleMod.TurtleMod;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityTurtle extends EntityAnimal {

	public EntityTurtle(World par1World) {
		super(par1World);
		this.setSize(1.0F, 0.5F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.25F));
		this.tasks.addTask(2, new EntityAIPanic(this, 0.5F));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	protected boolean isAIEnabled() {
		return true;
	}
	
	protected void func_110147_ax()
    {
        super.func_110147_ax();
        this.func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(15.0D);
        this.func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.20000000298023224D);
    }

	public int getDropItemId() {
		return TurtleMod.turtleShell.itemID;
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
		int var4;

		for (var4 = 0; var4 < var3; ++var4) {
			this.dropItem(TurtleMod.turtleShell.itemID, 1);
		}

		var3 = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + par2);

		for (var4 = 0; var4 < var3; ++var4) {
			if (this.isBurning()) {

			} else {
				this.dropItem(TurtleMod.Turtleleather.itemID, 1);
			}
		}
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

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		return null;
	}

}

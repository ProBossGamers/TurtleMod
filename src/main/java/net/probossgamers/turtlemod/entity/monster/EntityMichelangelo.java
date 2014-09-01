package net.probossgamers.turtlemod.entity.monster;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.item.ModItems;

public class EntityMichelangelo extends EntityMob
{
    public EntityMichelangelo(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlaze.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCaveSpider.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCreeper.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityEnderman.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGhast.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityGiantZombie.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMagmaCube.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPigZombie.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySilverfish.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySkeleton.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySlime.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySpider.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWitch.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityFootNinja.class, 1.0D, false));
        tasks.addTask(4, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlaze.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGhast.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySilverfish.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySlime.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class, 0, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFootNinja.class, 0, true));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D+(0.23000000417232513D/2));
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        this.entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        this.entityDropItem(new ItemStack(ModItems.turtleShell), 0);
    }

    public String getLivingSound()
    {
        return "turtlemod:mike:living";
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

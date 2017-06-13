package com.probossgamers.turtlemod.entities.monster;

/**
 * Created by aaron on 5/31/2017.
 */

        import com.probossgamers.turtlemod.SoundHandler;
        import com.probossgamers.turtlemod.blocks.ModBlocks;
        import com.probossgamers.turtlemod.items.ModItems;
        import net.minecraft.entity.SharedMonsterAttributes;
        import net.minecraft.entity.ai.*;
        import net.minecraft.entity.monster.*;
        import net.minecraft.entity.player.EntityPlayer;
        import net.minecraft.item.ItemStack;
        import net.minecraft.util.SoundEvent;
        import net.minecraft.world.World;

public class EntityLeonardo extends EntityMob
{
    public EntityLeonardo(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        /*tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityBlaze.class, 1.0D, false));
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
        */
        tasks.addTask(4, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityBlaze.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCaveSpider.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCreeper.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityEnderman.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGhast.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGiantZombie.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMagmaCube.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPigZombie.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySilverfish.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySkeleton.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySlime.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySpider.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityZombie.class,  true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityFootNinja.class,  true));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D + (0.23000000417232513D / 2));
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

    public void dropFewItems(boolean hit, int looting)
    {
        this.entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        this.entityDropItem(new ItemStack(ModBlocks.turtleShell), 0);
        this.entityDropItem(new ItemStack(ModItems.leosKatana),0);
    }

    public SoundEvent getAmbientSound()
    {
        return SoundHandler.leo_living;
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
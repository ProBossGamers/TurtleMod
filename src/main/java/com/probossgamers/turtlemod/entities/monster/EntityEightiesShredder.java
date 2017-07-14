package com.probossgamers.turtlemod.entities.monster;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.DamageSource;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.World;

/**
 * Created by aaron on 7/14/2017.
 */
public class EntityEightiesShredder extends EntityMob
{
    private final BossInfoServer bossInfo = (BossInfoServer)(new BossInfoServer(this.getDisplayName(), BossInfo.Color.PURPLE, BossInfo.Overlay.PROGRESS)).setDarkenSky(true);


    public EntityEightiesShredder(World world) {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        ((PathNavigateGround)this.getNavigator()).setCanSwim(true);
        this.setHealth(this.getMaxHealth());
        /*tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityDonatello.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityLeonardo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMichelangelo.class, 1.0D, false));
        tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityRaphael.class, 1.0D, false));
        */
        tasks.addTask(4, new EntityAIWander(this, 1.0D));
        tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(5, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityDonatello.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLeonardo.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMichelangelo.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityRaphael.class, true));
    }

    public boolean isAIEnabled() {
        return true;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);


        if (this.hasCustomName())
        {
            this.bossInfo.setName(this.getDisplayName());
        }
    }

    /**
     * Add the given player to the list of players tracking this entity. For instance, a player may track a boss in
     * order to view its associated boss bar.
     */
    public void addTrackingPlayer(EntityPlayerMP player)
    {
        super.addTrackingPlayer(player);
        this.bossInfo.addPlayer(player);
    }

    /**
     * Removes the given player from the list of players tracking this entity. See {@link Entity#addTrackingPlayer} for
     * more information on tracking.
     */
    public void removeTrackingPlayer(EntityPlayerMP player)
    {
        super.removeTrackingPlayer(player);
        this.bossInfo.removePlayer(player);
    }
    /**
     * Sets the custom name tag for this entity
     */
    public void setCustomNameTag(String name)
    {
        super.setCustomNameTag(name);
        this.bossInfo.setName(this.getDisplayName());
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (source != DamageSource.DROWN && !(source.getEntity() instanceof EntityEightiesShredder))
        {
                Entity entity1 = source.getEntity();

                if (entity1 != null && !(entity1 instanceof EntityPlayer) && entity1 instanceof EntityLivingBase && ((EntityLivingBase)entity1).getCreatureAttribute() == this.getCreatureAttribute())
                {
                    return false;
                }
                else
                {

                    return super.attackEntityFrom(source, amount);
                }
        }

        return false;
    }

    public void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(300.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6000000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.5D);
    }
}



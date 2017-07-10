package com.probossgamers.turtlemod.entities;

import com.google.common.base.Optional;
import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.entities.interfaces.ITurtle;
import com.probossgamers.turtlemod.entities.monster.EntityZombieTurtle;
import com.probossgamers.turtlemod.items.ModItems;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.management.PreYggdrasilConverter;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.UUID;

public class EntityTurtle extends EntityTameable implements ITurtle
{
   private boolean upsideDown = false;
    protected static final DataParameter<Byte> TAMED = EntityDataManager.<Byte>createKey(EntityTurtle.class, DataSerializers.BYTE);
    protected static final DataParameter<Optional<UUID>> OWNER_UNIQUE_ID = EntityDataManager.<Optional<UUID>>createKey(EntityTurtle.class, DataSerializers.OPTIONAL_UNIQUE_ID);

    public EntityTurtle(World world)
    {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIWander(this, 1.0D));
        tasks.addTask(2, new EntityAIPanic(this, 1.0D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(4, new EntityAILookIdle(this));
        tasks.addTask(5, new EntityAITempt(this, 1.25D, ModItems.pizzaSlice, false));
        this.tasks.addTask(6, new EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
        this.tasks.addTask(7, new EntityAIMate(this, 1.0D));
        this.setupTamedAI();
        setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled()
    {
       return true;
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(TAMED, Byte.valueOf((byte)0));
        this.dataManager.register(OWNER_UNIQUE_ID, Optional.<UUID>absent());
    }

    public boolean isTurtle()
    {
        return true;
    }

    public Team getTeam()
    {
        if (this.isTamed())
        {
            EntityLivingBase entitylivingbase = this.getOwner();

            if (entitylivingbase != null)
            {
                return entitylivingbase.getTeam();
            }
        }

        return super.getTeam();
    }

    public boolean isTamed()
    {
        return ((Byte) this.dataManager.get(TAMED) & 4) != 0;
    }

    /**
     * Returns whether this Entity is on the same team as the given Entity.
     */
    public boolean isOnSameTeam(Entity entityIn)
    {
        if (this.isTamed())
        {
            EntityLivingBase entitylivingbase = this.getOwner();

            if (entityIn == entitylivingbase)
            {
                return true;
            }

            if (entitylivingbase != null)
            {
                return entitylivingbase.isOnSameTeam(entityIn);
            }
        }

        return super.isOnSameTeam(entityIn);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {

        super.writeEntityToNBT(compound);
        compound.setBoolean("upsideDown", this.isUpsideDown());
        super.writeEntityToNBT(compound);

        if (this.getOwnerId() == null)
        {
            compound.setString("OwnerUUID", "");
        }
        else
        {
            compound.setString("OwnerUUID", this.getOwnerId().toString());
        }

        //compound.setBoolean("Sitting", this.isSitting());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {

        super.readEntityFromNBT(compound);
        setUpsideDown(compound.getBoolean("upsideDown"));
        String s;

        if (compound.hasKey("OwnerUUID", 8))
        {
            s = compound.getString("OwnerUUID");
        }
        else
        {
            String s1 = compound.getString("Owner");
            s = PreYggdrasilConverter.convertMobOwnerIfNeeded(this.getServer(), s1);
        }

        if (!s.isEmpty())
        {
            try
            {
                this.setOwnerId(UUID.fromString(s));
                this.setTamed(true);
            }
            catch (Throwable var4)
            {
                this.setTamed(false);
            }
        }

        /*
        if (this.aiSit != null)
        {
            this.aiSit.setSitting(compound.getBoolean("Sitting"));
        }


        this.setSitting(compound.getBoolean("Sitting"));
        */
    }

    public void setTamed(boolean tamed)
    {
        byte b0 = ((Byte)this.dataManager.get(TAMED)).byteValue();

        if (tamed)
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 4)));
        }
        else
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -5)));
        }

        this.setupTamedAI();
    }

    protected void setupTamedAI()
    {
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

    public boolean isUpsideDown()
    {
        return upsideDown;
    }

    public void setUpsideDown(boolean upsideDown)
    {
        this.upsideDown = upsideDown;
    }

    @Nullable
    public UUID getOwnerId()
    {
        return (UUID)((Optional)this.dataManager.get(OWNER_UNIQUE_ID)).orNull();
    }

    public void setOwnerId(@Nullable UUID p_184754_1_)
    {
        this.dataManager.set(OWNER_UNIQUE_ID, Optional.fromNullable(p_184754_1_));
    }

    @Nullable
    public EntityLivingBase getOwner()
    {
        try
        {
            UUID uuid = this.getOwnerId();
            return uuid == null ? null : this.world.getPlayerEntityByUUID(uuid);
        }
        catch (IllegalArgumentException var2)
        {
            return null;
        }
    }
}
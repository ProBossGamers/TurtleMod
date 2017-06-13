package com.probossgamers.turtlemod.entities;

import com.probossgamers.turtlemod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityKunai extends EntityThrowable
{
    private static final DataParameter<Byte> CRITICAL = EntityDataManager.<Byte>createKey(EntityKunai.class, DataSerializers.BYTE);
    private double damage;
    private int knockbackStrength;

    public EntityKunai(World worldIn)
    {
        super(worldIn);
        this.damage = 0D;
    }

    public EntityKunai(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);

    }

    public EntityKunai(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public static void registerFixesSnowball(DataFixer fixer)
    {
        EntityThrowable.registerFixesThrowable(fixer, "Kunai");
    }
    public void setDamage(double damageIn)
    {
        this.damage = damageIn;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setKnockbackStrength(int knockbackStrengthIn)
    {
        this.knockbackStrength = knockbackStrengthIn;
    }

    protected void entityInit()
    {
        this.dataManager.register(CRITICAL, Byte.valueOf((byte)0));
    }

    public void setIsCritical(boolean critical)
    {
        byte b0 = ((Byte)this.dataManager.get(CRITICAL)).byteValue();

        if (critical)
        {
            this.dataManager.set(CRITICAL, Byte.valueOf((byte)(b0 | 1)));
        }
        else
        {
            this.dataManager.set(CRITICAL, Byte.valueOf((byte)(b0 & -2)));
        }
    }

    /**
     * Whether the arrow has a stream of critical hit particles flying behind it.
     */
    public boolean getIsCritical()
    {
        byte b0 = ((Byte)this.dataManager.get(CRITICAL)).byteValue();
        return (b0 & 1) != 0;
    }
    /**
       (abstract) Protected helper method to write subclass entity data to NBT.
        */
    public void writeEntityToNBT(NBTTagCompound compound)
    {
        compound.setDouble("damage", this.damage);
        compound.setBoolean("crit", this.getIsCritical());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {

        if (compound.hasKey("damage", 99))
        {
            this.damage = compound.getDouble("damage");
        }

        this.setIsCritical(compound.getBoolean("crit"));
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 3)
        {
            for (int i = 0; i < 8; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
        if (result.entityHit != null)
        {
            int i = 5;

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
        }

        if (!this.world.isRemote)
        {
            this.world.setEntityState(this, (byte)3);
            this.dropItem(ModItems.kunai,1);
            this.setDead();

        }
    }
    
}
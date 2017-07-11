package com.probossgamers.turtlemod.entities.monster;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.interfaces.ITurtle;
import net.minecraft.block.material.Material;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by aaron on 6/26/2017.
 */
public class EntityNetherTurtle extends EntityMob implements ITurtle
{
    private static final DataParameter<Boolean> UPSIDEDOWN = EntityDataManager.<Boolean>createKey(EntityArcticTurtle.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Byte> ON_FIRE = EntityDataManager.<Byte>createKey(EntityNetherTurtle.class, DataSerializers.BYTE);

    public EntityNetherTurtle(World worldIn)
    {
        super(worldIn);
        tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));

        tasks.addTask(7, new EntityAIWander(this, 1.0D));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(8, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.LAVA, 8.0F);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.isImmuneToFire = true;
        setSize(0.6F, 0.5F);
    }

    protected void initEntityAI()
    {
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(ON_FIRE, Byte.valueOf((byte) 0));
        this.dataManager.register(UPSIDEDOWN, false);
    }


    public boolean isUpsideDown()
    {
        return this.dataManager.get(UPSIDEDOWN);
    }

    public void setUpsideDown(boolean upsideDown)
    {
        this.dataManager.set(UPSIDEDOWN,upsideDown);
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound compound)
    {

        super.writeEntityToNBT(compound);
        compound.setBoolean("upsideDown", this.isUpsideDown());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound compound)
    {

        super.readEntityFromNBT(compound);
        setUpsideDown(compound.getBoolean("upsideDown"));
    }

    public SoundEvent getAmbientSound() {
        return SoundHandler.turtle_living;
    }

    public SoundEvent getHurtSound() {
        return SoundHandler.turtle_hurt;
    }

    public SoundEvent getDeathSound() {
        return SoundHandler.turtle_death;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float partialTicks) {
        return 15728880;
    }

    public float getBrightness(float partialTicks) {
        return 1.0F;
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        if (this.world.isRemote)
        {
            if (this.rand.nextInt(24) == 0 && !this.isSilent())
            {
                this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i)
            {
                this.world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width, this.posY + this.rand.nextDouble() * (double) this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width, 0.0D, 0.0D, 0.0D, new int[0]);
            }




        }
        else
        {
            int i = MathHelper.floor(this.posX);
            int j = MathHelper.floor(this.posY);
            int k = MathHelper.floor(this.posZ);

            if (!this.world.getGameRules().getBoolean("mobGriefing"))
            {
                return;
            }

            for (int l = 0; l < 4; ++l)
            {
                i = MathHelper.floor(this.posX + (double)((float)(l % 2 * 2 - 1) * 0.25F));
                j = MathHelper.floor(this.posY);
                k = MathHelper.floor(this.posZ + (double)((float)(l / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(i, j, k);

                if (this.world.getBlockState(blockpos).getMaterial() == Material.AIR && this.world.getBiome(blockpos).getFloatTemperature(blockpos) > 0.8F && Blocks.FIRE.canPlaceBlockAt(this.world, blockpos))
                {
                    this.world.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
                }
            }
        }

        super.onLivingUpdate();
    }

    public boolean isTurtle()
    {
        return true;
    }
    protected void updateAITasks()
    {
        if (this.isWet()) {
            this.attackEntityFrom(DamageSource.DROWN, 1.0F);
        }

    }

    public boolean isBurning()
    {
        return this.isCharged();
    }

    public boolean isCharged()
    {
        return (((Byte)this.dataManager.get(ON_FIRE)).byteValue() & 1) != 0;
    }

    public void setOnFire(boolean onFire)
    {
        byte b0 = ((Byte)this.dataManager.get(ON_FIRE)).byteValue();

        if (onFire)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 = (byte)(b0 & -2);
        }

        this.dataManager.set(ON_FIRE, Byte.valueOf(b0));
    }

    protected boolean isValidLightLevel()
    {
        return true;
    }

}

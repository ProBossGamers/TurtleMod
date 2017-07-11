package com.probossgamers.turtlemod.entities.monster;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.interfaces.ITurtle;
import com.probossgamers.turtlemod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Calendar;

/**
 * Created by aaron on 5/29/2017.
 */
public class EntityZombieTurtle extends EntityMob implements ITurtle
{
    private boolean isBreakDoorsTaskSet;
    private int conversionTime;
    private static final DataParameter<Boolean> CONVERTING = EntityDataManager.<Boolean>createKey(EntityZombieTurtle.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> UPSIDEDOWN = EntityDataManager.<Boolean>createKey(EntityArcticTurtle.class, DataSerializers.BOOLEAN);



    private final EntityAIBreakDoor breakDoor = new EntityAIBreakDoor(this);
//
    public EntityZombieTurtle(World world)
    {
        super(world);
        //getNavigator().setBreakDoors(true);
        tasks.addTask(0, new EntityAISwimming(this));
        //tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        //tasks.addTask(3, new EntityAIAttackOnCollide(this, EntityVillager.class, 1.0D, true));
        tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));

        tasks.addTask(6, new EntityAIMoveThroughVillage(this, 1.0D, false));
        tasks.addTask(7, new EntityAIWander(this, 1.0D));
        tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        tasks.addTask(8, new EntityAILookIdle(this));
        targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, false));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, false));
        setSize(0.6F, 0.5F);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(CONVERTING, Boolean.valueOf(false));
        this.dataManager.register(UPSIDEDOWN, false);
    }

    @Override
    public boolean isTurtle()
    {
        return true;
    }


    public boolean isAIEnabled()
    {
        return true;
    }
    private boolean isBreakDoorsTaskSet()
    {
        return this.isBreakDoorsTaskSet;
    }

    public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEAD;
    }

    private void setBreakDoorsAItask(boolean enabled)
    {
        if (this.isBreakDoorsTaskSet != enabled)
        {
            this.isBreakDoorsTaskSet = enabled;
            ((PathNavigateGround)this.getNavigator()).setBreakDoors(enabled);

            if (enabled)
            {
                this.tasks.addTask(1, this.breakDoor);
            }
            else
            {
                this.tasks.removeTask(this.breakDoor);
            }
        }
    }


    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(40.0D);
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20000000417232513D / 2);
        getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.4D);
    }

    public void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);

        compound.setBoolean("upsideDown", this.isUpsideDown());
        compound.setBoolean("CanBreakDoors", this.isBreakDoorsTaskSet());

        compound.setInteger("ConversionTime", this.isConverting() ? this.conversionTime : -1);
    }

    private boolean isConverting()
    {
        return this.getDataManager().get(CONVERTING);
    }

    public void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);


        setUpsideDown(compound.getBoolean("upsideDown"));
        this.setBreakDoorsAItask(compound.getBoolean("CanBreakDoors"));
        if (compound.hasKey("ConversionTime", 99) && compound.getInteger("ConversionTime") > -1) {
            this.startConverting(compound.getInteger("ConversionTime"));
        }
    }

    private void startConverting(int conversionTime)
    {
        this.conversionTime = conversionTime;
        this.getDataManager().set(CONVERTING, Boolean.TRUE);
        this.removePotionEffect(MobEffects.WEAKNESS);
        this.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, conversionTime, Math.min(this.world.getDifficulty().getDifficultyId() - 1, 0)));
        this.world.setEntityState(this, (byte)16);
    }

    protected int getConversionProgress()
    {
        int i = 1;

        if (this.rand.nextFloat() < 0.01F)
        {
            int j = 0;
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for (int k = (int)this.posX - 4; k < (int)this.posX + 4 && j < 14; ++k)
            {
                for (int l = (int)this.posY - 4; l < (int)this.posY + 4 && j < 14; ++l)
                {
                    for (int i1 = (int)this.posZ - 4; i1 < (int)this.posZ + 4 && j < 14; ++i1)
                    {
                        Block block = this.world.getBlockState(blockpos$mutableblockpos.setPos(k, l, i1)).getBlock();

                        if (block == Blocks.IRON_BARS || block == Blocks.BED)
                        {
                            if (this.rand.nextFloat() < 0.3F)
                            {
                                ++i;
                            }

                            ++j;
                        }
                    }
                }
            }
        }

        return i;
    }


    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id)
    {
        if (id == 16)
        {
            if (!this.isSilent())
            {
                this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, SoundEvents.ENTITY_ZOMBIE_VILLAGER_CURE, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        if (!this.world.isRemote && this.isConverting())
        {
            int i = this.getConversionProgress();
            this.conversionTime -= i;

            if (this.conversionTime <= 0)
            {
                this.finishConversion();
            }
        }

        super.onUpdate();
    }

    private void finishConversion()
    {
        EntityTurtle entityTurtle = new EntityTurtle(this.world);
        entityTurtle.copyLocationAndAnglesFrom(this);


        this.world.removeEntity(this);
        entityTurtle.setNoAI(this.isAIDisabled());

        if (this.hasCustomName())
        {
            entityTurtle.setCustomNameTag(this.getCustomNameTag());
            entityTurtle.setAlwaysRenderNameTag(this.getAlwaysRenderNameTag());
        }

        this.world.spawnEntity(entityTurtle);
        entityTurtle.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));
        this.world.playEvent((EntityPlayer)null, 1027, new BlockPos((int)this.posX, (int)this.posY, (int)this.posZ), 0);
    }


    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack itemstack = player.getHeldItem(hand);

        if (itemstack.getItem() == Items.GOLDEN_APPLE && itemstack.getMetadata() == 0 && this.isPotionActive(MobEffects.WEAKNESS))
        {
            if (!player.capabilities.isCreativeMode)
            {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote)
            {
                this.startConverting(this.rand.nextInt(2401) + 3600);
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        float f = difficulty.getClampedAdditionalDifficulty();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * f);
        this.setBreakDoorsAItask(this.rand.nextFloat() < f * 0.1F);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);

        if (this.getItemStackFromSlot(EntityEquipmentSlot.HEAD).isEmpty())
        {
            Calendar calendar = this.world.getCurrentDate();

            if (calendar.get(Calendar.MONTH) + 1 == 10 && calendar.get(Calendar.DAY_OF_MONTH) == 31 && this.rand.nextFloat() < 0.25F)
            {
                this.setItemStackToSlot(EntityEquipmentSlot.HEAD, new ItemStack(this.rand.nextFloat() < 0.1F ? Blocks.LIT_PUMPKIN : Blocks.PUMPKIN));
                this.inventoryArmorDropChances[EntityEquipmentSlot.HEAD.getIndex()] = 0.0F;
            }
        }

        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextDouble() * 0.05000000074505806D, 0));
        double d0 = this.rand.nextDouble() * 1.5D * (double)f;

        if (d0 > 1.0D)
        {
            this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).applyModifier(new AttributeModifier("Random zombie-spawn bonus", d0, 2));
        }

        if (this.rand.nextFloat() < f * 0.05F)
        {
            this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(new AttributeModifier("Leader zombie bonus", this.rand.nextDouble() * 3.0D + 1.0D, 2));
            this.setBreakDoorsAItask(true);
        }

        return livingdata;
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

    public void onLivingUpdate()
    {
        if (world.isDaytime() && !world.isRemote && !isChild())
        {
            float f = getBrightness(1.0f);
            if (f > 0.5f && rand.nextFloat() * 30.0f < (f - 0.4f) * 2.0f && world.canBlockSeeSky(new BlockPos(MathHelper.floor(posX), MathHelper.floor(posY), MathHelper.floor(posZ))))
            {
                setFire(8);
            }
            super.onLivingUpdate();
        }
        super.onLivingUpdate();
    }

    public boolean isUpsideDown()
    {
        return this.dataManager.get(UPSIDEDOWN);
    }

    public void setUpsideDown(boolean upsideDown)
    {
        this.dataManager.set(UPSIDEDOWN,upsideDown);
    }

}
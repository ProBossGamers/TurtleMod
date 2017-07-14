package com.probossgamers.turtlemod.entities.monster;

import com.probossgamers.turtlemod.SoundHandler;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.interfaces.ITurtle;
import com.probossgamers.turtlemod.items.ModItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

/**
 * Created by aaron on 6/24/2017.
 */
public class EntityDubStepTurtle extends EntityAnimal implements ITurtle
{
    private static final DataParameter<Boolean> UPSIDEDOWN = EntityDataManager.<Boolean>createKey(EntityDubStepTurtle.class, DataSerializers.BOOLEAN);

    public EntityDubStepTurtle(World world) {
        super(world);
        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new EntityAIWander(this, 1.0D));
        tasks.addTask(2, new EntityAIPanic(this, 1.0D));
        tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        tasks.addTask(4, new EntityAILookIdle(this));
        tasks.addTask(5, new EntityAITempt(this, 1.25D, ModItems.pizzaSlice, false));
        setSize(0.6F, 0.5F);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean isTurtle()
    {
        return true;
    }

    protected void entityInit()
    {
        super.entityInit();
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D / 2);
    }

    public void dropFewItems(boolean hit, int looting) {
        this.entityDropItem(new ItemStack(ModItems.turtleLeather), 0);
        this.entityDropItem(new ItemStack(ModBlocks.turtleShell), 0);
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

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == ModItems.pizzaSlice;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return new EntityTurtle(this.world);
    }
}

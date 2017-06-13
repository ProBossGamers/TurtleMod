package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.entities.EntityKunai;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class ItemKunai extends BasicWeapon
{
    public ItemKunai(String unlocalizedName)
    {
    	super(unlocalizedName, ModItems.Kunai);
        this.maxStackSize = 16;
    }


    /**
     * Gets the velocity of the entity from the charge
     */
    public static float getVelocity(int charge)
    {
        float f = (float)charge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;

        if (f > 1.0F)
        {
            f = 1.0F;
        }

        return f;
    }
    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 5000;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }




    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        int i = this.getMaxItemUseDuration(stack) - timeLeft;
        float f = getVelocity(i);
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            if (!entityplayer.capabilities.isCreativeMode)
            {
                stack.shrink(1);
            }
            if ((double)f >= 0.1D)
            {
                boolean flag1 = entityplayer.capabilities.isCreativeMode || (stack.getItem() instanceof ItemKunai && ((ItemKunai) stack.getItem()).isInfinite(stack, entityplayer));

                if (!worldIn.isRemote)
                {

                    EntityKunai entityKunai = new EntityKunai(worldIn, entityLiving);
                    entityKunai.setHeadingFromThrower(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);


                    if (f == 1.0F)
                    {
                        entityKunai.setIsCritical(true);
                    }

                    int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                    if (j > 0)
                    {
                        entityKunai.setDamage(entityKunai.getDamage() + (double)j * 0.5D + 0.5D);
                    }

                    int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

                    if (k > 0)
                    {
                        entityKunai.setKnockbackStrength(k);
                    }

                    if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
                    {
                        entityKunai.setFire(100);
                    }

                    stack.damageItem(1, entityplayer);

                    /*
                   if (flag1 || entityplayer.capabilities.isCreativeMode)
                   {
                   entityKunai.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
                   }
                   */

                    worldIn.spawnEntity(entityKunai);
                }

                worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                if (!flag1 && !entityplayer.capabilities.isCreativeMode)
                {
                    stack.shrink(1);

                    if (stack.isEmpty())
                    {
                        entityplayer.inventory.deleteStack(stack);
                    }
                }

            }


        }
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);

        playerIn.setActiveHand(handIn);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    public boolean isInfinite(ItemStack stack, EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, stack);
        return enchant > 0;
    }
}
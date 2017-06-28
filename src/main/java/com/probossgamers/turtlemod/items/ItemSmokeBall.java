package com.probossgamers.turtlemod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by aaron on 6/28/2017.
 */
public class ItemSmokeBall extends BasicItem
{
    public ItemSmokeBall(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        BlockPos currentPos = playerIn.getPosition();
        if(!worldIn.isRemote)
        {
            worldIn.spawnParticle(EnumParticleTypes.CLOUD, currentPos.getX(),currentPos.getY(), currentPos.getZ(),0.0,0.5,0.0);
        }
        playerIn.setActiveHand(handIn);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}

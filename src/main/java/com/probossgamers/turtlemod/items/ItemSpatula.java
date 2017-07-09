package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.PlayerUtils;
import com.probossgamers.turtlemod.TurtleMain;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.interfaces.ITurtle;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by aaron on 7/9/2017.
 */
public class ItemSpatula extends BasicItem
{
    public ItemSpatula(String unlocalizedName)
    {
        super(unlocalizedName);
    }

    @Override
    public boolean itemInteractionForEntity(ItemStack itemstack, EntityPlayer player, EntityLivingBase entity, EnumHand hand)
    {
        if (entity.world.isRemote)
        {
            return false;
        }
        if (entity instanceof ITurtle)
        {
            ITurtle target = (ITurtle) entity;
            target.setUpsideDown(true);
            return true;
        }
        return false;
    }



}

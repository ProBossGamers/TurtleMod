package net.probossgamers.turtlemod.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public interface ICustomHighlightedBlock
{
    AxisAlignedBB[] getBoxes(World world, int x, int y, int z, EntityPlayer player);
}

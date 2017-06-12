package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by aaron on 6/12/2017.
 */
public class ItemTurtleArmor extends ItemModArmor
{

    /**
     * Armor types as used on player: 0 boots, 1 legs, 2 chest, 3 helm
     * Armor types as used in armor class: 0 helm, 1 chest, 2 legs, 3 boots
     */
    public ItemTurtleArmor(String unlocalizedName, ArmorMaterial material, int renderIndex, EntityEquipmentSlot type)
    {
        super(unlocalizedName,material, renderIndex, type);
    }

    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        switch (facing)
        {
            case DOWN:
                worldIn.setBlockState(new BlockPos(pos.getX(),pos.getY() - 1,pos.getZ()), ModBlocks.turtleShell.getStateFromMeta(0));
                break;
            case UP:
                worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), ModBlocks.turtleShell.getStateFromMeta(1));
                break;
            case NORTH:
                worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1), ModBlocks.turtleShell.getStateFromMeta(2));
                break;
            case SOUTH:
                worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1), ModBlocks.turtleShell.getStateFromMeta(3));
                break;
            case WEST:
                worldIn.setBlockState(new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()), ModBlocks.turtleShell.getStateFromMeta(4));
                break;
            case EAST:
                worldIn.setBlockState(new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()), ModBlocks.turtleShell.getStateFromMeta(5));
                break;
        }
        ItemStack currentStack = player.getActiveItemStack();
        int currentAmount = currentStack.getCount();
        currentStack.setCount(--currentAmount);
        return EnumActionResult.PASS;
    }

}

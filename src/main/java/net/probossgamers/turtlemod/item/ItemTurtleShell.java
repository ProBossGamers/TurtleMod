package net.probossgamers.turtlemod.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.block.ModBlocks;

public class ItemTurtleShell extends ItemArmor
{
    public ItemTurtleShell()
    {
        super(ModItems.turtleArmor, 0, 1);
        setUnlocalizedName("turtleShell");
        setTextureName("turtlemod:turtleShell");
    }

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int h, float f, float t, float k)
    {
        world.setBlock(x, y + 1, z, ModBlocks.shellBlock);
        return false;
    }
}

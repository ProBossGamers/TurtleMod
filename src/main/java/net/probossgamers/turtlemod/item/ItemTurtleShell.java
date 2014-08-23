package net.probossgamers.turtlemod.item;

import net.minecraft.entity.Entity;
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

    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float i, float d, float k)
    {
        switch (side)
        {
            case 0:
                world.setBlock(x, y - 1, z, ModBlocks.shellBlock);
                break;
            case 1:
                world.setBlock(x, y + 1, z, ModBlocks.shellBlock);
                break;
            case 2:
                world.setBlock(x, y, z - 1, ModBlocks.shellBlock);
                break;
            case 3:
                world.setBlock(x, y, z + 1, ModBlocks.shellBlock);
                break;
            case 4:
                world.setBlock(x - 1, y, z, ModBlocks.shellBlock);
                break;
            case 5:
                world.setBlock(x + 1, y, z, ModBlocks.shellBlock);
                break;
        }
        player.getCurrentEquippedItem().stackSize--;
        return true;
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "turtlemod:textures/models/armor/shell_1.png";
    }
}

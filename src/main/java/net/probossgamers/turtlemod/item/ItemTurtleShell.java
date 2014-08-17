package net.probossgamers.turtlemod.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.probossgamers.turtlemod.ModItems;

public class ItemTurtleShell extends ItemArmor
{
    public ItemTurtleShell()
    {
        super(ModItems.turtleArmor, 0, 1);
        setMaxStackSize(16);
        setUnlocalizedName("turtleShellChestplate");
        setTextureName("turtlemod:turtleShell");
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        return "turtlemod:textures/models/armor/shell_1.png";
    }
}

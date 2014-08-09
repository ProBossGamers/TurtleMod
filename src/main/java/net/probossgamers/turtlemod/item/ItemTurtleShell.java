package net.probossgamers.turtlemod.item;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.probossgamers.turtlemod.TurtleMod;

public class ItemTurtleShell extends ItemArmor {
    public ItemTurtleShell(ItemArmor.ArmorMaterial material, int id, int placement) {
        super(material, id, placement);
        setCreativeTab(TurtleMod.turtleTab);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == TurtleMod.turtleShell) {
            return "turtlemod:textures/models/armor/shell_1.png";
        } else {
            return null;
        }
    }
}

package net.probossgamers.TurtleMod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.probossgamers.TurtleMod.TurtleMod;

public class ItemTurtleArmor extends ItemArmor {
    public ItemTurtleArmor(ItemArmor.ArmorMaterial material, int id, int placement) {
        super(material, id, placement);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == TurtleMod.turtleHelmet || stack.getItem() == TurtleMod.turtleChestplate || stack.getItem() == TurtleMod.turtleBoots) {
            return "turtlemod:textures/models/armor/turtle_1.png";
        }
        if (stack.getItem() == TurtleMod.turtleLeggings) {
            return "turtlemod:textures/models/armor/turtle_2.png";
        } else {
            return null;
        }
    }
}

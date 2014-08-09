package net.probossgamers.TurtleMod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.probossgamers.TurtleMod.TurtleMod;

public class ItemTurtleShell extends ItemArmor {
    public ItemTurtleShell(ItemArmor.ArmorMaterial material, int id, int placement) {
        super(material, id, placement);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == TurtleMod.turtleShell) {
            return "turtlemod:textures/models/armor/shell_1.png";
        } else {
            return null;
        }
    }
}

package net.probossgamers.turtlemod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.TurtleMod;

public class ItemTurtleArmor extends ItemArmor {
    public ItemTurtleArmor(ItemArmor.ArmorMaterial material, int id, int placement) {
        super(material, id, placement);
        setCreativeTab(TurtleMod.turtleTab);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == RegisterItems.turtleHelmet || stack.getItem() == RegisterItems.turtleChestplate || stack.getItem() == RegisterItems.turtleBoots) {
            return "turtlemod:textures/models/armor/turtle_1.png";
        }
        if (stack.getItem() == RegisterItems.turtleLeggings) {
            return "turtlemod:textures/models/armor/turtle_2.png";
        } else {
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        if (player.getCurrentArmor(3) != null) {
            ItemStack helmet = player.getCurrentArmor(3);

            if (helmet.getItem() == RegisterItems.turtleHelmet) {
                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 10, 0));
            }
        }
    }
}

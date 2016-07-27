package net.probossgamers.turtlemod.client.items;

import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.probossgamers.turtlemod.TurtleMod;

public class ItemTurtleArmor extends ItemArmor {
    public ItemTurtleArmor(EntityEquipmentSlot equipmentSlotIn) {
        super(TurtleMod.turtleArmor, 0, equipmentSlotIn);
    }
}

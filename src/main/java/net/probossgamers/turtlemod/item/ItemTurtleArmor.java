package net.probossgamers.turtlemod.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemTurtleArmor extends ItemArmor
{
    public ItemTurtleArmor(int placement, String name)
    {
        super(ModItems.turtleArmor, 0, placement);
        setUnlocalizedName(name);
        setTextureName("turtlemod:" + name);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (stack.getItem() != ModItems.turtleLeggings)
        {
            return "turtlemod:textures/models/armor/turtle_1.png";
        }
        else
        {
            return "turtlemod:textures/models/armor/turtle_2.png";
        }
    }

    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if (player.getCurrentArmor(3) != null)
        {
            ItemStack helmet = player.getCurrentArmor(3);

            if (helmet.getItem() == this)
            {
                player.addPotionEffect(new PotionEffect(Potion.waterBreathing.getId(), 10, 0));
            }
        }
    }
}

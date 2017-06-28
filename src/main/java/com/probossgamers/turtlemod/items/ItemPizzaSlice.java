package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import static com.probossgamers.turtlemod.TurtleMain.PIZZA_EATEN;

public class ItemPizzaSlice extends ItemModFood
{

	public ItemPizzaSlice(String unlocalizedName)
	{
		super(unlocalizedName, 2, 0.6F,true);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player)
	{
		super.onFoodEaten(stack, world, player);
		player.addStat(TurtleMain.PIZZA_EATEN);

	}
}

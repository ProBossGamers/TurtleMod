package com.a2937.turtlemod.items;

import com.a2937.turtlemod.TurtleMain;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemModFood extends ItemFood {

	private PotionEffect[] effects;
	
	 public ItemModFood(String unlocalizedName, int amount, float saturation, boolean isWolfFood, PotionEffect... effects) {
	        super(amount, saturation, isWolfFood);
	        this.setUnlocalizedName(unlocalizedName);
	        this.setCreativeTab(TurtleMain.tabCustom);
	        this.effects = effects;
	    }
	 
	 @Override
	 protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	     super.onFoodEaten(stack, world, player);
	     
	     for (int i = 0; i < effects.length; i ++) {
	         effects[i].getPotion();
			if (!world.isRemote && effects[i] != null && Potion.getIdFromPotion(effects[i].getPotion()) > 0)
	             player.addPotionEffect(new PotionEffect(this.effects[i]));
	     }
	 }
	 
	 
}

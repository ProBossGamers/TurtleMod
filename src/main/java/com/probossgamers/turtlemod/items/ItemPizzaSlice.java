package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.item.ItemFood;

public class ItemPizzaSlice extends ItemFood {

	public ItemPizzaSlice(String unlocalizedName) {
		super(2, true);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TurtleMain.tabCustom);
	}
	
}

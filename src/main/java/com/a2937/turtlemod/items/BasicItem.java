package com.a2937.turtlemod.items;

import com.a2937.turtlemod.TurtleMain;

import net.minecraft.item.Item;

public class BasicItem extends Item{

	public BasicItem(String unlocalizedName) {
	    super();
	    this.setUnlocalizedName(unlocalizedName);
	    //this.setRegistryName(unlocalizedName);
	    this.setCreativeTab(TurtleMain.tabCustom);
	}
	
}

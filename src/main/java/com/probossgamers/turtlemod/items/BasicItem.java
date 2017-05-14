package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.item.Item;

public class BasicItem extends Item{

	public BasicItem(String unlocalizedName) {
	    super();
	    this.setUnlocalizedName(unlocalizedName);
	    //this.setRegistryName(unlocalizedName);
	    this.setCreativeTab(TurtleMain.tabCustom);
	}
	
}

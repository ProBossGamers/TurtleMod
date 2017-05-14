package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemCustomSeeds extends ItemSeeds  {

	public ItemCustomSeeds(String name, Block crop, Block land) {
		super(crop, land);
		setUnlocalizedName(name);
		setCreativeTab(TurtleMain.tabCustom);
	}


}
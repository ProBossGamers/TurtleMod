package com.a2937.turtlemod.items;

import com.a2937.turtlemod.TurtleMain;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

public class ItemCustomSeeds extends ItemSeeds  {

	public ItemCustomSeeds(String name, Block crop, Block land) {
		super(crop, land);
		setUnlocalizedName(name);
		setCreativeTab(TurtleMain.tabCustom);
	}


}
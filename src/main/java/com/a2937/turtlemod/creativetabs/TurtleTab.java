package com.a2937.turtlemod.creativetabs;

import com.a2937.turtlemod.ModInfo;
import com.a2937.turtlemod.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TurtleTab extends CreativeTabs {

	public TurtleTab() {
		super(ModInfo.MODID);
		setBackgroundImageName("item_search.png");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModItems.turtleLeather);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
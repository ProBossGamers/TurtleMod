/**
 * A custom tab that can be modified to suit
 * what we need
 */
package com.probossgamers.turtlemod.creativetabs;

import com.probossgamers.turtlemod.ModInfo;
import com.probossgamers.turtlemod.items.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TurtleTab extends CreativeTabs
{

	public TurtleTab()
	{
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
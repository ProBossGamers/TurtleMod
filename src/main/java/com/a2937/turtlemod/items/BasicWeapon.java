package com.a2937.turtlemod.items;

import com.a2937.turtlemod.TurtleMain;

import net.minecraft.item.ItemSword;

public class BasicWeapon extends ItemSword{

	public BasicWeapon(String unlocalizedName,ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TurtleMain.tabCustom);
	}

}

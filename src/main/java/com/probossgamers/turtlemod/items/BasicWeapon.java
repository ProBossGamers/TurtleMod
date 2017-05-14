package com.probossgamers.turtlemod.items;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.item.ItemSword;

public class BasicWeapon extends ItemSword{

	public BasicWeapon(String unlocalizedName,ToolMaterial material) {
		super(material);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(TurtleMain.tabCustom);
	}

}

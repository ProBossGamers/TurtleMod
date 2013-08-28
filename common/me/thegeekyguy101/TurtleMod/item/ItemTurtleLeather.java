package me.thegeekyguy101.TurtleMod.item;

import me.thegeekyguy101.TurtleMod.TurtleMod;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTurtleLeather extends Item {
	
	public ItemTurtleLeather(int par1) {
		super(par1);
		this.setCreativeTab(TurtleMod.turtleTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon) {
		this.itemIcon = par1RegisterIcon.registerIcon("turtlemod:turtleLeather");
	}
}

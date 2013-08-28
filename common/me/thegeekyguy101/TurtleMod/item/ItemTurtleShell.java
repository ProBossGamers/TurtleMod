package me.thegeekyguy101.TurtleMod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTurtleShell extends ItemArmor {
	
	public ItemTurtleShell(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par1, par2EnumArmorMaterial, par3, par4);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon) {
		this.itemIcon = par1RegisterIcon.registerIcon("turtlemod:turtleShell");
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		return "turtlemod:textures/models/armor/shell_1.png";
	}
}

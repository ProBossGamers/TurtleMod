package com.a2937.turtlemod.client.render.items;

import java.util.List;

import com.a2937.turtlemod.ModInfo;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class ItemRenderRegister {

	 public static void registerItemRenderer(List<Item> items) {

		 for(Item item : items) {
	    		reg(item);
	    	}
	    }
	 
	 public static String modid = ModInfo.MODID;

	 public static void reg(Item item) {
		 ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(ModInfo.MODID.toLowerCase() + ":" + item.getUnlocalizedName().substring(5), "inventory"));

	 }
	
}

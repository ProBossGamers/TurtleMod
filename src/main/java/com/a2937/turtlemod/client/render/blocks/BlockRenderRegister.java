package com.a2937.turtlemod.client.render.blocks;


import java.util.List;

import com.a2937.turtlemod.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class BlockRenderRegister {
   
	public static String modid = ModInfo.MODID;

	public static void registerBlockRenderer(List<Block> blocks) {
		
		
		for(Block block : blocks) {
			reg(block);
    	}
		
	}
	
	public static void reg(Block block) {
	Item itemBlock= Item.getItemFromBlock(block);
	 ModelLoader.setCustomModelResourceLocation(itemBlock, 0, new ModelResourceLocation(ModInfo.MODID.toLowerCase() + ":" + itemBlock.getUnlocalizedName().substring(5), "inventory"));
	
	}
	

}
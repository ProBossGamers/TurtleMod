package com.probossgamers.turtlemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class NewBlockRegistry {

	public ItemBlock[] blocks;
	public void register(Block[] block) 
	{
		for(int i = 0; i<block.length;i++) {
			GameRegistry.register(blocks[i]= (ItemBlock)new ItemBlock(block[i]),block[i].getRegistryName());
		}
	}
}

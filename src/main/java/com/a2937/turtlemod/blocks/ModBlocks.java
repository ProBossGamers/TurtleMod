package com.a2937.turtlemod.blocks;

import java.util.List;

import com.a2937.turtlemod.items.ModItems;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {


	 
	 
	public static Block tutorialBlock;
	public static Block tutorialOre;
	public static Block tutorialMultiOre;
	public static BlockCustomCrop blockCorn; 
	
	public static List<Block> blocks = Lists.newArrayList();
	//public static List<DirectionBlock> sidedBlocks = Lists.newArrayList();
	public static List<BlockCustomCrop> crops= Lists.newArrayList();
	//public static Block petStatue;
	//public static Block shrine;
	//public static Block stairs;

	
	public static void createPlants() {
		///	blockCorn = new BlockCustomCrop("cropCorn", ModItems.corn);
		//	 GameRegistry.registerBlock(blockCorn, "cropCorn");
		//	 crops.add(blockCorn);
	}
	
	public static void linkPlants() { 
		//blockCorn.setSeed(ModItems.cornSeeds); 
	}
	
    public static void createBlocks() {
    //	 GameRegistry.register(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f),new ResourceLocation("turtlemod","t"));
    	
    //	 GameRegistry.register(tutorialOre = new ModBlockOre("tutorial_ore", Material.ROCK, ModItems.turtleLeather, 2, 4));
    //	 GameRegistry.register(tutorialMultiOre = new ModBlockMultiOre("tutorial_multi_ore", Material.ROCK, 10.0f, 20.0f));
    	
    	//localization
    
    //	blocks.add(tutorialBlock);
	// blocks.add(tutorialOre);
	// blocks.add(tutorialMultiOre);
	
	 }
}
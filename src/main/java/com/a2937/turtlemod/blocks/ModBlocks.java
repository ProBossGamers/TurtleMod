package com.a2937.turtlemod.blocks;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {


	 
	 
	public static Block creamQuartz;
	public static BlockCustomCrop blockCorn; 
	
	public static ItemBlock ibCreamQuartz;
	public static ItemBlock ibTurtleShell;
	public static List<Block> blocks = Lists.newArrayList();
	
	//public static List<DirectionBlock> sidedBlocks = Lists.newArrayList();
	public static List<BlockCustomCrop> crops= Lists.newArrayList();
	//public static Block petStatue;
	//public static Block shrine;
	//public static Block stairs;
	public static Block turtleShell;

	
	public static void createPlants() {
		///	blockCorn = new BlockCustomCrop("cropCorn", ModItems.corn);
		//	 GameRegistry.registerBlock(blockCorn, "cropCorn");
		//	 crops.add(blockCorn);
	}
	
	public static void linkPlants() { 
		//blockCorn.setSeed(ModItems.cornSeeds); 
	}
	
    public static void createBlocks() {
    	GameRegistry.register(creamQuartz=new BasicBlock("cream_quartz", SoundType.METAL, Material.ROCK, 0.8f, 0.8f),new ResourceLocation("turtlemod","cream_quartz")); 
    
    	GameRegistry.register(turtleShell=new BasicBlock("shell_block", SoundType.STONE, Material.ROCK, 0.8f, 0.8f),new ResourceLocation("turtlemod","shell_block")); 
    	
    	GameRegistry.register(ibCreamQuartz = (ItemBlock) new ItemBlock(creamQuartz), creamQuartz.getRegistryName());
    	GameRegistry.register(ibTurtleShell = (ItemBlock) new ItemBlock(turtleShell), turtleShell.getRegistryName());
    	
    	
    	//	 GameRegistry.register(tutorialBlock = new BasicBlock("tutorial_block").setLightLevel(1.0f),new ResourceLocation("turtlemod","t"));
    	
    //	 GameRegistry.register(tutorialOre = new ModBlockOre("tutorial_ore", Material.ROCK, ModItems.turtleLeather, 2, 4));
    //	 GameRegistry.register(tutorialMultiOre = new ModBlockMultiOre("tutorial_multi_ore", Material.ROCK, 10.0f, 20.0f));
    	
    	//localization
    
    blocks.add(creamQuartz);
    blocks.add(turtleShell);
    //	blocks.add(tutorialBlock);
	// blocks.add(tutorialOre);
	// blocks.add(tutorialMultiOre);
	
	 }
}
package com.probossgamers.turtlemod.crafting;

import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.items.ModItems;

//import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static ItemStack boneMeal = new ItemStack(Items.DYE, 1, 15);
	public static ItemStack quartz = new ItemStack(Items.QUARTZ);
		
	public static void initCrafting() {

		
		  GameRegistry.addRecipe(new ItemStack(ModItems.turtleHelmet), "LLL", "L L", 'L', ModItems.turtleLeather, 'S', ModBlocks.turtleShell);
		  GameRegistry.addRecipe(new ItemStack(ModItems.turtleChestplate), "L L", "LSL", "LLL", 'L', ModItems.turtleLeather, 'S', ModBlocks.turtleShell);
		  GameRegistry.addRecipe(new ItemStack(ModItems.turtleLeggings), "LLL", "L L", "L L", 'L', ModItems.turtleLeather);
		  GameRegistry.addRecipe(new ItemStack(ModItems.turtleBoots), "L L", "L L", 'L', ModItems.turtleLeather);
          GameRegistry.addRecipe(new ItemStack(ModBlocks.creamQuartz), "CC", "CC", 'C', ModItems.creamQuartzPiece);
          GameRegistry.addShapelessRecipe(new ItemStack(ModItems.creamQuartzPiece), boneMeal, quartz);
	}

	
	
}

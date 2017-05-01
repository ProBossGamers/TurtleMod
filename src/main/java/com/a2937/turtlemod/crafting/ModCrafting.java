package com.a2937.turtlemod.crafting;

import com.a2937.turtlemod.items.ModItems;

//import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void initCrafting() {

		GameRegistry.addRecipe(new ItemStack(ModItems.turtleHelmet), new Object[] {"###", "# #", '#', ModItems.turtleLeather});
		GameRegistry.addRecipe(new ItemStack(ModItems.turtleChestplate), new Object[] {"# #", "# #", '#', ModItems.turtleLeather});
	}

	
	
}

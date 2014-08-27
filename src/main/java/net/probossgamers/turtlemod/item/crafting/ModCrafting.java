package net.probossgamers.turtlemod.item.crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.probossgamers.turtlemod.ContentHandler;
import net.probossgamers.turtlemod.block.ModBlocks;
import net.probossgamers.turtlemod.item.ModItems;

public class ModCrafting implements ContentHandler.IContentProvider
{

    public static ItemStack boneMeal = new ItemStack(Items.dye, 1, 15);
    public static ItemStack quartz = new ItemStack(Items.quartz);

    public void init() {
        GameRegistry.addRecipe(new ItemStack(ModItems.turtleHelmet), "LLL", "L L", 'L', ModItems.turtleLeather, 'S', ModItems.turtleShell);
        GameRegistry.addRecipe(new ItemStack(ModItems.turtleChestplate), "L L", "LSL", "LLL", 'L', ModItems.turtleLeather, 'S', ModItems.turtleShell);
        GameRegistry.addRecipe(new ItemStack(ModItems.turtleLeggings), "LLL", "L L", "L L", 'L', ModItems.turtleLeather);
        GameRegistry.addRecipe(new ItemStack(ModItems.turtleBoots), "L L", "L L", 'L', ModItems.turtleLeather);

        GameRegistry.addRecipe(new ItemStack(ModBlocks.creamQuartz_Block), "CC", "CC", 'C', ModItems.creamQuartz);

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.creamQuartz), boneMeal, quartz);
    }
}

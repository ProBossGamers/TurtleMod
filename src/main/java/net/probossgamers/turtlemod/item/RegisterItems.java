package net.probossgamers.turtlemod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.probossgamers.turtlemod.TurtleMod;

public class RegisterItems {

    public static Item turtleLeather;
    public static Item turtleShell;
    public static Item turtleHelmet;
    public static Item turtleChestplate;
    public static Item turtleLeggings;
    public static Item turtleBoots;

    public static ItemArmor.ArmorMaterial turtleMaterial = EnumHelper.addArmorMaterial("Turtle", 5, new int[]{1, 3, 2, 1}, 15);

    public static void itemInit() {
        turtleLeather = new Item().setUnlocalizedName("turtleLeather").setTextureName("turtlemod:turtleLeather").setCreativeTab(TurtleMod.turtleTab);
        turtleShell = new ItemTurtleShell(turtleMaterial, 0, 1).setTextureName("turtlemod:turtleShell").setUnlocalizedName("turtleShell");
        turtleHelmet = new ItemTurtleArmor(turtleMaterial, 0, 0).setTextureName("turtlemod:turtleHelmet").setUnlocalizedName("turtleHelmet");
        turtleChestplate = new ItemTurtleArmor(turtleMaterial, 0, 1).setTextureName("turtlemod:turtleChestplate").setUnlocalizedName("turtleChestplate");
        turtleLeggings = new ItemTurtleArmor(turtleMaterial, 0, 2).setTextureName("turtlemod:turtleLeggings").setUnlocalizedName("turtleLeggings");
        turtleBoots = new ItemTurtleArmor(turtleMaterial, 0, 3).setTextureName("turtlemod:turtleBoots").setUnlocalizedName("turtleBoots");
        GameRegistry.registerItem(turtleLeather, "Turtle Leather");
        GameRegistry.registerItem(turtleShell, "Turtle Shell");
        GameRegistry.registerItem(turtleHelmet, "Turtle Helmet");
        GameRegistry.registerItem(turtleChestplate, "Turtle Chestplate");
        GameRegistry.registerItem(turtleLeggings, "Turtle Leggings");
        GameRegistry.registerItem(turtleBoots, "Turtle Boots");
        GameRegistry.addRecipe(new ItemStack(turtleHelmet), "TST", "T T", 'T', turtleLeather, 'S', turtleShell);
        GameRegistry.addRecipe(new ItemStack(turtleChestplate), "T T", "TST", "TTT", 'T', turtleLeather, 'S', turtleShell);
        GameRegistry.addRecipe(new ItemStack(turtleLeggings), "TTT", "T T", "T T", 'T', turtleLeather);
        GameRegistry.addRecipe(new ItemStack(turtleBoots), "T T", "T T", 'T', turtleLeather);
    }
}

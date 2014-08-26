package net.probossgamers.turtlemod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.probossgamers.turtlemod.ContentHandler;
import net.probossgamers.turtlemod.creativetab.ModTabs;

import java.lang.reflect.Field;

public class ModItems implements ContentHandler.IContentProvider
{
    public static Item turtleLeather;
    public static Item turtleHelmet;
    public static Item turtleChestplate;
    public static Item turtleLeggings;
    public static Item turtleBoots;
    public static Item turtleShell;
    public static Item creamQuartz;

    public static ItemStack boneMeal = new ItemStack(Items.dye, 1, 15);
    public static ItemStack quartz = new ItemStack(Items.quartz);


    public static ItemArmor.ArmorMaterial turtleArmor;

    public void init()
    {
        turtleArmor = EnumHelper.addArmorMaterial("Turtle", 5, new int[]{1, 3, 2, 1}, 15);

        turtleLeather = new Item().setUnlocalizedName("turtleLeather").setTextureName("turtlemod:turtleLeather");
        turtleHelmet = new ItemTurtleArmor(0, "turtleHelmet");
        turtleChestplate = new ItemTurtleArmor(1, "turtleChestplate");
        turtleLeggings = new ItemTurtleArmor(2, "turtleLeggings");
        turtleBoots = new ItemTurtleArmor(3, "turtleBoots");
        turtleShell = new ItemTurtleShell();
        creamQuartz = new Item().setUnlocalizedName("creamQuartz").setTextureName("turtlemod:creamQuartz");


        GameRegistry.addRecipe(new ItemStack(turtleHelmet), "LSL", "L L", 'L', turtleLeather, 'S', turtleShell);
        GameRegistry.addRecipe(new ItemStack(turtleChestplate), "L L", "LSL", "LLL", 'L', turtleLeather, 'S', turtleShell);
        GameRegistry.addRecipe(new ItemStack(turtleLeggings), "LLL", "L L", "L L", 'L', turtleLeather);
        GameRegistry.addRecipe(new ItemStack(turtleBoots), "L L", "L L", 'L', turtleLeather);
        GameRegistry.addShapelessRecipe(new ItemStack(creamQuartz), boneMeal, quartz);

        setCreativeTabs();
        registerItems();
    }

    public void setCreativeTabs()
    {
        try
        {
            for (Field field : getClass().getDeclaredFields())
            {
                Object obj = field.get(null);
                if (obj != ModItems.turtleShell) {
                    if (obj instanceof Item) ModTabs.items.setCreativeTab((Item) obj);
                    else if (obj instanceof Item[]) ModTabs.items.setCreativeTab((Item[]) obj);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void registerItems()
    {
        try
        {
            for (Field field : getClass().getDeclaredFields())
            {
                Object obj = field.get(null);
                if (obj instanceof Item) GameRegistry.registerItem((Item) obj, field.getName());
                else if (obj instanceof Item[]) for (Item item : (Item[]) obj) GameRegistry.registerItem(item, item.getUnlocalizedName().split("\\.")[1]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

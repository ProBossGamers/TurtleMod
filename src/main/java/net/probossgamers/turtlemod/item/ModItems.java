package net.probossgamers.turtlemod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
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
    public static Item donsStick;
    public static Item katana;
    public static Item kunai;
    public static Item leosKatana;
    public static Item mikesChucks;
    public static Item pizza;
    public static Item smokePallet;
    public static Item spatula;

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
        donsStick = new Item().setUnlocalizedName("donsStick").setTextureName("turtlemod:donsStick");
        katana = new Item().setUnlocalizedName("katana").setTextureName("turtlemod:katana");
        kunai = new Item().setUnlocalizedName("kunai").setTextureName("turtlemod:kunai");
        leosKatana = new Item().setUnlocalizedName("leosKatana").setTextureName("turtlemod:leosKatana");
        mikesChucks = new Item().setUnlocalizedName("mikesChucks").setTextureName("turtlemod:mikesChucks");
        pizza = new Item().setUnlocalizedName("pizza").setTextureName("turtlemod:pizza");
        smokePallet = new Item().setUnlocalizedName("smokePallet").setTextureName("turtlemod:smokePallet");
        spatula = new Item().setUnlocalizedName("spatula").setTextureName("turtlemod:spatula");



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
                if (obj != ModItems.turtleShell)
                {
                    if (obj instanceof Item)
                    {
                        ModTabs.items.setCreativeTab((Item) obj);
                    }
                    else if (obj instanceof Item[])
                    {
                        ModTabs.items.setCreativeTab((Item[]) obj);
                    }
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
                if (obj instanceof Item)
                {
                    GameRegistry.registerItem((Item) obj, field.getName());
                }
                else if (obj instanceof Item[])
                {
                    for (Item item : (Item[]) obj)
                    {
                        GameRegistry.registerItem(item, item.getUnlocalizedName().split("\\.")[1]);
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

package net.probossgamers.turtlemod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.probossgamers.turtlemod.creativetab.ModTabs;
import net.probossgamers.turtlemod.ContentHandler;

import java.lang.reflect.Field;

public class ModItems implements ContentHandler.IContentProvider
{
    public static Item turtleLeather;
    public static Item turtleHelmet;
    public static Item turtleChestplate;
    public static Item turtleLeggings;
    public static Item turtleBoots;

    public static ItemArmor.ArmorMaterial turtleArmor;

    public void init()
    {
        turtleArmor = EnumHelper.addArmorMaterial("Turtle", 5, new int[]{1, 3, 2, 1}, 15);

        turtleLeather = new Item().setUnlocalizedName("turtleLeather").setTextureName("turtlemod:turtleLeather");
        turtleHelmet = new ItemTurtleArmor(0, "turtleHelmet");
        turtleChestplate = new ItemTurtleArmor(1, "turtleChestplate");
        turtleLeggings = new ItemTurtleArmor(2, "turtleLeggings");
        turtleBoots = new ItemTurtleArmor(3, "turtleLeggings");

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
                if (obj instanceof Item) ModTabs.items.setCreativeTab((Item) obj);
                else if (obj instanceof Item[]) ModTabs.items.setCreativeTab((Item[]) obj);
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

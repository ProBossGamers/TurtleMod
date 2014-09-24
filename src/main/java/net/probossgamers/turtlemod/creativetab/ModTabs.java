package net.probossgamers.turtlemod.creativetab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.probossgamers.turtlemod.item.ModItems;

public class ModTabs
{
    public static CreativeTab blocks = new CreativeTab("turtlemod.blocks", ModItems.turtleShell);
    public static CreativeTab items = new CreativeTab("turtlemod.items", ModItems.turtleLeather);

    public static class CreativeTab extends CreativeTabs
    {
        public Item tabIconItem;

        public CreativeTab(String name, Item item)
        {
            super(name);
            tabIconItem = item;
        }

        public Item getTabIconItem()
        {
            return tabIconItem;
        }

        public void setCreativeTab(Block... blocks)
        {
            for (Block block : blocks)
            {
                if (block != null)
                {
                    block.setCreativeTab(this);
                }
            }
            ModItems.turtleShell.setCreativeTab(this);
        }

        public void setCreativeTab(Item... items)
        {
            for (Item item : items)
            {
                if (item != null)
                {
                    item.setCreativeTab(this);
                }
            }
        }
    }
}

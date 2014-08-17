package net.probossgamers.turtlemod.creativetab;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.probossgamers.turtlemod.ContentHandler;

public class ModTabs implements ContentHandler.IContentProvider
{
    public static CreativeTab blocks;
    public static CreativeTab items;

    public void init()
    {
        blocks = new CreativeTab("turtlemod.blocks", Item.getItemFromBlock(Blocks.command_block));
        items = new CreativeTab("turtlemod.items", Items.baked_potato);
    }

    public class CreativeTab extends CreativeTabs
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
            for (Block block : blocks) if (block != null) block.setCreativeTab(this);
        }

        public void setCreativeTab(Item... items)
        {
            for (Item item : items) if (item != null) item.setCreativeTab(this);
        }
    }
}

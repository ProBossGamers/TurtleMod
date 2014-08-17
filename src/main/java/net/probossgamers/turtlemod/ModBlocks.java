package net.probossgamers.turtlemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.probossgamers.turtlemod.block.BlockTurtleShell;
import net.probossgamers.turtlemod.content.ContentHandler;

import java.lang.reflect.Field;

public class ModBlocks implements ContentHandler.IContentProvider
{
    public static Block turtleShell;

    public void init()
    {
        turtleShell = new BlockTurtleShell();

        setCreativeTabs();
        registerBlocks();
    }

    public void setCreativeTabs()
    {
        try
        {
            for (Field field : getClass().getDeclaredFields())
            {
                Object obj = field.get(null);
                if (obj instanceof Block) ModTabs.blocks.setCreativeTab((Block) obj);
                else if (obj instanceof Block[]) ModTabs.blocks.setCreativeTab((Block[]) obj);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void registerBlocks()
    {
        try
        {
            for (Field field : getClass().getDeclaredFields())
            {
                Object obj = field.get(null);
                if (obj instanceof Block) GameRegistry.registerBlock((Block) obj, field.getName());
                else if (obj instanceof Block[]) for (Block block : (Block[]) obj) GameRegistry.registerBlock(block, block.getUnlocalizedName().split("\\.")[1]);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

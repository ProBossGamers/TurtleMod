package net.probossgamers.turtlemod.client.render.block;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class BlockTurtleShellRenderer implements ISimpleBlockRenderingHandler
{
    public static int id = RenderingRegistry.getNextAvailableRenderId();

    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {

    }

    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return renderer.hasOverrideBlockTexture() && renderer.renderStandardBlock(block, x, y, z);
    }

    public boolean shouldRender3DInInventory(int modelId)
    {
        return false;
    }

    public int getRenderId()
    {
        return id;
    }
}

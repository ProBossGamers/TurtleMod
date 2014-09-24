package net.probossgamers.turtlemod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCreamQuartz extends Block
{
    public BlockCreamQuartz()
    {
        super(Material.rock);
        setStepSound(soundTypePiston);
        setHardness(0.8F);
        setBlockTextureName("turtlemod:creamQuartz");
        setBlockName("creamQuartz");
    }

    public boolean renderAsNormalBlock()
    {
        return true;
    }
}

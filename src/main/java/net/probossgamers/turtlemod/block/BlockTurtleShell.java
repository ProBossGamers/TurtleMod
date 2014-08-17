package net.probossgamers.turtlemod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.tileentity.TileEntityTurtleShell;

public class BlockTurtleShell extends BlockContainer
{
    public BlockTurtleShell()
    {
        super(Material.rock);
        this.setBlockBounds(1f / 16f * 4, 0f, 1f / 16f * 4, 1f - 1f / 16f * 4, 1f - 1f / 16f * 11, 1f - 1f / 16f * 4);
        this.setBlockTextureName("turtlemod:turtleShell");
        this.setBlockName("turtleShellBlock");
    }

    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityTurtleShell();
    }

    public int getRenderType() {
        return -1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }
}
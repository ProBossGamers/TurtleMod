package net.probossgamers.turtlemod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.TurtleMod;
import net.probossgamers.turtlemod.tileentity.TileEntityTurtleShell;

public class BlockTurtleShell extends BlockContainer {
    public BlockTurtleShell() {
        super(Material.rock);
        this.setBlockBounds(1F/16F*4, 0F, 1F/16F*4, 1F-1F/16F*4, 1F-1F/16F*11, 1F-1F/16F*4);
        this.setCreativeTab(TurtleMod.turtleTab);
        this.setBlockTextureName("turtlemod:turtleShell");
        this.setBlockName("turtleShell");
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
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
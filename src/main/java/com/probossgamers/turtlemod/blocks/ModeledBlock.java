package com.probossgamers.turtlemod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

/**
 * Created by aaron on 6/13/2017.
 */
public class ModeledBlock extends BasicBlock
{

    public ModeledBlock(String unlocalizedName, SoundType sound, Material material, float hardness, float resistance)
    {
        super(unlocalizedName, sound, material, hardness, resistance);
    }


    @Override    public boolean isFullCube(IBlockState state) {        return false;    }

    @Override    public boolean isOpaqueCube(IBlockState state) {        return false;    }
}

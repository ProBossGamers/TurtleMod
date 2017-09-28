/**
 * A class for a block that has different model
 * dimensions than default
 */
package com.probossgamers.turtlemod.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

/**
 * Created by aaron on 6/13/2017.
 */
public class ModeledBlock extends BasicBlock
{

	private static AxisAlignedBB COLLISION_BOX_FULL;

	/**
	 A constructor for a normal block
	 */
    public ModeledBlock(String unlocalizedName, SoundType sound, Material material, float hardness, float resistance)
    {
        this(unlocalizedName, sound, material, hardness, resistance, new AxisAlignedBB(0f, 0f, 0f, 1f, 1f, 1f));
    }

    /**
     A constructor for a modelled block
     */
    public ModeledBlock(String unlocalizedName, SoundType sound, Material material, float hardness, float resistance, AxisAlignedBB collisionBox)
    {
        super(unlocalizedName, sound, material, hardness, resistance);
        COLLISION_BOX_FULL = collisionBox;
    }

    @Override    public boolean isFullCube(IBlockState state) {        return false;    }

    @Override    public boolean isOpaqueCube(IBlockState state) {        return false;    }
    
    @Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return COLLISION_BOX_FULL;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return COLLISION_BOX_FULL;
	}
    
}

package com.a2937.turtlemod.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

	public class BlockObject {
	   
		// This a wrap-around thing that allows schematics with 
		// vanilla blocks to be placed. It is not a new 
		// defined block. 
	   private BlockPos pos;
	   private IBlockState state;
	   
	   public BlockObject(BlockPos pos, IBlockState state) {
	      this.pos = pos;
	      this.state = state;
	   }

	   public BlockPos getPos() {
	      return pos;
	   }

	   public IBlockState getState() {
	      return state;
	   }
	   
	   public BlockPos getPosWithOffset(int x, int y, int z) {
	      return new BlockPos(x + pos.getX(), y + pos.getY(), z + pos.getZ());
	   }

	}

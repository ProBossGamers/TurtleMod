package com.probossgamers.turtlemod.blocks;

import java.util.Random;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockCustomCrop extends BlockCrops{
	
	private Item seedHold;
	
	private Item cropHold;

	public BlockCustomCrop(String name, Item crop) {
		cropHold=crop;
		setUnlocalizedName(name);
	}

	public void setSeed(Item seed) {
		seedHold=seed;
		
	}
	
	
	@Override
	  protected Item getCrop()
	    {
	        return cropHold;
	    }
	
	@Override
	protected Item getSeed() {
		return seedHold; 
	}
	
	  public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ((Integer)state.getValue(AGE)).intValue() == 7 ? this.getCrop() : this.getSeed();
	    }

}

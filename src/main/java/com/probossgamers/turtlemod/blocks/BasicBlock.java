package com.probossgamers.turtlemod.blocks;

import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BasicBlock extends Block {

    public BasicBlock(String unlocalizedName,SoundType sound, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setSoundType(sound);
        this.setCreativeTab(TurtleMain.tabCustom);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
    	this(unlocalizedName,SoundType.STONE,Material.ROCK,hardness,resistance);
    }
    
    
    public BasicBlock(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, hardness, resistance);
    }

    public BasicBlock(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }


    @Override    public boolean isFullCube(IBlockState state) {        return false;    }

    @Override    public boolean isOpaqueCube(IBlockState state) {        return false;    }
    /*
    public String getDescription() {
    	return "";
    }
    */
}
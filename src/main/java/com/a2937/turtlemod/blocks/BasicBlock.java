package com.a2937.turtlemod.blocks;

import com.a2937.turtlemod.TurtleMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BasicBlock extends Block {

    public BasicBlock(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setRegistryName(unlocalizedName);
        this.setCreativeTab(TurtleMain.tabCustom);
        this.setHardness(hardness);
        this.setResistance(resistance);
    }

    public BasicBlock(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.ROCK, hardness, resistance);
    }

    public BasicBlock(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
    }
   
    /*
    public String getDescription() {
    	return "";
    }
    */
}
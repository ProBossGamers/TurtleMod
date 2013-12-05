package me.thegeekyguy101.TurtleMod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.thegeekyguy101.TurtleMod.TurtleMod;
import me.thegeekyguy101.TurtleMod.tileentity.TileEntityTurtleShell;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTurtleShell extends BlockContainer {

	public BlockTurtleShell(int id) {
		super(id, Material.rock);
		
		this.setBlockBounds(1F/16F*4, 0F, 1F/16F*4, 1F-1F/16F*4, 1F-1F/16F*11, 1F-1F/16F*4);
		this.setCreativeTab(TurtleMod.turtleTab);
	}

	public TileEntity createNewTileEntity(World world) {
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
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon) {
		this.blockIcon = icon.registerIcon("turtlemod:turtleShell");
	}

}

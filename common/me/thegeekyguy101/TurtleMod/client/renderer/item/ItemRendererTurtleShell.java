package me.thegeekyguy101.TurtleMod.client.renderer.item;

import me.thegeekyguy101.TurtleMod.client.model.ModelTurtleShell;
import me.thegeekyguy101.TurtleMod.tileentity.TileEntityTurtleShell;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererTurtleShell implements IItemRenderer {
	
	private ModelTurtleShell model;
	
	public ItemRendererTurtleShell() {
		model = new ModelTurtleShell();
	}
	
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRenderer.instance.renderTileEntityAt(new TileEntityTurtleShell(), 0.0D, 0.0D, 0.0D, 0.0F);
	}

}

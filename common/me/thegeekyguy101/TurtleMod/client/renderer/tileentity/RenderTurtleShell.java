package me.thegeekyguy101.TurtleMod.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import me.thegeekyguy101.TurtleMod.client.model.ModelTurtleShell;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTurtleShell extends TileEntitySpecialRenderer {
	
	private static final ResourceLocation texture = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");
	
	private ModelTurtleShell model;
	
	public RenderTurtleShell() {
		this.model = new ModelTurtleShell();
	}
	
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}

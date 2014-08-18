package net.probossgamers.turtlemod.client.render.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.probossgamers.turtlemod.client.model.ModelTurtleShell;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class RenderTurtleShell extends TileEntitySpecialRenderer
{
    public ResourceLocation texture = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");
    public ModelTurtleShell model = new ModelTurtleShell();

    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        bindTexture(texture);
        GL11.glPushMatrix();
        model.render();
        GL11.glPopMatrix();
        GL11.glPopMatrix();
    }
}
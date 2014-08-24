package net.probossgamers.turtlemod.client.render.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.probossgamers.turtlemod.client.model.block.ModelTurtleShell;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemTurtleShellRenderer implements IItemRenderer
{
    public ResourceLocation texture = new ResourceLocation("turtlemod:textures/mobs/Turtle.png");
    public ModelTurtleShell model = new ModelTurtleShell();
    public float scale = 0.0f;

    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return type != ItemRenderType.FIRST_PERSON_MAP;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return helper!= ItemRendererHelper.BLOCK_3D;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case ENTITY:
                setScale(0.5f);
                renderBlock(0f, 1.1f, -0.03125f);
                break;
            case EQUIPPED:
                setScale(1.2f);
                GL11.glRotatef(100f, 0f, 1f, 0f);
                GL11.glRotatef(-20f, 0f, 0f, 1f);
                renderBlock(-1.4f, 1.5f, 0f);
                break;
            case EQUIPPED_FIRST_PERSON:
                setScale(0.9f);
                GL11.glRotatef(180f, 0f, 1f, 0f);
                GL11.glRotatef(-20f, 0f, 0f, 1f);
                GL11.glRotatef(40f, 0f, 1f, 0f);
                renderBlock(0.2f, 2f, -0.9f);
                break;
            case INVENTORY:
                setScale(1.2f);
                renderBlock(0.0f, 1f, 0.0f);
                break;
        }
    }

    private void renderBlock(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(180f, 1f, 0f, 0f);
        Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
        model.render();
        GL11.glPopMatrix();
    }

    private void setScale(float s)
    {
        scale = s;
    }
}
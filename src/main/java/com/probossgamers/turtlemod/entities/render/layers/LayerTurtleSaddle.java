package com.probossgamers.turtlemod.entities.render.layers;

import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.models.ModelTurtle;
import com.probossgamers.turtlemod.entities.models.Saddle_Turtle;
import com.probossgamers.turtlemod.entities.render.RenderTurtle;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerTurtleSaddle implements LayerRenderer<EntityTurtle>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("turtlemod:textures/mobs/saddle_turtle.png");
    private final RenderTurtle turtleRenderer;
    private final ModelTurtle turtleModel = new ModelTurtle();

    public LayerTurtleSaddle(RenderTurtle turtleRendererIn)
    {
        this.turtleRenderer = turtleRendererIn;
    }

    public void doRenderLayer(EntityTurtle entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        if (entitylivingbaseIn.getSaddled())
        {
            this.turtleRenderer.bindTexture(TEXTURE);
            this.turtleModel.setModelAttributes(new Saddle_Turtle());
            this.turtleModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}

package net.probossgamers.turtlemod.client.model.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelTurtleShell extends ModelBase
{
    public ModelRenderer[] boxes = new ModelRenderer[2];

    public ModelTurtleShell()
    {
        textureWidth = 64;
        textureHeight = 64;

        boxes[0] = new ModelRenderer(this, 28, 8);
        boxes[0].addBox(-4f, -4f, -4f, 8, 8, 4);
        boxes[0].setRotationPoint(0f, 20f, 0f);
        setRotation(0, 1.570796f, 0f, 0f);
        boxes[1] = new ModelRenderer(this, 28, 21);
        boxes[1].addBox(-3f, 0f, -3f, 6, 1, 6);
        boxes[1].setRotationPoint(0f, 19f, 0f);
    }

    public void render()
    {
        for (ModelRenderer box : boxes) box.render(0.0625f);
    }

    public void setRotation(int boxIndex, float x, float y, float z)
    {
        boxes[boxIndex].rotateAngleX = x;
        boxes[boxIndex].rotateAngleY = y;
        boxes[boxIndex].rotateAngleZ = z;
    }
}
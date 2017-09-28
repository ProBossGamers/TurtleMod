/**
 * A GUI for a tile entity in the works
 * @Todo
 */
package com.probossgamers.turtlemod.gui;

import com.probossgamers.turtlemod.blocks.ModTileEntity;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.IInventory;

/**
 * For extra methods look here.
 * https://bedrockminer.jimdo.com/modding-tutorials/advanced-modding/drawing-a-gui-vanilla/
 */
public class GuiModTileEntity extends GuiContainer
{

    public GuiModTileEntity(IInventory playerInv, ModTileEntity te)
    {
        super(new ContainerModTileEntity(playerInv, te));

        this.xSize = 176;
        this.ySize = 166;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {

    }
}
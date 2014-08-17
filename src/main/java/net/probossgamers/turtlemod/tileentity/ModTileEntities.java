package net.probossgamers.turtlemod.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import net.probossgamers.turtlemod.ContentHandler;

public class ModTileEntities implements ContentHandler.IContentProvider
{
    public void init()
    {
        GameRegistry.registerTileEntity(TileEntityTurtleShell.class, "turtleShell");
    }
}

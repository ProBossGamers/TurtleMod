package net.probossgamers.turtlemod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.probossgamers.turtlemod.content.ContentHandler;
import net.probossgamers.turtlemod.tileentity.TileEntityTurtleShell;

public class ModTileEntities implements ContentHandler.IContentProvider
{
    public void init()
    {
        GameRegistry.registerTileEntity(TileEntityTurtleShell.class, "turtleShell");
    }
}

package net.probossgamers.turtlemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.probossgamers.turtlemod.content.ContentHandler;
import net.probossgamers.turtlemod.proxy.ServerProxy;

@Mod(modid = "turtlemod", name = "Turtle Mod", version = "Alpha 0.4")
public class TurtleMod
{
	@Mod.Instance("turtlemod")
    public static TurtleMod instance;
    @SidedProxy(clientSide = "net.probossgamers.turtlemod.proxy.ClientProxy", serverSide = "net.probossgamers.turtlemod.proxy.ServerProxy")
    public static ServerProxy proxy;

    public ContentHandler contentHandler = new ContentHandler();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        contentHandler.addContentProvider(ModTabs.class);
        contentHandler.addContentProvider(ModItems.class);
        contentHandler.addContentProvider(ModBlocks.class);
        contentHandler.addContentProvider(ModTileEntities.class);
        contentHandler.addContentProvider(ModEntities.class);

        contentHandler.init();
        proxy.init();
    }
}

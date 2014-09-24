package net.probossgamers.turtlemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.probossgamers.turtlemod.block.ModBlocks;
import net.probossgamers.turtlemod.common.CommonProxy;
import net.probossgamers.turtlemod.common.LogHelper;
import net.probossgamers.turtlemod.entity.ModEntities;
import net.probossgamers.turtlemod.item.ModItems;
import net.probossgamers.turtlemod.item.crafting.ModCrafting;
import net.probossgamers.turtlemod.tileentity.ModTileEntities;
import org.apache.logging.log4j.Level;

@Mod(modid = "turtlemod", name = "Turtle Mod", version = "Alpha 5.0")
public class TurtleMod
{
    @Mod.Instance("turtlemod")
    public static TurtleMod instance;
    @SidedProxy(clientSide = "net.probossgamers.turtlemod.client.ClientProxy", serverSide = "net.probossgamers.turtlemod.common.CommonProxy")
    public static CommonProxy proxy;

    public ContentHandler contentHandler = new ContentHandler();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        contentHandler.addContentProvider(ModItems.class);
        contentHandler.addContentProvider(ModBlocks.class);
        contentHandler.addContentProvider(ModTileEntities.class);
        contentHandler.addContentProvider(ModEntities.class);
        contentHandler.addContentProvider(ModCrafting.class);

        contentHandler.init();
        proxy.init();
        LogHelper.log(Level.INFO, "Pre Initialization complete");
    }
}

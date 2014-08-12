package net.probossgamers.turtlemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.probossgamers.turtlemod.entity.RegisterEntities;
import net.probossgamers.turtlemod.item.RegisterItems;
import net.probossgamers.turtlemod.server.ServerProxy;

@Mod(modid = TurtleMod.MODID, name = "Turtle Mod", version = TurtleMod.VERSION)
public class TurtleMod
{
	public static final String MODID = "turtlemod";
    public static final String VERSION = "Alpha 5.0";

    public static CreativeTabs turtleTab;

    @Mod.Instance(MODID)
    public static TurtleMod instance;

    @SidedProxy(clientSide = "net.probossgamers.turtlemod.client.ClientProxy", serverSide = "net.probossgamers.turtlemod.server.ServerProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenderers();
		
        turtleTab = new CreativeTabs("turtleTab") {
            @Override
            public Item getTabIconItem() {
                return RegisterItems.turtleShell;
            }
        };

        RegisterItems.itemInit();
        RegisterEntities.entityInit();
    }
}

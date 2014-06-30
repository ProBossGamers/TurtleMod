package net.probossgamers.TurtleMod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.probossgamers.TurtleMod.item.*;
import net.probossgamers.TurtleMod.entity.monster.EntityMineTurtle;
import net.probossgamers.TurtleMod.entity.passive.EntityTurtle;
import net.probossgamers.TurtleMod.entity.monster.EntityZombieTurtle;

import java.util.Random;

@Mod(
        modid = TurtleMod.MODID,
        name = "Turtle Mod",
        version = TurtleMod.VERSION
)

public class TurtleMod {

    public static final String MODID = "turtlemod";
    public static final String VERSION = "Alpha 5.0";

    public Item turtleLeather;
    public static Item turtleShell;
    public static Item turtleHelmet;
    public static Item turtleChestplate;
    public static Item turtleLeggings;
    public static Item turtleBoots;

    public static int turtleShellid;
    public static int turtleHelmetid;
    public static int turtleChestplateid;
    public static int turtleLeggingsid;
    public static int turtleBootsid;

    public static ItemArmor.ArmorMaterial turtleMaterial = EnumHelper.addArmorMaterial("Turtle", 5, new int[] { 1, 3, 2, 1 }, 15);

    @Mod.Instance(MODID)
    public static TurtleMod instance;

    @SidedProxy(clientSide = "net.probossgamers.TurtleMod.client.ClientProxy", serverSide = "net.probossgamers.TurtleMod.server.ServerProxy")
    public static net.probossgamers.TurtleMod.server.ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenderers();
        registerEntity(EntityTurtle.class, "turtle");
        registerEntity(EntityZombieTurtle.class, "zombieTurtle");
        registerEntity(EntityMineTurtle.class, "mineTurtle");
        turtleLeather = new ItemTurtleLeather().setUnlocalizedName("turtleLeather");
        turtleShell = new ItemTurtleShell(turtleMaterial, turtleShellid, 1).setTextureName("turtlemod:turtleShell").setUnlocalizedName("turtleShell");
        turtleHelmet = new ItemTurtleArmor(turtleMaterial, turtleHelmetid, 0).setTextureName("turtlemod:turtleHelmet").setUnlocalizedName("turtleHelmet");
        turtleChestplate = new ItemTurtleArmor(turtleMaterial, turtleChestplateid, 1).setTextureName("turtlemod:turtleChestplate").setUnlocalizedName("turtleChestplate");
        turtleLeggings = new ItemTurtleArmor(turtleMaterial, turtleLeggingsid, 2).setTextureName("turtlemod:turtleLeggings").setUnlocalizedName("turtleLeggings");
        turtleBoots = new ItemTurtleArmor(turtleMaterial, turtleBootsid, 3).setTextureName("turtlemod:turtleBoots").setUnlocalizedName("turtleBoots");
        GameRegistry.registerItem(turtleLeather, "Turtle Leather");
        GameRegistry.registerItem(turtleShell, "Turtle Shell");
        GameRegistry.registerItem(turtleHelmet, "Turtle Helmet");
        GameRegistry.registerItem(turtleChestplate, "Turtle Chestplate");
        GameRegistry.registerItem(turtleLeggings, "Turtle Leggings");
        GameRegistry.registerItem(turtleBoots, "Turtle Boots");
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static void registerEntity(Class entityClass, String name)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
}

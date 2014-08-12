package net.probossgamers.turtlemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;
import net.probossgamers.turtlemod.entity.monster.EntityMineTurtle;
import net.probossgamers.turtlemod.entity.monster.EntityZombieTurtle;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;
import net.probossgamers.turtlemod.item.ItemTurtleArmor;
import net.probossgamers.turtlemod.item.ItemTurtleShell;
import net.probossgamers.turtlemod.server.ServerProxy;

@Mod(modid = TurtleMod.MODID, name = "Turtle Mod", version = TurtleMod.VERSION)
public class TurtleMod
{
	public static final String MODID = "turtlemod";
    public static final String VERSION = "Alpha 5.0";

    public static CreativeTabs turtleTab;

    public Item turtleLeather;
    public static Item turtleShell;
    public static Item turtleHelmet;
    public static Item turtleChestplate;
    public static Item turtleLeggings;
    public static Item turtleBoots;

    public ItemArmor.ArmorMaterial turtleMaterial = EnumHelper.addArmorMaterial("Turtle", 5, new int[]{1, 3, 2, 1}, 15);

    @Mod.Instance(MODID)
    public static TurtleMod instance;

    @SidedProxy(clientSide = "net.probossgamers.turtlemod.client.ClientProxy", serverSide = "net.probossgamers.turtlemod.server.ServerProxy")
    public static ServerProxy proxy;

    public static void registerEntity(Class<? extends EntityLiving> entityClass, String name, int par1, int par2, int par3, int par4, int par5, EnumCreatureType CreatureType) {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID, par1, par2);
        EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, par3, par4, par5, CreatureType, 
			BiomeGenBase.beach,
			BiomeGenBase.frozenRiver,
			BiomeGenBase.iceMountains,
			BiomeGenBase.icePlains,
			BiomeGenBase.plains,
			BiomeGenBase.river,
			BiomeGenBase.swampland,
			BiomeGenBase.taiga,
			BiomeGenBase.taigaHills
		);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.registerRenderers();
		
        turtleTab = new CreativeTabs("turtleTab") {
            @Override
            public Item getTabIconItem() {
                return turtleShell;
            }
        };
		
        registerEntity(EntityTurtle.class, "turtle", 0x1e8100, 0x7d3900, 10, 2, 4, EnumCreatureType.creature);
        registerEntity(EntityZombieTurtle.class, "zombieTurtle", 0x008344, 0x823F02, 10, 2, 4, EnumCreatureType.monster);
        registerEntity(EntityMineTurtle.class, "mineTurtle", 0x1e8100, 0xef0000, 10, 2, 4, EnumCreatureType.monster);

        turtleLeather = new Item().setUnlocalizedName("turtleLeather").setTextureName("turtlemod:turtleLeather").setCreativeTab(turtleTab);
        turtleShell = new ItemTurtleShell(turtleMaterial, 0, 1).setTextureName("turtlemod:turtleShell").setUnlocalizedName("turtleShell");
        turtleHelmet = new ItemTurtleArmor(turtleMaterial, 0, 0).setTextureName("turtlemod:turtleHelmet").setUnlocalizedName("turtleHelmet");
        turtleChestplate = new ItemTurtleArmor(turtleMaterial, 0, 1).setTextureName("turtlemod:turtleChestplate").setUnlocalizedName("turtleChestplate");
        turtleLeggings = new ItemTurtleArmor(turtleMaterial, 0, 2).setTextureName("turtlemod:turtleLeggings").setUnlocalizedName("turtleLeggings");
        turtleBoots = new ItemTurtleArmor(turtleMaterial, 0, 3).setTextureName("turtlemod:turtleBoots").setUnlocalizedName("turtleBoots");
        GameRegistry.registerItem(turtleLeather, "Turtle Leather");
        GameRegistry.registerItem(turtleShell, "Turtle Shell");
        GameRegistry.registerItem(turtleHelmet, "Turtle Helmet");
        GameRegistry.registerItem(turtleChestplate, "Turtle Chestplate");
        GameRegistry.registerItem(turtleLeggings, "Turtle Leggings");
        GameRegistry.registerItem(turtleBoots, "Turtle Boots");
    }
}

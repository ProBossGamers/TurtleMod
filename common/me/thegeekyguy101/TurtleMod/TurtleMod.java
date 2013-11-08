package me.thegeekyguy101.TurtleMod;

import me.thegeekyguy101.TurtleMod.entity.customEntityList;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityDonatello;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityLeonardo;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityMichelangelo;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityMineTurtle;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityRaphael;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityZombieTurtle;
import me.thegeekyguy101.TurtleMod.entity.passive.EntityHelloGuy;
import me.thegeekyguy101.TurtleMod.entity.passive.EntityTurtle;
import me.thegeekyguy101.TurtleMod.item.ItemTMNTrecord;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleBoots;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleChestplate;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleHelmet;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleLeather;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleLeggings;
import me.thegeekyguy101.TurtleMod.item.ItemTurtleShell;
import me.thegeekyguy101.TurtleMod.item.customSpawnEgg;
import me.thegeekyguy101.TurtleMod.server.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraftforge.common.Property;

@Mod(modid = "DJCTM", name = "DeathJustys Crazy Turtle Mod", version = "Alpha 4.2")
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class TurtleMod {

	// Proxy stuff
	@SidedProxy(clientSide = "me.thegeekyguy101.TurtleMod.client.ClientProxy", serverSide = "me.thegeekyguy101.TurtleMod.server.ServerProxy")
	public static ServerProxy proxy;

	// Items
	public static Item Turtleleather;
	public static int turtleLeatherID;
	public static Item turtleShell;
	public static int turtleShellID;
	public static Block Shell;

	public static Item turtleHelmet;
	public static int turtleHelmetID;
	public static Item turtleChestplate;
	public static int turtleChestplateID;
	public static Item turtleLeggings;
	public static int turtleLeggingsID;
	public static Item turtleBoots;
	public static int turtleBootsID;

	public static Item customSpawnEgg;
	public static int customSpawnEggID;

	public static Item recordTMNT80;
	public static int recordTMNT80ID;
	public static Item recordTMNT2003;
	public static int recordTMNT2003ID;
	public static Item recordTMNT2012;
	public static int recordTMNT2012ID;
	public static Item recordMineturtle;
	public static int recordMineturtleID;
	public static int EntityID;

	public static EnumArmorMaterial turtleArmor = EnumHelper.addArmorMaterial("Turtle", 5, new int[] { 1, 3, 2, 1 }, 15);

	// creative tabs
	public static CreativeTabs turtleTab;

	// Mob stuff
	static int startEntityId = EntityID;

	public static int getUniqueEntityId() {
		do {
			startEntityId++;
		} while (EntityList.getStringFromID(startEntityId) != null);
		return startEntityId++;
	}

	public static void registerEntityEgg(Class<? extends Entity> entity,
			int primaryColor, int secondaryColor) {
		int id = getUniqueEntityId();
		EntityList.IDtoClassMapping.put(id, entity);
		EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor,
				secondaryColor));
	}

	@EventHandler
	public void Load(FMLPreInitializationEvent Event) {
		
		//config
		Configuration config = new Configuration(Event.getSuggestedConfigurationFile());
		config.load();
		
		//item configs
		int turtleLeatherID = config.getItem("turtle Leather", 3841).getInt();
		int turtleShellID = config.getItem("Turtle Shell", 3842).getInt();
		int turtleHelmetID = config.getItem("Turtle Helmet", 3843).getInt();
		int turtleChestplateID = config.getItem("Turtle Chestplate", 3844).getInt();
		int turtleLeggingsID = config.getItem("Turtle Leggings", 3845).getInt();
		int turtleBootsID = config.getItem("Turtle Boots", 3846).getInt();
		int recordTMNT80ID = config.getItem("TMNT 80 record", 3847).getInt();
		int recordTMNT2003ID = config.getItem("TMNT 2003 record", 3848).getInt();
		int recordTMNT2012ID = config.getItem("TMNT 2012 record", 3849).getInt();
		int recordMineturtleID = config.getItem("Mineturtle record", 3850).getInt();
		int customSpawnEggID = config.getItem("Custom Spawn Egg ID", 3851).getInt();
		int EntityID = config.get(Configuration.CATEGORY_GENERAL, "Start Entity ID's", 350).getInt();
		
		config.save();
		
		// more Proxy stuff
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		proxy.registerSound();
		
		// Armor stuff
		int renderTurtleArmor = proxy.addArmor("turtle");
		int renderShell = proxy.addArmor("shell");

		// custom creative tab
		turtleTab = new CreativeTabs("turtleTab") {
			public ItemStack getIconItemStack() {
				return new ItemStack(turtleShell, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("itemGroup.turtleTab", "en_US","DeathJusty's Crazy Turtle Mod");
		
		// Turtle Leather
		Turtleleather = new ItemTurtleLeather(turtleLeatherID).setUnlocalizedName("turtlemod:turtleLeather");
		LanguageRegistry.addName(Turtleleather, "Turtle Leather");
		
		// Turtle Shell		
		turtleShell = new ItemTurtleShell(turtleShellID, turtleArmor, renderShell, 1).setUnlocalizedName("turtleShell").setCreativeTab(this.turtleTab);
		GameRegistry.registerItem(turtleShell, "turtleShell");
		LanguageRegistry.addName(turtleShell, "Turtle Shell");	
		
		// Armor
		turtleHelmet = new ItemTurtleHelmet(turtleHelmetID, turtleArmor, renderTurtleArmor, 0).setUnlocalizedName("turtleHelmet").setCreativeTab(this.turtleTab);
		turtleChestplate = new ItemTurtleChestplate(turtleChestplateID, turtleArmor, renderTurtleArmor, 1).setUnlocalizedName("turtleChestplate").setCreativeTab(this.turtleTab);
		turtleLeggings = new ItemTurtleLeggings(turtleLeggingsID, turtleArmor, renderTurtleArmor, 2).setUnlocalizedName("turtleLeggings").setCreativeTab(this.turtleTab);
		turtleBoots = new ItemTurtleBoots(turtleBootsID, turtleArmor, renderTurtleArmor,3).setUnlocalizedName("turtleBoots").setCreativeTab(this.turtleTab);
		
		GameRegistry.registerItem(turtleHelmet, "turtleHelmet");
		GameRegistry.registerItem(turtleChestplate, "turtleChestplate");
		GameRegistry.registerItem(turtleLeggings, "turtleLeggings");
		GameRegistry.registerItem(turtleBoots, "turtleBoots");
		
		LanguageRegistry.addName(turtleHelmet, "Turtle Helmet");
		LanguageRegistry.addName(turtleChestplate, "Turtle Chestplate");
		LanguageRegistry.addName(turtleLeggings, "Turtle Leggings");
		LanguageRegistry.addName(turtleBoots, "Turtle Boots");
		
		GameRegistry.addRecipe(new ItemStack(turtleHelmet), new Object[] {
				"TST", "T T", 'T', Turtleleather, 'S', turtleShell });
		GameRegistry.addRecipe(new ItemStack(turtleChestplate), new Object[] {
				"T T", "TST", "TTT", 'T', Turtleleather, 'S', turtleShell });
		GameRegistry.addRecipe(new ItemStack(turtleLeggings), new Object[] {
				"TST", "T T", "T T", 'T', Turtleleather, 'S', turtleShell });
		GameRegistry.addRecipe(new ItemStack(turtleBoots), new Object[] {
				"T T", "T T", 'T', Turtleleather });
				

		recordTMNT80 = new ItemTMNTrecord(recordTMNT80ID, "turtlemod:TMNT80", "TMNT80").setUnlocalizedName("TMNT80").setTextureName("turtlemod:TMNT80");
		recordTMNT2003 = new ItemTMNTrecord(recordTMNT2003ID, "turtlemod:TMNT2003","TMNT2003").setUnlocalizedName("TMNT2003").setTextureName("turtlemod:TMNT2003");
		recordTMNT2012 = new ItemTMNTrecord(recordTMNT2012ID, "turtlemod:TMNT2012","TMNT2012").setUnlocalizedName("TMNT2012").setTextureName("turtlemod:TMNT2012");
		recordMineturtle = new ItemTMNTrecord(recordMineturtleID, "turtlemod:mineturtle","mineturtle").setUnlocalizedName("mineturtle").setTextureName("turtlemod:mineturtle");

		LanguageRegistry.addName(recordTMNT80, "TMNT80");
		LanguageRegistry.addName(recordTMNT2003, "TMNT2003");
		LanguageRegistry.addName(recordTMNT2012, "TMNT2012");
		LanguageRegistry.addName(recordMineturtle, "Mine Turtle");

		// Custom spawn egg for custom creative tab
		customSpawnEgg = new customSpawnEgg(customSpawnEggID).setUnlocalizedName("customSpawnEgg").setTextureName("turtlemod:customSpawnEgg").setCreativeTab(this.turtleTab);
		LanguageRegistry.addName(customSpawnEgg, "Spawn");

		EntityRegistry.findGlobalUniqueEntityId();

		// Turtle
		EntityRegistry.registerGlobalEntityID(EntityTurtle.class, "Turtle", 1);
		EntityRegistry.registerGlobalEntityID(EntityZombieTurtle.class,"ZombieTurtle", 2);
		EntityRegistry.registerGlobalEntityID(EntityMineTurtle.class,"MineTurtle", 3);
		EntityRegistry.registerGlobalEntityID(EntityHelloGuy.class, "HelloGuy", 4);
		EntityRegistry.registerGlobalEntityID(EntityLeonardo.class, "Leonardo", 5);
		EntityRegistry.registerGlobalEntityID(EntityRaphael.class, "Raphael", 6);
		EntityRegistry.registerGlobalEntityID(EntityDonatello.class, "Donatello", 7);
		EntityRegistry.registerGlobalEntityID(EntityMichelangelo.class, "Michelangelo", 8);
		
		EntityRegistry.addSpawn(EntityTurtle.class, 10, 2, 4,
				EnumCreatureType.creature, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityZombieTurtle.class, 10, 2, 4,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityMineTurtle.class, 10, 2, 4,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityHelloGuy.class, 10, 2, 4,
				EnumCreatureType.creature, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityLeonardo.class, 10, 1, 1,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityRaphael.class, 10, 1, 1,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityDonatello.class, 10, 1, 1,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		EntityRegistry.addSpawn(EntityMichelangelo.class, 10, 1, 1,
				EnumCreatureType.monster, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
		
		// registerEntityEgg(EntityTurtle.class, 0x6F9DD1, 0x7AD16F);
		
		LanguageRegistry.instance().addStringLocalization("entity.Turtle.name", "Turtle");
		LanguageRegistry.instance().addStringLocalization("entity.ZombieTurtle.name", "Zombie Turtle");
		LanguageRegistry.instance().addStringLocalization("entity.MineTurtle.name", "Mine Turtle");
		LanguageRegistry.instance().addStringLocalization("entity.HelloGuy.name", "Hello Guy");
		LanguageRegistry.instance().addStringLocalization("entity.Leonardo.name", "Leonardo");
		LanguageRegistry.instance().addStringLocalization("entity.Raphael.name", "Raphael");
		LanguageRegistry.instance().addStringLocalization("entity.Donatello.name", "Donatello");
		LanguageRegistry.instance().addStringLocalization("entity.Michelangelo.name", "Michelangelo");

	}
}

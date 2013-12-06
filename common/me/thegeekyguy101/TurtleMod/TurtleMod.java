package me.thegeekyguy101.TurtleMod;

import me.thegeekyguy101.TurtleMod.block.BlockTurtleShell;
import me.thegeekyguy101.TurtleMod.client.renderer.item.ItemRendererTurtleShell;
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
import me.thegeekyguy101.TurtleMod.tileentity.TileEntityTurtleShell;
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
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(
		modid = "DJCTM",
		name = "DeathJustys Crazy Turtle Mod",
		version = "Alpha 4.3"
	)
@NetworkMod(
		clientSideRequired = true,
		serverSideRequired = false
	)
public class TurtleMod {

	@SidedProxy(
			clientSide = "me.thegeekyguy101.TurtleMod.client.ClientProxy",
			serverSide = "me.thegeekyguy101.TurtleMod.server.ServerProxy"
		)
	public static ServerProxy proxy;
	
	public static Block turtleShellBlock;
	
	public static Item turtleLeather;
	public static Item turtleShellItem;
	public static Item turtleHelmet;
	public static Item turtleChestplate;
	public static Item turtleLeggings;
	public static Item turtleBoots;
	public static Item customSpawnEgg;
	public static Item recordTMNT80;
	public static Item recordTMNT2003;
	public static Item recordTMNT2012;
	public static Item recordMineturtle;
	
	public static int turtleShellBlockID;
	
	public static int turtleLeatherID;
	public static int turtleShellItemID;
	public static int turtleHelmetID;
	public static int turtleChestplateID;
	public static int turtleLeggingsID;
	public static int turtleBootsID;
	public static int customSpawnEggID;
	public static int recordTMNT80ID;
	public static int recordTMNT2003ID;
	public static int recordTMNT2012ID;
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
		
		// config
		Configuration config = new Configuration(Event.getSuggestedConfigurationFile());
		config.load();
		
		int startid = 3840;
		
		// item configs
		int turtleLeatherID = config.getItem("turtle Leather", startid++).getInt();
		int turtleShellBlockID = config.getItem("Turtle Shell Block", startid++).getInt();
		int turtleShellItemID = config.getItem("Turtle Shell Item", startid++).getInt();
		int turtleHelmetID = config.getItem("Turtle Helmet", startid++).getInt();
		int turtleChestplateID = config.getItem("Turtle Chestplate", startid++).getInt();
		int turtleLeggingsID = config.getItem("Turtle Leggings", startid++).getInt();
		int turtleBootsID = config.getItem("Turtle Boots", startid++).getInt();
		int recordTMNT80ID = config.getItem("TMNT 80 record", startid++).getInt();
		int recordTMNT2003ID = config.getItem("TMNT 2003 record", startid++).getInt();
		int recordTMNT2012ID = config.getItem("TMNT 2012 record", startid++).getInt();
		int recordMineturtleID = config.getItem("Mineturtle record", startid++).getInt();
		int customSpawnEggID = config.getItem("Custom Spawn Egg ID", startid++).getInt();
		
		int EntityID = config.get(Configuration.CATEGORY_GENERAL, "Start Entity ID's", 350).getInt();
		
		config.save();
		
		// Armor stuff
		int renderTurtleArmor = proxy.addArmor("turtle");
		int renderShell = proxy.addArmor("shell");

		// custom creative tab
		turtleTab = new CreativeTabs("turtleTab") {
			public ItemStack getIconItemStack() {
				return new ItemStack(turtleShellItem, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("itemGroup.turtleTab", "en_US","DeathJusty's Crazy Turtle Mod");
		
		// Turtle Leather
		turtleLeather = new ItemTurtleLeather(turtleLeatherID).setUnlocalizedName("turtleLeather");
		registerItem(turtleLeather, "Turtle Leather");
		
		// Turtle Shell Block
		turtleShellBlock = new BlockTurtleShell(turtleShellBlockID).setUnlocalizedName("turtleShellBlock");
		registerBlock(turtleShellBlock, "Turtle Shell");
		GameRegistry.registerTileEntity(TileEntityTurtleShell.class, "Turtle Shell");
		
		//Turtle Shell Item
		turtleShellItem = new ItemTurtleShell(turtleShellItemID, turtleArmor, renderShell, 1).setUnlocalizedName("turtleShellItem").setCreativeTab(this.turtleTab);
		registerItem(turtleShellItem, "Wearable Turtle Shell");
		GameRegistry.addRecipe(new ItemStack(turtleShellItem), new Object[] {
			"STS", 'S', Item.silk, 'T', turtleShellBlock });
		
		// Turtle Helmet
		turtleHelmet = new ItemTurtleHelmet(turtleHelmetID, turtleArmor, renderTurtleArmor, 0).setUnlocalizedName("turtleHelmet").setCreativeTab(this.turtleTab);
		registerItem(turtleHelmet, "Turtle Helmet");
		GameRegistry.addRecipe(new ItemStack(turtleHelmet), new Object[] {
			"TST", "T T", 'T', turtleLeather, 'S', turtleShellBlock });
		
		// Turtle Chestplate
		turtleChestplate = new ItemTurtleChestplate(turtleChestplateID, turtleArmor, renderTurtleArmor, 1).setUnlocalizedName("turtleChestplate").setCreativeTab(this.turtleTab);
		registerItem(turtleChestplate, "Turtle Chestplate");
		GameRegistry.addRecipe(new ItemStack(turtleChestplate), new Object[] {
			"T T", "TST", "TTT", 'T', turtleLeather, 'S', turtleShellBlock });
		
		// Turtle Leggings
		turtleLeggings = new ItemTurtleLeggings(turtleLeggingsID, turtleArmor, renderTurtleArmor, 2).setUnlocalizedName("turtleLeggings").setCreativeTab(this.turtleTab);
		registerItem(turtleLeggings, "Turtle Leggings");
		GameRegistry.addRecipe(new ItemStack(turtleLeggings), new Object[] {
			"TST", "T T", "T T", 'T', turtleLeather, 'S', turtleShellBlock });
		
		// Turtle Boots
		turtleBoots = new ItemTurtleBoots(turtleBootsID, turtleArmor, renderTurtleArmor,3).setUnlocalizedName("turtleBoots").setCreativeTab(this.turtleTab);
		registerItem(turtleBoots, "Turtle Boots");
		GameRegistry.addRecipe(new ItemStack(turtleBoots), new Object[] {
				"T T", "T T", 'T', turtleLeather });
		
		// Record TMNT80
		recordTMNT80 = new ItemTMNTrecord(recordTMNT80ID, "turtlemod:TMNT80", "TMNT80").setUnlocalizedName("TMNT80").setTextureName("turtlemod:TMNT80");
		registerItem(recordTMNT80, "TMNT80");
		
		// Record TMNT2003
		recordTMNT2003 = new ItemTMNTrecord(recordTMNT2003ID, "turtlemod:TMNT2003","TMNT2003").setUnlocalizedName("TMNT2003").setTextureName("turtlemod:TMNT2003");
		registerItem(recordTMNT2003, "TMNT2003");
		
		// Record TMNT2012
		recordTMNT2012 = new ItemTMNTrecord(recordTMNT2012ID, "turtlemod:TMNT2012","TMNT2012").setUnlocalizedName("TMNT2012").setTextureName("turtlemod:TMNT2012");
		registerItem(recordTMNT2012, "TMNT2012");
		
		// Record Mineturtle
		recordMineturtle = new ItemTMNTrecord(recordMineturtleID, "turtlemod:mineturtle","mineturtle").setUnlocalizedName("mineturtle").setTextureName("turtlemod:mineturtle");
		registerItem(recordMineturtle, "Mine Turtle");

		// Custom spawn egg for custom creative tab
		customSpawnEgg = new customSpawnEgg(customSpawnEggID).setUnlocalizedName("customSpawnEgg").setTextureName("turtlemod:customSpawnEgg").setCreativeTab(this.turtleTab);
		LanguageRegistry.addName(customSpawnEgg, "Spawn");

		EntityRegistry.findGlobalUniqueEntityId();

		registerEntity(EntityTurtle.class, "Turtle", 1, "Turtle");
		registerEntity(EntityZombieTurtle.class, "ZombieTurtle", 2, "Zombie Turtle");
		registerEntity(EntityMineTurtle.class, "MineTurtle", 3, "Mine Turtle");
		registerEntity(EntityHelloGuy.class, "HelloGuy", 4, "Hello Guy");
		registerEntity(EntityLeonardo.class, "Leonardo", 5, "Leonardo");
		registerEntity(EntityRaphael.class, "Raphael", 6, "Raphael");
		registerEntity(EntityDonatello.class, "Donatello", 7, "Donatello");
		registerEntity(EntityMichelangelo.class, "Michelangelo", 8, "Michelangelo");
		
		addSpawn(EntityTurtle.class, 10, 2, 4, EnumCreatureType.creature);
		addSpawn(EntityZombieTurtle.class, 10, 2, 4, EnumCreatureType.monster);
		addSpawn(EntityMineTurtle.class, 10, 2, 4, EnumCreatureType.monster);
		addSpawn(EntityHelloGuy.class, 10, 2, 4, EnumCreatureType.creature);
		addSpawn(EntityLeonardo.class, 10, 1, 1, EnumCreatureType.monster);
		addSpawn(EntityRaphael.class, 10, 1, 1, EnumCreatureType.monster);
		addSpawn(EntityDonatello.class, 10, 1, 1, EnumCreatureType.monster);
		addSpawn(EntityMichelangelo.class, 10, 1, 1, EnumCreatureType.monster);
		
		// more Proxy stuff
		proxy.registerRenderThings();
		proxy.registerServerTickHandler();
		proxy.registerSound();
	}
	public static void registerItem(Item par1, String par2) {
		GameRegistry.registerItem(par1, par1.toString());
		LanguageRegistry.addName(par1, par2);
	}
	
	public static void registerBlock(Block par1, String par2) {
		GameRegistry.registerBlock(par1, par1.toString());
		LanguageRegistry.addName(par1, par2);
	}
	
	public static void registerEntity(Class par1, String par2, int par3, String par4) {
		EntityRegistry.registerGlobalEntityID(par1, par2.toString(), par3);
		LanguageRegistry.instance().addStringLocalization("entity." + par2 + ".name", par4);
	}
	
	public static void addSpawn(Class par1, int par2, int par3, int par4, EnumCreatureType par5) {
		EntityRegistry.addSpawn(par1, par2, par3, par4, par5, BiomeGenBase.beach,
				BiomeGenBase.frozenRiver, BiomeGenBase.iceMountains,
				BiomeGenBase.icePlains, BiomeGenBase.plains,
				BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga,
				BiomeGenBase.taigaHills);
	}
}

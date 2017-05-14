package com.a2937.turtlemod;

import java.util.List;
import java.util.logging.Logger;

import com.a2937.turtlemod.blocks.ModBlocks;
import com.a2937.turtlemod.crafting.ModCrafting;
import com.a2937.turtlemod.creativetabs.TurtleTab;
import com.a2937.turtlemod.entities.EntityKunai;
import com.a2937.turtlemod.entities.EntityTurtle;
import com.a2937.turtlemod.entities.ModEntities;
import com.a2937.turtlemod.items.ModItems;
import com.a2937.turtlemod.localization.EnglishWriter;
import com.a2937.turtlemod.localization.FrenchWriter;
import com.a2937.turtlemod.localization.ItalianWriter;
import com.a2937.turtlemod.localization.PortugueseWriter;
import com.a2937.turtlemod.localization.RussianWriter;
import com.a2937.turtlemod.localization.SpanishWriter;
import com.a2937.turtlemod.packets.PacketDispatcher;
import com.a2937.turtlemod.proxies.ServerProxy;
import com.google.common.collect.Lists;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModInfo.MODID, name = ModInfo.MODNAME,version = ModInfo.VERSION)
public class TurtleMain
{
	
	@SidedProxy(clientSide=ModInfo.CLIENT_PROXY, serverSide=ModInfo.SERVER_PROXY)
	public static ServerProxy proxy;
	public static Logger logger = Logger.getLogger(ModInfo.MODNAME);
    
	
	
	public static List<Class<? extends Entity>> entitiesToRegister = Lists.newArrayList();	
	
	public static List<Class<? extends TileEntity>> tileEntitiesToRegister=Lists.newArrayList();
	// They still need to be manually added into the ClientProxy. 
	// There are too many variables to account for. 
	//

	
    //public static HashMap<String, Integer> playersWithPets = new HashMap<String, Integer>();	
    //public static final PetAchievements pa = new PetAchievements();
    
	
	//public static int DimID = DimensionManager.getNextFreeDimId();
	
	public static CreativeTabs tabCustom = new TurtleTab();
    
    @Instance
    public static TurtleMain instance = new TurtleMain();
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	
		 
    	entitiesToRegister.add(EntityKunai.class);
    	entitiesToRegister.add(EntityTurtle.class);
		 //entitiesToRegister.add(EntityCustomFireball.class);
		  	
   	 	//tileEntitiesToRegister.add(ModTileEntity.class);
   	 	
   	 	ModEntities.createEntity(entitiesToRegister);
   	 	//ModTileEntities.createTileEntities(tileEntitiesToRegister);
    	 	  
    	 	ModItems.createItems();
    	
    	 	ModBlocks.createBlocks();
    	 	
    	 	
    	 	//ModBlocks.createPlants();
    	 	
    	 	//ModItems.createSeeds();
    	 	
    	 	//ModBlocks.linkPlants();
    	 	
    	 	
    	 //	MinecraftForge.addGrassSeed(new ItemStack(ModItems.cornSeeds), 10);
    	 	
    	 	
		 if(ModInfo.isDevVersion) {
			 EnglishWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 
			 
			// EnglishWriter.writeFileForCrop(ModBlocks.crops);
			 
			 FrenchWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 SpanishWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 ItalianWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 RussianWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 PortugueseWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
		 }
		 
		proxy.render();
		proxy.renderEntities();
		PacketDispatcher.registerPackets(); 
		
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	
    	//MinecraftForge.EVENT_BUS.register(new MobDropEventHandler());
    	ModCrafting.initCrafting();
    	SoundHandler.registerSounds();
    	//GameRegistry.registerWorldGenerator(new TutorialWorldGenerator(), 0);
   
    	
    	 	
    	 	//DimensionManager.registerProviderType(DimID, WorldProviderTutorial.class, true);
    	 	//DimensionManager.registerDimension(DimID, DimID);
    	 	
    	 	
    	//EntityRegistry.registerGlobalEntityID(EntityBuddy.class, "TinyClone", EntityRegistry.findGlobalUniqueEntityId());
    	//NetworkRegistry.INSTANCE.registerGuiHandler(this, new ModGuiHandler());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    }
}

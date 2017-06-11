package com.probossgamers.turtlemod;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.crafting.ModCrafting;
import com.probossgamers.turtlemod.creativetabs.TurtleTab;
import com.probossgamers.turtlemod.entities.EntityHelloGuy;
import com.probossgamers.turtlemod.entities.EntityKunai;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.ModEntities;
import com.probossgamers.turtlemod.entities.monster.*;
import com.probossgamers.turtlemod.items.ModItems;
import com.probossgamers.turtlemod.localization.EnglishWriter;
import com.probossgamers.turtlemod.packets.PacketDispatcher;
import com.probossgamers.turtlemod.proxies.ServerProxy;
import com.google.common.collect.Lists;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
    
	
	
	private static List<Class<? extends Entity>> entitiesToRegister = Lists.newArrayList();
	
	public static List<Class<? extends TileEntity>> tileEntitiesToRegister=Lists.newArrayList();
	// They still need to be manually added into the ClientProxy. 
	// There are too many variables to account for. 
	//

	
    //public static HashMap<String, Integer> playersWithPets = new HashMap<String, Integer>();	
    //public static final PetAchievements pa = new PetAchievements();
    
	
	//public static int DimID = DimensionManager.getNextFreeDimId();
	
	public static CreativeTabs tabCustom = new TurtleTab();


	private static HashMap<Class<?extends EntityLivingBase>,Integer> entPrimaryColor = new HashMap<Class<?extends EntityLivingBase>,Integer>();
	private static HashMap<Class<?extends EntityLivingBase>,Integer> entSecondaryColor = new HashMap<Class<?extends EntityLivingBase>,Integer>();

    @Instance
    public static TurtleMain instance = new TurtleMain();
    

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {


    	entitiesToRegister.add(EntityKunai.class);



    	entitiesToRegister.add(EntityTurtle.class);
		entPrimaryColor.put(EntityTurtle.class, 1999104);
		entSecondaryColor.put(EntityTurtle.class, 8206592);

    	entitiesToRegister.add(EntityMineTurtle.class);
		entPrimaryColor.put(EntityMineTurtle.class, 1999104);
		entSecondaryColor.put(EntityMineTurtle.class, 15663104);


		entitiesToRegister.add(EntityZombieTurtle.class);
		entPrimaryColor.put(EntityZombieTurtle.class, 33604);
		entSecondaryColor.put(EntityZombieTurtle.class, 8535810);

		entitiesToRegister.add(EntityHelloGuy.class);
		entPrimaryColor.put(EntityHelloGuy.class, 16777215);
		entSecondaryColor.put(EntityHelloGuy.class, 16318464);

		entitiesToRegister.add(EntityLeonardo.class);
		entPrimaryColor.put(EntityLeonardo.class, 1999104);
		entSecondaryColor.put(EntityLeonardo.class, 11775);

		entitiesToRegister.add(EntityDonatello.class);
		entPrimaryColor.put(EntityDonatello.class, 1999104);
		entSecondaryColor.put(EntityDonatello.class, 6553735);

        entitiesToRegister.add(EntityRaphael.class);
        entPrimaryColor.put(EntityRaphael.class, 1999104);
        entSecondaryColor.put(EntityRaphael.class, 15466752);

        entitiesToRegister.add(EntityMichelangelo.class);
        entPrimaryColor.put(EntityMichelangelo.class, 1999104);
        entSecondaryColor.put(EntityMichelangelo.class, 16738560);

        entitiesToRegister.add(EntityFootNinja.class);
        entPrimaryColor.put(EntityFootNinja.class, 0);
        entSecondaryColor.put(EntityFootNinja.class, 5066072);
		 //entitiesToRegister.add(EntityCustomFireball.class);
		  	
   	 	//tileEntitiesToRegister.add(ModTileEntity.class);
   	 	
   	 	ModEntities.createEntity(entitiesToRegister,entPrimaryColor, entSecondaryColor);
   	 	//ModTileEntities.createTileEntities(tileEntitiesToRegister);
    	 	  
    	 	ModItems.createItems();
    	
    	 	ModBlocks.createBlocks();
    	 	
    	 	
    	 	//ModBlocks.createPlants();
    	 	
    	 	//ModItems.createSeeds();
    	 	
    	 	//ModBlocks.linkPlants();
    	 	//
    	 	
    	 //	MinecraftForge.addGrassSeed(new ItemStack(ModItems.cornSeeds), 10);
    	 	
    	 	
		 if(ModInfo.isDevVersion) {
			 EnglishWriter.writeFile(ModBlocks.blocks, ModItems.items, entitiesToRegister);
			 
			 
			// EnglishWriter.writeFileForCrop(ModBlocks.crops);
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

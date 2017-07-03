package com.probossgamers.turtlemod.items;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	
	
	public static List<Item> items = Lists.newArrayList();
	
	  public static Item turtleLeather;
	  
	  
	  
	  public static Item creamQuartzPiece;
		public static Item turtleHelmet,turtleChestplate,turtleLeggings,turtleBoots;
		

	    private static ArmorMaterial turtleArmor = EnumHelper.addArmorMaterial("Turtle", "turtlemod:turtle", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);

	    //Fun fact: Damage is 4 by default. It adds the tool material to it.
	    public static ToolMaterial Kunai = EnumHelper.addToolMaterial("Kunai", 2, 260, 6.5f, -2f, 18);

	    public static ToolMaterial LeoTool = EnumHelper.addToolMaterial("LeoTool", 2, 260, 6.5f, 2.5f, 18);

        public static ToolMaterial MikeTool = EnumHelper.addToolMaterial("MikeTool", 2, 260, 6.5f, 2.5f, 18);

        public static ToolMaterial RaphTool = EnumHelper.addToolMaterial("RaphTool", 2, 260, 6.5f, 2.5f, 18);

    private static ToolMaterial DonTool = EnumHelper.addToolMaterial("DonTool", 2, 260, 6.5f, 2.5f, 18);
    //public static ToolMaterial TUTORIAL = EnumHelper.addToolMaterial("TUTORIAL", harvestLevel, durability, miningSpeed, damageVsEntities, enchantability);
	    
		public static Item kunai;

		public static Item leosKatana;
	    
	    public static Item mikesChucks;

	    public static Item raphsSai;

	    public static Item donsStick;
	    
	    public static Item pizzaSlice;

	    public static Item smokeBall;
		
		public static void createSeeds() {
		 	
	    	/*
	    	GameRegistry.registerItem(cornSeeds= new ItemCustomSeeds("cornSeed", ModBlocks.blockCorn, Blocks.farmland),"cornSeed");
	    	items.add(cornSeeds);
	    	*/

        }
	   
	    public static void createItems() {
	    	
	    	
	    	//int renderIndex = TurtleMain.proxy.addArmor("custom_armor");
	    	
	    	
	    	
	   
	
	    
		
	    	GameRegistry.register(creamQuartzPiece = new BasicItem("cream_quartz_piece"),new ResourceLocation("turtlemod","cream_quartz_piece"));
	     
	     	GameRegistry.register(turtleLeather = new BasicItem("turtle_leather"),new ResourceLocation("turtlemod", "turtle_leather"));

	     	GameRegistry.register(leosKatana = new BasicWeapon("leos_katana",LeoTool), new ResourceLocation("turtlemod", "leos_katana"));

            GameRegistry.register(mikesChucks = new BasicWeapon("mikes_chucks",MikeTool), new ResourceLocation("turtlemod", "mikes_chucks"));

            GameRegistry.register(raphsSai = new BasicWeapon("raphs_sai",RaphTool), new ResourceLocation("turtlemod", "raphs_sai"));

            GameRegistry.register(donsStick = new BasicWeapon("dons_stick",DonTool), new ResourceLocation("turtlemod", "dons_stick"));

	    	GameRegistry.register(kunai = new ItemKunai("kunai"),new ResourceLocation("turtlemod", "kunai"));
	     	
	    	GameRegistry.register(turtleHelmet = new ItemModArmor("turtle_helmet", turtleArmor, 0, EntityEquipmentSlot.HEAD),new ResourceLocation("turtlemod","turtle_helmet"));
	    	
	    	GameRegistry.register(turtleChestplate = new ItemTurtleArmor("turtle_chest_plate", turtleArmor, 0, EntityEquipmentSlot.CHEST),new ResourceLocation("turtlemod","turtle_chest_plate"));
	    
	    	GameRegistry.register(turtleLeggings = new ItemModArmor("turtle_leggings", turtleArmor, 0, EntityEquipmentSlot.LEGS),new ResourceLocation("turtlemod","turtle_leggings"));
	    
	    	GameRegistry.register(turtleBoots = new ItemModArmor("turtle_boots", turtleArmor, 0, EntityEquipmentSlot.FEET),new ResourceLocation("turtlemod","turtle_boots"));
	    
	    	GameRegistry.register(pizzaSlice = new ItemPizzaSlice("pizza_slice"), new ResourceLocation("turtlemod","pizza_slice"));

	    	GameRegistry.register(smokeBall = new ItemSmokeBall("smoke_ball"),new ResourceLocation("turtlemod","smoke_ball"));

	   	/*
	    	GameRegistry.registerItem(turtleChocolate = new ItemModFood("chocolate", 2, 0.2f, false,
	    		    new PotionEffect(Potion.moveSpeed.id, 1200, 1),
	    		    new PotionEffect(Potion.jump.id, 600, 0),
	    		    new PotionEffect(Potion.regeneration.id, 200, 1))
	    		    .setAlwaysEdible(), "chocolate");
	    	GameRegistry.registerItem(popsicle = new ItemModFood("popsicle",2,0.2f,false, new PotionEffect(Potion.regeneration.id,200,1)).setAlwaysEdible(),"popsicle");
	    */
	    	
	    	///items.add(turtleChestplate);
	    	//items.add(turtleLeggings);
	    	items.add(creamQuartzPiece);
	    	items.add(turtleHelmet);
	    	items.add(turtleChestplate);
	    	items.add(turtleLeggings);
	    	items.add(turtleBoots);
	    	items.add(turtleLeather);
	    	items.add(kunai);
	    	items.add(leosKatana);
	    	items.add(raphsSai);
	    	items.add(mikesChucks);
	    	items.add(donsStick);
	    	items.add(pizzaSlice);
	    	items.add(smokeBall);
	    	//items.add(turtleBoots);
	    	//items.add(turtleHelmet);
	    }
	}


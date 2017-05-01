package com.a2937.turtlemod.items;

import java.util.List;

import com.a2937.turtlemod.ModInfo;
import com.a2937.turtlemod.TurtleMain;
import com.a2937.turtlemod.blocks.ModBlocks;
import com.google.common.collect.Lists;

import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModItems {
	
	
	
	public static List<Item> items = Lists.newArrayList();
	
	  public static Item turtleLeather;
	  
	  
	  
	  
	 // public  static ItemModArmor turtleLeggings;
	 /// public static ItemModArmor turtleHelmet;
	 // public static ItemModArmor turtleChestplate;
	//  public static ItemModArmor turtleBoots;
	  
	  
	   

	 
	  //public static ArmorMaterial turtleA = EnumHelper.addArmorMaterial("turtleA", ModInfo.MODID + ":turtle", 16, new int[] {3, 8, 6, 3}, 30);
	  
	  
	//  public static final ArmorMaterial CLOTH_CUSTOM = EnumHelper.addArmorMaterial("Cloth",ModInfo.MODID + ":skirt", 5, new int[]{1, 3, 2, 1}, 15);
		
	 // public static final ArmorMaterial CowBoy = EnumHelper.addArmorMaterial("Cloth",ModInfo.MODID + ":bandit", 5, new int[]{1, 3, 2, 1}, 15);
	  
	  
		/** Example armor with a model: a skirt */
		public static Item sampleArmor;
		/** A set of leather bandit / cowboy armor */
		public static Item banditHelm, banditChest, banditLegs, banditBoots;
		
		public static Item turtleHelmet,turtleChestplate,turtleLeggings,turtleBoots;

	    public static ArmorMaterial turtleArmor = EnumHelper.addArmorMaterial("Turtle", "turtlemod:turtle", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	    
	    
	   
		
		public static void createSeeds() {
		 	
	    	///GameRegistry.registerItem(cornSeeds= new ItemCustomSeeds("cornSeed", ModBlocks.blockCorn, Blocks.farmland),"cornSeed");
	    
	    	//items.add(cornSeeds);
	    	
		}
	   
	    public static void createItems() {
	    	
	    	
	    	//int renderIndex = TurtleMain.proxy.addArmor("custom_armor");
	    	
	    	
	    	
	   
	
	    
		
	     
	     	GameRegistry.register(turtleLeather = new BasicItem("turtle_leather"),new ResourceLocation("turtlemod", "turtle_leather"));

	    		
	    	GameRegistry.register(turtleHelmet = new ItemModArmor("turtle_helmet", turtleArmor, 0, EntityEquipmentSlot.HEAD),new ResourceLocation("turtlemod","turtle_helmet"));
	    	
	    	GameRegistry.register(turtleChestplate = new ItemModArmor("turtle_chest_plate", turtleArmor, 0, EntityEquipmentSlot.CHEST),new ResourceLocation("turtlemod","turtle_chest_plate"));
	    
	    	GameRegistry.register(turtleLeggings = new ItemModArmor("turtle_leggings", turtleArmor, 0, EntityEquipmentSlot.LEGS),new ResourceLocation("turtlemod","turtle_leggings"));
	    
	    	GameRegistry.register(turtleBoots = new ItemModArmor("turtle_boots", turtleArmor, 0, EntityEquipmentSlot.FEET),new ResourceLocation("turtlemod","turtle_boots"));
	    	 
	    	
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
	    	items.add(turtleHelmet);
	    	items.add(turtleChestplate);
	    	items.add(turtleLeggings);
	    	items.add(turtleBoots);
	    	items.add(turtleLeather);
	    	//items.add(turtleBoots);
	    	//items.add(turtleHelmet);
	    }
	}


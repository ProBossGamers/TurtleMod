package com.probossgamers.turtlemod.entities;

import java.util.HashMap;
import java.util.List;

import com.probossgamers.turtlemod.ModInfo;
import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;

	public final class ModEntities {

		public static String modid = ModInfo.MODID;
		public static int modEntityID=0;


		//public static void addToList() {
		
	// }

		public static void createEntity(List<Class<? extends Entity>> entityClass,HashMap<Class<?extends EntityLivingBase>,Integer> primaryColor,HashMap<Class<?extends EntityLivingBase>,Integer> secondaryColor){
		//	addToList();
			for(Class<? extends Entity> ent : entityClass) {
				if(EntityLivingBase.class.isAssignableFrom(ent)) {


					regLiving((Class<? extends EntityLiving>) ent,primaryColor,secondaryColor);
				}
				else{
					reg(ent);
				}
				
			}
			

		}
		
		
		public static void reg(Class<? extends Entity> entities) {
			EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
		
				}
		
		public static void regLiving(Class<? extends EntityLiving> entities,HashMap<Class<?extends EntityLivingBase>,Integer> primaryColor, HashMap<Class<?extends EntityLivingBase>,Integer> secondaryColor) {

            EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
			EntityRegistry.registerEgg(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), primaryColor.get(entities), secondaryColor.get(entities));
			EntityRegistry.addSpawn(entities,10, 2, 9, EnumCreatureType.CREATURE, Biomes.BEACH ,Biomes.FROZEN_RIVER, Biomes.ICE_MOUNTAINS, Biomes.ICE_PLAINS, Biomes.PLAINS, Biomes.RIVER, Biomes.SWAMPLAND, Biomes.TAIGA, Biomes.TAIGA_HILLS);
		}
		
	}

		
			
			
			


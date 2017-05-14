package com.probossgamers.turtlemod.entities;

import java.util.List;

import com.probossgamers.turtlemod.ModInfo;
import com.probossgamers.turtlemod.TurtleMain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

	public final class ModEntities {

		public static String modid = ModInfo.MODID;
		public static int modEntityID=0;
		
	
		
		//public static void addToList() {
		
	// }

		public static void createEntity(List<Class<? extends Entity>> entityClass){
		//	addToList();
			for(Class<? extends Entity> ent : entityClass) {
				if(EntityLivingBase.class.isAssignableFrom(ent)) {
					regLiving(ent);
				}
				else{
					reg(ent);
				}
				
			}
			

		}
		
		
		public static void reg(Class<? extends Entity> entities) {
			EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
		
				}
		
		public static void regLiving(Class<? extends Entity> entities) {
			EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
			EntityRegistry.registerEgg(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), 161425, 1582224);
		}
		
	}

		
			
			
			

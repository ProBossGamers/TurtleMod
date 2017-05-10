package com.a2937.turtlemod.entities;

import java.util.List;

import com.a2937.turtlemod.ModInfo;
import com.a2937.turtlemod.TurtleMain;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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
				if(ent.isAssignableFrom(EntityLiving.class)) {
					regLiving(ent);
				}
				else{
					reg(ent);
				}
				
			}
			

		}
		
		
		public static void reg(Class<? extends Entity> entities) {
			EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
			//EntityRegistry.registerEgg(entities, 161425, 1582224);
		
				}
		
		public static void regLiving(Class<? extends Entity> entities) {
			EntityRegistry.registerModEntity(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), entities, entities.getSimpleName().toLowerCase(),  modEntityID++, TurtleMain.instance, 64, 10, true);
			EntityRegistry.registerEgg(new ResourceLocation(ModInfo.MODID,entities.getSimpleName()), 161425, 1582224);
		}
		
	}

		
			
			
			


package com.a2937.turtlemod.localization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.a2937.turtlemod.ModInfo;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;



public class SpanishWriter {




		 /*
		void Translate() {
			
			String text = Translator.callUrlAndParseResult("I am programmer", Language.ENGLISH, Language.FRENCH); 
			System.out.println(text);
			 

			}
			*/
		
		  static String Translate(String toTranslate) throws Exception {
			String text = Translator.callUrlAndParseResult("en", "es", toTranslate); 
			return text;
		}
		
		public static void writeFile(List<Block> blocks, List<Item> items, List<Class<? extends Entity>> entities) {
		    try {
		       
		    	
		    	   String dirLang = "output/" + ModInfo.MODID + "/lang/";
		    	      
		    	      
		    	File newTextFile = new File(dirLang + "es_ES.lang");
		    	
		    	// The new file is found in the project run folder 
		        FileWriter fw = new FileWriter(newTextFile);
		        fw.write((Translate("< This is a generated Spanish file >\n")));
		        fw.write("\n---------Creative Tabs ---------\n");
		        fw.write("itemGroup.roleplaymod" + "=" + "RolePlay Tab\n");
		        fw.write("\n---------GUI Localization-------\n");
		        fw.write("container.tutorial_tile_entity" + "=" + Translate("Sample Container"));
		        fw.write("\n--------Blocks----------\n");
		    	for(Block block : blocks) {
		    		String UnlocalName = block.getUnlocalizedName(); 
		    		fw.write("\n" + UnlocalName + ".name" + "=" + Translate(block.getUnlocalizedName().substring(5).replaceAll("_", " ").toLowerCase()));
		    	}
		    	fw.write("\n-------Items-----------\n");
		    	for(Item item : items) {
		    		String UnlocalName = item.getUnlocalizedName(); 
		    		fw.write("\n" + UnlocalName + ".name" + "=" + Translate(item.getUnlocalizedName().substring(5).replaceAll("_", " ").toLowerCase()));
		    	}
		    	fw.write("\n-------Entities--------\n");
		    	for(Class<? extends Entity> ent : entities) {
		    		String entClassName = ent.getSimpleName().toLowerCase();
		    		fw.write("\n" + "entity."  + ModInfo.MODID + "."  + entClassName + ".name" + "=" + Translate(entClassName.substring(6).replaceAll("_", " ")));
		    	}
		    	//fw.write("/n------Tile Entities----\n");
		    	//for(Class<? extends TileEntity> tile : tileEntities) {
		    	//	String tileClassName = tile.getName().toLowerCase();
		    	//	fw.write("/n" + "");
		    	//}
		        
		    	fw.close();
		    

		    } catch (IOException iox) {
		        //do stuff with exception
		        iox.printStackTrace();
		    } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
package com.probossgamers.turtlemod.localization;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.probossgamers.turtlemod.ModInfo;
import com.probossgamers.turtlemod.blocks.BlockCustomCrop;
import net.minecraft.entity.EntityLiving;
import org.apache.commons.lang3.text.WordUtils;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;

public class EnglishWriter {

	
	public static void writeFile(List<Block> blocks, List<Item> items, List<Class<? extends Entity>> entities, List<Class<? extends EntityLiving>> netherEntities,  List<Class<? extends EntityLiving>> frozenEntities ) {
    try
    {
       
    	   String dirname = "output/" + ModInfo.MODID;
    	      File d = new File(dirname);
    	      
    	      // Create directory now.
    	      d.mkdirs();
    	   
    	      String dirLang = "output/" + ModInfo.MODID + "/lang/";
    	      File dir = new File(dirLang);
    	      dir.mkdirs();
    	      
    	      String dirModel = "output/" + ModInfo.MODID + "/models/block/";
    	      File dirM = new File(dirModel);
    	      dirM.mkdirs();
    	      
    	      String dirIModel= "output/" + ModInfo.MODID + "/models/item/";
    	      File dirI = new File(dirIModel);
    	      dirI.mkdirs();
    	      
    	      String dirState= "output/" + ModInfo.MODID + "/blockstates/";
    	      File dirS = new File(dirState);
    	      dirS.mkdirs();
    	      
    	      
    	File newTextFile = new File(dirLang + "en_US.lang");
    	
    	// The new file is found in the project run folder 
        FileWriter fw = new FileWriter(newTextFile);
        fw.write("< This is a generated English file >\n");
        fw.write("\n---------Creative Tabs ---------\n");
        fw.write("itemGroup.turtlemod" + "=" + "Turtle Tab\n");
        fw.write("\n---------GUI Localization-------\n");
        fw.write("container.tutorial_tile_entity" + "=" + "Sample Container");
        fw.write("\n--------Blocks----------\n");
    	for(Block block : blocks) {
    		String UnlocalName = block.getUnlocalizedName(); 
    		fw.write("\n" + UnlocalName + ".name" + "=" + WordUtils.capitalize(block.getUnlocalizedName().substring(5).replaceAll("_", " ").toLowerCase()));
    	}
    	fw.write("\n-------Items-----------\n");
    	for(Item item : items) {
    		String UnlocalName = item.getUnlocalizedName(); 
    		fw.write("\n" + UnlocalName + ".name" + "=" + WordUtils.capitalize(item.getUnlocalizedName().substring(5).replaceAll("_", " ").toLowerCase()));
    	}
    	fw.write("\n-------Entities--------\n");
    	for(Class<? extends Entity> ent : entities) {
    		String entClassName = ent.getSimpleName().toLowerCase();
    		fw.write("\n" + "entity." + entClassName + ".name" + "=" + WordUtils.capitalize(entClassName.substring(6).replaceAll("_", " ")));
    	}
		for(Class<? extends Entity> ent : frozenEntities) {
			String entClassName = ent.getSimpleName().toLowerCase();
			fw.write("\n" + "entity." + entClassName + ".name" + "=" + WordUtils.capitalize(entClassName.substring(6).replaceAll("_", " ")));
		}
		for(Class<? extends Entity> ent :  netherEntities) {
			String entClassName = ent.getSimpleName().toLowerCase();
			fw.write("\n" + "entity." + entClassName + ".name" + "=" + WordUtils.capitalize(entClassName.substring(6).replaceAll("_", " ")));
		}
    	//fw.write("/n------Tile Entities----\n");
    	//for(Class<? extends TileEntity> tile : tileEntities) {
    	//	String tileClassName = tile.getName().toLowerCase();
    	//	fw.write("/n" + "");
    	//}
        
    	fw.close();
    	
    	for(Block block:blocks) {
    		File modelBlockFile = new File(dirname + "/models/block/" + block.getUnlocalizedName().substring(5) +".json");
    		File modelItemFile = new File(dirname + "/models/item/" + block.getUnlocalizedName().substring(5) +".json");
    		File modelBlockState = new File(dirname + "/blockstates/" + block.getUnlocalizedName().substring(5) +".json");
    		
    		FileWriter fwB = new FileWriter(modelBlockFile);
    		
    		fwB.write("{ \n");
    		fwB.write("'parent':".replace('\'', '"') + "'block/cube_all'".replace('\'', '"') + "," + "\n");
    		fwB.write("'textures':".replace('\'', '"') + "{" + "\n");
    		fwB.write("'all':".replace('\'', '"') + "'".replace('\'', '"') +ModInfo.MODID + ":blocks/" + block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "\n");
    		fwB.write("}" + "\n");
    		fwB.write("}");
    		fwB.close();
    		
    		FileWriter fwI = new FileWriter(modelItemFile);
    		
    		fwI.write("{ \n");
    		fwI.write("'parent':".replace('\'', '"') + "'block/cube_all'".replace('\'', '"') + "," + "\n");
    		fwI.write("'textures':".replace('\'', '"') + "{" + "\n");
    		fwI.write("'all':".replace('\'', '"') +  "'".replace('\'', '"') +ModInfo.MODID + ":blocks/" + block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "\n");
    		fwI.write("}" + "\n");
    		fwI.write("}");
    		fwI.close();
    		
    		FileWriter fwBS = new FileWriter(modelBlockState);
    		fwBS.write("{" + "\n");
    		fwBS.write("'variants': {".replace('\'', '"') + "\n");
    		fwBS.write("'normal' : {".replace('\'', '"'));
    		fwBS.write("'model':".replace('\'', '"'));
    		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "} \n");
    		fwBS.write("}");
    		fwBS.write("\n }");
    		fwBS.close();
    	}
    	for(Item item:items) {
    		File modelItemFile = new File(dirname + "/models/item/" + item.getUnlocalizedName().substring(5) +".json");
    		FileWriter fwItem = new FileWriter(modelItemFile);
    		fwItem.write("{ \n");
    		fwItem.write("'parent': 'item/generated', \n".replace('\'', '"'));
    		fwItem.write("'textures': { \n".replace('\'', '"'));
    		fwItem.write("'layer0': '".replace('\'', '"') + ModInfo.MODID + ":" + "items/" + item.getUnlocalizedName().substring(5) + "'".replace('\'', '"'));
    		fwItem.write("\n } \n");
    		fwItem.write("} \n");
    		fwItem.close();
    	}
    

    } catch (IOException iox) {
        //do stuff with exception
        iox.printStackTrace();
    }
    
    
}
	
	
	public static void writeFileForCrop(List<BlockCustomCrop> blocks) {
		 String dirname = "output/" + ModInfo.MODID;
		
		
		/*
		 * for(Block block:blocks) {
    		File modelBlockFile = new File(dirname + "/models/block/" + block.getUnlocalizedName().substring(5) +".json");
    		File modelItemFile = new File(dirname + "/models/item/" + block.getUnlocalizedName().substring(5) +".json");
    		File modelBlockState = new File(dirname + "/blockstates/" + block.getUnlocalizedName().substring(5) +".json");
    		
    		FileWriter fwB = new FileWriter(modelBlockFile);
    		
    		fwB.write("{ \n");
    		fwB.write("'parent':".replace('\'', '"') + "'block/cube_all'".replace('\'', '"') + "," + "\n");
    		fwB.write("'textures':".replace('\'', '"') + "{" + "\n");
    		fwB.write("'all':".replace('\'', '"') + "'".replace('\'', '"') +ModInfo.MODID + ":blocks/" + block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "\n");
    		fwB.write("}" + "\n");
    		fwB.write("}");
    		fwB.close();
    		
    		FileWriter fwI = new FileWriter(modelItemFile);
    		
    		fwI.write("{ \n");
    		fwI.write("'parent':".replace('\'', '"') + "'block/cube_all'".replace('\'', '"') + "," + "\n");
    		fwI.write("'textures':".replace('\'', '"') + "{" + "\n");
    		fwI.write("'all':".replace('\'', '"') +  "'".replace('\'', '"') +ModInfo.MODID + ":blocks/" + block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "\n");
    		fwI.write("}" + "\n");
    		fwI.write("}");
    		fwI.close();
    		
    		FileWriter fwBS = new FileWriter(modelBlockState);
    		fwBS.write("{" + "\n");
    		fwBS.write("'variants': {".replace('\'', '"') + "\n");
    		fwBS.write("'normal' : {".replace('\'', '"'));
    		fwBS.write("'model':".replace('\'', '"'));
    		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "} \n");
    		fwBS.write("}");
    		fwBS.write("\n }");
    		fwBS.close();
    	}
    	
		 */
		
		
   		try {
				
				for(Block block:blocks) {
				File modelBlockFile0 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage0" +".json");
				File modelBlockFile1 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage1" +".json");
				File modelBlockFile2 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage2" +".json");
				File modelBlockFile3 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage3" +".json");
				File modelBlockFile4 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage4" +".json");
				File modelBlockFile5 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage5" +".json");
				File modelBlockFile6 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage6" +".json");
				File modelBlockFile7 = new File(dirname + "/models/block/" + block.getUnlocalizedName() + "/" + block.getUnlocalizedName().substring(5) +"_stage7" +".json");
				
				File modelItemFile = new File(dirname + "/models/item/" + block.getUnlocalizedName().substring(5) +".json");
	    		File modelBlockState = new File(dirname + "/blockstates/" + block.getUnlocalizedName().substring(5) +".json");
	    		
			FileWriter fwB0 = new FileWriter(modelBlockFile0);
   			fwB0.write("{ \n");
       		fwB0.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB0.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB0.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "0" + "'".replace('\'', '"') + "\n");
       		fwB0.write("}" + "\n");
       		fwB0.write("}");
       		fwB0.close();
       		
       		FileWriter fwB1 = new FileWriter(modelBlockFile1);
   			fwB1.write("{ \n");
       		fwB1.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB1.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB1.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "1" + "'".replace('\'', '"') + "\n");
       		fwB1.write("}" + "\n");
       		fwB1.write("}");
       		fwB1.close();
       		
      		FileWriter fwB2 = new FileWriter(modelBlockFile2);
   			fwB2.write("{ \n");
       		fwB2.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB2.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB2.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "2" + "'".replace('\'', '"') + "\n");
       		fwB2.write("}" + "\n");
       		fwB2.write("}");
       		fwB2.close();
       		
      		
      		FileWriter fwB3 = new FileWriter(modelBlockFile3);
   			fwB3.write("{ \n");
       		fwB3.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB3.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB3.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "3" + "'".replace('\'', '"') + "\n");
       		fwB3.write("}" + "\n");
       		fwB3.write("}");
       		fwB3.close();
       		
       		FileWriter fwB4 = new FileWriter(modelBlockFile4);
   			fwB4.write("{ \n");
       		fwB4.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB4.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB4.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "4" + "'".replace('\'', '"') + "\n");
       		fwB4.write("}" + "\n");
       		fwB4.write("}");
       		fwB4.close();
       		
       		FileWriter fwB5 = new FileWriter(modelBlockFile5);
   			fwB5.write("{ \n");
       		fwB5.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB5.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB5.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "5" + "'".replace('\'', '"') + "\n");
       		fwB5.write("}" + "\n");
       		fwB5.write("}");
       		fwB5.close();
       		
     		FileWriter fwB6 = new FileWriter(modelBlockFile6);
   			fwB6.write("{ \n");
       		fwB6.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB6.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB6.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "6" + "'".replace('\'', '"') + "\n");
       		fwB6.write("}" + "\n");
       		fwB6.write("}");
       		fwB6.close();
       		
       		FileWriter fwB7 = new FileWriter(modelBlockFile7);
   			fwB7.write("{ \n");
       		fwB7.write("'parent':".replace('\'', '"') + "'block/crop'".replace('\'', '"') + "," + "\n");
       		fwB7.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwB7.write("'crop':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "/" + "7" + "'".replace('\'', '"') + "\n");
       		fwB7.write("}" + "\n");
       		fwB7.write("}");
       		fwB7.close();
       		
       		
       		
       		FileWriter fwI = new FileWriter(modelItemFile);
       		
       		fwI.write("{ \n");
       		fwI.write("'parent':".replace('\'', '"') + "'block/cube_all'".replace('\'', '"') + "," + "\n");
       		fwI.write("'textures':".replace('\'', '"') + "{" + "\n");
       		fwI.write("'all':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" + "7" + "'".replace('\'', '"') + "\n");
       		fwI.write("}" + "\n");
       		fwI.write("}");
       		fwI.close();
       		
       		FileWriter fwBS = new FileWriter(modelBlockState);
       		fwBS.write("{" + "\n");
       		fwBS.write("'variants': {".replace('\'', '"') + "\n");
   
       		fwBS.write("'age=0' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage0" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=1' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage1" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=2' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage2" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=3' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage3" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=4' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage4" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=5' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage5" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=6' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage6" +"'".replace('\'', '"') + "}, \n");
       		
       		fwBS.write("'age=7' : {".replace('\'', '"'));
       		fwBS.write("'model':".replace('\'', '"'));
       		fwBS.write("'".replace('\'', '"')+ ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName() + "/" +block.getUnlocalizedName() + "_stage7" +"'".replace('\'', '"') + "} \n");
       		
       		
       		fwBS.write("}");
       		fwBS.write("\n }");
       		fwBS.close();
       		
				}
				
			} 
   		catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
 
	
	
	
	
	/*
	public static void writeFileForSidedBlock(List<DirectionBlock> blocks) {
		 String dirname = "output/" + ModInfo.MODID;
		
    		try {
				
				for(Block block:blocks) {
				File modelBlockFile = new File(dirname + "/models/block/" + block.getUnlocalizedName().substring(5) +".json");
				File modelItemFile = new File(dirname + "/models/item/" + block.getUnlocalizedName().substring(5) +".json");
	    		File modelBlockState = new File(dirname + "/blockstates/" + block.getUnlocalizedName().substring(5) +".json");
	    		
				FileWriter fwB = new FileWriter(modelBlockFile);
    			fwB.write("{ \n");
        		fwB.write("'parent':".replace('\'', '"') + "'block/orientable'".replace('\'', '"') + "," + "\n");
        		fwB.write("'textures':".replace('\'', '"') + "{" + "\n");
        		fwB.write("'front':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_side" + "'".replace('\'', '"') +  ",\n");
        		fwB.write("'down':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_down"+ "'".replace('\'', '"') + ",\n");
        		fwB.write("'top':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_top" + "'".replace('\'', '"') + ",\n");
        		fwB.write("'side':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_side" + "'".replace('\'', '"') + "\n");
        		fwB.write("}" + "\n");
        		fwB.write("}");
        		fwB.close();
        		
        		FileWriter fwI = new FileWriter(modelItemFile);
        		
        		fwI.write("{ \n");
        		fwI.write("'parent':".replace('\'', '"') + "'block/orientable'".replace('\'', '"') + "," + "\n");
        		fwI.write("'textures':".replace('\'', '"') + "{" + "\n");
        		fwI.write("'front':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + "\n");
        		fwI.write("'bottom':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "'".replace('\'', '"') + ",\n");
        		fwI.write("'top':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_top" + "'".replace('\'', '"') + ",\n");
        		fwI.write("'side':".replace('\'', '"') + "'".replace('\'', '"') + ModInfo.MODID + ":blocks/"+ block.getUnlocalizedName().substring(5) + "_side" + "'".replace('\'', '"') + "\n");
        		fwI.write("}" + "\n");
        		fwI.write("}");
        		fwI.close();
        		
        		FileWriter fwBS = new FileWriter(modelBlockState);
        		fwBS.write("{" + "\n");
        		fwBS.write("'variants': {".replace('\'', '"') + "\n");
        		fwBS.write("'normal' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front" +"'".replace('\'', '"') + "} \n");
        		
        		fwBS.write("'facing=north' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front" +"'".replace('\'', '"') + "} \n");
        		
        		
        		fwBS.write("'facing=sorth' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front"  
        		+ "'".replace('\'', '"') + "," + "'".replace('\'','"') + "," + "y" +":" + "180" + "} \n");
        		
        		fwBS.write("'facing=west' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front"  
                + "'".replace('\'', '"') + "," + "'".replace('\'','"') +  "," + "y" +":" + "270" + "} \n");
     
        		fwBS.write("'facing=east' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front"  
                + "'".replace('\'', '"') + "," + "'".replace('\'','"') +  "," +"y" +":" + "90" + "} \n");
     
        		fwBS.write("'facing=down' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front"  
                + "'".replace('\'', '"') + "," + "'".replace('\'','"') +  "," + "x" +":" + "90" + "} \n");
     
        		fwBS.write("'facing=down' : {".replace('\'', '"'));
        		fwBS.write("'model':".replace('\'', '"'));
        		fwBS.write("'".replace('\'', '"')+ModInfo.MODID +":"+ block.getUnlocalizedName().substring(5) + "_front"  
                + "'".replace('\'', '"') + "," + "'".replace('\'','"') +  "," + "x" +":" + "270" + "} \n");
     
        		
        		fwBS.write("}");
        		fwBS.write("\n }");
        		fwBS.close();
        		
				}
				
			} 
    		catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	*/
	}
	
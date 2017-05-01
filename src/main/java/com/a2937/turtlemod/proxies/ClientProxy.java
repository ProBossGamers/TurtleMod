package com.a2937.turtlemod.proxies;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.a2937.turtlemod.TurtleMain;
import com.a2937.turtlemod.blocks.ModBlocks;
import com.a2937.turtlemod.client.render.blocks.BlockRenderRegister;
import com.a2937.turtlemod.client.render.items.ItemRenderRegister;
import com.a2937.turtlemod.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends ServerProxy {
    
	private static int originalGuiScale;

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	RenderManager render = Minecraft.getMinecraft().getRenderManager();
	
	RenderItem renderItem= Minecraft.getMinecraft().getRenderItem();
	
	public int getGuiScale(){
		return originalGuiScale;
	}
	
	/** A Map allows for easy handling of many armor models */
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	
	
	private void addArmorModel(Item armor, ModelBiped model) {
		if (model == null) {
			// technically, you CAN add a null model, but the default is already to return null, so it would be redundant
			TurtleMain.logger.log(Level.WARNING, String.format("Error adding model for %s: Cannot add a NULL armor model!", armor.getUnlocalizedName()));
			return;
		}
		// better let yourself / users know when overwriting an entry, as it is likely to be a mistake!
		if (armorModels.containsKey(armor)) {
			TurtleMain.logger.log(Level.WARNING, String.format("A model for %s has already been registered! It will now be overwritten.", armor.getUnlocalizedName()));
		}
		armorModels.put(armor, model);
	}
	
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
	 // Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
	 // your packets will not work because you will be getting a client
	 // player even when you are on the server! Sounds absurd, but it's true.

	 // Solution is to double-check side before returning the player:
	 return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
	}
	
	public void render() {
		
	
	   //  OBJLoader.instance.addDomain(ModInfo.MODID.toLowerCase());
	  	ItemRenderRegister.registerItemRenderer(ModItems.items);
        BlockRenderRegister.registerBlockRenderer(ModBlocks.blocks);
	      //  ModelLoader.setCustomModelResourceLocation(item6, 0, new ModelResourceLocation(ModInfo.MODID.toLowerCase() + ":" + OBJDirectionBlock.name, "inventory"));

	        
		
		
		
		
		
	}
	
	@Override
	public void renderEntities() {
		
	
	
		
	
	}
	
	
	
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
	extendedEntityData.put(name, compound);
	}

	/**
	* Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	*/
	public static NBTTagCompound getEntityData(String name)
	{
	return extendedEntityData.remove(name);
	}
		
}

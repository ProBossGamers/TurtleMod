package com.a2937.turtlemod.proxies;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ServerProxy {
    
    
    private static int originalGuiScale;

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	
	
	
	public int getGuiScale(){
		return originalGuiScale;
	}
	
	 public EntityPlayer getPlayerEntity(MessageContext ctx) {
		  return ctx.getServerHandler().playerEntity;
		 }
	
	public void render() {}
	
	public void renderEntities() {}
	
	public int addArmor(String string) {
		return 0;
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
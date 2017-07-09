package com.probossgamers.turtlemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class PlayerUtils {

	
	public static void sendChat(EntityPlayer player, String message) {
		player.sendStatusMessage(new TextComponentString(message),false);
	}
	
}

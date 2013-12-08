package me.thegeekyguy101.TurtleMod.server;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ServerProxy {
	
	public void registerRenderThings() {
		
	}
	
	public void registerServerTickHandler() {
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
	public void test() {
		
	}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public void registerSound() {
		
	}
}

package com.probossgamers.turtlemod;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SoundHandler {
	
	
	public static SoundEvent mineturtle_hello;
	public static SoundEvent turtle_living;
	public static SoundEvent turtle_hurt;
	public static SoundEvent turtle_death;
	public static SoundEvent don_living;
	public static SoundEvent leo_living;
	public static SoundEvent mike_living;
	public static SoundEvent raph_living;
	public static SoundEvent helloguy_hg;
    public static SoundEvent helloguy_hgh;
    public static SoundEvent helloguy_hgd;
	/**
	 * Register the {@link SoundEvent}s.
	 */
	public static void registerSounds() {
		mineturtle_hello = registerSound("mineturtle.hello");
		turtle_living = registerSound("turtle.living");
		turtle_hurt = registerSound("turtle.hurt");
		turtle_death = registerSound("turtle.death");
		don_living = registerSound("don.living");
		leo_living = registerSound("leo.living");
		mike_living = registerSound("mike.living");
		raph_living = registerSound("raph.living");
        helloguy_hg = registerSound("helloguy.hg");
        helloguy_hgh = registerSound("helloguy.hgh");
        helloguy_hgd = registerSound("helloguy.hgd");
	}

	/**
	 * Register a {@link SoundEvent}.
	 *
	 * @param soundName The SoundEvent's name without the testmod3 prefix
	 * @return The SoundEvent
	 */
	private static SoundEvent registerSound(String soundName)
    {
		final ResourceLocation soundID = new ResourceLocation(ModInfo.MODID, soundName);
		return GameRegistry.register(new SoundEvent(soundID).setRegistryName(soundID));
	}
	
	
	
/*

public static SoundEvent turtleHurt;
	public static SoundEvent cadCreate;
	public static SoundEvent cadShoot;
	public static SoundEvent compileError;
	public static SoundEvent levelUp;
	public static SoundEvent loopcast;
	
	private static int size = 0;
	
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		turtleHurt = register("turtleHurt");
		cadCreate = register("cadCreate");
		cadShoot = register("cadShoot");
		compileError = register("compileError");
		levelUp = register("levelUp");
		loopcast = register("loopcast");
	}
	
	public static SoundEvent register(String name) {
		ResourceLocation loc = new ResourceLocation(ModInfo.MODID + name);
		SoundEvent e = new SoundEvent(loc);
		
		SoundEvent.REGISTRY.register(size, loc, e);
		size++;
		
		return e;
	}
	
	*/
}
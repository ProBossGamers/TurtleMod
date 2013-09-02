package me.thegeekyguy101.TurtleMod;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler {

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event) {
		event.manager.addSound("turtlemod:mob/turtle/living.ogg");
		event.manager.addSound("turtlemod:mob/turtle/hurt.ogg");
		event.manager.addSound("turtlemod:mob/turtle/death.ogg");
		
		event.manager.addSound("turtlemod:mob/helloGuy/hg0.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hg1.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hg2.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgh0.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgh1.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgd.ogg");
		
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT80.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT2003.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT2012.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:mineturtle.ogg");
	}
}

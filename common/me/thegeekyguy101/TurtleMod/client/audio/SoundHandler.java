package me.thegeekyguy101.TurtleMod.client.audio;

import me.thegeekyguy101.TurtleMod.entity.monster.EntityDonatello;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SoundHandler {

	@SideOnly(Side.CLIENT)
	@ForgeSubscribe
	public void onSoundLoad(SoundLoadEvent event) {
		//Turtle Sound effects
		event.manager.addSound("turtlemod:mob/turtle/living.ogg");
		event.manager.addSound("turtlemod:mob/turtle/hurt.ogg");
		event.manager.addSound("turtlemod:mob/turtle/death.ogg");
		
		//Hello Guy sound effects
		event.manager.addSound("turtlemod:mob/helloGuy/hg0.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hg1.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hg2.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgh0.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgh1.ogg");
		event.manager.addSound("turtlemod:mob/helloGuy/hgd.ogg");
		
		//Donatello sound effects
		event.manager.addSound("turtlemod:mob/TMNT/Donatello/don0.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Donatello/don1.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Donatello/don2.ogg");
		
		//Leonardo sound effects
		event.manager.addSound("turtlemod:mob/TMNT/Leonardo/leo0.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Leonardo/leo1.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Leonardo/leo2.ogg");
		
		//Michelangelo sound effects
		event.manager.addSound("turtlemod:mob/TMNT/Michelangelo/mike0.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Michelangelo/mike1.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Michelangelo/mike2.ogg");
		
		//Raphael sound effects
		event.manager.addSound("turtlemod:mob/TMNT/Raphael/raph0.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Raphael/raph1.ogg");
		event.manager.addSound("turtlemod:mob/TMNT/Raphael/raph2.ogg");
		
		//music disc sounds
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT80.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT2003.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:TMNT2012.ogg");
		event.manager.soundPoolStreaming.addSound("turtlemod:mineturtle.ogg");
	}
}
 
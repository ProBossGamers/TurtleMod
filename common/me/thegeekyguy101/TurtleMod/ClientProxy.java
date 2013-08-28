package me.thegeekyguy101.TurtleMod;

import me.thegeekyguy101.TurtleMod.entity.EntityHelloGuy;
import me.thegeekyguy101.TurtleMod.entity.EntityMineTurtle;
import me.thegeekyguy101.TurtleMod.entity.EntityTurtle;
import me.thegeekyguy101.TurtleMod.entity.EntityZombieTurtle;
import me.thegeekyguy101.TurtleMod.model.ModelMineTurtle;
import me.thegeekyguy101.TurtleMod.model.ModelTurtle;
import me.thegeekyguy101.TurtleMod.render.RenderHelloGuy;
import me.thegeekyguy101.TurtleMod.render.RenderMineTurtle;
import me.thegeekyguy101.TurtleMod.render.RenderTurtle;
import me.thegeekyguy101.TurtleMod.render.RenderZombieTurtle;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderThings() {
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new RenderHelloGuy(new ModelBiped(), 0.3F));
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
	@Override
	public void registerSound() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}
}

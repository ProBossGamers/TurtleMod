package me.thegeekyguy101.TurtleMod.client;

import me.thegeekyguy101.TurtleMod.RenderModel;
import me.thegeekyguy101.TurtleMod.TurtleMod;
import me.thegeekyguy101.TurtleMod.client.audio.SoundHandler;
import me.thegeekyguy101.TurtleMod.client.model.ModelMineTurtle;
import me.thegeekyguy101.TurtleMod.client.model.ModelTurtle;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderDonatello;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderHelloGuy;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderLeonardo;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderMichelangelo;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderMineTurtle;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderRaphael;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderTurtle;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderZombieTurtle;
import me.thegeekyguy101.TurtleMod.client.renderer.item.ItemRendererTurtleShell;
import me.thegeekyguy101.TurtleMod.client.renderer.tileentity.RenderTurtleShell;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityDonatello;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityLeonardo;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityMichelangelo;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityMineTurtle;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityRaphael;
import me.thegeekyguy101.TurtleMod.entity.monster.EntityZombieTurtle;
import me.thegeekyguy101.TurtleMod.entity.passive.EntityHelloGuy;
import me.thegeekyguy101.TurtleMod.entity.passive.EntityTurtle;
import me.thegeekyguy101.TurtleMod.server.ServerProxy;
import me.thegeekyguy101.TurtleMod.tileentity.TileEntityTurtleShell;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;


public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTurtleShell.class, new RenderTurtleShell());
		MinecraftForgeClient.registerItemRenderer(TurtleMod.turtleShellBlock.blockID, new ItemRendererTurtleShell());
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new RenderTurtle(new ModelTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new RenderZombieTurtle(new ModelTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new RenderMineTurtle(new ModelMineTurtle(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new RenderHelloGuy(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityLeonardo.class, new RenderLeonardo(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRaphael.class, new RenderRaphael(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityDonatello.class, new RenderDonatello(new ModelBiped(), 0.3F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMichelangelo.class, new RenderMichelangelo(new ModelBiped(), 0.3F));
	}
	
	@Override
	public void test() {
		MinecraftForge.EVENT_BUS.register(new RenderModel());
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

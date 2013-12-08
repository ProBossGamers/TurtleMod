package me.thegeekyguy101.TurtleMod;

import org.lwjgl.opengl.GL11;

import me.thegeekyguy101.TurtleMod.client.model.ModelShredderPlayer;
import me.thegeekyguy101.TurtleMod.client.model.ModelTurtlePlayer;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderShredderPlayer;
import me.thegeekyguy101.TurtleMod.client.renderer.entity.RenderTurtlePlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;

public class RenderModel {

	public final RenderTurtlePlayer turtleRenderer = new RenderTurtlePlayer(new ModelTurtlePlayer(), 0.3F);
	public final RenderShredderPlayer shredderRenderer = new RenderShredderPlayer(new ModelShredderPlayer(), 0.3F);
	
	@ForgeSubscribe
	public void pre(RenderPlayerEvent.Pre event) {
		String username = event.entityPlayer.username;
		EntityPlayer player = event.entityPlayer;
		
		if (username.equals("Ry_dog101")) {
			event.setCanceled(true);
			renderEntityTurtle(player);
		}else if (username.equals("DeathJusty")) {
			event.setCanceled(true);
			renderEntityDeathJusty(player);
		}else if (username.equals("dylan5950")) {
			event.setCanceled(true);
			renderEntityTurtle(player);
		}
	}
	
	private void renderEntityTurtle(EntityPlayer player) {
        float par2 = 0;
        float offset = 1.62f;
        double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * par2;
        double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * par2;
        double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * par2;
        float f1 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * par2;
        turtleRenderer.doRender(player, d0 - RenderManager.renderPosX, d1 - RenderManager.renderPosY - offset, d2 - RenderManager.renderPosZ, f1, par2);
	}
	
	private void renderEntityDeathJusty(EntityPlayer player) {
		float par2 = 0;
		float offset = 1.62f;
		double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * par2;
		double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * par2;
		double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * par2;
		float f1 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * par2;
		shredderRenderer.doRender(player, d0 - RenderManager.renderPosX, d1 - RenderManager.renderPosY - offset, d2 - RenderManager.renderPosZ, f1, par2);
	}
}

package me.thegeekyguy101.TurtleMod.client.renderer.entity;

import me.thegeekyguy101.TurtleMod.client.model.ModelTurtlePlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class RenderTurtlePlayer extends RendererLivingEntity {

	protected ModelTurtlePlayer model;
	
	public RenderTurtlePlayer(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		this.setRenderManager(RenderManager.instance);
		model = ((ModelTurtlePlayer)mainModel);
	}
	
	public void renderTurtlePlayer(EntityPlayer entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityPlayer par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderTurtlePlayer((EntityPlayer)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderTurtlePlayer((EntityPlayer)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("turtlemod:textures/mobs/Turtle.png");
	}
}

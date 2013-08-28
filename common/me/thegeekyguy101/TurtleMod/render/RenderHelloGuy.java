package me.thegeekyguy101.TurtleMod.render;

import me.thegeekyguy101.TurtleMod.entity.EntityHelloGuy;
import me.thegeekyguy101.TurtleMod.entity.EntityTurtle;
import me.thegeekyguy101.TurtleMod.model.ModelTurtle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderHelloGuy extends RenderLiving {

	protected ModelBiped model;
	
	public RenderHelloGuy(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		model = ((ModelBiped)mainModel);
	}
	
	public void renderHelloGuy(EntityHelloGuy entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRenderLiving(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9) {
		renderHelloGuy((EntityHelloGuy)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {
		renderHelloGuy((EntityHelloGuy)entity, d0, d1, d2, f, f1);
	}

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return new ResourceLocation("turtlemod:textures/mobs/HelloGuy.png");
	}

}

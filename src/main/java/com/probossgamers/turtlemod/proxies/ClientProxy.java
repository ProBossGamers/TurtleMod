package com.probossgamers.turtlemod.proxies;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import com.probossgamers.turtlemod.TurtleMain;
import com.probossgamers.turtlemod.blocks.ModBlocks;
import com.probossgamers.turtlemod.client.render.blocks.BlockRenderRegister;
import com.probossgamers.turtlemod.client.render.items.ItemRenderRegister;
import com.probossgamers.turtlemod.entities.EntityHelloGuy;
import com.probossgamers.turtlemod.entities.EntityKunai;
import com.probossgamers.turtlemod.entities.EntityTurtle;
import com.probossgamers.turtlemod.entities.monster.*;
import com.probossgamers.turtlemod.entities.render.*;
import com.probossgamers.turtlemod.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends ServerProxy {
    
	private static int originalGuiScale;

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	RenderManager render = Minecraft.getMinecraft().getRenderManager();
	
	RenderItem renderItem= Minecraft.getMinecraft().getRenderItem();
	
	public int getGuiScale(){
		return originalGuiScale;
	}
	
	/** A Map allows for easy handling of many armor models */
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();

	
	
	private void addArmorModel(Item armor, ModelBiped model) {
		if (model == null) {
			// technically, you CAN add a null model, but the default is already to return null, so it would be redundant
			TurtleMain.logger.log(Level.WARNING, String.format("Error adding model for %s: Cannot add a NULL armor model!", armor.getUnlocalizedName()));
			return;
		}
		// better let yourself / users know when overwriting an entry, as it is likely to be a mistake!
		if (armorModels.containsKey(armor)) {
			TurtleMain.logger.log(Level.WARNING, String.format("A model for %s has already been registered! It will now be overwritten.", armor.getUnlocalizedName()));
		}
		armorModels.put(armor, model);
	}
	
	
	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
	 // Note that if you simply return 'Minecraft.getMinecraft().thePlayer',
	 // your packets will not work because you will be getting a client
	 // player even when you are on the server! Sounds absurd, but it's true.

	 // Solution is to double-check side before returning the player:
	 return (ctx.side.isClient() ? Minecraft.getMinecraft().player : super.getPlayerEntity(ctx));
	}
	
	public void render() {
		
	
	   //  OBJLoader.instance.addDomain(ModInfo.MODID.toLowerCase());
	  	ItemRenderRegister.registerItemRenderer(ModItems.items);
        BlockRenderRegister.registerBlockRenderer(ModBlocks.blocks);
	      //  ModelLoader.setCustomModelResourceLocation(item6, 0, new ModelResourceLocation(ModInfo.MODID.toLowerCase() + ":" + OBJDirectionBlock.name, "inventory"));

	        
		
		
		
		
		
	}
	
	@Override
	public void renderEntities() {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityTurtle.class, new IRenderFactory<EntityTurtle>(){
			@Override
			public Render<? super EntityTurtle> createRenderFor(RenderManager manager) 
			{
				return new RenderTurtle(manager);
			}
		});
		
	
		RenderingRegistry.registerEntityRenderingHandler(EntityKunai.class, new IRenderFactory<EntityKunai>() 
		{
			@Override
			public Render<? super EntityKunai> createRenderFor(RenderManager manager) 
			{
				return new RenderSnowball<EntityKunai>(manager,ModItems.kunai, Minecraft.getMinecraft().getRenderItem());
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityMineTurtle.class, new IRenderFactory<EntityMineTurtle>()
		{
			@Override
			public Render<? super EntityMineTurtle> createRenderFor(RenderManager manager)
			{
				return new RenderMineTurtle(manager);
			}
		});

	
	RenderingRegistry.registerEntityRenderingHandler(EntityZombieTurtle.class, new IRenderFactory<EntityZombieTurtle>()
		{
			@Override
			public Render<? super EntityZombieTurtle> createRenderFor(RenderManager manager)
			{
				return new RenderZombieTurtle(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySkeletonTurtle.class, new IRenderFactory<EntitySkeletonTurtle>()
		{
			@Override
			public Render<? super EntitySkeletonTurtle> createRenderFor(RenderManager manager)
			{
				return new RenderSkeletonTurtle(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityHelloGuy.class, new IRenderFactory<EntityHelloGuy>()
		{
			@Override
			public Render<? super EntityHelloGuy> createRenderFor(RenderManager manager)
			{
				return new RenderHelloGuy(manager);
			}
		});

        RenderingRegistry.registerEntityRenderingHandler(EntityLeonardo.class, new IRenderFactory<EntityLeonardo>()
        {
            @Override
            public Render<? super EntityLeonardo> createRenderFor(RenderManager manager)
            {
                return new RenderLeonardo(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityRaphael.class, new IRenderFactory<EntityRaphael>()
        {
            @Override
            public Render<? super EntityRaphael> createRenderFor(RenderManager manager)
            {
                return new RenderRaphael(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityMichelangelo.class, new IRenderFactory<EntityMichelangelo>()
        {
            @Override
            public Render<? super EntityMichelangelo> createRenderFor(RenderManager manager)
            {
                return new RenderMichelangelo(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityDonatello.class, new IRenderFactory<EntityDonatello>()
        {
            @Override
            public Render<? super EntityDonatello> createRenderFor(RenderManager manager)
            {
                return new RenderDonatello(manager);
            }
        });

        RenderingRegistry.registerEntityRenderingHandler(EntityFootNinja.class, new IRenderFactory<EntityFootNinja>()
        {
            @Override
            public Render<? super EntityFootNinja> createRenderFor(RenderManager manager)
            {
                return new RenderFootNinja(manager);
            }
        });
}

	
	public static void storeEntityData(String name, NBTTagCompound compound)
	{
	extendedEntityData.put(name, compound);
	}

	/**
	* Removes the compound from the map and returns the NBT tag stored for name or null if none exists
	*/
	public static NBTTagCompound getEntityData(String name)
	{
	return extendedEntityData.remove(name);
	}
		
}

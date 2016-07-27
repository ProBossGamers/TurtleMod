package net.probossgamers.turtlemod.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.probossgamers.turtlemod.TurtleMod;
import net.probossgamers.turtlemod.common.CommonProxy;

public class ClientProxy extends CommonProxy {
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
        ItemModelMesher modelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        modelMesher.register(TurtleMod.turtleLeather, stack -> new ModelResourceLocation("turtlemod:turtleLeather", "inventory"));
        modelMesher.register(TurtleMod.turtleHelmet, stack -> new ModelResourceLocation("turtlemod:turtleHelmet", "inventory"));
        modelMesher.register(TurtleMod.turtleChestplate, stack -> new ModelResourceLocation("turtlemod:turtleChestplate", "inventory"));
        modelMesher.register(TurtleMod.turtleLeggings, stack -> new ModelResourceLocation("turtlemod:turtleLeggings", "inventory"));
        modelMesher.register(TurtleMod.turtleBoots, stack -> new ModelResourceLocation("turtlemod:turtleBoots", "inventory"));
    }
}

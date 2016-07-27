package net.probossgamers.turtlemod;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.probossgamers.turtlemod.client.items.ItemTurtleArmor;
import net.probossgamers.turtlemod.client.items.TurtleItem;
import net.probossgamers.turtlemod.common.CommonProxy;

@Mod(modid = "turtlemod", name = "Turtle Mod", version = "Alpha 6.0")
public class TurtleMod {
    @Mod.Instance("turtlemod")
    public static TurtleMod instance;
    @SidedProxy(serverSide = "net.probossgamers.turtlemod.common.CommonProxy", clientSide = "net.probossgamers.turtlemod.client.ClientProxy")
    public static CommonProxy proxy;


    public static ItemArmor.ArmorMaterial turtleArmor = EnumHelper.addArmorMaterial("Turtle", "turtlemod:turtle", 5, new int[]{1, 3, 2, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
    public static final TurtleItem turtleLeather = new TurtleItem();
    public static ItemTurtleArmor turtleHelmet = new ItemTurtleArmor(EntityEquipmentSlot.HEAD);
    public static ItemTurtleArmor turtleChestplate = new ItemTurtleArmor(EntityEquipmentSlot.CHEST);
    public static ItemTurtleArmor turtleLeggings = new ItemTurtleArmor(EntityEquipmentSlot.LEGS);
    public static ItemTurtleArmor turtleBoots = new ItemTurtleArmor(EntityEquipmentSlot.FEET);

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        turtleLeather.setUnlocalizedName("turtleLeather");
        turtleHelmet.setUnlocalizedName("turtleHelmet");
        turtleChestplate.setUnlocalizedName("turtleChestplate");
        turtleLeggings.setUnlocalizedName("turtleLeggings");
        turtleBoots.setUnlocalizedName("turtleBoots");
        GameRegistry.register(turtleLeather, new ResourceLocation("turtlemod", "turtleLeather"));
        GameRegistry.register(turtleHelmet, new ResourceLocation("turtlemod", "turtleHelmet"));
        GameRegistry.register(turtleChestplate, new ResourceLocation("turtlemod", "turtleChestplate"));
        GameRegistry.register(turtleLeggings, new ResourceLocation("turtlemod", "turtleLeggings"));
        GameRegistry.register(turtleBoots, new ResourceLocation("turtlemod", "turtleBoots"));

    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {

    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}

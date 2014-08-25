package net.probossgamers.turtlemod.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.probossgamers.turtlemod.ContentHandler;
import net.probossgamers.turtlemod.TurtleMod;
import net.probossgamers.turtlemod.entity.monster.*;
import net.probossgamers.turtlemod.entity.passive.EntityHelloGuy;
import net.probossgamers.turtlemod.entity.passive.EntityTurtle;

public class ModEntities implements ContentHandler.IContentProvider
{
    public void init()
    {
        registerEntity(EntityTurtle.class, "turtle", 0x1e8100, 0x7d3900, 10, 2, 4, EnumCreatureType.creature);
        registerEntity(EntityZombieTurtle.class, "zombieTurtle", 0x008344, 0x823F02, 10, 2, 4, EnumCreatureType.monster);
        registerEntity(EntityMineTurtle.class, "mineTurtle", 0x1e8100, 0xef0000, 10, 2, 4, EnumCreatureType.creature);
        registerEntity(EntityHelloGuy.class, "helloGuy", 0xffffff, 0xf90000, 10, 2, 4, EnumCreatureType.creature);
        registerEntity(EntityDonatello.class, "donatello", 0x1e8100, 0x640087, 10, 1, 1, EnumCreatureType.creature);
        registerEntity(EntityRaphael.class, "raphael", 0x1e8100, 0xec0100, 10, 1, 1, EnumCreatureType.creature);
        registerEntity(EntityLeonardo.class, "leonardo", 0x1e8100, 0x002dff, 10, 1, 1, EnumCreatureType.creature);
        registerEntity(EntityMichelangelo.class, "michelangelo", 0x1e8100, 0xff6900, 10, 1, 1, EnumCreatureType.creature);
        registerEntity(EntityFootNinja.class, "footNinja", 0x000000, 0x4D4D58, 10, 5, 9, EnumCreatureType.creature);
    }

    public static void registerEntity(Class<? extends EntityLiving> entityClass, String name, int par1, int par2, int par3, int par4, int par5, EnumCreatureType CreatureType)
    {
        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID, par1, par2);
        EntityRegistry.registerModEntity(entityClass, name, entityID, TurtleMod.instance, 64, 1, true);
        EntityRegistry.addSpawn(entityClass, par3, par4, par5, CreatureType,
                BiomeGenBase.beach,
                BiomeGenBase.frozenRiver,
                BiomeGenBase.iceMountains,
                BiomeGenBase.icePlains,
                BiomeGenBase.plains,
                BiomeGenBase.river,
                BiomeGenBase.swampland,
                BiomeGenBase.taiga,
                BiomeGenBase.taigaHills
        );
    }
}

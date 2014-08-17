package net.probossgamers.turtlemod.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class RegisterBlocks {

    public static Block turtleShell;

    public static void blockInit() {
        turtleShell = new BlockTurtleShell();
        GameRegistry.registerBlock(turtleShell, "blockTurtleShell");
    }
}

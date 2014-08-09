package net.probossgamers.TurtleMod.item;

import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemTurtleLeather extends Item {
    public ItemTurtleLeather() {
        super();
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setTextureName("turtlemod:turtleLeather");
    }
}

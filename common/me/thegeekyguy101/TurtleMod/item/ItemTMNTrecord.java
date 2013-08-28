package me.thegeekyguy101.TurtleMod.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.thegeekyguy101.TurtleMod.TurtleMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockJukeBox;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTMNTrecord extends ItemRecord {
	
	private static final Map records = new HashMap();

	public final String recordSound;
	public final String recordName;

	public ItemTMNTrecord(int id, String sound, String name) {
		super(id, sound);
		this.recordSound = sound;
		this.recordName = name;
		this.maxStackSize = 1;
		this.setCreativeTab(TurtleMod.turtleTab);
		records.put(sound, this);
	}

	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int par1) {
		return this.itemIcon;
	}

	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		if (par3World.getBlockId(par4, par5, par6) == Block.jukebox.blockID && par3World.getBlockMetadata(par4, par5, par6) == 0) {
			if (par3World.isRemote) {
				return true;
			} else {
				((BlockJukeBox) Block.jukebox).insertRecord(par3World, par4, par5, par6, par1ItemStack);
				par3World.playAuxSFXAtEntity((EntityPlayer) null, 1005, par4, par5, par6, this.itemID);
				--par1ItemStack.stackSize;
				return true;
			}
		} else {
			return false;
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("");
	}

	@SideOnly(Side.CLIENT)
	public String getRecordTitle() {
		return this.recordName;
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@SideOnly(Side.CLIENT)
	public static ItemTMNTrecord getRecord(String par0Str) {
		return (ItemTMNTrecord) records.get(par0Str);
	}
}

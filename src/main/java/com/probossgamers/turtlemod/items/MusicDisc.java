package com.probossgamers.turtlemod.items;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.probossgamers.turtlemod.ModInfo;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MusicDisc extends ItemRecord
{
 private static final Map<String, MusicDisc> records = new HashMap<String, MusicDisc>();


 public final String recordName;


private SoundEvent sound;


 public MusicDisc(String recordName, SoundEvent soundIn)
 {
 super(recordName, soundIn);


 this.recordName = recordName;
 this.maxStackSize = 1;
 this.sound = soundIn;
 

 records.put(recordName, this);
 }



 public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
 {
     IBlockState iblockstate = worldIn.getBlockState(pos);

     if (iblockstate.getBlock() == Blocks.JUKEBOX && !((Boolean)iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue())
     {
         if (!worldIn.isRemote)
         {
             ItemStack itemstack = player.getHeldItem(hand);
             ((BlockJukebox)Blocks.JUKEBOX).insertRecord(worldIn, pos, iblockstate, itemstack);
             worldIn.playEvent((EntityPlayer)null, 1010, pos, Item.getIdFromItem(this));
             itemstack.shrink(1);
             player.addStat(StatList.RECORD_PLAYED);
         }

         return EnumActionResult.SUCCESS;
     }
     else
     {
         return EnumActionResult.PASS;
     }
 }


 @Override
 public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List<String> par3List, boolean par4)
 {
 par3List.add(this.getRecordNameLocal());
 }

 @Override
 public EnumRarity getRarity(ItemStack itemStack)
 {
 return EnumRarity.RARE;
 }


 public static MusicDisc getRecord(String par0Str)
 {
 return (MusicDisc)records.get(par0Str);
 }


 @Override
 public ResourceLocation getRecordResource(String name)
 {
 return new ResourceLocation(ModInfo.MODID + ":" + name);
 }
}
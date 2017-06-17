package com.probossgamers.turtlemod.blocks;

import com.probossgamers.turtlemod.TurtleMain;
import com.probossgamers.turtlemod.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPizza extends Block {

	public static AxisAlignedBB COLLISION_BOX_FULL = new AxisAlignedBB(0.0625 * 1, 0, 0.0625 * 1, 0.0625 * 15, 0.0625 / 2, 0.0625 * 15);
    public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 3);
	
	public BlockPizza(String unlocalizedName) {
		super(Material.CAKE);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(TurtleMain.tabCustom);
        this.setHardness(.8f);
        this.setResistance(.8f);
	}
	
	@Override
	public boolean isFullBlock(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return COLLISION_BOX_FULL;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos) {
		return COLLISION_BOX_FULL;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			if(playerIn.isSneaking()) {
				ItemStack stack = new ItemStack(ModItems.pizzaSlice, 1);
                if (!playerIn.inventory.addItemStackToInventory(stack)) {
                    // Not possible. Throw item in the world
                    EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY()+1, pos.getZ(), stack);
                    worldIn.spawnEntity(entityItem);
                } else {
                    playerIn.openContainer.detectAndSendChanges();
                }
			} else {
				if (playerIn.canEat(false)) {
					playerIn.addStat(TurtleMain.PIZZA_EATEN);
					playerIn.getFoodStats().addStats(2, 0.1F);
				}
			}
			int i = ((Integer)state.getValue(BITES)).intValue();
			
	        if (i < 3) {
	            worldIn.setBlockState(pos, state.withProperty(BITES, Integer.valueOf(i + 1)));
	        } else {
	            worldIn.setBlockToAir(pos);
	        }
		return true;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
        return ((Integer)state.getValue(BITES)).intValue();
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(BITES, Integer.valueOf(meta));
    }

	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {BITES});
    }
	
}

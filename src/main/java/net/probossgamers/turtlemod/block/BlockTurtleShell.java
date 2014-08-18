package net.probossgamers.turtlemod.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.probossgamers.turtlemod.client.render.block.BlockTurtleShellRenderer;
import net.probossgamers.turtlemod.tileentity.TileEntityTurtleShell;

import java.util.List;

public class BlockTurtleShell extends BlockContainer implements ICustomHighlightedBlock
{
    public float pixel = 0.0625f;
    public AxisAlignedBB[] bounds = new AxisAlignedBB[]
    {
        AxisAlignedBB.getBoundingBox(4 * pixel, 0 * pixel, 4 * pixel, 1 - (4 * pixel), 4 * pixel, 1 - (4 * pixel)),
        AxisAlignedBB.getBoundingBox(5 * pixel, 4 * pixel, 5 * pixel, 1 - (5 * pixel), 5 * pixel, 1 - (5 * pixel))
    };

    public BlockTurtleShell()
    {
        super(Material.glass);
        setBlockName("shellBlock");
        setHardness(3f);
        setBlockBounds(4 * pixel, 0 * pixel, 4 * pixel, 1 - (4 * pixel), 5 * pixel, 1 - (4 * pixel));
        setStepSound(stepSound);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public int getRenderType()
    {
        return BlockTurtleShellRenderer.id;
    }

    public TileEntity createNewTileEntity(World w, int m)
    {
        return new TileEntityTurtleShell();
    }

    public AxisAlignedBB[] getBoxes(World world, int x, int y, int z, EntityPlayer player)
    {
        return bounds;
    }

    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB box, List list, Entity entity)
    {
        for (AxisAlignedBB aabb : bounds)
        {
            AxisAlignedBB aabbTmp = aabb.getOffsetBoundingBox(x, y, z);
            if (box.intersectsWith(aabbTmp)) list.add(aabbTmp);
        }
    }

    public MovingObjectPosition collisionRayTrace(World world, int x, int y, int z, Vec3 origin, Vec3 direction)
    {
       MovingObjectPosition closest = null;
        for (AxisAlignedBB aabb : bounds)
        {
            MovingObjectPosition mop = aabb.getOffsetBoundingBox(x, y, z).calculateIntercept(origin, direction);
            if (mop != null)
            {
                if (closest != null && mop.hitVec.distanceTo(origin) < closest.hitVec.distanceTo(origin)) closest = mop;
                else closest = mop;
            }
        }
        if (closest != null)
        {
            closest.blockX = x;
            closest.blockY = y;
            closest.blockZ = z;
        }
        return closest;
    }
}

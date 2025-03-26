package com.infinityitems.items;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBucket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidFinite;

import java.util.List;

public class ItemSpaceBucket extends ItemBucket {
    private Block isFull;
    public ItemSpaceBucket(String name, Block b) {
        super(b);
        this.isFull = b;
        setUnlocalizedName(name + "_bucket");
        setMaxStackSize(1);
        setCreativeTab(InfinityItemsCore.tab);
        setTextureName(InfinityItemsCore.MODID + ":" + name + "_bucket");
    }

    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        boolean flag = this.isFull == Blocks.air;
        float var4 = 1.0F;
        double var10000 = player.prevPosX + (player.posX - player.prevPosX) * (double)var4;
        double trueY = player.prevPosY + (player.posY - player.prevPosY) * (double)var4 + 1.62D - (double)player.yOffset;
        var10000 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)var4;

        MovingObjectPosition position = this.getMovingObjectPositionFromPlayer(world, player, flag);
        if (position == null) {
            return stack;
        } else {
            if (position.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
                int clickX = position.blockX;
                int clickY = position.blockY;
                int clickZ = position.blockZ;
                if (!world.canMineBlock(player, clickX, clickY, clickZ)) {
                    return stack;
                }

                if (position.sideHit == 0) {
                    --clickY;
                }

                if (position.sideHit == 1) {
                    ++clickY;
                }

                if (position.sideHit == 2) {
                    --clickZ;
                }

                if (position.sideHit == 3) {
                    ++clickZ;
                }

                if (position.sideHit == 4) {
                    --clickX;
                }

                if (position.sideHit == 5) {
                    ++clickX;
                }

                if (!player.canPlayerEdit(clickX, clickY, clickZ, position.sideHit, stack)) {
                    return stack;
                }

                if (this.tryPlaceContainedLiquid(world, clickX, clickY, clickZ, stack.getItemDamage()) && !player.capabilities.isCreativeMode) {
                    return new ItemStack(Items.bucket);
                }
            }

            return stack;
        }
    }

    public boolean tryPlaceContainedLiquid(World world, int clickX, int clickY, int clickZ, int type) {
        if (isAirBlock(world, clickX, clickY, clickZ) && world.getBlock(clickX, clickY, clickZ).getMaterial().isSolid()) {
            return false;
        } else {
            Material material = world.getBlock(clickX, clickY, clickZ).getMaterial();
            boolean flag = !material.isSolid();

            if (!world.isAirBlock(clickX, clickY, clickZ) && !flag) {
                return false;
            } else {
                if (!world.isRemote && flag && !material.isLiquid()) {
                    world.func_147480_a(clickX, clickY, clickZ, true);
                }

                world.setBlock(clickX, clickY, clickZ, this.isFull, 0, 3);
                return true;
            }
        }
    }



    public static boolean isAirBlock(World access, int x, int y, int z) {
        return access.isAirBlock(x, y, z);
    }



}

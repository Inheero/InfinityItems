package com.infinityitems.trees;

import com.infinityitems.InfinityItemsCore;
import com.infinityitems.worldgen.WorldGenCustomTreeTwo;
import net.minecraft.block.BlockSapling;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCustomSaplingTwo  extends BlockSapling {
    private IIcon[] icons;

    public BlockCustomSaplingTwo() {
        this.setBlockName("customSaplingTwo");
        this.setBlockTextureName(InfinityItemsCore.MODID +":custom_sapling_two");
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setHardness(0.0F);
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (!world.isRemote) {
            super.updateTick(world, x, y, z, rand);

            if (world.getBlockLightValue(x, y + 1, z) >= 9 && rand.nextInt(7) == 0) {
                this.func_149879_c(world, x, y, z, rand);
            }
        }
    }

    public void func_149879_c(World world, int x, int y, int z, Random rand) {
        if (world.getBlock(x, y, z) == this) { // Проверяем только этот саженец
            generateTree(world, x, y, z, rand);
        }
    }

    public void generateTree(World world, int x, int y, int z, Random rand) {
        world.setBlockToAir(x, y, z);
        world.setBlockToAir(x + 1, y, z);
        world.setBlockToAir(x, y, z + 1);
        world.setBlockToAir(x + 1, y, z + 1);

        // Теперь передаем два блока: customLog и customLeaves
        WorldGenCustomTreeTwo treeGen = new WorldGenCustomTreeTwo(InfinityItemsCore.customLogTwo, InfinityItemsCore.customLeavesTwo, true);

        if (!treeGen.generate(world, rand, x, y, z)) {
            world.setBlock(x, y, z, this);
            world.setBlock(x + 1, y, z, this);
            world.setBlock(x, y, z + 1, this);
            world.setBlock(x + 1, y, z + 1, this);
        }
    }

    @Override
    public void registerBlockIcons(IIconRegister reg) {
        this.icons = new IIcon[1];
        this.icons[0] = reg.registerIcon(this.getTextureName());
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return this.icons[0];
    }

    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
    }
}


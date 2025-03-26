package com.infinityitems.fluids;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class SpaceFluid extends BlockFluidClassic {
    public SpaceFluid(Fluid fluid) {
        super(fluid, Material.lava);
        fluid.setBlock(this);
        setBlockName("fluid_space");
        setCreativeTab(InfinityItemsCore.tab);
        setBlockTextureName(InfinityItemsCore.MODID + ":space_still");
    }

    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        super.onEntityCollidedWithBlock(world, x, y, z, entity);
//        if (entity instanceof EntityLivingBase) {
//            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(IEPotions.sticky.id, 40, 2, true));
//
//        }

    }
    /**
     * Данный метод вызывается для проверки возможности вытеснения блоков жидкостью(как это делает вода с рычагами, редстоуном и т.п.)
     *
     * @param world     мир в котором установлен блок.
     * @param x         позиция блока по X координате.
     * @param y         позиция блока по Yextends BlockFluidClassic {
     *     public DiamondFluid(Fluid fluid) {
     *         super(fluid, Material.lava);
     *         fluid.setBlock(this);
     *         setBlockName("fluid_space");
     *         setCreativeTab(InfinityItemsCore.tab);
     *         setBlockTextureName(InfinityItemsCore.MODID + ":space_still");
     *     }
     *
     *     public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
     *         super.onEntityCollidedWithBlock(world, x, y, z, entity);
     * //        if (entity instanceof EntityLivingBase) {
     * //            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(IEPotions.sticky.id, 40, 2, true));
     * //
     * //        }
     *
     *     } координате.
     * @param z         позиция блока по Z координате.
     * @return Возвращает логическое значение.
     */
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        // Чтобы наша жидкость не заменяла воду, лаву или иные жидкости, добавим проверку, что материал блока не является жидкостью.
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.canDisplace(world, x, y, z);
    }

    /**
     * Данный метод вызывается при попытке вытеснить блок.
     *
     * @param world     мир в котором установлен блок.
     * @param x         позиция блока для вытеснения по X координате.
     * @param y         позиция блока для вытеснения по Y координате.
     * @param z         позиция блока для вытеснения по Z координате.
     * @return Возвращает логическое значение.
     */
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        // Чтобы наша жидкость не заменяла воду, лаву или иные жидкости, добавим проверку, что материал блока не является жидкостью.
        return !world.getBlock(x, y, z).getMaterial().isLiquid() && super.displaceIfPossible(world, x, y, z);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        super.registerBlockIcons(register);
        // Получаем переданную жидкость через конструктор и добавляем ей текстуру неподвижной и подвижной жидкости.
        getFluid().setIcons(blockIcon, register.registerIcon(InfinityItemsCore.MODID + ":space_flow"));
    }
}





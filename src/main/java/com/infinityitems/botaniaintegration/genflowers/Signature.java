package com.infinityitems.botaniaintegration.genflowers;

import com.infinityitems.InfinityItemsCore;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import vazkii.botania.api.subtile.signature.SubTileSignature;

public class Signature extends SubTileSignature {
    String name;
    IIcon icon;

    public Signature(String nombre) {
        name = nombre;
    }

    @Override
    public void registerIcons(IIconRegister reg) {
        icon = reg.registerIcon(InfinityItemsCore.MODID + ":flowers/" + name);
    }

    @Override
    public IIcon getIconForStack(ItemStack item) {
        return icon;
    }

    @Override
    public String getUnlocalizedNameForStack(ItemStack item) {
        return InfinityItemsCore.MODID +  ".flower." + name;
    }

    @Override
    public String getUnlocalizedLoreTextForStack(ItemStack item) {
        return "tile." + InfinityItemsCore.MODID +  ".flower." + name + ".lore";
    }
}


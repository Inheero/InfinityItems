package com.infinityitems;

import com.infinityitems.blocks.BlockBodyMechanism;
import com.infinityitems.blocks.ItemBlockBodyMechanism;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class IModBlocks {

    public static Block BODY_MECHANISM = new BlockBodyMechanism();
    public static void registerBlocks() {
        registerBlock(BODY_MECHANISM, ItemBlockBodyMechanism.class);
    }

    public static void registerBlock(Block block, Class<? extends ItemBlock> itemClass) {
        block.setCreativeTab(InfinityItemsCore.tab);
        GameRegistry.registerBlock(block, itemClass, block.getUnlocalizedName());
    }
}
package com.infinityitems.items;

import com.infinityitems.InfinityItemsCore;
import net.minecraft.item.Item;

public class ItemBedrockEmber extends Item {
    public ItemBedrockEmber() {
        setUnlocalizedName("bedrockEmber");
        this.setTextureName(InfinityItemsCore.MODID +":infinityitems_bedrock_ember");
        setCreativeTab(InfinityItemsCore.tab);
    }
}
package com.infinityitems.proxy;

import com.infinityitems.IModBlocks;
import com.infinityitems.ModItems;
import com.infinityitems.fluids.InfinityBucketHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        IModBlocks.registerBlocks();
        ModItems.registerItems();
        MinecraftForge.EVENT_BUS.register(new InfinityBucketHandler());
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

}
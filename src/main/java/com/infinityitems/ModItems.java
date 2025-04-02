package com.infinityitems;

import com.infinityitems.items.*;
import com.infinityitems.pickaxes.ItemFortunePickaxe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {

    public static final EnumRarity LEGENDARY_RARITY = EnumHelper.addRarity("infinityitems:legendary", EnumChatFormatting.RED, "Legendary");

    public static ItemCustomBukkit DIAMOND_BUCKET;
    public static ItemCustomBukkit SPACE_BUCKET;
    public static final Item TM_COMPONENT = new ItemComponent();
    public static final Item TM_TECHNOMAGIC = new ItemTechnomagic();
    public static final Item TM_WOOD = new ItemWoodBucket(Blocks.water);
    public static final Item TM_PLATE = new ItemPlate();
    public static final Item TM_INGOT = new ItemIngot();
    public static final Item TM_MIDASSA = new ItemMidassa();
    public static final Item TM_SEEDS = new ItemSeeds();
    public static final Item TM_SPLAV = new ItemSplav();
    public static final Item TM_SPLAVINGOT = new ItemSplavingot();
    public static final Item TM_SOLARCORE = new ItemSolarcore();
    public static final Item TM_PIXELFART= new ItemFortunePickaxe();

    public static void registerItems() {
        registerItem(TM_COMPONENT);
        registerItem(TM_TECHNOMAGIC);
        registerItem(TM_WOOD);
        registerItem(TM_PLATE);
        registerItem(TM_INGOT);
        registerItem(TM_MIDASSA);
        registerItem(TM_SEEDS);
        registerItem(TM_SPLAVINGOT);
        registerItem(TM_SPLAV);
        registerItem(TM_SOLARCORE);
        registerItem(TM_PIXELFART);
    }

    public static void registerItem(Item item) {
        item.setCreativeTab(InfinityItemsCore.tab);
        GameRegistry.registerItem(item, item.getUnlocalizedName());
    }
}

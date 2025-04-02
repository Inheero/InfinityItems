package com.infinityitems;

import com.infinityitems.blocks.*;
import com.infinityitems.botaniaintegration.genflowers.AsgardDandelion;
import com.infinityitems.botaniaintegration.genflowers.HelheimWeed;
import com.infinityitems.botaniaintegration.genflowers.MidgardSunflower;
import com.infinityitems.botaniaintegration.genflowers.Signature;
import com.infinityitems.enderioport.BedrockFireHandler;
import com.infinityitems.fluids.DiamondFluid;
import com.infinityitems.fluids.InfinityBucketHandler;
import com.infinityitems.fluids.SpaceFluid;
import com.infinityitems.items.ItemBedrockEmber;
import com.infinityitems.proxy.CommonProxy;
import com.infinityitems.trees.*;
import com.infinityitems.worldgen.*;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraft.block.Block;
import vazkii.botania.api.BotaniaAPI;

@Mod(modid = InfinityItemsCore.MODID, version = InfinityItemsCore.VERSION, name = InfinityItemsCore.MODNAME)
public class InfinityItemsCore {
    public static final String MODID = "infinityitems";
    public static final String VERSION = "@VERSION@";
    public static final String MODNAME = "Infinity Items";

    @Mod.Instance(MODID)
    public static InfinityItemsCore instance;

    public static CreativeTabs tab = new CreativeTabs("infinity_items_tab") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.sponge);
        }
    };

    public static final Fluid DIAMOND_FLUID = new Fluid(MODID + ":diamond").setLuminosity(15).setDensity(20000).setViscosity(2000).setTemperature(100);
    public static DiamondFluid DIAMOND;

    public static final Fluid SPACE_FLUID = new Fluid(MODID + ":space").setLuminosity(15).setDensity(20000).setViscosity(2000).setTemperature(100);
    public static SpaceFluid SPACE;

    @SidedProxy(clientSide = "com.infinityitems.proxy.ClientProxy", serverSide = "com.infinityitems.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Block rareOre;
    public static Block tungustenOre;
    public static Block lithiumOre;
    public static Block titanOre;
    public static Block vanadiumOre;
    public static Block customLog;
    public static Block customLeaves;
    public static Block customSapling;
    public static Block customSaplingTwo;
    public static Block customLogTwo;
    public static Block customLeavesTwo;
    public static Block customSaplingFree;
    public static Block customLeavesFree;
    public static Block customLogFree;
    public static Block spaceFluidBlock;
    public static Block customLeavesFo;
    public static Block customLogFo;
    public static Block customSaplingFo;
    public static Item bedrockEmber;
    public static Block berkeliumOre;
    public static Block californiumOre;
    public static Block einsteiniumOre;
    public static Block neptuniumOre;
    public static Block thoriumOre;
    public static Block customPlanks;

    private void registerSubtiles() {
        customLog = new BlockCustomLog().setCreativeTab(InfinityItemsCore.tab);
        customLeaves = new BlockCustomLeaves().setBlockName("customLeaves").setCreativeTab(InfinityItemsCore.tab);
        customSapling = new BlockCustomSapling().setBlockName("customSapling").setCreativeTab(InfinityItemsCore.tab);
        customSaplingTwo = new BlockCustomSaplingTwo().setBlockName("customSaplingTwo").setCreativeTab(InfinityItemsCore.tab);
        customLogTwo = new BlockCustomLogTwo().setCreativeTab(InfinityItemsCore.tab);
        customLeavesTwo = new BlockCustomLeavesTwo().setBlockName("customLeavesTwo").setCreativeTab(InfinityItemsCore.tab);
        customLeavesFree = new BlockCustomLeavesFree().setBlockName("customLeavesFree").setCreativeTab(InfinityItemsCore.tab);
        customLogFree = new BlockCustomLogFree().setCreativeTab(InfinityItemsCore.tab);
        customSaplingFree = new BlockCustomSaplingFree().setBlockName("customSaplingFree").setCreativeTab(InfinityItemsCore.tab);
        customLeavesFo = new BlockCustomLeavesFo().setBlockName("customLeavesFo").setCreativeTab(InfinityItemsCore.tab);
        customLogFo = new BlockCustomLogFo().setCreativeTab(InfinityItemsCore.tab);
        customSaplingFo = new BlockCustomSaplingFo().setBlockName("customSaplingFo").setCreativeTab(InfinityItemsCore.tab);

        GameRegistry.registerBlock(customLog, customLog.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(customLeaves, "customLeaves");
        GameRegistry.registerBlock(customSapling, "customSapling");
        GameRegistry.registerBlock(customSaplingTwo,"customSaplingTwo");
        GameRegistry.registerBlock(customLogTwo,customLogTwo.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(customLeavesTwo,"customLeavesTwo");
        GameRegistry.registerBlock(customSaplingFree,"customSaplingFree");
        GameRegistry.registerBlock(customLogFree,customLogFree.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(customLeavesFree,"customLeavesFree");
        GameRegistry.registerBlock(customSaplingFo,"customSaplingFo");
        GameRegistry.registerBlock(customLogFo,customLogFo.getUnlocalizedName().substring(5));
        GameRegistry.registerBlock(customLeavesFo,"customLeavesFo");

        customPlanks = new BlockCustomPlanks();
        GameRegistry.registerBlock(customPlanks, ItemCustomPlanks.class, "custom_planks");

        BotaniaAPI.registerSubTile("asgardDandelion", AsgardDandelion.class);
        BotaniaAPI.addSubTileToCreativeMenu("asgardDandelion");
        BotaniaAPI.registerSubTileSignature(AsgardDandelion.class, new Signature("asgardDandelion"));
        BotaniaAPI.registerSubTile("midgardSunflower", MidgardSunflower.class);
        BotaniaAPI.addSubTileToCreativeMenu("midgardSunflower");
        BotaniaAPI.registerSubTileSignature(MidgardSunflower.class, new Signature("midgardSunflower"));
        BotaniaAPI.registerSubTile("helheimWeed", HelheimWeed.class);
        BotaniaAPI.addSubTileToCreativeMenu("helheimWeed");
        BotaniaAPI.registerSubTileSignature(HelheimWeed.class, new Signature("helheimWeed"));
    }


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //IConfig.registerConfig(ConfigDirectory = event.getModConfigurationDirectory().getAbsolutePath() + "/InfinitySolarPanels/");
        proxy.preInit(event);
        // Жидкость должна быть зарегистрирована раньше, чем блок для которой она будет прикреплена!
        if (FluidRegistry.registerFluid(DIAMOND_FLUID)) {
            // Если конфликтов никаких нет, то регистрируем блок для жидкости, иначе ничего не делаем.
            DIAMOND = new DiamondFluid(DIAMOND_FLUID);
            GameRegistry.registerBlock(DIAMOND, "fluid_diamond");
            // Регистрировать ведро необходимо после регистрации блока жидкости и самой жидкости.
            ModItems.DIAMOND_BUCKET = InfinityBucketHandler.registryBucket("diamond", DIAMOND_FLUID);
        }
        FluidRegistry.registerFluid(DIAMOND_FLUID);

        // Жидкость должна быть зарегистрирована раньше, чем блок для которой она будет прикреплена!
        if (FluidRegistry.registerFluid(SPACE_FLUID)) {
            // Если конфликтов никаких нет, то регистрируем блок для жидкости, иначе ничего не делаем.
            SPACE= new SpaceFluid(SPACE_FLUID);
            GameRegistry.registerBlock(SPACE, "fluid_space");
            // Регистрировать ведро необходимо после регистрации блока жидкости и самой жидкости.
            ModItems.SPACE_BUCKET = InfinityBucketHandler.registryBucket("space",SPACE_FLUID);
        }
        FluidRegistry.registerFluid(SPACE_FLUID);
        spaceFluidBlock = SPACE;
        rareOre = new BlockRareOre();
        GameRegistry.registerBlock(rareOre, "rareOre");
        tungustenOre = new BlockTungstenOre();
        GameRegistry.registerBlock(tungustenOre,"tungstenOre");
        lithiumOre = new BlockLithiumOre();
        GameRegistry.registerBlock(lithiumOre,"lithiumOre");
        titanOre = new BlockTitanOre();
        GameRegistry.registerBlock(titanOre,"titanOre");
        vanadiumOre = new BlockVanadiumOre();
        GameRegistry.registerBlock(vanadiumOre,"vanadiumOre");
        berkeliumOre = new BlockBerkeliumOre();
        GameRegistry.registerBlock(berkeliumOre,"berkeliumOre");
        californiumOre = new BlockCaliforniumOre();
        GameRegistry.registerBlock(californiumOre,"californiumOre");
        einsteiniumOre = new BlockEinsteiniumOre();
        GameRegistry.registerBlock(einsteiniumOre,"einsteiniumOre");
        neptuniumOre = new BlockNeptuniumOre();
        GameRegistry.registerBlock(neptuniumOre,"neptuniumOre");
        thoriumOre = new BlockThoriumOre();
        GameRegistry.registerBlock(thoriumOre,"thoriumOre");
        registerSubtiles();
        bedrockEmber = new ItemBedrockEmber();
        GameRegistry.registerItem(bedrockEmber, "bedrock_ember");
        BedrockFireHandler handler = new BedrockFireHandler();
        MinecraftForge.EVENT_BUS.register(handler);
        FMLCommonHandler.instance().bus().register(handler);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {proxy.init(event);
        GameRegistry.registerWorldGenerator(new WorldGeneratorMultiOre(), 0);
        GameRegistry.registerWorldGenerator(new WorldGenSpaceFluidLake(InfinityItemsCore.spaceFluidBlock), 0);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
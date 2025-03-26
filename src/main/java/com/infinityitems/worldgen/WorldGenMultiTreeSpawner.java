package com.infinityitems.worldgen;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Random;

public class WorldGenMultiTreeSpawner implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        if (world.provider.dimensionId == 0) {
            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);
            int y = world.getHeightValue(x, z);

            // Проверка на биом магического леса из Thaumcraft
            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);
            if (biome.biomeName.equals("Magical Forest")) {

                if (random.nextInt(10) < 3) { // 30% шанс на спаун дерева
                    int treeType = random.nextInt(4);

                    switch (treeType) {
                        case 0:
                            new WorldGenCustomTree(
                                    InfinityItemsCore.customLog,
                                    InfinityItemsCore.customLeaves,
                                    false
                            ).generate(world, random, x, y, z);
                            break;

                        case 1:
                            new WorldGenCustomTree(
                                    InfinityItemsCore.customLogTwo,
                                    InfinityItemsCore.customLeavesTwo,
                                    false
                            ).generate(world, random, x, y, z);
                            break;

                        case 2:
                            new WorldGenCustomTree(
                                    InfinityItemsCore.customLogFree,
                                    InfinityItemsCore.customLeavesFree,
                                    false
                            ).generate(world, random, x, y, z);
                            break;

                        case 3:
                            new WorldGenCustomTree(
                                    InfinityItemsCore.customLogFo,
                                    InfinityItemsCore.customLeavesFo,
                                    false
                            ).generate(world, random, x, y, z);
                            break;

                        default:
                            break;
                    }
                }
            }
        }
    }
}


package com.infinityitems.worldgen;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class WorldGenSpaceFluidLake implements IWorldGenerator {
    private final Block fluidBlock;

    public WorldGenSpaceFluidLake(Block fluidBlock) {
        this.fluidBlock = fluidBlock;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         net.minecraft.world.chunk.IChunkProvider chunkGenerator,
                         net.minecraft.world.chunk.IChunkProvider chunkProvider) {

        if (world.provider.dimensionId == 0) { // Только в обычном мире
            int x = chunkX * 16 + random.nextInt(16);
            int z = chunkZ * 16 + random.nextInt(16);

            BiomeGenBase biome = world.getBiomeGenForCoords(x, z);

            // Проверяем биом и шанс 1 из 3 пещер
            if ((biome == BiomeGenBase.jungle || biome == BiomeGenBase.jungleHills) && random.nextInt(3) == 0) {

                // Поиск случайной высоты под землёй
                int minY = 10;
                int maxY = 40; // Ограничиваем глубину
                int y = minY + random.nextInt(maxY - minY);

                // Ищем пространство с воздухом (пещера)
                while (y > minY && world.getBlock(x, y, z) != Blocks.air) {
                    y--;
                }

                // Проверяем, что место подходит (не просто ямка в земле)
                if (world.getBlock(x, y - 1, z) != Blocks.air) {
                    generateLake(world, random, x, y, z);
                }
            }
        }
    }

    private void generateLake(World world, Random random, int x, int y, int z) {
        int depth = 2 + random.nextInt(3); // Глубина 2-4 блока
        int radius = 3 + random.nextInt(2); // Радиус 3-4 блока

        for (int dx = -radius; dx <= radius; dx++) {
            for (int dz = -radius; dz <= radius; dz++) {
                if (random.nextInt(3) != 0) { // Неровные края
                    for (int dy = 0; dy >= -depth; dy--) {
                        int lakeX = x + dx;
                        int lakeY = y + dy;
                        int lakeZ = z + dz;

                        // Проверяем, что блок внутри пещеры, чтобы не залить стены
                        Block block = world.getBlock(lakeX, lakeY, lakeZ);
                        if (block == Blocks.air || block.getMaterial().isReplaceable()) {
                            world.setBlock(lakeX, lakeY, lakeZ, fluidBlock, 0, 2);
                        }
                    }
                }
            }
        }
    }
}





package com.infinityitems.worldgen;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class WorldGeneratorMultiOre implements IWorldGenerator {

    private static class OreData {
        public final Block oreBlock;
        public final int minY;
        public final int maxY;
        public final int minVeinSize;
        public final int maxVeinSize;
        public final int veinsPerChunk;

        public OreData(Block oreBlock, int minY, int maxY, int minVeinSize, int maxVeinSize, int veinsPerChunk) {
            this.oreBlock = oreBlock;
            this.minY = minY;
            this.maxY = maxY;
            this.minVeinSize = minVeinSize;
            this.maxVeinSize = maxVeinSize;
            this.veinsPerChunk = veinsPerChunk;
        }
    }

    private final List<OreData> ores = Arrays.asList(
            new OreData(InfinityItemsCore.rareOre, 10, 46, 2, 8, 3),
            new OreData(InfinityItemsCore.tungustenOre, 5, 30, 3, 7, 4),
            new OreData(InfinityItemsCore.lithiumOre, 20, 60, 4, 10, 2),
            new OreData(InfinityItemsCore.titanOre, 15, 50, 1, 5, 5),
            new OreData(InfinityItemsCore.vanadiumOre, 12, 45, 2, 6, 3)
    );

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.dimensionId == 0) { // Только в обычном мире
            int baseX = chunkX * 16;
            int baseZ = chunkZ * 16;

            for (OreData ore : ores) {
                generateOre(ore, world, random, baseX, baseZ);
            }
        }
    }

    private void generateOre(OreData ore, World world, Random random, int baseX, int baseZ) {
        for (int i = 0; i < ore.veinsPerChunk; i++) {
            int posX = baseX + random.nextInt(16);
            int posY = ore.minY + random.nextInt(ore.maxY - ore.minY);
            int posZ = baseZ + random.nextInt(16);

            int veinSize = ore.minVeinSize + random.nextInt(ore.maxVeinSize - ore.minVeinSize + 1);
            new WorldGenMinable(ore.oreBlock, veinSize).generate(world, random, posX, posY, posZ);
        }
    }
}



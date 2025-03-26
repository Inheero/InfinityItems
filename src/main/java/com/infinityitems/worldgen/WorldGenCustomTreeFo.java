package com.infinityitems.worldgen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenCustomTreeFo extends WorldGenerator {
    private final Block logBlockFo;
    private final Block leavesBlockFo;

    public WorldGenCustomTreeFo(Block log, Block leaves, boolean notify) {
        super(notify);
        this.logBlockFo = log;
        this.leavesBlockFo = leaves;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
        int height = rand.nextInt(3) + 5;  // Генерация случайной высоты от 5 до 7 блоков

        if (y <= 0 || y + height + 1 > 256) return false;  // Проверка границ мира

        Block ground = world.getBlock(x, y - 1, z);  // Проверка земли под саженцем
        if (ground != Blocks.grass && ground != Blocks.dirt) return false;  // Если земля не трава или грязь, не генерируем

        // Генерация ствола
        for (int trunkHeight = 0; trunkHeight < height; trunkHeight++) {
            world.setBlock(x, y + trunkHeight, z, logBlockFo, 0, 2);  // Установка блока ствола
        }

        // Генерация листвы как у дуба
        // Листва будет начинаться с высоты на 3 блока ниже верха дерева и будет иметь радиус 2
        int leafHeightStart = y + height - 3;

        for (int yOffset = leafHeightStart; yOffset <= y + height; yOffset++) {
            int radius = 2;  // Радиус для листвы

            if (yOffset == y + height) {
                radius = 1;  // Верхушка дерева с радиусом 1
            }

            // Генерация листвы в радиусе
            for (int leafX = x - radius; leafX <= x + radius; leafX++) {
                for (int leafZ = z - radius; leafZ <= z + radius; leafZ++) {
                    int distance = Math.abs(leafX - x) + Math.abs(leafZ - z);
                    if (distance <= radius) {  // Генерация листвы только внутри радиуса
                        if (world.isAirBlock(leafX, yOffset, leafZ) || world.getBlock(leafX, yOffset, leafZ).isLeaves(world, leafX, yOffset, leafZ)) {
                            world.setBlock(leafX, yOffset, leafZ, leavesBlockFo, 0, 2);  // Установка листвы
                        }
                    }
                }
            }
        }
        return true;
    }
}


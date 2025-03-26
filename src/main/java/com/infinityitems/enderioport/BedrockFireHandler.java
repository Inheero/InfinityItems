package com.infinityitems.enderioport;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ml.luxinfine.events.blocks.BlockSetEvent;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import java.util.HashSet;
import java.util.Iterator;

public class BedrockFireHandler {
    private static final int CHECK_INTERVAL = 20; // проверяем раз в секунду
    private static int tickCounter = 0;
    private final HashSet<ChunkCoordinates> burningBedrocks = new HashSet<>();

    // Событие поджога бедрока
    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
            World world = event.world;
            if (world.isRemote) return; // отсекаем клиент

            Block block = world.getBlock(event.x, event.y, event.z);

            // Если бедрок и игрок держит зажигалку
            if (block == Blocks.bedrock && event.entityPlayer.getCurrentEquippedItem() != null &&
                    event.entityPlayer.getCurrentEquippedItem().getItem() == Items.flint_and_steel) {

                // Ставим огонь на блок сверху бедрока
                world.setBlock(event.x, event.y + 1, event.z, Blocks.fire);
                event.entityPlayer.swingItem();

                // Добавляем координаты
                burningBedrocks.add(new ChunkCoordinates(event.x, event.y, event.z));
            }
        }
    }

    // Проверяем потух ли огонь каждую секунду
    @SubscribeEvent
    public void onWorldTick(TickEvent.WorldTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        World world = event.world;
        if (world.isRemote) return; // опять отсечём клиент

        tickCounter++;

        if (tickCounter >= CHECK_INTERVAL) {
            tickCounter = 0;

            // Проходим по всем координатам
            Iterator<ChunkCoordinates> iterator = burningBedrocks.iterator();
            while (iterator.hasNext()) {
                ChunkCoordinates pos = iterator.next();

                // Если огонь потух сам — дропаем предмет и удаляем координаты
                if (world.getBlock(pos.posX, pos.posY + 1, pos.posZ) != Blocks.fire) {
                    world.spawnEntityInWorld(new EntityItem(world, pos.posX + 0.5, pos.posY + 1, pos.posZ + 0.5,
                            new ItemStack(InfinityItemsCore.bedrockEmber))); // Твой кастомный предмет

                    iterator.remove(); // убираем координаты
                }
            }
        }
    }
}
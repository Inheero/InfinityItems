package com.infinityitems.botaniaintegration.genflowers;

import net.minecraft.util.IIcon;
import vazkii.botania.api.BotaniaAPI;
import vazkii.botania.api.subtile.SubTileGenerating;

public class MidgardSunflower  extends SubTileGenerating {

    @Override
    public int getMaxMana() {
        return 2500000;
    }

    @Override
    public int getColor() {
        return 0x11FF00;
    }

    @Override
    public boolean canGeneratePassively() {
        return true;
    }
    @Override
    public int getDelayBetweenPassiveGeneration() {
        return 1;
    }

    @Override
    public int getValueForPassiveGeneration() {
        return 2500000;
    }

    @Override
    public IIcon getIcon(){
        return BotaniaAPI.getSignatureForName("midgardSunflower").getIconForStack(null);
    }
}


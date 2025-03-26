package com.infinityitems.items;

import com.infinityitems.InfinityItemsCore;
import com.infinityitems.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;

import java.util.List;

public class ItemMidassa extends ItemFood {
    public ItemMidassa() {
        super(20, 500F, false);
        setUnlocalizedName(InfinityItemsCore.MODID + ".midassa");
        setTextureName(InfinityItemsCore.MODID + ":midassa");
        setCreativeTab(InfinityItemsCore.tab);
    }
    public EnumRarity getRarity(ItemStack stack) {
        return ModItems.LEGENDARY_RARITY;
    }
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add(StatCollector.translateToLocal("infinityitems.tooltip.midassa"));
    }
    @Override
    protected void onFoodEaten(ItemStack stack, net.minecraft.world.World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.heal.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 6000, 1));
        player.addPotionEffect(new PotionEffect(Potion.jump.id, 6000, 1));
    }
}


package com.infinityitems.pickaxes;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.common.util.EnumHelper;

import java.util.List;

public class ItemFortunePickaxe extends ItemPickaxe {

    // Создаем новый материал для кирки
    public static final Item.ToolMaterial FORTUNE_TOOL_MATERIAL = EnumHelper.addToolMaterial("FORTUNE", 7, 15561, 20.0F, 3.0F, 10);

    public ItemFortunePickaxe() {
        super(FORTUNE_TOOL_MATERIAL);
        this.setUnlocalizedName("fortunePickaxe");
        this.setTextureName(InfinityItemsCore.MODID + ":fortune_pickaxe");
        this.setMaxStackSize(1);
        this.setCreativeTab(InfinityItemsCore.tab);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.epic;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
        list.add(StatCollector.translateToLocal("infinitymagic.tooltip.fortunepickaxe"));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        ItemStack pick = new ItemStack(this);
        pick.addEnchantment(Enchantment.fortune, 10);
        list.add(pick);
    }
}


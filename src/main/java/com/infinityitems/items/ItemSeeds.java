package com.infinityitems.items;

import com.infinityitems.InfinityItemsCore;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import java.util.List;

public class ItemSeeds extends Item {

    public static final String[] ITEMS = new String[] {
            "aluminum_seeds",
            "aluminum_seeds_x8",
            "ardit_seeds",
            "ardit_seeds_x8",
            "base_crafting_seed",
            "coal_seeds",
            "coal_seeds_x8",
            "cobalt_seeds",
            "cobalt_seeds_x8",
            "copper_seeds",
            "copper_seeds_x8",
            "diamond_seeds",
            "diamond_seeds_x8",
            "emerald_seeds",
            "emerald_seeds_x8",
            "glowstone_seeds",
            "glowstone_seeds_x8",
            "gold_seeds",
            "gold_seeds_x8",
            "iron_seeds",
            "iron_seeds_x8",
            "lapis_lazuli_seeds",
            "lapis_lazuli_seeds_x8",
            "lead_seeds",
            "lead_seeds_x8",
            "nether_quartz_seeds",
            "nether_quartz_seeds_x8",
            "nickel_seeds",
            "nickel_seeds_x8",
            "platinum_seeds",
            "platinum_seeds_x8",
            "redstone_seeds",
            "redstone_seeds_x8",
            "silver_seeds",
            "silver_seeds_x8",
            "tin_seeds",
            "tin_seeds_x8",
            "uranium_seeds",
            "uranium_seeds_x8"
    };

    @SideOnly(Side.CLIENT)
    IIcon[] icons;

    public ItemSeeds() {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("seeds");
    }


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        icons = new IIcon[ITEMS.length];
        for (int x = 0; x < ITEMS.length; x++) {
            icons[x] = ir.registerIcon(InfinityItemsCore.MODID + ":seeds/" + ITEMS[x]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icons[meta % icons.length];
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        int i = MathHelper.clamp_int(stack.getItemDamage(), 0, ITEMS.length - 1);
        return super.getUnlocalizedName() + "." + ITEMS[i];
    }

    @SuppressWarnings({ "unchecked"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for (int j = 0; j < icons.length; ++j) {
            list.add(new ItemStack(item, 1, j));
        }
    }

}


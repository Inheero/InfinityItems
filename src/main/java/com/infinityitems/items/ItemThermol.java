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

public class ItemThermol extends Item {

    public static final String[] ITEMS = new String[] {
            "coil1","coil2","coil3","coil4",
            "wire1","wire2","wire3","wire4",
            "claims1","claims2","claims3",
            "camera1","camera2","camera3","camera4",
            "cameras1","cameras2","cameras3","cameras4",
            "nottigel1","nottigel2","nottigel3","nottigel4",
            "tigel1","tigel2","tigel3","tigel4",
            "valik1","valik2","valik3","valik4",
            "valdrob1","valdrob2","valdrob3","valdrob4",
            "lezvie1","lezvie2","lezvie3","lezvie4",
    };


    @SideOnly(Side.CLIENT)
    IIcon[] icons;

    public ItemThermol() {
        this.setHasSubtypes(true);
        this.setUnlocalizedName("thermol");
    }


    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ir) {
        icons = new IIcon[ITEMS.length];
        for (int x = 0; x < ITEMS.length; x++) {
            icons[x] = ir.registerIcon(InfinityItemsCore.MODID + ":thermol/" + ITEMS[x]);
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


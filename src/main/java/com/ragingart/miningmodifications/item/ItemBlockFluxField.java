package com.ragingart.miningmodifications.item;

import com.ragingart.miningmodifications.generics.ItemBlockMM;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by MaaT on 26.09.2014.
 */
public class ItemBlockFluxField extends ItemBlockMM {
    public ItemBlockFluxField(Block p_i45328_1_) {
        super(p_i45328_1_);
    }

    @Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata) {
        return false;
    }

}

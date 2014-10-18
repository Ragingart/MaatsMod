package com.ragingart.maatsmod.container.handmachines;


import com.ragingart.maatsmod.generics.ContainerMM;
import com.ragingart.maatsmod.tileentity.handmachines.TileEntityCompactor;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class ContainerCompactor extends ContainerMM{

    public ContainerCompactor(InventoryPlayer invPlayer, TileEntity tileEntity){
        this.addSlotToContainer(new Slot((TileEntityCompactor)tileEntity, 0, 50, 22));
        this.addSlotToContainer(new Slot((TileEntityCompactor)tileEntity, 1, 110, 22));
        this.addPlayerInventory(invPlayer);
    }
}
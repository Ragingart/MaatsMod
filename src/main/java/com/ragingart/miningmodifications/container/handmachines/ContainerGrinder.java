package com.ragingart.miningmodifications.container.handmachines;


import com.ragingart.miningmodifications.generics.ContainerMM;
import com.ragingart.miningmodifications.tileentity.handmachines.TileEntityGrinder;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.tileentity.TileEntity;

public class ContainerGrinder extends ContainerMM{

    public ContainerGrinder(InventoryPlayer invPlayer, TileEntity tileEntity){
        this.addSlotToContainer(new Slot((TileEntityGrinder)tileEntity, 0, 50, 22));
        this.addSlotToContainer(new Slot((TileEntityGrinder)tileEntity, 1, 110, 22));
        this.addPlayerInventory(invPlayer);
    }
}

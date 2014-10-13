package com.ragingart.maatsmod.tileentity;

import cofh.api.energy.IEnergyContainerItem;
import com.ragingart.maatsmod.generics.TileEntityMachineMM;
import com.ragingart.maatsmod.util.RFHelper;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityDischarger extends TileEntityMachineMM {

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        if(!worldObj.isRemote)
        {
            extractContainer();
            RFHelper.transferEnergyToAdjacent(this);
        }
    }

    public boolean getHasContainer(){
        if(inventory!=null){
            if(inventory.getItem() instanceof IEnergyContainerItem){
                return true;
            }
        }
        return false;
    }

    public void extractContainer(){
        if(!worldObj.isRemote) {
            if (inventory != null && RFHelper.itemCanCharge(inventory)) {
                int transferRate = RFHelper.transferEnergyFromItem(inventory, energy);

                if (transferRate > 0 && getHasContainer()) {
                    machineHelper.setState(2);
                } else if (getHasContainer()) {
                    machineHelper.setState(1);
                }
            } else {
                machineHelper.setState(0);
            }
        }
    }


    @Override
    public int[] validPorts() {
        return new int[]{0,1,2,3};
    }

    @Override
    public boolean isWorkDone() {
        return !RFHelper.itemCanCharge(inventory);
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate){
        return 0;
    }

}

package com.ragingart.maatsmod.tileentity;

import cofh.api.energy.IEnergyContainerItem;
import com.ragingart.maatsmod.generics.TileEntityMachineMM;
import com.ragingart.maatsmod.util.MachineHelper;

public class TileEntityCharger extends TileEntityMachineMM {


    private boolean hasWork=false;

    @Override
    public void updateEntity()
    {
        super.updateEntity();
        loadContainer();
    }

    public boolean getHasContainer(){
        if(inventory!=null){
            if(inventory.getItem() instanceof IEnergyContainerItem){
                return true;
            }
        }
        return false;
    }

    public void loadContainer(){
        if(!worldObj.isRemote) {
            if (inventory != null && MachineHelper.itemNeedsCharge(inventory)) {
               hasWork=true;
               int transfered = MachineHelper.transferEnergyToItem(energy, inventory);

                if (transfered > 0 && getHasContainer()) {
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
        return !hasWork;
    }

}

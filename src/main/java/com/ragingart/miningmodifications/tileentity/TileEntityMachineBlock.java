package com.ragingart.miningmodifications.tileentity;

import com.ragingart.miningmodifications.generics.TileEntityMachineMM;

/**
 * Created by MaaT on 22.10.2014.
 */
public class TileEntityMachineBlock extends TileEntityMachineMM {
    @Override
    public int[] validPorts() {
        return new int[0];
    }

    @Override
    public boolean isWorkDone() {
        return false;
    }
}
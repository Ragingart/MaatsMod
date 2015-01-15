package com.ragingart.miningmodifications.block.machines;


import com.ragingart.miningmodifications.MiningModifications;
import com.ragingart.miningmodifications.generics.BlockMachineMM;
import com.ragingart.miningmodifications.ref.Gui;
import com.ragingart.miningmodifications.ref.Names;
import com.ragingart.miningmodifications.tileentity.machines.TileEntityRFEnergyStorage;
import com.ragingart.miningmodifications.util.CasingHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockRFEnergyStorage extends BlockMachineMM{

    public BlockRFEnergyStorage()
    {
        super(Names.Blocks.RFENERGYSTORAGE);
        this.setHardness(7.0F);
        this.setHarvestLevel("wrench", 4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iR)
    {
        mCasingHelper = new CasingHelper(iR,Names.Textures.Blocks.RFEnergyStorage.FRONT);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta){
        return new TileEntityRFEnergyStorage();
    }


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {

            if (!worldIn.isRemote && worldIn.getTileEntity(pos) instanceof TileEntityRFEnergyStorage) {
                playerIn.openGui(MiningModifications.instance, Gui.ID.RFENERGYSTORAGE.ordinal(), worldIn, pos.getX(),pos.getY(),pos.getZ());
            }
            return true;

    }
}
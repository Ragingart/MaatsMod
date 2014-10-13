package com.ragingart.maatsmod.network.messages;

import com.ragingart.maatsmod.generics.TileEntityMachineMM;
import com.ragingart.maatsmod.util.MachineHelper;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.FluidStack;

/**
 * Created by MaaT on 02.09.2014.
 */
public class MessageTileEntityMachineMM implements IMessage,IMessageHandler<MessageTileEntityMachineMM,IMessage>{

    private MachineHelper aHelper;
    private int x;
    private int y;
    private int z;
    private int energy;
    private int famount;
    private int fid;

    public MessageTileEntityMachineMM(){
        aHelper=new MachineHelper();
    }

    public MessageTileEntityMachineMM(TileEntityMachineMM te){
        x=te.xCoord;
        y=te.yCoord;
        z=te.zCoord;
        energy=te.getEnergyStored(ForgeDirection.UNKNOWN);
        aHelper=te.getMachineHelper();
        famount = te.getFluidAmount();
        fid = te.getFluidID();
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        x=buf.readInt();
        y=buf.readInt();
        z=buf.readInt();
        energy=buf.readInt();
        famount =buf.readInt();
        fid = buf.readInt();
        aHelper.setState(buf.readInt());
        aHelper.setFacing(ForgeDirection.getOrientation(buf.readInt()));
        for (int i = 0; i < 6; i++) {
            aHelper.setPort(i, buf.readInt());
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(energy);
        buf.writeInt(famount);
        buf.writeInt(fid);
        buf.writeInt(aHelper.getState());
        buf.writeInt(aHelper.getFacing().ordinal());
        for (int i = 0; i < 6; i++) {
            if(aHelper.getPort(i)==null){
                buf.writeInt(6);
            }else {
                buf.writeInt(aHelper.getPort(i).ordinal());
            }
        }
    }

    @Override
    public IMessage onMessage(MessageTileEntityMachineMM message, MessageContext ctx) {
        Minecraft aClient = FMLClientHandler.instance().getClient();
        TileEntity aTile = aClient.theWorld.getTileEntity(message.x,message.y,message.z);


        if(aTile instanceof TileEntityMachineMM){

            ((TileEntityMachineMM) aTile).setMachineHelper(message.aHelper);

            ((TileEntityMachineMM) aTile).getTank().setFluid(new FluidStack(message.fid,message.famount));

            ((TileEntityMachineMM) aTile).setEnergy(message.energy);
            aClient.theWorld.markBlockForUpdate(message.x,message.y,message.z);
        }
        return null;
    }
}

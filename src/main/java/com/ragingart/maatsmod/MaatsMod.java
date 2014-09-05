package com.ragingart.maatsmod;

import com.ragingart.maatsmod.handler.ConfigHandler;
import com.ragingart.maatsmod.handler.EventHandler;
import com.ragingart.maatsmod.handler.GuiHandler;
import com.ragingart.maatsmod.init.*;
import com.ragingart.maatsmod.network.PacketHandler;
import com.ragingart.maatsmod.proxy.IProxy;
import com.ragingart.maatsmod.ref.Reference;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid= Reference.MOD_ID,name = Reference.MOD_NAME,version = Reference.VERSION,guiFactory = Reference.GUI_FACTORY,dependencies = Reference.DEPENDENCIES)
public class MaatsMod {

    @Mod.Instance(Reference.MOD_ID)
    public static MaatsMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide=Reference.SERVER_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

        // network handler
        PacketHandler.init();
        // config
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        // register Config to Eventbus
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        // init items blocks
        ModItems.init();
        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerModels();
        //
        ModOreDict.init();
        //Recipes
        ModRecipes.init();
        //Tile Entities
        ModTiles.init();
        // gui
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        // stuff
    }

}

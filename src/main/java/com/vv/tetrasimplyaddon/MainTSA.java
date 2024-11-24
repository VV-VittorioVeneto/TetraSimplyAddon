package com.vv.tetrasimplyaddon;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dev.architectury.platform.forge.EventBuses;


@Mod(MainTSA.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class MainTSA
{
    public static final String MOD_ID = "tetrasimplyaddon";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final boolean DEBUG = false;

    public MainTSA(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(MOD_ID, modEventBus);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new TSAEventHandler());
        TSAItemRegistry.ITEMS.register();
    }

}
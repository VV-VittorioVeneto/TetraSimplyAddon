package com.vv.tetrasimplyaddon;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import se.mickelus.tetra.items.modular.ModularItem;

public class TSASlotHandler {

    public static void applyRunicSocket(ItemStack stack){
        CompoundTag nbt = stack.getOrCreateTag();
        if(stack.getItem() instanceof ModularItem){
            final int level_runic = nbt.contains("sword/blade:tetrasimplyaddon/runicpower") ? 1 : 0;
            if(MainTSA.DEBUG) MainTSA.LOGGER.debug("runic level is: {}", level_runic);
            if(nbt.getString("runic_power").isEmpty()){
                nbt.putString("runic_power", "no_socket");
            }
            if(level_runic > 0 && nbt.getString("runic_power").contains("no_socket")){
                nbt.putString("runic_power", "socket_empty");
            }else if(level_runic == 0 && !nbt.getString("runic_power").contains("no_socket")){
                nbt.putString("runic_power", "no_socket");
            }
        }
    }

    public static void applyNetherSocket(ItemStack stack){
        CompoundTag nbt = stack.getOrCreateTag();
        if(stack.getItem() instanceof ModularItem){
            final int level_nether = nbt.contains("sword/blade:tetrasimplyaddon/netherpower") ? 1 : 0;
            if(MainTSA.DEBUG) MainTSA.LOGGER.debug("nether level is: {}", level_nether);
            if(nbt.getString("nether_power").isEmpty()){
                nbt.putString("nether_power", "no_socket");
            }
            if(level_nether > 0 && nbt.getString("nether_power").contains("no_socket")){
                nbt.putString("nether_power", "socket_empty");
            }else if(level_nether == 0 && !nbt.getString("nether_power").contains("no_socket")){
                nbt.putString("nether_power", "no_socket");
            }
        }
    }
}

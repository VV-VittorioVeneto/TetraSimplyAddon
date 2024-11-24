package com.vv.tetrasimplyaddon;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.sweenus.simplyswords.item.ModToolMaterial;
import net.sweenus.simplyswords.item.RunicSwordItem;
import net.sweenus.simplyswords.item.UniqueSwordItem;

public class TSAItemRegistry {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MainTSA.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<UniqueSwordItem> UNIQUE_TRANS = ITEMS.register("unique_trans",
            () -> new UniqueSwordItem(ModToolMaterial.UNIQUE, 1, 1, (new Item.Properties()))) ;

    public static final RegistrySupplier<RunicSwordItem> RUNIC_TRANS = ITEMS.register("runic_trans",
            () -> new RunicSwordItem(ModToolMaterial.RUNIC, 1, 1, (new Item.Properties())));
}
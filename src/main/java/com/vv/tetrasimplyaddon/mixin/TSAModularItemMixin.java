package com.vv.tetrasimplyaddon.mixin;

import static com.vv.tetrasimplyaddon.TSAItemRegistry.UNIQUE_TRANS;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import com.vv.tetrasimplyaddon.MainTSA;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import se.mickelus.tetra.items.modular.ItemModularHandheld;
import se.mickelus.tetra.items.modular.ModularItem;

@Mixin(ItemModularHandheld.class)
public class TSAModularItemMixin extends ModularItem {
    public TSAModularItemMixin(Item.Properties properties) {
        super(properties);
    }

    @Unique
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag){
        super.appendHoverText(stack, world, tooltip, flag);
        if(MainTSA.DEBUG)MainTSA.LOGGER.debug("appendHoverTextMixin init.");
        UNIQUE_TRANS.get().appendHoverText(stack, world, tooltip, flag);
    }
}

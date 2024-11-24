package com.vv.tetrasimplyaddon;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.ItemStackedOnOtherEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import se.mickelus.tetra.items.modular.ItemModularHandheld;
import static com.vv.tetrasimplyaddon.TSAItemRegistry.RUNIC_TRANS;
import static com.vv.tetrasimplyaddon.TSAItemRegistry.UNIQUE_TRANS;

public class TSAEventHandler {

    @SubscribeEvent
    public void TSAonInteract(ItemStackedOnOtherEvent event){
        final Player player = event.getPlayer();
        final ItemStack otherStack = event.getCarriedItem();
        final ItemStack stack = event.getStackedOnItem();

        if(otherStack.getItem() instanceof ItemModularHandheld){
            update(otherStack);
        }
        if(stack.getItem() instanceof ItemModularHandheld){
            update(stack);
        }

        if (stack.getOrCreateTag().getString("runic_power").equals("socket_empty") || stack.getOrCreateTag().getString("nether_power").equals("socket_empty")) {
            String netherPowerSelection;
            if (otherStack.getItem().toString().contains("runefused_gem")) {
                netherPowerSelection = otherStack.getOrCreateTag().getString("runic_power");
                stack.getOrCreateTag().putString("runic_power", netherPowerSelection);
                player.level().playSound(null, player, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                otherStack.shrink(1);
            } else if (otherStack.getItem().toString().contains("netherfused_gem")) {
                netherPowerSelection = otherStack.getOrCreateTag().getString("nether_power");
                stack.getOrCreateTag().putString("nether_power", netherPowerSelection);
                player.level().playSound(null, player, SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 1.0F, 1.0F);
                otherStack.shrink(1);
            }
        }
    }


    @SubscribeEvent
    public void TSAonLivingEntityHurt(LivingHurtEvent event){
        final Entity attacker = event.getSource().getEntity();
        final LivingEntity target = event.getEntity();
        if(attacker instanceof final LivingEntity livingentity){
            final ItemStack stack = livingentity.getMainHandItem();
            if(stack.getItem() instanceof ItemModularHandheld){
                UNIQUE_TRANS.get().hurtEnemy(stack, target, livingentity);
            }
        }
    }

    @SubscribeEvent
    public void TSAonTick(TickEvent.PlayerTickEvent event){
        if(event.phase.equals(Phase.END))return;
        final Player player = event.player;
        final ItemStack stack = player.getMainHandItem();
        final Level level = player.level();
        final int slot = 0;
        final boolean selected = true;
        if(stack.getItem() instanceof ItemModularHandheld){
            RUNIC_TRANS.get().inventoryTick(stack, level, player, slot, selected);
        }
    }

    private void update(ItemStack stack){
        TSASlotHandler.applyRunicSocket(stack);
        TSASlotHandler.applyNetherSocket(stack);
    }
}
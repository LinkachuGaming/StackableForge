package org.lonkachu.stackableforge.mixin;


import net.minecraft.network.TickablePacketListener;
import net.minecraft.network.chat.Component;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.*;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.server.network.ServerPlayerConnection;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
I wasn't the person who discovered this desync bug within minecraft, infact this bug appears to be found by Devan Kerman in his CC0 repository for stacc, the fix and code provided is original however

Effectively, this class fixes the onCreativeInventoryAction method which by default checks if the itemcount of the new stack is less than 64 rather then using the inbuilt getMaxCount variable this should have the benefit of preventing overstacking on items that stack to less then 64 to begin with
 */

@Mixin(ServerGamePacketListenerImpl.class)
public abstract class ServerPlayNetworkDesyncFixMixin implements ServerPlayerConnection, TickablePacketListener, ServerGamePacketListener {

    @Shadow public ServerPlayer player;

    @Shadow private int dropSpamTickCount;

    @Inject(method = "handleSetCreativeModeSlot", at = @At ("TAIL"))
    public void onCreativeInventoryAction(ServerboundSetCreativeModeSlotPacket packet, CallbackInfo ci) {
        ItemStack itemStack = packet.getItem();
        boolean slotIsPositive = packet.getSlotNum() < 0;
        boolean isValid = itemStack.isEmpty() || itemStack.getDamageValue() >= 0 && itemStack.getCount() <= itemStack.getMaxStackSize() && !itemStack.isEmpty();
        boolean bl2 = packet.getSlotNum() >= 1 && packet.getSlotNum() <= 45; //I'm not smart enough to understand exactly what this code does,

        if(isValid && bl2) {

            this.player.inventoryMenu.getSlot(packet.getSlotNum()).setByPlayer(itemStack);
            this.player.inventoryMenu.broadcastChanges();
        } else if(slotIsPositive && isValid && this.dropSpamTickCount < 200) {
            this.dropSpamTickCount += 20;
            this.player.drop(itemStack, true);
        }
    }



}

package com.lonkachu.mixin;

import com.lonkachu.stackable.Stackable;
import net.minecraft.world.item.BundleItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@BundleItemMixinFixin
/*
This class handles a major crash issue that results from bundles assuming the stack size is 64 rather than 127 or whatever custom value has been applied, this class makes some siginficant changes to how bundles work and can be a considerable problem if your mod also utilizes the bundleitem class.


 */

@Mixin(BundleItem.class)
public class BundleItemMixin {

    @Mutable
    @Shadow @Final public static int TOOLTIP_MAX_WEIGHT; //MAX_STORAGE

    @Inject(method = "<clinit>", at = @At("HEAD"))
    private static void inject(CallbackInfo ci) {
        TOOLTIP_MAX_WEIGHT = Stackable.getMaxStackCount();
    }

    //@appendTooltip
    //We need to remove the 0/64 tooltip from the bundle and replace it with a tooltip that includes the actual stacksize we defined already
    @ModifyConstant(
            method = "appendHoverText",
            constant = @Constant(intValue = 64)
    )
    private int appendTooltip(int constant)
    {
        return Stackable.getMaxStackCount();
    }


}

package com.lonkachu.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.lonkachu.stackable.Stackable;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import net.neoforged.fml.Logging;
import org.spongepowered.asm.logging.ILogger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = Container.class)
public interface InventoryStackMixin extends Clearable {

    /**
     * @author Lonk
     *
     * This needs to change the constant of 99 into the variable we want to replace as the maximum stack size,
     * technically, this might be best described as just 2.147B, but I'm unsure if this makes a significant distance
     * This rewrite is to stop us from requiring overwrites and inject and early returns that are ultimately bad for
     * mod compatibility.
     */
//    @ModifyConstant(
//            method = "getMaxStackSize()I",
//            constant = @Constant(intValue = 99)
//    )
//    default int getMaxCountPerStack(int constant) {
//        return Stackable.getMaxStackCount();
//    }
//
    @ModifyReturnValue(
            method = "getMaxStackSize()I",
            at = @At("RETURN")
    )
    default int getMaxCountPerStack(int constant)
    {
        if (constant != 99)
        {
            return constant;
        }
        return Stackable.MAX_STACK; //We ignore the original, we could do a check to ensure it was 64, however, this should always be 64, this is the base case.
    }
}

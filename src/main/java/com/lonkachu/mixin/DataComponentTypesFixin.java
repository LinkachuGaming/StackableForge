package com.lonkachu.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.lonkachu.stackable.Stackable;
import net.minecraft.core.component.DataComponents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;


@Mixin(DataComponents.class)
public class DataComponentTypesFixin {

    @ModifyExpressionValue
            (
                    method = "<clinit>",
                    at = @At(value = "CONSTANT", args = "intValue=64")
            )
    private static int getMaxCountPerStack(int original) {
        //return 128;
        return Stackable.getMaxStackCount();
    }
}

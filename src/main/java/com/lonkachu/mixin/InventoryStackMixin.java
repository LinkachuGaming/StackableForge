package com.lonkachu.mixin;

import com.lonkachu.stackable.Stackable;
import net.minecraft.world.Clearable;
import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Container.class)
public interface InventoryStackMixin extends Clearable {




    /**
     * @author Lonk
     *
     * This needs to change the constant of 99 into the variable we want to replace as the maximum stack size,
     * technically, this might be best described as just 2.147B, but I'm unsure if this makes a significant distance
     * This rewrite is to stop us from requiring overwrites and inject and early returns that are ultimately bad for
     * mod compatibility.
     */
    @ModifyConstant(
            method = "getMaxStackSize()I",
            constant = @Constant(intValue = 99)
    )
    default int getMaxCountPerStack(int constant) {
        return Stackable.getMaxStackCount();
    }


}

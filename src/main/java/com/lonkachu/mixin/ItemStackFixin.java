package com.lonkachu.mixin;

import com.lonkachu.stackable.Stackable;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/*
@ItemStackFixin
Author: Lonk
This mixin class exists to unpatch a crash that occurs if a block stack is above 99, I'm not quite sure why mojang added this
tbh, it doesn't massively impact how people
 */
@Mixin(ItemStack.class)
public class ItemStackFixin {
    @ModifyConstant
            (
                    method = "lambda$static$3(Lcom/mojang/serialization/codecs/RecordCodecBuilder$Instance;)Lcom/mojang/datafixers/kinds/App;", //This method is a Lambda, they aren't funda.
                    constant = @Constant(intValue = 99)

            )

    private static int getMaxCountPerStack(int constant) {
        return Stackable.getMaxStackCount();
    }
}

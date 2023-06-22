package org.lonkachu.stackableforge.mixin;


import net.minecraft.world.Clearable;
import net.minecraft.world.Container;

import org.lonkachu.stackableforge.StackableForge;
import org.spongepowered.asm.mixin.*;

@Mixin(Container.class)
public interface InventoryStackMixin extends Clearable {




    /**
     * @author Lonk
     * @reason effectively, I need to change this hardcoded return 64, to a return 128 (Preferably some configurable value)
     */
    @Overwrite
    default int getMaxStackSize() {
        return StackableForge.getMaxStackCount();
    }




}

package org.lonkachu.stackableforge.mixin;


import net.minecraft.world.item.Item;
import org.lonkachu.stackableforge.StackableForge;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.Properties.class)
public abstract class ItemSettingsMixin {


	@Shadow int maxStackSize;
	@Inject(at = @At("TAIL"), method = "<init>")
	private void init(CallbackInfo ci) {

		this.maxStackSize = StackableForge.getMaxStackCount();

	}


}

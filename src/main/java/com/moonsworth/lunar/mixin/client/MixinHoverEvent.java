package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.event.HoverEventBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import net.minecraft.event.HoverEvent;
import net.minecraft.util.IChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(HoverEvent.class)
public abstract class MixinHoverEvent implements HoverEventBridge {
    @Shadow
    public abstract IChatComponent getValue();

    public IChatComponentBridge bridge$getValue() {
        return (IChatComponentBridge) getValue();
    }
}

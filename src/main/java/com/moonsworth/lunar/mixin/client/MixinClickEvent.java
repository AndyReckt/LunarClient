package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.event.ClickEventBridge;
import net.minecraft.event.ClickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClickEvent.class)
public abstract class MixinClickEvent implements ClickEventBridge {

    @Shadow
    public abstract String getValue();

    public String bridge$getValue() {
        return getValue();
    }
}

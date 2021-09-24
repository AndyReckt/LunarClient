package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiButtonBridge;
import net.minecraft.client.gui.GuiButton;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiButton.class)
public abstract class MixinGuiButton implements GuiButtonBridge {
    public MixinGuiButton() {
    }
}

package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiConfirmOpenLinkBridge;
import net.minecraft.client.gui.GuiConfirmOpenLink;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiConfirmOpenLink.class)
public abstract class MixinGuiConfirmOpenLink implements GuiConfirmOpenLinkBridge {
    public MixinGuiConfirmOpenLink() {
    }
}

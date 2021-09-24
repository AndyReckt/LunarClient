package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDownloadTerrain;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiDownloadTerrain.class)
public abstract class MixinGuiDownloadTerrain extends GuiScreen implements GuiScreenBridge {

    public long screenCreatedAt;

    public MixinGuiDownloadTerrain() {
    }

    public void impl$initGui(CallbackInfo var1) {
    }

    public void impl$updateScreen(CallbackInfo var1) {
    }

    public void actionPerformed(GuiButton var1) {
    }
}
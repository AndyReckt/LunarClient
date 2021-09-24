package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiDisconnected.class)
public abstract class MixinGuiDisconnectedz extends GuiScreen implements GuiScreenBridge {
    @Shadow
    public int field_175353_i;
    @Shadow
    public GuiScreen parentScreen;

    public MixinGuiDisconnectedz() {
    }

    public void impl$initGui(CallbackInfo var1) {
    }

    public void impl$actionPerformed(GuiButton var1, CallbackInfo var2) {
    }
}

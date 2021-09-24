package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiIngameMenuBridge;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameMenu.class)
public abstract class MixinGuiIngameMenuz extends GuiScreen implements GuiIngameMenuBridge {
    public MixinGuiIngameMenuz() {
    }

    public void impl$onInitGui(CallbackInfo var1) {
    }

    public void impl$onActionPerformed(GuiButton var1, CallbackInfo var2) {
    }
}

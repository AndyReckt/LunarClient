package com.moonsworth.lunar.mixin.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiKeyBindingList.KeyEntry.class)
public abstract class MixinGuiKeyBindingList$KeyEntry {
    @Shadow
    public GuiButton btnChangeKeyBinding;
    @Shadow
    public KeyBinding keybinding;

    public MixinGuiKeyBindingList$KeyEntry() {
    }

    public void impl$onDrawEntry(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, CallbackInfo var9) {
    }
}

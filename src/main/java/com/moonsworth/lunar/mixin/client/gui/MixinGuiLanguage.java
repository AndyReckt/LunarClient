package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiLanguageBridge;
import net.minecraft.client.gui.GuiLanguage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Map;

@Mixin(GuiLanguage.class)
public abstract class MixinGuiLanguage implements GuiLanguageBridge {
    public MixinGuiLanguage() {
    }

    @Mixin(GuiLanguage.List.class)
    public static abstract class MixinGuiLanguage$List {
        @Shadow
        public Map languageMap;
        @Shadow
        public List langCodeList;

        public MixinGuiLanguage$List() {
        }

        public void impl$drawSlot(int var1, int var2, int var3, int var4, int var5, int var6, CallbackInfo var7) {
        }
    }


}

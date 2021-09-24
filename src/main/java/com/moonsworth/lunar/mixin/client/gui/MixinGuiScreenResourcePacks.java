package com.moonsworth.lunar.mixin.client.gui;

import net.minecraft.client.gui.*;
import net.minecraft.client.resources.ResourcePackRepository;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiScreenResourcePacks.class)
public abstract class MixinGuiScreenResourcePacks extends GuiScreen {
    @Shadow
    public List availableResourcePacks;
    @Shadow
    public List selectedResourcePacks;
    @Shadow
    public boolean changed;
    @Shadow
    public GuiResourcePackAvailable availableResourcePacksList;
    @Shadow
    public GuiResourcePackSelected selectedResourcePacksList;

    public GuiTextField searchField;
    public boolean loaded;
    public GuiButton clearGlass;
    public GuiButton redString;
    public GuiButton transBG;
    public GuiOptionButton doneButton;

    public MixinGuiScreenResourcePacks() {
    }

    public void initGui() {
    }

    public void keyTyped(char var1, int var2) {
    }

    public void updateScreen() {
    }

    public void impl$mouseClicked(int var1, int var2, int var3, CallbackInfo var4) {
    }

    public void impl$drawScreen(int var1, int var2, float var3, CallbackInfo var4) {
    }

    public void impl$drawBackground(GuiScreenResourcePacks var1, int var2) {
    }

    public void impl$actionPerformed(GuiButton var1, CallbackInfo var2) {
    }

    public void impl$onSwapPack(CallbackInfo var1) {
    }

    public void impl$beforePackSwap(CallbackInfo var1) {
    }

    // $FF: synthetic method
    public void lambda$initGui$1(ResourcePackRepository var1) {
    }

    // $FF: synthetic method
    public void lambda$null$0() {
    }
}
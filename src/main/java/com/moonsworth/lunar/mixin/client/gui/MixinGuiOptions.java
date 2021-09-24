package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiOptionsBridge;
import net.minecraft.client.gui.GuiOptions;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiOptions.class)
public abstract class MixinGuiOptions implements GuiOptionsBridge {
}
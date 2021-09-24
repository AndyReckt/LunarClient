package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiSelectWorldBridge;
import net.minecraft.client.gui.GuiSelectWorld;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiSelectWorld.class)
public abstract class MixinGuiSelectWorld implements GuiSelectWorldBridge {
}
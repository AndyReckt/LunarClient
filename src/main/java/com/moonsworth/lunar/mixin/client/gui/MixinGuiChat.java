package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiChatBridge;
import net.minecraft.client.gui.GuiChat;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GuiChat.class)
public abstract class MixinGuiChat implements GuiChatBridge {
    public MixinGuiChat() {
    }
}

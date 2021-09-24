package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.util.ChatComponentTextBridge;
import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;
import net.minecraft.util.ChatComponentStyle;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import org.spongepowered.asm.mixin.Mixin;

import java.util.List;

@Mixin(ChatComponentText.class)
public abstract class MixinChatComponentText extends ChatComponentStyle implements ChatComponentTextBridge {
    public boolean lc;

    public MixinChatComponentText() {
    }

    public boolean isLc() {
        return lc;
    }

    public void setLc(boolean var1) {
        lc = var1;
    }

    public String bridge$getRawText() {
        return getUnformattedText();
    }

    public void bridge$appendSibling(IChatComponentBridge var1) {
        appendSibling((IChatComponent) var1);
    }

    public List bridge$getSiblings() {
        return getSiblings();
    }
}
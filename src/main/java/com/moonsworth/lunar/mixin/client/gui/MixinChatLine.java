package com.moonsworth.lunar.mixin.client.gui;

import com.moonsworth.lunar.bridge.minecraft.client.gui.ChatLineBridge;
import net.minecraft.client.gui.ChatLine;
import net.minecraft.util.IChatComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ChatLine.class)
public abstract class MixinChatLine implements ChatLineBridge {
    public boolean lc;

    @Shadow
    public abstract IChatComponent getChatComponent();

    public String bridge$asLegacyString() {
        return getChatComponent().getUnformattedText();
    }

    public boolean isLc() {
        return this.lc;
    }

    public void setLc(boolean var1) {
        this.lc = var1;
    }
}

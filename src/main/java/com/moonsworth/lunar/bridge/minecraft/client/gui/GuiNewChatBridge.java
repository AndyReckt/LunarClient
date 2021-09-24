package com.moonsworth.lunar.bridge.minecraft.client.gui;

import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;

public interface GuiNewChatBridge {
    void bridge$printChatMessage(IChatComponentBridge var1);

    void bridge$sendMessageWithId(IChatComponentBridge var1, int var2);

    boolean bridge$getChatOpen();

    void bridge$deleteMessage(int var1);
}

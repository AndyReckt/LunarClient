package com.moonsworth.lunar.bridge.minecraft.client.gui;

import com.moonsworth.lunar.bridge.minecraft.util.IChatComponentBridge;

public interface GuiNewChatBridge {
    public void bridge$printChatMessage(IChatComponentBridge var1);

    public void bridge$sendMessageWithId(IChatComponentBridge var1, int var2);

    public boolean bridge$getChatOpen();

    public void bridge$deleteMessage(int var1);
}
 
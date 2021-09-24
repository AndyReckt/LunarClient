package com.moonsworth.lunar.bridge.minecraft.client.gui;

public interface GuiIngameBridge
    extends GuiBridge {
    void bridge$renderGameOverlay(float var1);

    boolean bridge$showCrosshair();

    GuiNewChatBridge bridge$getChatGUI();

    void bridge$resetTitleTimer();
}

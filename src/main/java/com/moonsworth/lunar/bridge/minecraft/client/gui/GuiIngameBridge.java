package com.moonsworth.lunar.bridge.minecraft.client.gui;

public interface GuiIngameBridge
extends GuiBridge {
    public void bridge$renderGameOverlay(float var1);

    public boolean bridge$showCrosshair();

    public GuiNewChatBridge bridge$getChatGUI();

    public void bridge$resetTitleTimer();
}
 
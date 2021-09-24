package com.moonsworth.lunar.client.feature.type.replaymod;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.websocket.packet.AbstractWebSocketPacket;

import java.util.Set;

public interface IReplayModWrapper {
    void handleMainMenuButton();

    boolean isViewingReplay();

    boolean isStopped();

    boolean isPaused();

    boolean isRecording();

    boolean showRecordingIndicator();

    ResourceLocationBridge getReplayModTexture();

    int getTextureSize();

    void onEnable();

    void onDisable();

    void handleAssetPacket(AbstractWebSocketPacket var1);

    boolean shouldRenderBrand(GuiScreenBridge var1);

    Set<KeyBindingBridge> getKeyBindings();

    void startRecording();

    void stopRecording();

    void pauseRecording();

    void resumeRecording();

    void noRecover();
}

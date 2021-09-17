package com.moonsworth.lunar.client.feature.type.replaymod;

import com.moonsworth.lunar.bridge.minecraft.client.gui.GuiScreenBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.websocket.assets.AbstractWebSocketPacket;

import java.util.Set;

public interface IReplayModWrapper {
    public void handleMainMenuButton();

    public boolean isViewingReplay();

    public boolean isStopped();

    public boolean isPaused();

    public boolean isRecording();

    public boolean showRecordingIndicator();

    public ResourceLocationBridge getReplayModTexture();

    public int getTextureSize();

    public void onEnable();

    public void onDisable();

    public void handleAssetPacket(AbstractWebSocketPacket var1);

    public boolean shouldRenderBrand(GuiScreenBridge var1);

    public Set<KeyBindingBridge> getKeyBindings();

    public void startRecording();

    public void stopRecording();

    public void pauseRecording();

    public void resumeRecording();

    public void noRecover();
}
 
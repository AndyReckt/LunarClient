package com.moonsworth.lunar.bridge.minecraft.client.settings;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GameSettingsBridge {
    public void bridge$setThirdPersonView(int var1);

    public int bridge$getThirdPersonView();

    public KeyType bridge$getScreenshotKey();

    public KeyBindingBridge bridge$keyBindForward();

    public KeyBindingBridge bridge$keyBindLeft();

    public KeyBindingBridge bridge$keyBindBack();

    public KeyBindingBridge bridge$keyBindRight();

    public KeyBindingBridge bridge$keyBindJump();

    public KeyBindingBridge bridge$keyBindAttack();

    public KeyBindingBridge bridge$keyBindUseItem();

    public KeyBindingBridge bridge$keyBindSprint();

    public KeyBindingBridge bridge$keyBindSneak();

    public KeyBindingBridge bridge$keyBindTogglePerspective();

    public KeyBindingBridge[] bridge$getKeyBindings();

    public boolean bridge$isFancyGraphics();

    public int bridge$getRenderDistance();

    public void bridge$setGamma(float var1);

    public boolean bridge$showDebugInfo();

    public Set bridge$getModelParts();

    public boolean bridge$isHideGui();

    public float bridge$getChatScale();

    public void bridge$setOptionFloatValue(int var1, float var2);

    public void bridge$setFancyGraphics(boolean var1);

    public void bridge$setKeyBindState(KeyType var1, boolean var2);

    public void bridge$unpressAllKeys();

    public List getResourcePacks();

    public void bridge$setSmoothCamera(boolean var1);

    public boolean bridge$getSmoothCamera();

    default public void bridge$updateVSync() {
    }

    default public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

    default public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
    }

    default public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return false;
    }

    default public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

    default public Optional bridge$getZoomKey() {
        return Optional.empty();
    }
}
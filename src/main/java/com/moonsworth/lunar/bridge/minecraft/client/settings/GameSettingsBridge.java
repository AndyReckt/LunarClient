package com.moonsworth.lunar.bridge.minecraft.client.settings;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface GameSettingsBridge {
    void bridge$setThirdPersonView(int var1);

    int bridge$getThirdPersonView();

    KeyType bridge$getScreenshotKey();

    KeyBindingBridge bridge$keyBindForward();

    KeyBindingBridge bridge$keyBindLeft();

    KeyBindingBridge bridge$keyBindBack();

    KeyBindingBridge bridge$keyBindRight();

    KeyBindingBridge bridge$keyBindJump();

    KeyBindingBridge bridge$keyBindAttack();

    KeyBindingBridge bridge$keyBindUseItem();

    KeyBindingBridge bridge$keyBindSprint();

    KeyBindingBridge bridge$keyBindSneak();

    KeyBindingBridge bridge$keyBindTogglePerspective();

    KeyBindingBridge[] bridge$getKeyBindings();

    boolean bridge$isFancyGraphics();

    int bridge$getRenderDistance();

    void bridge$setGamma(float var1);

    boolean bridge$showDebugInfo();

    Set bridge$getModelParts();

    boolean bridge$isHideGui();

    float bridge$getChatScale();

    void bridge$setOptionFloatValue(int var1, float var2);

    void bridge$setFancyGraphics(boolean var1);

    void bridge$setKeyBindState(KeyType var1, boolean var2);

    void bridge$unpressAllKeys();

    List getResourcePacks();

    void bridge$setSmoothCamera(boolean var1);

    boolean bridge$getSmoothCamera();

default void bridge$updateVSync() {
    }

default void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
    }

default void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
    }

default boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return false;
    }

default boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return false;
    }

default Optional<KeyBindingBridge> bridge$getZoomKey() {
        return Optional.empty();
    }
}
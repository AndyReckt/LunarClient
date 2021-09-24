package com.moonsworth.lunar.bridge.minecraft.client.settings;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

import java.util.List;

public interface KeyBindingBridge {
    KeyType bridge$getKey();

    void bridge$setKey(KeyType var1);

    boolean bridge$isKeyDown();

    String bridge$getKeyName();

    String bridge$getKeyDescription();

    void bridge$setKeyBindState(boolean var1);

    List<String> bridge$getClashesWith();

    String bridge$getCategory();
}

package com.moonsworth.lunar.bridge.minecraft.client.settings;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

import java.util.List;

public interface KeyBindingBridge {
    public KeyType bridge$getKey();

    public void bridge$setKey(KeyType var1);

    public boolean bridge$isKeyDown();

    public String bridge$getKeyName();

    public String bridge$getKeyDescription();

    public void bridge$setKeyBindState(boolean var1);

    public List<String> bridge$getClashesWith();

    public String bridge$getCategory();
}
 
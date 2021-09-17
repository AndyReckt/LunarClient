package com.moonsworth.lunar.client.setting;

import com.google.common.collect.HashBiMap;
import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.BindableSettingUIComponent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 18:12
 */
public class BindableSetting extends AbstractFeatureSetting<String> {
    public static final Set IlllIIIIIIlllIlIIlllIlIIl = new HashSet();
    public static final HashBiMap<BindableSetting, Object> lIlIlIlIlIIlIIlIIllIIIIIl = HashBiMap.create();

    public BindableSetting(String string, KeyType keyType) {
        this(null, string, keyType);
    }

    public BindableSetting(Feature feature, String string, KeyType keyType) {
        super(feature, string + "_kb", keyType.name());
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new BindableSettingUIComponent(this, uIComponent);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        try {
            KeyType keyType = KeyType.valueOf(string.toUpperCase());
            KeyBindingBridge keyBindingBridge = (KeyBindingBridge)lIlIlIlIlIIlIIlIIllIIIIIl.get(this);
            if (keyBindingBridge != null) {
                keyBindingBridge.bridge$setKey(keyType);
            } else {
                KeyBindingBridge keyBindingBridge2 = Bridge.llIlllIIIllllIIlllIllIIIl().initKeyBinding(this.f_(), Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll(keyType), "Lunar Client");
                lIlIlIlIlIIlIIlIIllIIIIIl.put(this, keyBindingBridge2);
                IlllIIIIIIlllIlIIlllIlIIl.add(this.f_());
            }
            super.lIlIlIlIlIIlIIlIIllIIIIIl(keyType.name());
            Ref.llIlIIIllIIlIllIllIllllIl();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        String string = !jsonObject.has(this.lIIlIlllIlIlIIIlllIIlIIII()) || jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).isJsonNull() ? (String)this.IIlIllIlllllllIIlIIIllIIl() : jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).getAsString();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        String string2 = string.toUpperCase();
        if (!string2.startsWith("KEY_")) {
            string2 = "KEY_" + string2;
        }
        KeyType keyType = KeyType.valueOf(string2);
        if (IlllIIIIIIlllIlIIlllIlIIl.contains(this.f_())) {
            try {
                KeyBindingBridge keyBindingBridge = (KeyBindingBridge)lIlIlIlIlIIlIIlIIllIIIIIl.get(this);
                if (keyBindingBridge != null) {
                    keyBindingBridge.bridge$setKey(keyType);
                }
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
        } else {
            KeyBindingBridge keyBindingBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initKeyBinding(this.f_(), Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIllIlIIIlIIIIIIIlllIlIll(keyType), "Lunar Client");
            lIlIlIlIlIIlIIlIIllIIIIIl.put(this, keyBindingBridge);
            IlllIIIIIIlllIlIIlllIlIIl.add(this.f_());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (((String)this.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            return;
        }
        String string = ((String)this.IllIllIIIllIIIlIlIlIIIIll()).toUpperCase();
        if (!string.startsWith("KEY_")) {
            string = "KEY_" + string;
        }
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII(), KeyType.valueOf(string).name());
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        KeyType keyType = KeyType.valueOf(((String)this.llIlllIIIllllIIlllIllIIIl()).toUpperCase());
        return Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(keyType);
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return true;
    }

    @Override
    public KeyType g_() {
        return KeyType.valueOf(((String)this.IllIllIIIllIIIlIlIlIIIIll()).toUpperCase());
    }
}


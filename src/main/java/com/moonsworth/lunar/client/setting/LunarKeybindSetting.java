package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.KeybindSettingUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Decencies
 * @since 10/07/2021 17:46
 */
public class LunarKeybindSetting extends AbstractFeatureSetting<KeyBind> {
    public static final Set<LunarKeybindSetting> lIlIlIlIlIIlIIlIIllIIIIIl = new HashSet<>();
    public boolean IlllIIIIIIlllIlIIlllIlIIl;

    public LunarKeybindSetting(String string, KeyType keyType) {
        this(null, string, new KeyBind(false, false, false, keyType), true);
    }

    public LunarKeybindSetting(Feature feature, String string, KeyType keyType) {
        this(feature, string, new KeyBind(false, false, false, keyType), true);
    }

    public LunarKeybindSetting(String string, KeyType keyType, boolean bl) {
        this(null, string, new KeyBind(false, false, false, keyType), bl);
    }

    public LunarKeybindSetting(Feature feature, String string, KeyType keyType, boolean bl) {
        this(feature, string, new KeyBind(false, false, false, keyType), bl);
    }

    public LunarKeybindSetting(String string, KeyBind keyBind) {
        this(null, string, keyBind, true);
    }

    public LunarKeybindSetting(Feature feature, String string, KeyBind keyBind) {
        this(feature, string, keyBind, true);
    }

    public LunarKeybindSetting(Feature feature, String string, KeyBind keyBind, boolean bl) {
        super(feature, string + "_kblc", keyBind);
        lIlIlIlIlIIlIIlIIllIIIIIl.add(this);
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new KeybindSettingUIComponent(this, uIComponent);
    }

    @Override
    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        if (((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() && !Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
            return false;
        }
        if (((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() && !AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
            return false;
        }
        if (((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() && !Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl)) {
            return false;
        }
        return Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl());
    }

    @Override
    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        if (((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl() && !Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.IlIlIllIIllllIllllllIIlIl)) {
            return false;
        }
        if (((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll() && !AbstractUIScreen.IIlIllIlIIllIIlIlIllllllI()) {
            return false;
        }
        return !((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl() || Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.llIIIIllIlIIlIlIIlllIllIl);
    }

    @Override
    public KeyType g_() {
        return ((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyBind keyBind) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(keyBind);
        Ref.llIlIIIllIIlIllIllIllllIl();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType, boolean bl, boolean bl2, boolean bl3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(new KeyBind(bl2, bl, bl3, keyType));
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIlllIlIlIIIlllIIlIIII(), jsonObject, true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIlIlllIlIlIIIlllIIlIIII() + "_kblc", jsonObject, false);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string, JsonObject jsonObject, boolean bl) {
        if (!(jsonObject.has(string) && !jsonObject.get(string).isJsonNull() || jsonObject.has(string + "_shift") && !jsonObject.get(string + "_shift").isJsonNull() || jsonObject.has(string + "_alt") && !jsonObject.get(string + "_alt").isJsonNull() || jsonObject.has(string + "_control") && !jsonObject.get(string + "_control").isJsonNull())) {
            if (bl) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl((KeyBind)this.IIlIllIlllllllIIlIIIllIIl());
            }
            return;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(KeyType.valueOf(jsonObject.get(string).getAsString()), jsonObject.get(string + "_shift").getAsBoolean(), jsonObject.get(string + "_alt").getAsBoolean(), jsonObject.get(string + "_control").getAsBoolean());
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        if (((KeyBind)this.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            return;
        }
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII(), ((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).llIlllIIIllllIIlllIllIIIl().name());
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII() + "_shift", ((KeyBind) this.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl());
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII() + "_control", Boolean.valueOf(((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIllIlIIIlIIIIIIIlllIlIll()));
        jsonObject.addProperty(this.lIIlIlllIlIlIIIlllIIlIIII() + "_alt", Boolean.valueOf(((KeyBind)this.llIlllIIIllllIIlllIllIIIl()).lIlIlIlIlIIlIIlIIllIIIIIl()));
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}

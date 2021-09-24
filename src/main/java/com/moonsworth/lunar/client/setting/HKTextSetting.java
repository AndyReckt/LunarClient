package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.HKTextSettingUIComponent;

/**
 * @author Decencies
 * @since 10/07/2021 18:20
 */
public class HKTextSetting extends AbstractSetting<String> {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public LunarKeybindSetting IlllIIIIIIlllIlIIlllIlIIl;

    public HKTextSetting(Feature feature, String string, String string2, KeyType keyType) {
        super(string + "_hk", string2);
        this.IlllIIIIIIlllIlIIlllIlIIl = new LunarKeybindSetting(feature, string + "_hk", keyType);
    }

    @Override
    public AbstractDescritiveSettingUIComponent getUIComponent(UIComponent uIComponent) {
        return new HKTextSettingUIComponent(this, uIComponent);
    }

    @Override
    public void read(JsonObject jsonObject) {
        if (!jsonObject.has(this.lIIlIlllIlIlIIIlllIIlIIII()) || jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).isJsonNull()) {
            return;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject(this.lIIlIlllIlIlIIIlllIIlIIII());
        this.IlllIIIIIIlllIlIIlllIlIIl.read(jsonObject2);
        if (jsonObject2.has("text") && !jsonObject2.get("text").isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2.get("text").getAsString());
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IIlIllIlllllllIIlIIIllIIl());
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(string);
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        if (!this.IllIllIIIllIIIlIlIlIIIIll().equalsIgnoreCase(this.IIlIllIlllllllIIlIIIllIIl())) {
            jsonObject2.addProperty("text", this.IllIllIIIllIIIlIlIlIIIIll());
        }
        this.IlllIIIIIIlllIlIIlllIlIIl.write(jsonObject2);
        if (!jsonObject2.entrySet().isEmpty()) {
            jsonObject.add(this.lIIlIlllIlIlIIIlllIIlIIII(), jsonObject2);
        }
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }

    public LunarKeybindSetting lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}

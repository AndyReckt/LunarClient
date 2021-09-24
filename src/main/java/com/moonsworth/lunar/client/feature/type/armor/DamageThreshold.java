package com.moonsworth.lunar.client.feature.type.armor;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum DamageThreshold implements IEnumSetting {
    VALUE("value"),
    PERCENT("percent");

    public final String lIllIlIIIlIIIIIIIlllIlIll;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String toString() {
        return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    DamageThreshold(String var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }
}
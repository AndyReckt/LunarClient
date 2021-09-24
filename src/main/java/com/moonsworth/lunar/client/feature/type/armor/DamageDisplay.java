package com.moonsworth.lunar.client.feature.type.armor;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum DamageDisplay implements IEnumSetting {
    VALUE("value"),
    PERCENT("percent"),
    NONE("none");

    public final String llIlllIIIllllIIlllIllIIIl;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public String toString() {
        return this.get(this.llIlllIIIllllIIlllIllIIIl);
    }

    DamageDisplay(String var3) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
    }
}
package com.moonsworth.lunar.client.feature.type.armor;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum ListMode implements IEnumSetting {
    lIlIlIlIlIIlIIlIIllIIIIIl("vertical"),
    IlllIIIIIIlllIlIIlllIlIIl("horizontal");

    public final String lIllIlIIIlIIIIIIIlllIlIll;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String toString() {
        return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    ListMode(String var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }
}

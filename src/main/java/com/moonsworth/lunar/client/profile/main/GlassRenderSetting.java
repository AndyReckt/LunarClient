package com.moonsworth.lunar.client.profile.main;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum GlassRenderSetting implements IEnumSetting {
    OFF("off"),
    REGULAR("regular"),
    ALL("all");

    public final String llIlllIIIllllIIlllIllIIIl;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.name();
    }

    public String toString() {
        return this.get(this.llIlllIIIllllIIlllIllIIIl, new Object[0]);
    }

    GlassRenderSetting(String var3) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
    }
}
 
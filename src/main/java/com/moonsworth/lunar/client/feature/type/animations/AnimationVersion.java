package com.moonsworth.lunar.client.feature.type.animations;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum AnimationVersion implements IEnumSetting {
    VERSION_1_7("1.7"),
    VERSION_1_8("1.8");

    public final String lIllIlIIIlIIIIIIIlllIlIll;

    AnimationVersion(String var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String toString() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }
}
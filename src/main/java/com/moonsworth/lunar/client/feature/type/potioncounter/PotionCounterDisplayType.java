package com.moonsworth.lunar.client.feature.type.potioncounter;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum PotionCounterDisplayType implements IEnumSetting {
    POTION("potion"),
    SOUP("soup");

    public final String lIllIlIIIlIIIIIIIlllIlIll;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
    }

    PotionCounterDisplayType(String var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }
}
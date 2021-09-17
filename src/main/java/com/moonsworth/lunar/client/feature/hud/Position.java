package com.moonsworth.lunar.client.feature.hud;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum Position implements IEnumSetting {
    TOP("top"),
    BOTTOM("bottom"),
    MIDDLE("middle"),
    LEFT("left"),
    RIGHT("right");

    public final String IlIlIlllllIlIIlIlIlllIlIl;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    Position(String var3) {
        this.IlIlIlllllIlIIlIlIlllIlIl = var3;
    }
}
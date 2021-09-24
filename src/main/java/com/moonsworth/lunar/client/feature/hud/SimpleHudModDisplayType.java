package com.moonsworth.lunar.client.feature.hud;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum SimpleHudModDisplayType implements IEnumSetting {
    BACKGROUND,
    BRACKETS,
    CLEAN;

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.name();
    }
}
package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public interface IEnumSetting extends I18nBridge {
    public String toString();

    public String lIlIlIlIlIIlIIlIIllIIIIIl();

    @Override
    default public String getLanguagePath() {
        return "settings";
    }
}
 
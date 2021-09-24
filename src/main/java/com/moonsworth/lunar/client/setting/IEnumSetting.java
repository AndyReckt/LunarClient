package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public interface IEnumSetting extends I18nBridge {
    String toString();

    String lIlIlIlIlIIlIIlIIllIIIIIl();

    @Override
    default String getLanguagePath() {
        return "settings";
    }
}

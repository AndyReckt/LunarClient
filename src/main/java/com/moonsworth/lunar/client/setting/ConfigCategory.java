package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public enum ConfigCategory implements I18nBridge {
    GENERAL("general"),
    PERFORMANCE("performance"),
    CONTROLS("controls");

    public final String label;

    ConfigCategory(String var3) {
        this.label = var3;
    }

    public String toString() {
        return this.label;
    }

    public String getLanguagePath() {
        return "gui.settings";
    }
}
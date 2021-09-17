package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public enum ConfigCategory implements I18nBridge {
    lIlIlIlIlIIlIIlIIllIIIIIl("general"),
    IlllIIIIIIlllIlIIlllIlIIl("performance"),
    lIllIlIIIlIIIIIIIlllIlIll("controls");

    public final String llIlllIIIllllIIlllIllIIIl;

    ConfigCategory(String var3) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
    }

    public String toString() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public String getLanguagePath() {
        return "gui.settings";
    }
}
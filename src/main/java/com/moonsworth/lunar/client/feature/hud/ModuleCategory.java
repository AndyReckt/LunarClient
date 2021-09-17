package com.moonsworth.lunar.client.feature.hud;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public enum ModuleCategory implements I18nBridge {
    lIlIlIlIlIIlIIlIIllIIIIIl("all"),
    IlllIIIIIIlllIlIIlllIlIIl("new"),
    lIllIlIIIlIIIIIIIlllIlIll("hud"),
    llIlllIIIllllIIlllIllIIIl("server"),
    llllIIlIIlIIlIIllIIlIIllI("mechanic"),
    IlIlIlllllIlIIlIlIlllIlIl("none");

    public String llIIIIIIIllIIllIlIllIIIIl;

    ModuleCategory(String var3) {
        this.llIIIIIIIllIIllIlIllIIIIl = var3;
    }

    public String toString() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public String getLanguagePath() {
        return "gui.components";
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }
}
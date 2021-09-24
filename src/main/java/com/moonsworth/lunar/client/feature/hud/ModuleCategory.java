package com.moonsworth.lunar.client.feature.hud;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;

public enum ModuleCategory implements I18nBridge {
    ALL("all"),
    NEW("new"),
    HUD("hud"),
    SERVER("server"),
    MECHANIC("mechanic"),
    NONE("none");

    public String label;

    ModuleCategory(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }

    public String getLanguagePath() {
        return "gui.components";
    }

    public String getLabel() {
        return this.label;
    }
}
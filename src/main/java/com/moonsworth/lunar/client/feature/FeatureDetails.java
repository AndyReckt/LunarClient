package com.moonsworth.lunar.client.feature;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FeatureDetails implements I18nBridge {
    public final String id;
    public List<ModuleCategory> categories;
    public boolean enabledOnCurrentVersion = true;
    public List<String> aliases;
    public List<String> originalAuthors;

    public FeatureDetails(String string) {
        this.id = string;
    }

    public FeatureDetails(String string, List<ModuleCategory> list, String ... stringArray) {
        this.id = string;
        this.categories = list;
        this.originalAuthors = Arrays.asList(stringArray);
    }

    public FeatureDetails(String string, List<ModuleCategory> list, boolean bl, List<MinecraftVersion> list2, String ... stringArray) {
        this.id = string;
        this.enabledOnCurrentVersion = bl != list2.contains(Bridge.getMinecraftVersion());
        this.categories = !this.enabledOnCurrentVersion ? new ArrayList<>() : list;
        this.originalAuthors = Arrays.asList(stringArray);
    }

    public FeatureDetails(String string, List<ModuleCategory> list, List<MinecraftVersion> list2, String ... stringArray) {
        this(string, list, false, list2, stringArray);
    }

    public FeatureDetails lIlIlIlIlIIlIIlIIllIIIIIl(List<String> list) {
        this.aliases = list;
        return this;
    }

    @Override
    public String getLanguagePath() {
        return "features." + this.id + ".details";
    }

    public String getId() {
        return this.id;
    }

    public List<ModuleCategory> getCategories() {
        return this.categories;
    }

    public boolean isEnabledOnCurrentVersion() {
        return this.enabledOnCurrentVersion;
    }

    public List<String> getAliases() {
        return this.aliases;
    }

    public List<String> getOriginalAuthors() {
        return this.originalAuthors;
    }

    public String toString() {
        return "FeatureDetails(id=" + this.getId() + ", categories=" + this.getCategories() + ", enabledOnCurrentVersion=" + this.isEnabledOnCurrentVersion() + ", aliases=" + this.getAliases() + ", originalAuthors=" + this.getOriginalAuthors() + ")";
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(List<ModuleCategory> list) {
        this.categories = list;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(List<String> list) {
        this.originalAuthors = list;
    }
}
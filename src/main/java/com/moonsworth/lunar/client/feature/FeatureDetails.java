package com.moonsworth.lunar.client.feature;

import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Decencies
 * @since 10/07/2021 17:53
 */
public class FeatureDetails
        implements I18nBridge {
    public final String lIlIlIlIlIIlIIlIIllIIIIIl;
    public List IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = true;
    public List<String> llIlllIIIllllIIlllIllIIIl;
    public List llllIIlIIlIIlIIllIIlIIllI;

    public FeatureDetails(String string) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
    }

    public FeatureDetails(String string, List list, String ... stringArray) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
        this.llllIIlIIlIIlIIllIIlIIllI = Arrays.asList(stringArray);
    }

    public FeatureDetails(String string, List list, boolean bl, List<MinecraftVersion> list2, String ... stringArray) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl != list2.contains(Bridge.IlllIIIIIIlllIlIIlllIlIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl = !this.lIllIlIIIlIIIIIIIlllIlIll ? new ArrayList<>() : list;
        this.llllIIlIIlIIlIIllIIlIIllI = Arrays.asList(stringArray);
    }

    public FeatureDetails(String string, List list, List list2, String ... stringArray) {
        this(string, list, false, list2, stringArray);
    }

    public FeatureDetails lIlIlIlIlIIlIIlIIllIIIIIl(List list) {
        this.llIlllIIIllllIIlllIllIIIl = list;
        return this;
    }

    @Override
    public String getLanguagePath() {
        return "features." + this.lIlIlIlIlIIlIIlIIllIIIIIl + ".details";
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public List IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public List<String> llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public List llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public String toString() {
        return "FeatureDetails(id=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", categories=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", enabledOnCurrentVersion=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", aliases=" + this.llIlllIIIllllIIlllIllIIIl() + ", originalAuthors=" + this.llllIIlIIlIIlIIllIIlIIllI() + ")";
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(List list) {
        this.IlllIIIIIIlllIlIIlllIlIIl = list;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(List list) {
        this.llllIIlIIlIIlIIllIIlIIllI = list;
    }
}
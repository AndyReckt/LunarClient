package com.moonsworth.lunar.client.profile.main;

import com.moonsworth.lunar.client.setting.IEnumSetting;
import org.apache.commons.lang3.text.WordUtils;

public enum EnderPortalOptions implements IEnumSetting {
    lIlIlIlIlIIlIIlIIllIIIIIl("always"),
    IlllIIIIIIlllIlIIlllIlIIl("skyBlockOnly"),
    lIllIlIIIlIIIIIIIlllIlIll("never");

    public final String llIlllIIIllllIIlllIllIIIl;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return WordUtils.capitalize(this.name().toLowerCase().replace("_", " "));
    }

    public String toString() {
        return this.get(this.llIlllIIIllllIIlllIllIIIl, new Object[0]);
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    EnderPortalOptions(String var3) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
    }
}
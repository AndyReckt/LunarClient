package com.moonsworth.lunar.client.feature.type.freelook;

import com.moonsworth.lunar.client.setting.IEnumSetting;
import org.apache.commons.lang3.text.WordUtils;

public enum FreelookPerspective implements IEnumSetting {
    THIRD("thirdPerson", 1),
    FORWARD("forward", 2),
    FIRST("firstPerson", 0);

    public String llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return WordUtils.capitalize(this.get(this.llIlllIIIllllIIlllIllIIIl));
    }

    FreelookPerspective(String var3, int var4) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
        this.llllIIlIIlIIlIIllIIlIIllI = var4;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}

package com.moonsworth.lunar.client.feature.type.crosshair;

import club.decencies.remapper.lunar.annotation.OriginalName;
import com.moonsworth.lunar.client.setting.IEnumSetting;
import org.apache.commons.lang3.text.WordUtils;

public enum CrosshairModDisplayType implements IEnumSetting
{
    CROSS("cross"),
    CIRCLE("circle"),
    ARROW("arrow");

    public final String llIlllIIIllllIIlllIllIIIl;

    @Override
    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return WordUtils.capitalize(this.get(this.llIlllIIIllllIIlllIllIIIl, new Object[0]));
    }

    CrosshairModDisplayType(String nameProxy) {
        this.llIlllIIIllllIIlllIllIIIl = nameProxy;
    }
}
 
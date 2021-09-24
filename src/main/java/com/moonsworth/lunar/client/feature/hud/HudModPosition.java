package com.moonsworth.lunar.client.feature.hud;

import com.moonsworth.lunar.client.setting.IEnumSetting;

public enum HudModPosition implements IEnumSetting {
    TOP_LEFT("top_left", Position.LEFT, Position.TOP),
    TOP_CENTER("top_center", Position.MIDDLE, Position.TOP),
    TOP_RIGHT("top_right", Position.RIGHT, Position.TOP),
    MIDDLE_LEFT("middle_left", Position.LEFT, Position.MIDDLE),
    MIDDLE_CENTER("middle_center", Position.MIDDLE, Position.MIDDLE),
    MIDDLE_RIGHT("middle_right", Position.RIGHT, Position.MIDDLE),
    BOTTOM_LEFT("bottom_left", Position.LEFT, Position.BOTTOM),
    BOTTOM_CENTER_L("bottom_center_left", Position.RIGHT, Position.BOTTOM),
    BOTTOM_CENTER_R("bottom_center_right", Position.LEFT, Position.BOTTOM),
    BOTTOM_RIGHT("bottom_right", Position.RIGHT, Position.BOTTOM);

    public final String llIIIlllIIlllIllllIlIllIl;
    public final Position lllllIllIllIllllIlIllllII;
    public final Position lllIIIIIlllIIlIllIIlIIIlI;

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public String toString() {
        return this.llIIIlllIIlllIllllIlIllIl;
    }

    public static HudModPosition lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        HudModPosition[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            HudModPosition var4 = var1[var3];
            if (var0.equals(var4.llIIIlllIIlllIllllIlIllIl)) {
                return var4;
            }
        }

        return null;
    }

    HudModPosition(String var3, Position var4, Position var5) {
        this.llIIIlllIIlllIllllIlIllIl = var3;
        this.lllllIllIllIllllIlIllllII = var4;
        this.lllIIIIIlllIIlIllIIlIIIlI = var5;
    }

    public Position IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lllllIllIllIllllIlIllllII;
    }

    public Position lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }
}
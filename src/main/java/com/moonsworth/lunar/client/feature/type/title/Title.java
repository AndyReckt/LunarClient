package com.moonsworth.lunar.client.feature.type.title;

import com.moonsworth.lunar.client.setting.ColorSetting;

public class Title {
    public final DisplayType displayType;
    public final String message;
    public final float scale;
    public final long displayTimeMs;
    public final long fadeInTimeMs;
    public final long fadeOutTimeMs;
    public final long creationTime = System.currentTimeMillis();
    public final ColorSetting color;

    public Title(String message, DisplayType displayType, float scale, long displayTimeMs, long fadeInTimeMs, long fadeOutTimeMs) {
        this(message, displayType, scale, displayTimeMs, fadeInTimeMs, fadeOutTimeMs, null);
    }

    public Title(String string, DisplayType displayType, float f, long l, long l2, long l3, ColorSetting colorSetting) {
        this.message = string;
        this.scale = f;
        this.displayType = displayType;
        this.displayTimeMs = l == 0L ? 5000L : l;
        this.fadeInTimeMs = l2;
        this.fadeOutTimeMs = l3;
        this.color = colorSetting;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return System.currentTimeMillis() < this.creationTime + this.fadeInTimeMs;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return System.currentTimeMillis() > this.creationTime + this.displayTimeMs - this.fadeOutTimeMs;
    }

    public DisplayType lIllIlIIIlIIIIIIIlllIlIll() {
        return this.displayType;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.message;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.scale;
    }

    public long IlIlIlllllIlIIlIlIlllIlIl() {
        return this.displayTimeMs;
    }

    public long llIIIIIIIllIIllIlIllIIIIl() {
        return this.fadeInTimeMs;
    }

    public long lIIIllIllIIllIlllIlIIlllI() {
        return this.fadeOutTimeMs;
    }

    public long IlllllIlIIIlIIlIIllIIlIll() {
        return this.creationTime;
    }

    public ColorSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.color;
    }

    public enum DisplayType {
        lIlIlIlIlIIlIIlIIllIIIIIl,
        IlllIIIIIIlllIlIIlllIlIIl
    }
}

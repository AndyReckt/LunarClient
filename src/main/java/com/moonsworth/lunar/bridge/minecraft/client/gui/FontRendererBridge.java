package com.moonsworth.lunar.bridge.minecraft.client.gui;

public interface FontRendererBridge {
    float bridge$getStringWidth(String var1);

    float bridge$drawString(String var1, float var2, float var3, int var4, boolean var5);

    void bridge$drawStringElements(String var1, float var2, float var3, float var4, boolean var5);

    default float lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2, int n) {
        float f3 = this.bridge$getStringWidth(string);
        return this.bridge$drawString(string, f - f3 / 2.0f, f2, n, true);
    }

    default float IlllIIIIIIlllIlIIlllIlIIl(String string, float f, float f2, int n) {
        float f3 = this.bridge$getStringWidth(string);
        return this.bridge$drawString(string, f - f3 / 2.0f, f2, n, false);
    }

    default int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return 9;
    }

    default void tick() {
    }

    default void clearCaches() {
    }
}
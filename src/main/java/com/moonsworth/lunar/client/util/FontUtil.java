package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;

public class FontUtil {
    public static int lIlIlIlIlIIlIIlIIllIIIIIl(FontRendererBridge fontRendererBridge, String string, float f, float f2, int n) {
        float f3 = fontRendererBridge.bridge$getStringWidth(string);
        return (int)fontRendererBridge.bridge$drawString(string, f - f3 / 2.0f, f2, n, true);
    }
}
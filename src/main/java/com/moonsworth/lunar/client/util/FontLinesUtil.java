package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.client.registry.FontRegistry;

import java.util.ArrayList;
import java.util.List;

public final class FontLinesUtil {
    public static List<String> lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, boolean bl) {
        f -= bl ? 15.5f : 0.0f;
        if (!string.contains(" ")) {
            return FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl(string, f);
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        float f2 = 0.0f;
        for (String string2 : string.split(" ")) {
            float f3 = f2 + (float)FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(string2);
            if (f3 < f) {
                stringBuilder.append(string2).append(" ");
                f2 = f3 + 1.0f;
                continue;
            }
            if (f2 == 0.0f) {
                arrayList.addAll(FontLinesUtil.lIlIlIlIlIIlIIlIIllIIIIIl(string2, f, false));
                continue;
            }
            arrayList.add(stringBuilder.toString().charAt(stringBuilder.length() - 1) == ' ' ? stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1) : stringBuilder.toString());
            f2 = FontRegistry.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl(string2) + 1;
            stringBuilder = new StringBuilder(string2).append(" ");
        }
        arrayList.add(stringBuilder.toString().charAt(stringBuilder.length() - 1) == ' ' ? stringBuilder.toString().substring(0, stringBuilder.toString().length() - 1) : stringBuilder.toString());
        return arrayList;
    }

    public FontLinesUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
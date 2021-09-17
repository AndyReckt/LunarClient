package com.moonsworth.lunar.client.util;

public class StringValidator {

    // todo
    public static final char[] lIlIlIlIlIIlIIlIIllIIIIIl = new char[]{};

    public static boolean lIlIlIlIlIIlIIlIIllIIIIIl(char c) {
        return c != '§' && c >= ' ' && c != '';
    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (!StringValidator.lIlIlIlIlIIlIIlIIllIIIIIl(c)) continue;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
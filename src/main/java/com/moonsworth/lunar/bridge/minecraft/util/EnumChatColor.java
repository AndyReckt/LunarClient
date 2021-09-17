package com.moonsworth.lunar.bridge.minecraft.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Decencies
 * @since 10/07/2021 16:28
 */
public enum EnumChatColor {
    lIlIlIlIlIIlIIlIIllIIIIIl('0', 0),
    IlllIIIIIIlllIlIIlllIlIIl('1', 1),
    lIllIlIIIlIIIIIIIlllIlIll('2', 2),
    llIlllIIIllllIIlllIllIIIl('3', 3),
    llllIIlIIlIIlIIllIIlIIllI('4', 4),
    IlIlIlllllIlIIlIlIlllIlIl('5', 5),
    llIIIIIIIllIIllIlIllIIIIl('6', 6),
    lIIIllIllIIllIlllIlIIlllI('7', 7),
    IlllllIlIIIlIIlIIllIIlIll('8', 8),
    llIIlIlIIIllIlIlIlIIlIIll('9', 9),
    llIIIlllIIlllIllllIlIllIl('a', 10),
    lllllIllIllIllllIlIllllII('b', 11),
    lllIIIIIlllIIlIllIIlIIIlI('c', 12),
    lIlIIIIIIlIIIllllIllIIlII('d', 13),
    llIlIIIllIIlIllIllIllllIl('e', 14),
    IllIllIIIllIIIlIlIlIIIIll('f', 15),
    IIlIllIlllllllIIlIIIllIIl('k', true),
    lIIlIlllIlIlIIIlllIIlIIII('l', true),
    llIllIlIllIlllIllIIIIllII('m', true),
    IllllllllllIlIIIlllIlllll('n', true),
    lllllIllIlIIlIIlIIIlllIlI('o', true),
    IllIIIlllIIIlIlllIlIIlIII('r');

    public static final Map<String, EnumChatColor> IIlIllIlIIllIIlIlIllllllI = new HashMap<>();
    public static final Pattern lIIIlllIIIIllllIlIIIlIIll = Pattern.compile("(?i)§[0-9A-FK-OR]");
    public final char llIIIlIllIIIIlIIIlIlIllIl;
    public final boolean llllIlIllllIlIlIIIllIlIlI;
    public final String IlIllIIlIIlIIIllIllllIIll;
    public final int lIllllIllIIlIIlIIIlIIIlII;
    public static final Pattern lIlIlIIIIIIllIlIIIIllIIII;

    EnumChatColor(char var3, int var4) {
        this.llIIIlIllIIIIlIIIlIlIllIl = var3;
        this.llllIlIllllIlIlIIIllIlIlI = false;
        this.IlIllIIlIIlIIIllIllllIIll = "§" + var3;
        this.lIllllIllIIlIIlIIIlIIIlII = var4;
    }

    EnumChatColor(char var3) {
        this(var3, false);
    }

    EnumChatColor(char var3, boolean var4) {
        this.llIIIlIllIIIIlIIIlIlIllIl = var3;
        this.llllIlIllllIlIlIIIllIlIlI = var4;
        this.IlIllIIlIIlIIIllIllllIIll = "§" + var3;
        this.lIllllIllIIlIIlIIIlIIIlII = -1;
    }

    public char lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return !this.llllIlIllllIlIlIIIllIlIlI && this != IllIIIlllIIIlIlllIlIIlIII;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.name().toLowerCase();
    }

    public String toString() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        return var0 == null ? null : lIIIlllIIIIllllIlIIIlIIll.matcher(var0).replaceAll("");
    }

    public static EnumChatColor IlllIIIIIIlllIlIIlllIlIIl(String var0) {
        return var0 == null ? null : IIlIllIlIIllIIlIlIllllllI.get(var0.toLowerCase());
    }

    public static Collection<String> lIlIlIlIlIIlIIlIIllIIIIIl(boolean var0, boolean var1) {
        ArrayList<String> var2 = new ArrayList<>();
        EnumChatColor[] var3 = values();
        EnumChatColor[] var4 = var3;
        int var5 = var3.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            EnumChatColor var7 = var4[var6];
            if ((!var7.lIllIlIIIlIIIIIIIlllIlIll() || var0) && (!var7.IlllIIIIIIlllIlIIlllIlIIl() || var1)) {
                var2.add(var7.llIlllIIIllllIIlllIllIIIl());
            }
        }

        return var2;
    }

    public static String lIllIlIIIlIIIIIIIlllIlIll(String var0) {
        Matcher var1 = lIlIlIIIIIIllIlIIIIllIIII.matcher(var0);

        String var2;
        for(var2 = ""; var1.find(); var2 = var1.group()) {
        }

        return var2;
    }

    public int llllIIlIIlIIlIIllIIlIIllI() {
        return this.lIllllIllIIlIIlIIIlIIIlII;
    }

    static {
        EnumChatColor[] var0 = values();
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            EnumChatColor var3 = var0[var2];
            IIlIllIlIIllIIlIlIllllllI.put(var3.llIlllIIIllllIIlllIllIIIl(), var3);
        }

        lIlIlIIIIIIllIlIIIIllIIII = Pattern.compile("(?i)" + '§' + "[0-9A-FR]");
    }
}
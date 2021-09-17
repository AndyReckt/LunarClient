package com.moonsworth.lunar.bridge.minecraft.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Map;

public enum ParticleType {
    lIlIlIlIlIIlIIlIIllIIIIIl("explode", 0, true),
    IlllIIIIIIlllIlIIlllIlIIl("largeexplode", 1, true),
    lIllIlIIIlIIIIIIIlllIlIll("hugeexplosion", 2, true),
    llIlllIIIllllIIlllIllIIIl("fireworksSpark", 3, false),
    llllIIlIIlIIlIIllIIlIIllI("bubble", 4, false),
    IlIlIlllllIlIIlIlIlllIlIl("splash", 5, false),
    llIIIIIIIllIIllIlIllIIIIl("wake", 6, false),
    lIIIllIllIIllIlllIlIIlllI("suspended", 7, false),
    IlllllIlIIIlIIlIIllIIlIll("depthsuspend", 8, false),
    llIIlIlIIIllIlIlIlIIlIIll("crit", 9, false),
    llIIIlllIIlllIllllIlIllIl("magicCrit", 10, false),
    lllllIllIllIllllIlIllllII("smoke", 11, false),
    lllIIIIIlllIIlIllIIlIIIlI("largesmoke", 12, false),
    lIlIIIIIIlIIIllllIllIIlII("spell", 13, false),
    llIlIIIllIIlIllIllIllllIl("instantSpell", 14, false),
    IllIllIIIllIIIlIlIlIIIIll("mobSpell", 15, false),
    IIlIllIlllllllIIlIIIllIIl("mobSpellAmbient", 16, false),
    lIIlIlllIlIlIIIlllIIlIIII("witchMagic", 17, false),
    llIllIlIllIlllIllIIIIllII("dripWater", 18, false),
    IllllllllllIlIIIlllIlllll("dripLava", 19, false),
    lllllIllIlIIlIIlIIIlllIlI("angryVillager", 20, false),
    IllIIIlllIIIlIlllIlIIlIII("happyVillager", 21, false),
    IIlIllIlIIllIIlIlIllllllI("townaura", 22, false),
    lIIIlllIIIIllllIlIIIlIIll("note", 23, false),
    llIIIlIllIIIIlIIIlIlIllIl("portal", 24, false),
    llllIlIllllIlIlIIIllIlIlI("enchantmenttable", 25, false),
    IlIllIIlIIlIIIllIllllIIll("flame", 26, false),
    lIllllIllIIlIIlIIIlIIIlII("lava", 27, false),
    lIlIlIIIIIIllIlIIIIllIIII("footstep", 28, false),
    lIIlIIIIIIlIIlIIllIlIIlII("cloud", 29, false),
    IlIIlIIlIIlIIllIIIllIIllI("reddust", 30, false),
    IIlIlIIIllIIllllIllllIlIl("snowballpoof", 31, false),
    lllllIIIIlIlllIllIIIlIIlI("snowshovel", 32, false),
    IIlllIllIlIllIllIIllIlIIl("slime", 33, false),
    lIlIIlIlllIIlIIIlIlIlIllI("heart", 34, false),
    lIIlllIIIIIlllIIIlIlIlllI("barrier", 35, false),
    IIIlIIIIIIllIIIIllIIIIlII("iconcrack_", 36, false, 2),
    IlIIIlIlIlIlIlIllIIllIIlI("blockcrack_", 37, false, 1),
    IlIlIllIIllllIllllllIIlIl("blockdust_", 38, false, 1),
    lIIlIIlllIIIIlIlllIIIIlll("droplet", 39, false),
    llIllIIIIlIIIIIIlllIllIlI("take", 40, false),
    lIlIIIIIllIIlIIlIIlIlIIlI("mobappearance", 41, true);

    public final String IIllIlIllIlIllIllIllIllII;
    public final int IlIlllIlIlllIllIIIIIIlllI;
    public final boolean llllIlIlIIIllllIIlIllIlII;
    public final int llIIIllllIIIllIIIIlIlIlll;
    public static final Map<Integer, ParticleType> IIIIIIIIIIIIIIIllllIIlIIl = Maps.newHashMap();
    public static final String[] llIIIIllIlIIlIlIIlllIllIl;

    ParticleType(String var3, int var4, boolean var5, int var6) {
        this.IIllIlIllIlIllIllIllIllII = var3;
        this.IlIlllIlIlllIllIIIIIIlllI = var4;
        this.llllIlIlIIIllllIIlIllIlII = var5;
        this.llIIIllllIIIllIIIIlIlIlll = var6;
    }

    ParticleType(String var3, int var4, boolean var5) {
        this(var3, var4, var5, 0);
    }

    public static String[] lIlIlIlIlIIlIIlIIllIIIIIl() {
        return llIIIIllIlIIlIlIIlllIllIl;
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IIllIlIllIlIllIllIllIllII;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlIlllIlIlllIllIIIIIIlllI;
    }

    public int llIlllIIIllllIIlllIllIIIl() {
        return this.llIIIllllIIIllIIIIlIlIlll;
    }

    public boolean llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIlIlIIIllllIIlIllIlII;
    }

    public boolean IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llIIIllllIIIllIIIIlIlIlll > 0;
    }

    public static ParticleType lIlIlIlIlIIlIIlIIllIIIIIl(int var0) {
        return IIIIIIIIIIIIIIIllllIIlIIl.get(var0);
    }

    static {
        ArrayList<String> var0 = Lists.newArrayList();
        ParticleType[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            ParticleType var4 = var1[var3];
            IIIIIIIIIIIIIIIllllIIlIIl.put(var4.lIllIlIIIlIIIIIIIlllIlIll(), var4);
            if (!var4.IlllIIIIIIlllIlIIlllIlIIl().endsWith("_")) {
                var0.add(var4.IlllIIIIIIlllIlIIlllIlIIl());
            }
        }

        llIIIIllIlIIlIlIIlllIllIl = var0.toArray(new String[0]);
    }
}
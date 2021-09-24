package com.moonsworth.lunar.bridge.lunar.lang;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.feature.external.ThirdPartyMod;

import java.util.function.Supplier;

public enum IlllIIIIIIlllIlIIlllIlIIl {
    lIlIlIlIlIIlIIlIIllIIIIIl("cps", () -> {
        return 5;
    }),
    IlllIIIIIIlllIlIIlllIlIIl("cpsRmb", () -> {
        return 7;
    }),
    lIllIlIIIlIIIIIIIlllIlIll("sbaVersion", () -> {
        return LunarClient.getInstance().IlIlIlIlIIIlIIlIIlllIllIl().get("skyblockaddons").lIllIlIIIlIIIIIIIlllIlIll();
    });

    public final String llIlllIIIllllIIlllIllIIIl;
    public Supplier llllIIlIIlIIlIIllIIlIIllI;

    public static String lIlIlIlIlIIlIIlIIllIIIIIl(String var0) {
        IlllIIIIIIlllIlIIlllIlIIl[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            IlllIIIIIIlllIlIIlllIlIIl var4 = var1[var3];
            if (var4.llIlllIIIllllIIlllIllIIIl.equals(var0)) {
                return var4.llllIIlIIlIIlIIllIIlIIllI.get().toString();
            }
        }

        return null;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public Supplier IlllIIIIIIlllIlIIlllIlIIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    IlllIIIIIIlllIlIIlllIlIIl(String var3) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
    }

    IlllIIIIIIlllIlIIlllIlIIl(String var3, Supplier var4) {
        this.llIlllIIIllllIIlllIllIIIl = var3;
        this.llllIIlIIlIIlIIllIIlIIllI = var4;
    }
}

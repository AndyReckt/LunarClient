package com.moonsworth.lunar.bridge.minecraft.util;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

public class KeyVersionPair {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public KeyType IlllIIIIIIlllIlIIlllIlIIl;
    public int lIllIlIIIlIIIIIIIlllIlIll;

    public KeyVersionPair(String var1, KeyType var2, int var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        this.IlllIIIIIIlllIlIIlllIlIIl = var2;
        this.lIllIlIIIlIIIIIIIlllIlIll = var3;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public KeyType IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public int lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyType var1) {
        this.IlllIIIIIIlllIlIIlllIlIIl = var1;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(int var1) {
        this.lIllIlIIIlIIIIIIIlllIlIll = var1;
    }

    public boolean equals(Object var1) {
        if (var1 == this) {
            return true;
        } else if (!(var1 instanceof KeyVersionPair)) {
            return false;
        } else {
            KeyVersionPair var2 = (KeyVersionPair)var1;
            if (!var2.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
                return false;
            } else if (this.lIllIlIIIlIIIIIIIlllIlIll() != var2.lIllIlIIIlIIIIIIIlllIlIll()) {
                return false;
            } else {
                String var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
                String var4 = var2.lIlIlIlIlIIlIIlIIllIIIIIl();
                if (var3 == null) {
                    if (var4 != null) {
                        return false;
                    }
                } else if (!var3.equals(var4)) {
                    return false;
                }

                KeyType var5 = this.IlllIIIIIIlllIlIIlllIlIIl();
                KeyType var6 = var2.IlllIIIIIIlllIlIIlllIlIIl();
                if (var5 == null) {
                    return var6 == null;
                } else return var5.equals(var6);
            }
        }
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object var1) {
        return var1 instanceof KeyVersionPair;
    }

    public int hashCode() {
        boolean var1 = true;
        byte var2 = 1;
        int var5 = var2 * 59 + this.lIllIlIIIlIIIIIIIlllIlIll();
        String var3 = this.lIlIlIlIlIIlIIlIIllIIIIIl();
        var5 = var5 * 59 + (var3 == null ? 43 : var3.hashCode());
        KeyType var4 = this.IlllIIIIIIlllIlIIlllIlIIl();
        var5 = var5 * 59 + (var4 == null ? 43 : var4.hashCode());
        return var5;
    }

    public String toString() {
        return "KeyVersionPair(keyCode=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", key=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", legacyKeyCode=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ")";
    }
}

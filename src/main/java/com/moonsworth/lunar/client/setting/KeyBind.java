package com.moonsworth.lunar.client.setting;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;

public class KeyBind {
    public boolean lIlIlIlIlIIlIIlIIllIIIIIl;
    public boolean IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;
    public KeyType llIlllIIIllllIIlllIllIIIl;

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public KeyType llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        this.IlllIIIIIIlllIlIIlllIlIIl = bl;
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyType keyType) {
        this.llIlllIIIllllIIlllIllIIIl = keyType;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof KeyBind)) {
            return false;
        }
        KeyBind keyBind = (KeyBind)object;
        if (!keyBind.lIlIlIlIlIIlIIlIIllIIIIIl(this)) {
            return false;
        }
        if (this.lIlIlIlIlIIlIIlIIllIIIIIl() != keyBind.lIlIlIlIlIIlIIlIIllIIIIIl()) {
            return false;
        }
        if (this.IlllIIIIIIlllIlIIlllIlIIl() != keyBind.IlllIIIIIIlllIlIIlllIlIIl()) {
            return false;
        }
        if (this.lIllIlIIIlIIIIIIIlllIlIll() != keyBind.lIllIlIIIlIIIIIIIlllIlIll()) {
            return false;
        }
        KeyType keyType = this.llIlllIIIllllIIlllIllIIIl();
        KeyType keyType2 = keyBind.llIlllIIIllllIIlllIllIIIl();
        return !(keyType == null ? keyType2 != null : !((Object) keyType).equals(keyType2));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(Object object) {
        return object instanceof KeyBind;
    }

    public int hashCode() {
        int n = 59;
        int n2 = 1;
        n2 = n2 * 59 + (this.lIlIlIlIlIIlIIlIIllIIIIIl() ? 79 : 97);
        n2 = n2 * 59 + (this.IlllIIIIIIlllIlIIlllIlIIl() ? 79 : 97);
        n2 = n2 * 59 + (this.lIllIlIIIlIIIIIIIlllIlIll() ? 79 : 97);
        KeyType keyType = this.llIlllIIIllllIIlllIllIIIl();
        n2 = n2 * 59 + (keyType == null ? 43 : ((Object) keyType).hashCode());
        return n2;
    }

    public String toString() {
        return "KeyBind(alt=" + this.lIlIlIlIlIIlIIlIIllIIIIIl() + ", shift=" + this.IlllIIIIIIlllIlIIlllIlIIl() + ", control=" + this.lIllIlIIIlIIIIIIIlllIlIll() + ", value=" + this.llIlllIIIllllIIlllIllIIIl() + ")";
    }

    public KeyBind(boolean bl, boolean bl2, boolean bl3, KeyType keyType) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = bl;
        this.IlllIIIIIIlllIlIIlllIlIIl = bl2;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl3;
        this.llIlllIIIllllIIlllIllIIIl = keyType;
    }
}
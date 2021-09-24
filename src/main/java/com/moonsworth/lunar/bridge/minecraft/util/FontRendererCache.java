package com.moonsworth.lunar.bridge.minecraft.util;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class FontRendererCache extends Object2ObjectOpenHashMap {
    public lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl = new lIlIlIlIlIIlIIlIIllIIIIIl(null, 0, false);

    public lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl(String var1, int var2, boolean var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl = var2;
        this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll = var3;
        return (lIlIlIlIlIIlIIlIIllIIIIIl)this.get(this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public static class lIlIlIlIlIIlIIlIIllIIIIIl {
        public String lIlIlIlIlIIlIIlIIllIIIIIl;
        public int IlllIIIIIIlllIlIIlllIlIIl;
        public boolean lIllIlIIIlIIIIIIIlllIlIll;

        public lIlIlIlIlIIlIIlIIllIIIIIl(String var1, int var2, boolean var3) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl = var1;
            this.IlllIIIIIIlllIlIIlllIlIIl = var2;
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
        }

        public boolean equals(Object var1) {
            if (this == var1) {
                return true;
            } else if (var1 != null && this.getClass() == var1.getClass()) {
                FontRendererCache.lIlIlIlIlIIlIIlIIllIIIIIl var2 = (FontRendererCache.lIlIlIlIlIIlIIlIIllIIIIIl)var1;
                return this.IlllIIIIIIlllIlIIlllIlIIl == var2.IlllIIIIIIlllIlIIlllIlIIl && this.lIllIlIIIlIIIIIIIlllIlIll == var2.lIllIlIIIlIIIIIIIlllIlIll && this.lIlIlIlIlIIlIIlIIllIIIIIl.equals(var2.lIlIlIlIlIIlIIlIIllIIIIIl);
            } else {
                return false;
            }
        }

        public int hashCode() {
            int var1 = this.lIlIlIlIlIIlIIlIIllIIIIIl.hashCode();
            var1 = 31 * var1 + this.IlllIIIIIIlllIlIIlllIlIIl;
            var1 = 31 * var1 + (this.lIllIlIIIlIIIIIIIlllIlIll ? 1 : 0);
            return var1;
        }
    }
}
package com.moonsworth.lunar.client.cosmetic.de;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.util.function.BiConsumer;

public class IlllIIIIIIlllIlIIlllIlIIl {
    public final ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public final BiConsumer IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll = false;

    public IlllIIIIIIlllIlIIlllIlIIl(ResourceLocationBridge resourceLocationBridge, BiConsumer biConsumer, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = biConsumer;
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public BiConsumer IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        this.lIllIlIIIlIIIIIIIlllIlIll = bl;
    }

    public IlllIIIIIIlllIlIIlllIlIIl(ResourceLocationBridge resourceLocationBridge, BiConsumer biConsumer) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = biConsumer;
    }
}
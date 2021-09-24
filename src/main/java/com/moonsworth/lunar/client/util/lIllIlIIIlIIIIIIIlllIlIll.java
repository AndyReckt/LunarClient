package com.moonsworth.lunar.client.util;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;

public class lIllIlIIIlIIIIIIIlllIlIll {
    public static final TextureManagerBridge lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getTextureManager();
    public final int IlllIIIIIIlllIlIIlllIlIIl;
    public final ResourceLocationBridge lIllIlIIIlIIIIIIIlllIlIll;

    public lIllIlIIIlIIIIIIIlllIlIll(int n, ResourceLocationBridge resourceLocationBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = n;
        this.lIllIlIIIlIIIIIIIlllIlIll = resourceLocationBridge;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        if (this.lIllIlIIIlIIIIIIIlllIlIll == null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        } else {
            lIlIlIlIlIIlIIlIIllIIIIIl.bridge$bindTexture(this.lIllIlIIIlIIIIIIIlllIlIll);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$callList(this.IlllIIIIIIlllIlIIlllIlIIl);
        if (this.lIllIlIIIlIIIIIIIlllIlIll == null) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl() {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$deleteLists(this.IlllIIIIIIlllIlIIlllIlIIl, 1);
    }
}
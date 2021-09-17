package com.moonsworth.lunar.client.blog;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ThreadDownloadImageDataBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;

import java.io.File;

public class BlogCache {
    public static final File lIlIlIlIlIIlIIlIIllIIIIIl = new File(new File(new File(System.getProperty("user.home"), ".lunarclient"), "game-cache"), "blog-post-images");
    public final String IlllIIIIIIlllIlIIlllIlIIl;
    public final String lIllIlIIIlIIIIIIIlllIlIll;
    public final String llIlllIIIllllIIlllIllIIIl;
    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI;

    public BlogCache(String string, String string2, String string3) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.lIllIlIIIlIIIIIIIlllIlIll = string2;
        this.llIlllIIIllllIIlllIllIIIl = string3;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        try {
            lIlIlIlIlIIlIIlIIllIIIIIl.mkdirs();
        }
        catch (Exception exception) {
            // empty catch block
        }
        String string = Hashing.md5().hashString(this.lIllIlIIIlIIIIIIIlllIlIll, Charsets.UTF_8).toString();
        File file = new File(lIlIlIlIlIIlIIlIIllIIIIIl, string);
        this.llllIIlIIlIIlIIllIIlIIllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", string);
        ThreadDownloadImageDataBridge threadDownloadImageDataBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initThreadDownloadImageData(file, this.lIllIlIIIlIIIIIIIlllIlIll, Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar", "backgrounds/post-default-403x171.png"));
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$loadTexture(this.llllIIlIIlIIlIIllIIlIIllI, threadDownloadImageDataBridge);
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}
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
    public final String imageURL;
    public final String blogLink;
    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI;

    public BlogCache(String string, String imageURL, String blogLink) {
        this.IlllIIIIIIlllIlIIlllIlIIl = string;
        this.imageURL = imageURL;
        this.blogLink = blogLink;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl() {
        try {
            lIlIlIlIlIIlIIlIIllIIIIIl.mkdirs();
        } catch (Exception exception) {
            // empty catch block
        }
        String string = Hashing.md5().hashString(this.imageURL, Charsets.UTF_8).toString();
        File file = new File(lIlIlIlIlIIlIIlIIllIIIIIl, string);
        this.llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initResourceLocation("lunar", string);
        ThreadDownloadImageDataBridge threadDownloadImageDataBridge = Bridge.getInstance().initThreadDownloadImageData(file, this.imageURL, Bridge.getInstance().initResourceLocation("lunar", "backgrounds/post-default-403x171.png"));
        Ref.getMinecraft().bridge$getTextureManager().bridge$loadTexture(this.llllIIlIIlIIlIIllIIlIIllI, threadDownloadImageDataBridge);
    }

    public String IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public String lIllIlIIIlIIIIIIIlllIlIll() {
        return this.imageURL;
    }

    public String llIlllIIIllllIIlllIllIIIl() {
        return this.blogLink;
    }

    public ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }
}
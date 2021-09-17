package com.moonsworth.lunar.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTickingTexture;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.SimpleResourceBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.AnimationMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import lombok.SneakyThrows;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public final class AnimationTickingTexture
extends AbstractTickingTexture {
    public ResourceLocationBridge lIlIlIlIlIIlIIlIIllIIIIIl;
    public AnimationMetadataSectionBridge IlllIIIIIIlllIlIIlllIlIIl;
    public long lIllIlIIIlIIIIIIIlllIlIll;
    public int llIlllIIIllllIIlllIllIIIl = 0;
    public int llllIIlIIlIIlIIllIIlIIllI;
    public int IlIlIlllllIlIIlIlIlllIlIl;
    public int llIIIIIIIllIIllIlIllIIIIl;
    public boolean lIIIllIllIIllIlllIlIIlllI = false;

    public AnimationTickingTexture(ResourceLocationBridge resourceLocationBridge, AnimationMetadataSectionBridge animationMetadataSectionBridge) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = resourceLocationBridge;
        this.IlllIIIIIIlllIlIIlllIlIIl = animationMetadataSectionBridge;
        this.llIIIIIIIllIIllIlIllIIIIl = animationMetadataSectionBridge.bridge$getFrameTime();
        if (animationMetadataSectionBridge.bridge$getFrameCount() > 0) {
            this.llllIIlIIlIIlIIllIIlIIllI = animationMetadataSectionBridge.bridge$getFrameCount();
            this.lIIIllIllIIllIlllIlIIlllI = true;
        }
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        int n = this.lIIIllIllIIllIlllIlIIlllI ? this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getFrameIndex(this.llIlllIIIllllIIlllIllIIIl % this.llllIIlIIlIIlIIllIIlIIllI) : this.llIlllIIIllllIIlllIllIIIl % this.IlIlIlllllIlIIlIlIlllIlIl;
        return n;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    @Override
    public void bridge$tick() {
        int n;
        int n2 = 1;
        n2 = this.lIIIllIllIIllIlllIlIIlllI && this.IlllIIIIIIlllIlIIlllIlIIl.bridge$hasTime(n = this.lIlIlIlIlIIlIIlIIllIIIIIl()) ? this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getFrameTimeSingle(n) : this.llIIIIIIIllIIllIlIllIIIIl;
        if (System.currentTimeMillis() - this.lIllIlIIIlIIIIIIIlllIlIll >= (long)(n2 *= 50)) {
            ++this.llIlllIIIllllIIlllIllIIIl;
            this.lIllIlIIIlIIIIIIIlllIlIll = System.currentTimeMillis();
        }
    }

    @SneakyThrows // todo i think
    @Override
    public void bridge$loadTexture(IResourceManagerBridge iResourceManagerBridge) {
        SimpleResourceBridge simpleResourceBridge = iResourceManagerBridge.bridge$getResource(this.lIlIlIlIlIIlIIlIIllIIIIIl);
        if (simpleResourceBridge != null) {
            InputStream inputStream = Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager().bridge$getResource(this.lIlIlIlIlIIlIIlIIllIIIIIl).bridge$getInputStream();
            BufferedImage bufferedImage = ImageIO.read(inputStream);
            this.IlIlIlllllIlIIlIlIlllIlIl = bufferedImage.getHeight() / this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getFrameHeight();
            Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$uploadTextureImage(this.bridge$getGlTextureId(), bufferedImage);
        } else {
            System.out.println("resource is null");
        }
    }
}
 
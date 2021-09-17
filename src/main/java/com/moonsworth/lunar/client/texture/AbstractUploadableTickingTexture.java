package com.moonsworth.lunar.client.texture;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTickingTexture;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.LoadableTickingTexture;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.texture.runnable.ResourceUploadRunnable;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public abstract class AbstractUploadableTickingTexture
extends AbstractTickingTexture
implements LoadableTickingTexture {
    public static final int maxTextureSize = 0x400000;
    public static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
    public static final IntBuffer dataBuffer = ByteBuffer.allocateDirect(0x1000000).order(ByteOrder.nativeOrder()).asIntBuffer();
    public boolean readyForUpload;
    public boolean loaded;
    public boolean clamp;
    public boolean blur;
    public int textureWidth;
    public int textureHeight;
    public Map dataMap;
    public final ResourceLocationBridge textureLocation;

    public AbstractUploadableTickingTexture(ResourceLocationBridge resourceLocationBridge) {
        this.textureLocation = resourceLocationBridge;
        this.loaded = this.hasTexture();
    }

    @Override
    public boolean bridge$ready() {
        return this.loaded;
    }

    public void markReadyForUpload() {
        this.readyForUpload = true;
    }

    @Override
    public void bridge$tick() {
        if (this.readyForUpload && this.glTextureId != -1) {
            this.uploadTexture();
            this.dataMap.clear();
            this.dataMap = null;
            this.loaded = true;
            this.readyForUpload = false;
        }
    }

    public abstract void uploadTexture();

    @Override
    public void bridge$loadTexture(IResourceManagerBridge iResourceManagerBridge) {
        this.bridge$deleteGlTexture();
        if (this.glTextureId == -1) {
            this.bridge$setGlTextureId(Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$glGenTextures());
        }
        this.addTexture();
        executor.submit(new ResourceUploadRunnable(iResourceManagerBridge, this));
    }

    @Override
    public void bridge$deleteGlTexture() {
        if (this.glTextureId != -1) {
            Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.glTextureId);
            this.bridge$setGlTextureId(-1);
        }
        this.removeTexture();
        this.dataMap = new HashMap();
        this.loaded = false;
    }

    public boolean hasTexture() {
        return Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$getTextureMap().containsKey(this.textureLocation);
    }

    public void addTexture() {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$getTextureMap().put(this.textureLocation, this);
    }

    public void removeTexture() {
        Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$getTextureMap().remove(this.textureLocation);
    }

    @Override
    public void bridge$setBlurMipmap(boolean bl, boolean bl2) {
    }

    @Override
    public int bridge$getGlTextureId() {
        return this.glTextureId;
    }

    public static int getMaxTextureSize() {
        return 0x400000;
    }

    public void setClamp(boolean bl) {
        this.clamp = bl;
    }

    public void setBlur(boolean bl) {
        this.blur = bl;
    }

    public void setTextureWidth(int n) {
        this.textureWidth = n;
    }

    public void setTextureHeight(int n) {
        this.textureHeight = n;
    }

    public Map getDataMap() {
        return this.dataMap;
    }
}
 
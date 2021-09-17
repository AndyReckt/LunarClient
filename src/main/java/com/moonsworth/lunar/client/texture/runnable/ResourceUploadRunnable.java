package com.moonsworth.lunar.client.texture.runnable;

import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.SimpleResourceBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.TextureMetadataSectionBridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import com.moonsworth.lunar.client.texture.AbstractUploadableTickingTexture;
import org.apache.commons.io.IOUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceUploadRunnable
implements Runnable {
    public static final int[] lIlIlIlIlIIlIIlIIllIIIIIl = new int[AbstractUploadableTickingTexture.getMaxTextureSize()];
    public final IResourceManagerBridge IlllIIIIIIlllIlIIlllIlIIl;
    public final AbstractUploadableTickingTexture lIllIlIIIlIIIIIIIlllIlIll;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.glTextureId == -1) {
            return;
        }
        try {
            BufferedImage bufferedImage;
            SimpleResourceBridge simpleResourceBridge = this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getResource(this.lIllIlIIIlIIIIIIIlllIlIll.textureLocation);
            InputStream inputStream = simpleResourceBridge.bridge$getInputStream();
            try {
                bufferedImage = ImageIO.read(inputStream);
            }
            finally {
                IOUtils.closeQuietly(inputStream);
            }
            boolean bl = false;
            boolean bl2 = false;
            if (simpleResourceBridge.bridge$hasMetadata()) {
                try {
                    TextureMetadataSectionBridge textureMetadataSectionBridge = (TextureMetadataSectionBridge)simpleResourceBridge.bridge$getMetadata("texture");
                    if (textureMetadataSectionBridge != null) {
                        bl = textureMetadataSectionBridge.bridge$getTextureBlur();
                        bl2 = textureMetadataSectionBridge.bridge$getTextureClamp();
                    }
                }
                catch (Exception class18) {
                    LunarLogger.lIllIlIIIlIIIIIIIlllIlIll((Object)("Failed reading metadata of: " + this.lIllIlIIIlIIIIIIIlllIlIll.textureLocation), new Object[]{class18});
                }
            }
            int n = bufferedImage.getWidth();
            int n2 = bufferedImage.getHeight();
            int n3 = 0x400000 / n;
            int[] nArray = new int[n * n2];
            for (int i = 0; i < n * n2; i += n * n3) {
                int n4 = i / n;
                int n5 = Math.min(n3, n2 - n4);
                bufferedImage.getRGB(0, n4, n, n5, nArray, 0, n);
                this.lIllIlIIIlIIIIIIIlllIlIll.getDataMap().put(i, nArray);
            }
            this.lIllIlIIIlIIIIIIIlllIlIll.setClamp(bl2);
            this.lIllIlIIIlIIIIIIIlllIlIll.setBlur(bl);
            this.lIllIlIIIlIIIIIIIlllIlIll.setTextureWidth(n);
            this.lIllIlIIIlIIIIIIIlllIlIll.setTextureHeight(n2);
            this.lIllIlIIIlIIIIIIIlllIlIll.markReadyForUpload();
        }
        catch (IOException iOException) {
            LunarLogger.lIllIlIIIlIIIIIIIlllIlIll((Object)("Failed to load texture: " + this.lIllIlIIIlIIIIIIIlllIlIll.textureLocation), iOException);
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public ResourceUploadRunnable(IResourceManagerBridge iResourceManagerBridge, AbstractUploadableTickingTexture abstractUploadableTickingTexture) {
        this.IlllIIIIIIlllIlIIlllIlIIl = iResourceManagerBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = abstractUploadableTickingTexture;
    }
}
 
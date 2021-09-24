package com.moonsworth.lunar.mixin.client;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ThreadDownloadImageDataBridge;
import lombok.Getter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Mixin(ThreadDownloadImageData.class)
public abstract class MixinThreadDownloadImageDatazz implements ThreadDownloadImageDataBridge {
    @Shadow
    public String imageUrl;
    @Shadow
    public IImageBuffer imageBuffer;
    @Shadow
    public BufferedImage bufferedImage;
    @Shadow
    public File cacheFile;

    @Final
    @Shadow
    private static Logger logger;

    private static final ThreadFactory textureThreadFactory;
    private static final ExecutorService textureThreadPool;

    static {
        textureThreadFactory = new ThreadFactoryBuilder().setNameFormat("Texture Downloader #%d").setDaemon(true).build();
        textureThreadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), textureThreadFactory);
    }

    @Shadow
    public abstract void setBufferedImage(BufferedImage var1);

    public void loadTextureFromServer() {
        textureThreadPool.submit(() -> {
            logger.debug("Downloading http texture from {} to {}", this.imageUrl, this.cacheFile);
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.imageUrl).openConnection(Minecraft.getMinecraft().getProxy());
                try (InputStream inputStream = httpURLConnection.getInputStream()) {
                    BufferedImage bufferedImage;
                    if (this.cacheFile != null) {
                        FileUtils.copyInputStreamToFile(inputStream, this.cacheFile);
                        bufferedImage = ImageIO.read(this.cacheFile);
                    } else {
                        bufferedImage = ImageIO.read(inputStream);
                    }
                    if (this.imageBuffer != null) {
                        bufferedImage = this.imageBuffer.parseUserSkin(bufferedImage);
                    }
                    this.setBufferedImage(bufferedImage);

                    this.bridge$setImageFound(this.bufferedImage != null);
                    if (httpURLConnection.getErrorStream() != null) {
                        try {
                            httpURLConnection.getErrorStream();
                            try {
                                while (inputStream.skip(2048L) > 0L) {
                                }
                            } finally {
                                inputStream.close();
                            }
                        } catch (Exception ignored) {
                        }
                    }
                } catch (Throwable t) {
                    throw t;
                }
            } catch (Exception ex) {
                if (!(ex instanceof FileNotFoundException)) {
                    logger.error("Couldn't download http texture: " + ex.getClass().getName() + ": " + ex.getMessage());
                }
            }
        });
    }

    static {
    }
}
package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.logger.LunarLogger;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.AbstractResourcePack;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Mixin(AbstractResourcePack.class)
public abstract class MixinAbstractResourcePackz implements AbstractResourcePackBridge {

    @Shadow
    protected abstract InputStream getInputStreamByName(String var1);

    @Shadow
    public abstract String getPackName();

    @Shadow
    public abstract InputStream getInputStream(ResourceLocation var1);

    @Override
    public InputStream bridge$getInputStream(ResourceLocationBridge var1) {
        return getInputStream((ResourceLocation) var1);
    }

    @Overwrite
    public BufferedImage getPackImage() throws IOException {
        int var1 = LunarClient.llIlllIIIllllIIlllIllIIIl();
        BufferedImage var2 = TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
        if (var2 == null) {
            return null;
        } else if (var2.getWidth() <= var1 && var2.getHeight() <= var1) {
            return var2;
        } else {
            LunarLogger.info("MemoryFix", "Scaling resource pack icon from " + var2.getWidth() + " to " + var1);
            BufferedImage var3 = new BufferedImage(var1, var1, 2);
            Graphics var4 = var3.getGraphics();
            var4.drawImage(var2, 0, 0, var1, var1, null);
            var4.dispose();
            return var3;
        }
    }

    @Override
    public String bridge$getPackName() {
        return getPackName();
    }

    @Override
    public Optional<BufferedImage> bridge$getPackImage() {
        try {
            return Optional.ofNullable(this.getPackImage());
        } catch (IOException var2) {
            return Optional.empty();
        }
    }
}
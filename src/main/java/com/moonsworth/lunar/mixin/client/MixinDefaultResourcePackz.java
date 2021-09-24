package com.moonsworth.lunar.mixin.client;

import com.google.common.collect.ImmutableSet;
import com.moonsworth.lunar.bridge.minecraft.client.resources.AbstractResourcePackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Optional;
import java.util.Set;

@Mixin(DefaultResourcePack.class)
public abstract class MixinDefaultResourcePackz implements AbstractResourcePackBridge {
    public MixinDefaultResourcePackz() {
    }

    @Shadow
    protected abstract InputStream getResourceStream(ResourceLocation var1);

    @Shadow
    public abstract String getPackName();

    @Shadow
    public abstract BufferedImage getPackImage();

    @Overwrite
    public Set<String> getResourceDomains() {
        return ImmutableSet.of("minecraft", "realms", "lunar");
    }

    public InputStream bridge$getInputStream(ResourceLocationBridge var1) {
        return this.getResourceStream((ResourceLocation)var1);
    }

    public String bridge$getPackName() {
        return this.getPackName();
    }

    public Optional<BufferedImage> bridge$getPackImage() {
        return Optional.ofNullable(this.getPackImage());
    }
}
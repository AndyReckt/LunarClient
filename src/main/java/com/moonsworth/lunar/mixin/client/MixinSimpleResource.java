package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.resources.SimpleResourceBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.data.IMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.resources.SimpleResource;
import net.minecraft.client.resources.data.IMetadataSection;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.io.InputStream;

@Mixin(SimpleResource.class)
public abstract class MixinSimpleResource implements SimpleResourceBridge {

    @Shadow
    public abstract InputStream getInputStream();

    @Shadow
    public abstract boolean hasMetadata();

    @Shadow
    public abstract IMetadataSection getMetadata(String var1);

    @Shadow
    public abstract ResourceLocation getResourceLocation();

    @Shadow
    public abstract String getResourcePackName();

    @Override
    public ResourceLocationBridge bridge$getResourceLocation() {
        return (ResourceLocationBridge) getResourceLocation();
    }

    @Override
    public boolean bridge$hasMetadata() {
        return hasMetadata();
    }

    @Override
    public IMetadataSectionBridge bridge$getMetadata(String var1) {
        return (IMetadataSectionBridge) getMetadata(var1);
    }

    @Override
    public String bridge$getResourcePackName() {
        return getResourcePackName();
    }

    @Override
    public InputStream bridge$getInputStream() {
        return getInputStream();
    }
}
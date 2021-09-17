package com.moonsworth.lunar.bridge.minecraft.client.resources;

import com.moonsworth.lunar.bridge.minecraft.client.resources.data.IMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.io.InputStream;

public interface SimpleResourceBridge {
    public ResourceLocationBridge bridge$getResourceLocation();

    public InputStream bridge$getInputStream();

    public boolean bridge$hasMetadata();

    public IMetadataSectionBridge bridge$getMetadata(String var1);

    public String bridge$getResourcePackName();
}
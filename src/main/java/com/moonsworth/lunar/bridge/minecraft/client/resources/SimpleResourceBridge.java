package com.moonsworth.lunar.bridge.minecraft.client.resources;

import com.moonsworth.lunar.bridge.minecraft.client.resources.data.IMetadataSectionBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

import java.io.InputStream;

public interface SimpleResourceBridge {
    ResourceLocationBridge bridge$getResourceLocation();

    InputStream bridge$getInputStream();

    boolean bridge$hasMetadata();

    IMetadataSectionBridge bridge$getMetadata(String var1);

    String bridge$getResourcePackName();
}
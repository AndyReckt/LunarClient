package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.resources.*;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.client.resources.*;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mixin(SimpleReloadableResourceManager.class)
public abstract class MixinSimpleReloadableResourceManager implements SimpleReloadableResourceManagerBridge {
    @Final
    @Shadow
    private Map<String, FallbackResourceManager> domainResourceManagers;

    @Shadow
    public abstract IResource getResource(ResourceLocation var1);

    @Shadow
    public abstract void reloadResources(List<IResourcePack> var1);

    @Shadow
    public abstract void registerReloadListener(IResourceManagerReloadListener var1);

    @Shadow
    public abstract Set<String> getResourceDomains();

    @Shadow
    public abstract List<IResource> getAllResources(ResourceLocation var1);

    @Override
    public SimpleResourceBridge bridge$getResource(ResourceLocationBridge var1) {
        return (SimpleResourceBridge) getResource((ResourceLocation) var1);
    }

    @Override
    public void bridge$putDomainResourceManager(String var1, IResourceManagerBridge var2) {
        this.domainResourceManagers.put(var1, (FallbackResourceManager) var2);
    }

    @Override
    public void bridge$reloadResources(List<AbstractResourcePackBridge> var1) {
        ArrayList<IResourcePack> arrayList = new ArrayList<>(var1.size());
        for (AbstractResourcePackBridge abstractResourcePackBridge : var1) {
            arrayList.add((IResourcePack) abstractResourcePackBridge);
        }
        this.reloadResources(arrayList);
    }

    @Override
    public void bridge$registerReloadListener(IResourceManagerReloadListenerBridge var1) {
        this.registerReloadListener((IResourceManagerReloadListener) var1);
    }

    @Override
    public Set<String> bridge$getResourceDomains() {
        return getResourceDomains();
    }

    @Override
    public SimpleResourceBridge bridge$getResource(ResourceLocationBridge var1, boolean var2) {
        return (SimpleResourceBridge) getResource((ResourceLocation) var1);
    }

    @Override
    public List<SimpleResourceBridge> bridge$getAllResources(ResourceLocationBridge var1) {
        List<IResource> list = this.getAllResources((ResourceLocation)var1);
        ArrayList<SimpleResourceBridge> arrayList = new ArrayList<>(list.size());
        for (IResource iResource : list) {
            arrayList.add((SimpleResourceBridge) iResource);
        }
        return arrayList;
    }
}
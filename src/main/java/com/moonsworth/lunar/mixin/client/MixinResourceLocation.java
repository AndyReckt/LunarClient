package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author Decencies
 * @since 14/07/2021 00:05
 */
@Mixin(ResourceLocation.class)
public abstract class MixinResourceLocation implements ResourceLocationBridge {

    @Final
    @Shadow
    protected String resourcePath;
    @Final
    @Shadow
    protected String resourceDomain;

    @Override
    public String bridge$getPath() {
        return resourcePath;
    }

    @Override
    public String bridge$getDomain() {
        return resourceDomain;
    }

}

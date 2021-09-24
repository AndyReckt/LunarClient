package com.moonsworth.lunar.mixin.client.shader;

import com.moonsworth.lunar.bridge.minecraft.client.shader.FramebufferBridge;
import net.minecraft.client.shader.Framebuffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Framebuffer.class)
public abstract class MixinFramebuffer implements FramebufferBridge {

    @Shadow
    public int framebufferTextureWidth;

    @Shadow
    public int framebufferTextureHeight;

    @Shadow
    public int framebufferWidth;

    @Shadow
    public int framebufferHeight;

    @Shadow
    public int framebufferTexture;

    public int bridge$framebufferWidth() {
        return framebufferWidth;
    }

    public int bridge$framebufferHeight() {
        return framebufferHeight;
    }

    public int bridge$framebufferTextureWidth() {
        return framebufferTextureWidth;
    }

    public int bridge$framebufferTextureHeight() {
        return framebufferTextureHeight;
    }

    public int bridge$getFramebufferTexture() {
        return framebufferTexture;
    }
}
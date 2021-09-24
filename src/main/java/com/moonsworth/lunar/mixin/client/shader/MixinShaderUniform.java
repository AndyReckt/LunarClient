package com.moonsworth.lunar.mixin.client.shader;

import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderUniformBridge;
import net.minecraft.client.shader.ShaderUniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ShaderUniform.class)
public abstract class MixinShaderUniform implements ShaderUniformBridge {

    @Shadow
    public abstract void set(float var1);

    @Shadow
    public abstract void set(float var1, float var2);

    @Shadow
    public abstract void set(float var1, float var2, float var3);

    public void bridge$set(float var1) {
        set(var1);
    }

    public void bridge$set(float var1, float var2) {
        set(var1, var2);
    }

    public void bridge$set(float var1, float var2, float var3) {
        set(var1, var2, var3);
    }
}
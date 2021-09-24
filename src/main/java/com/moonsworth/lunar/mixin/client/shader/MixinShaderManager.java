package com.moonsworth.lunar.mixin.client.shader;

import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderUniformBridge;
import net.minecraft.client.shader.ShaderManager;
import net.minecraft.client.shader.ShaderUniform;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ShaderManager.class)
public abstract class MixinShaderManager implements ShaderManagerBridge {

    @Shadow
    public abstract ShaderUniform getShaderUniform(String var1);

    public ShaderUniformBridge bridge$getShaderUniform(String var1) {
        return (ShaderUniformBridge) getShaderUniform(var1);
    }
}

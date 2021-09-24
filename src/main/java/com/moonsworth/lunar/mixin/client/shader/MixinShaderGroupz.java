package com.moonsworth.lunar.mixin.client.shader;

import com.moonsworth.lunar.bridge.minecraft.client.shader.ShaderGroupBridge;
import net.minecraft.client.shader.Shader;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Mixin(ShaderGroup.class)
public abstract class MixinShaderGroupz implements ShaderGroupBridge {

    @Final
    @Shadow
    private List<Shader> listShaders;

    @Shadow
    public abstract String getShaderGroupName();

    public List bridge$listShaders() {
        return listShaders;
    }

    public String bridge$getShaderGroupName() {
        return getShaderGroupName();
    }
}

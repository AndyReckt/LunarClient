package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.VertexFormatBridge;
import net.minecraft.client.renderer.vertex.VertexFormat;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VertexFormat.class)
public abstract class MixinVertexFormat implements VertexFormatBridge {
}

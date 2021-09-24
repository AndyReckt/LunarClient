package com.moonsworth.lunar.client.bridge.impl.type.vertex;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.DefaultVertexFormatsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.VertexFormatBridge;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public final class DefaultVertexFormatsImplementation implements DefaultVertexFormatsBridge {
    public VertexFormatBridge bridge$position_tex_normal() {
        return (VertexFormatBridge) DefaultVertexFormats.TEX_2F;
    }

    public VertexFormatBridge bridge$block() {
        return (VertexFormatBridge)DefaultVertexFormats.BLOCK;
    }

    public VertexFormatBridge bridge$position_tex() {
        return (VertexFormatBridge)DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL;
    }

    public VertexFormatBridge bridge$position_color() {
        return (VertexFormatBridge)DefaultVertexFormats.POSITION_TEX_LMAP_COLOR;
    }
}

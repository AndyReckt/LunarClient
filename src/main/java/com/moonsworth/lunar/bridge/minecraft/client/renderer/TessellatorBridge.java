package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.VertexFormatBridge;

public interface TessellatorBridge {
    public void bridge$begin(int var1, boolean var2, boolean var3);

    public TessellatorBridge bridge$pos(float var1, float var2, float var3);

    default public TessellatorBridge lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        return this.bridge$pos((float)d, (float)d2, (float)d3);
    }

    public TessellatorBridge bridge$normal(float var1, float var2, float var3);

    public TessellatorBridge bridge$color(float var1, float var2, float var3, float var4);

    public TessellatorBridge bridge$uv(float var1, float var2);

    default public TessellatorBridge lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return this.bridge$pos(f, f2, 0.0f);
    }

    public TessellatorBridge bridge$endVertex();

    public void bridge$end();

    public boolean bridge$isDrawing();

    public void bridge$begin(int var1, VertexFormatBridge var2);

    public void bridge$setTranslation(double var1, double var3, double var5);
}
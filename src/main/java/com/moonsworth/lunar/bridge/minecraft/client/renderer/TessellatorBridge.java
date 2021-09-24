package com.moonsworth.lunar.bridge.minecraft.client.renderer;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.VertexFormatBridge;

public interface TessellatorBridge {
    void bridge$begin(int var1, boolean var2, boolean var3);

    TessellatorBridge bridge$pos(float var1, float var2, float var3);

default TessellatorBridge lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        return this.bridge$pos((float)d, (float)d2, (float)d3);
    }

    TessellatorBridge bridge$normal(float var1, float var2, float var3);

    TessellatorBridge bridge$color(float var1, float var2, float var3, float var4);

    TessellatorBridge bridge$uv(float var1, float var2);

default TessellatorBridge lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2) {
        return this.bridge$pos(f, f2, 0.0f);
    }

    TessellatorBridge bridge$endVertex();

    void bridge$end();

    boolean bridge$isDrawing();

    void bridge$begin(int var1, VertexFormatBridge var2);

    void bridge$setTranslation(double var1, double var3, double var5);
}
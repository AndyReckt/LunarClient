package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.vertex.VertexFormatBridge;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(Tessellator.class)
public abstract class MixinTessellatorz implements TessellatorBridge {

    @Shadow
    protected WorldRenderer worldRenderer;

    @Shadow
    public abstract WorldRenderer getWorldRenderer();

    @Shadow public abstract void draw();

    public void bridge$begin(int var1, boolean var2, boolean var3) {
        VertexFormat vertexFormat = DefaultVertexFormats.POSITION_TEX;
        if (var2 && var3) {
            vertexFormat = DefaultVertexFormats.POSITION_TEX_COLOR;
        } else if (var2) {
            vertexFormat = DefaultVertexFormats.POSITION_TEX;
        } else if (var3) {
            vertexFormat = DefaultVertexFormats.POSITION_COLOR;
        }
        this.getWorldRenderer().begin(var1, vertexFormat);
    }

    public void bridge$begin(int var1, VertexFormatBridge var2) {
        worldRenderer.begin(var1, (VertexFormat) var2);
    }

    public TessellatorBridge bridge$pos(float var1, float var2, float var3) {
        this.getWorldRenderer().pos(var1, var2, var3);
        return this;
    }

    public TessellatorBridge bridge$color(float var1, float var2, float var3, float var4) {
        this.getWorldRenderer().color(var1, var2, var3, var4);
        return this;
    }

    public TessellatorBridge bridge$uv(float var1, float var2) {
        this.getWorldRenderer().tex(var1, var2);
        return this;
    }

    public TessellatorBridge bridge$normal(float var1, float var2, float var3) {
        this.getWorldRenderer().normal(var1, var2, var3);
        return this;
    }

    public TessellatorBridge bridge$endVertex() {
        this.getWorldRenderer().endVertex();
        return this;
    }

    public boolean bridge$isDrawing() {
        return this.worldRenderer.isDrawing;
    }

    public void bridge$end() {
        this.draw();
    }

    public void bridge$setTranslation(double var1, double var3, double var5) {
        this.worldRenderer.setTranslation(var1, var3, var5);
    }
}
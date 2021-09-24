package com.moonsworth.lunar.client.bridge.impl.type.util;

import com.moonsworth.lunar.bridge.lunar.GeometryTessellator;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3d;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class TesselatorImplementation extends Tessellator implements GeometryTessellator {
    public static TesselatorImplementation instance = null;
    public static double deltaS = 0.0D;
    public double delta;

    public TesselatorImplementation() {
        this(2097152);
    }

    public TesselatorImplementation(int var1) {
        super(var1);
        this.delta = 0.0D;
    }

    public static TesselatorImplementation paepeppsehahahaeeppsssesp() {
        if (instance == null) {
            instance = new TesselatorImplementation();
        }

        return instance;
    }

    public void setTranslation(double var1, double var3, double var5) {
        this.getWorldRenderer().setTranslation(var1, var3, var5);
    }

    public void beginQuads() {
        this.begin(7);
    }

    public void beginLines() {
        this.begin(1);
    }

    public void begin(int var1) {
        this.getWorldRenderer().begin(var1, DefaultVertexFormats.POSITION_TEX_LMAP_COLOR);
    }

    public void draw() {
        super.draw();
    }

    public void setDelta(double var1) {
        this.delta = var1;
    }

    public static void setStaticDelta(double var0) {
        deltaS = var0;
    }

    public void drawCuboid(Vector3d var1, int var2, int var3) {
        this.drawCuboid(var1, var1, var2, var3);
    }

    public void drawCuboid(Vector3d var1, Vector3d var2, int var3, int var4) {
        drawCuboid(this.getWorldRenderer(), var1, var2, var3, var4, this.delta);
    }

    public static void drawCuboid(WorldRenderer var0, Vector3d var1, int var2, int var3) {
        drawCuboid(var0, var1, var1, var2, var3);
    }

    public static void drawCuboid(WorldRenderer var0, Vector3d var1, Vector3d var2, int var3, int var4) {
        drawCuboid(var0, var1, var2, var3, var4, deltaS);
    }

    public static void drawCuboid(WorldRenderer var0, Vector3d var1, Vector3d var2, int var3, int var4, double var5) {
        if (var0.getDrawMode() != -1 && var3 != 0) {
            double var7 = var1.lIlIlIlIlIIlIIlIIllIIIIIl() - var5;
            double var9 = var1.IlllIIIIIIlllIlIIlllIlIIl() - var5;
            double var11 = var1.lIllIlIIIlIIIIIIIlllIlIll() - var5;
            double var13 = var2.lIlIlIlIlIIlIIlIIllIIIIIl() + 1.0D + var5;
            double var15 = var2.IlllIIIIIIlllIlIIlllIlIIl() + 1.0D + var5;
            double var17 = var2.lIllIlIIIlIIIIIIIlllIlIll() + 1.0D + var5;
            switch(var0.getDrawMode()) {
            case 1:
                drawLines(var0, var7, var9, var11, var13, var15, var17, var3, var4);
                break;
            case 7:
                drawQuads(var0, var7, var9, var11, var13, var15, var17, var3, var4);
                break;
            default:
                throw new IllegalStateException("Unsupported mode for " + var0.getDrawMode());
            }

        }
    }

    public static void drawQuads(WorldRenderer var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14) {
        int var15 = var14 >>> 24 & 255;
        int var16 = var14 >>> 16 & 255;
        int var17 = var14 >>> 8 & 255;
        int var18 = var14 & 255;
        drawQuads(var0, var1, var3, var5, var7, var9, var11, var13, var15, var16, var17, var18);
    }

    public static void drawQuads(WorldRenderer var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14, int var15, int var16, int var17) {
        if ((var13 & 1) != 0) {
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 2) != 0) {
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 4) != 0) {
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 8) != 0) {
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 16) != 0) {
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 32) != 0) {
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

    }

    public static void drawLines(WorldRenderer var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14) {
        int var15 = var14 >>> 24 & 255;
        int var16 = var14 >>> 16 & 255;
        int var17 = var14 >>> 8 & 255;
        int var18 = var14 & 255;
        drawLines(var0, var1, var3, var5, var7, var9, var11, var13, var15, var16, var17, var18);
    }

    public static void drawLines(WorldRenderer var0, double var1, double var3, double var5, double var7, double var9, double var11, int var13, int var14, int var15, int var16, int var17) {
        if ((var13 & 17) != 0) {
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 18) != 0) {
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 33) != 0) {
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 34) != 0) {
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 5) != 0) {
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 6) != 0) {
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 9) != 0) {
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 10) != 0) {
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 20) != 0) {
            var0.pos(var1, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 36) != 0) {
            var0.pos(var7, var3, var5).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var5).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 24) != 0) {
            var0.pos(var1, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var1, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

        if ((var13 & 40) != 0) {
            var0.pos(var7, var3, var11).color(var15, var16, var17, var14).endVertex();
            var0.pos(var7, var9, var11).color(var15, var16, var17, var14).endVertex();
        }

    }

    public void bridge$setTranslation(double var1, double var3, double var5) {
        this.setTranslation(var1, var3, var5);
    }

    public void bridge$begin(int var1) {
        this.begin(var1);
    }

    public void bridge$draw() {
        this.draw();
    }

    public void bridge$setDelta(double var1) {
        this.setDelta(var1);
    }

    public void bridge$drawCuboid(Vector3d var1, int var2, int var3) {
        this.drawCuboid(var1, var2, var3);
    }

    public void bridge$drawCuboid(Vector3d var1, Vector3d var2, int var3, int var4) {
        this.drawCuboid(var1, var2, var3, var4);
    }

    public void bridge$drawLines(Vector3d var1, Vector3d var2, int var3, int var4) {
        this.drawCuboid(var1, var2, var3, var4);
    }

    public void bridge$drawLines(Vector3d var1, int var2, int var3) {
        this.drawCuboid(var1, var2, var3);
    }

    public boolean bridge$isDrawing() {
        return this.worldRenderer.isDrawing;
    }
}
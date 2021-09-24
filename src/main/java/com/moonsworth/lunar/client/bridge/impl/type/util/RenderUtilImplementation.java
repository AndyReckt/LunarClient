package com.moonsworth.lunar.client.bridge.impl.type.util;

import com.moonsworth.lunar.bridge.lunar.RenderUtilBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vector3d;
import com.moonsworth.lunar.client.bridge.Bridge;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Project;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.Iterator;
import java.util.List;

import static net.minecraft.client.gui.Gui.drawModalRectWithCustomSizedTexture;
import static net.minecraft.client.gui.inventory.GuiInventory.drawEntityOnScreen;

public class RenderUtilImplementation implements RenderUtilBridge {
    public final ResourceLocation[] titlePanoramaPaths = new ResourceLocation[] {new ResourceLocation("lunar", "backgrounds/panorama_0.png"), new ResourceLocation("lunar", "backgrounds/panorama_1.png"), new ResourceLocation("lunar", "backgrounds/panorama_2.png"), new ResourceLocation("lunar", "backgrounds/panorama_3.png"), new ResourceLocation("lunar", "backgrounds/panorama_4.png"), new ResourceLocation("lunar", "backgrounds/panorama_5.png")};
    public ResourceLocation RES_BACKGROUND;
    public static final Tessellator tess = Tessellator.getInstance();
    public static final WorldRenderer wr;

    public void bridge$drawRect(float var1, float var2, float var3, float var4, int var5) {
        float var6 = var1 + var3;
        float var7 = var2 + var4;
        this.pre(var5);
        wr.begin(7, DefaultVertexFormats.POSITION);
        wr.pos(var1, var7, 0.0D).endVertex();
        wr.pos(var6, var7, 0.0D).endVertex();
        wr.pos(var6, var2, 0.0D).endVertex();
        wr.pos(var1, var2, 0.0D).endVertex();
        tess.draw();
        this.post();
    }

    public void bridge$drawRectColor(float var1, float var2, float var3, float var4, int[] var5) {
        GlStateManager.disableCull();
        GlStateManager.disableTexture2D();
        GlStateManager.pushAttrib(); // todo
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        float var6 = var1 + var3;
        float var7 = var2 + var4;
        int[] var8;
        int[] var9;
        int[] var10;
        int[] var11;
        if (var5.length == 4) {
            var8 = this.getColor(var5[0]);
            var9 = this.getColor(var5[1]);
            var10 = this.getColor(var5[2]);
            var11 = this.getColor(var5[3]);
        } else {
            if (var5.length != 2) {
                throw new IllegalArgumentException("Invalid color length (" + var5.length + "), requires 2 or 4!");
            }

            var8 = this.getColor(var5[0]);
            var9 = this.getColor(var5[1]);
            var10 = this.getColor(var5[1]);
            var11 = this.getColor(var5[0]);
        }

        wr.begin(7, DefaultVertexFormats.POSITION_COLOR);
        wr.pos(var1, var7, 0.0D);
        wr.color(var8[0], var8[1], var8[2], var8[3]);
        wr.endVertex();
        wr.pos(var6, var7, 0.0D);
        wr.color(var9[0], var9[1], var9[2], var9[3]);
        wr.endVertex();
        wr.pos(var6, var2, 0.0D);
        wr.color(var10[0], var10[1], var10[2], var10[3]);
        wr.endVertex();
        wr.pos(var1, var2, 0.0D);
        wr.color(var11[0], var11[1], var11[2], var11[3]);
        wr.endVertex();
        tess.draw();
        GlStateManager.disableBlend();
        GlStateManager.popAttrib(); // todo
        GlStateManager.enableTexture2D();
        GlStateManager.enableCull();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void bridge$drawRoundedRectColor(float var1, float var2, float var3, float var4, float var5, int[] var6) {
        double var7 = var1 + var3;
        double var9 = var2 + var4;
        int[] var11;
        int[] var12;
        int[] var13;
        int[] var14;
        if (var6.length == 4) {
            var11 = this.getColor(var6[0]);
            var12 = this.getColor(var6[3]);
            var13 = this.getColor(var6[2]);
            var14 = this.getColor(var6[1]);
        } else {
            if (var6.length != 2) {
                throw new IllegalArgumentException("Invalid color length (" + var6.length + "), requires 2 or 4!");
            }

            var11 = this.getColor(var6[0]);
            var12 = this.getColor(var6[1]);
            var13 = this.getColor(var6[1]);
            var14 = this.getColor(var6[0]);
        }

        GL11.glPushAttrib(0);
        GlStateManager.scale(0.5D, 0.5D, 0.5D);
        var1 *= 2.0F;
        var2 *= 2.0F;
        var7 *= 2.0D;
        var9 *= 2.0D;
        GlStateManager.disableCull();
        GlStateManager.disableTexture2D();
        GlStateManager.pushMatrix(); // todo
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        wr.begin(9, DefaultVertexFormats.POSITION_COLOR);

        int var15;
        for(var15 = 0; var15 <= 90; var15 += 3) {
            wr.pos((double)(var1 + var5) + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * (double)(var5 * -1.0F), (double)(var2 + var5) + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * (double)(var5 * -1.0F), 0.0D).color(var11[0], var11[1], var11[2], var11[3]).endVertex();
        }

        for(var15 = 90; var15 <= 180; var15 += 3) {
            wr.pos((double)(var1 + var5) + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * (double)(var5 * -1.0F), var9 - (double)var5 + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * (double)(var5 * -1.0F), 0.0D).color(var12[0], var12[1], var12[2], var12[3]).endVertex();
        }

        for(var15 = 0; var15 <= 90; var15 += 3) {
            wr.pos(var7 - (double)var5 + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * (double)var5, var9 - (double)var5 + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * (double)var5, 0.0D).color(var13[0], var13[1], var13[2], var13[3]).endVertex();
        }

        for(var15 = 90; var15 <= 180; var15 += 3) {
            wr.pos(var7 - (double)var5 + Math.sin((double)var15 * 3.141592653589793D / 180.0D) * (double)var5, (double)(var2 + var5) + Math.cos((double)var15 * 3.141592653589793D / 180.0D) * (double)var5, 0.0D).color(var14[0], var14[1], var14[2], var14[3]).endVertex();
        }

        tess.draw();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix(); // todo
        GlStateManager.enableTexture2D();
        GlStateManager.enableCull();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(2.0D, 2.0D, 2.0D);
        GL11.glPopAttrib();
    }

    public int[] getColor(int var1) {
        int var2 = var1 >> 24 & 255;
        int var3 = var1 >> 16 & 255;
        int var4 = var1 >> 8 & 255;
        int var5 = var1 & 255;
        return new int[] {var3, var4, var5, var2};
    }

    public void bridge$drawGradientRect(int var1, int var2, int var3, int var4, int var5, int var6, float var7) {
        float var8 = (float)(var5 >> 24 & 255) / 255.0F;
        float var9 = (float)(var5 >> 16 & 255) / 255.0F;
        float var10 = (float)(var5 >> 8 & 255) / 255.0F;
        float var11 = (float)(var5 & 255) / 255.0F;
        float var12 = (float)(var6 >> 24 & 255) / 255.0F;
        float var13 = (float)(var6 >> 16 & 255) / 255.0F;
        float var14 = (float)(var6 >> 8 & 255) / 255.0F;
        float var15 = (float)(var6 & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        Tessellator var16 = Tessellator.getInstance();
        WorldRenderer var17 = var16.getWorldRenderer();
        var17.begin(7, DefaultVertexFormats.POSITION_COLOR);
        var17.pos(var3, var2, var7);
        var17.color(var9, var10, var11, var8);
        var17.endVertex();
        var17.pos(var1, var2, var7);
        var17.color(var9, var10, var11, var8);
        var17.endVertex();
        var17.pos(var1, var4, var7);
        var17.color(var13, var14, var15, var12);
        var17.endVertex();
        var17.pos(var3, var4, var7);
        var17.color(var13, var14, var15, var12);
        var17.endVertex();
        var16.draw();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public void bridge$drawRectGui(float var1, float var2, float var3, float var4, int var5) {
        float var6;
        if (var1 < var3) {
            var6 = var1;
            var1 = var3;
            var3 = var6;
        }

        if (var2 < var4) {
            var6 = var2;
            var2 = var4;
            var4 = var6;
        }

        var6 = (float)(var5 >> 24 & 255) / 255.0F;
        float var7 = (float)(var5 >> 16 & 255) / 255.0F;
        float var8 = (float)(var5 >> 8 & 255) / 255.0F;
        float var9 = (float)(var5 & 255) / 255.0F;
        Tessellator var10 = Tessellator.getInstance();
        WorldRenderer var11 = var10.getWorldRenderer();
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.color(var7, var8, var9, var6);
        var11.begin(7, DefaultVertexFormats.POSITION);
        var11.pos(var1, var4, 0.0D).endVertex();
        var11.pos(var3, var4, 0.0D).endVertex();
        var11.pos(var3, var2, 0.0D).endVertex();
        var11.pos(var1, var2, 0.0D).endVertex();
        var10.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
    }

    public void bridge$drawCircle(double var1, double var3, double var5, int var7) {
        wr.begin(6, DefaultVertexFormats.POSITION);
        wr.pos(var1, var3, 1.0D);
        wr.endVertex();
        double var8 = 6.283185307179586D;
        double var10 = var8 / 30.0D;

        for(double var12 = -var10; var12 < var8; var12 += var10) {
            wr.pos(var1 + var5 * Math.cos(-var12), var3 + var5 * Math.sin(-var12), 10.0D).endVertex();
        }

        tess.draw();
    }

    public void bridge$drawTriangle(float var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
        try {
            wr.begin(4, DefaultVertexFormats.POSITION);
            wr.pos(var1, var4, 0.0D).endVertex();
            wr.pos(var2, var5, 0.0D).endVertex();
            wr.pos(var3, var6, 0.0D).endVertex();
            tess.draw();
        } catch (Throwable var10) {
            throw var10;
        }
    }

    public void bridge$drawCircleSegment(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        wr.begin(7, DefaultVertexFormats.POSITION);
        wr.pos(var1, var5, 0.0D);
        wr.endVertex();
        wr.pos(var2, var6, 0.0D);
        wr.endVertex();
        wr.pos(var3, var7, 0.0D);
        wr.endVertex();
        wr.pos(var4, var8, 0.0D);
        wr.endVertex();
        tess.draw();
    }

    public void bridge$renderSkybox(int var1, int var2, int var3, float var4) {
        Minecraft var5 = Minecraft.getMinecraft();
        if (this.RES_BACKGROUND == null) {
            this.RES_BACKGROUND = Minecraft.getMinecraft().getTextureManager().getDynamicTextureLocation("background", new DynamicTexture(256, 256));
        }

        var5.getFramebuffer().unbindFramebuffer();
        GlStateManager.viewport(0, 0, 256, 256);
        this.bridge$mainMenuPanorama(var3, var4);
        this.bridge$rotateAndBlurSkyBox(var1, var2);
        byte var6 = 3;

        for(int var7 = 0; var7 < var6; ++var7) {
            this.bridge$rotateAndBlurSkyBox(var1, var2);
            this.bridge$rotateAndBlurSkyBox(var1, var2);
        }

        var5.getFramebuffer().bindFramebuffer(true);
        GlStateManager.viewport(0, 0, var5.displayWidth, var5.displayHeight);
        float var10 = var1 > var2 ? 120.0F / (float)var1 : 120.0F / (float)var2;
        float var8 = (float)var2 * var10 / 256.0F;
        float var9 = (float)var1 * var10 / 256.0F;
        wr.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        wr.pos(0.0D, var2, 0.0D).tex(0.5F - var8, 0.5F + var9).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        wr.pos(var1, var2, 0.0D).tex(0.5F - var8, 0.5F - var9).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        wr.pos(var1, 0.0D, 0.0D).tex(0.5F + var8, 0.5F - var9).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        wr.pos(0.0D, 0.0D, 0.0D).tex(0.5F + var8, 0.5F + var9).color(1.0F, 1.0F, 1.0F, 1.0F).endVertex();
        tess.draw();
    }

    public void bridge$rotateAndBlurSkyBox(int var1, int var2) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(this.RES_BACKGROUND);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
        GL11.glCopyTexSubImage2D(GL11.GL_TEXTURE_2D, 0, 0, 0, 0, 0, 256, 256);
        GlStateManager.enableBlend();
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
        GlStateManager.colorMask(true, true, true, false);
        Tessellator var3 = Tessellator.getInstance();
        WorldRenderer var4 = var3.getWorldRenderer();
        var4.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
        GlStateManager.disableAlpha();
        byte var5 = 3;
        byte var6 = 3;

        for(int var7 = 0; var7 < var6; ++var7) {
            float var8 = 1.0F / (float)(var7 + 1);
            float var9 = (float)(var7 - var5 / 2) / 256.0F;
            var4.pos(var1, var2, 0.0D).tex(0.0F + var9, 1.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
            var4.pos(var1, 0.0D, 0.0D).tex(1.0F + var9, 1.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
            var4.pos(0.0D, 0.0D, 0.0D).tex(1.0F + var9, 0.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
            var4.pos(0.0D, var2, 0.0D).tex(0.0F + var9, 0.0D).color(1.0F, 1.0F, 1.0F, var8).endVertex();
        }

        var3.draw();
        GlStateManager.enableAlpha();
        GlStateManager.colorMask(true, true, true, true);
    }

    public void bridge$mainMenuPanorama(int var1, float var2) {
        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.pushMatrix(); // pushAttrib - pushMatrix
        GlStateManager.loadIdentity(); // pushAttrib - loadIdentity
        Project.gluPerspective(120.0F, 1.0F, 0.05F, 10.0F);
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.pushMatrix(); // pushAttrib - pushMatrix
        GlStateManager.loadIdentity(); // pushAttrib - loadIdentity
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.rotate(180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.enableBlend(); // popAttrib-  enableBlend
        GlStateManager.disableAlpha(); // enableAlpha - disableAlpha
        GlStateManager.disableCull(); // disablePolygonOffset - disableCull
        GlStateManager.depthMask(false);
        GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);

        for(int var3 = 0; var3 < 64; ++var3) {
            GlStateManager.pushMatrix();
            float var4 = ((float)(var3 % 8) / 8.0F - 0.5F) / 64.0F;
            float var5 = ((float)(var3 / 8) / 8.0F - 0.5F) / 64.0F;
            GlStateManager.color(var4, var5, 0.0F);
            GlStateManager.rotate((float)(Math.sin(((float)var1 + var2) / 400.0F) * 25.0D + 20.0D), 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(-((float)var1 + var2) * 0.1F, 0.0F, 1.0F, 0.0F);

            for(int var6 = 0; var6 < 6; ++var6) {
                GlStateManager.pushMatrix(); // pushAttrib - pushMatrix
                if (var6 == 1) {
                    GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var6 == 2) {
                    GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var6 == 3) {
                    GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
                }

                if (var6 == 4) {
                    GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
                }

                if (var6 == 5) {
                    GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
                }

                Minecraft.getMinecraft().getTextureManager().bindTexture(this.titlePanoramaPaths[var6]);
                wr.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                int var7 = (int)(255.0F / (float)(var3 + 1));
                wr.pos(-1.0D, -1.0D, 1.0D).tex(0.0D, 0.0D).color(255, 255, 255, var7).endVertex();
                wr.pos(1.0D, -1.0D, 1.0D).tex(1.0D, 0.0D).color(255, 255, 255, var7).endVertex();
                wr.pos(1.0D, 1.0D, 1.0D).tex(1.0D, 1.0D).color(255, 255, 255, var7).endVertex();
                wr.pos(-1.0D, 1.0D, 1.0D).tex(0.0D, 1.0D).color(255, 255, 255, var7).endVertex();
                tess.draw();
                GlStateManager.popMatrix();
            }

            GlStateManager.popMatrix();
            GlStateManager.colorMask(true, true, true, false);
        }

        wr.setTranslation(0.0D, 0.0D, 0.0D);
        GlStateManager.colorMask(true, true, true, true);
        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.popMatrix(); // popAttrib - popMatrix
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.popMatrix();
        GlStateManager.depthMask(true);
        GlStateManager.enableCull();
        GlStateManager.enableDepth();
    }

    public void bridge$circleHollow(double var1, double var3, double var5, double var7, double var9, int var11, double var12, int var14) {
        Tessellator var15 = Tessellator.getInstance();
        WorldRenderer var16 = var15.getWorldRenderer();
        this.pre(var14);
        var9 = (var9 + (double)var11) % (double)var11;
        var16.begin(7, DefaultVertexFormats.POSITION);

        for(double var17 = 360.0D / (double)var11 * (var9 + var12); var17 < 360.0D / (double)var11 * (var9 + 1.0D - var12) - 0.5D; ++var17) {
            double var19 = -var17 * 3.141592653589793D / 180.0D;
            double var21 = (-var17 - 1.0D) * 3.141592653589793D / 180.0D;
            double[] var23 = new double[] {Math.cos(var19) * var5, -Math.sin(var19) * var5, Math.cos(var21) * var5, -Math.sin(var21) * var5};
            double[] var24 = new double[] {Math.cos(var19) * var7, -Math.sin(var19) * var7, Math.cos(var21) * var7, -Math.sin(var21) * var7};
            var16.pos(var1 + var24[0], var3 + var24[1], 0.0D);
            var16.endVertex();
            var16.pos(var1 + var24[2], var3 + var24[3], 0.0D);
            var16.endVertex();
            var16.pos(var1 + var23[2], var3 + var23[3], 0.0D);
            var16.endVertex();
            var16.pos(var1 + var23[0], var3 + var23[1], 0.0D);
            var16.endVertex();
        }

        var15.draw();
        this.post();
    }

    public void bridge$drawCircleHollow(double var1, double var3, double var5, double var7, double var9, int var11, double var12) {
        GlStateManager.enableBlend();
        GlStateManager.disableTexture2D();
        GL11.glEnable(2848);
        var9 = (var9 + (double)var11) % (double)var11;
        wr.begin(7, DefaultVertexFormats.POSITION);

        for(double var14 = 360.0D / (double)var11 * var9; var14 < 360.0D / (double)var11 * (var9 + var12); ++var14) {
            double var16 = var14 * 3.141592653589793D / 180.0D;
            double var18 = (var14 - 1.0D) * 3.141592653589793D / 180.0D;
            double[] var20 = new double[] {Math.cos(var16) * var5, -Math.sin(var16) * var5, Math.cos(var18) * var5, -Math.sin(var18) * var5};
            double[] var21 = new double[] {Math.cos(var16) * var7, -Math.sin(var16) * var7, Math.cos(var18) * var7, -Math.sin(var18) * var7};
            wr.pos(var1 + var21[0], var3 + var21[1], 0.0D).endVertex();
            wr.pos(var1 + var21[2], var3 + var21[3], 0.0D).endVertex();
            wr.pos(var1 + var20[2], var3 + var20[3], 0.0D).endVertex();
            wr.pos(var1 + var20[0], var3 + var20[1], 0.0D).endVertex();
        }

        tess.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.disableBlend();
        GL11.glDisable(2848);
        GlStateManager.disableBlend();
        GlStateManager.enableTexture2D();
    }

    public void pre(int var1) {
        float var2 = (float)(var1 >> 24 & 255) / 255.0F;
        float var3 = (float)(var1 >> 16 & 255) / 255.0F;
        float var4 = (float)(var1 >> 8 & 255) / 255.0F;
        float var5 = (float)(var1 & 255) / 255.0F;
        GlStateManager.disableTexture2D();
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        GlStateManager.color(var3, var4, var5, var2);
    }

    public void post() {
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
        GlStateManager.enableTexture2D();
    }

    public void bridge$enableStandardItemLighting() {
        RenderHelper.enableStandardItemLighting();
    }

    public void bridge$enableGUIStandardItemLighting() {
        RenderHelper.enableGUIStandardItemLighting();
    }

    public void bridge$disableStandardItemLighting() {
        RenderHelper.disableStandardItemLighting();
    }

    public void bridge$texturedModalRect(float var1, float var2, int var3, int var4, int var5, int var6) {
        float var7 = 0.00390625F;
        float var8 = 0.00390625F;
        Tessellator var9 = Tessellator.getInstance();
        WorldRenderer var10 = var9.getWorldRenderer();
        var10.begin(7, DefaultVertexFormats.POSITION_TEX);
        var10.pos(var1 + 0.0F, var2 + (float)var6, 0.0D);
        var10.tex((float)(var3 + 0) * var7, (float)(var4 + var6) * var8);
        var10.endVertex();
        var10.pos(var1 + (float)var5, var2 + (float)var6, 0.0D);
        var10.tex((float)(var3 + var5) * var7, (float)(var4 + var6) * var8);
        var10.endVertex();
        var10.pos(var1 + (float)var5, var2 + 0.0F, 0.0D);
        var10.tex((float)(var3 + var5) * var7, (float)(var4 + 0) * var8);
        var10.endVertex();
        var10.pos(var1 + 0.0F, var2 + 0.0F, 0.0D);
        var10.tex((float)(var3 + 0) * var7, (float)(var4 + 0) * var8);
        var10.endVertex();
        var9.draw();
    }

    public void bridge$project(float var1, float var2, float var3, FloatBuffer var4, FloatBuffer var5, IntBuffer var6, FloatBuffer var7) {
        GLU.gluProject(var1, var2, var3, var4, var5, var6, var7);
    }

    public void bridge$drawEntityOnScreen(float var1, float var2, float var3, float var4, float var5, float var6, EntityLivingBaseBridge var7) {
        EntityLivingBase var8 = (EntityLivingBase)var7;
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.color(var1, var2, 100.0F);
        GlStateManager.translate(-var3, var3, var3);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float var9 = var8.renderYawOffset;
        float var10 = var8.rotationYaw;
        float var11 = var8.rotationPitch;
        float var12 = var8.prevRotationYawHead;
        float var13 = var8.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan(var6 / 40.0F)) * 20.0F, 1.0F, 0.0F, 0.0F);
        var8.renderYawOffset = (float)Math.atan(var5 / 40.0F) * 20.0F - var4;
        var8.rotationYaw = (float)Math.atan(var5 / 40.0F) * 40.0F - var4;
        var8.rotationPitch -= (float)Math.atan(var6 / 40.0F) * 20.0F;
        var8.rotationYawHead = var8.rotationYaw;
        var8.prevRotationYawHead = var8.rotationYaw;
        GlStateManager.color(0.0F, 0.0F, 0.0F);
        RenderManager var14 = Minecraft.getMinecraft().getRenderManager();
        System.out.println("RenderManager: " + var14);
        System.out.println("EntityLivingBase: " + var8);
        var14.setPlayerViewY(180.0F);
        var14.setRenderShadow(false);
        //var14.renderEntityWithPosYaw(var8, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        var14.setRenderShadow(true);
        var8.renderYawOffset = var9;
        var8.rotationYaw = var10;
        var8.rotationPitch = var11;
        var8.prevRotationYawHead = var12;
        var8.rotationYawHead = var13;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

    public void bridge$highlightRegion(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, double var17, int var19) {
        TesselatorImplementation var20 = TesselatorImplementation.paepeppsehahahaeeppsssesp();
        Vector3d var21 = new Vector3d(var7, var9, var11);
        Vector3d var22 = new Vector3d(var13, var15, var17);
        if (var20 != null) {
            var20.setTranslation(var1, var3, var5);
            var20.setDelta(0.0D);
            GL11.glEnable(GL11.GL_LINE_SMOOTH);
            var20.beginLines();
            var20.drawCuboid(var21, var22, 63, var19);
            var20.draw();
            GL11.glDisable(GL11.GL_LINE_SMOOTH);
        }

    }

    public void bridge$highlightBlock(double var1, double var3, double var5, double var7, double var9, double var11, int var13) {
        TesselatorImplementation.paepeppsehahahaeeppsssesp().setTranslation(var1, var3, var5);
        TesselatorImplementation.paepeppsehahahaeeppsssesp().setDelta(0.004999999888241291D);
        TesselatorImplementation.paepeppsehahahaeeppsssesp().drawCuboid(new Vector3d(var7, var9, var11), 63, var13);
    }

    public void bridge$drawNameplate(FontRendererBridge var1, String var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11, EntityBridge var12) {
        drawNameplate((FontRenderer)var1, var2, var3, var5, var7, var9, var10, var11, (Entity)var12);
    }

    public void bridge$drawModalRectWithCustomSizedTexture(int var1, int var2, float var3, float var4, int var5, int var6, float var7, float var8) {
        float var9 = 1.0F / var7;
        float var10 = 1.0F / var8;
        Tessellator var11 = Tessellator.getInstance();
        WorldRenderer var12 = var11.getWorldRenderer();
        var12.begin(7, DefaultVertexFormats.POSITION_TEX);
        var12.pos(var1, var2 + var6, 0.0D).tex(var3 * var9, (var4 + (float)var6) * var10).endVertex();
        var12.pos(var1 + var5, var2 + var6, 0.0D).tex((var3 + (float)var5) * var9, (var4 + (float)var6) * var10).endVertex();
        var12.pos(var1 + var5, var2, 0.0D).tex((var3 + (float)var5) * var9, var4 * var10).endVertex();
        var12.pos(var1, var2, 0.0D).tex(var3 * var9, var4 * var10).endVertex();
        var11.draw();
    }

    public void bridge$drawNameplates(FontRendererBridge var1, List var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11, EntityBridge var12) {
        drawNameplates((FontRenderer)var1, var2, var3, var5, var7, var9, var10, var11, (Entity)var12);
    }

    public static void drawNameplates(FontRenderer var0, List var1, double var2, double var4, double var6, float var8, boolean var9) {
        drawNameplates(var0, var1, var2, var4, var6, var8, var9, false, null);
    }

    public static void drawNameplates(FontRenderer var0, List<String> var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10, Entity var11) {
        int var12 = 0;

        for(Iterator<String> var13 = var1.iterator(); var13.hasNext(); ++var12) {
            String var14 = var13.next();
            var4 += (float)var12 / 3.5F;
            drawNameplate(var0, var14, var2, var4, var6, var8, var9, var10, var11);
        }

    }

    public static void drawNameplate(FontRenderer var0, String var1, double var2, double var4, double var6, float var8, boolean var9) {
        drawNameplate(var0, var1, var2, var4, var6, var8, var9, false, null);
    }

    public static void drawNameplate(FontRenderer var0, String var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10, Entity var11) {
        // $FF: Couldn't be decompiled
    }

    public void bridge$turnOnLighting() {
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_LIGHT0);
        GL11.glEnable(GL11.GL_LIGHT1);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glColorMaterial(GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
    }

    static {
        wr = tess.getWorldRenderer();
    }
}
package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.IResourceManagerReloadListenerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.FontRendererCache;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.util.lIlIlIlIlIIlIIlIIllIIIIIl;
import com.moonsworth.lunar.client.util.lIllIlIIIlIIIIIIIlllIlIll;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.io.InputStream;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Mixin(FontRenderer.class)
public abstract class MixinFontRendererz implements IResourceManagerReloadListenerBridge, FontRendererBridge {

    private static final Tessellator tess = Tessellator.getInstance();
    private static final WorldRenderer wr = tess.getWorldRenderer();
    private static final FloatBuffer currentColor = BufferUtils.createFloatBuffer(16);

    public ResourceLocation currentTexture;
    public int index;
    public int remaining;
    public boolean[] rendered;
    public FontRendererCache cache = new FontRendererCache();
    public List<lIllIlIIIlIIIIIIIlllIlIll> renderPasses;
    public long currentTick;
    public float offsetBold;

    @Shadow
    public ResourceLocation locationFontTexture;
    @Shadow
    public int textColor;
    @Shadow
    public float red;
    @Shadow
    public float blue;
    @Shadow
    public float green;
    @Shadow
    public float alpha;
    @Shadow
    public float posX;
    @Shadow
    public float posY;
    @Shadow
    public byte[] glyphWidth;
    @Shadow
    public boolean strikethroughStyle;
    @Shadow
    public boolean underlineStyle;
    @Shadow
    public int FONT_HEIGHT;
    @Shadow
    public boolean italicStyle;
    @Shadow
    public boolean boldStyle;
    @Shadow
    public boolean unicodeFlag;
    @Shadow
    public Random fontRandom;
    @Shadow
    public boolean randomStyle;
    @Shadow
    public int[] colorCode;
    @Shadow
    public boolean bidiFlag;

    public float[] charWidthFloat;

    public MixinFontRendererz() {
    }

    @Shadow
    public abstract ResourceLocation getUnicodePageLocation(int var1);

    @Shadow
    protected abstract void resetStyles();

    @Shadow
    protected abstract String bidiReorder(String var1);

    @Shadow
    public abstract int getCharWidth(char var1);

//    @Shadow
//    public abstract InputStream getResourceInputStream(ResourceLocation var1);

    public float getCharWidthFloat(char var1) {
        if (var1 == 167) {
            return -1.0F;
        } else if (var1 == ' ') {
            return this.charWidthFloat[32];
        } else {
            int var2 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(var1);
            if (var1 > 0 && var2 != -1 && !this.unicodeFlag) {
                return this.charWidthFloat[var2];
            } else if (this.glyphWidth[var1] != 0) {
                int var3 = this.glyphWidth[var1] >>> 4;
                int var4 = this.glyphWidth[var1] & 15;
                var3 &= 15;
                ++var4;
                return (float)((var4 - var3) / 2 + 1);
            } else {
                return 0.0F;
            }
        }
    }

//   @Overwrite
    public void readFontTexture() {
//        BufferedImage var1;
//        try {
//            var1 = TextureUtil.readBufferedImage(this.b(this.locationFontTexture));
//        } catch (IOException var21) {
//            throw new Class18(var21);
//        }
//
//        Properties var2 = FontUtils.readFontProperties(this.locationFontTexture);
//        int var3 = var1.getWidth();
//        int var4 = var1.getHeight();
//        int var5 = var3 / 16;
//        int var6 = var4 / 16;
//        float var7 = (float)var3 / 128.0F;
//        float var8 = Config.limit(var7, 1.0F, 2.0F);
//        this.offsetBold = 1.0F / var8;
//        float var9 = FontUtils.readFloat(var2, "offsetBold", -1.0F);
//        if (var9 >= 0.0F) {
//            this.offsetBold = var9;
//        }
//
//        int[] var10 = new int[var3 * var4];
//        var1.getRGB(0, 0, var3, var4, var10, 0, var3);
//
//        for(int var11 = 0; var11 < 256; ++var11) {
//            int var12 = var11 % 16;
//            int var13 = var11 / 16;
//            boolean var14 = false;
//
//            int var22;
//            for(var22 = var5 - 1; var22 >= 0; --var22) {
//                int var15 = var12 * var5 + var22;
//                boolean var16 = true;
//
//                for(int var17 = 0; var17 < var6 && var16; ++var17) {
//                    int var18 = (var13 * var6 + var17) * var3;
//                    int var19 = var10[var15 + var18];
//                    int var20 = var19 >> 24 & 255;
//                    if (var20 > 16) {
//                        var16 = false;
//                    }
//                }
//
//                if (!var16) {
//                    break;
//                }
//            }
//
//            if (var11 == 65) {
//                var11 = var11;
//            }
//
//            if (var11 == 32) {
//                if (var5 <= 8) {
//                    var22 = (int)(2.0F * var7);
//                } else {
//                    var22 = (int)(1.5F * var7);
//                }
//            }
//
//            this.charWidthFloat[var11] = (float)(var22 + 1) / var7 + 1.0F;
//        }
//
//        FontUtils.readCustomCharWidths(var2, this.charWidthFloat);
    }

    @Overwrite
    public float renderChar(char var1, boolean var2) {
        if (var1 == ' ') {
            this.markRendered();
            return !this.unicodeFlag ? this.charWidthFloat[var1] : 4.0F;
        } else {
            int var3 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(var1);
            return var3 != -1 && !this.unicodeFlag ? this.renderDefaultChar(var3, var2) : this.renderDefaultChar(var1, var2);
        }
    }

    @Overwrite
    public float renderDefaultChar(int var1, boolean var2) {
        if (this.currentTexture == null && !this.rendered[this.index]) {
            this.currentTexture = this.locationFontTexture;
            if (!wr.isDrawing) {
                int var3 = GL11.glGenLists(1);
                this.renderPasses.add(new lIllIlIIIlIIIIIIIlllIlIll(var3, (ResourceLocationBridge)this.locationFontTexture));
                GL11.glNewList(var3, 4864);
                wr.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
            }
        }

        if (this.currentTexture == this.locationFontTexture) {
            float var11 = (float)(var1 % 16 * 8);
            float var4 = (float)(var1 / 16 * 8);
            float var5 = var2 ? 1.0F : 0.0F;
            float var6 = 7.99F;
            float var7 = this.textColor == -1 ? this.red : (float)(this.textColor >> 16) / 255.0F;
            float var8 = this.textColor == -1 ? this.blue : (float)(this.textColor >> 8 & 255) / 255.0F;
            float var9 = this.textColor == -1 ? this.green : (float)(this.textColor & 255) / 255.0F;
            float var10 = this.alpha;
            wr.pos(this.posX + var5, this.posY, 0.0D).tex(var11 / 128.0F, var4 / 128.0F).color(var7, var8, var9, var10).endVertex();
            wr.pos(this.posX - var5, this.posY + 7.99F, 0.0D).tex(var11 / 128.0F, (var4 + 7.99F) / 128.0F).color(var7, var8, var9, var10).endVertex();
            wr.pos(this.posX + var6 - 1.0F - var5, this.posY + 7.99F, 0.0D).tex((var11 + var6 - 1.0F) / 128.0F, (var4 + 7.99F) / 128.0F).color(var7, var8, var9, var10).endVertex();
            wr.pos(this.posX + var6 - 1.0F + var5, this.posY, 0.0D).tex((var11 + var6 - 1.0F) / 128.0F, var4 / 128.0F).color(var7, var8, var9, var10).endVertex();
            this.markRendered();
        }

        return this.charWidthFloat[var1];
    }

    @Overwrite
    public void loadGlyphTexture(int var1) {
    }

    @Overwrite
    public float renderUnicodeChar(char var1, boolean var2) {
        if (this.glyphWidth[var1] == 0) {
            this.markRendered();
            return 0.0F;
        } else {
            ResourceLocation var3 = this.getUnicodePageLocation(var1 / 256);
            int var4 = this.glyphWidth[var1] >>> 4;
            int var5 = this.glyphWidth[var1] & 15;
            var4 &= 15;
            float var6 = (float)var4;
            float var7 = (float)(var5 + 1);
            if (this.currentTexture == null && !this.rendered[this.index]) {
                this.currentTexture = var3;
                if (!wr.isDrawing) {
                    int var8 = GL11.glGenLists(1);
                    this.renderPasses.add(new lIllIlIIIlIIIIIIIlllIlIll(var8, (ResourceLocationBridge)var3));
                    GL11.glNewList(var8, 4864);
                    wr.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
                }
            }

            if (this.currentTexture == var3) {
                float var16 = (float)(var1 % 16 * 16) + var6;
                float var9 = (float)((var1 & 255) / 16 * 16);
                float var10 = var7 - var6 - 0.02F;
                float var11 = var2 ? 1.0F : 0.0F;
                float var12 = this.textColor == -1 ? this.red : (float)(this.textColor >> 16) / 255.0F;
                float var13 = this.textColor == -1 ? this.blue : (float)(this.textColor >> 8 & 255) / 255.0F;
                float var14 = this.textColor == -1 ? this.green : (float)(this.textColor & 255) / 255.0F;
                float var15 = this.alpha;
                wr.pos(this.posX + var11, this.posY, 0.0D).tex(var16 / 256.0F, var9 / 256.0F).color(var12, var13, var14, var15).endVertex();
                wr.pos(this.posX - var11, this.posY + 7.99F, 0.0D).tex(var16 / 256.0F, (var9 + 15.98F) / 256.0F).color(var12, var13, var14, var15).endVertex();
                wr.pos(this.posX + var10 / 2.0F - var11, this.posY + 7.99F, 0.0D).tex((var16 + var10) / 256.0F, (var9 + 15.98F) / 256.0F).color(var12, var13, var14, var15).endVertex();
                wr.pos(this.posX + var10 / 2.0F + var11, this.posY, 0.0D).tex((var16 + var10) / 256.0F, var9 / 256.0F).color(var12, var13, var14, var15).endVertex();
                this.markRendered();
            }

            return (var7 - var6) / 2.0F + 1.0F;
        }
    }

    public void impl$onRenderStringAtPos(FontRenderer var1, String var2, boolean var3, String var4, float var5, float var6, int var7, boolean var8) {
    }

    public void renderStringAtPos(String var1, boolean var2, int var3) {
//        lIlIlIlIlIIlIIlIIllIIIIIl var4 = this.cache.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var3, var2);
//        if (var4 != null) {
//            var4.lIlIlIlIlIIlIIlIIllIIIIIl(this.currentTick);
//            GL11.glGetFloat(2816, currentColor);
//            GL11.glPushMatrix();
//            GL11.glTranslatef(this.posX, this.posY, 0.0F);
//            var4.lIlIlIlIlIIlIIlIIllIIIIIl();
//            GL11.glPopMatrix();
//            GL11.glColor4f(currentColor.get(0), currentColor.get(1), currentColor.get(2), currentColor.get(3));
//            this.posX += var4.lIllIlIIIlIIIIIIIlllIlIll();
//        } else {
//            float var5 = this.posX;
//            float var6 = this.posY;
//            this.posX = 0.0F;
//            this.posY = 0.0F;
//            this.renderPasses = new ArrayList<>();
//            this.rendered = new boolean[var1.length()];
//            this.remaining = var1.length();
//            boolean var7 = false;
//
//            while (this.remaining >= 0) {
//                if (this.remaining == 0) {
//                    this.remaining = -1;
//                }
//
//                this.posX = 0.0F;
//                this.currentTexture = null;
//                this.textColor = -1;
//                this.b();
//
//                for (this.index = 0; this.index < var1.length(); ++this.index) {
//                    char var8 = var1.charAt(this.index);
//                    int var9;
//                    if (var8 == 167 && this.index + 1 < var1.length()) {
//                        var9 = "0123456789abcdefklmnor".indexOf(Character.toLowerCase(var1.charAt(this.index + 1)));
//                        if (var9 < 16) {
//                            this.randomStyle = false;
//                            this.boldStyle = false;
//                            this.strikethroughStyle = false;
//                            this.underlineStyle = false;
//                            this.italicStyle = false;
//                            if (var9 < 0 || var9 > 15) {
//                                var9 = 15;
//                            }
//
//                            if (var2) {
//                                var9 += 16;
//                            }
//
//                            int var10 = this.colorCode[var9];
//                            this.textColor = var10;
//                        } else if (var9 == 16) {
//                            this.randomStyle = true;
//                            var7 = true;
//                        } else if (var9 == 17) {
//                            this.boldStyle = true;
//                        } else if (var9 == 18) {
//                            this.strikethroughStyle = true;
//                        } else if (var9 == 19) {
//                            this.underlineStyle = true;
//                        } else if (var9 == 20) {
//                            this.italicStyle = true;
//                        } else if (var9 == 21) {
//                            this.randomStyle = false;
//                            this.boldStyle = false;
//                            this.strikethroughStyle = false;
//                            this.underlineStyle = false;
//                            this.italicStyle = false;
//                            this.textColor = -1;
//                        }
//
//                        this.markRendered();
//                        ++this.index;
//                        this.markRendered();
//                    } else {
//                        var9 = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\u0000\u0000\u0000\u0000\u0000\u0000\u0000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u0000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\u0000".indexOf(var1);
//                        if (this.randomStyle && var9 != -1) {
//                            int var11 = this.e(var8);
//
//                            char var12;
//                            do {
//                                var9 =
//                            } while(var11 != this.e(var12));
//                            var8 = var12;
//                        }
//                    }
//                }
//            }
//        }
    }

    @Overwrite
    public void renderStringAtPos(String var1, boolean var2) {
        this.renderStringAtPos(var1, var2, -1);
    }

    public void markRendered() {
        if (!this.rendered[this.index]) {
            this.rendered[this.index] = true;
            --this.remaining;
        }
    }

    public void tick() {
        byte var1 = 10;
        long var2 = this.currentTick - (long)(20 * var1);
        ObjectIterator var4 = this.cache.values().iterator();

        while(true) {
            lIlIlIlIlIIlIIlIIllIIIIIl var5;
            do {
                if (!var4.hasNext()) {
                    if (this.currentTick % 50L == 0L) {
                        this.cache.trim();
                    }

                    ++this.currentTick;
                    return;
                }

                var5 = (lIlIlIlIlIIlIIlIIllIIIIIl)var4.next();
            } while(!var5.llllIIlIIlIIlIIllIIlIIllI() && var5.llIlllIIIllllIIlllIllIIIl() >= var2);

            var5.IlllIIIIIIlllIlIIlllIlIIl();
            var4.remove();
        }
    }

    public void clearCaches() {
        ObjectIterator var1 = this.cache.values().iterator();

        while(var1.hasNext()) {
            lIlIlIlIlIIlIIlIIllIIIIIl var2 = (lIlIlIlIlIIlIIlIIllIIIIIl)var1.next();
            var2.IlllIIIIIIlllIlIIlllIlIIl();
        }

        this.cache.clear();
    }

    static {
    }
}

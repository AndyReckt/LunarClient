package com.moonsworth.lunar.client.font;

import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

/**
 * @author Decencies
 * @since 10/07/2021 15:58
 */
public class LCFont {

    public float lIIIllIllIIllIlllIlIIlllI = 1048.0f;
    public CharData[] lIlIlIlIlIIlIIlIIllIIIIIl = new CharData[256];
    public Font IlllIIIIIIlllIlIIlllIlIIl;
    public boolean lIllIlIIIlIIIIIIIlllIlIll;
    public boolean llIlllIIIllllIIlllIllIIIl;
    public int llllIIlIIlIIlIIllIIlIIllI = -1;
    public int IlIlIlllllIlIIlIlIlllIlIl = 0;
    public int llIIIIIIIllIIllIlIllIIIIl;

    public LCFont(ResourceLocationBridge resourceLocationBridge, float f) {
        Font font;
        try {
            InputStream inputStream = Ref.lIlIlIlIlIIlIIlIIllIIIIIl() == null || Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager() == null ? Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMcDefaultResourcePack().bridge$getInputStream(resourceLocationBridge) : Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getResourceManager().bridge$getResource(resourceLocationBridge).bridge$getInputStream();
            font = Font.createFont(0, inputStream).deriveFont(f);
        }
        catch (Exception exception) {
            font = new Font("Arial", 0, (int)f);
        }
        this.IlllIIIIIIlllIlIIlllIlIIl = font;
        this.lIllIlIIIlIIIIIIIlllIlIll = true;
        this.llIlllIIIllllIIlllIllIIIl = true;
        this.llIIIIIIIllIIllIlIllIIIIl = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(Font font, boolean bl, boolean bl2, CharData[] charDataArray) {
        BufferedImage bufferedImage = this.IlllIIIIIIlllIlIIlllIlIIl(font, bl, bl2, charDataArray);
        int n = Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$glGenTextures();
        Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$uploadTextureImage(n, bufferedImage);
        return n;
    }

    public BufferedImage IlllIIIIIIlllIlIIlllIlIIl(Font font, boolean bl, boolean bl2, CharData[] charDataArray) {
        int n = (int)this.lIIIllIllIIllIlllIlIIlllI;
        BufferedImage bufferedImage = new BufferedImage(n, n, 2);
        Graphics2D graphics2D = (Graphics2D)bufferedImage.getGraphics();
        graphics2D.setFont(font);
        graphics2D.setColor(new Color(255, 255, 255, 0));
        graphics2D.fillRect(0, 0, n, n);
        graphics2D.setColor(Color.WHITE);
        graphics2D.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, bl2 ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, bl ? RenderingHints.VALUE_TEXT_ANTIALIAS_ON : RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, bl ? RenderingHints.VALUE_ANTIALIAS_ON : RenderingHints.VALUE_ANTIALIAS_OFF);
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int n2 = 0;
        int n3 = 0;
        int n4 = 1;
        for (int i = 0; i < charDataArray.length; ++i) {
            char c = (char)i;
            CharData charData = new CharData();
            Rectangle2D rectangle2D = fontMetrics.getStringBounds(String.valueOf(c), graphics2D);
            charData.lIlIlIlIlIIlIIlIIllIIIIIl = rectangle2D.getBounds().width + 8;
            charData.IlllIIIIIIlllIlIIlllIlIIl = rectangle2D.getBounds().height;
            if (n3 + charData.lIlIlIlIlIIlIIlIIllIIIIIl >= n) {
                n3 = 0;
                n4 += n2;
                n2 = 0;
            }
            if (charData.IlllIIIIIIlllIlIIlllIlIIl > n2) {
                n2 = charData.IlllIIIIIIlllIlIIlllIlIIl;
            }
            charData.lIllIlIIIlIIIIIIIlllIlIll = n3;
            charData.llIlllIIIllllIIlllIllIIIl = n4;
            if (charData.IlllIIIIIIlllIlIIlllIlIIl > this.llllIIlIIlIIlIIllIIlIIllI) {
                this.llllIIlIIlIIlIIllIIlIIllI = charData.IlllIIIIIIlllIlIIlllIlIIl;
            }
            charDataArray[i] = charData;
            graphics2D.drawString(String.valueOf(c), n3 + 2, n4 + fontMetrics.getAscent());
            n3 += charData.lIlIlIlIlIIlIIlIIllIIIIIl;
        }
        return bufferedImage;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(CharData[] charDataArray, char c, float f, float f2, int n) {
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        tessellatorBridge.bridge$begin(4, true, false);
        try {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(tessellatorBridge, f, f2, charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl, charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl, charDataArray[c].lIllIlIIIlIIIIIIIlllIlIll, charDataArray[c].llIlllIIIllllIIlllIllIIIl, charDataArray[c].lIlIlIlIlIIlIIlIIllIIIIIl, charDataArray[c].IlllIIIIIIlllIlIIlllIlIIl);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        tessellatorBridge.bridge$end();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TessellatorBridge tessellatorBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        float f9 = f5 / this.lIIIllIllIIllIlllIlIIlllI;
        float f10 = f6 / this.lIIIllIllIIllIlllIlIIlllI;
        float f11 = f7 / this.lIIIllIllIIllIlllIlIIlllI;
        float f12 = f8 / this.lIIIllIllIIllIlllIlIIlllI;
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2).bridge$uv(f9 + f11, f10).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2).bridge$uv(f9, f10).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4).bridge$uv(f9, f10 + f12).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4).bridge$uv(f9, f10 + f12).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2 + f4).bridge$uv(f9 + f11, f10 + f12).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3, f2).bridge$uv(f9 + f11, f10).bridge$endVertex();
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl();
    }

    public int lIlIlIlIlIIlIIlIIllIIIIIl() {
        return (this.llllIIlIIlIIlIIllIIlIIllI - 8) / 2;
    }

    public int IlllIIIIIIlllIlIIlllIlIIl(String string) {
        int n = 0;
        for (char c : string.toCharArray()) {
            if (c >= this.lIlIlIlIlIIlIIlIIllIIIIIl.length) continue;
            n += this.lIlIlIlIlIIlIIlIIllIIIIIl[c].lIlIlIlIlIIlIIlIIllIIIIIl - 8 + this.IlIlIlllllIlIIlIlIlllIlIl;
        }
        return n / 2;
    }

    public boolean IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean bl) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll != bl) {
            this.lIllIlIIIlIIIIIIIlllIlIll = bl;
            Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.llIIIIIIIllIIllIlIllIIIIl);
            this.llIIIIIIIllIIllIlIllIIIIl = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl, bl, this.llIlllIIIllllIIlllIllIIIl, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        }
    }

    public boolean lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(boolean bl) {
        if (this.llIlllIIIllllIIlllIllIIIl != bl) {
            this.llIlllIIIllllIIlllIllIIIl = bl;
            Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.llIIIIIIIllIIllIlIllIIIIl);
            this.llIIIIIIIllIIllIlIllIIIIl = this.lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, bl, this.lIlIlIlIlIIlIIlIIllIIIIIl);
        }
    }

    public Font llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Font font) {
        this.IlllIIIIIIlllIlIIlllIlIIl = font;
        Bridge.lIIIllIllIIllIlllIlIIlllI().bridge$deleteTexture(this.llIIIIIIIllIIllIlIllIIIIl);
        this.llIIIIIIIllIIllIlIllIIIIl = this.lIlIlIlIlIIlIIlIIllIIIIIl(font, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, this.lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public class CharData {
        public int lIlIlIlIlIIlIIlIIllIIIIIl;
        public int IlllIIIIIIlllIlIIlllIlIIl;
        public int lIllIlIIIlIIIIIIIlllIlIll;
        public int llIlllIIIllllIIlllIllIIIl;
    }

}

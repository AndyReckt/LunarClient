package com.moonsworth.lunar.client.setting;

import com.google.gson.JsonObject;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.font.LCFontRenderer;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.component.UIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.AbstractDescritiveSettingUIComponent;
import com.moonsworth.lunar.client.ui.component.type.setting.ColorPickerUIComponent;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

import java.awt.*;
import java.util.function.BiFunction;
import java.util.function.BooleanSupplier;

public class ColorSetting extends NumberSetting {
    public float red;
    public float green;
    public float blue;
    public float alpha;
    public float hue;
    public float saturation;
    public float brightness;
    public BooleanSetting chroma = new BooleanSetting("chroma", false);
    public NumberSetting chromaSpeed = new NumberSetting("chroma_speed", 40, 1, 100);
    public EnumSetting<ChromaType> chromaType = new EnumSetting<>("chroma_type", ChromaType.lIlIlIlIlIIlIIlIIllIIIIIl);

    public ColorSetting(String string, Integer n, BooleanSupplier booleanSupplier) {
        super(string + "_clr", n, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, booleanSupplier);
        this.lIlIIIIIIlIIIllllIllIIlII();
        this.llIlIIIllIIlIllIllIllllIl();
    }

    public ColorSetting(String string, Integer n) {
        this(string, n, () -> false);
    }

    public ColorSetting(String string, float f, float f2, float f3) {
        this(string, f, f2, f3, 1.0f);
    }

    public ColorSetting(String string, float f, float f2, float f3, float f4) {
        this(string, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4));
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(ColorSetting colorSetting) {
        if (this.chroma.llIlllIIIllllIIlllIllIIIl()) {
            return this.llllIIlIIlIIlIIllIIlIIllI() == colorSetting.llllIIlIIlIIlIIllIIlIIllI() && this.lIIIllIllIIllIlllIlIIlllI() == colorSetting.lIIIllIllIIllIlllIlIIlllI() && this.llIIIIIIIllIIllIlIllIIIIl() == colorSetting.llIIIIIIIllIIllIlIllIIIIl() && colorSetting.chroma.llIlllIIIllllIIlllIllIIIl() != false && colorSetting.chromaSpeed.llIlllIIIllllIIlllIllIIIl().equals(this.chromaSpeed.llIlllIIIllllIIlllIllIIIl()) && colorSetting.chromaType.llIlllIIIllllIIlllIllIIIl() == this.chromaType.llIlllIIIllllIIlllIllIIIl();
        }
        return colorSetting.IllIllIIIllIIIlIlIlIIIIll().equals(this.IllIllIIIllIIIlIlIlIIIIll());
    }

    public void setColor(Integer n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lIlIIIIIIlIIIllllIllIIlII();
        this.llIlIIIllIIlIllIllIllllIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        try {
            int n = (int)Long.parseLong(string, 16);
            this.setColor(n);
        } catch (Exception exception) {
            exception.printStackTrace();
            super.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ColorSetting colorSetting) {
        this.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl());
        this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl());
        this.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl());
        this.setColor((Integer)colorSetting.llIlllIIIllllIIlllIllIIIl());
    }

    public Integer lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        if (this.chroma.llIlllIIIllllIIlllIllIIIl()) {
            f = (float)(AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().lIlIlIlIlIIlIIlIIllIIIIIl() + AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl()) - f;
            return ((ChromaType)this.chromaType.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl().apply(f, this);
        }
        return (Integer)this.IllIllIIIllIIIlIlIlIIIIll();
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(float f) {
        return (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl(f) >> 16 & 0xFF) / 255.0f;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(float f) {
        return (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl(f) >> 8 & 0xFF) / 255.0f;
    }

    public float llIlllIIIllllIIlllIllIIIl(float f) {
        return (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl(f) & 0xFF) / 255.0f;
    }

    public float llllIIlIIlIIlIIllIIlIIllI(float f) {
        return (float)(this.lIlIlIlIlIIlIIlIIllIIIIIl(f) >> 24 & 0xFF) / 255.0f;
    }

    public void lIlIIIIIIlIIIllllIllIIlII() {
        this.red = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 16 & 0xFF) / 255.0f;
        this.green = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 8 & 0xFF) / 255.0f;
        this.blue = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() & 0xFF) / 255.0f;
        this.alpha = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 24 & 0xFF) / 255.0f;
    }

    public void llIlIIIllIIlIllIllIllllIl() {
        float[] fArray = Color.RGBtoHSB((int)(this.red * 255.0f), (int)(this.green * 255.0f), (int)(this.blue * 255.0f), new float[3]);
        this.hue = fArray[0];
        this.saturation = fArray[1];
        this.brightness = fArray[2];
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.red = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void llIIIIIIIllIIllIlIllIIIIl(float f) {
        this.green = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void lIIIllIllIIllIlllIlIIlllI(float f) {
        this.blue = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void IlllllIlIIIlIIlIIllIIlIll(float f) {
        this.alpha = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void IllllllllllIlIIIlllIlllll() {
        this.setColor(ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.red, this.green, this.blue, this.alpha));
    }

    public void llIIlIlIIIllIlIlIlIIlIIll(float f) {
        this.hue = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void llIIIlllIIlllIllllIlIllIl(float f) {
        this.saturation = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void lllllIllIllIllllIlIllllII(float f) {
        this.brightness = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void lllllIllIlIIlIIlIIIlllIlI() {
        this.setColor(Color.HSBtoRGB(this.hue, this.saturation, this.brightness));
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        float f3 = Ref.getFontRenderer().bridge$getStringWidth(string);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - f3 / 2.0f, f2, true);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(LCFontRenderer lCFontRenderer, String string, float f, float f2) {
        float f3 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lCFontRenderer, string, f - f3 / 2.0f, f2, true);
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(String string, float f, float f2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2, true);
    }

    public float IlllIIIIIIlllIlIIlllIlIIl(LCFontRenderer lCFontRenderer, String string, float f, float f2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lCFontRenderer, string, f, f2, true);
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(String string, float f, float f2) {
        float f3 = Ref.getFontRenderer().bridge$getStringWidth(string);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f - f3 / 2.0f, f2, false);
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(LCFontRenderer lCFontRenderer, String string, float f, float f2) {
        float f3 = lCFontRenderer.IlllIIIIIIlllIlIIlllIlIIl(string);
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lCFontRenderer, string, f - f3 / 2.0f, f2, false);
    }

    public float llIlllIIIllllIIlllIllIIIl(String string, float f, float f2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2, false);
    }

    public float llIlllIIIllllIIlllIllIIIl(LCFontRenderer lCFontRenderer, String string, float f, float f2) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl(lCFontRenderer, string, f, f2, false);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2, boolean bl) {
        if (this.chroma.llIlllIIIllllIIlllIllIIIl()) {
            float f3 = f;
            for (char c : EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string).toCharArray()) {
                f3 = Ref.getFontRenderer().bridge$drawString(String.valueOf(c), f3, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + f2), bl);
                if (!bl) continue;
                f3 -= 1.0f;
            }
            return f3;
        }
        return Ref.getFontRenderer().bridge$drawString(string, f, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), bl);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(LCFontRenderer lCFontRenderer, String string, float f, float f2, boolean bl) {
        if (this.chroma.llIlllIIIllllIIlllIllIIIl()) {
            float f3 = f;
            for (char c : EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string).toCharArray()) {
                f3 = lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(c), f3, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + f2), bl) + 1.0f;
                if (!bl) continue;
                f3 -= 1.0f;
            }
            return f3;
        }
        return lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string, f, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), bl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, boolean bl) {
        if (bl) {
            float f5 = f + f3;
            float f6 = f2 + f4;
            int n = this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2);
            int n2 = this.lIlIlIlIlIIlIIlIIllIIIIIl(f5 + f6);
            n = (n & 0xFCFCFC) >> 2 | n & 0xFF000000;
            n2 = (n2 & 0xFCFCFC) >> 2 | n2 & 0xFF000000;
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectColor(f + 1.0f, f2 + 1.0f, f3, f4, new int[] {n, n2});
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectColor(f, f2, f3, f4, new int[] {this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 + (f2 + f4))});
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(float f, float f2, float f3, float f4) {
        float f5;
        if (f < f3) {
            f5 = f;
            f = f3;
            f3 = f5;
        }
        if (f2 < f4) {
            f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
    }

    @Override
    public void write(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        if (!this.IllIllIIIllIIIlIlIlIIIIll().equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            jsonObject2.addProperty("value", this.IllIllIIIllIIIlIlIlIIIIll());
        }
        this.chroma.write(jsonObject2);
        this.chromaSpeed.write(jsonObject2);
        this.chromaType.write(jsonObject2);
        if (!jsonObject2.entrySet().isEmpty()) {
            jsonObject.add(this.lIIlIlllIlIlIIIlllIIlIIII(), jsonObject2);
        }
    }

    @Override
    public void read(JsonObject jsonObject) {
        if (!jsonObject.has(this.lIIlIlllIlIlIIIlllIIlIIII()) || jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).isJsonNull()) {
            this.setColor((Integer)this.IIlIllIlllllllIIlIIIllIIl());
            this.chroma.lIlIlIlIlIIlIIlIIllIIIIIl(this.chroma.IIlIllIlllllllIIlIIIllIIl());
            this.chromaSpeed.lIlIlIlIlIIlIIlIIllIIIIIl(this.chromaSpeed.IIlIllIlllllllIIlIIIllIIl());
            this.chromaType.lIlIlIlIlIIlIIlIIllIIIIIl(this.chromaType.IIlIllIlllllllIIlIIIllIIl());
            return;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject(this.lIIlIlllIlIlIIIlllIIlIIII());
        this.chroma.read(jsonObject2);
        this.chromaSpeed.read(jsonObject2);
        this.chromaType.read(jsonObject2);
        if (jsonObject2.has("value") && !jsonObject2.get("value").isJsonNull()) {
            if (jsonObject2.get("value").isJsonPrimitive() && jsonObject2.get("value").getAsJsonPrimitive().isString()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2.get("value").getAsString().replaceFirst("#", ""));
            } else {
                this.setColor(jsonObject2.get("value").getAsInt());
            }
        } else {
            this.setColor((Integer)this.IIlIllIlllllllIIlIIIllIIl());
        }
    }

    @Override
    public AbstractDescritiveSettingUIComponent<Number> getUIComponent(UIComponent uIComponent) {
        return new ColorPickerUIComponent(this, uIComponent);
    }

    @Override
    public void d_() {
        this.chroma.d_();
        this.chromaSpeed.d_();
        this.chromaType.d_();
        super.d_();
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.red;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.green;
    }

    public float e_() {
        return this.blue;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.alpha;
    }

    public float IlIlIlllllIlIIlIlIlllIlIl() {
        return this.hue;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.saturation;
    }

    public float lIIIllIllIIllIlllIlIIlllI() {
        return this.brightness;
    }

    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll() {
        return this.chroma;
    }

    public NumberSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.chromaSpeed;
    }

    public EnumSetting<ChromaType> llIIIlllIIlllIllllIlIllIl() {
        return this.chromaType;
    }

    public enum ChromaType implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("wave", (var0, setting) -> {
            float var2 = (float)((Integer)setting.llIIlIlIIIllIlIlIlIIlIIll().lllIIIIIlllIIlIllIIlIIIlI() - (Integer)setting.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()) / 100.0F;
            float var3 = 2.0E7F * var2;
            float var4 = 1.0E10F * var2;
            float var5 = ((float)System.nanoTime() + var0 * var3) / var4 % 1.0F;
            return (int)(setting.llllIIlIIlIIlIIllIIlIIllI() * 255.0F) << 24 | Color.HSBtoRGB(var5, setting.llIIIIIIIllIIllIlIllIIIIl(), setting.lIIIllIllIIllIlllIlIIlllI()) & 16777215;
        }),
        IlllIIIIIIlllIlIIlllIlIIl("shift", (var0, setting) -> {
            float var2 = (float)((Integer)setting.llIIlIlIIIllIlIlIlIIlIIll().lllIIIIIlllIIlIllIIlIIIlI() - (Integer)setting.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()) / 100.0F;
            float var3 = 1.0E10F * var2;
            float var4 = (float)System.nanoTime() / var3 % 1.0F;
            return (int)(setting.llllIIlIIlIIlIIllIIlIIllI() * 255.0F) << 24 | Color.HSBtoRGB(var4, setting.llIIIIIIIllIIllIlIllIIIIl(), setting.lIIIllIllIIllIlllIlIIlllI()) & 16777215;
        });

        public final String lIllIlIIIlIIIIIIIlllIlIll;
        public final BiFunction<Float, ColorSetting, Integer> llIlllIIIllllIIlllIllIIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public String toString() {
            return this.get(this.lIllIlIIIlIIIIIIIlllIlIll);
        }

        ChromaType(String var3, BiFunction<Float, ColorSetting, Integer> var4) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
            this.llIlllIIIllllIIlllIllIIIl = var4;
        }

        public BiFunction<Float, ColorSetting, Integer> IlllIIIIIIlllIlIIlllIlIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }
    }
}
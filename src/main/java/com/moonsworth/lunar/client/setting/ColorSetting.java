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

/**
 * @author Decencies
 * @since 10/07/2021 18:24
 */
public class ColorSetting
        extends NumberSetting {
    public float lIlIlIlIlIIlIIlIIllIIIIIl;
    public float IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;
    public float llllIIlIIlIIlIIllIIlIIllI;
    public float IlIlIlllllIlIIlIlIlllIlIl;
    public float llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("chroma", false);
    public NumberSetting IlllllIlIIIlIIlIIllIIlIll = new NumberSetting("chroma_speed", 40, 1, 100);
    public EnumSetting llIIlIlIIIllIlIlIlIIlIIll = new EnumSetting("chroma_type", ChromaType.lIlIlIlIlIIlIIlIIllIIIIIl);

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
        if (((Boolean)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            return this.llllIIlIIlIIlIIllIIlIIllI() == colorSetting.llllIIlIIlIIlIIllIIlIIllI() && this.lIIIllIllIIllIlllIlIIlllI() == colorSetting.lIIIllIllIIllIlllIlIIlllI() && this.llIIIIIIIllIIllIlIllIIIIl() == colorSetting.llIIIIIIIllIIllIlIllIIIIl() && (Boolean)colorSetting.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl() != false && ((Integer)colorSetting.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()).equals(this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()) && colorSetting.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl() == this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl();
        }
        return ((Integer)colorSetting.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IllIllIIIllIIIlIlIlIIIIll());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Integer n) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(n);
        this.lIlIIIIIIlIIIllllIllIIlII();
        this.llIlIIIllIIlIllIllIllllIl();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        try {
            int n = (int)Long.parseLong(string, 16);
            this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)n);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            super.lIlIlIlIlIIlIIlIIllIIIIIl(string);
        }
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ColorSetting colorSetting) {
        this.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.IlllllIlIIIlIIlIIllIIlIll().llIlllIIIllllIIlllIllIIIl());
        this.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl((Number)colorSetting.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl());
        this.llIIIlllIIlllIllllIlIllIl().lIlIlIlIlIIlIIlIIllIIIIIl(colorSetting.llIIIlllIIlllIllllIlIllIl().llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)colorSetting.llIlllIIIllllIIlllIllIIIl());
    }

    public Integer lIlIlIlIlIIlIIlIIllIIIIIl(float f) {
        if (((Boolean)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            f = (float)(AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().lIlIlIlIlIIlIIlIIllIIIIIl() + AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI().IlllIIIIIIlllIlIIlllIlIIl()) - f;
            return (Integer)((ChromaType)this.llIIlIlIIIllIlIlIlIIlIIll.llIlllIIIllllIIlllIllIIIl()).IlllIIIIIIlllIlIIlllIlIIl().apply(Float.valueOf(f), this);
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
        this.lIlIlIlIlIIlIIlIIllIIIIIl = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 16 & 0xFF) / 255.0f;
        this.IlllIIIIIIlllIlIIlllIlIIl = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 8 & 0xFF) / 255.0f;
        this.lIllIlIIIlIIIIIIIlllIlIll = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() & 0xFF) / 255.0f;
        this.llIlllIIIllllIIlllIllIIIl = (float)((Integer)this.IllIllIIIllIIIlIlIlIIIIll() >> 24 & 0xFF) / 255.0f;
    }

    public void llIlIIIllIIlIllIllIllllIl() {
        float[] fArray = Color.RGBtoHSB((int)(this.lIlIlIlIlIIlIIlIIllIIIIIl * 255.0f), (int)(this.IlllIIIIIIlllIlIIlllIlIIl * 255.0f), (int)(this.lIllIlIIIlIIIIIIIlllIlIll * 255.0f), new float[3]);
        this.llllIIlIIlIIlIIllIIlIIllI = fArray[0];
        this.IlIlIlllllIlIIlIlIlllIlIl = fArray[1];
        this.llIIIIIIIllIIllIlIllIIIIl = fArray[2];
    }

    public void IlIlIlllllIlIIlIlIlllIlIl(float f) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void llIIIIIIIllIIllIlIllIIIIl(float f) {
        this.IlllIIIIIIlllIlIIlllIlIIl = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void lIIIllIllIIllIlllIlIIlllI(float f) {
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void IlllllIlIIIlIIlIIllIIlIll(float f) {
        this.llIlllIIIllllIIlllIllIIIl = f;
        this.IllllllllllIlIIIlllIlllll();
    }

    public void IllllllllllIlIIIlllIlllll() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer) ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, this.IlllIIIIIIlllIlIIlllIlIIl, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl));
    }

    public void llIIlIlIIIllIlIlIlIIlIIll(float f) {
        this.llllIIlIIlIIlIIllIIlIIllI = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void llIIIlllIIlllIllllIlIllIl(float f) {
        this.IlIlIlllllIlIIlIlIlllIlIl = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void lllllIllIllIllllIlIllllII(float f) {
        this.llIIIIIIIllIIllIlIllIIIIl = f;
        this.lllllIllIlIIlIIlIIIlllIlI();
    }

    public void lllllIllIlIIlIIlIIIlllIlI() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)Color.HSBtoRGB(this.llllIIlIIlIIlIIllIIlIIllI, this.IlIlIlllllIlIIlIlIlllIlIl, this.llIIIIIIIllIIllIlIllIIIIl));
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(String string, float f, float f2) {
        float f3 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(string);
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
        float f3 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(string);
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
        if (((Boolean)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            float f3 = f;
            for (char c : EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string).toCharArray()) {
                f3 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$drawString(String.valueOf(c), f3, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + f2), bl);
                if (!bl) continue;
                f3 -= 1.0f;
            }
            return f3;
        }
        return Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$drawString(string, f, f2, this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), bl);
    }

    public float lIlIlIlIlIIlIIlIIllIIIIIl(LCFontRenderer lCFontRenderer, String string, float f, float f2, boolean bl) {
        if (((Boolean)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            float f3 = f;
            for (char c : EnumChatColor.lIlIlIlIlIIlIIlIIllIIIIIl(string).toCharArray()) {
                f3 = lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(c), (double)f3, (double)f2, (int)this.lIlIlIlIlIIlIIlIIllIIIIIl(f3 + f2), bl) + 1.0f;
                if (!bl) continue;
                f3 -= 1.0f;
            }
            return f3;
        }
        return lCFontRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(string, (double)f, (double)f2, (int)this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), bl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, boolean bl) {
        if (bl) {
            float f5 = f + f3;
            float f6 = f2 + f4;
            int n = this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2);
            int n2 = this.lIlIlIlIlIIlIIlIIllIIIIIl(f5 + f6);
            n = (n & 0xFCFCFC) >> 2 | n & 0xFF000000;
            n2 = (n2 & 0xFCFCFC) >> 2 | n2 & 0xFF000000;
            Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectColor(f + 1.0f, f2 + 1.0f, f3, f4, new int[]{n, n2});
        }
        this.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, f3, f4);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4) {
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawRectColor(f, f2, f3, f4, new int[]{this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f2), this.lIlIlIlIlIIlIIlIIllIIIIIl(f + f3 + (f2 + f4))});
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
    public void lIlIlIlIlIIlIIlIIllIIIIIl(JsonObject jsonObject) {
        JsonObject jsonObject2 = new JsonObject();
        if (!((Integer)this.IllIllIIIllIIIlIlIlIIIIll()).equals(this.IIlIllIlllllllIIlIIIllIIl())) {
            jsonObject2.addProperty("value", (Number)this.IllIllIIIllIIIlIlIlIIIIll());
        }
        this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2);
        if (!jsonObject2.entrySet().isEmpty()) {
            jsonObject.add(this.lIIlIlllIlIlIIIlllIIlIIII(), jsonObject2);
        }
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(JsonObject jsonObject) {
        if (!jsonObject.has(this.lIIlIlllIlIlIIIlllIIlIIII()) || jsonObject.get(this.lIIlIlllIlIlIIIlllIIlIIII()).isJsonNull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)this.IIlIllIlllllllIIlIIIllIIl());
            this.lIIIllIllIIllIlllIlIIlllI.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIIIllIllIIllIlllIlIIlllI.IIlIllIlllllllIIlIIIllIIl());
            this.IlllllIlIIIlIIlIIllIIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((Number)this.IlllllIlIIIlIIlIIllIIlIll.IIlIllIlllllllIIlIIIllIIl());
            this.llIIlIlIIIllIlIlIlIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(this.llIIlIlIIIllIlIlIlIIlIIll.IIlIllIlllllllIIlIIIllIIl());
            return;
        }
        JsonObject jsonObject2 = jsonObject.getAsJsonObject(this.lIIlIlllIlIlIIIlllIIlIIII());
        this.lIIIllIllIIllIlllIlIIlllI.IlllIIIIIIlllIlIIlllIlIIl(jsonObject2);
        this.IlllllIlIIIlIIlIIllIIlIll.IlllIIIIIIlllIlIIlllIlIIl(jsonObject2);
        this.llIIlIlIIIllIlIlIlIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(jsonObject2);
        if (jsonObject2.has("value") && !jsonObject2.get("value").isJsonNull()) {
            if (jsonObject2.get("value").isJsonPrimitive() && jsonObject2.get("value").getAsJsonPrimitive().isString()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(jsonObject2.get("value").getAsString().replaceFirst("#", ""));
            } else {
                this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)jsonObject2.get("value").getAsInt());
            }
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl((Integer)this.IIlIllIlllllllIIlIIIllIIl());
        }
    }

    @Override
    public AbstractDescritiveSettingUIComponent lIlIlIlIlIIlIIlIIllIIIIIl(UIComponent uIComponent) {
        return new ColorPickerUIComponent(this, uIComponent);
    }

    @Override
    public void d_() {
        this.lIIIllIllIIllIlllIlIIlllI.d_();
        this.IlllllIlIIIlIIlIIllIIlIll.d_();
        this.llIIlIlIIIllIlIlIlIIlIIll.d_();
        super.d_();
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }

    public float e_() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float llllIIlIIlIIlIIllIIlIIllI() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public float IlIlIlllllIlIIlIlIlllIlIl() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public float llIIIIIIIllIIllIlIllIIIIl() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public float lIIIllIllIIllIlllIlIIlllI() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public BooleanSetting IlllllIlIIIlIIlIIllIIlIll() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public NumberSetting llIIlIlIIIllIlIlIlIIlIIll() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public EnumSetting llIIIlllIIlllIllllIlIllIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }

    public static enum ChromaType implements IEnumSetting {
        lIlIlIlIlIIlIIlIIllIIIIIl("wave", (var0, var1) -> {
            float var2 = (float)((Integer)var1.llIIlIlIIIllIlIlIlIIlIIll().lllIIIIIlllIIlIllIIlIIIlI() - (Integer)var1.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()) / 100.0F;
            float var3 = 2.0E7F * var2;
            float var4 = 1.0E10F * var2;
            float var5 = ((float)System.nanoTime() + var0 * var3) / var4 % 1.0F;
            return (int)(var1.llllIIlIIlIIlIIllIIlIIllI() * 255.0F) << 24 | Color.HSBtoRGB(var5, var1.llIIIIIIIllIIllIlIllIIIIl(), var1.lIIIllIllIIllIlllIlIIlllI()) & 16777215;
        }),
        IlllIIIIIIlllIlIIlllIlIIl("shift", (var0, var1) -> {
            float var2 = (float)((Integer)var1.llIIlIlIIIllIlIlIlIIlIIll().lllIIIIIlllIIlIllIIlIIIlI() - (Integer)var1.llIIlIlIIIllIlIlIlIIlIIll().llIlllIIIllllIIlllIllIIIl()) / 100.0F;
            float var3 = 1.0E10F * var2;
            float var4 = (float)System.nanoTime() / var3 % 1.0F;
            return (int)(var1.llllIIlIIlIIlIIllIIlIIllI() * 255.0F) << 24 | Color.HSBtoRGB(var4, var1.llIIIIIIIllIIllIlIllIIIIl(), var1.lIIIllIllIIllIlllIlIIlllI()) & 16777215;
        });

        public final String lIllIlIIIlIIIIIIIlllIlIll;
        public final BiFunction<Float, ColorSetting, Integer> llIlllIIIllllIIlllIllIIIl;

        public String lIlIlIlIlIIlIIlIIllIIIIIl() {
            return this.lIllIlIIIlIIIIIIIlllIlIll;
        }

        public String toString() {
            return this.get(this.lIllIlIIIlIIIIIIIlllIlIll, new Object[0]);
        }

        ChromaType(String var3, BiFunction<Float, ColorSetting, Integer> var4) {
            this.lIllIlIIIlIIIIIIIlllIlIll = var3;
            this.llIlllIIIllllIIlllIllIIIl = var4;
        }

        public BiFunction IlllIIIIIIlllIlIIlllIlIIl() {
            return this.llIlllIIIllllIIlllIllIIIl;
        }
    }
}
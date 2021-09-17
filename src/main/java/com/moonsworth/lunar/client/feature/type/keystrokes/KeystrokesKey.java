package com.moonsworth.lunar.client.feature.type.keystrokes;

import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ColorUtil;

public class KeystrokesKey {
    public String lIlIlIlIlIIlIIlIIllIIIIIl;
    public KeyBindingBridge IlllIIIIIIlllIlIIlllIlIIl;
    public float lIllIlIIIlIIIIIIIlllIlIll;
    public float llIlllIIIllllIIlllIllIIIl;
    public boolean llllIIlIIlIIlIIllIIlIIllI;
    public long IlIlIlllllIlIIlIlIlllIlIl;
    public ColorSetting llIIIIIIIllIIllIlIllIIIIl;
    public ColorSetting lIIIllIllIIllIlllIlIIlllI;

    public KeystrokesKey(String string, KeyBindingBridge keyBindingBridge, float f, float f2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = string;
        this.IlllIIIIIIlllIlIIlllIlIIl = keyBindingBridge;
        this.lIllIlIIIlIIIIIIIlllIlIll = f;
        this.llIlllIIIllllIIlllIllIIIl = f2;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, ColorSetting colorSetting, ColorSetting colorSetting2, ColorSetting colorSetting3, ColorSetting colorSetting4, boolean bl) {
        ColorSetting colorSetting5;
        float f3;
        float f4;
        float f5;
        boolean bl2;
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        boolean bl3 = bl2 = Bridge.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getKey()) && Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen() == null;
        if (bl2 && !this.llllIIlIIlIIlIIllIIlIIllI) {
            this.llllIIlIIlIIlIIllIIlIIllI = true;
            this.IlIlIlllllIlIIlIlIlllIlIl = System.currentTimeMillis();
            this.llIIIIIIIllIIllIlIllIIIIl = colorSetting3;
            this.lIIIllIllIIllIlllIlIIlllI = colorSetting4;
        } else if (this.llllIIlIIlIIlIIllIIlIIllI && !bl2) {
            this.llllIIlIIlIIlIIllIIlIIllI = false;
            this.IlIlIlllllIlIIlIlIlllIlIl = System.currentTimeMillis();
            this.llIIIIIIIllIIllIlIllIIIIl = colorSetting4;
            this.lIIIllIllIIllIlllIlIIlllI = colorSetting3;
        }
        float f6 = 75.0f;
        if ((float)(System.currentTimeMillis() - this.IlIlIlllllIlIIlIlIlllIlIl) < f6) {
            float f7 = System.currentTimeMillis() - this.IlIlIlllllIlIIlIlIlllIlIl;
            float f8 = f7 / f6;
            f5 = f + f2;
            f4 = f8 * this.lIIIllIllIIllIlllIlIIlllI.IlllIIIIIIlllIlIIlllIlIIl(f5) + (1.0f - f8) * this.llIIIIIIIllIIllIlIllIIIIl.IlllIIIIIIlllIlIIlllIlIIl(f5);
            float f9 = f8 * this.lIIIllIllIIllIlllIlIIlllI.lIllIlIIIlIIIIIIIlllIlIll(f5) + (1.0f - f8) * this.llIIIIIIIllIIllIlIllIIIIl.lIllIlIIIlIIIIIIIlllIlIll(f5);
            float f10 = f8 * this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl(f5) + (1.0f - f8) * this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl(f5);
            f3 = f8 * this.lIIIllIllIIllIlllIlIIlllI.llllIIlIIlIIlIIllIIlIIllI(f5) + (1.0f - f8) * this.llIIIIIIIllIIllIlIllIIIIl.llllIIlIIlIIlIIllIIlIIllI(f5);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f, f2, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl, ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(f4, f9, f10, f3));
        } else {
            ColorSetting colorSetting6 = bl2 ? colorSetting4 : colorSetting3;
            colorSetting6.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, this.lIllIlIIIlIIIIIIIlllIlIll, this.llIlllIIIllllIIlllIllIIIl);
        }
        ColorSetting colorSetting7 = colorSetting5 = bl2 ? colorSetting2 : colorSetting;
        if (this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getKey() == minecraftBridge.bridge$getGameSettings().bridge$keyBindJump().bridge$getKey()) {
            colorSetting5.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.lIllIlIIIlIIIIIIIlllIlIll / 2.0f - this.lIllIlIIIlIIIIIIIlllIlIll / 6.0f, f2 + 3.0f, this.lIllIlIIIlIIIIIIIlllIlIll / 3.0f, 1.0f, bl);
        } else {
            boolean bl4;
            KeyStrokesMod keyStrokesMod = Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().llIIIlllIIlllIllllIlIllIl();
            f5 = f + this.lIllIlIIIlIIIIIIIlllIlIll / 2.0f;
            f4 = f2 + this.llIlllIIIllllIIlllIllIIIl / 2.0f - (float)(Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl() / 2) + 1.0f;
            boolean bl5 = this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getKey() == minecraftBridge.bridge$getGameSettings().bridge$keyBindAttack().bridge$getKey() && (Boolean)keyStrokesMod.IIIIIIIIIIIIIIIllllIIlIIl().llIlllIIIllllIIlllIllIIIl() != false;
            boolean bl6 = bl4 = this.IlllIIIIIIlllIlIIlllIlIIl.bridge$getKey() == minecraftBridge.bridge$getGameSettings().bridge$keyBindUseItem().bridge$getKey() && (Boolean)keyStrokesMod.llIIIIllIlIIlIlIIlllIllIl().llIlllIIIllllIIlllIllIIIl() != false;
            if (bl5 || bl4) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
                f3 = 0.6f;
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(f3, f3, 0.0);
                f4 = f2 + this.llIlllIIIllllIIlllIllIIIl - (float)Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl() + 2.0f;
                String string = Ref.IlllIIIIIIlllIlIIlllIlIIl().IlIlIllIIllllIllllllIIlIl().lIlIlIlIlIIlIIlIIllIIIIIl(bl5) + " CPS";
                if (bl) {
                    Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(string, f5 / f3, f4 / f3, colorSetting5.lIlIlIlIlIIlIIlIIllIIIIIl(f5 + f4));
                } else {
                    Ref.IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl(string, f5 / f3, f4 / f3, colorSetting5.lIlIlIlIlIIlIIlIIllIIIIIl(f5 + f4));
                }
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(1.0, 1.0, 0.0);
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
                f4 = f2 + this.llIlllIIIllllIIlllIllIIIl / 4.0f - (float)(Ref.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl() / 4);
            }
            if (bl) {
                colorSetting5.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIlIlIlIIlIIlIIllIIIIIl, f5, f4);
            } else {
                colorSetting5.lIllIlIIIlIIIIIIIlllIlIll(this.lIlIlIlIlIIlIIlIIllIIIIIl, f5, f4);
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(KeyBindingBridge keyBindingBridge) {
        this.IlllIIIIIIlllIlIIlllIlIIl = keyBindingBridge;
    }

    public String lIlIlIlIlIIlIIlIIllIIIIIl() {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl;
    }

    public float IlllIIIIIIlllIlIIlllIlIIl() {
        return this.lIllIlIIIlIIIIIIIlllIlIll;
    }

    public float lIllIlIIIlIIIIIIIlllIlIll() {
        return this.llIlllIIIllllIIlllIllIIIl;
    }

    public KeyBindingBridge llIlllIIIllllIIlllIllIIIl() {
        return this.IlllIIIIIIlllIlIIlllIlIIl;
    }
}
 
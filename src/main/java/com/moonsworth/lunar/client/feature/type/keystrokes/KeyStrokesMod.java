package com.moonsworth.lunar.client.feature.type.keystrokes;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.event.type.gui.GuiOpenEvent;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;

public class KeyStrokesMod extends DraggableHudMod {
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public BooleanSetting IllllllllllIlIIIlllIlllll;
    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI;
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public ColorSetting IIlIllIlIIllIIlIlIllllllI;
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public ColorSetting lIIIlllIIIIllllIlIIIlIIll;
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public NumberSetting llIlIIIllIIlIllIllIllllIl;
    public KeystrokesKey llIIIlIllIIIIlIIIlIlIllIl;
    public KeystrokesKey llllIlIllllIlIlIIIllIlIlI;
    public KeystrokesKey IlIllIIlIIlIIIllIllllIIll;
    public KeystrokesKey lIllllIllIIlIIlIIIlIIIlII;
    public KeystrokesKey lIlIlIIIIIIllIlIIIIllIIII;
    public KeystrokesKey lIIlIIIIIIlIIlIIllIlIIlII;
    public KeystrokesKey IlIIlIIlIIlIIllIIIllIIllI;

    public KeyStrokesMod() {
        super(false, HudModPosition.TOP_LEFT);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl((f) -> this.IlIllIIlIIlIIIllIllllIIll());
        this.lllllIllIlIIlIIlIIIlllIlI.lIlIlIlIlIIlIIlIIllIIIIIl((bl) -> this.IlIllIIlIIlIIIllIllllIIll());
        this.lIlIlIlIlIIlIIlIIllIIIIIl(GuiOpenEvent.class, guiOpenEvent -> {
            if (Ref.llIIIlllIIlllIllllIlIllIl() != null && Ref.getMinecraft().bridge$getCurrentScreen().bridge$isControlsGui()) {
                this.IlIllIIlIIlIIIllIllllIIll();
            }
        });
    }

    @Override
    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0f, 46.0f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        if (this.llIllIlIllIlllIllIIIIllII.llIlllIIIllllIIlllIllIIIl()) {
            this.llIIIlIllIIIIlIIIlIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + 1.0f, f2, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            this.llllIlIllllIlIlIIIllIlIlI.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + this.llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll() + 1.0f, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            this.lIllllIllIIlIIlIIIlIIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + 1.0f, f2 + this.llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll() + 1.0f, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            this.IlIllIIlIIlIIIllIllllIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + this.lIllllIllIIlIIlIIIlIIIlII.IlllIIIIIIlllIlIIlllIlIIl() + 2.0f, f2 + this.llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll() + 1.0f, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            f3 = this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + this.lIllllIllIIlIIlIIIlIIIlII.IlllIIIIIIlllIlIIlllIlIIl() + this.IlIllIIlIIlIIIllIllllIIll.IlllIIIIIIlllIlIIlllIlIIl() + 2.0f;
            f4 += this.llIIIlIllIIIIlIIIlIlIllIl.lIllIlIIIlIIIIIIIlllIlIll() + 2.0f + this.lIllllIllIIlIIlIIIlIIIlII.lIllIlIIIlIIIIIIIlllIlIll();
        }
        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
            this.lIlIlIIIIIIllIlIIIIllIIII.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            this.lIIlIIIIIIlIIlIIllIlIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.lIlIlIIIIIIllIlIIIIllIIII.IlllIIIIIIlllIlIIlllIlIIl() + 1.0f, f2 + f4, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            f3 = this.lIlIlIIIIIIllIlIIIIllIIII.IlllIIIIIIlllIlIIlllIlIIl() + this.lIIlIIIIIIlIIlIIllIlIIlII.IlllIIIIIIlllIlIIlllIlIIl() + 1.0f;
            f4 += this.lIIlIIIIIIlIIlIIllIlIIlII.lIllIlIIIlIIIIIIIlllIlIll() + 1.0f;
        }
        if (this.IllllllllllIlIIIlllIlllll.llIlllIIIllllIIlllIllIIIl()) {
            this.IlIIlIIlIIlIIllIIIllIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f4, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII, this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl());
            f4 += this.IlIIlIIlIIlIIllIIIllIIllI.lIllIlIIIlIIIIIIIlllIlIll() + 1.0f;
        }
        this.IlllIIIIIIlllIlIIlllIlIIl(f3, f4 < 18.0f ? 18.0f : f4 + 2.0f);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("clicks", true);
        this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("leftCPS", false, () -> this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() == false);
        this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("rightCPS", false, () -> this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() == false);
        this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("movement", true);
        this.IllllllllllIlIIIlllIlllll = new BooleanSetting("spacebar", false);
        this.lllllIllIlIIlIIlIIIlllIlI = new BooleanSetting("arrows", false);
        this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("textShadow", false);
        this.llIlIIIllIIlIllIllIllllIl = new NumberSetting("box_size", Float.valueOf(18.0f), Float.valueOf(10.0f), Float.valueOf(32.0f));
        this.IIlIllIlIIllIIlIlIllllllI = new ColorSetting("text", -1);
        this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("text_pressed", -16777216);
        this.lIIIlllIIIIllllIlIIIlIIll = new ColorSetting("background", 0x6F000000);
        this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("background_pressed", 0x6FFFFFFF);
        return ImmutableList.of(this.IllIllIIIllIIIlIlIlIIIIll, this.IIlIllIlllllllIIlIIIllIIl, this.lIIlIlllIlIlIIIlllIIlIIII, this.llIllIlIllIlllIllIIIIllII, this.IllllllllllIlIIIlllIlllll, this.lllllIllIlIIlIIlIIIlllIlI, this.IllIIIlllIIIlIlllIlIIlIII, this.llIlIIIllIIlIllIllIllllIl, this.IIlIllIlIIllIIlIlIllllllI, this.lllIIIIIlllIIlIllIIlIIIlI, this.lIIIlllIIIIllllIlIIIlIIll, this.lIlIIIIIIlIIIllllIllIIlII);
    }

    public void IlIllIIlIIlIIIllIllllIIll() {
        KeyBindingBridge keyBindingBridge = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindForward();
        KeyBindingBridge keyBindingBridge2 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindLeft();
        KeyBindingBridge keyBindingBridge3 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindBack();
        KeyBindingBridge keyBindingBridge4 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindRight();
        float f = this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl().floatValue();
        String string = keyBindingBridge.bridge$getKeyName().toUpperCase();
        String string2 = keyBindingBridge2.bridge$getKeyName().toUpperCase();
        String string3 = keyBindingBridge3.bridge$getKeyName().toUpperCase();
        String string4 = keyBindingBridge4.bridge$getKeyName().toUpperCase();
        float f2 = Ref.getFontRenderer().bridge$getStringWidth(string);
        float f3 = Ref.getFontRenderer().bridge$getStringWidth(string2);
        float f4 = Ref.getFontRenderer().bridge$getStringWidth(string3);
        float f5 = Ref.getFontRenderer().bridge$getStringWidth(string4);
        KeyBindingBridge keyBindingBridge5 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindJump();
        KeyBindingBridge keyBindingBridge6 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindAttack();
        KeyBindingBridge keyBindingBridge7 = Ref.getMinecraft().bridge$getGameSettings().bridge$keyBindUseItem();
        boolean bl = this.lllllIllIlIIlIIlIIIlllIlI.llIlllIIIllllIIlllIllIIIl();
        this.llIIIlIllIIIIlIIIlIlIllIl = new KeystrokesKey(bl ? "▲" : (f2 > f ? string.substring(0, 1) : string), keyBindingBridge, f, f);
        this.llllIlIllllIlIlIIIllIlIlI = new KeystrokesKey(bl ? "◀" : (f3 > f ? string2.substring(0, 1) : string2), keyBindingBridge2, f, f);
        this.lIllllIllIIlIIlIIIlIIIlII = new KeystrokesKey(bl ? "▼" : (f4 > f ? string3.substring(0, 1) : string3), keyBindingBridge3, f, f);
        this.IlIllIIlIIlIIIllIllllIIll = new KeystrokesKey(bl ? "▶" : (f5 > f ? string4.substring(0, 1) : string4), keyBindingBridge4, f, f);
        float f6 = (this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + this.lIllllIllIIlIIlIIIlIIIlII.IlllIIIIIIlllIlIIlllIlIIl() + this.IlIllIIlIIlIIIllIllllIIll.IlllIIIIIIlllIlIIlllIlIIl() + 1.0f) / 2.0f;
        this.lIlIlIIIIIIllIlIIIIllIIII = new KeystrokesKey(f < 14.0f ? "L" : "LMB", keyBindingBridge6, f6, f);
        this.lIIlIIIIIIlIIlIIllIlIIlII = new KeystrokesKey(f < 14.0f ? "R" : "RMB", keyBindingBridge7, f6, f);
        this.IlIIlIIlIIlIIllIIIllIIllI = new KeystrokesKey(keyBindingBridge5.bridge$getKeyName(), keyBindingBridge5, this.llllIlIllllIlIlIIIllIlIlI.IlllIIIIIIlllIlIIlllIlIIl() + this.lIllllIllIIlIIlIIIlIIIlII.IlllIIIIIIlllIlIIlllIlIIl() + this.IlIllIIlIIlIIIllIllllIIll.IlllIIIIIIlllIlIIlllIlIIl() + 2.0f, f * 0.5f);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Key Strokes", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("keystrokes", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public BooleanSetting llIIIIllIlIIlIlIIlllIllIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }
}
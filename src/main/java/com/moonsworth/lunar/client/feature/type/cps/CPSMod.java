package com.moonsworth.lunar.client.feature.type.cps;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.Anchor;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudMod;
import com.moonsworth.lunar.client.feature.hud.simple.SimpleHudModSize;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.Collections;
import java.util.List;

public class CPSMod
extends SimpleHudMod {
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public BooleanSetting IIlIllIlIIllIIlIlIllllllI;
    public ColorSetting lIIIlllIIIIllllIlIIIlIIll;

    public CPSMod() {
        super(false, Anchor.TOP_LEFT);
        this.IllIIIlllIIIlIlllIlIIlIII.IlllIIIIIIlllIlIIlllIlIIl((bl) -> LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIllIIllllIllllllIIlIl().lIllIlIIIlIIIIIIIlllIlIll());
    }

    @Override
    public List IlIllIIlIIlIIIllIllllIIll() {
        return Collections.singletonList(this.lIIIlllIIIIllllIlIIIlIIll);
    }

    @Override
    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0f, 103.0f);
    }

    @Override
    public String IlIlIlIlIIIlIIlIIlllIllIl() {
        return "[16 CPS]";
    }

    @Override
    public SimpleHudModSize lIIIlIllllIIlIIlIIlIIIIlI() {
        return new SimpleHudModSize(10, 18, 22, 40, 56, 62);
    }

    @Override
    public String lllllIlIllIlIlllIIIlIIlIl() {
        int n = LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIllIIllllIllllllIIlIl().IlllIIIIIIlllIlIIlllIlIIl();
        String string = this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() != false ? "  " + LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIllIIllllIllllllIIlIl().llIlllIIIllllIIlllIllIIIl() : "";
        String string2 = this.IIlIllIlIIllIIlIlIllllllI.llIlllIIIllllIIlllIllIIIl() != false ? " CPS" : "";
        return n + string + string2;
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(renderGameOverlayEvent, f, f2);
        this.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        super.IlllIIIIIIlllIlIIlllIlIIl(renderGameOverlayEvent, f, f2);
        this.lIllIlIIIlIIIIIIIlllIlIll(f, f2);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float f, float f2) {
        if (this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
            float f3 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(this.lllllIlIllIlIlllIIIlIIlIl());
            float f4 = Ref.IlllllIlIIIlIIlIIllIIlIll().bridge$getStringWidth(LunarClient.IIllIlIllIlIllIllIllIllII().IlIlIllIIllllIllllllIIlIl().IlllIIIIIIlllIlIIlllIlIIl() + " ");
            float f5 = f + this.llIIIIIIIllIIllIlIllIIIIl / 2.04f - f3 / 2.0f + f4;
            if (this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f5 + 0.25f, f2 + this.lIIIllIllIIllIlllIlIIlllI / 2.0f - 4.0f, 1.0f, 9.0f, 0x6F000000);
            }
            this.lIIIlllIIIIllllIlIIIlIIll.lIlIlIlIlIIlIIlIIllIIIIIl(f5 - 0.5f, f2 + this.lIIIllIllIIllIlllIlIIlllI / 2.0f - 4.5f, 1.0f, 9.0f);
        }
    }

    @Override
    public FeatureDetails llIIIIIIIllIIllIlIllIIIIl() {
        return new FeatureDetails("cps", ImmutableList.of(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl, ModuleCategory.IlllIIIIIIlllIlIIlllIlIIl), new String[0]);
    }

    @Override
    public List IIIIIIIIIIIIIIIllllIIlIIl() {
        this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("rightCLick", false);
        this.IIlIllIlIIllIIlIlIllllllI = new BooleanSetting("showCPSText", true);
        this.lIIIlllIIIIllllIlIIIlIIll = new ColorSetting("lineColor", -14671840, () -> this.IllIIIlllIIIlIlllIlIIlIII.llIlllIIIllllIIlllIllIIIl() == false);
        return ImmutableList.of(this.IllIIIlllIIIlIlllIlIIlIII, this.IIlIllIlIIllIIlIlIllllllI, this.lIIIlllIIIIllllIlIIIlIIll);
    }
}
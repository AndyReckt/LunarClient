package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.*;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.*;

import java.util.List;

public class SkyblockAddonsFeatureWarnings extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public NumberSetting IllIllIIIllIIIlIlIlIIIIll;
    public BooleanSetting IIlIllIlllllllIIlIIIllIIl;
    public BooleanSetting lIIlIlllIlIlIIIlllIIlIIII;
    public BooleanSetting llIllIlIllIlllIllIIIIllII;
    public BooleanSetting IllllllllllIlIIIlllIlllll;
    public BooleanSetting lllllIllIlIIlIIlIIIlllIlI;
    public BooleanSetting IllIIIlllIIIlIlllIlIIlIII;
    public BooleanSetting IIlIllIlIIllIIlIlIllllllI;
    public BooleanSetting lIIIlllIIIIllllIlIIIlIIll;
    public BooleanSetting llIIIlIllIIIIlIIIlIlIllIl;
    public BooleanSetting llllIlIllllIlIlIIIllIlIlI;
    public BooleanSetting IlIllIIlIIlIIIllIllllIIll;

    public SkyblockAddonsFeatureWarnings(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.MIDDLE_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        super.lIllllIllIIlIIlIIIlIIIlII();
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        String var4 = Ref.llIIlIlIIIllIlIlIlIIlIIll().getFeatureTitle();
        String var5 = Ref.llIIlIlIIIllIlIlIlIIlIIll().getFeatureSubtitle();
        if (var4.isEmpty()) {
            var4 = "Full Inventory!";
        }

        if (var5.isEmpty()) {
            var5 = "A minion on your island is full!";
        }

        this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var5, var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        String var4 = Ref.llIIlIlIIIllIlIlIlIIlIIll().getFeatureTitle();
        String var5 = Ref.llIIlIlIIIllIlIlIlIIlIIll().getFeatureSubtitle();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var5, var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, String var2, float var3, float var4) {
        float var5 = 0.0F;
        float var6 = 0.0F;
        float var7;
        if (!var1.isEmpty()) {
            var7 = 1.5F;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(1.5D, 1.5D, 1.5D);
            var5 = Math.max(Ref.getFontRenderer().bridge$getStringWidth(var1) * 1.5F, var5);
            this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var1, (var3 + this.llIIIIIIIllIIllIlIllIIIIl / 2.0F - var5 / 2.0F) / 1.5F, (var4 + 4.0F) / 1.5F, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            var6 += (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() * 1.5F;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }

        if (!var2.isEmpty()) {
            var7 = Ref.getFontRenderer().bridge$getStringWidth(var2);
            this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3 + this.llIIIIIIIllIIllIlIllIIIIl / 2.0F - var7 / 2.0F, var4 + 8.0F + var6, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            var5 = Math.max(var7, var5);
            var6 += (float) Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl();
        }

        this.IlllIIIIIIlllIlIIlllIlIIl(var5 + 8.0F, var6 + 8.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(
                   new SettingLabel("colorOptions"),
                   this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("textColor", -65536),
                   this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("textColor", -43691),
                   this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("textShadow", true),
                   new SettingLabel("warningOptions"),
                   this.IllIllIIIllIIIlIlIlIIIIll = new NumberSetting("warningTime", 5, 1, 30),
                   this.IIlIllIlllllllIIlIIIllIIl = new BooleanSetting("fullInventoryWarning", true),
                   this.lIIlIlllIlIlIIIlllIIlIIII = new BooleanSetting("repeatFullInventoryWarning", false),
                   this.llIllIlIllIlllIllIIIIllII = new BooleanSetting("magmaWarning", true),
                   this.IllllllllllIlIIIlllIlllll = new BooleanSetting("minionStopWarning", false),
                   this.lllllIllIlIIlIIlIIIlllIlI = new BooleanSetting("minionFullWarning", true),
                   this.IllIIIlllIIIlIlllIlIIlIII = new BooleanSetting("minionDisableLocationWarning", true),
                   this.IIlIllIlIIllIIlIlIllllllI = new BooleanSetting("legendarySeaCreatureWarning", true),
                   this.lIIIlllIIIIllllIlIIIlIIll = new BooleanSetting("repeatSlayBossWarning", false),
                   this.llIIIlIllIIIIlIIIlIlIllIl = new BooleanSetting("summonEyeAlert", true),
                   this.llllIlIllllIlIlIIIllIlIlI = new BooleanSetting("noArrowsLeftAlert", true),
                   this.IlIllIIlIIlIIIllIllllIIll = new BooleanSetting("bossApproachAlert", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("sba_feature_warning", ImmutableList.of(ModuleCategory.HUD));
    }

    public ColorSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.lllIIIIIlllIIlIllIIlIIIlI;
    }

    public ColorSetting llIIIIllIlIIlIlIIlllIllIl() {
        return this.lIlIIIIIIlIIIllllIllIIlII;
    }

    public BooleanSetting IIIIlIllIllIlIIIIIlIlIlIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }

    public NumberSetting IlIlIlIlIIIlIIlIIlllIllIl() {
        return this.IllIllIIIllIIIlIlIlIIIIll;
    }

    public BooleanSetting lIIIlIllllIIlIIlIIlIIIIlI() {
        return this.IIlIllIlllllllIIlIIIllIIl;
    }

    public BooleanSetting lllllIlIllIlIlllIIIlIIlIl() {
        return this.lIIlIlllIlIlIIIlllIIlIIII;
    }

    public BooleanSetting IllIlIIllIIlllIIllIlIlIII() {
        return this.llIllIlIllIlllIllIIIIllII;
    }

    public BooleanSetting IlIlllIIIIIllIIllIllIIlll() {
        return this.IllllllllllIlIIIlllIlllll;
    }

    public BooleanSetting IllllIIllllIllIIIIlllllII() {
        return this.lllllIllIlIIlIIlIIIlllIlI;
    }

    public BooleanSetting IIllllIIlllIlIIlIIlllIlII() {
        return this.IllIIIlllIIIlIlllIlIIlIII;
    }

    public BooleanSetting IllIlIIlllIIlIIllIIIIIIIl() {
        return this.IIlIllIlIIllIIlIlIllllllI;
    }

    public BooleanSetting IllIllIllIIlIlllIIlllIIll() {
        return this.lIIIlllIIIIllllIlIIIlIIll;
    }

    public BooleanSetting IlIIIIlllIllllIlIlIllIlII() {
        return this.llIIIlIllIIIIlIIIlIlIllIl;
    }

    public BooleanSetting lIlIIIlIIlIIIlIIIlllIlIII() {
        return this.llllIlIllllIlIlIIIllIlIlI;
    }

    public BooleanSetting IlIllIIlIIlIlIIlIIlIllIll() {
        return this.IlIllIIlIIlIIIllIllllIIll;
    }
}

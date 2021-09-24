package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.List;

public class SkyBlockAddonsSpeedTextChild extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;

    public SkyBlockAddonsSpeedTextChild(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.BOTTOM_CENTER_R);
        this.IlllIIIIIIlllIlIIlllIlIIl(40.0F, 12.0F);
    }

    public HudModPosition IIllIlIllIlIllIllIllIllII() {
        return super.IIllIlIllIlIllIllIllIllII();
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(19.0F, -28.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer() == null ? 0.0F : Ref.getPlayer().bridge$getPlayerCapabilities().bridge$getWalkSpeed(), var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer().bridge$getPlayerCapabilities().bridge$getWalkSpeed(), var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3) {
        String var4 = String.valueOf(var1 * 1000.0F);
        String var5 = var4.substring(0, Math.min(var4.length(), 3));
        if (var5.endsWith(".")) {
            var5 = var5.substring(0, var5.indexOf(46));
        }

        var5 = var5 + "%";
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var2 + 2.0F, var3, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var5) + 4.0F, (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("textColor", -1), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsSpeedTextChild", ImmutableList.of());
    }
}

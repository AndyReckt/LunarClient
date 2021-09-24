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

import java.math.BigDecimal;
import java.util.List;

public class SkyBlockAddonsDefensePercentageChild extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;

    public SkyBlockAddonsDefensePercentageChild(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.BOTTOM_CENTER_R);
        this.IlllIIIIIIlllIlIIlllIlIIl(40.0F, 12.0F);
    }

    public HudModPosition IIllIlIllIlIllIllIllIllII() {
        return super.IIllIlIllIlIllIllIllIllII();
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 12.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        double var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getDefence();
        if (var4 <= 0.0D) {
            var4 = 100.0D;
        }

        this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        double var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getDefence();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(double var1, float var3, float var4) {
        String var5 = (new BigDecimal(var1)).setScale(1, 4).toString().replace(".0", "") + "";
        if (Ref.getLC().lllllIllIllIllllIlIllllII() != null && Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll() != null) {
            double var6 = var1 / 100.0D / (var1 / 100.0D + 1.0D) * 100.0D;
            BigDecimal var8 = (new BigDecimal(var6)).setScale(1, 4);
            var5 = var8.toString() + "%";
        }

        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var3 + 2.0F, var4, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var5) + 4.0F, (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("defensetextColor", -16711936), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsDefensePercentageChild", ImmutableList.of());
    }
}

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

public class SkyBlockAddonsHealthTextChild extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;

    public SkyBlockAddonsHealthTextChild(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.BOTTOM_CENTER_L);
        this.IlllIIIIIIlllIlIIlllIlIIl(52.0F, 12.0F);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-40.0F, -44.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2) {
        String var3 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getHealth() + "/" + Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxHealth();
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var3, var1 + 2.0F, var2, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var3) + 4.0F, (float)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("healthbarColor", -65536), this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsHealthTextChild", ImmutableList.of());
    }
}

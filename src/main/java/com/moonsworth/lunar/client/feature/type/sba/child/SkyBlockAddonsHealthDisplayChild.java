package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.List;

public class SkyBlockAddonsHealthDisplayChild extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;

    public SkyBlockAddonsHealthDisplayChild(DraggableHudMod var1) {
        super(var1, false, HudModPosition.BOTTOM_CENTER_R);
        this.IlllIIIIIIlllIlIIlllIlIIl(40.0F, 12.0F);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 8.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl("+123", var2, var3, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        Integer var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getHealthUpdate();
        if (var4 != null) {
            if (var4 > 0) {
                this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl("+" + var4, var2, var3, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            } else {
                this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl("-" + var4, var2, var3, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
            }

        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("increaseColor", -16711936), this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("increaseColor", -65536), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsHealthDisplayChild", ImmutableList.of());
    }
}

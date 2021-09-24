package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.setting.BooleanSetting;

import java.util.List;

public class SkyBlockAddonsDefenseIconChild extends AbstractFeatureContainerChild {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/defence.png");
    public static final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("textures/gui/icons.png");
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;

    public SkyBlockAddonsDefenseIconChild(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.BOTTOM_CENTER_R);
        this.IlllIIIIIIlllIlIIlllIlIIl(40.0F, 12.0F);
    }

    public HudModPosition IIllIlIllIlIllIllIllIllII() {
        return super.IIllIlIllIlIllIllIllIllII();
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(19.0F, -40.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
            this.mc.bridge$getTextureManager().bridge$bindTexture(lllIIIIIlllIIlIllIIlIIIlI);
        } else {
            this.mc.bridge$getTextureManager().bridge$bindTexture(lIlIIIIIIlIIIllllIllIIlII);
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$texturedModalRect(var2, var3, 34, 9, 9, 9);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        this.IlllIIIIIIlllIlIIlllIlIIl(20.0F, 10.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("useVanillaTextureDefence", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsDefenseIconChild", ImmutableList.of());
    }

    public BooleanSetting IIIIIIIIIIIIIIIllllIIlIIl() {
        return this.llIlIIIllIIlIllIllIllllIl;
    }
}

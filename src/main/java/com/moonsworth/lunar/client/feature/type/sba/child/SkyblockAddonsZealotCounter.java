package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsZealotCounter extends AbstractFeatureContainerChild {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/icons/enderman.png");
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;

    public SkyblockAddonsZealotCounter(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(80.0F, 144.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().location().equalsIgnoreCase("DRAGONS_NEST")) {
            this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
        }
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, 8.0F, var1, var2);
        String var3 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIIlllIlIIlllllIIllIIIII() + "";
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var3, var1 + 18.0F, var2 + 4.0F, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(20.0F + Ref.getFontRenderer().bridge$getStringWidth(var3) + 2.0F, 15.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("textColor", -16711696), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsZealotCounter", new ArrayList());
    }
}

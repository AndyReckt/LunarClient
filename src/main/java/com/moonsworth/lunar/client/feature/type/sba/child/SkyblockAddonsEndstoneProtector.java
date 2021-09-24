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

public class SkyblockAddonsEndstoneProtector extends AbstractFeatureContainerChild {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/irongolem.png");
    public static final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/endermangroup.png");
    public ColorSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;

    public SkyblockAddonsEndstoneProtector(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(80.0F, 130.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, 5);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        String var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().location();
        if ((var4.equalsIgnoreCase("THE_END") || var4.equalsIgnoreCase("DRAGONS_NEST")) && Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getEndstoneProtectorStage() != null && Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().canDetectSkull()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, Math.min(Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getEndstoneProtectorStage(), 5));
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, int var3) {
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, 8.0F, var1, var2);
        String var4 = "Stage: " + var3;
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var1 + 18.0F, var2 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        float var5 = 18.0F + Ref.getFontRenderer().bridge$getStringWidth(var4) + 2.0F;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIlIIIIIIlIIIllllIllIIlII, 8.0F, var1 + var5, var2);
        int var6 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getEndstoneZealotCount();
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(String.valueOf(var6), var1 + 16.0F + 2.0F + var5, var2 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(var5 + Ref.getFontRenderer().bridge$getStringWidth(var6 + "") + 20.0F, 15.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new ColorSetting("textColor", -16711696), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsEndstoneProtector", new ArrayList());
    }
}

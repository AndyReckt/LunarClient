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

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsTickerChargesDisplay extends AbstractFeatureContainerChild {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/ticker.png");

    public SkyblockAddonsTickerChargesDisplay(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_RIGHT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-80.0F, 42.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        byte var4 = 4;

        for(int var5 = 0; var5 < var4; ++var5) {
            this.mc.bridge$getTextureManager().bridge$bindTexture(lllIIIIIlllIIlIllIIlIIIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var5 < 3) {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawModalRectWithCustomSizedTexture((int)var2 + 1 + var5 * 11, (int)var3, 0.0F, 0.0F, 9, 9, 18.0F, 9.0F);
            } else {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawModalRectWithCustomSizedTexture((int)var2 + 1 + var5 * 11, (int)var3, 9.0F, 0.0F, 9, 9, 18.0F, 9.0F);
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl((float)(var4 * 11 - 2), 9.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        int var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxTickers();

        for(int var5 = 0; var5 < var4; ++var5) {
            this.mc.bridge$getTextureManager().bridge$bindTexture(lllIIIIIlllIIlIllIIlIIIlI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            if (var5 < Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().tickers()) {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawModalRectWithCustomSizedTexture((int)var2 + 2 + var5 * 11, (int)var3 + 4, 0.0F, 0.0F, 9, 9, 18.0F, 9.0F);
            } else {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawModalRectWithCustomSizedTexture((int)var2 + 2 + var5 * 11, (int)var3 + 4, 9.0F, 0.0F, 9, 9, 18.0F, 9.0F);
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl((float)(var4 * 11 + 4), 9.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsTickerChargesDisplay", new ArrayList());
    }
}

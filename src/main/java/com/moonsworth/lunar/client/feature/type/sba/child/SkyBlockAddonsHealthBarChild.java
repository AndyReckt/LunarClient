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
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.List;

public class SkyBlockAddonsHealthBarChild extends AbstractFeatureContainerChild {
    public final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/bars.png");
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;

    public SkyBlockAddonsHealthBarChild(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.BOTTOM_CENTER_L);
        this.IlllIIIIIIlllIlIIlllIlIIl(103.0F, 5.0F);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-38.0F, -40.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2) {
        this.mc.bridge$getTextureManager().bridge$bindTexture(this.lllIIIIIlllIIlIllIIlIIIlI);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        short var3 = 182;
        byte var4 = 0;
        float var5 = 0.0F;
        double var6 = 10.0D;
        float var8 = (float)Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getHealth() / (float)Math.max(1, Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxHealth());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI(var1 + var2));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1 + 0.0F, var2 + (float)var4, 0, 0, var3, 5);

        for(float var9 = 10.0F; (double)var9 < (var6 - 1.0D) * 10.0D; var9 += 10.0F) {
            var5 = var9;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.lIlIIIIIIlIIIllllIllIIlII.IlllIIIIIIlllIlIIlllIlIIl(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.lIllIlIIIlIIIIIIIlllIlIll(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl(var1 + var2), this.lIlIIIIIIlIIIllllIllIIlII.llllIIlIIlIIlIIllIIlIIllI(var1 + var2));
            if (var9 >= var8 * 100.0F) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.25F, 0.25F, 0.25F);
            }

            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1 + var9, var2 + (float)var4, 10, 0, var3, 5);
        }

        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getHealth() + 1 < Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxHealth()) {
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(0.25F, 0.25F, 0.25F);
        }

        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1 + var5 + 10.0F, var2 + (float)var4, 20, 0, var3, 5);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("healthbarColor", -65536));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsHealthBarChild", ImmutableList.of());
    }
}

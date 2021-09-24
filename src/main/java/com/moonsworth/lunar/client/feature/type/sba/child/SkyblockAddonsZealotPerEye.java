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

public class SkyblockAddonsZealotPerEye extends AbstractFeatureContainerChild {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/icons/zealotspereye.png");
    public static final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/icons/slash.png");
    public ColorSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;

    public SkyblockAddonsZealotPerEye(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(80.0F, 176.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        int var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().llIIlIIIllllIIIllIIIIIIll();
        String var5 = "0";
        if (var4 > 0) {
            var5 = String.valueOf(Math.round((double)Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().lIIIllIIIlIlIlIIlIIlllIlI() / (double)Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().llIIlIIIllllIIIllIIIIIIll()));
        }

        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, 8.0F, var2, var3);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(var2 + var3), this.llIlIIIllIIlIllIllIllllIl.lIllIlIIIlIIIIIIIlllIlIll(var2 + var3), this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl(var2 + var3));
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3);
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var2 + 18.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(18.0F + Ref.getFontRenderer().bridge$getStringWidth(var5) + 4.0F, 15.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().location().equalsIgnoreCase("DRAGONS_NEST")) {
            int var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().llIIlIIIllllIIIllIIIIIIll();
            String var5 = "0";
            if (var4 > 0) {
                var5 = String.valueOf(Math.round((double)Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().lIIIllIIIlIlIlIIlIIlllIlI() / (double)Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().llIIlIIIllllIIIllIIIIIIll()));
            }

            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, 8.0F, var2, var3);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.llIlIIIllIIlIllIllIllllIl.IlllIIIIIIlllIlIIlllIlIIl(var2 + var3), this.llIlIIIllIIlIllIllIllllIl.lIllIlIIIlIIIIIIIlllIlIll(var2 + var3), this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl(var2 + var3));
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3);
            this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var2 + 18.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
            this.IlllIIIIIIlllIlIIlllIlIIl(18.0F + Ref.getFontRenderer().bridge$getStringWidth(var5) + 4.0F, 15.0F);
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new ColorSetting("textColor", -16711696), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsZealotPerEye", new ArrayList());
    }
}

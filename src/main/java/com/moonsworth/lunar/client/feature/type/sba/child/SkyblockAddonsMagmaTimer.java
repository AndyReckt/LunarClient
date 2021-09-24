package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsMagmaTimer extends AbstractShowInOtherGamesFeature {
    public final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/icons/magmaboss.png");
    public ColorSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;

    public SkyblockAddonsMagmaTimer(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 154.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        byte var4 = 0;
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl("1:23:45", var2 + 20.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3 + (float)var4);
        int var5 = (int)((float)var4 + 16.0F);
        this.IlllIIIIIIlllIlIIlllIlIIl(60.0F, (float)var5);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        byte var4 = 0;
        StringBuilder var5 = new StringBuilder();
        int var6 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().magmaSpawnSeconds();
        if (var6 < 0) {
            var6 = 0;
        }

        int var7 = var6 / 3600;
        int var8 = var6 / 60 % 60;
        int var9 = var6 % 60;
        if (Math.abs(var7) >= 10) {
            var7 = 10;
        }

        var5.append(var7).append(":");
        if (var8 < 10) {
            var5.append("0");
        }

        var5.append(var8).append(":");
        if (var9 < 10) {
            var5.append("0");
        }

        var5.append(var9);
        String var10 = var5.toString();
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var10, var2 + 20.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3 + (float)var4);
        int var11 = (int)((float)var4 + 16.0F);
        this.IlllIIIIIIlllIlIIlllIlIIl(60.0F, (float)var11);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new ColorSetting("textColor", -16711696), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsMagmaTimer", new ArrayList());
    }
}

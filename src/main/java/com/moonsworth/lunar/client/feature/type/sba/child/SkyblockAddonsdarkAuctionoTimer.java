package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.setting.AbstractSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

public class SkyblockAddonsdarkAuctionoTimer extends AbstractShowInOtherGamesFeature {
    public final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/icons/sirius.png");
    public ColorSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;

    public SkyblockAddonsdarkAuctionoTimer(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 130.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        byte var4 = 0;
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl("13:37", var2 + 20.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3 + (float)var4);
        int var5 = (int)((float)var4 + 16.0F);
        this.IlllIIIIIIlllIlIIlllIlIIl(60.0F, (float)var5);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        byte var4 = 0;
        Calendar var5 = Calendar.getInstance(TimeZone.getTimeZone("EST"));
        if (var5.get(12) >= 55) {
            var5.add(11, 1);
        }

        var5.set(12, 55);
        var5.set(13, 0);
        int var6 = (int)(var5.getTimeInMillis() - System.currentTimeMillis());
        int var7 = var6 / '';
        int var8 = (int)Math.round((double)(var6 % '') / 1000.0D);
        StringBuilder var9 = new StringBuilder();
        if (var7 < 10) {
            var9.append("0");
        }

        var9.append(var7).append(":");
        if (var8 < 10) {
            var9.append("0");
        }

        var9.append(var8);
        String var10 = var9.toString();
        this.llIlIIIllIIlIllIllIllllIl.lIlIlIlIlIIlIIlIIllIIIIIl(var10, var2 + 20.0F, var3 + 4.0F, this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, 8.0F, var2, var3 + (float)var4);
        int var11 = (int)((float)var4 + 16.0F);
        this.IlllIIIIIIlllIlIIlllIlIIl(60.0F, (float)var11);
    }

    public List<AbstractSetting<?>> IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new ColorSetting("textColor", -16711696), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsdarkAuctionoTimer", new ArrayList<>());
    }
}

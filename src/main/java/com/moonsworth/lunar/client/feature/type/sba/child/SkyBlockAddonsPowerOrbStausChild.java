package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.util.EnumChatColor;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.sba.ActivePowerOrb;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class SkyBlockAddonsPowerOrbStausChild extends AbstractFeatureContainerChild {
    public static final DecimalFormat lllIIIIIlllIIlIllIIlIIIlI = new DecimalFormat("#,###.##");
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;

    public SkyBlockAddonsPowerOrbStausChild(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.BOTTOM_CENTER_R);
        this.IlllIIIIIIlllIlIIlllIlIIl(40.0F, 12.0F);
    }

    public HudModPosition IIllIlIllIlIllIllIllIllII() {
        return super.IIllIlIllIlIllIllIllIllII();
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(124.0F, -2.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        ActivePowerOrb var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().powerOrb();
        if (var4 == null) {
            var4 = new ActivePowerOrb(10, "§aRadiant", 0.01D, 0.1D, 1, 1.0D, Bridge.getInstance().initResourceLocation("lunar", "skyblockaddons/powerorbs/radiant.png"));
        }

        if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2, var3);
        } else {
            this.IlllIIIIIIlllIlIIlllIlIIl(var4, var2, var3);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        ActivePowerOrb var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().powerOrb();
        if (var4 != null) {
            if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, var2, var3);
            } else {
                this.IlllIIIIIIlllIlIIlllIlIIl(var4, var2, var3);
            }

        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(ActivePowerOrb var1, float var2, float var3) {
        int var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxHealth();
        double var5 = (double)var4 * var1.lIllIlIIIlIIIIIIIlllIlIll();
        double var7 = var1.IlIlIlllllIlIIlIlIlllIlIl() * 100.0D;
        LinkedList<String> var9 = new LinkedList();
        var9.add(String.format(EnumChatColor.lllIIIIIlllIIlIllIIlIIIlI + "+%s ❤/s", lllIIIIIlllIIlIllIIlIIIlI.format(var5)));
        if (var1.llIlllIIIllllIIlllIllIIIl() > 0.0D) {
            int var10 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getMaxMana();
            double var11 = Math.floorDiv(var10, 50);
            var11 += var11 * var1.llIlllIIIllllIIlllIllIIIl();
            var9.add(String.format(EnumChatColor.lllllIllIllIllllIlIllllII + "+%s ❤/s", lllIIIIIlllIIlIllIIlIIIlI.format(var11)));
        }

        if (var1.llllIIlIIlIIlIIllIIlIIllI() > 0) {
            var9.add(String.format(EnumChatColor.llllIIlIIlIIlIIllIIlIIllI + "+%d ❁", var1.llllIIlIIlIIlIIllIIlIIllI()));
        }

        if (var7 > 0.0D) {
            var9.add(String.format(EnumChatColor.lIllIlIIIlIIIIIIIlllIlIll + "+%s%% Healing", lllIIIIIlllIIlIllIIlIIIlI.format(var7)));
        }

        byte var16 = 1;
        int var17 = (int)((double)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() * 1.5D);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIIIIIIIllIIllIlIllIIIIl(), (float)var17, var2, var3 - (float)(var17 / 2) + 2.0F);
        String var12 = String.format("%ss", var1.lIlIlIlIlIIlIIlIIllIIIIIl());
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var12, var2 + (float)Math.round((float)var17 - Ref.getFontRenderer().bridge$getStringWidth(var12) / 2.0F), var3 + (float)var17 + 8.0F, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        float var13 = 0.0F;

        for(int var14 = 0; var14 < var9.size(); ++var14) {
            String var15 = var9.get(var14);
            var13 = Math.max(var13, Ref.getFontRenderer().bridge$getStringWidth(var15));
            this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var15, var2 + (float)(var17 * 2) + 2.0F, var3 + 3.0F + (float)(var14 * (Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() + var16)), this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        }

        this.IlllIIIIIIlllIlIIlllIlIIl(var13 + 4.0F + (float)(var17 * 2), (float)(var9.size() * (var16 + Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl()) + 2));
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(ActivePowerOrb var1, float var2, float var3) {
        int var4 = (int)((double)Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() * 1.5D);
        String var5 = String.format("%ss", var1.lIlIlIlIlIIlIIlIIllIIIIIl());
        byte var6 = 1;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var1.llIIIIIIIllIIllIlIllIIIIl(), (float)var4, var2, var3);
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var5, var2 + (float)var6 + (float)(var4 * 2), var3 + (float)var4 - 4.0F, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        this.IlllIIIIIIlllIlIIlllIlIIl(Ref.getFontRenderer().bridge$getStringWidth(var5) + 4.0F + (float)(var4 * 2), (float)(var4 * 2));
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("textColor", -14614656), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("textShadow", true), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("detailed", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyBlockAddonsPowerOrbStausChild", ImmutableList.of());
    }
}

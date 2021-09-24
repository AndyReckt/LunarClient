package com.moonsworth.lunar.client.feature.type.bossbar;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.entity.boss.BossStatusBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;

import java.util.Iterator;
import java.util.List;

public class BossBarMod extends DraggableHudMod {
    public static final ResourceLocationBridge lllIIIIIlllIIlIllIIlIIIlI = Bridge.getInstance().initResourceLocation("lunar", "icons/icons.png");
    public static final ResourceLocationBridge lIlIIIIIIlIIIllllIllIIlII = Bridge.getInstance().initResourceLocation("textures/gui/icons.png");
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;
    public BooleanSetting IllIllIIIllIIIlIlIlIIIIll;
    public ColorSetting IIlIllIlllllllIIlIIIllIIl;

    public BossBarMod() {
        super(true, HudModPosition.TOP_CENTER);
        this.IlllIIIIIIlllIlIIlllIlIIl(182.0F, 16.0F);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(0.0F, 40.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("render_bar", true), this.IllIllIIIllIIIlIlIlIIIIll = new BooleanSetting("customBossBar", true), this.IIlIllIlllllllIIlIIIllIIl = new ColorSetting("barColor", -898574, () -> {
            return !(Boolean)this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl();
        }));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        this.lIllIlIIIlIIIIIIIlllIlIll(var2, var3);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
            if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(var2 + var3), this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll(var2 + var3), this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl(var2 + var3));
            }

            this.mc.bridge$getTextureManager().bridge$bindTexture(this.IlIllIIlIIlIIIllIllllIIll());
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
            short var4 = 182;
            byte var5 = 0;
            int var6 = (int)(1.0F * (float)(var4 + 1));
            byte var7 = 12;
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + (float)var5, var3 + (float)var7, 0, 74, var4, 5);
            AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + (float)var5, var3 + (float)var7, 0, 74, var4, 5);
            if (var6 > 0) {
                AbstractUIScreen.lIlIlIlIlIIlIIlIIllIIIIIl(var2 + (float)var5, var3 + (float)var7, 0, 79, var6, 5);
            }
        }

        String var8 = "EnderDragon";
        int var9 = 16777215;
        int finalVar = var9;
        var9 = Bridge.lIllIlIIIlIIIIIIIlllIlIll().map((var1x) -> {
            return var1x.getBossTextColor(finalVar);
        }).orElse(var9);
        Ref.getFontRenderer().bridge$drawString(var8, var2 + (this.llIIIIIIIllIIllIlIllIIIIl / 2.0F - Ref.getFontRenderer().bridge$getStringWidth(var8) / 2.0F), var3 + 2.0F, var9, true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        this.IlllIIIIIIlllIlIIlllIlIIl(182.0F, 18.0F);
    }

    public void lIllIlIIIlIIIIIIIlllIlIll(float var1, float var2) {
        List var3 = Bridge.getInstance().getBossStatus();
        int var4 = 0;
        Iterator var5 = var3.iterator();

        while(var5.hasNext()) {
            BossStatusBridge var6 = (BossStatusBridge)var5.next();
            if (this.lIlIlIlIlIIlIIlIIllIIIIIl(var6)) {
                var2 += (float)var4 * 16.0F;
                this.IlllIIIIIIlllIlIIlllIlIIl(var6);
                if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl()) {
                    if (this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl()) {
                        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(this.IIlIllIlllllllIIlIIIllIIl.IlllIIIIIIlllIlIIlllIlIIl(var1 + var2), this.IIlIllIlllllllIIlIIIllIIl.lIllIlIIIlIIIIIIIlllIlIll(var1 + var2), this.IIlIllIlllllllIIlIIIllIIl.llIlllIIIllllIIlllIllIIIl(var1 + var2));
                    }

                    var6.bridge$drawBar(var1, var2);
                }

                String var7 = var6.bridge$getBossName();
                int var8 = 16777215;
                int finalVar = var8;
                var8 = Bridge.lIllIlIIIlIIIIIIIlllIlIll().map((var1x) -> {
                    return var1x.getBossTextColor(finalVar);
                }).orElse(var8);
                Ref.getFontRenderer().bridge$drawString(var7, var1 + (this.llIIIIIIIllIIllIlIllIIIIl / 2.0F - Ref.getFontRenderer().bridge$getStringWidth(var7) / 2.0F), var2 + 2.0F, var8, true);
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
                ++var4;
            }
        }

        this.IlllIIIIIIlllIlIIlllIlIIl(182.0F, (float)var4 * 16.0F);
    }

    public ResourceLocationBridge IlIllIIlIIlIIIllIllllIIll() {
        return this.IllIllIIIllIIIlIlIlIIIIll.llIlllIIIllllIIlllIllIIIl() ? lllIIIIIlllIIlIllIIlIIIlI : lIlIIIIIIlIIIllllIllIIlII;
    }

    public boolean lIlIlIlIlIIlIIlIIllIIIIIl(BossStatusBridge var1) {
        return var1.bridge$getBossName() != null && var1.bridge$getStatusBarTime() == -1 || var1.bridge$getStatusBarTime() > 0;
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(BossStatusBridge var1) {
        int var2 = var1.bridge$getStatusBarTime();
        if (var2 != -1) {
            var1.bridge$setStatusBarTime(var2 - 1);
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Boss Bar", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("bossbar", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD));
    }
}

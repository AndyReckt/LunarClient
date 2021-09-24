package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsBirchParkRainmaker extends AbstractShowInOtherGamesFeature {
    public ColorSetting lIlIIIIIIlIIIllllIllIIlII;
    public BooleanSetting llIlIIIllIIlIllIllIllllIl;

    public SkyblockAddonsBirchParkRainmaker(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.TOP_RIGHT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-80.0F, 10.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        long var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().nextRainMaker();
        this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, var4);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        long var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().nextRainMaker();
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().location().equalsIgnoreCase("BIRCH_PARK")) {
            if (var4 != -1L) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, var4);
            }
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, long var3) {
        int var5 = (int)(var3 - System.currentTimeMillis()) / 1000;
        int var6 = var5 / '';
        int var7 = (int)Math.round((double)(var5 % '') / 1000.0D);
        StringBuilder var8 = new StringBuilder();
        if (var6 < 10) {
            var8.append("0");
        }

        var8.append(var6).append(":");
        if (var7 < 10) {
            var8.append("0");
        }

        var8.append(var7);
        String var9 = var8.toString();
        this.lIlIIIIIIlIIIllllIllIIlII.lIlIlIlIlIIlIIlIIllIIIIIl(var9, var1 + 18.0F, var2 + 4.0F, this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        RenderItemBridge var10 = Ref.getMinecraft().bridge$getRenderItem();
        ItemStackBridge var11 = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem("water_bucket"));
        float var12 = var10.bridge$getZLevel();
        var10.bridge$setZLevel(-200.0F);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
        var10.bridge$renderItemAndEffectIntoGUI(var11, (int)var1, (int)var2);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        var10.bridge$setZLevel(-var12);
        this.IlllIIIIIIlllIlIIlllIlIIl(20.0F + Ref.getFontRenderer().bridge$getStringWidth(var9), 15.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIlIIIIIIlIIIllllIllIIlII = new ColorSetting("textColor", -16711696), this.llIlIIIllIIlIllIllIllllIl = new BooleanSetting("textShadow", true));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsBirchParkRainmaker", new ArrayList());
    }
}

package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.ColorSetting;

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsSkillDisplay extends AbstractFeatureContainerChild {
    public ColorSetting lllIIIIIlllIIlIllIIlIIIlI;
    public BooleanSetting lIlIIIIIIlIIIllllIllIIlII;

    public SkyblockAddonsSkillDisplay(ConfigurableFeature var1) {
        super(var1, true, HudModPosition.MIDDLE_LEFT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(10.0F, 92.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        int var4 = (int)(Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkillFadeoutTime() - System.currentTimeMillis());
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkill() != null && var4 > 0) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, var3);
        } else {
            ItemStackBridge var5 = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem("golden_hoe"));
            this.lIlIlIlIlIIlIIlIIllIIIIIl("+10 (20,000/50,000)", var5, 2000L, var2, var3);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkill() != null) {
            String var4 = Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkill();
            int var5 = (int)(Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkillFadeoutTime() - System.currentTimeMillis());
            this.lIlIlIlIlIIlIIlIIllIIIIIl(var4, Ref.getLC().lllllIllIllIllllIlIllllII().lIIIlllIIIIllllIlIIIlIIll().IIIllIlIllIIllIlIlllIllIl().getSkillItem(), var5, var2, var3);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, ItemStackBridge var2, long var3, float var5, float var6) {
        if (var3 < 0L) {
            if (var3 < -2000L) {
                this.lllIIIIIlllIIlIllIIlIIIlI.IlllllIlIIIlIIlIIllIIlIll(1.0F);
                return;
            }

            float var7 = 1.0F - (float)(-var3) / 2000.0F;
            this.lllIIIIIlllIIlIllIIlIIIlI.IlllllIlIIIlIIlIIllIIlIll((float)(255 - Math.round(var7 * 255.0F >= 4.0F ? var7 * 255.0F : 4.0F)));
        } else if (this.lllIIIIIlllIIlIllIIlIIIlI.llllIIlIIlIIlIIllIIlIIllI() != 1.0F) {
            this.lllIIIIIlllIIlIllIIlIIIlI.IlllllIlIIIlIIlIIllIIlIll(1.0F);
        }

        this.lllIIIIIlllIIlIllIIlIIIlI.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var5 + 18.0F, var6 + 4.0F, this.lIlIIIIIIlIIIllllIllIIlII.llIlllIIIllllIIlllIllIIIl());
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Farming", var2, var5, var6);
        this.IlllIIIIIIlllIlIIlllIlIIl(20.0F + Ref.getFontRenderer().bridge$getStringWidth(var1), 16.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(String var1, ItemStackBridge var2, float var3, float var4) {
        RenderItemBridge var5 = Ref.getMinecraft().bridge$getRenderItem();
        float var6 = var5.bridge$getZLevel();
        var5.bridge$setZLevel(-200.0F);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();
        var5.bridge$renderItemAndEffectIntoGUI(var2, (int)var3, (int)var4);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        var5.bridge$setZLevel(var6);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.lIlIIIIIIlIIIllllIllIIlII = new BooleanSetting("textShadow", true), this.lllIIIIIlllIIlIllIIlIIIlI = new ColorSetting("textColor", -11141121));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsSkillDisplay", new ArrayList());
    }
}

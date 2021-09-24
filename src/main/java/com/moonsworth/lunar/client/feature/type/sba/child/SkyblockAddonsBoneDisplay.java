package com.moonsworth.lunar.client.feature.type.sba.child;

import com.google.common.collect.ImmutableList;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.item.EntityItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.AbstractFeatureContainerChild;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.ref.Ref;

import java.util.ArrayList;
import java.util.List;

public class SkyblockAddonsBoneDisplay extends AbstractFeatureContainerChild {
    public SkyblockAddonsBoneDisplay(ConfigurableFeature var1) {
        super(var1, false, HudModPosition.TOP_RIGHT);
    }

    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-80.0F, 26.0F);
    }

    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        RenderItemBridge var4 = Ref.getMinecraft().bridge$getRenderItem();
        ItemStackBridge var5 = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem(352));
        float var6 = var4.bridge$getZLevel();
        var4.bridge$setZLevel(-200.0F);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();

        for(int var7 = 0; var7 < 3; ++var7) {
            var4.bridge$renderItemAndEffectIntoGUI(var5, (int)var2 + var7 * 16, (int)var3);
        }

        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        var4.bridge$setZLevel(var6);
        this.IlllIIIIIIlllIlIIlllIlIIl(48.0F, 16.0F);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent var1, float var2, float var3) {
        RenderItemBridge var4 = Ref.getMinecraft().bridge$getRenderItem();
        ItemStackBridge var5 = Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem(352));
        float var6 = var4.bridge$getZLevel();
        var4.bridge$setZLevel(-200.0F);
        int var7 = 0;

        for (EntityBridge var9 : this.mc.bridge$getWorld().bridge$getEntities()) {
            if (var9 instanceof EntityItemBridge && var9.bridge$getRidingEntity() instanceof com.moonsworth.lunar.bridge.minecraft.client.entity.item.lIlIlIlIlIIlIIlIIllIIIIIl && var9.bridge$getRidingEntity().bridge$isInvisible() && var9.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer()) <= 8.0D) {
                ++var7;
            }
        }

        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$enableStandardItemLighting();

        for(int var10 = 0; var10 < var7; ++var10) {
            var4.bridge$renderItemAndEffectIntoGUI(var5, (int)var2 + var10 * 16, (int)var3);
        }

        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$disableStandardItemLighting();
        var4.bridge$setZLevel(var6);
        this.IlllIIIIIIlllIlIIlllIlIIl((float)var7 * 16.0F, 16.0F);
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("skyblockAddonsBoneDisplay", new ArrayList<>());
    }
}

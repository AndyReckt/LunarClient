package com.moonsworth.lunar.client.feature.type.coodowns;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.HudModPosition;
import com.moonsworth.lunar.client.feature.hud.DraggableHudMod;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.feature.type.armor.ListMode;
import com.moonsworth.lunar.client.setting.EnumSetting;

import java.util.ArrayList;
import java.util.List;

public class CooldownsMod
    extends DraggableHudMod {
    public static List<CooldownsItemRenderer> lllIIIIIlllIIlIllIIlIIIlI = new ArrayList();
    public List<CooldownsItemRenderer> lIlIIIIIIlIIIllllIllIIlII = new ArrayList();
    public EnumSetting llIlIIIllIIlIllIllIllllIl;

    public CooldownsMod() {
        super(true, HudModPosition.BOTTOM_CENTER_L);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    @Override
    public void lIllllIllIIlIIlIIIlIIIlII() {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(-124.0f, 0.0f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent tickEvent) {
        if (!lllIIIIIlllIIlIllIIlIIIlI.isEmpty()) {
            lllIIIIIlllIIlIllIIlIIIlI.removeIf(CooldownsItemRenderer::lIlIlIlIlIIlIIlIIllIIIIIl);
        }
        if (!this.lIlIIIIIIlIIIllllIllIIlII.isEmpty()) {
            this.lIlIIIIIIlIIIllllIllIIlII.removeIf(CooldownsItemRenderer::lIlIlIlIlIIlIIlIIllIIIIIl);
        }
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, f, f2);
    }

    @Override
    public void IlllIIIIIIlllIlIIlllIlIIl(RenderGameOverlayEvent renderGameOverlayEvent, float f, float f2) {
        if (lllIIIIIlllIIlIllIIlIIIlI.isEmpty()) {
            if (this.lIlIIIIIIlIIIllllIllIIlII.isEmpty()) {
                this.lIlIIIIIIlIIIllllIllIIlII.add(new CooldownsItemRenderer("CombatTag", CooldownsMod.lIlIlIlIlIIlIIlIIllIIIIIl("golden_sword"), 30000L));
                this.lIlIIIIIIlIIIllllIllIIlII.add(new CooldownsItemRenderer("EnderPearl", CooldownsMod.lIlIlIlIlIIlIIlIIllIIIIIl("ender_pearl"), 12000L));
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl(this.lIlIIIIIIlIIIllllIllIIlII, f, f2);
        } else {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(lllIIIIIlllIIlIllIIlIIIlI, f, f2);
        }
    }

    public static ItemStackBridge lIlIlIlIlIIlIIlIIllIIIIIl(String string) {
        return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem(string));
    }

    public static ItemStackBridge IlllIIIIIIlllIlIIlllIlIIl(int n) {
        return Bridge.getInstance().initItemStack(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItem(n));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(List list, float f, float f2) {
        if (list.isEmpty()) {
            return;
        }
        boolean bl = this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() == ListMode.lIlIlIlIlIIlIIlIIllIIIIIl;
        int n = 36;
        int n2 = 36;
        int n3 = bl ? n : list.size() * n;
        int n4 = bl ? list.size() * n2 : n2;
        this.IlllIIIIIIlllIlIIlllIlIIl(n3, n4);
        for (int i = 0; i < list.size(); ++i) {
            CooldownsItemRenderer cooldownsItemRenderer = (CooldownsItemRenderer)list.get(i);
            if (this.llIlIIIllIIlIllIllIllllIl.llIlllIIIllllIIlllIllIIIl() == ListMode.lIlIlIlIlIIlIIlIIllIIIIIl) {
                cooldownsItemRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(f + this.llIIIIIIIllIIllIlIllIIIIl / 2.0f - (float)n / 2.0f, f2 + (float)(i * n2));
                continue;
            }
            cooldownsItemRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(f + (float)(i * n), f2);
        }
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, long l, int n) {
        for (CooldownsItemRenderer cooldownsItemRenderer : lllIIIIIlllIIlIllIIlIIIlI) {
            if (!cooldownsItemRenderer.lIllIlIIIlIIIIIIIlllIlIll().equalsIgnoreCase(string) || cooldownsItemRenderer.llllIIlIIlIIlIIllIIlIIllI() != n || cooldownsItemRenderer.lIlIlIlIlIIlIIlIIllIIIIIl()) continue;
            return;
        }
        lllIIIIIlllIIlIllIIlIIIlI.add(new CooldownsItemRenderer(string, CooldownsMod.IlllIIIIIIlllIlIIlllIlIIl(n), l));
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(String string, long l, ItemStackBridge itemStackBridge) {
        for (CooldownsItemRenderer cooldownsItemRenderer : lllIIIIIlllIIlIllIIlIIIlI) {
            if (!cooldownsItemRenderer.lIllIlIIIlIIIIIIIlllIlIll().equalsIgnoreCase(string)) continue;
            cooldownsItemRenderer.IlllIIIIIIlllIlIIlllIlIIl();
            cooldownsItemRenderer.lIlIlIlIlIIlIIlIIllIIIIIl(l);
            return;
        }
        lllIIIIIlllIIlIllIIlIIIlI.add(new CooldownsItemRenderer(string, itemStackBridge, l));
    }

    public static void IlllIIIIIIlllIlIIlllIlIIl(String string, long l, int n) {
        CooldownsMod.lIlIlIlIlIIlIIlIIllIIIIIl(string, l, CooldownsMod.IlllIIIIIIlllIlIIlllIlIIl(n));
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.llIlIIIllIIlIllIllIllllIl = new EnumSetting("mode", ListMode.lIlIlIlIlIIlIIlIIllIIIIIl);
        return ImmutableList.of(this.llIlIIIllIIlIllIllIllllIl);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Cooldowns", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("cooldowns", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.HUD, ModuleCategory.SERVER));
    }
}

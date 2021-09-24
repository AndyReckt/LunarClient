package com.moonsworth.lunar.client.feature.type.title;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.network.NetHandlerConnectionStateUpdateEvent;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.world.TickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.ColorUtil;
import com.moonsworth.lunar.client.util.FontUtil;

import java.util.List;
import java.util.Set;

public class TitlesMod
    extends ConfigurableFeature {
    public TitlesMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(NetHandlerConnectionStateUpdateEvent netHandlerConnectionStateUpdateEvent) {
        LunarClient.getInstance().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl().clear();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent) {
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        for (Title title : LunarClient.getInstance().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl()) {
            float f;
            boolean bl = title.lIllIlIIIlIIIIIIIlllIlIll() == Title.DisplayType.IlllIIIIIIlllIlIIlllIlIIl;
            float f2 = bl ? 4.0f : 1.5f;
            float f3 = bl ? -30.0f : 10.0f;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(f2 *= title.llllIIlIIlIIlIIllIIlIIllI(), f2, f2);
            float f4 = 255.0f;
            if (title.lIlIlIlIlIIlIIlIIllIIIIIl()) {
                f = title.llIIIIIIIllIIllIlIllIIIIl() - (System.currentTimeMillis() - title.IlllllIlIIIlIIlIIllIIlIll());
                f4 = 1.0f - f / (float)title.llIIIIIIIllIIllIlIllIIIIl();
            } else if (title.IlllIIIIIIlllIlIIlllIlIIl()) {
                f = title.IlIlIlllllIlIIlIlIlllIlIl() - (System.currentTimeMillis() - title.IlllllIlIIIlIIlIIllIIlIll());
                f4 = f <= 0.0f ? 0.0f : f / (float)title.lIIIllIllIIllIlllIlIIlllI();
            }
            f4 = Math.min(1.0f, Math.max(0.0f, f4));
            if ((double)f4 <= 0.15) {
                f4 = 0.15f;
            }
            if (title.llIIlIlIIIllIlIlIlIIlIIll() != null) {
                title.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(title.llIlllIIIllllIIlllIllIIIl(), (int)(renderGameOverlayEvent.lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0 / (double)f2), (int)((renderGameOverlayEvent.IlllIIIIIIlllIlIIlllIlIIl() / 2.0 - (double)(Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() / 2) + (double)f3) / (double)f2));
            } else {
                FontUtil.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getFontRenderer(), title.llIlllIIIllllIIlllIllIIIl(), (int)(renderGameOverlayEvent.lIlIlIlIlIIlIIlIIllIIIIIl() / 2.0 / (double)f2), (int)((renderGameOverlayEvent.IlllIIIIIIlllIlIIlllIlIIl() / 2.0 - (double)(Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl() / 2) + (double)f3) / (double)f2), ColorUtil.lIlIlIlIlIIlIIlIIllIIIIIl(1.0f, 1.0f, 1.0f, f4));
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(1.0f / f2, 1.0f / f2, 1.0f / f2);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(TickEvent tickEvent) {
        Set<Title> set = LunarClient.getInstance().lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl();
        if (!set.isEmpty()) {
            set.removeIf(title -> title.IlllllIlIIIlIIlIIllIIlIll() + title.IlIlIlllllIlIIlIlIlllIlIl() < System.currentTimeMillis());
        }
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("titles", ImmutableList.of(ModuleCategory.SERVER));
    }
}

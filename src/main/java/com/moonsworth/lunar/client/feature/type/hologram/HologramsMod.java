package com.moonsworth.lunar.client.feature.type.hologram;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class HologramsMod
    extends Feature {
    public HologramsMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent renderWorldPassEvent) {
        FontRendererBridge fontRendererBridge = Ref.getFontRenderer();
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        RenderManagerBridge renderManagerBridge = Ref.getRenderManager();
        for (Hologram hologram : LunarClient.getInstance().getHolograms().llIlllIIIllllIIlllIllIIIl().values()) {
            if (hologram.getLines() == null || hologram.getLines().length <= 0) continue;
            for (int i = hologram.getLines().length - 1; i >= 0; --i) {
                String string = hologram.getLines()[hologram.getLines().length - i - 1];
                float f = 1.6f;
                float f2 = 0.016666668f * f;
                double d = hologram.getX() - renderManagerBridge.getRenderPosX();
                double d2 = hologram.getY() + 1.0 + (double)((float)i * 0.25f) - renderManagerBridge.getRenderPosY();
                double d3 = hologram.getZ() - renderManagerBridge.getRenderPosZ();
                glStateManagerBridge.bridge$pushMatrix();
                glStateManagerBridge.bridge$translate((float)d + 0.0f, (float)d2, (float)d3);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                glStateManagerBridge.bridge$rotate((float)(-renderManagerBridge.getPlayerViewY()), 0.0f, 1.0f, 0.0f);
                glStateManagerBridge.bridge$rotate((float)renderManagerBridge.getPlayerViewX(), 1.0f, 0.0f, 0.0f);
                glStateManagerBridge.bridge$scale(-f2, -f2, f2);
                glStateManagerBridge.bridge$depthMask(false);
                glStateManagerBridge.bridge$enableBlend();
                glStateManagerBridge.bridge$tryBlendFuncSeparate(770, 771, 1, 0);
                int n = 0;
                int n2 = (int)(fontRendererBridge.bridge$getStringWidth(string) / 2.0f);
                glStateManagerBridge.bridge$disableTexture2D();
                GL11.glBegin(7);
                GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.25f);
                GL11.glVertex3d(-n2 - 1, -1 + n, 0.0);
                GL11.glVertex3d(-n2 - 1, 8 + n, 0.0);
                GL11.glVertex3d(n2 + 1, 8 + n, 0.0);
                GL11.glVertex3d(n2 + 1, -1 + n, 0.0);
                GL11.glEnd();
                glStateManagerBridge.bridge$enableTexture2D();
                fontRendererBridge.bridge$drawString(string, -fontRendererBridge.bridge$getStringWidth(string) / 2.0f, n, 0x20FFFFFF, false);
                glStateManagerBridge.bridge$depthMask(true);
                fontRendererBridge.bridge$drawString(string, -fontRendererBridge.bridge$getStringWidth(string) / 2.0f, n, -1, false);
                glStateManagerBridge.bridge$disableBlend();
                glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
                glStateManagerBridge.bridge$popMatrix();
            }
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
        return new FeatureDetails("holograms", ImmutableList.of(ModuleCategory.SERVER));
    }
}

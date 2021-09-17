package com.moonsworth.lunar.client.feature.type.waypoints;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.gui.FontRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BindableSetting;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.ui.screen.type.waypoint.WaypointUIScreen;
import com.moonsworth.lunar.client.util.MathHelperUtil;
import org.lwjgl.opengl.GL11;

import java.util.List;

public class WaypointsMod extends ConfigurableFeature {
    public final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("textures/entity/beacon_beam.png");
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public BooleanSetting llIIIIIIIllIIllIlIllIIIIl;
    public BooleanSetting lIIIllIllIIllIlllIlIIlllI;
    public NumberSetting IlllllIlIIIlIIlIIllIIlIll;
    public BindableSetting llIIlIlIIIllIlIlIlIIlIIll;
    public final WaypointRenderer llIIIlllIIlllIllllIlIllIl = new WaypointRenderer();

    public WaypointsMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, this::onRenderWorldPass);
        this.llIIlIlIIIllIlIlIlIIlIIll.IlllIIIIIIlllIlIIlllIlIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(true).lIlIlIlIlIIlIIlIIllIIIIIl(bl -> Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$displayScreen(Bridge.llIlllIIIllllIIlllIllIIIl().initCustomScreen(new WaypointUIScreen(Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getCurrentScreen()))));
    }

    public void onRenderWorldPass(RenderWorldPassEvent renderWorldPassEvent) {
        if (this.lIllIlIIIlIIIIIIIlllIlIll.bridge$getRenderViewEntity() == null) {
            return;
        }
        if (Ref.IlllIIIIIIlllIlIIlllIlIIl().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
            return;
        }
        for (Waypoint waypoint : LunarClient.IIllIlIllIlIllIllIllIllII().llIllIlIllIlllIllIIIIllII().llIlllIIIllllIIlllIllIIIl()) {
            if (!waypoint.IlIlIlllllIlIIlIlIlllIlIl() || !waypoint.lIlIlIlIlIIlIIlIIllIIIIIl()) continue;
            double d = this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, this.lIllIlIIIlIIIIIIIlllIlIll.bridge$getRenderViewEntity());
            double d2 = (double)((float)this.lIllIlIIIlIIIIIIIlllIlIll.bridge$getGameSettings().bridge$getRenderDistance() * 16.0f) * 0.75;
            if (((Boolean)this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
                this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, renderWorldPassEvent.lIlIlIlIlIIlIIlIIllIIIIIl(), d, d2);
            }
            this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, d, d2);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint, float f, double d, double d2) {
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        RenderManagerBridge renderManagerBridge = minecraftBridge.bridge$getRenderManager();
        double d3 = renderManagerBridge.getRenderPosX();
        double d4 = renderManagerBridge.getRenderPosY();
        double d5 = renderManagerBridge.getRenderPosZ();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 771, 1, 0);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7425);
        double d6 = (double)((float)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord()) - d3;
        double d7 = (double)((float)waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord()) - d5;
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(false);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate((float)d6, (float)(-d4), (float)d7);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate(-90.0f, 1.0f, 0.0f, 0.0f);
        float f2 = 0.75f;
        float f3 = 0.0f;
        float f4 = (float) MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.IlIlIlllllIlIIlIlIlllIlIl().bridge$getPosY() + 50.0, waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord(), 256.0);
        int n = 20;
        int n2 = 1;
        float f5 = 1.0f * ((float)Math.max(0.0, Math.min(60.0, this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, Ref.IlIlIlllllIlIIlIlIlllIlIl()) - 4.0)) / 60.0f);
        float f6 = 0.6f * f5;
        int n3 = waypoint.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(0.0f);
        float f7 = (float)(n3 >> 16 & 0xFF) / 255.0f;
        float f8 = (float)(n3 >> 8 & 0xFF) / 255.0f;
        float f9 = (float)(n3 & 0xFF) / 255.0f;
        float f10 = (float)Math.PI * 2 / (float)n;
        float f11 = (f3 - f2) / (float)n2;
        float f12 = f4 / (float)n2;
        float f13 = 0.0f;
        float f14 = f2;
        TessellatorBridge tessellatorBridge = Bridge.llIlllIIIllllIIlllIllIIIl().initTessellator();
        for (int i = 0; i < n2; ++i) {
            tessellatorBridge.bridge$begin(8, false, true);
            for (int j = 0; j <= n; ++j) {
                float f15;
                float f16;
                if (j == n) {
                    f16 = this.llIlllIIIllllIIlllIllIIIl(0.0f);
                    f15 = this.lIllIlIIIlIIIIIIIlllIlIll(0.0f);
                } else {
                    f16 = this.llIlllIIIllllIIlllIllIIIl((float)j * f10);
                    f15 = this.lIllIlIIIlIIIIIIIlllIlIll((float)j * f10);
                }
                tessellatorBridge.bridge$pos(f16 * f14, f15 * f14, f13).bridge$color(f7, f8, f9, f6).bridge$endVertex();
                tessellatorBridge.bridge$pos(f16 * (f14 + f11), f15 * (f14 + f11), f13 + f12).bridge$color(f7, f8, f9, f6).bridge$endVertex();
            }
            tessellatorBridge.bridge$end();
            f14 += f11;
            f13 += f12;
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.0f, (float)(waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord() + (double)0.001f));
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color(f7, f8, f9, 0.85f);
        this.llIIIlllIIlllIllllIlIllIl.lIlIlIlIlIIlIIlIIllIIIIIl(0.85f, 0.78f, 0.0f, 26, 1);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$shadeModel(7424);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableTexture2D();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public float lIllIlIIIlIIIIIIIlllIlIll(float f) {
        return (float)Math.cos(f);
    }

    public float llIlllIIIllllIIlllIllIIIl(float f) {
        return (float)Math.sin(f);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3) {
        float f4 = (float)Math.sqrt(f * f + f2 * f2 + f3 * f3);
        if (f4 > 1.0E-5f) {
            f /= f4;
            f2 /= f4;
            f3 /= f4;
        }
        GL11.glNormal3f((float)f, (float)f2, (float)f3);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint, double d, double d2) {
        MinecraftBridge minecraftBridge = Ref.lIlIlIlIlIIlIIlIIllIIIIIl();
        RenderManagerBridge renderManagerBridge = minecraftBridge.bridge$getRenderManager();
        if (minecraftBridge.bridge$getRenderViewEntity() == null) {
            return;
        }
        FontRendererBridge fontRendererBridge = Ref.IlllllIlIIIlIIlIIllIIlIll();
        double d3 = waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord() - renderManagerBridge.getRenderPosX();
        double d4 = 2.0 + waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord() - renderManagerBridge.getRenderPosY();
        double d5 = waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord() - renderManagerBridge.getRenderPosZ();
        String string = waypoint.IlllIIIIIIlllIlIIlllIlIIl() + " [" + (int)d + "m]";
        if (d > d2) {
            d3 = d3 / d * d2;
            d4 = d4 / d * d2;
            d5 = d5 / d * d2;
            d = d2;
        }
        int n = (int)(fontRendererBridge.bridge$getStringWidth(string) / 2.0f);
        float f = 0.016666668f * (float)(1.0 + d * (double)0.15f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate((float)d3, (float)d4, (float)d5);
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate((float)(-renderManagerBridge.getPlayerViewY()), 0.0f, 1.0f, 0.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$rotate((float)renderManagerBridge.getPlayerViewX(), 1.0f, 0.0f, 0.0f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$scale(-f, -f, f);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(false);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableDepth();
        float f2 = ((Float)this.IlllllIlIIIlIIlIIllIIlIll.llIlllIIIllllIIlllIllIIIl()).floatValue();
        float f3 = (float)(-n) - f2;
        float f4 = -f2;
        float f5 = (float)(n * 2) + f2 * 2.0f;
        float f6 = 8.0f + f2 * 2.0f;
        float f7 = 1.0f * ((float)Math.max(0.0, Math.min(10.0, this.lIlIlIlIlIIlIIlIIllIIIIIl(waypoint, Ref.IlIlIlllllIlIIlIlIlllIlIl()) - 4.0)) / 10.0f);
        AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3, f4, f5, f6, (int)(0.4f * f7 * 255.0f) << 24);
        if (((Boolean)this.llIIIIIIIllIIllIlIllIIIIl.llIlllIIIllllIIlllIllIIIl()).booleanValue()) {
            int n2 = (int)(f7 * 255.0f) << 24 | waypoint.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(0.0f) & 0xFFFFFF;
            float f8 = 0.5f;
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3, f4 - f8, f5, f8, n2);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3, f4 + f6, f5, f8, n2);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3 - f8, f4 - f8, f8, f6 + f8 * 2.0f, n2);
            AbstractUIScreen.lIllIlIIIlIIIIIIIlllIlIll(f3 + f5, f4 - f8, f8, f6 + f8 * 2.0f, n2);
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
        fontRendererBridge.bridge$drawString(string, -n, 0.0f, (int)Math.max(4.0f, f7 * 255.0f) << 24 | 0xFFFFFF, (Boolean)this.lIIIllIllIIllIlllIlIIlllI.llIlllIIIllllIIlllIllIIIl());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(true);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableDepth();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(Waypoint waypoint, EntityBridge entityBridge) {
        double d = waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$xCoord() - entityBridge.bridge$getPosX();
        double d2 = waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$yCoord() - entityBridge.bridge$getPosY();
        double d3 = waypoint.lIllIlIIIlIIIIIIIlllIlIll().bridge$zCoord() - entityBridge.bridge$getPosZ();
        return Math.sqrt(d * d + d2 * d2 + d3 * d3);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("beams", true);
        this.llIIIIIIIllIIllIlIllIIIIl = new BooleanSetting("box_border", true);
        this.lIIIllIllIIllIlllIlIIlllI = new BooleanSetting("text_shadow", false);
        this.IlllllIlIIIlIIlIIllIIlIll = new NumberSetting("box_padding", 4.0f, 1.0f, 8.0f);
        this.llIIlIlIIIllIlIlIlIIlIIll = new BindableSetting(this, "add_waypoint", KeyType.llIIIlIllIIIIlIIIlIlIllIl);
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl, this.llIIIIIIIllIIllIlIllIIIIl, this.lIIIllIllIIllIlllIlIIlllI, this.IlllllIlIIIlIIlIIllIIlIll, this.llIIlIlIIIllIlIlIlIIlIIll);
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Waypoints", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails llIIIIIIIllIIllIlIllIIIIl() {
        return new FeatureDetails("waypoints", ImmutableList.of(ModuleCategory.lIlIlIlIlIIlIIlIIllIIIIIl), new String[0]);
    }

    public BindableSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }
}
 
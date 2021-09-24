package com.moonsworth.lunar.client.feature.type.borders;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.lunar.LunarBorder;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.util.AxisAlignedBBBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.entity.EntityBoundingBoxCollisionEvent;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.feature.Feature;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.MathHelperUtil;

import java.util.List;

public class BordersMod extends Feature {
    public static final ResourceLocationBridge llllIIlIIlIIlIIllIIlIIllI = Bridge.getInstance().initResourceLocation("textures/misc/forcefield.png");

    public BordersMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(EntityBoundingBoxCollisionEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent var1) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl(Ref.getPlayer(), var1.lIlIlIlIlIIlIIlIIllIIIIIl());
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final EntityBoundingBoxCollisionEvent entityBoundingBoxCollisionEvent) {
        if (entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() == null) {
            return;
        }
        for (final LunarBorder lunarBorder : Ref.getLC().IlIIlIIlIIlIIllIIIllIIllI().llIlllIIIllllIIlllIllIIIl().values()) {
            if (!Ref.getLC().lIlIlIlIlIIlIIlIIllIIIIIl(lunarBorder.getWorld())) {
                continue;
            }
            if (entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl() != Ref.getPlayer() && !lunarBorder.isWorldBorder()) {
                continue;
            }
            for (final AxisAlignedBBBridge axisAlignedBBBridge : lunarBorder.getWalls()) {
                if (axisAlignedBBBridge.bridge$intersectsWith(entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getBoundingBox().bridge$expand(Math.abs(entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionX()), Math.abs(entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionY()), Math.abs(entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionZ())).bridge$offset(entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionX(), entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionY(), entityBoundingBoxCollisionEvent.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getMotionZ()))) {
                    entityBoundingBoxCollisionEvent.lIllIlIIIlIIIIIIIlllIlIll().add(axisAlignedBBBridge);
                }
            }
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(final EntityBridge entityBridge, final float n) {
        final TessellatorBridge initTessellator = Bridge.getInstance().initTessellator();
        final double n2 = this.mc.bridge$getGameSettings().bridge$getRenderDistance() * 16;
        for (final LunarBorder lunarBorder : LunarClient.getInstance().IlIIlIIlIIlIIllIIIllIIllI().llIlllIIIllllIIlllIllIIIl().values()) {
            if (!Ref.getLC().lIlIlIlIlIIlIIlIIllIIIIIl(lunarBorder.getWorld())) {
                continue;
            }
            final double bridge$minX = lunarBorder.bridge$minX();
            final double bridge$maxX = lunarBorder.bridge$maxX();
            final double bridge$minZ = lunarBorder.bridge$minZ();
            final double bridge$maxZ = lunarBorder.bridge$maxZ();
            if (entityBridge.bridge$getPosX() < bridge$maxX - n2 && entityBridge.bridge$getPosX() > bridge$minX + n2 && entityBridge.bridge$getPosZ() < bridge$maxZ - n2 && entityBridge.bridge$getPosZ() > bridge$minZ + n2) {
                continue;
            }
            final double pow = Math.pow(1.0 - lunarBorder.bridge$getClosestDistance(entityBridge) / n2, 4.0);
            final double n3 = entityBridge.bridge$lastTickX() + (entityBridge.bridge$getPosX() - entityBridge.bridge$lastTickX()) * n;
            final double n4 = entityBridge.bridge$lastTickY() + (entityBridge.bridge$getPosY() - entityBridge.bridge$lastTickY()) * n;
            final double n5 = entityBridge.bridge$lastTickZ() + (entityBridge.bridge$getPosZ() - entityBridge.bridge$lastTickZ()) * n;
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$tryBlendFuncSeparate(770, 1, 1, 0);
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(BordersMod.llllIIlIIlIIlIIllIIlIIllI);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(false);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            final int color = lunarBorder.getColor();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$color((color >> 16 & 0xFF) / 255.0f, (color >> 8 & 0xFF) / 255.0f, (color & 0xFF) / 255.0f, (float)pow);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$doPolygonOffset(-3.0f, -3.0f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enablePolygonOffset();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$alphaFunc(516, 0.1f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableCull();
            final float n6 = Ref.getMinecraft().bridge$getSystemTime() % 3000L / 3000.0f;
            initTessellator.bridge$begin(7, true, false);
            initTessellator.bridge$setTranslation(-n3, -n4, -n5);
            final double max = Math.max(MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(n5 - n2), bridge$minZ);
            final double min = Math.min(MathHelperUtil.lIlIlIlIlIIlIIlIIllIIIIIl(n5 + n2), bridge$maxZ);
            if (n3 > bridge$maxX - n2) {
                float n7 = 0.0f;
                for (double n8 = max; n8 < min; ++n8, n7 += 0.5f) {
                    final double min2 = Math.min(1.0, min - n8);
                    final float n9 = (float)min2 * 0.5f;
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$maxX, 256.0, n8).bridge$uv(n6 + n7, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$maxX, 256.0, n8 + min2).bridge$uv(n6 + n9 + n7, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$maxX, 0.0, n8 + min2).bridge$uv(n6 + n9 + n7, n6 + 128.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$maxX, 0.0, n8).bridge$uv(n6 + n7, n6 + 128.0f).bridge$endVertex();
                }
            }
            if (n3 < bridge$minX + n2) {
                float n10 = 0.0f;
                for (double n11 = max; n11 < min; ++n11, n10 += 0.5f) {
                    final double min3 = Math.min(1.0, min - n11);
                    final float n12 = (float)min3 * 0.5f;
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$minX, 256.0, n11).bridge$uv(n6 + n10, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$minX, 256.0, n11 + min3).bridge$uv(n6 + n12 + n10, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$minX, 0.0, n11 + min3).bridge$uv(n6 + n12 + n10, n6 + 128.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(bridge$minX, 0.0, n11).bridge$uv(n6 + n10, n6 + 128.0f).bridge$endVertex();
                }
            }
            final double max2 = Math.max(MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(n3 - n2), bridge$minX);
            final double min4 = Math.min(MathHelperUtil.IlllIIIIIIlllIlIIlllIlIIl(n3 + n2), bridge$maxX);
            if (n5 > bridge$maxZ - n2) {
                float n13 = 0.0f;
                for (double n14 = max2; n14 < min4; ++n14, n13 += 0.5f) {
                    final double min5 = Math.min(1.0, min4 - n14);
                    final float n15 = (float)min5 * 0.5f;
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n14, 256.0, bridge$maxZ).bridge$uv(n6 + n13, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n14 + min5, 256.0, bridge$maxZ).bridge$uv(n6 + n15 + n13, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n14 + min5, 0.0, bridge$maxZ).bridge$uv(n6 + n15 + n13, n6 + 128.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n14, 0.0, bridge$maxZ).bridge$uv(n6 + n13, n6 + 128.0f).bridge$endVertex();
                }
            }
            if (n5 < bridge$minZ + n2) {
                float n16 = 0.0f;
                for (double n17 = max2; n17 < min4; ++n17, n16 += 0.5f) {
                    final double min6 = Math.min(1.0, min4 - n17);
                    final float n18 = (float)min6 * 0.5f;
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n17, 256.0, bridge$minZ).bridge$uv(n6 + n16, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n17 + min6, 256.0, bridge$minZ).bridge$uv(n6 + n18 + n16, n6 + 0.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n17 + min6, 0.0, bridge$minZ).bridge$uv(n6 + n18 + n16, n6 + 128.0f).bridge$endVertex();
                    initTessellator.lIlIlIlIlIIlIIlIIllIIIIIl(n17, 0.0, bridge$minZ).bridge$uv(n6 + n16, n6 + 128.0f).bridge$endVertex();
                }
            }
            initTessellator.bridge$end();
            initTessellator.bridge$setTranslation(0.0, 0.0, 0.0);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableCull();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableAlpha();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$doPolygonOffset(0.0f, 0.0f);
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disablePolygonOffset();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableAlpha();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$disableBlend();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$depthMask(true);
        }
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("borders", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.SERVER));
    }
}

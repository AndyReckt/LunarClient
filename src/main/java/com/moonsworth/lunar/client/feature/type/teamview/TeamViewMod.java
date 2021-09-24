package com.moonsworth.lunar.client.feature.type.teamview;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.TessellatorBridge;
import com.moonsworth.lunar.bridge.minecraft.util.Vec3Bridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.render.RenderGameOverlayEvent;
import com.moonsworth.lunar.client.event.type.render.RenderWorldPassEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.profile.FriendProfile;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.ui.screen.AbstractUIScreen;
import com.moonsworth.lunar.client.util.ScaledResolutionHelper;
import org.lwjgl.BufferUtils;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.List;
import java.util.Optional;

public final class TeamViewMod
    extends ConfigurableFeature {
    public final FloatBuffer llllIIlIIlIIlIIllIIlIIllI = BufferUtils.createFloatBuffer(16);
    public final FloatBuffer IlIlIlllllIlIIlIlIlllIlIl = BufferUtils.createFloatBuffer(16);

    public TeamViewMod() {
        super(true);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderGameOverlayEvent renderGameOverlayEvent) {
        IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$glGetInteger(2978, intBuffer);
        float f = Ref.getMinecraft().bridge$getTimer().bridge$partialTick();
        float f2 = (float)Ref.getRenderManager().getRenderPosX();
        float f3 = (float)Ref.getRenderManager().getRenderPosY();
        float f4 = (float)Ref.getRenderManager().getRenderPosZ();
        double d = (this.mc.bridge$getPlayer().bridge$getRotationPitch() + 90.0) * Math.PI / 180.0;
        double d2 = (this.mc.bridge$getPlayer().bridge$getRotationYaw() + 90.0) * Math.PI / 180.0;
        if (this.mc.bridge$getGameSettings().bridge$getThirdPersonView() == 2) {
            d2 = (this.mc.bridge$getPlayer().bridge$getRotationYaw() - 90.0) * Math.PI / 180.0;
        }
        Vec3Bridge vec3Bridge = Bridge.getInstance().initVec3d(Math.sin(d) * Math.cos(d2), Math.cos(d), Math.sin(d) * Math.sin(d2));
        for (FriendProfile friendProfile : LunarClient.getInstance().getFriendRegistry().llIlllIIIllllIIlllIllIIIl().values()) {
            double d3;
            if (friendProfile.IllIllIIIllIIIlIlIlIIIIll() != -1.0 && LunarClient.getInstance().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll() != -1.0 && friendProfile.IllIllIIIllIIIlIlIlIIIIll() != LunarClient.getInstance().llllIIlIIlIIlIIllIIlIIllI().IllIllIIIllIIIlIlIlIIIIll()) continue;
            Optional optional = this.mc.bridge$getWorld().bridge$getPlayerByUniqueId(friendProfile.lIllIlIIIlIIIIIIIlllIlIll());
            if (!optional.isPresent()) {
                double d4;
                double d5 = friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$xCoord() - (double)f2;
                double d6 = friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$yCoord() - (double)f3;
                d3 = friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$zCoord() - (double)f4;
                double d7 = this.lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$xCoord(), friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$yCoord(), friendProfile.llIlIIIllIIlIllIllIllllIl().bridge$zCoord());
                if (d7 > (d4 = (float)this.mc.bridge$getGameSettings().bridge$getRenderDistance() * 16.0f)) {
                    d5 = d5 / d7 * d4;
                    d6 = d6 / d7 * d4;
                    d3 = d3 / d7 * d4;
                }
                this.lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile, (float)d5, (float)d6, (float)d3, intBuffer, vec3Bridge, (int)d7);
                continue;
            }
            EntityPlayerBridge entityPlayerBridge = (EntityPlayerBridge)optional.get();
            if (entityPlayerBridge == this.mc.bridge$getPlayer()) continue;
            float f5 = (float)(entityPlayerBridge.bridge$lastTickX() + (entityPlayerBridge.bridge$getPosX() - entityPlayerBridge.bridge$lastTickX()) * (double)f - (double)f2);
            float f6 = (float)(entityPlayerBridge.bridge$lastTickY() + (entityPlayerBridge.bridge$getPosY() - entityPlayerBridge.bridge$lastTickY()) * (double)f - (double)f3);
            float f7 = (float)(entityPlayerBridge.bridge$lastTickZ() + (entityPlayerBridge.bridge$getPosZ() - entityPlayerBridge.bridge$lastTickZ()) * (double)f - (double)f4);
            d3 = this.lIlIlIlIlIIlIIlIIllIIIIIl(entityPlayerBridge.bridge$getPosX(), entityPlayerBridge.bridge$getPosY(), entityPlayerBridge.bridge$getPosZ());
            this.lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile, f5, f6 + 3.0f, f7, intBuffer, vec3Bridge, (int)d3);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile friendProfile, float f, float f2, float f3, IntBuffer intBuffer, Vec3Bridge vec3Bridge, int n) {
        Vec3Bridge vec3Bridge2 = Bridge.getInstance().initVec3d(f, f2, f3);
        ScaledResolutionHelper scaledResolutionHelper = AbstractUIScreen.llllIlIllllIlIlIIIllIlIlI();
        double d = vec3Bridge2.bridge$lengthVector();
        if (vec3Bridge.bridge$dotProduct(vec3Bridge2 = vec3Bridge2.bridge$normalize()) <= 0.02) {
            double d2 = 1.5533430342749535;
            double d3 = Math.sin(1.5533430342749535);
            double d4 = Math.cos(1.5533430342749535);
            Vec3Bridge vec3Bridge3 = vec3Bridge.bridge$crossProduct(vec3Bridge2);
            double d5 = vec3Bridge3.bridge$xCoord();
            double d6 = vec3Bridge3.bridge$yCoord();
            double d7 = vec3Bridge3.bridge$zCoord();
            double d8 = d4 + d5 * d5 * (1.0 - d4);
            double d9 = d5 * d6 * (1.0 - d4) - d7 * d3;
            double d10 = d5 * d7 * (1.0 - d4) + d6 * d3;
            double d11 = d6 * d5 * (1.0 - d4) + d7 * d3;
            double d12 = d4 + d6 * d6 * (1.0 - d4);
            double d13 = d6 * d7 * (1.0 - d4) - d5 * d3;
            double d14 = d7 * d5 * (1.0 - d4) - d6 * d3;
            double d15 = d7 * d6 * (1.0 - d4) + d5 * d3;
            double d16 = d4 + d7 * d7 * (1.0 - d4);
            f = (float)(d * (d8 * vec3Bridge.bridge$xCoord() + d9 * vec3Bridge.bridge$yCoord() + d10 * vec3Bridge.bridge$zCoord()));
            f2 = (float)(d * (d11 * vec3Bridge.bridge$xCoord() + d12 * vec3Bridge.bridge$yCoord() + d13 * vec3Bridge.bridge$zCoord()));
            f3 = (float)(d * (d14 * vec3Bridge.bridge$xCoord() + d15 * vec3Bridge.bridge$yCoord() + d16 * vec3Bridge.bridge$zCoord()));
        }
        FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(3);
        Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$project(f, f2, f3, this.llllIIlIIlIIlIIllIIlIIllI, this.IlIlIlllllIlIIlIlIlllIlIl, intBuffer, floatBuffer);
        float f4 = floatBuffer.get(0) / (float)scaledResolutionHelper.llllIIlIIlIIlIIllIIlIIllI();
        float f5 = floatBuffer.get(1) / (float)scaledResolutionHelper.llllIIlIIlIIlIIllIIlIIllI();
        MarkerPosition markerPosition = null;
        int n2 = 6;
        int n3 = 8;
        int n4 = -4 - n3;
        float f6 = (float)scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl() - f5;
        if (f6 < 0.0f) {
            markerPosition = MarkerPosition.lIlIlIlIlIIlIIlIIllIIIIIl;
            f5 = scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl() - 6;
        } else if (f6 > (float)(scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl() - n3)) {
            markerPosition = MarkerPosition.lIllIlIIIlIIIIIIIlllIlIll;
            f5 = 6.0f;
        }
        if (f4 - (float)n2 < 0.0f) {
            markerPosition = MarkerPosition.IlllIIIIIIlllIlIIlllIlIIl;
            f4 = 6.0f;
        } else if (f4 > (float)(scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl() - n2)) {
            markerPosition = MarkerPosition.llIlllIIIllllIIlllIllIIIl;
            f4 = scaledResolutionHelper.lIlIlIlIlIIlIIlIIllIIIIIl() - 6;
        }
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        glStateManagerBridge.bridge$pushMatrix();
        glStateManagerBridge.bridge$translate(f4, (float)scaledResolutionHelper.IlllIIIIIIlllIlIIlllIlIIl() - f5, 200.0f);
        if (markerPosition == null) {
            this.lIlIlIlIlIIlIIlIIllIIIIIl(friendProfile, n2, -((float)n3 / 2.0f) - (float)n3, n3);
            if (n > 40) {
                Ref.getFontRenderer().lIlIlIlIlIIlIIlIIllIIIIIl("(" + n + "m)", 0.0f, 10.0f, 0x78FFFFFF);
            }
        }
        glStateManagerBridge.bridge$popMatrix();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FriendProfile friendProfile, float f, float f2, float f3) {
        TessellatorBridge tessellatorBridge = Bridge.getInstance().initTessellator();
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        glStateManagerBridge.bridge$enableBlend();
        glStateManagerBridge.bridge$disableTexture2D();
        Bridge.lIlIIIIIIlIIIllllIllIIlII().bridge$glBlendFunc(770, 771, 1, 0);
        int n = friendProfile.lIlIIIIIIlIIIllllIllIIlII();
        float f4 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f5 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f6 = (float)(n & 0xFF) / 255.0f;
        glStateManagerBridge.bridge$color(f4, f5, f6, 0.75f);
        glStateManagerBridge.bridge$pushMatrix();
        glStateManagerBridge.bridge$scale(0.5, 0.5, 0.5);
        glStateManagerBridge.bridge$rotate(45.0f, 0.0f, 0.0f, 1.0f);
        glStateManagerBridge.bridge$translate(f * 2.0f, 0.0f, 0.0f);
        glStateManagerBridge.bridge$rotate(90.0f, 0.0f, 0.0f, -1.0f);
        tessellatorBridge.bridge$begin(7, false, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(-f, f2, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(-f, f2 + f3 / 2.0f, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2 + f3 / 2.0f, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f2, 0.0).bridge$endVertex();
        tessellatorBridge.bridge$end();
        glStateManagerBridge.bridge$rotate(90.0f, 0.0f, 0.0f, -1.0f);
        glStateManagerBridge.bridge$translate(f * 2.0f + 3.0f, f3 / 2.0f + 2.0f, 0.0f);
        tessellatorBridge.bridge$begin(7, false, false);
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(-f / 2.0f, f2, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(-f / 2.0f, f2 + f3 / 2.0f, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f - 1.0f, f2 + f3 / 2.0f, 0.0).bridge$endVertex();
        tessellatorBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f - 1.0f, f2, 0.0).bridge$endVertex();
        tessellatorBridge.bridge$end();
        glStateManagerBridge.bridge$popMatrix();
        glStateManagerBridge.bridge$enableTexture2D();
        glStateManagerBridge.bridge$disableBlend();
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(RenderWorldPassEvent renderWorldPassEvent) {
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        this.llllIIlIIlIIlIIllIIlIIllI.rewind();
        glStateManagerBridge.bridge$getFloat(2982, this.llllIIlIIlIIlIIllIIlIIllI);
        this.IlIlIlllllIlIIlIlIlllIlIl.rewind();
        glStateManagerBridge.bridge$getFloat(2983, this.IlIlIlllllIlIIlIlIlllIlIl);
    }

    @Override
    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(float f, float f2, float f3, float f4, float f5, float f6, boolean bl) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Team View", f, f2, f3, f4);
    }

    @Override
    public FeatureDetails initDetails() {
        return new FeatureDetails("teamview", ImmutableList.of(ModuleCategory.ALL, ModuleCategory.SERVER));
    }

    public double lIlIlIlIlIIlIIlIIllIIIIIl(double d, double d2, double d3) {
        double d4 = d - this.mc.bridge$getPlayer().bridge$getPosX();
        double d5 = d2 - this.mc.bridge$getPlayer().bridge$getPosY();
        double d6 = d3 - this.mc.bridge$getPlayer().bridge$getPosZ();
        return Math.sqrt(d4 * d4 + d5 * d5 + d6 * d6);
    }

    public FloatBuffer IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public FloatBuffer lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public enum MarkerPosition {
        lIlIlIlIlIIlIIlIIllIIIIIl, // TOP
        IlllIIIIIIlllIlIIlllIlIIl, // LEFT
        lIllIlIIIlIIIIIIIlllIlIll, // BOTTOM
        llIlllIIIllllIIlllIllIIIl // RIGHT

    }
}

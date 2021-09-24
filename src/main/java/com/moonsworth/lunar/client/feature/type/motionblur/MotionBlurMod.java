package com.moonsworth.lunar.client.feature.type.motionblur;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.world.PreRunTickEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.io.IOException;
import java.util.List;

public class MotionBlurMod extends ConfigurableFeature {
    public NumberSetting llllIIlIIlIIlIIllIIlIIllI;
    public BooleanSetting IlIlIlllllIlIIlIlIlllIlIl;
    public boolean llIIIIIIIllIIllIlIllIIIIl = false;

    public MotionBlurMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
        this.llllIIlIIlIIlIIllIIlIIllI.lIlIlIlIlIIlIIlIIllIIIIIl(((var1) -> {
            this.llIIIIIIIllIIllIlIllIIIIl = true;
            if (this.mc.bridge$getCurrentScreen() == null) {
                this.lIlIlIIIIIIllIlIIIIllIIII();
            }

        }));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(PreRunTickEvent var1) {
        if (this.llIIIIIIIllIIllIlIllIIIIl || this.mc.bridge$getCurrentScreen() == null && (!this.mc.bridge$getEntityRenderer().bridge$isShaderActive() || this.mc.bridge$getEntityRenderer().bridge$getShaderGroup() == null || !this.mc.bridge$getEntityRenderer().bridge$getShaderGroup().bridge$getShaderGroupName().equalsIgnoreCase("minecraft:shaders/post/lunar_motionblur.json"))) {
            if (!this.llIIIIIIIllIIllIlIllIIIIl && Ref.getLC().lllllIllIllIllllIlIllllII().lIlIIlIlllIIlIIIlIlIlIllI().IlIllIIlIIlIIIllIllllIIll()) {
                return;
            }

            this.lIlIlIIIIIIllIlIIIIllIIII();
        }

    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(boolean var1) {
        super.lIlIlIlIlIIlIIlIIllIIIIIl(var1);
        if (!var1 && Ref.getMinecraft().bridge$getEntityRenderer().bridge$isShaderActive()) {
            Ref.getMinecraft().bridge$getEntityRenderer().bridge$stopUseShader();
        }

    }

    public void lIlIlIIIIIIllIlIIIIllIIII() {
        if (true) return; // todo "Invalid shaders/program/lunar_motionblur.json: null"
        try {
            this.llIIIIIIIllIIllIlIllIIIIl = false;
            this.mc.bridge$getEntityRenderer().bridge$loadShader(Bridge.getInstance().initResourceLocation("minecraft", "shaders/post/lunar_motionblur.json"));
            float var1 = (float)(Integer)this.llllIIlIIlIIlIIllIIlIIllI.llIlllIIIllllIIlllIllIIIl() / 10.0F;
            if (var1 >= 1.0F) {
                var1 = 0.99F;
            }

            float var2 = 1.0F - var1;
            if (this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl()) {
                var2 = 0.7F + (float)(Integer)this.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl() / 100.0F * 3.0F - 0.01F;
            }

            if (this.mc.bridge$getEntityRenderer().bridge$getShaderGroup() != null) {
                float finalVar = var2;
                this.mc.bridge$getEntityRenderer().bridge$getShaderGroup().bridge$listShaders().forEach((var2x) -> {
                    if (var2x.bridge$getShaderManager().bridge$getShaderUniform("Phosphor") != null) {
                        var2x.bridge$getShaderManager().bridge$getShaderUniform("Phosphor").bridge$set(finalVar, this.IlIlIlllllIlIIlIlIlllIlIl.llIlllIIIllllIIlllIllIIIl() ? 1.0F : 0.0F, 0.0F);
                    }

                });
            }

        } catch (IOException var4) {
            throw new RuntimeException(var4);
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.IlIlIlllllIlIIlIlIlllIlIl = new BooleanSetting("oldBlur", false), this.llllIIlIIlIIlIIllIIlIIllI = new NumberSetting("value", 1, 1, 10));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("Motion Blur", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("motionBlur", ImmutableList.of(ModuleCategory.ALL));
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public BooleanSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }
}

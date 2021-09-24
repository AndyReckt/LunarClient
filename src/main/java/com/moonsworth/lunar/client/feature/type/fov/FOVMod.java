package com.moonsworth.lunar.client.feature.type.fov;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.type.hud.FOVChangeEvent;
import com.moonsworth.lunar.client.feature.FeatureDetails;
import com.moonsworth.lunar.client.feature.hud.ConfigurableFeature;
import com.moonsworth.lunar.client.feature.hud.ModuleCategory;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BooleanSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class FOVMod extends ConfigurableFeature {
    public NumberSetting llllIIlIIlIIlIIllIIlIIllI;
    public NumberSetting IlIlIlllllIlIIlIlIlllIlIl;
    public NumberSetting llIIIIIIIllIIllIlIllIIIIl;
    public NumberSetting lIIIllIllIIllIlllIlIIlllI;
    public NumberSetting IlllllIlIIIlIIlIIllIIlIll;
    public BooleanSetting llIIlIlIIIllIlIlIlIIlIIll;

    public FOVMod() {
        super(false);
        this.lIlIlIlIlIIlIIlIIllIIIIIl(FOVChangeEvent.class, this::lIlIlIlIlIIlIIlIIllIIIIIl);
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(FOVChangeEvent var1) {
        if (var1.lIlIlIlIlIIlIIlIIllIIIIIl() == FOVChangeEvent.Result.CONSTANT) {
            boolean var2 = false;
            AtomicReference<Float> var3 = new AtomicReference<>(var1.IlllIIIIIIlllIlIIlllIlIIl());

            //?
            FOVMod var4 = Ref.getLC().lllllIllIllIllllIlIllllII().llIIlIlIIIllIlIlIlIIlIIll();
            EntityPlayerSPBridge var5 = Ref.getPlayer();
            if (var5.bridge$isSprinting()) {
                var3.set((float)(Integer)var4.lIlIlIIIIIIllIlIIIIllIIII().llIlllIIIllllIIlllIllIIIl());
                var2 = true;
            }

            if (var5.bridge$getPlayerCapabilities().bridge$isFlying()) {
                var3.set((float)(Integer)var4.lIIlIIIIIIlIIlIIllIlIIlII().llIlllIIIllllIIlllIllIIIl());
                var2 = true;
            }

            if (var5.bridge$isPotionActive(Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$moveSlowdown())) {
                var3.set((float)(Integer)var4.lIllllIllIIlIIlIIIlIIIlII().llIlllIIIllllIIlllIllIIIl());
                var2 = true;
            }

            if (var5.bridge$isPotionActive(Bridge.IIlIllIlllllllIIlIIIllIIl().bridge$moveSpeed())) {
                var3.set((float)(Integer)var4.IlIIlIIlIIlIIllIIIllIIllI().llIlllIIIllllIIlllIllIIIl());
                var2 = true;
            }

            if (!var2) {
                var3.set((float)(Integer)var4.IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl());
            }

            if (var4.IIlIlIIIllIIllllIllllIlIl().llIlllIIIllllIIlllIllIIIl()) {
                var1.cancel();
            }

            var1.lIlIlIlIlIIlIIlIIllIIIIIl(var3.get());
        }
    }

    public List IlIlIlllllIlIIlIlIlllIlIl() {
        return ImmutableList.of(this.llllIIlIIlIIlIIllIIlIIllI = new NumberSetting("default_fov", 70, 30, 110), this.IlIlIlllllIlIIlIlIlllIlIl = new NumberSetting("slowness_fov", 70, 30, 110), this.llIIIIIIIllIIllIlIllIIIIl = new NumberSetting("sprinting_fov", 70, 30, 110), this.lIIIllIllIIllIlllIlIIlllI = new NumberSetting("flying_fov", 70, 30, 110), this.IlllllIlIIIlIIlIIllIIlIll = new NumberSetting("speed_fov", 70, 30, 110), this.llIIlIlIIIllIlIlIlIIlIIll = new BooleanSetting("static_FOV", false));
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(float var1, float var2, float var3, float var4, float var5, float var6, boolean var7) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl("FOV Mod", var1, var2, var3, var4);
    }

    public FeatureDetails initDetails() {
        return new FeatureDetails("fov_mod", ImmutableList.of(ModuleCategory.ALL));
    }

    public NumberSetting IlIllIIlIIlIIIllIllllIIll() {
        return this.llllIIlIIlIIlIIllIIlIIllI;
    }

    public NumberSetting lIllllIllIIlIIlIIIlIIIlII() {
        return this.IlIlIlllllIlIIlIlIlllIlIl;
    }

    public NumberSetting lIlIlIIIIIIllIlIIIIllIIII() {
        return this.llIIIIIIIllIIllIlIllIIIIl;
    }

    public NumberSetting lIIlIIIIIIlIIlIIllIlIIlII() {
        return this.lIIIllIllIIllIlllIlIIlllI;
    }

    public NumberSetting IlIIlIIlIIlIIllIIIllIIllI() {
        return this.IlllllIlIIIlIIlIIllIIlIll;
    }

    public BooleanSetting IIlIlIIIllIIllllIllllIlIl() {
        return this.llIIlIlIIIllIlIlIlIIlIIll;
    }
}

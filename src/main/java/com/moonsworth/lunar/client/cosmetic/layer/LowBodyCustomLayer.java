package com.moonsworth.lunar.client.cosmetic.layer;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.lunar.SkeletalWings;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelBipedBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.part.BodyPart;
import com.moonsworth.lunar.client.cosmetic.type.WingsCosmeticTypeWithRenderf;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

import java.util.Optional;

public class LowBodyCustomLayer implements CustomLayer {
    public static SkeletalWings lIlIlIlIlIIlIIlIIllIIIIIl;
    public final CosmeticManager IlllIIIIIIlllIlIIlllIlIIl;

    public LowBodyCustomLayer(CosmeticManager cosmeticManager) {
        lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.lllIIIIIlllIIlIllIIlIIIlI().initSkeletalWings();
        this.IlllIIIIIIlllIlIIlllIlIIl = cosmeticManager;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        WingsCosmeticTypeWithRenderf wingsCosmeticTypeWithRenderf = this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(abstractClientPlayerBridge.bridge$getUniqueID(), WingsCosmeticTypeWithRenderf.class);
        if (wingsCosmeticTypeWithRenderf != null) {
            if (!wingsCosmeticTypeWithRenderf.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()) {
                return;
            }
            if (abstractClientPlayerBridge.bridge$isInvisible()) {
                return;
            }
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
            if (Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge)) {
                Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge);
                BOBJArmature bOBJArmature = cosmetic.animator.animation.meshes.get(0).armature;
                cosmetic.animator.setupMatrix(bOBJArmature.bones.get("low_body"));
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.25f, 0.0f);
            }
            BodyPart.BODY.lIlIlIlIlIIlIIlIIllIIIIIl((ModelBipedBridge)modelPlayerBridge);
            if (abstractClientPlayerBridge.bridge$isSneaking()) {
                Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.2f, 0.0f);
            }
            lIlIlIlIlIIlIIlIIllIIIIIl.renderLegacy(wingsCosmeticTypeWithRenderf.llIlllIIIllllIIlllIllIIIl(), 0.0625f, wingsCosmeticTypeWithRenderf.llllIIlIIlIIlIIllIIlIIllI());
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, int n, int n2, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f) {
        WingsCosmeticTypeWithRenderf wingsCosmeticTypeWithRenderf = this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(abstractClientPlayerBridge.bridge$getUniqueID(), WingsCosmeticTypeWithRenderf.class);
        if (wingsCosmeticTypeWithRenderf != null) {
            if (!wingsCosmeticTypeWithRenderf.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl().booleanValue()) {
                return;
            }
            if (abstractClientPlayerBridge.bridge$isInvisible()) {
                return;
            }
            matrixStackBridge.lIllIlIIIlIIIIIIIlllIlIll();
            if (Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge)) {
                Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge);
                if (cosmetic.animator != null) {
                    BOBJArmature bOBJArmature = cosmetic.animator.animation.meshes.get(0).armature;
                    cosmetic.animator.setupMatrix(bOBJArmature.bones.get("low_body"));
                    matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(0.0, 0.25, 0.0);
                }
            }
            if (abstractClientPlayerBridge.bridge$isSneaking() && !abstractClientPlayerBridge.bridge$getPlayerCapabilities().bridge$isFlying()) {
                matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(0.0, 0.2f, 0.0);
            }
            lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, n, wingsCosmeticTypeWithRenderf.llIlllIIIllllIIlllIllIIIl(), 0.0625f, wingsCosmeticTypeWithRenderf.llllIIlIIlIIlIIllIIlIIllI());
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    @Override
    public int lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        return 1;
    }

    @Override
    public Optional lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        return lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge);
    }

    @Override
    public Optional lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, int n) {
        WingsCosmeticTypeWithRenderf wingsCosmeticTypeWithRenderf = this.IlllIIIIIIlllIlIIlllIlIIl.IlllIIIIIIlllIlIIlllIlIIl(abstractClientPlayerBridge.bridge$getUniqueID(), WingsCosmeticTypeWithRenderf.class);
        if (wingsCosmeticTypeWithRenderf != null) {
            return Optional.of(wingsCosmeticTypeWithRenderf.llllIIlIIlIIlIIllIIlIIllI());
        }
        return Optional.empty();
    }
}

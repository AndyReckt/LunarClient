package com.moonsworth.lunar.client.cosmetic.layer;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.client.cosmetic.RenderableCosmeticType;
import com.moonsworth.lunar.client.cosmetic.de.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

import java.util.List;
import java.util.Optional;

public class CosmeticManagerLayer
implements CustomLayer {
    public final CosmeticManager lIlIlIlIlIIlIIlIIllIIIIIl;

    public CosmeticManagerLayer(CosmeticManager cosmeticManager) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = cosmeticManager;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (abstractClientPlayerBridge.bridge$isInvisible() || Ref.IlIlIlllllIlIIlIlIlllIlIl() != null && abstractClientPlayerBridge.bridge$isInvisibleTo(Ref.IlIlIlllllIlIIlIlIlllIlIl()) || abstractClientPlayerBridge.bridge$isSpectator()) {
            return;
        }
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge.bridge$getUniqueID());
        boolean bl = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge);
        float f8 = abstractClientPlayerBridge.bridge$getPrevRotationYawHead() + (abstractClientPlayerBridge.bridge$getRotationYawHead() - abstractClientPlayerBridge.bridge$getPrevRotationYawHead()) * f3;
        float f9 = abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset() + (abstractClientPlayerBridge.bridge$getRenderYawOffset() - abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset()) * f3;
        float f10 = (float)(abstractClientPlayerBridge.bridge$getPreviousRotationPitch() + (abstractClientPlayerBridge.bridge$getRotationPitch() - abstractClientPlayerBridge.bridge$getPreviousRotationPitch()) * (double)f3);
        List<RenderableCosmeticType> list = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge.bridge$getUniqueID(), RenderableCosmeticType.class);
        for (RenderableCosmeticType renderableCosmeticType : list) {
            AbstractCosmetic abstractCosmetic;
            if (renderableCosmeticType == null || !((Boolean)renderableCosmeticType.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()).booleanValue() || !renderableCosmeticType.llIIIIIIIllIIllIlIllIIIIl() || (abstractCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(renderableCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) == null || abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl() && abstractClientPlayerBridge.bridge$getArmor(abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl()) != null && !abstractCosmetic.llllIIlIIlIIlIIllIIlIIllI()) continue;
            if (bl) {
                BOBJArmature bOBJArmature = ((AnimationMesh)cosmetic.animator.animation.meshes.get((int)0)).armature;
                cosmetic.animator.setupMatrix((BOBJBone)bOBJArmature.bones.get("low_body"));
            }
            lunar.au.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, modelPlayerBridge, renderableCosmeticType, abstractCosmetic, f, f2, f5, f6, f7, f4, f3, false, bl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, int n, int n2, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f) {
        RenderableCosmeticType renderableCosmeticType;
        BOBJArmature object;
        if (abstractClientPlayerBridge.bridge$isInvisible() || Ref.IlIlIlllllIlIIlIlIlllIlIl() != null && abstractClientPlayerBridge.bridge$isInvisibleTo(Ref.IlIlIlllllIlIIlIlIlllIlIl()) || abstractClientPlayerBridge.bridge$isSpectator()) {
            return;
        }
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge.bridge$getUniqueID());
        boolean bl = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge);
        if (bl && cosmetic.animator != null) {
            object = cosmetic.animator.animation.meshes.get((int)0).armature;
            cosmetic.animator.setupMatrix(object.bones.get("low_body"), matrixStackBridge);
        }
        if ((renderableCosmeticType = (RenderableCosmeticType) this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge.bridge$getUniqueID(), RenderableCosmeticType.class).get(n2)) != null && ((Boolean)renderableCosmeticType.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()).booleanValue() && renderableCosmeticType.llIIIIIIIllIIllIlIllIIIIl()) {
            AbstractCosmetic abstractCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(renderableCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            if (abstractCosmetic == null) {
                return;
            }
            if (abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl() && abstractClientPlayerBridge.bridge$getArmor(abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().IlllIIIIIIlllIlIIlllIlIIl()) != null && !abstractCosmetic.llllIIlIIlIIlIIllIIlIIllI()) {
                return;
            }
            lunar.au.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, n, modelPlayerBridge, renderableCosmeticType, abstractCosmetic, 0.0f, f, false, bl);
        }
    }

    @Override
    public Optional lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, int n) {
        List list = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge.bridge$getUniqueID(), RenderableCosmeticType.class);
        RenderableCosmeticType renderableCosmeticType = (RenderableCosmeticType)list.get(n);
        if (renderableCosmeticType != null) {
            AbstractCosmetic abstractCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl(renderableCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            if (abstractCosmetic == null) {
                return null;
            }
            if (abstractCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                return Optional.ofNullable(renderableCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            }
            return Optional.ofNullable(abstractCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        return Optional.empty();
    }

    @Override
    public int lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge.bridge$getUniqueID(), RenderableCosmeticType.class).size();
    }
}
 
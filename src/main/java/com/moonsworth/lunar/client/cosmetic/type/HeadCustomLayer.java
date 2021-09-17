package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.CustomLayer;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.registry.CosmeticManager;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

import java.util.List;
import java.util.Optional;

public class HeadCustomLayer
implements CustomLayer {
    public final CosmeticManager lIlIlIlIlIIlIIlIIllIIIIIl;

    public HeadCustomLayer(CosmeticManager cosmeticManager) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = cosmeticManager;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (abstractClientPlayerBridge.bridge$isInvisible() || Ref.IlIlIlllllIlIIlIlIlllIlIl() != null && abstractClientPlayerBridge.bridge$isInvisibleTo(Ref.IlIlIlllllIlIIlIlIlllIlIl()) || abstractClientPlayerBridge.bridge$isSpectator()) {
            return;
        }
        // todo Cosmetic.get() = McHorse
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge.bridge$getUniqueID());
        boolean bl = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge);
        if (bl) {
            BOBJArmature bOBJArmature = ((AnimationMesh)cosmetic.animator.animation.meshes.get((int)0)).armature;
            cosmetic.animator.setupMatrix((BOBJBone)bOBJArmature.bones.get("head"));
        }
        float f8 = abstractClientPlayerBridge.bridge$getPrevRotationYawHead() + (abstractClientPlayerBridge.bridge$getRotationYawHead() - abstractClientPlayerBridge.bridge$getPrevRotationYawHead()) * f3;
        float f9 = abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset() + (abstractClientPlayerBridge.bridge$getRenderYawOffset() - abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset()) * f3;
        float f10 = (float)(abstractClientPlayerBridge.bridge$getPreviousRotationPitch() + (abstractClientPlayerBridge.bridge$getRotationPitch() - abstractClientPlayerBridge.bridge$getPreviousRotationPitch()) * (double)f3);
        List<HatCosmeticType> list = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(abstractClientPlayerBridge.bridge$getUniqueID());
        for (HatCosmeticType hatCosmeticType : list) {
            HatCosmetic hatCosmetic;
            if (hatCosmeticType == null || !((Boolean)hatCosmeticType.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()).booleanValue() || !hatCosmeticType.llIIIIIIIllIIllIlIllIIIIl() || (hatCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) == null || abstractClientPlayerBridge.bridge$getArmor(3) != null && !hatCosmetic.IIlIllIlllllllIIlIIIllIIl()) continue;
            CosmeticRendererFinal.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, modelPlayerBridge, hatCosmeticType, hatCosmetic, 0.0f, f3, abstractClientPlayerBridge.bridge$isSneaking() ? 0.25f : 0.5f, f7, f9, f8, f10, false, bl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, int n, int n2, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, float f) {
        HatCosmetic hatCosmetic;
        HatCosmeticType hatCosmeticType;
        Object object;
        if (abstractClientPlayerBridge.bridge$isInvisible() || Ref.IlIlIlllllIlIIlIlIlllIlIl() != null && abstractClientPlayerBridge.bridge$isInvisibleTo(Ref.IlIlIlllllIlIIlIlIlllIlIl()) || abstractClientPlayerBridge.bridge$isSpectator()) {
            return;
        }
        matrixStackBridge.lIllIlIIIlIIIIIIIlllIlIll();
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge.bridge$getUniqueID());
        boolean bl = Ref.IlllIIIIIIlllIlIIlllIlIIl().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge);
        if (bl && cosmetic.animator != null) {
            object = ((AnimationMesh)cosmetic.animator.animation.meshes.get((int)0)).armature;
            cosmetic.animator.setupMatrix((BOBJBone)((BOBJArmature)object).bones.get("head"), matrixStackBridge);
        }
        if ((hatCosmeticType = (HatCosmeticType)(object = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(abstractClientPlayerBridge.bridge$getUniqueID())).get(n2)) != null && ((Boolean)hatCosmeticType.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()).booleanValue() && hatCosmeticType.llIIIIIIIllIIllIlIllIIIIl() && (hatCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) != null && (abstractClientPlayerBridge.bridge$getArmor(3) == null || hatCosmetic.IIlIllIlllllllIIlIIIllIIl())) {
            CosmeticRendererFinal.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, modelPlayerBridge, lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, n, hatCosmeticType, hatCosmetic, 0.0f, f, false, bl);
        }
        matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl();
    }

    @Override
    public Optional lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, int n) {
        List list = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(abstractClientPlayerBridge.bridge$getUniqueID());
        HatCosmeticType hatCosmeticType = (HatCosmeticType)list.get(n);
        if (hatCosmeticType != null) {
            HatCosmetic hatCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            if (hatCosmetic == null) {
                return null;
            }
            if (hatCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
                return Optional.of(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            }
            return Optional.of(hatCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        return Optional.empty();
    }

    @Override
    public int lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge) {
        return this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(abstractClientPlayerBridge.bridge$getUniqueID()).size();
    }

    @Override
    public Optional lIlIlIlIlIIlIIlIIllIIIIIl(ResourceLocationBridge resourceLocationBridge) {
        return Bridge.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(resourceLocationBridge, false, false);
    }
}
 
package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
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

public class HeadCustomLayer implements CustomLayer {
    public final CosmeticManager lIlIlIlIlIIlIIlIIllIIIIIl;

    public HeadCustomLayer(CosmeticManager cosmeticManager) {
        this.lIlIlIlIlIIlIIlIIllIIIIIl = cosmeticManager;
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        if (abstractClientPlayerBridge.bridge$isInvisible() || Ref.getPlayer() != null && abstractClientPlayerBridge.bridge$isInvisibleTo(Ref.getPlayer()) || abstractClientPlayerBridge.bridge$isSpectator()) {
            return;
        }
        Cosmetic cosmetic = (Cosmetic)Cosmetic.get(abstractClientPlayerBridge.bridge$getUniqueID());
        boolean bl = Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge);
        if (bl) {
            BOBJArmature bOBJArmature = cosmetic.animator.animation.meshes.get(0).armature;
            cosmetic.animator.setupMatrix(bOBJArmature.bones.get("head"));
        }
        float f8 = abstractClientPlayerBridge.bridge$getPrevRotationYawHead() + (abstractClientPlayerBridge.bridge$getRotationYawHead() - abstractClientPlayerBridge.bridge$getPrevRotationYawHead()) * f3;
        float f9 = abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset() + (abstractClientPlayerBridge.bridge$getRenderYawOffset() - abstractClientPlayerBridge.bridge$getPreviousRotationYawOffset()) * f3;
        float f10 = (float)(abstractClientPlayerBridge.bridge$getPreviousRotationPitch() + (abstractClientPlayerBridge.bridge$getRotationPitch() - abstractClientPlayerBridge.bridge$getPreviousRotationPitch()) * (double)f3);
        List<HatCosmeticType> list = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(abstractClientPlayerBridge.bridge$getUniqueID());
        for (HatCosmeticType hatCosmeticType : list) {
            HatCosmetic hatCosmetic;
            if (hatCosmeticType == null || !hatCosmeticType.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl() || !hatCosmeticType.llIIIIIIIllIIllIlIllIIIIl() || (hatCosmetic = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) == null || abstractClientPlayerBridge.bridge$getArmor(3) != null && !hatCosmetic.IIlIllIlllllllIIlIIIllIIl()) continue;
            CosmeticRendererFinal.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, modelPlayerBridge, hatCosmeticType, hatCosmetic, 0.0f, f3, abstractClientPlayerBridge.bridge$isSneaking() ? 0.25f : 0.5f, f7, f9, f8, f10, false, bl);
        }
    }

    public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, ModelPlayerBridge var2, int var3, int var4, com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll var5, MatrixStackBridge var6, float var7) {
        if (!var1.bridge$isInvisible() && (Ref.getPlayer() == null || !var1.bridge$isInvisibleTo(Ref.getPlayer())) && !var1.bridge$isSpectator()) {
            var6.lIllIlIIIlIIIIIIIlllIlIll();
            Cosmetic var8 = (Cosmetic)Cosmetic.get(var1.bridge$getUniqueID());
            boolean var9 = Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(var1);
            if (var9 && var8.animator != null) {
                BOBJArmature var10 = var8.animator.animation.meshes.get(0).armature;
                var8.animator.setupMatrix(var10.bones.get("head"), var6);
            }

            List var13 = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll(var1.bridge$getUniqueID());
            HatCosmeticType var11 = (HatCosmeticType)var13.get(var4);
            if (var11 != null && var11.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl() && var11.llIIIIIIIllIIllIlIllIIIIl()) {
                HatCosmetic var12 = this.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var11.llllIIlIIlIIlIIllIIlIIllI());
                if (var12 != null && (var1.bridge$getArmor(3) == null || var12.IIlIllIlllllllIIlIIIllIIl())) {
                    CosmeticRendererFinal.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, var5, var6, var3, var11, var12, 0.0F, var7, false, var9);
                }
            }
            var6.IlllIIIIIIlllIlIIlllIlIIl();
        }
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

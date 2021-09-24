package com.moonsworth.lunar.client.cosmetic.au;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelBipedBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.model.ModelMesh;
import com.moonsworth.lunar.client.cosmetic.part.AbstractCosmetic;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public class lIlIlIlIlIIlIIlIIllIIIIIl {
    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelBipedBridge modelBipedBridge, Cosmetic cosmetic, AbstractCosmetic abstractCosmetic, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl, boolean bl2) {
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        glStateManagerBridge.bridge$pushMatrix();
        glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        if (bl2) {
            glStateManagerBridge.bridge$rotate(180.0f, 0.0f, 0.0f, 1.0f);
            glStateManagerBridge.bridge$translate(0.0f, 0.75f, 0.0f);
        }
        if (abstractClientPlayerBridge != null) {
            modelBipedBridge.bridge$setSneak(abstractClientPlayerBridge.bridge$isSneaking() && !bl2);
            modelBipedBridge.bridge$setRotationAngles(f, f2, f6, f3, f4, f5, abstractClientPlayerBridge);
            if (abstractClientPlayerBridge.bridge$isSneaking() && !bl2 && Bridge.getMinecraftVersion().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal()) {
                glStateManagerBridge.bridge$translate(0.0f, 0.2f, 0.0f);
            }
            abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(modelBipedBridge).transform(abstractClientPlayerBridge, f7);
        }
        if (bl) {
            float f8 = (f6 + f7) / 20.0f * 57.295776f;
            glStateManagerBridge.bridge$rotate(f8, 0.0f, 1.0f, 0.0f);
        }
        if (!bl2) {
            for (CosmeticRotationHelper cosmeticRotationHelper : abstractCosmetic.llIIIlllIIlllIllllIlIllIl()) {
                cosmeticRotationHelper.transform(abstractClientPlayerBridge, f7);
            }
        }
        ModelMesh modelMesh = null;
        if (abstractCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(cosmetic.llllIIlIIlIIlIIllIIlIIllI());
            if (Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(cosmetic.llllIIlIIlIIlIIllIIlIIllI())) {
                modelMesh = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(cosmetic.llllIIlIIlIIlIIllIIlIIllI());
            }
        } else {
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(abstractCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        if (modelMesh == null) {
            modelMesh = abstractCosmetic.lIlIIIIIIlIIIllllIllIIlII();
        }
        if (modelMesh != null) {
            modelMesh.IlllIIIIIIlllIlIIlllIlIIl();
        }
        glStateManagerBridge.bridge$popMatrix();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, int n, ModelPlayerBridge modelPlayerBridge, Cosmetic cosmetic, AbstractCosmetic abstractCosmetic, float f, float f2, boolean bl, boolean bl2) {
        abstractCosmetic.llIIlIlIIIllIlIlIlIIlIIll().lIlIlIlIlIIlIIlIIllIIIIIl(modelPlayerBridge).lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, matrixStackBridge, f2);
        if (bl2) {
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, 0.0f, 180.0f);
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, -90.0f, 0.0f);
        }
        if (bl) {
            float f3 = (f + f2) / 20.0f * 57.295776f;
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, f3, 0.0f);
        }
        for (CosmeticRotationHelper cosmeticRotationHelper : abstractCosmetic.llIIIlllIIlllIllllIlIllIl()) {
            cosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, matrixStackBridge, f2);
        }
        Object object = abstractCosmetic.lIlIIIIIIlIIIllllIllIIlII();
        if (abstractCosmetic.llIIIIIIIllIIllIlIllIIIIl() && Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(cosmetic.llllIIlIIlIIlIIllIIlIIllI())) {
            object = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(cosmetic.llllIIlIIlIIlIIllIIlIIllI());
        }
        if (object != null) {
            ((ModelMesh)object).lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, n);
        }
    }
}

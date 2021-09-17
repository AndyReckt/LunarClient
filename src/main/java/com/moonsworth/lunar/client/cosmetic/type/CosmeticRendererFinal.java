package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MathHelperBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

public final class CosmeticRendererFinal {
    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, HatCosmeticType hatCosmeticType, HatCosmetic hatCosmetic, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean bl, boolean bl2) {
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        MathHelperBridge mathHelperBridge = Bridge.lIIlIlllIlIlIIIlllIIlIIII();
        glStateManagerBridge.bridge$pushMatrix();
        glStateManagerBridge.bridge$color(1.0f, 1.0f, 1.0f, 1.0f);
        if (!bl2) {
            if (Bridge.IlllIIIIIIlllIlIIlllIlIIl().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal() && abstractClientPlayerBridge != null) {
                if (abstractClientPlayerBridge.bridge$isSneaking()) {
                    glStateManagerBridge.bridge$translate(0.0f, 0.2f, 0.0f);
                }
                modelPlayerBridge.bridge$head().bridge$postRender(f4);
            }
            glStateManagerBridge.bridge$rotate(90.0f, 0.0f, 1.0f, 0.0f);
        }
        if (bl2) {
            glStateManagerBridge.bridge$rotate(180.0f, 0.0f, 0.0f, 1.0f);
            glStateManagerBridge.bridge$rotate(90.0f, 0.0f, -1.0f, 0.0f);
        }
        if (bl) {
            float f8 = (f + f2) / 20.0f * 57.295776f;
            glStateManagerBridge.bridge$rotate(f8, 0.0f, 1.0f, 0.0f);
        }
        for (CosmeticRotationHelper cosmeticRotationHelper : hatCosmetic.llIIIlllIIlllIllllIlIllIl()) {
            cosmeticRotationHelper.transform(abstractClientPlayerBridge, f2);
        }
        Object object = null;
        if (hatCosmetic.llIIIIIIIllIIllIlIllIIIIl()) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            if (Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) {
                object = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
            }
        } else {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getTextureManager().bridge$bindTexture(hatCosmetic.lIlIlIlIlIIlIIlIIllIIIIIl());
        }
        if (object == null) {
            object = hatCosmetic.lIlIIIIIIlIIIllllIllIIlII();
        }
        if (object != null) {
            ((ModelMesh)object).IlllIIIIIIlllIlIIlllIlIIl();
        }
        glStateManagerBridge.bridge$popMatrix();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge abstractClientPlayerBridge, ModelPlayerBridge modelPlayerBridge, lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, int n, HatCosmeticType hatCosmeticType, HatCosmetic hatCosmetic, float f, float f2, boolean bl, boolean bl2) {
        if (bl2) {
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, 0.0f, 180.0f);
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, -90.0f, 0.0f);
        } else {
            BodyPart.HEAD.lIlIlIlIlIIlIIlIIllIIIIIl(modelPlayerBridge).lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, matrixStackBridge, f2);
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, 90.0f, 0.0f);
        }
        if (bl) {
            float f3 = (f + f2) / 20.0f * 57.295776f;
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, f3, 0.0f);
        }
        for (CosmeticRotationHelper cosmeticRotationHelper : hatCosmetic.llIIIlllIIlllIllllIlIllIl()) {
            cosmeticRotationHelper.lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge, matrixStackBridge, f2);
        }
        Object object = hatCosmetic.lIlIIIIIIlIIIllllIllIIlII();
        if (hatCosmetic.llIIIIIIIllIIllIlIllIIIIl() && Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI())) {
            object = (ModelMesh)Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(hatCosmeticType.llllIIlIIlIIlIIllIIlIIllI());
        }
        if (object != null) {
            ((ModelMesh)object).lIlIlIlIlIIlIIlIIllIIIIIl(lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, n);
        }
    }
}
 
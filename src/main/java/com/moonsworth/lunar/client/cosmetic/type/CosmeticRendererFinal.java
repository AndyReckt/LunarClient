package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.MathHelperBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.model.ModelMesh;
import com.moonsworth.lunar.client.cosmetic.part.BodyPart;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.util.CosmeticRotationHelper;

import java.util.Iterator;

public final class CosmeticRendererFinal {
    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var0, ModelPlayerBridge var1, HatCosmeticType var2, HatCosmetic var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, boolean var11, boolean var12) {
        GlStateManagerBridge var13 = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        MathHelperBridge var14 = Bridge.lIIlIlllIlIlIIIlllIIlIIII();
        var13.bridge$pushMatrix();
        var13.bridge$color(1.0F, 1.0F, 1.0F, 1.0F);
        if (!var12) {
            if (Bridge.getMinecraftVersion().ordinal() >= MinecraftVersion.IlllIIIIIIlllIlIIlllIlIIl.ordinal() && var0 != null) {
                if (var0.bridge$isSneaking()) {
                    var13.bridge$translate(0.0F, 0.2F, 0.0F);
                }

                var1.bridge$head().bridge$postRender(var7);
            }

            var13.bridge$rotate(90.0F, 0.0F, 1.0F, 0.0F);
        }

        if (var12) {
            var13.bridge$rotate(180.0F, 0.0F, 0.0F, 1.0F);
            var13.bridge$rotate(90.0F, 0.0F, -1.0F, 0.0F);
        }

        if (var11) {
            float var15 = (var4 + var5) / 20.0F * 57.295776F;
            var13.bridge$rotate(var15, 0.0F, 1.0F, 0.0F);
        }

        Iterator<CosmeticRotationHelper> var17 = var3.llIIIlllIIlllIllllIlIllIl().iterator();

        while(var17.hasNext()) {
            CosmeticRotationHelper var16 = var17.next();
            var16.transform(var0, var5);
        }

        ModelMesh var18 = null;
        if (var3.llIIIIIIIllIIllIlIllIIIIl()) {
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(var2.llllIIlIIlIIlIIllIIlIIllI());
            if (Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(var2.llllIIlIIlIIlIIllIIlIIllI())) {
                var18 = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(var2.llllIIlIIlIIlIIllIIlIIllI());
            }
        } else {
            Ref.getMinecraft().bridge$getTextureManager().bridge$bindTexture(var3.lIlIlIlIlIIlIIlIIllIIIIIl());
        }

        if (var18 == null) {
            var18 = var3.lIlIIIIIIlIIIllllIllIIlII();
        }

        if (var18 != null) {
            var18.IlllIIIIIIlllIlIIlllIlIIl();
        }

        var13.bridge$popMatrix();
    }

    public static void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var0, ModelPlayerBridge var1, com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll var2, MatrixStackBridge var3, int var4, HatCosmeticType var5, HatCosmetic var6, float var7, float var8, boolean var9, boolean var10) {
        if (var10) {
            var3.IlllIIIIIIlllIlIIlllIlIIl(0.0F, 0.0F, 180.0F);
            var3.IlllIIIIIIlllIlIIlllIlIIl(0.0F, -90.0F, 0.0F);
        } else {
            BodyPart.HEAD.lIlIlIlIlIIlIIlIIllIIIIIl(var1).lIlIlIlIlIIlIIlIIllIIIIIl(var0, var3, var8);
            var3.IlllIIIIIIlllIlIIlllIlIIl(0.0F, 90.0F, 0.0F);
        }

        if (var9) {
            float var11 = (var7 + var8) / 20.0F * 57.295776F;
            var3.IlllIIIIIIlllIlIIlllIlIIl(0.0F, var11, 0.0F);
        }

        Iterator var13 = var6.llIIIlllIIlllIllllIlIllIl().iterator();

        while(var13.hasNext()) {
            CosmeticRotationHelper var12 = (CosmeticRotationHelper)var13.next();
            var12.lIlIlIlIlIIlIIlIIllIIIIIl(var0, var3, var8);
        }

        ModelMesh var14 = var6.lIlIIIIIIlIIIllllIllIIlII();
        if (var6.llIIIIIIIllIIllIlIllIIIIl() && Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIllIlIIIlIIIIIIIlllIlIll(var5.llllIIlIIlIIlIIllIIlIIllI())) {
            var14 = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lllllIllIllIllllIlIllllII().get(var5.llllIIlIIlIIlIIllIIlIIllI());
        }

        if (var14 != null) {
            var14.lIlIlIlIlIIlIIlIIllIIIIIl(var2, var3, var4);
        }

    }
}

package com.moonsworth.lunar.client.cosmetic.de;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.type.HeadCustomLayer;
import com.moonsworth.lunar.client.ref.Ref;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

import java.util.Collections;
import java.util.Optional;

public enum lIlIlIlIlIIlIIlIIllIIIIIl {
    lIlIlIlIlIIlIIlIIllIIIIIl {
        public final HeadCustomLayer llIlllIIIllllIIlllIllIIIl = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIIIIIIlIIIllllIllIIlII();

        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, ModelPlayerBridge var2, int var3, com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl var4, MatrixStackBridge var5, float var6, float var7) {
            for(int var8 = 0; var8 < this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1); ++var8) {
                Optional var9 = this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var8);
                if (var9.isPresent()) {
                    Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getTextureManager().bridge$bindTexture((ResourceLocationBridge)var9.get());
                    var5.lIllIlIIIlIIIIIIIlllIlIll();
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableDepth();
                    Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$enableCull();
                    this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var2, var3, var8, null, var5, var6);
                    var5.IlllIIIIIIlllIlIIlllIlIIl();
                }
            }

        }
    },
    IlllIIIIIIlllIlIIlllIlIIl {
        public final LayerCapeBridge llIlllIIIllllIIlllIllIIIl = LunarClient.getInstance().IIlIllIlIIllIIlIlIllllllI().IIlIllIlllllllIIlIIIllIIl();

        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, ModelPlayerBridge var2, int var3, com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl var4, MatrixStackBridge var5, float var6, float var7) {
            var5.lIllIlIIIlIIIIIIIlllIlIll();
            if (Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(var1)) {
                Cosmetic var8 = (Cosmetic)Cosmetic.get(var1);
                BOBJArmature var9 = var8.animator.animation.meshes.get(0).armature;
                var8.animator.setupMatrix(var9.bones.get("low_body"), var5);
            }

            var5.lIlIlIlIlIIlIIlIIllIIIIIl(0.0D, 0.375D, 0.0D);
            var5.IlllIIIIIIlllIlIIlllIlIIl(0.0F, 0.0F, 180.0F);
            this.llIlllIIIllllIIlllIllIIIl.lIlIlIlIlIIlIIlIIllIIIIIl(var1, var5, var4, var3, 0.0F, 0.0F, var6, 0.0F, 0.0F, 0.0F);
            var5.IlllIIIIIIlllIlIIlllIlIIl();
        }
    },
    lIllIlIIIlIIIIIIIlllIlIll {
        public void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, ModelPlayerBridge var2, int var3, com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl var4, MatrixStackBridge var5, float var6, float var7) {
            var5.lIllIlIIIlIIIIIIIlllIlIll();
            var5.IlllIIIIIIlllIlIIlllIlIIl(0.0F, var7, 0.0F);
            if (Ref.getLC().lIIlIIIIIIlIIlIIllIlIIlII().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().containsKey(var1.bridge$getUniqueID())) {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var1, Ref.getLC().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().get(var1.bridge$getUniqueID()), var5, var4, var3);
            } else {
                Bridge.IlllllIlIIIlIIlIIllIIlIll().lIlIlIlIlIIlIIlIIllIIIIIl(var1, Collections.singletonList(var1.bridge$getDisplayName()), var5, var4, var3);
            }

            var5.IlllIIIIIIlllIlIIlllIlIIl();
        }
    };

    lIlIlIlIlIIlIIlIIllIIIIIl() {
    }

    public abstract void lIlIlIlIlIIlIIlIIllIIIIIl(AbstractClientPlayerBridge var1, ModelPlayerBridge var2, int var3, com.moonsworth.lunar.bridge.minecraft.client.renderer.lIlIlIlIlIIlIIlIIllIIIIIl var4, MatrixStackBridge var5, float var6, float var7);

    // $FF: synthetic method
    lIlIlIlIlIIlIIlIIllIIIIIl(Object var3) {
        this();
    }
}

package com.moonsworth.lunar.client.cosmetic.type;

import com.moonsworth.lunar.bridge.lunar.SkeletalWings;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.Cosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.ref.Ref;

public class WingsCosmeticTypeWithRenderf extends Cosmetic {
    public static SkeletalWings lIlIlIlIlIIlIIlIIllIIIIIl;

    public WingsCosmeticTypeWithRenderf(final long n, final String s, final float n2, final String s2, final boolean b) {
        super(n, s, n2, s2, CosmeticType.WINGS, b);
        WingsCosmeticTypeWithRenderf.lIlIlIlIlIIlIIlIIllIIIIIl = Bridge.lllIIIIIlllIIlIllIIlIIIlI().initSkeletalWings();
    }

    @Override
    public void lIlIlIlIlIIlIIlIIllIIIIIl(final AbstractClientPlayerBridge abstractClientPlayerBridge, final float n) {
        if (!(boolean) this.lIllIlIIIlIIIIIIIlllIlIll().lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()) {
            return;
        }
        if (abstractClientPlayerBridge.bridge$isInvisible()) {
            return;
        }
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$pushMatrix();
        if (Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayerBridge)) {
            final mchorse.emoticons.capabilities.cosmetic.Cosmetic cosmetic = (mchorse.emoticons.capabilities.cosmetic.Cosmetic) mchorse.emoticons.capabilities.cosmetic.Cosmetic.get(abstractClientPlayerBridge);
            cosmetic.animator.setupMatrix(cosmetic.animator.animation.meshes.get(0).armature.bones.get("low_body"));
            Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$translate(0.0f, 0.25f, 0.0f);
        }
        WingsCosmeticTypeWithRenderf.lIlIlIlIlIIlIIlIIllIIIIIl.renderLegacy(this.llIlllIIIllllIIlllIllIIIl(), 0.0625f, this.llllIIlIIlIIlIIllIIlIIllI());
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$popMatrix();
    }
}

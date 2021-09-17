/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector4f
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.a.Bridge
 *  lunar.o.EntityFXBridge
 */
package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;
import lunar.G.EntityLivingBaseBridge;
import lunar.a.Bridge;
import lunar.o.EntityFXBridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

public class PureSaltEmote
extends Emote {
    public PureSaltEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        if (n > 18 && n <= 78 && n % 2 == 0) {
            int n2;
            BOBJBone bOBJBone = (BOBJBone)bOBJArmature.bones.get("low_right_arm.end");
            Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJBone, 0.0f, 0.15f, 0.0f, f);
            int n3 = n2 = n == 78 ? 12 : 1;
            for (int i = 0; i < n2; ++i) {
                EntityFXBridge entityFXBridge = Bridge.lllIIIIIlllIIlIllIIlIIIlI().initSaltParticle(entityLivingBaseBridge.bridge$getWorld(), (double)vector4f.x, (double)vector4f.y, (double)vector4f.z, 0.0);
                Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getEffectRenderer().bridge$addEffect(entityFXBridge);
            }
        }
    }
}


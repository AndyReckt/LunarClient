/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector4f
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.af.ParticleType
 */
package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;
import lunar.G.EntityLivingBaseBridge;
import lunar.af.ParticleType;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.mclib.utils.Time;

public class SneezeEmote
extends Emote {
    public SneezeEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        super.progressAnimation(entityLivingBaseBridge, bOBJArmature, animatorEmoticonsController, n, f);
        if (n == Time.toTicks(121) - 1) {
            for (int i = 0; i < 10; ++i) {
                Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, (BOBJBone)bOBJArmature.bones.get("head"), 0.0f, 0.125f, 0.25f, f);
                entityLivingBaseBridge.bridge$getWorld().bridge$spawnParticle(ParticleType.lIIlIIIIIIlIIlIIllIlIIlII, (double)vector4f.x, (double)vector4f.y, (double)vector4f.z, (double)this.rand(0.05f), (double)-0.025f, (double)this.rand(0.05f), new int[0]);
            }
        }
    }
}


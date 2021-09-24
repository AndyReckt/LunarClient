package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

public class StarPowerEmote
    extends Emote {
    public StarPowerEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        Vector4f vector4f;
        BOBJBone bOBJBone;
        if (n == 30) {
            bOBJBone = bOBJArmature.bones.get("low_right_arm.end");
            vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJBone, 0.0f, 0.15f, 0.0f, f);
            int n2 = 15;
            for (int i = 0; i < n2; ++i) {
            }
        }
        if (n >= 33 && n < 43) {
            bOBJBone = bOBJArmature.bones.get("low_right_arm.end");
            vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJBone, 0.0f, 0.15f, 0.0f, f);
            float f2 = 1.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            float f5 = (float)(n - 33) / 10.0f;
            if (!((double)f5 < 0.2)) {
                if ((double)f5 < 0.35) {
                    f3 = 0.5f;
                } else if ((double)f5 < 0.45) {
                    f3 = 1.0f;
                } else if ((double)f5 < 0.65) {
                    f2 = 0.25f;
                    f3 = 1.0f;
                } else if ((double)f5 < 0.85) {
                    f2 = 0.0f;
                    f3 = 0.75f;
                    f4 = 1.0f;
                } else {
                    f2 = 0.0f;
                    f3 = 0.0f;
                    f4 = 1.0f;
                }
            }
            int n3 = 7;
            for (int i = 0; i < n3; ++i) {
                entityLivingBaseBridge.bridge$getWorld().bridge$spawnParticle(ParticleType.IllIllIIIllIIIlIlIlIIIIll, (double)vector4f.x + LunarClient.RANDOM.nextDouble() * 0.05 - 0.025, (double)vector4f.y + LunarClient.RANDOM.nextDouble() * 0.05 - 0.025, (double)vector4f.z + LunarClient.RANDOM.nextDouble() * 0.05 - 0.025, f2, f3, f4);
            }
        }
    }
}


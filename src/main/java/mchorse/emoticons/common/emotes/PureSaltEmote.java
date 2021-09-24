package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
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
            BOBJBone bOBJBone = bOBJArmature.bones.get("low_right_arm.end");
            Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJBone, 0.0f, 0.15f, 0.0f, f);
            int n3 = n2 = n == 78 ? 12 : 1;
            for (int i = 0; i < n2; ++i) {
                EntityFXBridge entityFXBridge = Bridge.lllIIIIIlllIIlIllIIlIIIlI().initSaltParticle(entityLivingBaseBridge.bridge$getWorld(), vector4f.x, vector4f.y, vector4f.z, 0.0);
                Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getEffectRenderer().bridge$addEffect(entityFXBridge);
            }
        }
    }
}


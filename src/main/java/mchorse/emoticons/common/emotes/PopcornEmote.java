package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;

public class PopcornEmote extends Emote {
    public PopcornEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        if (n == 8 || n == 32 || n == 56 || n == 86) {
            BOBJBone bOBJBone = bOBJArmature.bones.get("low_right_arm.end");
            Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJBone, 0.0f, 0.15f, 0.0f, f);
            int n2 = 15;
            for (int i = 0; i < n2; ++i) {
                EntityFXBridge entityFXBridge = Bridge.lllIIIIIlllIIlIllIIlIIIlI().initPopcornParticle(entityLivingBaseBridge.bridge$getWorld(), vector4f.x, vector4f.y, vector4f.z, 0.1);
                Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getEffectRenderer().bridge$addEffect(entityFXBridge);
            }
        }
    }

    @Override
    public void startAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
        animatorEmoticonsController.userConfig.meshes.get("popcorn").visible = true;
    }

    @Override
    public void stopAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
        animatorEmoticonsController.userConfig.meshes.get("popcorn").visible = false;
    }
}


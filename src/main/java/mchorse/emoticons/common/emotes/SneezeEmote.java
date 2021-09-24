package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
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
                Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, bOBJArmature.bones.get("head"), 0.0f, 0.125f, 0.25f, f);
                entityLivingBaseBridge.bridge$getWorld().bridge$spawnParticle(ParticleType.lIIlIIIIIIlIIlIIllIlIIlII, vector4f.x, vector4f.y, vector4f.z, this.rand(0.05f), -0.025f, this.rand(0.05f));
            }
        }
    }
}


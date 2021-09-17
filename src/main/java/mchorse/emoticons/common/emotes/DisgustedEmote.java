/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Vector4f
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.a.Bridge
 *  lunar.af.ParticleType
 */
package mchorse.emoticons.common.emotes;

import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import com.moonsworth.lunar.client.bridge.Bridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.mclib.utils.Time;

public class DisgustedEmote
extends Emote {
    public DisgustedEmote(String string, int n, boolean bl) {
        super(string, n, bl);
    }

    @Override
    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
        super.progressAnimation(entityLivingBaseBridge, bOBJArmature, animatorEmoticonsController, n, f);
        int n2 = Bridge.llIlIIIllIIlIllIllIllllIl().bridge$getItemID(Bridge.llIlIIIllIIlIllIllIllllIl().bridge$green_dye());
        if (n >= Time.toTicks(117) && n < Time.toTicks(140)) {
            for (int i = 0; i < 10; ++i) {
                Vector4f vector4f = animatorEmoticonsController.calcPosition(entityLivingBaseBridge, (BOBJBone)bOBJArmature.bones.get("head"), 0.0f, 0.125f, 0.25f, f);
                entityLivingBaseBridge.bridge$getWorld().bridge$spawnParticle(ParticleType.IIIlIIIIIIllIIIIllIIIIlII, (double)(vector4f.x + this.rand(0.1f)), (double)vector4f.y, (double)(vector4f.z + this.rand(0.1f)), (double)this.rand(0.05f), -0.125, (double)this.rand(0.05f), new int[]{n2, 2});
            }
        }
    }
}


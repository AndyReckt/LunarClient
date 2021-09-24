package mchorse.emoticons.common.emotes;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

public class Emote {
    public final String name;
    public int duration;
    public boolean looping;

    public Emote(String string, int n, boolean bl) {
        this.name = string;
        this.duration = n;
        this.looping = bl;
    }

    public boolean stopOnMove() {
        return false;
    }

    public boolean renderCape() {
        return true;
    }

    public final boolean limitsLoops() {
        return this.loops() > 0;
    }

    public int loops() {
        return -1;
    }

    public void progressAnimation(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, AnimatorEmoticonsController animatorEmoticonsController, int n, float f) {
    }

    public void startAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
    }

    public void stopAnimation(AnimatorEmoticonsController animatorEmoticonsController) {
    }

    public Emote getDynamicEmote() {
        return this;
    }

    public Emote getDynamicEmote(String string) {
        return this;
    }

    public String getKey() {
        return this.name;
    }

    public float rand(float f) {
        return LunarClient.RANDOM.nextFloat() * f - f / 2.0f;
    }
}


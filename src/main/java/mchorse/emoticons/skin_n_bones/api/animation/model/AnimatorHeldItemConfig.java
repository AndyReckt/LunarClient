/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import mchorse.mclib.utils.Interpolation;

public class AnimatorHeldItemConfig {
    public String boneName = "";
    public float x;
    public float y;
    public float z;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float scaleZ = 1.0f;
    public float rotateX;
    public float rotateY;
    public float rotateZ;

    public AnimatorHeldItemConfig(String string) {
        this.boneName = string;
    }

    public void interpolate(AnimatorHeldItemConfig animatorHeldItemConfig, AnimatorHeldItemConfig animatorHeldItemConfig2, float f, Interpolation interpolation) {
        this.x = interpolation.interpolate(animatorHeldItemConfig.x, animatorHeldItemConfig2.x, f);
        this.y = interpolation.interpolate(animatorHeldItemConfig.y, animatorHeldItemConfig2.y, f);
        this.z = interpolation.interpolate(animatorHeldItemConfig.z, animatorHeldItemConfig2.z, f);
        this.scaleX = interpolation.interpolate(animatorHeldItemConfig.scaleX, animatorHeldItemConfig2.scaleX, f);
        this.scaleY = interpolation.interpolate(animatorHeldItemConfig.scaleY, animatorHeldItemConfig2.scaleY, f);
        this.scaleZ = interpolation.interpolate(animatorHeldItemConfig.scaleZ, animatorHeldItemConfig2.scaleZ, f);
        this.rotateX = interpolation.interpolate(animatorHeldItemConfig.rotateX, animatorHeldItemConfig2.rotateX, f);
        this.rotateY = interpolation.interpolate(animatorHeldItemConfig.rotateY, animatorHeldItemConfig2.rotateY, f);
        this.rotateZ = interpolation.interpolate(animatorHeldItemConfig.rotateZ, animatorHeldItemConfig2.rotateZ, f);
    }

    public AnimatorHeldItemConfig clone() {
        AnimatorHeldItemConfig animatorHeldItemConfig = new AnimatorHeldItemConfig(this.boneName);
        animatorHeldItemConfig.x = this.x;
        animatorHeldItemConfig.y = this.y;
        animatorHeldItemConfig.z = this.z;
        animatorHeldItemConfig.scaleX = this.scaleX;
        animatorHeldItemConfig.scaleY = this.scaleY;
        animatorHeldItemConfig.scaleZ = this.scaleZ;
        animatorHeldItemConfig.rotateX = this.rotateX;
        animatorHeldItemConfig.rotateY = this.rotateY;
        animatorHeldItemConfig.rotateZ = this.rotateZ;
        return animatorHeldItemConfig;
    }

    public boolean equals(Object object) {
        if (object instanceof AnimatorHeldItemConfig) {
            AnimatorHeldItemConfig animatorHeldItemConfig = (AnimatorHeldItemConfig)object;
            boolean bl = animatorHeldItemConfig.x == this.x && animatorHeldItemConfig.y == this.y && animatorHeldItemConfig.z == this.z;
            bl = bl && animatorHeldItemConfig.scaleX == this.scaleX && animatorHeldItemConfig.scaleY == this.scaleY && animatorHeldItemConfig.scaleZ == this.scaleZ;
            bl = bl && animatorHeldItemConfig.rotateX == this.rotateX && animatorHeldItemConfig.rotateY == this.rotateY && animatorHeldItemConfig.rotateZ == this.rotateZ;
            return bl;
        }
        return super.equals(object);
    }
}


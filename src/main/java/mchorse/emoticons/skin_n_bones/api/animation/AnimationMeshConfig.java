/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  lunar.af.ResourceLocationBridge
 */
package mchorse.emoticons.skin_n_bones.api.animation;

import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;

public class AnimationMeshConfig {
    public ResourceLocationBridge texture;
    public int filtering = 9728;
    public boolean normals = false;
    public boolean smooth = false;
    public boolean visible = true;
    public boolean lighting = true;
    public int color = 10511680;

    public AnimationMeshConfig clone() {
        AnimationMeshConfig animationMeshConfig = new AnimationMeshConfig();
        animationMeshConfig.texture = this.texture;
        animationMeshConfig.filtering = this.filtering;
        animationMeshConfig.normals = this.normals;
        animationMeshConfig.smooth = this.smooth;
        animationMeshConfig.visible = this.visible;
        animationMeshConfig.lighting = this.lighting;
        animationMeshConfig.color = this.color;
        return animationMeshConfig;
    }
}


/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorActionsConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorHeldItemConfig;

public class AnimatorConfig {
    public String name = "";
    public String primaryMesh = "";
    public float scale = 1.0f;
    public float scaleGui = 1.0f;
    public float scaleItems = 1.0f;
    public boolean renderHeldItems = true;
    public Map<Integer, AnimatorHeldItemConfig> leftHands = new HashMap();
    public Map<Integer, AnimatorHeldItemConfig> rightHands = new HashMap();
    public String head = "head";
    public AnimatorActionsConfig actions = new AnimatorActionsConfig();
    public Map<Integer, AnimationMeshConfig> meshes = new HashMap();

    public void copy(AnimatorConfig animatorConfig) {
        this.name = animatorConfig.name;
        this.primaryMesh = animatorConfig.primaryMesh;
        this.scale = animatorConfig.scale;
        this.scaleGui = animatorConfig.scaleGui;
        this.scaleItems = animatorConfig.scaleItems;
        this.renderHeldItems = animatorConfig.renderHeldItems;
        this.head = animatorConfig.head;
        this.actions.copy(animatorConfig.actions);
        this.leftHands.clear();
        this.rightHands.clear();
        this.meshes.clear();
        for (Map.Entry<Integer, AnimatorHeldItemConfig> entry : animatorConfig.leftHands.entrySet()) {
            this.leftHands.put(entry.getKey(), entry.getValue().clone());
        }
        for (Map.Entry<Integer, AnimatorHeldItemConfig>  entry : animatorConfig.rightHands.entrySet()) {
            this.rightHands.put(entry.getKey(), entry.getValue().clone());
        }
        for (Map.Entry<Integer, AnimationMeshConfig>  entry : animatorConfig.meshes.entrySet()) {
            this.meshes.put(entry.getKey(), entry.getValue().clone());
        }
    }

    public static class AnimatorConfigEntry {
        public AnimatorConfig config;
        public long lastModified;

        public AnimatorConfigEntry(AnimatorConfig animatorConfig, long l) {
            this.config = animatorConfig;
            this.lastModified = l;
        }
    }
}


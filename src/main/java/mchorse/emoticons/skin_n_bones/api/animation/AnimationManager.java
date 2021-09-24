/*
 * Decompiled with CFR 0.150.
 *
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 */
package mchorse.emoticons.skin_n_bones.api.animation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mchorse.emoticons.skin_n_bones.api.animation.Animation;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMeshConfig;
import mchorse.emoticons.skin_n_bones.api.animation.json.ActionConfigAdapter;
import mchorse.emoticons.skin_n_bones.api.animation.json.AnimationMeshConfigAdapter;
import mchorse.emoticons.skin_n_bones.api.animation.json.AnimatorActionsConfigAdapter;
import mchorse.emoticons.skin_n_bones.api.animation.json.AnimatorConfigAdapter;
import mchorse.emoticons.skin_n_bones.api.animation.json.AnimatorHeldItemConfigAdapter;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorActionsConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorHeldItemConfig;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJLoader;

public class AnimationManager {
    public Map animations = new HashMap();
    public Map configs = new HashMap();
    public AnimatorConfig.AnimatorConfigEntry defaultConfig = new AnimatorConfig.AnimatorConfigEntry(new AnimatorConfig(), 0L);
    public Gson gson;
    public static final AnimationManager INSTANCE = new AnimationManager();

    public AnimationManager() {
        this.defaultConfig.config.rightHands.put("right_hand", new AnimatorHeldItemConfig("right_hand"));
        this.defaultConfig.config.leftHands.put("left_hand", new AnimatorHeldItemConfig("left_hand"));
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(AnimationMeshConfig.class, new AnimationMeshConfigAdapter());
        gsonBuilder.registerTypeAdapter(AnimatorConfig.class, new AnimatorConfigAdapter());
        gsonBuilder.registerTypeAdapter(AnimatorActionsConfig.class, new AnimatorActionsConfigAdapter());
        gsonBuilder.registerTypeAdapter(AnimatorHeldItemConfig.class, new AnimatorHeldItemConfigAdapter());
        gsonBuilder.registerTypeAdapter(ActionConfig.class, new ActionConfigAdapter());
        this.gson = gsonBuilder.create();
    }

    public Animation getAnimation(String string) {
        AnimationEntry animationEntry = (AnimationEntry)this.animations.get(string);
        return animationEntry == null ? null : animationEntry.animation;
    }

    public AnimatorConfig.AnimatorConfigEntry getConfig(String string) {
        AnimatorConfig.AnimatorConfigEntry animatorConfigEntry = (AnimatorConfig.AnimatorConfigEntry)this.configs.get(string);
        return animatorConfigEntry == null ? this.defaultConfig : animatorConfigEntry;
    }

    public static class AnimationEntry {
        public Animation animation;
        public File directory;
        public long lastModified;

        public AnimationEntry(Animation animation, File file, long l) {
            this.animation = animation;
            this.directory = file;
            this.lastModified = l;
        }

        public void reloadAnimation(BOBJLoader.BOBJData bOBJData, long l) {
            this.animation.reload(bOBJData);
            this.lastModified = l;
        }
    }
}


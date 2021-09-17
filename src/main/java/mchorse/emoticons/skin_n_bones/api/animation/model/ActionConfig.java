/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

public class ActionConfig {
    public String name = "";
    public boolean clamp = true;
    public boolean reset = true;
    public float speed = 1.0f;
    public float fade = 5.0f;
    public int tick = 0;

    public ActionConfig() {
    }

    public ActionConfig(String string) {
        this.name = string;
    }

    public ActionConfig clone() {
        ActionConfig actionConfig = new ActionConfig(this.name);
        actionConfig.clamp = this.clamp;
        actionConfig.reset = this.reset;
        actionConfig.speed = this.speed;
        actionConfig.fade = this.fade;
        actionConfig.tick = this.tick;
        return actionConfig;
    }

    public boolean isDefault() {
        return this.clamp && this.reset && this.speed == 1.0f && this.fade == 5.0f && this.tick == 0;
    }
}


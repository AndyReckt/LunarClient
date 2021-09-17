/*
 * Decompiled with CFR 0.150.
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJAction;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJGroup;

public class ActionPlayback {
    public BOBJAction action;
    public ActionConfig config;
    public int fade;
    public float ticks;
    public int duration;
    public float speed = 1.0f;
    public boolean looping = false;
    public boolean fading = false;
    public boolean playing = true;
    public int priority;

    public ActionPlayback(BOBJAction bOBJAction, ActionConfig actionConfig) {
        this(bOBJAction, actionConfig, true);
    }

    public ActionPlayback(BOBJAction bOBJAction, ActionConfig actionConfig, boolean bl) {
        this.action = bOBJAction;
        this.config = actionConfig;
        this.duration = bOBJAction.getDuration();
        this.looping = bl;
        this.setSpeed(1.0f);
    }

    public ActionPlayback(BOBJAction bOBJAction, ActionConfig actionConfig, boolean bl, int n) {
        this(bOBJAction, actionConfig, bl);
        this.priority = n;
    }

    public void reset() {
        if (this.config.reset) {
            this.ticks = Math.copySign(1.0f, this.speed) < 0.0f ? (float)this.duration : 0.0f;
        }
        this.unfade();
    }

    public boolean finishedFading() {
        return this.fading && this.fade <= 0;
    }

    public boolean isFading() {
        return this.fading && this.fade > 0;
    }

    public void fade() {
        this.fade = (int)this.config.fade;
        this.fading = true;
    }

    public void unfade() {
        this.fade = 0;
        this.fading = false;
    }

    public float getFadeFactor(float f) {
        return ((float)this.fade - f) / this.config.fade;
    }

    public void setSpeed(float f) {
        this.speed = f * this.config.speed;
    }

    public void update() {
        if (this.fading && this.fade > 0) {
            --this.fade;
            return;
        }
        if (!this.playing) {
            return;
        }
        this.ticks += this.speed;
        if (!this.looping && !this.fading && this.ticks >= (float)this.duration) {
            this.fade();
        }
        if (this.looping) {
            if (this.ticks >= (float)this.duration && this.speed > 0.0f && this.config.clamp) {
                this.ticks -= (float)this.duration;
                this.ticks += (float)this.config.tick;
            } else if (this.ticks < 0.0f && this.speed < 0.0f && this.config.clamp) {
                this.ticks = (float)this.duration + this.ticks;
                this.ticks -= (float)this.config.tick;
            }
        }
    }

    public float getTick(float f) {
        float f2 = this.ticks + f * this.speed;
        if (this.looping) {
            if (f2 >= (float)this.duration && this.speed > 0.0f && this.config.clamp) {
                f2 -= (float)this.duration;
            } else if (this.ticks < 0.0f && this.speed < 0.0f && this.config.clamp) {
                f2 = (float)this.duration + f2;
            }
        }
        return f2;
    }

    public void apply(BOBJArmature bOBJArmature, float f) {
        for (BOBJGroup bOBJGroup : this.action.groups.values()) {
            BOBJBone bOBJBone = (BOBJBone)bOBJArmature.bones.get(bOBJGroup.name);
            if (bOBJBone == null) continue;
            bOBJGroup.apply(bOBJBone, this.getTick(f));
        }
    }

    public void applyInactive(BOBJArmature bOBJArmature, float f, float f2) {
        for (BOBJGroup bOBJGroup : this.action.groups.values()) {
            BOBJBone bOBJBone = (BOBJBone)bOBJArmature.bones.get(bOBJGroup.name);
            if (bOBJBone == null) continue;
            bOBJGroup.applyInterpolate(bOBJBone, this.ticks, f2);
        }
    }
}


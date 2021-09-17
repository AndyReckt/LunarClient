/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  lunar.G.EntityBridge
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.L.EntityPlayerBridge
 *  lunar.Q.ItemStackBridge
 *  lunar.Q.ItemStackBridge$lIlIlIlIlIIlIIlIIllIIIIIl
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import mchorse.emoticons.skin_n_bones.api.animation.Animation;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionPlayback;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorActionsConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorController;
import mchorse.emoticons.skin_n_bones.api.animation.model.IAnimator;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

public class Animator
implements IAnimator {
    public ActionPlayback idle;
    public ActionPlayback walking;
    public ActionPlayback running;
    public ActionPlayback sprinting;
    public ActionPlayback crouching;
    public ActionPlayback crouchingIdle;
    public ActionPlayback swimming;
    public ActionPlayback swimmingIdle;
    public ActionPlayback flying;
    public ActionPlayback flyingIdle;
    public ActionPlayback riding;
    public ActionPlayback ridingIdle;
    public ActionPlayback dying;
    public ActionPlayback falling;
    public ActionPlayback sleeping;
    public ActionPlayback jump;
    public ActionPlayback swipe;
    public ActionPlayback hurt;
    public ActionPlayback land;
    public ActionPlayback shoot;
    public ActionPlayback consume;
    public ActionPlayback emote;
    public ActionPlayback active;
    public ActionPlayback lastActive;
    public List<ActionPlayback> actions = new ArrayList<>();
    public double prevX = 3.4028234663852886E38;
    public double prevZ = 3.4028234663852886E38;
    public double prevMY;
    public boolean wasOnGround = true;
    public boolean wasShooting = false;
    public boolean wasConsuming = false;
    public AnimatorController controller;

    public Animator(AnimatorController animatorController) {
        this.controller = animatorController;
        this.refresh();
    }

    @Override
    public void refresh() {
        AnimatorActionsConfig animatorActionsConfig = this.controller.userConfig.actions;
        Animation animation = this.controller.animation;
        this.idle = animation.createAction(this.idle, animatorActionsConfig.getConfig("idle"), true);
        this.walking = animation.createAction(this.walking, animatorActionsConfig.getConfig("walking"), true);
        this.running = animation.createAction(this.running, animatorActionsConfig.getConfig("running"), true);
        this.sprinting = animation.createAction(this.sprinting, animatorActionsConfig.getConfig("sprinting"), true);
        this.crouching = animation.createAction(this.crouching, animatorActionsConfig.getConfig("crouching"), true);
        this.crouchingIdle = animation.createAction(this.crouchingIdle, animatorActionsConfig.getConfig("crouching_idle"), true);
        this.swimming = animation.createAction(this.swimming, animatorActionsConfig.getConfig("swimming"), true);
        this.swimmingIdle = animation.createAction(this.swimmingIdle, animatorActionsConfig.getConfig("swimming_idle"), true);
        this.flying = animation.createAction(this.flying, animatorActionsConfig.getConfig("flying"), true);
        this.flyingIdle = animation.createAction(this.flyingIdle, animatorActionsConfig.getConfig("flying_idle"), true);
        this.riding = animation.createAction(this.riding, animatorActionsConfig.getConfig("riding"), true);
        this.ridingIdle = animation.createAction(this.ridingIdle, animatorActionsConfig.getConfig("riding_idle"), true);
        this.dying = animation.createAction(this.dying, animatorActionsConfig.getConfig("dying"), false);
        this.falling = animation.createAction(this.falling, animatorActionsConfig.getConfig("falling"), true);
        this.sleeping = animation.createAction(this.sleeping, animatorActionsConfig.getConfig("sleeping"), true);
        this.swipe = animation.createAction(this.swipe, animatorActionsConfig.getConfig("swipe"), false);
        this.jump = animation.createAction(this.jump, animatorActionsConfig.getConfig("jump"), false, 2);
        this.hurt = animation.createAction(this.hurt, animatorActionsConfig.getConfig("hurt"), false, 3);
        this.land = animation.createAction(this.land, animatorActionsConfig.getConfig("land"), false);
        this.shoot = animation.createAction(this.shoot, animatorActionsConfig.getConfig("shoot"), true);
        this.consume = animation.createAction(this.consume, animatorActionsConfig.getConfig("consume"), true);
    }

    @Override
    public void setEmote(ActionPlayback actionPlayback) {
        if (actionPlayback != null) {
            this.emote = actionPlayback;
        } else if (this.emote != null) {
            this.emote = null;
        }
    }

    @Override
    public void update(EntityLivingBaseBridge entityLivingBaseBridge) {
        if (this.prevX == 3.4028234663852886E38) {
            this.prevX = entityLivingBaseBridge.bridge$getPosX();
            this.prevZ = entityLivingBaseBridge.bridge$getPosZ();
        }
        this.controlActions(entityLivingBaseBridge);
        if (this.active != null) {
            this.active.update();
        }
        if (this.lastActive != null) {
            this.lastActive.update();
        }
        Iterator iterator = this.actions.iterator();
        while (iterator.hasNext()) {
            ActionPlayback actionPlayback = (ActionPlayback)iterator.next();
            actionPlayback.update();
            if (!actionPlayback.finishedFading()) continue;
            actionPlayback.unfade();
            iterator.remove();
        }
    }

    public void controlActions(EntityLivingBaseBridge entityLivingBaseBridge) {
        boolean bl;
        if (!(entityLivingBaseBridge instanceof EntityPlayerBridge)) {
            return;
        }
        EntityPlayerBridge entityPlayerBridge = (EntityPlayerBridge)entityLivingBaseBridge;
        double d = entityLivingBaseBridge.bridge$getPosX() - this.prevX;
        double d2 = entityLivingBaseBridge.bridge$getPosZ() - this.prevZ;
        boolean bl2 = entityPlayerBridge.bridge$getPlayerCapabilities().bridge$isFlying();
        boolean bl3 = entityLivingBaseBridge.bridge$isInWater();
        float f = bl2 ? 0.1f : (bl3 ? 0.025f : 0.01f);
        boolean bl4 = bl = Math.abs(d) > (double)f || Math.abs(d2) > (double)f;
        if (this.emote != null) {
            this.setActiveAction(this.emote);
        } else if (entityLivingBaseBridge.bridge$getHealth() <= 0.0f) {
            this.setActiveAction(this.dying);
        } else if (entityLivingBaseBridge.bridge$isPlayerSleeping()) {
            this.setActiveAction(this.sleeping);
        } else if (bl3) {
            this.setActiveAction(!bl ? this.swimmingIdle : this.swimming);
        } else if (entityLivingBaseBridge.bridge$isRiding()) {
            EntityBridge entityBridge = entityLivingBaseBridge.bridge$getRidingEntity();
            bl = Math.abs(entityBridge.bridge$getPosX() - this.prevX) > (double)f || Math.abs(entityBridge.bridge$getPosZ() - this.prevZ) > (double)f;
            this.prevX = entityBridge.bridge$getPosX();
            this.prevZ = entityBridge.bridge$getPosZ();
            this.setActiveAction(!bl ? this.ridingIdle : this.riding);
        } else if (bl2) {
            this.setActiveAction(!bl ? this.flyingIdle : this.flying);
        } else {
            float f2 = (float)((double)Math.round(Math.sqrt(d * d + d2 * d2) * 1000.0) / 1000.0);
            if (entityLivingBaseBridge.bridge$isSneaking()) {
                f2 /= 0.065f;
                this.setActiveAction(!bl ? this.crouchingIdle : this.crouching);
                if (this.crouching != null) {
                    this.crouching.setSpeed(entityLivingBaseBridge.bridge$getMoveForward() > 0.0f ? f2 : -f2);
                }
            } else if (!entityLivingBaseBridge.bridge$isOnGround() && entityLivingBaseBridge.bridge$getMotionY() < 0.0 && (double)entityLivingBaseBridge.bridge$getFallDistance() > 1.25) {
                this.setActiveAction(this.falling);
            } else if (entityPlayerBridge.bridge$isSprinting() && this.sprinting != null) {
                this.setActiveAction(this.sprinting);
                this.sprinting.setSpeed(f2 / 0.281f);
            } else {
                this.setActiveAction(!bl ? this.idle : this.running);
                f2 /= 0.216f;
                if (this.running != null) {
                    this.running.setSpeed(entityLivingBaseBridge.bridge$getMoveForward() >= 0.0f ? f2 : -f2);
                }
                if (this.walking != null) {
                    this.walking.setSpeed(entityLivingBaseBridge.bridge$getMoveForward() > 0.0f ? f2 : -f2);
                }
            }
            if (!entityLivingBaseBridge.bridge$isOnGround() || this.wasOnGround || entityPlayerBridge.bridge$isSprinting() || this.prevMY < -0.5) {
                // empty if block
            }
        }
        if (!entityLivingBaseBridge.bridge$isOnGround() && this.wasOnGround && Math.abs(entityLivingBaseBridge.bridge$getMotionY()) > (double)0.2f) {
            this.wasOnGround = false;
        }
        boolean bl5 = this.wasShooting;
        boolean bl6 = this.wasConsuming;
        ItemStackBridge itemStackBridge = entityPlayerBridge.bridge$getHeldItem();
        if (itemStackBridge != null && !itemStackBridge.bridge$isEmpty()) {
            if (((EntityPlayerBridge)entityLivingBaseBridge).bridge$getItemInUseCount() > 0) {
                ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2 = itemStackBridge.bridge$getItemUseAction();
                if (lIlIlIlIlIIlIIlIIllIIIIIl2 == ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI) {
                    if (!this.actions.contains(this.shoot)) {
                        this.addAction(this.shoot);
                    }
                    this.wasShooting = true;
                } else if (lIlIlIlIlIIlIIlIIllIIIIIl2 == ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll || lIlIlIlIlIIlIIlIIllIIIIIl2 == ItemStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl) {
                    if (!this.actions.contains(this.consume)) {
                        this.addAction(this.consume);
                    }
                    this.wasConsuming = true;
                }
            } else {
                this.wasShooting = false;
                this.wasConsuming = false;
            }
        } else {
            this.wasShooting = false;
            this.wasConsuming = false;
        }
        if (bl5 && !this.wasShooting && this.shoot != null) {
            this.shoot.fade();
        }
        if (bl6 && !this.wasConsuming && this.consume != null) {
            this.consume.fade();
        }
        this.prevX = entityLivingBaseBridge.bridge$getPosX();
        this.prevZ = entityLivingBaseBridge.bridge$getPosZ();
        this.prevMY = entityLivingBaseBridge.bridge$getMotionY();
        this.wasOnGround = entityLivingBaseBridge.bridge$isOnGround();
    }

    public void setActiveAction(ActionPlayback actionPlayback) {
        if (this.active == actionPlayback || actionPlayback == null) {
            return;
        }
        if (this.active != null && actionPlayback.priority < this.active.priority) {
            return;
        }
        if (this.active != null) {
            this.lastActive = this.active;
            this.lastActive.fade();
        }
        this.active = actionPlayback;
        this.active.reset();
    }

    public void addAction(ActionPlayback actionPlayback) {
        if (actionPlayback == null) {
            return;
        }
        if (this.actions.contains(actionPlayback)) {
            actionPlayback.reset();
            return;
        }
        actionPlayback.reset();
        this.actions.add(actionPlayback);
    }

    @Override
    public void applyActions(BOBJArmature bOBJArmature, float f) {
        if (this.active != null) {
            this.active.apply(bOBJArmature, f);
        }
        if (this.lastActive != null && this.lastActive.isFading()) {
            this.lastActive.applyInactive(bOBJArmature, f, 1.0f - this.lastActive.getFadeFactor(f));
        }
        for (ActionPlayback actionPlayback : this.actions) {
            if (actionPlayback.isFading()) {
                actionPlayback.applyInactive(bOBJArmature, f, 1.0f - actionPlayback.getFadeFactor(f));
                continue;
            }
            actionPlayback.apply(bOBJArmature, f);
        }
    }
}


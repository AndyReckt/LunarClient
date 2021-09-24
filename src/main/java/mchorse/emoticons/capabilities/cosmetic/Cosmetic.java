package mchorse.emoticons.capabilities.cosmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityPlayerSPBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.UnknownRenderEntityBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.cosmetic.de.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.client.ref.Ref;
import mchorse.emoticons.api.animation.model.AnimatorEmoticonsController;
import mchorse.emoticons.common.emotes.Emote;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionPlayback;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;

public class Cosmetic implements ICosmetic {
    public AnimatorEmoticonsController animator;
    public ActionPlayback emoteAction;
    public Emote emote;
    public ICosmetic.CosmeticMode mode = ICosmetic.CosmeticMode.CLIENT;
    public int emoteTimer;
    public double lastX;
    public double lastY;
    public double lastZ;
    public static final Map<UUID, ICosmetic> cache = new HashMap<>();

    public static ICosmetic get(EntityBridge entityBridge) {
        return Cosmetic.get(entityBridge.bridge$getUniqueID());
    }

    public static ICosmetic get(UUID uUID2) {
        return cache.computeIfAbsent(uUID2, uUID -> new Cosmetic());
    }

    public static void postUpdate(EntityPlayerBridge entityPlayerBridge) {
        if (!cache.containsKey(entityPlayerBridge.bridge$getUniqueID())) {
            return;
        }
        cache.get(entityPlayerBridge.bridge$getUniqueID()).update(entityPlayerBridge);
    }

    @Override
    public ICosmetic.CosmeticMode getMode() {
        return this.mode;
    }

    @Override
    public void setMode(ICosmetic.CosmeticMode cosmeticMode) {
        this.mode = cosmeticMode;
    }

    @Override
    public void setEmote(Emote emote, EntityLivingBaseBridge entityLivingBaseBridge) {
        if (entityLivingBaseBridge.bridge$getWorld().bridge$isRemote()) {
            this.stopAction(entityLivingBaseBridge);
        }
        if (entityLivingBaseBridge.bridge$isSneaking() || entityLivingBaseBridge.bridge$isRiding() || entityLivingBaseBridge.IlllIIIIIIlllIlIIlllIlIIl() || entityLivingBaseBridge.lIllIlIIIlIIIIIIIlllIlIll()) {
            this.stopAction(entityLivingBaseBridge);
            return;
        }
        this.emote = emote;
        this.emoteTimer = 0;
        if (entityLivingBaseBridge.bridge$getWorld().bridge$isRemote()) {
            this.setActionEmote(emote, entityLivingBaseBridge);
        }
    }

    @Override
    public Emote getEmote() {
        return this.emote;
    }

    @Override
    public void update(EntityLivingBaseBridge entityLivingBaseBridge) {
        if (entityLivingBaseBridge.bridge$getWorld().bridge$isRemote()) {
            this.updateClient(entityLivingBaseBridge);
        } else {
            if (this.emote != null) {
                double d;
                boolean bl = (this.emote.stopOnMove() || entityLivingBaseBridge.bridge$isRiding() || entityLivingBaseBridge.lIllIlIIIlIIIIIIIlllIlIll() || entityLivingBaseBridge.IlllIIIIIIlllIlIIlllIlIIl()) && (d = Math.abs(entityLivingBaseBridge.bridge$getPosX() - this.lastX + (entityLivingBaseBridge.bridge$getPosY() - this.lastY) + (entityLivingBaseBridge.bridge$getPosZ() - this.lastZ))) > 0.015;
                if (((EntityPlayerBridge)entityLivingBaseBridge).bridge$isUsingItem()) {
                    bl = true;
                }
                if (entityLivingBaseBridge.bridge$isSneaking()) {
                    bl = true;
                }
                if (bl || this.emote.limitsLoops() && this.loopsDone() > this.emote.loops() || !this.emote.looping && this.emoteTimer >= this.emote.duration) {
                    Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityLivingBaseBridge, false);
                }
            }
            this.lastX = entityLivingBaseBridge.bridge$getPosX();
            this.lastY = entityLivingBaseBridge.bridge$getPosY();
            this.lastZ = entityLivingBaseBridge.bridge$getPosZ();
        }
    }

    public int loopsDone() {
        if (this.emoteTimer < this.emote.duration) {
            return 0;
        }
        return (int)Math.floor((double)this.emoteTimer / (double)this.emote.duration);
    }

    public void updateClient(EntityLivingBaseBridge entityLivingBaseBridge) {
        if (this.mode != ICosmetic.CosmeticMode.SERVER) {
            if (this.emote != null) {
                double d;
                boolean bl = (this.emote.stopOnMove() || entityLivingBaseBridge.bridge$isRiding() || entityLivingBaseBridge.lIllIlIIIlIIIIIIIlllIlIll() || entityLivingBaseBridge.IlllIIIIIIlllIlIIlllIlIIl()) && (d = Math.abs(entityLivingBaseBridge.bridge$getPosX() - this.lastX + (entityLivingBaseBridge.bridge$getPosY() - this.lastY) + (entityLivingBaseBridge.bridge$getPosZ() - this.lastZ))) > 0.015;
                if (((EntityPlayerBridge)entityLivingBaseBridge).bridge$isUsingItem()) {
                    bl = true;
                }
                if (entityLivingBaseBridge.bridge$isSneaking()) {
                    bl = true;
                }
                if (bl || this.emote.limitsLoops() && this.loopsDone() > this.emote.loops() || !this.emote.looping && this.emoteTimer >= this.emote.duration) {
                    Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityLivingBaseBridge, false);
                }
            }
            this.lastX = entityLivingBaseBridge.bridge$getPosX();
            this.lastY = entityLivingBaseBridge.bridge$getPosY();
            this.lastZ = entityLivingBaseBridge.bridge$getPosZ();
        }
        if (this.emote != null && this.emoteAction != null) {
            ++this.emoteTimer;
        }
        if (this.animator != null) {
            this.animator.update(entityLivingBaseBridge);
        }
    }

    public void stopAction(EntityLivingBaseBridge entityLivingBaseBridge) {
        if (this.emote != null) {
            this.emote.stopAnimation(this.animator);
            this.emote = null;
            Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityLivingBaseBridge, false, false);
        }
    }

    public void setActionEmote(Emote emote, EntityLivingBaseBridge entityLivingBaseBridge) {
        if (this.animator == null) {
            this.setupAnimator(entityLivingBaseBridge);
        }
        if (emote != null) {
            ActionConfig actionConfig = this.animator.config.config.actions.getConfig("emote_" + emote.name);
            if (emote.name.equals("gun_lean")) {
                actionConfig.tick = 8;
            }
            this.emoteAction = this.animator.animation.createAction(null, actionConfig, emote.looping);
            this.animator.setEmote(this.emoteAction);
            emote.startAnimation(this.animator);
        } else {
            this.emoteAction = null;
            this.animator.setEmote(null);
        }
    }

    @Override
    public boolean shouldRender(EntityLivingBaseBridge entityLivingBaseBridge) {
        return this.animator != null && this.emote != null && Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityPlayerBridge)entityLivingBaseBridge);
    }

    @Override
    public boolean render(EntityLivingBaseBridge entityLivingBaseBridge, double d, double d2, double d3, float f) {
        boolean bl;
        if (this.animator == null) {
            this.setupAnimator(entityLivingBaseBridge);
        }
        if (bl = this.shouldRender(entityLivingBaseBridge)) {
            String string;
            AbstractClientPlayerBridge object;
            if (entityLivingBaseBridge instanceof AbstractClientPlayerBridge) {
                object = (AbstractClientPlayerBridge)entityLivingBaseBridge;
                string = object.bridge$getSkinType() + "";
                if (!string.equals(this.animator.animationName)) {
                    this.animator.animationName = string;
                    this.animator.animation = null;
                    this.animator.fetchAnimation();
                }
                this.animator.userConfig.meshes.get("body").texture = object.bridge$getLocationSkin();
            }
            this.animator.render(entityLivingBaseBridge, d, d2, d3, 0.0f, f);
            BOBJArmature armature = this.animator.animation.meshes.get(0).armature;
            MinecraftBridge mc = Bridge.llllIIlIIlIIlIIllIIlIIllI();
            UnknownRenderEntityBridge rendererLivingEntityBridge = Bridge.lllllIllIlIIlIIlIIIlllIlI();
            if (rendererLivingEntityBridge.bridge$canRenderName(entityLivingBaseBridge)) {
                RenderManagerBridge renderManagerBridge = mc.bridge$getRenderManager();
                Vector4f vector4f = this.animator.calcPosition(entityLivingBaseBridge, (armature).bones.get("head"), 0.0f, 0.0f, 0.0f, f);
                float f2 = vector4f.x - (float)renderManagerBridge.bridge$viewerPosX();
                float f3 = vector4f.y - (float)renderManagerBridge.bridge$viewerPosY() + 0.7f;
                float f4 = vector4f.z - (float)renderManagerBridge.bridge$viewerPosZ();
                if (Ref.getLC().lIIlIIIIIIlIIlIIllIlIIlII().IlllllIlIIIlIIlIIllIIlIll().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().containsKey(entityLivingBaseBridge.bridge$getUniqueID())) {
                    Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawNameplates(Ref.getFontRenderer(), Ref.getLC().llIIIlIllIIIIlIIIlIlIllIl().llIlllIIIllllIIlllIllIIIl().get(entityLivingBaseBridge.bridge$getUniqueID()), f2, f3, f4, -0.3f, false, true, entityLivingBaseBridge);
                } else {
                    Bridge.IlllllIlIIIlIIlIIllIIlIll().bridge$drawNameplate(Ref.getFontRenderer(), entityLivingBaseBridge.bridge$getDisplayName(), f2, f3, f4, -0.3f, false, true, entityLivingBaseBridge);
                }
            }
            if (this.emote != null && !mc.bridge$isGamePaused() && this.emoteAction != null) {
                int n = (int)this.emoteAction.getTick(f);
                this.emote.progressAnimation(entityLivingBaseBridge, armature, this.animator, n, f);
            }
        }
        return bl;
    }

    @Override
    public lIllIlIIIlIIIIIIIlllIlIll render(EntityLivingBaseBridge entityLivingBaseBridge, MatrixStackBridge matrixStackBridge, double d, double d2, double d3, float f, int n) {
        if (this.animator == null) {
            this.setupAnimator(entityLivingBaseBridge);
        }
        boolean bl = this.shouldRender(entityLivingBaseBridge);
        lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2 = new lIllIlIIIlIIIIIIIlllIlIll();
        if (bl) {
            String string;
            AbstractClientPlayerBridge object;
            if (entityLivingBaseBridge instanceof AbstractClientPlayerBridge) {
                object = (AbstractClientPlayerBridge)entityLivingBaseBridge;
                string = object.bridge$getSkinType() + "";
                if (!string.equals(this.animator.animationName)) {
                    this.animator.animationName = string;
                    this.animator.animation = null;
                    this.animator.fetchAnimation();
                }
                this.animator.userConfig.meshes.get("body").texture = (object).bridge$getLocationSkin();
            }
            lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl(this.animator.renderModern(entityLivingBaseBridge, lIllIlIIIlIIIIIIIlllIlIll2, matrixStackBridge, d, d2, d3, f, n));
            BOBJArmature armature = this.animator.animation.meshes.get(0).armature;
            MinecraftBridge mc = Bridge.llllIIlIIlIIlIIllIIlIIllI();
            if (this.emote != null && !mc.bridge$isGamePaused() && this.emoteAction != null) {
                int n2 = (int)this.emoteAction.getTick(f);
                this.emote.progressAnimation(entityLivingBaseBridge, armature, this.animator, n2, f);
            }
        }
        return lIllIlIIIlIIIIIIIlllIlIll2;
    }

    public void setupAnimator(EntityLivingBaseBridge entityLivingBaseBridge) {
        if (entityLivingBaseBridge instanceof EntityPlayerSPBridge) {
            this.animator = new AnimatorEmoticonsController(((EntityPlayerSPBridge)entityLivingBaseBridge).bridge$getSkinType());
            this.animator.fetchAnimation();
        }
        if (entityLivingBaseBridge instanceof AbstractClientPlayerBridge) {
            AbstractClientPlayerBridge abstractClientPlayerBridge = (AbstractClientPlayerBridge)entityLivingBaseBridge;
            this.animator = new AnimatorEmoticonsController(abstractClientPlayerBridge.bridge$getSkinType());
            this.animator.fetchAnimation();
        }
    }
}


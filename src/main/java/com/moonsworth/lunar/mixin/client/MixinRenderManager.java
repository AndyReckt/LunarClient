package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.TextureManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.settings.GameSettingsBridge;
import com.moonsworth.lunar.bridge.minecraft.world.WorldBridge;
import com.moonsworth.lunar.client.feature.type.hitbox.HitboxMod;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.ColorSetting;
import com.moonsworth.lunar.client.setting.NumberSetting;
import com.moonsworth.lunar.client.ui.screen.type.mainmenu.cosmetics.base.CosmeticsUIScreenBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(RenderManager.class)
public abstract class MixinRenderManager implements RenderManagerBridge {
    @Shadow
    private double renderPosX;
    @Shadow
    private double renderPosY;
    @Shadow
    private double renderPosZ;
    @Shadow
    public float playerViewY;
    @Shadow
    public float playerViewX;
    @Shadow
    private RenderPlayer playerRenderer;
    @Shadow
    public TextureManager renderEngine;
    @Shadow
    public Entity livingPlayer;
    @Shadow
    public GameSettings options;
    @Shadow
    private boolean renderShadow;
    @Shadow
    public double viewerPosX;
    @Shadow
    public double viewerPosY;
    @Shadow
    public double viewerPosZ;
    @Shadow
    private Map<String, RenderPlayer> skinMap;
    @Shadow
    private boolean debugBoundingBox;

    public Entity lastRenderedEntity;

    @Shadow
    public abstract boolean renderEntityWithPosYaw(Entity var1, double var2, double var4, double var6, float var8, float var9);

    @Shadow
    public abstract void setDebugBoundingBox(boolean var1);

    public double getRenderPosX() {
        return this.renderPosX;
    }

    public double getRenderPosY() {
        return this.renderPosY;
    }

    public double getRenderPosZ() {
        return this.renderPosZ;
    }

    public double getPlayerViewX() {
        return this.playerViewX;
    }

    public double getPlayerViewY() {
        return this.playerViewY;
    }

    public RenderPlayerBridge bridge$defaultPlayerRenderer() {
        return (RenderPlayerBridge) this.playerRenderer;
    }

    public void bridge$setTextureManager(TextureManagerBridge var1) {
        this.renderEngine = (TextureManager) var1;
    }

    public void bridge$setLivingEntity(EntityLivingBaseBridge var1) {
        this.livingPlayer = (EntityLivingBase) var1;
    }

    public void bridge$setOptions(GameSettingsBridge var1) {
        this.options = (GameSettings) var1;
    }

    public void bridge$setRenderShadow(boolean var1) {
        this.renderShadow = var1;
    }

    public void bridge$setPlayerViewY(float var1) {
        this.playerViewY = var1;
    }

    public void bridge$renderEntityWithPosYaw(EntityBridge var1, double n, double n2, double n3, float n4, float n5) {
        this.renderEntityWithPosYaw((Entity) var1, n, n2, n3, n4, n5);
    }

    public Map bridge$getSkinMap() {
        return this.skinMap;
    }

    @Inject(method = "doRenderEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/entity/Render;doRender(Lnet/minecraft/entity/Entity;DDDFF)V", shift = At.Shift.BEFORE))
    public void impl$doRender(CallbackInfoReturnable var1) {
        GlStateManager.enableDepth();
    }

    public double bridge$viewerPosX() {
        return this.viewerPosX;
    }

    public double bridge$viewerPosY() {
        return this.viewerPosY;
    }

    public double bridge$viewerPosZ() {
        return this.viewerPosZ;
    }

    public void bridge$setDebugBoundingBox(boolean var1) {
        this.debugBoundingBox = var1;
    }

    public void bridge$prepare(WorldBridge var1, EntityBridge var2) {

    }

    @Redirect(method = "cacheActiveRenderInfo", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;rotationYaw:F"))
    public float impl$rotationYaw(Entity var1) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIIIIIIllIlIIIIllIIII();
        }
        return var1.rotationYaw;
    }

    @Redirect(method = "cacheActiveRenderInfo", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;prevRotationYaw:F"))
    public float impl$prevRotationYaw(Entity var1) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIlIlIIIIIIllIlIIIIllIIII();
        }
        return var1.prevRotationYaw;
    }

    @Redirect(method = "cacheActiveRenderInfo", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;prevRotationPitch:F"))
    public float impl$prevRotationPitch(Entity var1) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIIlIIIIIIlIIlIIllIlIIlII();
        }
        return var1.prevRotationPitch;
    }

    @Redirect(method = "cacheActiveRenderInfo", at = @At(value = "FIELD", target = "Lnet/minecraft/entity/Entity;rotationPitch:F"))
    public float impl$rotationPitch(Entity var1) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlllIIIIIIlllIlIIlllIlIIl() && Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().IlIIlIIlIIlIIllIIIllIIllI()) {
            return Ref.getLC().lllllIllIllIllllIlIllllII().lllllIllIlIIlIIlIIIlllIlI().lIIlIIIIIIlIIlIIllIlIIlII();
        }
        return var1.rotationPitch;
    }

    // todo GlStateManager shit
    @Redirect(method = "renderDebugBoundingBox", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/RenderGlobal;drawOutlinedBoundingBox(Lnet/minecraft/util/AxisAlignedBB;IIII)V"))
    public void impl$onDrawOutlinedBoundingBox(final AxisAlignedBB axisAlignedBB, final int n, final int n2, final int n3, final int n4) {
        final HitboxMod iIlllIllIlIllIllIIllIlIIl = LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlllIllIlIllIllIIllIlIIl();
        if (iIlllIllIlIllIllIIllIlIIl.IlllIIIIIIlllIlIIlllIlIIl() && this.lastRenderedEntity != null) {
            final ColorSetting llIlllIIIllllIIlllIllIIIl = iIlllIllIlIllIllIIllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) this.lastRenderedEntity).llIlllIIIllllIIlllIllIIIl();
            final NumberSetting lIllIlIIIlIIIIIIIlllIlIll = iIlllIllIlIllIllIIllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) this.lastRenderedEntity).lIllIlIIIlIIIIIIIlllIlIll();
            final HitboxMod.LinePattern linePattern = (HitboxMod.LinePattern) iIlllIllIlIllIllIIllIlIIl.IIlIlIIIllIIllllIllllIlIl().llIlllIIIllllIIlllIllIIIl();
            GL11.glLineWidth((float) lIllIlIIIlIIIIIIIlllIlIll.llIlllIIIllllIIlllIllIIIl());
            GL11.glEnable(2852);
            GL11.glLineStipple(linePattern.IlllIIIIIIlllIlIIlllIlIIl(), (short) linePattern.lIllIlIIIlIIIIIIIlllIlIll());
            if (llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI() < 0.95f) {
                GlStateManager.pushAttrib();
                GlStateManager.popAttrib();
                GlStateManager.colorMaterial(770, 769);
            }
            RenderGlobal.drawOutlinedBoundingBox(axisAlignedBB, (int) (llIlllIIIllllIIlllIllIIIl.IlllIIIIIIlllIlIIlllIlIIl(0.0f) * 255.0f), (int) (llIlllIIIllllIIlllIllIIIl.lIllIlIIIlIIIIIIIlllIlIll(0.0f) * 255.0f), (int) (llIlllIIIllllIIlllIllIIIl.llIlllIIIllllIIlllIllIIIl(0.0f) * 255.0f), (int) (llIlllIIIllllIIlllIllIIIl.llllIIlIIlIIlIIllIIlIIllI(0.0f) * 255.0f));
            GL11.glLineWidth(1.0f);
            GL11.glDisable(2852);
        } else {
            RenderGlobal.drawOutlinedBoundingBox(axisAlignedBB, n, n2, n3, n4);
        }
    }

    // todo GlStateManager shit
    public void impl$onRenderDebugBoundingBox(Entity var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
        final HitboxMod iIlllIllIlIllIllIIllIlIIl = LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlllIllIlIllIllIIllIlIIl();
        if (iIlllIllIlIllIllIIllIlIIl.IlllIIIIIIlllIlIIlllIlIIl() && !(boolean) iIlllIllIlIllIllIIllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) var1).llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl()) {
            var10.cancel();
            GlStateManager.disableColorMaterial();
            GlStateManager.disableLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.enableBlend();
            GlStateManager.depthMask(true);
        }
    }

    // todo GlStateManager shit
    @Inject(method = "renderDebugBoundingBox", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/Entity;getLook(F)Lnet/minecraft/util/Vec3;", shift = At.Shift.BEFORE), cancellable = true)
    public void impl$onRenderDebugBoundingBox$getLook(Entity var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
        final HitboxMod iIlllIllIlIllIllIIllIlIIl = LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlllIllIlIllIllIIllIlIIl();
        if (iIlllIllIlIllIllIIllIlIIl.IlllIIIIIIlllIlIIlllIlIIl() && !(boolean) iIlllIllIlIllIllIIllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) var1).llllIIlIIlIIlIIllIIlIIllI().llIlllIIIllllIIlllIllIIIl()) {
            var10.cancel();
            GlStateManager.disableColorMaterial();
            GlStateManager.disableLighting();
            GlStateManager.enablePolygonOffset();
            GlStateManager.enableBlend();
            GlStateManager.depthMask(true);
        }
    }

    @Inject(method = "renderDebugBoundingBox", at = @At("HEAD"), cancellable = true)
    public void impl$onRenderDebugBoundingBox$head(Entity var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
        final HitboxMod iIlllIllIlIllIllIIllIlIIl = LunarClient.getInstance().lllllIllIllIllllIlIllllII().IIlllIllIlIllIllIIllIlIIl();
        if (Ref.llIIIlllIIlllIllllIlIllIl() == CosmeticsUIScreenBase.class) {
            var10.cancel();
            return;
        }
        if (iIlllIllIlIllIllIIllIlIIl.IlllIIIIIIlllIlIIlllIlIIl()) {
            if (!(boolean) iIlllIllIlIllIllIIllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge) var1).IlIlIlllllIlIIlIlIlllIlIl().llIlllIIIllllIIlllIllIIIl()) {
                var10.cancel();
            } else {
                this.lastRenderedEntity = var1;
            }
        }
    }

    @Inject(method = "renderDebugBoundingBox", at = @At("TAIL"), cancellable = true)
    public void impl$onRenderDebugBoundingBox$tail(Entity var1, double var2, double var4, double var6, float var8, float var9, CallbackInfo var10) {
        this.lastRenderedEntity = null;
    }

    public boolean bridge$showDebugBoundingBox() {
        return this.debugBoundingBox;
    }
}
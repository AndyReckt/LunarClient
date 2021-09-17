/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  javax.vecmath.Matrix4f
 *  javax.vecmath.Tuple4f
 *  javax.vecmath.Vector4f
 *  lunar.D.BuiltInModelBridge
 *  lunar.G.EntityBridge
 *  lunar.G.EntityLivingBaseBridge
 *  lunar.G.llIIIIIIIllIIllIlIllIIIIl
 *  lunar.L.EntityPlayerBridge
 *  lunar.Q.ItemArmorBridge
 *  lunar.Q.ItemBridge
 *  lunar.Q.ItemStackBridge
 *  lunar.R.RenderUtilBridge
 *  lunar.a.Bridge
 *  lunar.a.MinecraftVersion
 *  lunar.af.ResourceLocationBridge
 *  lunar.at.CosmeticManagerLayer
 *  lunar.c.MatrixStackBridge
 *  lunar.cO.HeadCustomLayer
 *  lunar.dc.Ref
 *  lunar.de.lIlIlIlIlIIlIIlIIllIIIIIl
 *  lunar.de.lIllIlIIIlIIIIIIIlllIlIll
 *  lunar.h.MinecraftBridge
 *  lunar.l.ModelPlayerBridge
 *  lunar.p.AbstractClientPlayerBridge
 *  lunar.q.GlStateManagerBridge
 *  lunar.q.ItemRendererBridge
 *  lunar.q.RendererLivingEntityBridge
 *  lunar.q.lIlIlIlIlIIlIIlIIllIIIIIl
 *  lunar.r.ItemCameraTransformsBridge$lIlIlIlIlIIlIIlIIllIIIIIl
 *  lunar.u.RenderItemBridge
 *  lunar.v.LayerCapeBridge
 *  lunar.w.RenderPlayerBridge
 *  org.lwjgl.BufferUtils
 *  org.lwjgl.opengl.GL11
 */
package mchorse.emoticons.skin_n_bones.api.animation.model;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.vecmath.Matrix4f;
import javax.vecmath.Tuple4f;
import javax.vecmath.Vector4f;

import com.moonsworth.lunar.bridge.current.MatrixStackBridge;
import com.moonsworth.lunar.bridge.current.lIllIlIIIlIIIIIIIlllIlIll;
import com.moonsworth.lunar.bridge.lunar.RenderUtilBridge;
import com.moonsworth.lunar.bridge.minecraft.client.MinecraftBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.llIIIIIIIllIIllIlIllIIIIl;
import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.GlStateManagerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.ItemRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.block.model.ItemCameraTransformsBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderItemBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RendererLivingEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.UnknownRenderEntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;
import com.moonsworth.lunar.bridge.minecraft.client.resources.model.BuiltInModelBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemArmorBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemBridge;
import com.moonsworth.lunar.bridge.minecraft.item.ItemStackBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.bridge.MinecraftVersion;
import com.moonsworth.lunar.client.cosmetic.de.lIlIlIlIlIIlIIlIIllIIIIIl;
import com.moonsworth.lunar.client.cosmetic.layer.CosmeticManagerLayer;
import com.moonsworth.lunar.client.cosmetic.type.HeadCustomLayer;
import com.moonsworth.lunar.client.ref.Ref;
import mchorse.emoticons.common.EntityEquipmentSlot;
import mchorse.emoticons.skin_n_bones.api.animation.Animation;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationManager;
import mchorse.emoticons.skin_n_bones.api.animation.AnimationMesh;
import mchorse.emoticons.skin_n_bones.api.animation.model.ActionPlayback;
import mchorse.emoticons.skin_n_bones.api.animation.model.Animator;
import mchorse.emoticons.skin_n_bones.api.animation.model.AnimatorConfig;
import mchorse.emoticons.skin_n_bones.api.animation.model.IAnimator;
import mchorse.emoticons.skin_n_bones.api.animation.model.IAnimatorFactory;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJArmature;
import mchorse.emoticons.skin_n_bones.api.bobj.BOBJBone;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class AnimatorController {
    public static final ResourceLocationBridge EMPTY_LOCATION = Bridge.llIlllIIIllllIIlllIllIIIl().initResourceLocation("lunar:empty");
    public static final FloatBuffer matrix = BufferUtils.createFloatBuffer((int)16);
    public static final float[] buffer = new float[16];
    public static final IAnimatorFactory DEFAULT_FACTORY = Animator::new;
    public IAnimatorFactory factory = DEFAULT_FACTORY;
    public Animation animation;
    public IAnimator animator;
    public ActionPlayback emote;
    public AnimatorConfig.AnimatorConfigEntry config;
    public AnimatorConfig userConfig = new AnimatorConfig();
    public long lastModified;
    public int checkConfig;
    public String animationName;
    public MinecraftBridge mc;
    public Vector4f result = new Vector4f();
    public Matrix4f rotate = new Matrix4f();
    public static int NO_OVERLAY = AnimatorController.pack(0, 10);

    public AnimatorController(String string) {
        this.refresh(string);
        this.mc = Bridge.llllIIlIIlIIlIIllIIlIIllI();
    }

    public Vector4f calcPosition(EntityLivingBaseBridge entityLivingBaseBridge, BOBJBone bOBJBone, float f, float f2, float f3, float f4) {
        float f5 = (float)Math.PI;
        this.result.set(f, f2, f3, 1.0f);
        bOBJBone.mat.transform((Tuple4f)this.result);
        this.rotate.setIdentity();
        this.rotate.rotY((180.0f - entityLivingBaseBridge.bridge$getRenderYawOffset() + 180.0f) / 180.0f * (float)Math.PI);
        this.rotate.transform((Tuple4f)this.result);
        this.result.scale(0.9375f);
        float f6 = (float)(entityLivingBaseBridge.bridge$lastTickX() + (entityLivingBaseBridge.bridge$getPosX() - entityLivingBaseBridge.bridge$lastTickX()) * (double)f4);
        float f7 = (float)(entityLivingBaseBridge.bridge$lastTickY() + (entityLivingBaseBridge.bridge$getPosY() - entityLivingBaseBridge.bridge$lastTickY()) * (double)f4);
        float f8 = (float)(entityLivingBaseBridge.bridge$lastTickZ() + (entityLivingBaseBridge.bridge$getPosZ() - entityLivingBaseBridge.bridge$lastTickZ()) * (double)f4);
        this.result.x += f6;
        this.result.y += f7;
        this.result.z += f8;
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl && entityLivingBaseBridge == Ref.IlIlIlllllIlIIlIlIlllIlIl()) {
            this.result.y -= 1.62f;
        }
        return this.result;
    }

    public void setEmote(ActionPlayback actionPlayback) {
        this.emote = actionPlayback;
        if (this.animator != null) {
            this.animator.setEmote(actionPlayback);
        }
    }

    public void refresh(String string) {
        this.animation = null;
        this.animator = null;
        this.animationName = string;
    }

    public void render(EntityLivingBaseBridge entityLivingBaseBridge, double d, double d2, double d3, float f, float f2) {
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        RenderUtilBridge renderUtilBridge = Bridge.IlllllIlIIIlIIlIIllIIlIll();
        if (this.animation != null && this.animation.meshes.size() > 0) {
            EntityPlayerBridge playerBridge;
            if (Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl && entityLivingBaseBridge == Ref.IlIlIlllllIlIIlIlIlllIlIl()) {
                d2 -= (double)1.62f;
            }
            glStateManagerBridge.bridge$disableCull();
            glStateManagerBridge.bridge$enableAlpha();
            float f3 = entityLivingBaseBridge.bridge$getPrevRenderYawOffset() + (entityLivingBaseBridge.bridge$getRenderYawOffset() - entityLivingBaseBridge.bridge$getPrevRenderYawOffset()) * f2;
            if (entityLivingBaseBridge.bridge$isRiding()) {
                EntityBridge entityBridge = entityLivingBaseBridge.bridge$getRidingEntity();
                if (entityBridge instanceof EntityPlayerBridge) {
                    playerBridge = (EntityPlayerBridge)entityBridge;
                    f3 = playerBridge.bridge$getPrevRenderYawOffset() + (playerBridge.bridge$getRenderYawOffset() - playerBridge.bridge$getPreviousRotationYawOffset()) * f2;
                } else {
                    f3 = (float)(entityBridge.bridge$getPreviousRotationYaw() + (entityBridge.bridge$getRotationYaw() - entityBridge.bridge$getPreviousRotationYaw()) * (double)f2);
                }
                if (entityBridge instanceof llIIIIIIIllIIllIlIllIIIIl) {
                    f3 += 90.0f;
                }
            }
            float f4 = this.userConfig.scale;
            GL11.glPushMatrix();
            GL11.glTranslated((double)d, (double)d2, (double)d3);
            GL11.glScalef((float)f4, (float)f4, (float)f4);
            if (entityLivingBaseBridge.bridge$isPlayerSleeping()) {
                playerBridge = (EntityPlayerBridge)entityLivingBaseBridge;
                glStateManagerBridge.bridge$rotate(playerBridge.bridge$getBedOrientationInDegrees(), 0.0f, 1.0f, 0.0f);
                glStateManagerBridge.bridge$rotate(270.0f, 0.0f, 1.0f, 0.0f);
            } else {
                GL11.glRotatef((float)(180.0f - (f3 - 180.0f)), (float)0.0f, (float)1.0f, (float)0.0f);
            }
            this.renderAnimation(entityLivingBaseBridge, (AnimationMesh)this.animation.meshes.get(0), f3, f2);
            GL11.glPopMatrix();
            glStateManagerBridge.bridge$enableCull();
        }
    }

    public List renderModern(EntityLivingBaseBridge entityLivingBaseBridge, com.moonsworth.lunar.client.cosmetic.de.lIllIlIIIlIIIIIIIlllIlIll lIllIlIIIlIIIIIIIlllIlIll2, MatrixStackBridge matrixStackBridge, double d, double d2, double d3, float f, int n) {
        ArrayList arrayList = new ArrayList();
        if (this.animation != null && this.animation.meshes.size() > 0) {
            float f2 = entityLivingBaseBridge.bridge$getPrevRenderYawOffset() + (entityLivingBaseBridge.bridge$getRenderYawOffset() - entityLivingBaseBridge.bridge$getPrevRenderYawOffset()) * f;
            if (entityLivingBaseBridge.bridge$isRiding()) {
                EntityBridge entityBridge = entityLivingBaseBridge.bridge$getRidingEntity();
                if (entityBridge instanceof EntityLivingBaseBridge) {
                    EntityLivingBaseBridge entityLivingBaseBridge2 = (EntityLivingBaseBridge)entityBridge;
                    f2 = entityLivingBaseBridge2.bridge$getPrevRenderYawOffset() + (entityLivingBaseBridge2.bridge$getRenderYawOffset() - entityLivingBaseBridge2.bridge$getPreviousRotationYawOffset()) * f;
                } else {
                    f2 = (float)(entityBridge.bridge$getPreviousRotationYaw() + (entityBridge.bridge$getRotationYaw() - entityBridge.bridge$getPreviousRotationYaw()) * (double)f);
                }
                if (entityBridge instanceof llIIIIIIIllIIllIlIllIIIIl) {
                    f2 += 90.0f;
                }
            }
            float f3 = this.userConfig.scale;
            matrixStackBridge = matrixStackBridge.llllIIlIIlIIlIIllIIlIIllI();
            matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f3, f3, f3);
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, 180.0f - (f2 - 180.0f), 0.0f);
            lIllIlIIIlIIIIIIIlllIlIll2.lIlIlIlIlIIlIIlIIllIIIIIl(matrixStackBridge);
            arrayList.addAll(this.renderAnimationModern(entityLivingBaseBridge, (AnimationMesh)this.animation.meshes.get(0), matrixStackBridge, f2, f, n));
        }
        return arrayList;
    }

    public List renderAnimationModern(EntityLivingBaseBridge entityLivingBaseBridge, AnimationMesh animationMesh, MatrixStackBridge matrixStackBridge, float f, float f2, int n) {
        BOBJArmature bOBJArmature = animationMesh.armature;
        this.setupBoneMatrices(entityLivingBaseBridge, bOBJArmature, f, f2);
        for (AnimationMesh animationMesh2 : this.animation.meshes) {
            animationMesh2.updateMesh(true);
        }
        List list = this.animation.renderPasses(this.userConfig.meshes, n);
        Bridge.llllIIlIIlIIlIIllIIlIIllI().IlllIIIIIIlllIlIIlllIlIIl().ifPresent(llIIlIlIIIllIlIlIlIIlIIll2 -> {
            ModelPlayerBridge modelPlayerBridge = ((RenderPlayerBridge)Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$getSkinMap().get(((AbstractClientPlayerBridge)entityLivingBaseBridge).bridge$getSkinType())).bridge$getMainModel();
            lIlIlIlIlIIlIIlIIllIIIIIl.IlllIIIIIIlllIlIIlllIlIIl.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractClientPlayerBridge)entityLivingBaseBridge, modelPlayerBridge, n, llIIlIlIIIllIlIlIlIIlIIll2.lIllIlIIIlIIIIIIIlllIlIll(), matrixStackBridge, f2, 0.0f);
            lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractClientPlayerBridge)entityLivingBaseBridge, modelPlayerBridge, n, llIIlIlIIIllIlIlIlIIlIIll2.lIllIlIIIlIIIIIIIlllIlIll(), matrixStackBridge, f2, 0.0f);
            UnknownRenderEntityBridge rendererLivingEntityBridge = Bridge.lllllIllIlIIlIIlIIIlllIlI();
            if (rendererLivingEntityBridge.bridge$canRenderName(entityLivingBaseBridge)) {
                lIlIlIlIlIIlIIlIIllIIIIIl.lIllIlIIIlIIIIIIIlllIlIll.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractClientPlayerBridge)entityLivingBaseBridge, modelPlayerBridge, n, llIIlIlIIIllIlIlIlIIlIIll2.lIllIlIIIlIIIIIIIlllIlIll(), matrixStackBridge, f2, f);
            }
            this.renderHeadModern(entityLivingBaseBridge, (BOBJBone)bOBJArmature.bones.get(this.userConfig.head), matrixStackBridge, llIIlIlIIIllIlIlIlIIlIIll2.lIllIlIIIlIIIIIIIlllIlIll(), n);
        });
        return list;
    }

    public void renderAnimation(EntityLivingBaseBridge entityLivingBaseBridge, AnimationMesh animationMesh, float f, float f2) {
        BOBJArmature bOBJArmature = animationMesh.armature;
        this.setupBoneMatrices(entityLivingBaseBridge, bOBJArmature, f, f2);
        for (AnimationMesh animationMesh2 : this.animation.meshes) {
            animationMesh2.updateMesh(false);
        }
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        glStateManagerBridge.bridge$enableRescaleNormal();
        boolean bl = Bridge.lllllIllIlIIlIIlIIIlllIlI().bridge$setBrightness(entityLivingBaseBridge, f2);
        this.animation.render(this.userConfig.meshes);
        if (bl) {
            Bridge.lllllIllIlIIlIIlIIIlllIlI().bridge$unsetBrightness();
        }
        glStateManagerBridge.bridge$disableRescaleNormal();
        bl = Bridge.lllllIllIlIIlIIlIIIlllIlI().bridge$setBrightness(entityLivingBaseBridge, f2);
        glStateManagerBridge.bridge$pushMatrix();
        LayerCapeBridge layerCapeBridge = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().IIlIllIlllllllIIlIIIllIIl();
        if (layerCapeBridge != null) {
            layerCapeBridge.bridge$render((AbstractClientPlayerBridge)entityLivingBaseBridge, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f);
        }
        glStateManagerBridge.bridge$popMatrix();
        glStateManagerBridge.bridge$pushMatrix();
        if (Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl) {
            Ref.lIlIlIlIlIIlIIlIIllIIIIIl().bridge$getRenderManager().bridge$defaultPlayerRenderer().lIlIlIlIlIIlIIlIIllIIIIIl((AbstractClientPlayerBridge)entityLivingBaseBridge, f2);
        } else {
            HeadCustomLayer headCustomLayer = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().lIlIIIIIIlIIIllllIllIIlII();
            CosmeticManagerLayer cosmeticManagerLayer = Ref.IlllIIIIIIlllIlIIlllIlIIl().IIlIllIlIIllIIlIlIllllllI().llIlIIIllIIlIllIllIllllIl();
            if (headCustomLayer != null && entityLivingBaseBridge instanceof AbstractClientPlayerBridge) {
                ModelPlayerBridge modelPlayerBridge = ((RenderPlayerBridge)Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderManager().bridge$getSkinMap().get(((AbstractClientPlayerBridge)entityLivingBaseBridge).bridge$getSkinType())).bridge$getMainModel();
                headCustomLayer.lIlIlIlIlIIlIIlIIllIIIIIl((AbstractClientPlayerBridge)entityLivingBaseBridge, modelPlayerBridge, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        glStateManagerBridge.bridge$popMatrix();
        if (bl) {
            Bridge.lllllIllIlIIlIIlIIIlllIlI().bridge$unsetBrightness();
        }
        this.renderHead(entityLivingBaseBridge, (BOBJBone)bOBJArmature.bones.get(this.userConfig.head));
    }

    public void setupBoneMatrices(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, float f, float f2) {
        for (BOBJBone bOBJBone : bOBJArmature.orderedBones) {
            bOBJBone.reset();
        }
        this.setupBoneTransformations(entityLivingBaseBridge, bOBJArmature, f, f2);
        for (BOBJBone bOBJBone : bOBJArmature.orderedBones) {
            bOBJArmature.matrices[bOBJBone.index] = bOBJBone.compute();
        }
    }

    public void setupBoneTransformations(EntityLivingBaseBridge entityLivingBaseBridge, BOBJArmature bOBJArmature, float f, float f2) {
        BOBJBone bOBJBone = (BOBJBone)bOBJArmature.bones.get(this.userConfig.head);
        if (bOBJBone != null) {
            float f3 = entityLivingBaseBridge.bridge$getPrevRotationYawHead() + (entityLivingBaseBridge.bridge$getRotationYawHead() - entityLivingBaseBridge.bridge$getPrevRotationYawHead()) * f2;
            float f4 = (float)(entityLivingBaseBridge.bridge$getPreviousRotationPitch() + (entityLivingBaseBridge.bridge$getRotationPitch() - entityLivingBaseBridge.bridge$getPreviousRotationPitch()) * (double)f2);
            f3 = (f - f3) / 180.0f * (float)Math.PI;
            bOBJBone.rotateX = f4 = f4 / 180.0f * (float)Math.PI;
            bOBJBone.rotateY = f3;
        }
        if (this.animator != null) {
            this.animator.applyActions(bOBJArmature, f2);
        }
    }

    public void renderHeadModern(EntityLivingBaseBridge entityLivingBaseBridge, BOBJBone bOBJBone, MatrixStackBridge matrixStackBridge, lIlIlIlIlIIlIIlIIllIIIIIl lIlIlIlIlIIlIIlIIllIIIIIl2, int n) {
        ItemBridge itemBridge;
        ItemStackBridge itemStackBridge = entityLivingBaseBridge.bridge$getEquipmentInSlot(EntityEquipmentSlot.HEAD.ordinal());
        if (itemStackBridge != null && !itemStackBridge.bridge$isEmpty() && bOBJBone != null && !((itemBridge = itemStackBridge.bridge$getItem()) instanceof ItemArmorBridge)) {
            matrixStackBridge.lIllIlIIIlIIIIIIIlllIlIll();
            this.setupMatrix(bOBJBone, matrixStackBridge);
            float f = 0.625f;
            if (itemBridge.bridge$isItemSkull()) {
                f = 1.1875f;
                matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(0.0, (double)0.595f, 0.0);
            } else {
                matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(0.0, 0.25, 0.0);
                matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl(0.0f, 180.0f, 0.0f);
            }
            matrixStackBridge.lIlIlIlIlIIlIIlIIllIIIIIl(f, f, f);
            ItemRendererBridge itemRendererBridge = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getItemRenderer();
            RenderItemBridge renderItemBridge = Bridge.llllIIlIIlIIlIIllIIlIIllI().bridge$getRenderItem();
            renderItemBridge.bridge$getItemModelShaper().ifPresent(itemModelMesherBridge -> {
                BuiltInModelBridge builtInModelBridge = itemModelMesherBridge.bridge$getItemModel(itemStackBridge);
                itemRendererBridge.lIlIlIlIlIIlIIlIIllIIIIIl(itemStackBridge, ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl, true, matrixStackBridge, lIlIlIlIlIIlIIlIIllIIIIIl2, n, NO_OVERLAY, builtInModelBridge);
            });
            matrixStackBridge.IlllIIIIIIlllIlIIlllIlIIl();
        }
    }

    public void renderHead(EntityLivingBaseBridge entityLivingBaseBridge, BOBJBone bOBJBone) {
        ItemBridge itemBridge;
        GlStateManagerBridge glStateManagerBridge = Bridge.llIIIIIIIllIIllIlIllIIIIl();
        ItemStackBridge itemStackBridge = entityLivingBaseBridge.bridge$getEquipmentInSlot(EntityEquipmentSlot.HEAD.ordinal());
        if (itemStackBridge != null && !itemStackBridge.bridge$isEmpty() && bOBJBone != null && !((itemBridge = itemStackBridge.bridge$getItem()) instanceof ItemArmorBridge)) {
            float f;
            glStateManagerBridge.bridge$pushMatrix();
            this.setupMatrix(bOBJBone);
            float f2 = f = Bridge.IlllIIIIIIlllIlIIlllIlIIl() == MinecraftVersion.lIlIlIlIlIIlIIlIIllIIIIIl ? 1.0625f : 0.625f;
            if (itemBridge != Bridge.llIlIIIllIIlIllIllIllllIl().bridge$skull()) {
                glStateManagerBridge.bridge$rotate(180.0f, 0.0f, 1.0f, 0.0f);
            }
            if (Bridge.IlllIIIIIIlllIlIIlllIlIIl().ordinal() >= MinecraftVersion.lIllIlIIIlIIIIIIIlllIlIll.ordinal()) {
                if (itemBridge == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$skull()) {
                    f = 1.1875f;
                    glStateManagerBridge.bridge$translate(0.0f, 0.585f, 0.0f);
                } else {
                    glStateManagerBridge.bridge$translate(0.0f, 0.25f, 0.0f);
                }
            } else {
                if (itemBridge == Bridge.llIlIIIllIIlIllIllIllllIl().bridge$skull()) {
                    f = 0.6f;
                }
                glStateManagerBridge.bridge$translate(0.0f, 0.25f, 0.0f);
            }
            glStateManagerBridge.bridge$scale((double)f, (double)f, (double)f);
            this.mc.bridge$getItemRenderer().bridge$renderItem(entityLivingBaseBridge, itemStackBridge, ItemCameraTransformsBridge.lIlIlIlIlIIlIIlIIllIIIIIl.IlIlIlllllIlIIlIlIlllIlIl);
            glStateManagerBridge.bridge$popMatrix();
        }
    }

    public void setupMatrix(BOBJBone bOBJBone) {
        this.setupMatrix(bOBJBone.mat);
    }

    public void setupMatrix(BOBJBone bOBJBone, MatrixStackBridge matrixStackBridge) {
        this.setupMatrix(bOBJBone.mat, matrixStackBridge);
    }

    public void setupMatrix(Matrix4f matrix4f) {
        AnimatorController.buffer[0] = matrix4f.m00;
        AnimatorController.buffer[1] = matrix4f.m10;
        AnimatorController.buffer[2] = matrix4f.m20;
        AnimatorController.buffer[3] = matrix4f.m30;
        AnimatorController.buffer[4] = matrix4f.m01;
        AnimatorController.buffer[5] = matrix4f.m11;
        AnimatorController.buffer[6] = matrix4f.m21;
        AnimatorController.buffer[7] = matrix4f.m31;
        AnimatorController.buffer[8] = matrix4f.m02;
        AnimatorController.buffer[9] = matrix4f.m12;
        AnimatorController.buffer[10] = matrix4f.m22;
        AnimatorController.buffer[11] = matrix4f.m32;
        AnimatorController.buffer[12] = matrix4f.m03;
        AnimatorController.buffer[13] = matrix4f.m13;
        AnimatorController.buffer[14] = matrix4f.m23;
        AnimatorController.buffer[15] = matrix4f.m33;
        matrix.clear();
        matrix.put(buffer);
        matrix.flip();
        Bridge.llIIIIIIIllIIllIlIllIIIIl().bridge$multMatrix(matrix);
    }

    public void setupMatrix(Matrix4f matrix4f, MatrixStackBridge matrixStackBridge) {
        matrixStackBridge.llIlllIIIllllIIlllIllIIIl().lIlIlIlIlIIlIIlIIllIIIIIl().lIlIlIlIlIIlIIlIIllIIIIIl(matrix4f);
    }

    public void update(EntityLivingBaseBridge entityLivingBaseBridge) {
        this.fetchAnimation();
        if (this.animator != null) {
            this.watchConfig();
            this.animator.update(entityLivingBaseBridge);
        }
    }

    public void watchConfig() {
        ++this.checkConfig;
        if (this.checkConfig > 10) {
            this.checkConfig = 0;
            if (this.lastModified < this.config.lastModified) {
                this.animation = null;
                this.fetchAnimation();
            }
        }
    }

    public void fetchAnimation() {
        if (this.animation != null) {
            return;
        }
        Animation animation = AnimationManager.INSTANCE.getAnimation(this.animationName);
        if (animation != null) {
            this.animation = animation;
            this.config = AnimationManager.INSTANCE.getConfig(animation.name);
            this.userConfig.copy(this.config.config);
            this.animator = this.factory.createAnimator(this);
            this.animator.setEmote(this.emote);
            this.lastModified = this.config.lastModified;
        }
    }

    public static int pack(int n, int n2) {
        return n | n2 << 16;
    }
}


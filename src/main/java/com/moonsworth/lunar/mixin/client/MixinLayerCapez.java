package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.layers.LayerCapeBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.AbstractTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.texture.CustomTextureBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ModelCloak;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.bridge.impl.type.texture.TickingTextureImplementation;
import com.moonsworth.lunar.client.cosmetic.CloakCosmetic;
import com.moonsworth.lunar.client.cosmetic.CosmeticType;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.texture.AnimationTickingTexture;
import mchorse.emoticons.capabilities.cosmetic.Cosmetic;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerCape;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LayerCape.class)
public abstract class MixinLayerCapez implements LayerCapeBridge {

    @Final
    @Shadow
    private RenderPlayer playerRenderer;

    @Shadow
    public abstract void doRenderLayer(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8);

    public void impl$doRenderLayer$pushMatrix(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, CallbackInfo var9) {
        final Cosmetic cosmetic = (Cosmetic)Cosmetic.get((EntityBridge) var1);
        if (cosmetic != null && cosmetic.emote != null && Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityLivingBaseBridge) var1)) {
            if (!cosmetic.emote.renderCape()) {
                var9.cancel();
                GlStateManager.popAttrib();
            } else {
                cosmetic.animator.setupMatrix(cosmetic.animator.animation.meshes.get(0).armature.bones.get("low_body"));
                GlStateManager.translate(0.0, 0.375, 0.0);
                GlStateManager.rotate(180.0f, 0.0f, 0.0f, 1.0f);
            }
        }
    }

    public void impl$doRenderLayer(ModelPlayer var1, float var2, AbstractClientPlayer var3) {
        final ResourceLocation redirect$zij000$impl$getLocationCape = this.impl$getLocationCape(var3);
        final AbstractTextureBridge bridge$getTexture = Ref.getMinecraft().bridge$getTextureManager().bridge$getTexture((ResourceLocationBridge) redirect$zij000$impl$getLocationCape);
        if (bridge$getTexture instanceof TickingTextureImplementation) {
            final CustomTextureBridge customTexture = ((TickingTextureImplementation)bridge$getTexture).getCustomTexture();
            if (customTexture instanceof AnimationTickingTexture) {
                final AnimationTickingTexture animationTickingTexture = (AnimationTickingTexture)customTexture;
                final ModelCloak modelCloakImplementation = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().llIIIlllIIlllIllllIlIllIl().get(redirect$zij000$impl$getLocationCape);
                if (modelCloakImplementation != null) {
                    modelCloakImplementation.updateUVPosition(animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl() * animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl(), animationTickingTexture.IlllIIIIIIlllIlIIlllIlIIl());
                    modelCloakImplementation.render(animationTickingTexture.lIlIlIlIlIIlIIlIIllIIIIIl(), 0.0315f);
                }
            }
        } else {
            this.playerRenderer.getMainModel().renderCape(0.0625f);
        }
    }

    public boolean impl$isSneaking(AbstractClientPlayer abstractClientPlayer) {
        return abstractClientPlayer.isRiding() && !Ref.getLC().lIIlIlllIlIlIIIlllIIlIIII().lIlIlIlIlIIlIIlIIllIIIIIl((EntityLivingBaseBridge) abstractClientPlayer);
    }

    public ResourceLocation impl$getLocationCape(AbstractClientPlayer abstractClientPlayer) {
        final CloakCosmetic lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayer.getUniqueID());
        if (lIlIlIlIlIIlIIlIIllIIIIIl != null && lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl() && CosmeticType.CLOAK.lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()) {
            return (ResourceLocation)lIlIlIlIlIIlIIlIIllIIIIIl.llllIIlIIlIIlIIllIIlIIllI();
        }
        return abstractClientPlayer.getLocationCape();
    }

    public boolean impl$isWearing(AbstractClientPlayer abstractClientPlayer, EnumPlayerModelParts enumPlayerModelParts) {
        if (enumPlayerModelParts == EnumPlayerModelParts.CAPE) {
            final CloakCosmetic lIlIlIlIlIIlIIlIIllIIIIIl = Ref.getLC().IIlIllIlIIllIIlIlIllllllI().lIlIlIlIlIIlIIlIIllIIIIIl(abstractClientPlayer.getUniqueID());
            return (lIlIlIlIlIIlIIlIIllIIIIIl != null && lIlIlIlIlIIlIIlIIllIIIIIl.llIIIIIIIllIIllIlIllIIIIl() && CosmeticType.CLOAK.lIIIllIllIIllIlllIlIIlllI().llIlllIIIllllIIlllIllIIIl()) || abstractClientPlayer.isWearing(enumPlayerModelParts);
        }
        return abstractClientPlayer.isWearing(enumPlayerModelParts);
    }

    public void bridge$render(AbstractClientPlayerBridge var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
        this.doRenderLayer((AbstractClientPlayer)var1, var2, var3, var4, var5, var6, var7, var8);
    }
}
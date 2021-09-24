package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityLivingBaseBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelRendererBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.state.EventState;
import com.moonsworth.lunar.client.event.type.hud.ModelBipedRenderEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModelPlayer.class)
public abstract class MixinModelPlayer extends ModelBiped implements ModelPlayerBridge {
    @Shadow
    public ModelRenderer bipedCape;

    public MixinModelPlayer() {
    }

    @Shadow
    public abstract void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7);

    public ModelRendererBridge bridge$bipedHead() {
        return (ModelRendererBridge) this.bipedHead;
    }

    public ModelRendererBridge bridge$bipedHeadwear() {
        return (ModelRendererBridge) this.bipedHeadwear;
    }

    public ModelRendererBridge bridge$bipedBody() {
        return (ModelRendererBridge) this.bipedBody;
    }

    public ModelRendererBridge bridge$bipedRightArm() {
        return (ModelRendererBridge) this.bipedRightArm;
    }

    public ModelRendererBridge bridge$bipedLeftArm() {
        return (ModelRendererBridge) this.bipedLeftArm;
    }

    public ModelRendererBridge bridge$bipedRightLeg() {
        return (ModelRendererBridge) this.bipedRightLeg;
    }

    public ModelRendererBridge bridge$bipedLeftLeg() {
        return (ModelRendererBridge) this.bipedLeftLeg;
    }

    public ModelRendererBridge bridge$cloak() {
        return (ModelRendererBridge) this.bipedCape;
    }

    public ModelRendererBridge bridge$head() {
        return (ModelRendererBridge) this.bipedHead;
    }

    @Override
    public void bridge$setRotationAngles(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final EntityLivingBaseBridge entityLivingBaseBridge) {
        this.setRotationAngles(n, n2, n3, n4, n5, n6, (Entity)entityLivingBaseBridge);
    }

    public void impl$onModelBipedRender(final Entity entity, final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final CallbackInfo callbackInfo) {
        if (entity instanceof AbstractClientPlayer) {
            EventBus.getInstance().call(new ModelBipedRenderEvent(EventState.POST, (AbstractClientPlayerBridge)entity, this, n6));
        }
    }
}
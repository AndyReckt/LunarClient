package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.minecraft.client.entity.player.EntityPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.model.ModelPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.client.renderer.entity.RenderPlayerBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.player.PreRenderPlayerEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RenderPlayer.class)
public abstract class MixinRenderPlayer implements RenderPlayerBridge {
    @Shadow
    public abstract ModelPlayer getMainModel();

    public ModelPlayerBridge bridge$getMainModel() {
        return (ModelPlayerBridge) getMainModel();
    }

    @Inject(method = "setModelVisibilities", at = @At(value = "FIELD", target = "Lnet/minecraft/client/model/ModelBiped;aimedBow:Z", shift = At.Shift.AFTER))
    public void impl$onSetModelVisibilities(CallbackInfo var1) {
        this.getMainModel().isRiding = false;
    }

    @Inject(method = "doRender", at = @At("HEAD"), cancellable = true)
    public void impl$onPreRenderPlayer(AbstractClientPlayer var1, double n, double n2, double n3, float n4, float n5, CallbackInfo callbackInfo) {
        if (!var1.isUser() || Minecraft.getMinecraft().getRenderManager().livingPlayer == var1) {
            final PreRenderPlayerEvent preRenderPlayerEvent = new PreRenderPlayerEvent((EntityPlayerBridge) var1, n, n2, n3, n5);
            EventBus.getInstance().call(preRenderPlayerEvent);
            if (preRenderPlayerEvent.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }
}
package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.entity.EntityBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EffectRendererBridge;
import com.moonsworth.lunar.bridge.minecraft.client.particle.EntityFXBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ParticleType;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EffectRenderer.class)
public abstract class MixinEffectRenderer implements EffectRendererBridge {
//    @Shadow
//    private Map<Integer, IParticleFactory> particleTypes;

    @Shadow
    public abstract void emitParticleAtEntity(Entity var1, EnumParticleTypes var2);

    @Shadow
    public abstract void addEffect(EntityFX var1);

    @Redirect(method = "renderParticles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/particle/EntityFX;renderParticle(Lnet/minecraft/client/renderer/WorldRenderer;Lnet/minecraft/entity/Entity;FFFFFF)V"))
    public void impl$renderParticle(EntityFX var1, WorldRenderer var2, Entity var3, float var4, float var5, float var6, float var7, float var8, float var9) {
        if (LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().IlIlIlllllIlIIlIlIlllIlIl().lIlIlIlIlIIlIIlIIllIIIIIl((EntityBridge)var1)) {
            var1.renderParticle(var2, var3, var4, var5, var6, var7, var8, var9);
        }
    }

    public void bridge$emitParticleAtEntity(EntityBridge var1, ParticleType var2) {
        emitParticleAtEntity((Entity) var1, EnumParticleTypes.getParticleFromId(var2.lIllIlIIIlIIIIIIIlllIlIll()));
    }

    public void bridge$addEffect(EntityFXBridge var1) {
        addEffect((EntityFX)var1);
    }
}
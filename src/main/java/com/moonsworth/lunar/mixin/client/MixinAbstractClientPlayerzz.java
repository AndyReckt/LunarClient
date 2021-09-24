package com.moonsworth.lunar.mixin.client;

import com.mojang.authlib.GameProfile;
import com.moonsworth.lunar.bridge.minecraft.client.entity.AbstractClientPlayerBridge;
import com.moonsworth.lunar.bridge.minecraft.util.ResourceLocationBridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.entity.player.CreatePlayerEvent;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractClientPlayer.class)
public abstract class MixinAbstractClientPlayerzz extends EntityPlayer implements AbstractClientPlayerBridge {
    @Shadow
    public abstract boolean isSpectator();

    @Shadow
    public abstract String getSkinType();

    @Shadow
    public abstract ResourceLocation getLocationSkin();

    @Shadow
    protected abstract NetworkPlayerInfo getPlayerInfo();

    public MixinAbstractClientPlayerzz(World var1, GameProfile var2) {
        super(var1, var2);
    }

    public boolean bridge$isSpectator() {
        return isSpectator();
    }

    public void bridge$setLocationOfCape(ResourceLocationBridge var1) {

    }

    public void bridge$setLocationOfCapeOverride(ResourceLocationBridge var1) {
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    public void impl$createPlayer(World var1, GameProfile var2, CallbackInfo var3) {
        EventBus.getInstance().call((new CreatePlayerEvent(this)));
    }

    public String bridge$getSkinType() {
        return getSkinType();
    }

    public ResourceLocationBridge bridge$getLocationSkin() {
        return (ResourceLocationBridge) getLocationSkin();
    }
}
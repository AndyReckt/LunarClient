package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.client.bridge.Bridge;
import com.moonsworth.lunar.client.event.EventBus;
import com.moonsworth.lunar.client.event.type.input.ScrollIngameEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.entity.player.InventoryPlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Minecraft.class)
public class MixinMinecraftz {

    @Shadow @Final private List<IResourcePack> defaultResourcePacks;

    @Inject(method = "startGame", at = @At("RETURN"))
    public void impl$startGame(CallbackInfo var1) {
        Bridge.lIlIlIlIlIIlIIlIIllIIIIIl().ifPresent(abstractResourcePackBridge -> {
            System.out.println("[Bridge] Adding cosmetic pack to the default resource packs");
            this.defaultResourcePacks.add((IResourcePack) abstractResourcePackBridge);
        });
    }

    @Redirect(method = "runTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/player/InventoryPlayer;changeCurrentItem(I)V"))
    public void impl$runTick$changeCurrentItem(InventoryPlayer var1, int var2) {
        ScrollIngameEvent scrollIngameEvent = new ScrollIngameEvent(var2);
        EventBus.getInstance().call(scrollIngameEvent);
        if (!scrollIngameEvent.isCancelled()) {
            var1.changeCurrentItem(var2);
        }
    }
}
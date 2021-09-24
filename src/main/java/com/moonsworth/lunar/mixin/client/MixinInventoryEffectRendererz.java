package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.client.ref.Ref;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.inventory.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(InventoryEffectRenderer.class)
public abstract class MixinInventoryEffectRendererz extends GuiContainer {
    public MixinInventoryEffectRendererz(Container var1) {
        super(var1);
    }

    @Inject(method = "updateActivePotionEffects", at = @At("RETURN"))
    public void impl$updateActivePotionEffects(CallbackInfo var1) {
        if (!Minecraft.getMinecraft().thePlayer.getActivePotionEffects().isEmpty() && !(Boolean) LunarClient.getInstance().lllIIIIIlllIIlIllIIlIIIlI().llllIIlIIlIIlIIllIIlIIllI().lllIIIIIlllIIlIllIIlIIIlI().llIlllIIIllllIIlllIllIIIl()) {
            this.guiLeft -= 60;
        }
    }

    @Inject(method = "drawActivePotionEffects", at = @At("HEAD"), cancellable = true)
    public void impl$drawActivePotionEffects(CallbackInfo var1) {
        if (Ref.getLC().lllllIllIllIllllIlIllllII().IllIllIIIllIIIlIlIlIIIIll().IlllIIIIIIlllIlIIlllIlIIl() && !(Boolean)Ref.getLC().lllllIllIllIllllIlIllllII().IllIllIIIllIIIlIlIlIIIIll().IlIllIIlIIlIIIllIllllIIll().llIlllIIIllllIIlllIllIIIl()) {
            var1.cancel();
        }
    }
}
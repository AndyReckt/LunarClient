package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.LunarClient;
import net.minecraft.client.resources.LanguageManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LanguageManager.class)
public abstract class MixinLanguageManager {
    @Shadow
    private String currentLanguage;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void impl$onConstruct(CallbackInfo var1) {
        handleLanguageUpdate();
    }

    @Inject(method = "setCurrentLanguage", at = @At("RETURN"))
    public void impl$onSetLanguage(CallbackInfo var1) {
        handleLanguageUpdate();
    }

    public void handleLanguageUpdate() {
        if (LunarClient.getInstance() != null && LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI() != null) {
            LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(this.currentLanguage);
        } else {
            LunarClient.LANG = this.currentLanguage;
        }
    }
}

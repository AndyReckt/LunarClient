package com.moonsworth.lunar.mixin.client.resources.I18n;

import com.google.common.collect.ImmutableList;
import com.moonsworth.lunar.LunarClient;
import com.moonsworth.lunar.bridge.minecraft.client.resources.I18n.I18nBridge;
import net.minecraft.client.resources.I18n;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;

/**
 * @author Decencies
 * @since 09/07/2021 23:34
 */
@Mixin(I18n.class)
public abstract class MixinI18n implements I18nBridge {

    @Inject(method = "format", at = @At("HEAD"), cancellable = true)
    private static void onFormat(String translateKey, Object[] parameters, CallbackInfoReturnable<String> cir) {
        Arrays.stream(translateKey.split("\\.")).findFirst().ifPresent(string2 -> {
            String string3 = LunarClient.getInstance().lIlIIlIlllIIlIIIlIlIlIllI().lIlIlIlIlIIlIIlIIllIIIIIl(ImmutableList.of(string2), translateKey, parameters);
            if (!string3.equals(translateKey)) {
                cir.setReturnValue(string3);
            }
        });
    }

    @Override public String getLanguagePath() {
        return null;
    }
}

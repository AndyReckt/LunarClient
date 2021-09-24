package com.moonsworth.lunar.mixin.client;

import com.moonsworth.lunar.bridge.lunar.input.KeyType;
import com.moonsworth.lunar.bridge.minecraft.client.settings.KeyBindingBridge;
import com.moonsworth.lunar.client.bridge.impl.type.keyboard.KeyboardImplementation;
import com.moonsworth.lunar.client.ref.Ref;
import com.moonsworth.lunar.client.setting.BindableSetting;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;

import static net.minecraft.client.settings.KeyBinding.setKeyBindState;

@Mixin(KeyBinding.class)
public abstract class MixinKeyBinding implements KeyBindingBridge {
    @Shadow
    public int keyCode;
    @Final
    @Shadow
    private String keyDescription;
    @Shadow
    private String keyCategory;

    public final List clashesWith = new ArrayList();

    public MixinKeyBinding() {
    }

    @Shadow
    public abstract boolean isKeyDown();

    @Shadow
    public abstract String getKeyCategory();

    public KeyType bridge$getKey() {
        return KeyboardImplementation.lIlIlIlIlIIlIIlIIllIIIIIl(this.keyCode);
    }

    public String bridge$getKeyDescription() {
        return I18n.format(this.keyDescription);
    }

    public void bridge$setKey(KeyType var1) {
        this.keyCode = KeyboardImplementation.llIlllIIIllllIIlllIllIIIl(var1);
    }

    public boolean bridge$isKeyDown() {
        return this.isKeyDown();
    }

    public String bridge$getKeyName() {
        return Keyboard.getKeyName(this.keyCode);
    }

    public void bridge$setKeyBindState(boolean var1) {
        setKeyBindState(this.keyCode, var1);
    }

    @Inject(method = "setKeyCode", at = @At("RETURN"))
    public void impl$onSetKeyCode(int var1, CallbackInfo var2) {
        BindableSetting var3 = BindableSetting.lIlIlIlIlIIlIIlIIllIIIIIl.inverse().get(this);
        if (var3 != null) {
            var3.lIlIlIlIlIIlIIlIIllIIIIIl(KeyboardImplementation.lIlIlIlIlIIlIIlIIllIIIIIl(var1).name());
        }
        Ref.llIlIIIllIIlIllIllIllllIl();
    }

    public List bridge$getClashesWith() {
        return clashesWith;
    }

    public String bridge$getCategory() {
        return getKeyCategory();
    }
}